package com.tencent.tim.filemanager.activity.delDownloadFile;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileDelAppTabView$1$1
  implements Runnable
{
  QfileLocalFileDelAppTabView$1$1(QfileLocalFileDelAppTabView.1 param1) {}
  
  public void run()
  {
    if (QfileLocalFileDelAppTabView.a(this.a.this$0) != null)
    {
      Iterator localIterator = QfileLocalFileDelAppTabView.b(this.a.this$0).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)QfileLocalFileDelAppTabView.c(this.a.this$0).get(str)).size() == 0) {
          localIterator.remove();
        }
      }
    }
    QfileLocalFileDelAppTabView.e(this.a.this$0).putAll(QfileLocalFileDelAppTabView.d(this.a.this$0));
    this.a.this$0.refreshUI();
    this.a.this$0.setSelect(0);
    QfileLocalFileDelAppTabView.f(this.a.this$0).clear();
    this.a.this$0.IU(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */