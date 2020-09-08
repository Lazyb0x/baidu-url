package cn.beanbang.urlpost.service;

import cn.beanbang.urlpost.domain.Sitemap;
import cn.beanbang.urlpost.domain.SubmitConfig;
import cn.beanbang.urlpost.util.SitemapParseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 链接推送服务
 */
@Service
public class PostService {

    @Autowired
    SubmitConfig submitConfig;

    @Autowired
    SitemapParseUtil sitemapParseUtil;

    final Logger log = LoggerFactory.getLogger(getClass());

    static final String POST_URL = "http://data.zz.baidu.com/urls?site={site}&token={token}";

    public String postUrl(String site, String token, Sitemap sitemap) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(POST_URL, sitemap.toString(), String.class, site, token);
        log.info("Submitted {} URLs.", sitemap.size());
        return result;
    }

    public String postUrl() {
        String site = submitConfig.getSite();
        String token = submitConfig.getToken();
        Sitemap sitemap = sitemapParseUtil.getFromUrl(submitConfig.getSitemap());
        return postUrl(site, token, sitemap);
    }
}
