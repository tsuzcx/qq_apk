package com.tencent.qqmail.model.task;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMTaskSQLiteHelper$1
  implements Observable.OnSubscribe<Boolean>
{
  QMTaskSQLiteHelper$1(QMTaskSQLiteHelper paramQMTaskSQLiteHelper, QMSendMailTask paramQMSendMailTask) {}
  
  public void call(Subscriber<? super Boolean> paramSubscriber)
  {
    paramSubscriber.onNext(Boolean.valueOf(QMTaskSQLiteHelper.access$000(this.this$0, this.val$task)));
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMTaskSQLiteHelper.1
 * JD-Core Version:    0.7.0.1
 */