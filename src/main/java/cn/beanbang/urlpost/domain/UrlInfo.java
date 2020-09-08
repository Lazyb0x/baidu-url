package cn.beanbang.urlpost.domain;

/**
 * URL 信息
 */
public class UrlInfo {

    private String location;

    private String lastModified;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "UrlInfo{" +
                "location='" + location + '\'' +
                ", lastModified='" + lastModified + '\'' +
                '}';
    }
}
