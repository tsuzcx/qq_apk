package com.tencent.qqmail.widget;

import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.thread.Threads;

class QMWidgetDataManager$1
  implements ICallBack
{
  QMWidgetDataManager$1(QMWidgetDataManager paramQMWidgetDataManager) {}
  
  public void callback(Object paramObject)
  {
    Threads.runOnMainThread(new QMWidgetDataManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.QMWidgetDataManager.1
 * JD-Core Version:    0.7.0.1
 */