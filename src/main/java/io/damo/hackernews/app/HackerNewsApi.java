package io.damo.hackernews.app;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpMethod.GET;

@Component
public class HackerNewsApi {

    private final RestOperations restOperations = new RestTemplate();
    private final ParameterizedTypeReference<List<Long>> idsTypeReference = new ParameterizedTypeReference<List<Long>>() {
    };


    public List<NewsItem> topTenStories() {
        ResponseEntity<List<Long>> topIdsResponseEntity = restOperations.exchange(
            "https://hacker-news.firebaseio.com/v0/topstories.json",
            GET, null, idsTypeReference);

        List<Long> topIds = topIdsResponseEntity.getBody();

        return topIds
            .stream()
            .limit(10)
            .map(this::fetchNewsItem)
            .collect(toList());
    }

    private NewsItem fetchNewsItem(Long newsItemId) {
        String itemUrl = format("https://hacker-news.firebaseio.com/v0/item/%d.json", newsItemId);
        return restOperations.getForObject(itemUrl, NewsItem.class);
    }
}




