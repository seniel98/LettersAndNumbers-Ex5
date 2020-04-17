package es.ulpgc.eite.cleancode.lettersandnumbers.letters;

import java.util.Random;

public class LetterListModel implements LetterListContract.Model {

    public static String TAG = LetterListModel.class.getSimpleName();

    private String data;

    final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public LetterListModel(String data) {
        this.data = data;
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }

    public void addLetter() {
        Random rnd = new Random();
        char randomChar = alphabet.charAt(rnd.nextInt(alphabet.length()));
        data = String.valueOf(randomChar);
    }
}
