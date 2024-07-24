package main.StringFunifier;
import main.Interface.StringOperations;
import main.Interface.Impl.*;

import java.util.List;
import java.util.concurrent.*;
import java.util.ArrayList;

public class StringFunifier {

    private String boringString;
    private List<Integer> startIndexes;
    private List<Integer> endIndexes;
    private List<StringOperations> funOperations;

    public StringFunifier(String boringString, List<Integer> startIndexes, List<Integer> endIndexes, List<StringOperations> funOperations) {
        this.boringString = boringString;
        this.startIndexes = startIndexes;
        this.endIndexes = endIndexes;
        this.funOperations = funOperations;
    }

    public String getFunnyString() throws InterruptedException, ExecutionException {
        StringBuilder result = new StringBuilder();
        int current = 0;

        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < startIndexes.size(); i++) {
            int start = startIndexes.get(i);
            int end = endIndexes.get(i);
            StringOperations operation = funOperations.get(i);

            futures.add(executor.submit(() -> {
                StringBuilder builder = new StringBuilder(boringString.substring(start, end + 1));
                return operation.apply(String.valueOf(builder));
            }));

        }

        for (int i = 0; i < startIndexes.size(); i++) {
            int start = startIndexes.get(i);
            int end = endIndexes.get(i);
            String funSubString = futures.get(i).get();

            result.append(boringString, current, start);
            result.append("(").append(funSubString).append(")");
            current = end + 1;
        }

        executor.shutdown();
        return result.toString();
    }

}

