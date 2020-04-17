package es.ulpgc.eite.cleancode.lettersandnumbers.letters;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.lettersandnumbers.app.LettersToNumbersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.app.NumbersToLettersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.data.LetterData;

public class LetterListPresenter implements LetterListContract.Presenter {

    public static String TAG = LetterListPresenter.class.getSimpleName();

    private WeakReference<LetterListContract.View> view;
    private LetterListState state;
    private LetterListContract.Model model;
    private LetterListContract.Router router;

    public LetterListPresenter(LetterListState state) {
        this.state = state;
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new LetterListState();
        }

    /*
    // use passed state if is necessary
    LetterListState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.data);
    }
    */

    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary
        NumbersToLettersState savedState = router.getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);
        }


        // call the model and update the state
        state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

    @Override
    public void onClickLetterListCell(LetterData data) {
        // Log.e(TAG, "onClickLetterListCell()");
        LettersToNumbersState lettersToNumbersState = new LettersToNumbersState();
        lettersToNumbersState.letterData = data;
        router.passStateToNextScreen(lettersToNumbersState);
        router.navigateToNextScreen();

    }

    @Override
    public void onClickLetterListButton() {
        // Log.e(TAG, "onClickLetterListButton()");
        model.addLetter();
        LetterData letterData = new LetterData();
        letterData.letter = model.getStoredData();
        state.letterData = letterData;
        state.datasource.add(state.letterData);
        view.get().onDataUpdated(state);
    }

    @Override
    public void injectView(WeakReference<LetterListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(LetterListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(LetterListContract.Router router) {
        this.router = router;
    }
}
