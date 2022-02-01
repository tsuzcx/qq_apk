package com.tencent.qqmail.uma;

import android.util.Log;
import rx.functions.Action1;

class QMUmaManager$47
  implements Action1<Throwable>
{
  QMUmaManager$47(QMUmaManager paramQMUmaManager) {}
  
  public void call(Throwable paramThrowable)
  {
    Log.i("QMUmaManager", "Gloable doOnError " + paramThrowable.getStackTrace());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.47
 * JD-Core Version:    0.7.0.1
 */