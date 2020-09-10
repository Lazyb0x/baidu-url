package cn.beanbang.urlpost.task;

import cn.beanbang.urlpost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@EnableAsync
public class PostTask {

    private final PostService postService;

    @Autowired
    public PostTask(PostService postService) {
        this.postService = postService;
    }

    @Async
    @Scheduled(cron = "0 */30 * * * *")
    public void postTask() {
        postService.postUrl();
    }
}
