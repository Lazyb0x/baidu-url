package cn.beanbang.urlpost.util;

import cn.beanbang.urlpost.domain.Sitemap;
import cn.beanbang.urlpost.domain.UrlInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component
public class SitemapParseUtil {

    private Document doc;

    final Logger log = LoggerFactory.getLogger(getClass());

    private String getSiteMap(String url) {
        log.info("Getting sitemap from '{}'.", url);
        RestTemplate template = new RestTemplate();
        return template.getForObject(url, String.class);
    }

    public Sitemap getFromUrl(String url) {

        Sitemap sitemap = new Sitemap();
        String sitemapString = this.getSiteMap(url);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new ByteArrayInputStream(sitemapString.getBytes()));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        NodeList list = doc.getElementsByTagName("url");
        for (int i=0; i<list.getLength(); i++) {
            Element e = (Element)list.item(i);
            String loc = getTextValue(e, "loc");
            String lastmod = getTextValue(e, "lastmod");

            UrlInfo urlInfo = new UrlInfo();
            urlInfo.setLocation(loc);
            urlInfo.setLastModified(lastmod);

            sitemap.add(urlInfo);
        }

        return sitemap;
    }

    /**
     * 从元素节点里面找到对应标签名的值
     * @param e 被找的元素
     * @param name 被找的标签名
     * @return 标签的文本内容
     */
    private String getTextValue(Element e, String name){
        NodeList nodes = e.getElementsByTagName(name);
        if (nodes.getLength()!=0){
            return nodes.item(0).getFirstChild().getNodeValue();
        }
        else {
            return "";
        }
    }
}
