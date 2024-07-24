package main;
import main.Interface.Impl.NothingOperation;
import main.Operations.*;

import main.StringFunifier.StringFunifier;
import main.Interface.StringOperations;


import java.util.*;
import java.util.concurrent.ExecutionException;


public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {



        String boringString = "ccchHJKkklmlmmml";

        int numOperations = 5;
        List<Integer> startIndexes = new ArrayList<>(Arrays.asList(1, 5, 7, 11, 13));
        List<Integer> endIndexes = new ArrayList<>(Arrays.asList(3, 5, 10, 12, 14));

        List<StringOperations> operations = new ArrayList<>(List.of(
                new LowerCaseOperation(new ReverseOperation(new CompressionOperation(new NothingOperation()))),
                new UpperCaseOperation(new NothingOperation()),
                new SortOperation(new UpperCaseOperation(new CompressionOperation(new NothingOperation()))),
                new CompressionOperation(new NothingOperation()),
                new ReverseOperation(new UpperCaseOperation(new CompressionOperation(new NothingOperation())))
        ));
        for (int i = 0; i < numOperations; i++) {
            List<StringOperations> op = new ArrayList<>();
            for (StringOperations opera : operations) {
                switch (operations.toString()) {
                    case "REVERSE":
                        operations.add(new ReverseOperation(new NothingOperation()));
                        break;
                    case "UPPERCASE":
                        operations.add(new UpperCaseOperation(new NothingOperation()));
                        break;
                    case "LOWERCASE":
                        operations.add(new LowerCaseOperation(new NothingOperation()));
                        break;
                    case "SORT":
                        operations.add(new SortOperation(new NothingOperation()));
                        break;
                    case "COMPRESSION":
                        operations.add(new CompressionOperation(new NothingOperation()));
                        break;
                    default:
                        break;
                }
            }


        }

        StringFunifier funifier = new StringFunifier(boringString, startIndexes, endIndexes, operations);


        long startTimeTotal = System.currentTimeMillis();

        String funnyString = funifier.getFunnyString();


        long endTimeTotal = System.currentTimeMillis();
        long totalExecutionTime = endTimeTotal - startTimeTotal;

        System.out.println("Funny String: " + funnyString);

        System.out.println("Total Execution Time: " + totalExecutionTime + " milliseconds");
    }
}
