package main.support.contract.domain;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by jlaotsezu on 17/12/2017.
 */

public class UseCaseThreadPoolScheduler implements UseCaseRunner.UseCaseScheduler {
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private static final int SIZE = 2;
    private static final int MAX_SIZE = 4;
    private static final int TIMEOUT = 30;

    private ThreadPoolExecutor mExecutor;

    public UseCaseThreadPoolScheduler(){
        mExecutor  = new ThreadPoolExecutor(SIZE, MAX_SIZE, TIMEOUT, SECONDS, new ArrayBlockingQueue<>(SIZE));
    }

    @Override
    public void runOnThreadPool(Runnable runnable) {
        mExecutor.execute(runnable);
    }

    @Override
    public void runOnUI(Runnable runnable) {
        mHandler.post(runnable);
    }
}
