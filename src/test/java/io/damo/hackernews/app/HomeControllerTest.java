package io.damo.hackernews.app;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {

    private HackerNewsApi hackerNews = Mockito.mock(HackerNewsApi.class);
    private HomeController controller = new HomeController(hackerNews);

    @Test
    public void testIndex() {
        ModelAndView modelAndView = controller.index();

        assertThat(modelAndView.getViewName(), equalTo("hackernews"));
    }
}
