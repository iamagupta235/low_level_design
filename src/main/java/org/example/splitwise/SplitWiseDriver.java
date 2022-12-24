package org.example.splitwise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SplitWiseDriver {

    float[][] balances;
    User user;
    List<User> users = new ArrayList<>();
    HashMap<String, Integer> userMap;
    HashMap<Integer, String> userInverseMap;

    public void drive(String file){
        System.out.println("\n\n");
        System.out.println(" xxxxxx-----xxxxx ----- xxxxx -----xxxxx ----------xxxxx");
        System.out.println();
        System.out.println("\t\t\t\t DRIVER FOR SPLIT-WISE");
        System.out.println("\t\t\t\t\t\t\t\t - System designed by Abhishek Kumar Gupta");

        addUsers();
        initBalance();
        createHash();
        Scanner scanner ;
        try {
            scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] inputArr = line.split(" ");
                String input = inputArr[0];
                switch (input) {
                    case "SHOW" -> {
                        if (inputArr.length == 1) {
                            showAllBalances();
                        } else {
                            showBalanceofUser(inputArr[1]);
                        }
                    }
                    case "EXPENSE" -> addExpenses(inputArr);
                    default -> throw new RuntimeException("Invalid Input");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void createHash() {
        userMap = new HashMap<>();
        userInverseMap = new HashMap<>();
        for (User user1 : users){
            userMap.put(user1.name, user1.userId);
            userInverseMap.put(user1.userId, user1.expandedName);
        }
    }

    private void initBalance() {
        balances = new float[users.size()][users.size()];
    }

    private void addUsers() {
        user = new User("u1", "abhishek.email@gmail.com", "+91-9990212922");
        users.add(user);
        user = new User("u2", "kumar.email@gmail.com", "+91-89765899876");
        users.add(user);
        user = new User("u3", "gupta.email@gmail.com", "+91-8976589087");
        users.add(user);
        user = new User("u4", "saurav.email@gmail.com", "+91-8976589087");
        users.add(user);
    }

    private void addExpenses(String[] inputArr) {
        int index = 1;
        String lender = inputArr[index++];
        float amount = Float.parseFloat(inputArr[index++]);
        int noOfPeople = Integer.parseInt(inputArr[index++]);
        List<String> borrowers = new ArrayList<>(noOfPeople);
        for (int i = 0; i < noOfPeople; i++) {
            borrowers.add(inputArr[index++]);
        }
        String borrowType = inputArr[index++];
        float[] eachBorrowed = new float[noOfPeople];
        switch (borrowType) {
            case "EQUAL" -> {
                float eachBorrowerAmount = amount / noOfPeople;
                Arrays.fill(eachBorrowed, eachBorrowerAmount);
            }
            case "EXACT" -> {
                for (int i = 0; i < noOfPeople; i++) {
                    eachBorrowed[i] = Float.parseFloat(inputArr[index++]);
                }
            }
            case "PERCENT" -> {
                for (int i = 0; i < noOfPeople; i++) {
                    eachBorrowed[i] = Float.parseFloat(inputArr[index++]) * amount / 100;
                }
            }
        }
        lendMoney(userMap.get(lender), borrowers, eachBorrowed);
    }

    private void lendMoney(int lender, List<String> borrowers, float[] eachBorrowed) {
        int index = 0;
        for (String borrower : borrowers){
            int borrowerId = userMap.get(borrower);
            float borrowAmount = eachBorrowed[index++];
            balances[lender][borrowerId] += borrowAmount;
            balances[borrowerId][lender] -= borrowAmount;
        }
    }

    private void showBalanceofUser(String userName) {
        System.out.println("\nUser balance : " + userInverseMap.get(userMap.get(userName)));
        System.out.println();
        int i = userMap.get(userName);
        boolean noBalance = true;
        for (int j = 0; j < balances.length; j++) {
            float money = balances[j][i];
            if (money == 0f)
                continue;
            if (money > 0) {
                noBalance = false;
                display(j, i, money);
            }
            else{
                noBalance = false;
                display(i, j, -money);
            }
        }
        if (noBalance)
            System.out.println("No Balances");
    }
    private void display(int borrowerIndex, int lenderIndex, float amount){
        System.out.println(userInverseMap.get(borrowerIndex) + " owes " + userInverseMap.get(lenderIndex) + " : " + amount);
    }

    private void showAllBalances() {
        System.out.println("\nAll balances\n");
        boolean noBalance = true;
        for (int j = 0; j < balances.length; j++) {
            for (int i = 0; i < balances.length; i++) {
                float money = balances[i][j];
                if (money > 0) {
                    noBalance = false;
                    display(j, i, money);
                }
            }
        }
        if (noBalance)
            System.out.println("No Balances");
    }
}
