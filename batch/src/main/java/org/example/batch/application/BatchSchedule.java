package org.example.batch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BatchSchedule {
    private final BatchFacade batchFacade;

    @Scheduled(cron = "0 59 23 * * *")
    public void updateAllMember() {
        batchFacade.updateAllMembers();
    }
}
