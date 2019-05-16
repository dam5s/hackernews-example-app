package io.damo.hackernews.app;

import java.util.Objects;

public class NewsItem {
    private final String title;
    private final String url;

    public NewsItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    private NewsItem() {
        this("", "");
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsItem newsItem = (NewsItem) o;
        return Objects.equals(title, newsItem.title) &&
            Objects.equals(url, newsItem.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url);
    }

    @Override
    public String toString() {
        return "NewsItem{" +
            "title='" + title + '\'' +
            ", url='" + url + '\'' +
            '}';
    }
}
