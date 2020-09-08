package cn.beanbang.urlpost.service;

import cn.beanbang.urlpost.domain.Sitemap;
import cn.beanbang.urlpost.util.SitemapParseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Autowired
    SitemapParseUtil sitemapParseUtil;

    @Test
    void postUrl() {
        Sitemap sitemap = sitemapParseUtil.getFromUrl("https://blog.beanbang.cn/sitemap.xml");
        String site = "https://blog.beanbang.cn";
        String token = "fl0YRc6Zi477UDAJ";
        String s = postService.postUrl(site, token, sitemap);
        System.out.println(s);
    }

}