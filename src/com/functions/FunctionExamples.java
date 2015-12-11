package com.functions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FunctionExamples {


    public static void main(String[] args) {
        //supplier
        List<ValmisMuna> munad = new ArrayList<>();
        munad.stream().collect(Collectors.toCollection(() -> new TreeSet<>()));
        munad.stream().collect(Collectors.toCollection(LinkedList::new));

        // java 7
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task #1 is running");
            }
        };
        new Thread(task).start();

        // Lambda Runnable
        Runnable task2 = () -> System.out.println("Task #2 is running");
        new Thread(task2).start();


        munad.forEach(new Consumer<ValmisMuna>() {
            @Override
            public void accept(ValmisMuna valmisMuna) {
                valmisMuna.incrementEnergia(20);
            }
        });
        munad.forEach(m -> m.incrementEnergia(20));

        List<TooresMuna> tooredMunad = new ArrayList<>();
        tooredMunad.stream().map(tm-> Main.prae(tm)).collect(Collectors.toList());
        tooredMunad.stream().map(Main::keeda).collect(Collectors.toList());
    }
}
