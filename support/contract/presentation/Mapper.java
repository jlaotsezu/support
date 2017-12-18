package main.support.contract.presentation;

/**
 * Created by jlaotsezu on 18/12/2017.
 */

public interface Mapper<FROM, TO> {
    TO map(FROM from);
}
