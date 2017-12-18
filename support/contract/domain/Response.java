package main.support.contract.domain;

/**
 * Created by thopv on 12/17/2017.
 */

/**
 * Communate between Usecases and Presenters.
 */
public class Response<T> {
    private boolean success;
    private String message;

    private T payload;

    private Response(boolean success, String message, T payload) {
        this.success = success;
        this.message = message;
        this.payload = payload;
    }

    public static <T> Response<T> fail(String message){
        return new Response<>(false, message, null);
    }
    public static <T> Response<T> success(T payload){
        return new Response<>(true, "success", payload);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getPayload() {
        return payload;
    }
}
