package com.tencent.qqmail.uma;

import android.util.Log;
import rx.Observable;
import rx.functions.Func1;

class QMUmaManager$49
  implements Func1<byte[], Observable<? extends QMUmaManager.QMUmaResult>>
{
  QMUmaManager$49(QMUmaManager paramQMUmaManager, QMUmaManager.QMUmaSession paramQMUmaSession) {}
  
  public Observable<? extends QMUmaManager.QMUmaResult> call(byte[] paramArrayOfByte)
  {
    Log.v("terrytan", QMUmaManager.access$200(this.this$0) + "uma end");
    return Observable.just(new QMUmaManager.QMUmaResult(this.this$0, this.val$session, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.49
 * JD-Core Version:    0.7.0.1
 */