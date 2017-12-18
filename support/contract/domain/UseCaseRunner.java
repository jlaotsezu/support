package main.support.contract.domain;

/**
 * Created by thopv on 12/17/2017.
 */

/**
 * Chuyên dùng để thực thi các usecase
 */
public class UseCaseRunner {
    private static UseCaseRunner instance;

    public static UseCaseRunner getInstance() {
        if(instance == null)
            instance = new UseCaseRunner();
        return instance;
    }

    private UseCaseScheduler mUseCaseScheduler;
    private UseCaseRunner(){
        mUseCaseScheduler = new UseCaseThreadPoolScheduler();
    }
    public <Q extends UseCase.RequestValues, R extends UseCase.ResponseValues> void execute(UseCase<Q, R> useCase, Q requestValues, UseCase.UseCaseCallback<R> callback){
        useCase.setRequestValues(requestValues);
        useCase.setCallback(response -> {
            mUseCaseScheduler.runOnUI(() -> {
                callback.push(response);
            });
        });
        mUseCaseScheduler.runOnThreadPool(useCase::run);
    }

    /**
     * Scheduler thực thi các Usecase, được sử dụng bởi UseCaseRunner
     * hỗ trợ trong việc thực thi các Usecase
     *
     * với trách nhiệm tạo, quản lý các luồng, đưa usecase xuống luồng
     * để thực thi và sau đó đưa về luồng ui để trả về presenter.
     */
    public interface UseCaseScheduler{
        void runOnThreadPool(Runnable runnable);
        void runOnUI(Runnable runnable);
    }
}
