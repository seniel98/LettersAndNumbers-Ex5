package es.ulpgc.eite.cleancode.lettersandnumbers.numbers;

import java.util.Random;

public class NumberListModel implements NumberListContract.Model {

    public static String TAG = NumberListModel.class.getSimpleName();

    private String data;

    public NumberListModel(String data) {
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

    @Override
    public void addNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(51);
        data = String.valueOf(number);
    }
}
