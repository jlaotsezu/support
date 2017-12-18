package main.support.contract.domain;

/**
 * Created by thopv on 12/17/2017.
 */

public interface Filter<T> {
    boolean filter(T t);
}
