package es.ulpgc.eite.cleancode.lettersandnumbers.numbers;

import java.util.List;

import es.ulpgc.eite.cleancode.lettersandnumbers.data.LetterData;
import es.ulpgc.eite.cleancode.lettersandnumbers.data.NumberData;

public class NumberListModel implements NumberListContract.Model {

    public static String TAG = NumberListModel.class.getSimpleName();

    private String data;

    private LetterData letterData;

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
    public void onDataFromPreviousScreen(LetterData letterData) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
        this.letterData = letterData;

    }

    @Override
    public List<NumberData> addNumber() {
        NumberData numberData = new NumberData();
        if (data.equals("")) {
            data = String.valueOf(1);
            numberData.number = 1;
            letterData.numbers.add(numberData);
        } else {
            int number = Integer.parseInt(data);
            number++;
            numberData.number = number;
            data = String.valueOf(number);
            letterData.numbers.add(numberData);
        }

        return letterData.numbers;


    }
}
