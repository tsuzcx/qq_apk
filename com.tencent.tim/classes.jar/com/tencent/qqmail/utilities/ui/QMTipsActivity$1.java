package com.tencent.qqmail.utilities.ui;

import com.tencent.qqmail.utilities.observer.ICallBack;

class QMTipsActivity$1
  implements ICallBack
{
  QMTipsActivity$1(QMTipsActivity paramQMTipsActivity) {}
  
  public void callback(Object paramObject)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    paramObject = (QMTipsActivity.QMTipsActivityCommand)paramObject;
    QMTipsActivity.access$000(this.this$0, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMTipsActivity.1
 * JD-Core Version:    0.7.0.1
 */