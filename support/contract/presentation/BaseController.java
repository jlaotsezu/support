package main.support.contract.presentation;

/**
 * Created by thopv on 12/17/2017.
 */

public interface BaseController<T> {
    void setPresenter(T presenter);
}
