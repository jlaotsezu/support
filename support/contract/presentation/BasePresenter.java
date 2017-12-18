package main.support.contract.presentation;

/**
 * Created by thopv on 12/17/2017.
 */

/**
 * Active và disable làm manh mối cho Presenter
 * về vòng đời của Controller.
 */
public interface BasePresenter {
    void active();
    void disable();
}
