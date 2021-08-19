package ru.diasoft.study_tasks.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Aspect
public class ControollerAspect {

    private static Logger logger = LogManager.getLogger(ControollerAspect.class);


    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object methodName(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature methodSignature = joinPoint.getSignature();
        String methodParams = Arrays.toString(joinPoint.getArgs());

        logger.info("methodSignature: {}", methodSignature);
        logger.info("Params for method: {}", methodParams);
        Object proceed = joinPoint.proceed();
        logger.info("Result: {}", proceed.toString());
        return proceed;
    }
}
