package com.tencent.qqmail.widget;

import com.tencent.qqmail.utilities.log.QMLog;

class QMWidgetDataManager$1$1
  implements Runnable
{
  QMWidgetDataManager$1$1(QMWidgetDataManager.1 param1) {}
  
  public void run()
  {
    QMLog.log(4, "QMWidgetDataManager", "[Method Invoke]QMWidgetDataManager->accountChangeIObserver");
    this.this$1.this$0.accountChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.QMWidgetDataManager.1.1
 * JD-Core Version:    0.7.0.1
 */