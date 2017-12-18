package main.support.contract.domain;

import io.reactivex.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by thopv on 12/17/2017.
 */

/**
 Base cho toàn bộ các Usecase.
 Mỗi Usecase sẽ triển khai lớp này.
 và Implement phương thức executeUsecase() để thực thi usecase.
 * @param <Q>
 * @param <R>
 */
public abstract class UseCase<Q extends UseCase.RequestValues, R extends UseCase.ResponseValues> {
    private Q requestValues;
    private UseCaseCallback<R> callback;
    public void run(){
        executeUseCase(
                checkNotNull(requestValues),
                checkNotNull(callback)
        );
    }
    public void setRequestValues(Q requestValues) {
        this.requestValues = requestValues;
    }

    public void setCallback(UseCaseCallback<R> callback) {
        this.callback = callback;
    }

    protected abstract void executeUseCase(Q requestValues, UseCaseCallback<R> callback);
    public static class RequestValues{

    }
    public static class ResponseValues{

    }
    public interface UseCaseCallback<T extends ResponseValues>{
        void push(Response<T> response);
    }
}
