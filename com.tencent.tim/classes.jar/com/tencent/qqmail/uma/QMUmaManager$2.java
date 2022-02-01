package com.tencent.qqmail.uma;

import com.tencent.qqmail.protocol.OnProtocolListener;
import rx.functions.Action1;

class QMUmaManager$2
  implements Action1<Throwable>
{
  QMUmaManager$2(QMUmaManager paramQMUmaManager) {}
  
  public void call(Throwable paramThrowable)
  {
    if (((paramThrowable instanceof QMUmaManager.QMPUmaException)) && (((QMUmaManager.QMPUmaException)paramThrowable).retCode == -10024) && (QMUmaManager.access$000(this.this$0) != null)) {
      QMUmaManager.access$000(this.this$0).OnCloudProtocolLogin(new QMUmaManager.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.2
 * JD-Core Version:    0.7.0.1
 */