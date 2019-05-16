package io.damo.hackernews.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final HackerNewsApi hackerNewsApi;

    public HomeController(HackerNewsApi hackerNewsApi) {
        this.hackerNewsApi = hackerNewsApi;
    }

    @GetMapping("/")
    public ModelAndView index() {
        List<NewsItem> newsItems = hackerNewsApi.topTenStories();

        ModelAndView modelAndView = new ModelAndView("hackernews");
        modelAndView.getModel().put("newsItems", newsItems);
        return modelAndView;
    }
}
