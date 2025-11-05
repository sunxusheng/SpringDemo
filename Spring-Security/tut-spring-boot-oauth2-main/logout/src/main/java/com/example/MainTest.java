package com.example;

public class MainTest {
    public static final String NON_ALPHA_NUMERIC_REGEXP = "[^a-zA-Z0-9]";
    public static void main(String[] args) {



        String[] record = "2UU-12345-1-0       ,                    ,Symbol001                                          ,CUSIP0001,        10.0000,                                                  ,                                                  ,                                                  ,                    ,Security 001          ,IGNORE".split(",");
        String type = "P";

        String accountId = "";
        String acctId = "";
        if (record != null) {
            if ("P".equals(type)) {
                accountId = record[0].trim();
            }
            acctId = normalizeAccountId(accountId);
        }


        System.out.println(acctId);
    }

    public static String normalizeAccountId(String accountID) {
        // This line replaces all non-aplhanumeric characters with blank string, removing them from the string
        String normalized = accountID.replaceAll(NON_ALPHA_NUMERIC_REGEXP, "");
        // uppercase it
        return normalized.toUpperCase();
    }

}
