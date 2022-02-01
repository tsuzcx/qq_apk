package com.tencent.tim.filemanager.activity.delDownloadFile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileDelPicTabView$1$1
  implements Runnable
{
  QfileLocalFileDelPicTabView$1$1(QfileLocalFileDelPicTabView.1 param1, HashMap paramHashMap) {}
  
  public void run()
  {
    QfileLocalFileDelPicTabView.a(this.a.this$0).clear();
    Iterator localIterator = this.kD.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)this.kD.get(str);
      if (localList.size() != 0) {
        QfileLocalFileDelPicTabView.b(this.a.this$0).put(str, localList);
      }
    }
    this.a.this$0.refreshUI();
    this.a.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView.1.1
 * JD-Core Version:    0.7.0.1
 */