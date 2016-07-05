package com.company;

import java.sql.*;

public class AI {

    private String sentence;

    private boolean question;

    private String[] questionsLevel1;
    private String[] questionsLevel2;
    private String[] questionsLevel3;

    private TextUtils utils;

    public AI(String sentence) {
        this.sentence = sentence;

        this.questionsLevel1 = new String[]{"how", "which", "where", "why", "when", "what"};
        this.questionsLevel2 = new String[]{"will", "did", "do", "are", "was", "were", "is", "have", "would", "could", "should"};
        this.questionsLevel3 = new String[]{"it", "she", "he", "they", "you", "we"};

        this.utils = new TextUtils( sentence );

        System.out.println("determineSentenceType = " + determineSentenceType());
        Sql sql = new Sql("entries", "root", "uupkvjnus123");
        sql.connect();
        ResultSet data = sql.Execute("SELECT * FROM `entries` WHERE  `word` LIKE  'wolf' LIMIT 30");

        sql.printData("data =", data, "definition");

        sql.closeConnection();

    }

    public String determineSentenceType() {

        //level1 + level2 + level3
        for(int i = 0; i < this.questionsLevel1.length; i++) {

            if( this.utils.getFirstWord().equals(this.questionsLevel1[i]) ) {

                for(int j = 0; j < questionsLevel2.length; j++) {

                    if( this.utils.contains( questionsLevel2[j] ) ) {

                        for( int k = 0; k < questionsLevel3.length; k++ ) {

                            if( this.utils.contains( questionsLevel3[k] ) ) {

                                return (this.utils.checkIfWordComesBeforeWord(questionsLevel2[j], questionsLevel3[k])) ? "question" : "!!!";
                            }
                        }

                    }
                }

            }
        }

        //level 2 + level 3
        for(int i = 0; i < questionsLevel2.length; i++) {

            if( this.utils.getFirstWord().equals(this.questionsLevel2[i]) ) {
                for (int j = 0; j < questionsLevel3.length; j++) {

                    if (this.utils.checkIfWordComesBeforeWord(questionsLevel2[i], questionsLevel3[j])) {

                        return "question";
                    } else if (this.utils.contains(questionsLevel2[i]) && !this.utils.contains(questionsLevel3[j])) {

                        return "question";
                    }

                    //return ( this.utils.checkIfWordComesBeforeWord(questionsLevel2[i], questionsLevel3[j]) ) ? "question" : "!!!";
                }
            }
        }

        return "!!!";
    }
}
