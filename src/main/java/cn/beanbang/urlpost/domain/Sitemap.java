package cn.beanbang.urlpost.domain;

import java.util.HashSet;
import java.util.Objects;

/**
 * 站点地图
 * 用在提交连接时转换成字符串
 */
public class Sitemap extends HashSet<UrlInfo> {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.forEach(urlInfo -> sb.append(urlInfo.getLocation()).append('\n'));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sitemap)) return false;
        if (!super.equals(o)) return false;
        Sitemap sitemap = (Sitemap) o;
        return Objects.equals(getUrl(), sitemap.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUrl());
    }
}
