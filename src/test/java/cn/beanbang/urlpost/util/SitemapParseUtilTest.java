package cn.beanbang.urlpost.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SitemapParseUtilTest {

    @Autowired
    SitemapParseUtil sitemapUtil;

    @Test
    void getFromUrl() {
        String url = "https://blog.beanbang.cn/sitemap.xml";
        var sitemap = sitemapUtil.getFromUrl(url);
        System.out.println(sitemap.size());
        System.out.println(sitemap);
        assertNotNull(sitemap);
    }

    @Test
    void hello() {
        System.out.println("Hello");
        assert true;
    }
}