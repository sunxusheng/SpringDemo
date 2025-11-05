package org.example.springdemo;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DemoController {


    @Autowired
    private PlatformTransactionManager transactionManager;

    @GetMapping("/deliverUserSelfDeliverySurveysToCertainUser")
    @Transactional
    public String deliverUserSelfDeliverySurveysToCertainUser() {


        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try{
            TransactionSynchronizationManager.registerSynchronization(
                    new UncEventSynchronization()
            );

            System.out.println("Before commit");
            transactionManager.commit(status);

            System.out.println("after commit");
        } catch (Exception e) {
            transactionManager.rollback(status);
        }


        System.out.println("complete commit");

        return "Hello World";
    }


    @GetMapping("/getOutstandingPortfolioActions")
    public String getOutstandingPortfolioActions() {

        UserSubmittedQuestionnaire userSubmittedQuestionnaire = new UserSubmittedQuestionnaire();
        userSubmittedQuestionnaire.setUserSubmittedId(List.of(Thread.currentThread().getName()));
        String json = JSON.toJSONString(userSubmittedQuestionnaire);
        return json;
    }

    @GetMapping("/getUserSubmittedSurvey")
    public String getUserSubmittedSurvey(@RequestParam("userSubmittedId") String userSubmittedId) {

        System.out.println(userSubmittedId);
        return userSubmittedId;
    }

}
