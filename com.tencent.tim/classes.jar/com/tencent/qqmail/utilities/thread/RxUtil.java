package com.tencent.qqmail.utilities.thread;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.android.schedulers.AndroidSchedulers;

public class RxUtil
{
  public static <T> Observable<T> runInBackgroundThenBackToCallerThread(Observable.OnSubscribe<T> paramOnSubscribe)
  {
    boolean bool = Threads.isOnMainThread();
    Observable localObservable = Observable.create(paramOnSubscribe).subscribeOn(QMSchedulers.background());
    if (bool) {}
    for (paramOnSubscribe = AndroidSchedulers.mainThread();; paramOnSubscribe = QMSchedulers.background()) {
      return localObservable.observeOn(paramOnSubscribe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.thread.RxUtil
 * JD-Core Version:    0.7.0.1
 */