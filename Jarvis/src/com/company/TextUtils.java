package com.company;

public class TextUtils {

    private String sentence;

    public TextUtils() {
        this.sentence = "";
    }

    public TextUtils(String senetence) {
        this.sentence = senetence.toLowerCase();
        System.out.println(this.sentence);
    }

    public void updateString(String str) {
        this.sentence = str.toLowerCase();
    }

    public int charAtIndex(int index) {
        return this.sentence.charAt(index);
    }

    public int getLength() {
       return this.sentence.length();
    }

    public boolean contains(String str) {
        String word = str.toLowerCase();
        int indexOfWord = this.sentence.indexOf(word);
        int lastIndexOfWord;
        if( indexOfWord > -1 ) {
            lastIndexOfWord = indexOfWord + (str.length()-1);

            if(indexOfWord == 0 || charAtIndex(indexOfWord-1) == ' ') {

                if( lastIndexOfWord == getLength()-1 ) {

                    return true;
                }
                else if ( charAtIndex(lastIndexOfWord+1) == ' ' ||
                        charAtIndex(lastIndexOfWord+1) == '?' ||
                        charAtIndex(lastIndexOfWord+1) == '.' ||
                        charAtIndex(lastIndexOfWord+1) == ',') {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkIfWordComesBeforeWord(String str1, String str2) {

        int indexstr1 = indexOf( str1 );
        int indexstr2 = indexOf( str2 );

        if( (indexstr1 > -1) && (indexstr2 > -1) && (indexstr1 < indexstr2) ) {

            return true;
        }
        else {

            return false;
        }
    }

    public String getFirstWord() {

        if(this.sentence.indexOf(' ') == -1) {
            return this.sentence;
        }

        return this.sentence.substring( 0, this.sentence.indexOf(' ') );
    }

    public int indexOf(String str) {
        String word = str.toLowerCase();
        int indexOfWord = this.sentence.indexOf(word);
        int lastIndexOfWord;
        if( indexOfWord > -1 ) {
            lastIndexOfWord = indexOfWord + (str.length()-1);

            if(indexOfWord == 0 || charAtIndex(indexOfWord-1) == ' ') {

                if( lastIndexOfWord == getLength()-1 ) {

                    return indexOfWord;
                }
                else if ( charAtIndex(lastIndexOfWord+1) == ' ' ||
                        charAtIndex(lastIndexOfWord+1) == '?' ||
                        charAtIndex(lastIndexOfWord+1) == '.' ||
                        charAtIndex(lastIndexOfWord+1) == ',') {

                    return indexOfWord;
                }
            }
        }

        return -1;
    }
}