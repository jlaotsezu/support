package main.support.contract.data.source;

import android.support.annotation.NonNull;

import com.thopv.projects.jmiu.support.contract.domain.Criteria;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Created by thopv on 12/17/2017.
 */

public interface Repository<IDENTIFY, ENTITY> {
    Flowable<ENTITY> fetchAll();
    Maybe<ENTITY> fetchById(@NonNull IDENTIFY id);
    Flowable<ENTITY> fetchByCriteria(@NonNull Criteria criteria);

    Completable save(@NonNull List<ENTITY> entities);
    Completable remove(@NonNull List<IDENTIFY> ids);

    void refresh();
}
