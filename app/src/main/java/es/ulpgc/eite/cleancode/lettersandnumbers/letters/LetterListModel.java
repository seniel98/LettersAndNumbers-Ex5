package es.ulpgc.eite.cleancode.lettersandnumbers.letters;

public class LetterListModel implements LetterListContract.Model {

    public static String TAG = LetterListModel.class.getSimpleName();

    private String data;

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
        switch (data) {
            case "":
                data = "A";
                break;
            case "A":
                data = "B";
                break;
            case "B":
                data = "C";
                break;
            default:
                data = "D";
                break;
        }
    }
}
