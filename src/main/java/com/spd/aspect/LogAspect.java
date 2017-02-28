package com.spd.aspect;


import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;
import java.util.Set;

@Aspect
public class LogAspect {
    private static final Gson GSON = new Gson();


    @Pointcut("execution(* *(..)) && within(com.spd.service.impl.*) ")
    private void allMethods() {
    }

    @Around("allMethods()")
    public Object watchTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        System.out.println("Method begin " + joinPoint.getSignature().toShortString());
        Object output = null;

        for (Object object : joinPoint.getArgs()) {
            System.out.println("Param " + object);
        }
        try {
            output = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("Method end " + joinPoint.getSignature().toShortString() + ", time=" + time + " ms <<");

        return output;
    }

    @AfterReturning(pointcut = "allMethods()", returning = "obj")
    public void print(Object obj) {
        System.out.println("Print info begin >>");

        if (obj instanceof Set) {

            Set set = (Set) obj;

            for (Object object : set) {
                System.out.println(object);
            }
        } else if (obj instanceof Map) {

            Map map = (Map) obj;

            for (Object object : map.keySet()) {
                System.out.println("key= " + object + ", " + map.get(object));
            }
        }
        System.out.println("Print info end >>");
        System.out.println();
    }

    @Around("execution(* com.spd.service..*(..))")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        log(methodName + " - arguments {" + GSON.toJson(args) + "}");

        Object result;
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable t) {
            log(methodName + " - failed with " + t.getMessage());
            throw t;
        }
        log(methodName + " - result {" + GSON.toJson(result) + "}");

        return result;
    }
    private void log(String message) {
        System.out.println(message);
    }
}
