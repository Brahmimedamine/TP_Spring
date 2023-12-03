package com.example.project.Configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AjoutAspet {
    @Before("execution(* com.example.project.Service.EtudiantService.addEtudiant(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @AfterReturning("execution(* com.example.project.Service.EtudiantService.addEtudiant(..))")
    public void logMethodEntryReturning(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In running " + name + " : ");
    }

    @AfterThrowing("execution(* com.example.project.Service.EtudiantService.addEtudiant(..))")
    public void logMethodEntryThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In throwing " + name + " : ");
    }
    @After("execution(* com.example.project.Service.EtudiantService.addEtudiant(..))")
    public void logMethodEntryExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("after Exec " + name + " : ");
    }
}
