package com.tencent.qqmail.uma;

import android.util.Log;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.utilities.stringextention.Hex;
import rx.Observable;
import rx.functions.Func0;

class QMUmaManager$54
  implements Func0<Observable<QMUmaManager.QMUmaSession>>
{
  QMUmaManager$54(QMUmaManager paramQMUmaManager, QMUmaManager.QMUmaSession paramQMUmaSession) {}
  
  public Observable call()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(QMUmaManager.access$200(this.this$0)).append("uma prepareSessionRequst defer sessionKey:");
    if (QMUmaManager.access$100(this.this$0) == null) {}
    for (String str = "null";; str = String.valueOf(Hex.encodeHex(QMUmaManager.access$100(this.this$0))))
    {
      Log.d("terrytan", str);
      if (QMUmaManager.access$100(this.this$0) == null) {
        break;
      }
      return Observable.just(QMUmaManager.access$1200(this.this$0, this.val$session));
    }
    return QMUmaManager.access$400(this.this$0, CloudProtocolHelper.getCommonInfo(), new QMUmaManager.54.2(this)).concatMap(new QMUmaManager.54.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.54
 * JD-Core Version:    0.7.0.1
 */