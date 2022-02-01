package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import agey;
import ahap;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
import com.tencent.util.Pair;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class QfileLocalFileDelFileTabView$1
  implements Runnable
{
  QfileLocalFileDelFileTabView$1(QfileLocalFileDelFileTabView paramQfileLocalFileDelFileTabView) {}
  
  public void run()
  {
    if (this.this$0.isRunning) {
      return;
    }
    this.this$0.isRunning = true;
    this.this$0.T.clear();
    this.this$0.U.clear();
    TreeMap localTreeMap = new TreeMap(new agey(this));
    Iterator localIterator = QfileLocalFileDelFileTabView.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      QfileTabBarView.a locala = (QfileTabBarView.a)localIterator.next();
      QfileLocalFileDelFileTabView.a(this.this$0, locala.wd(), locala, this.this$0.AQ, ((Integer)this.this$0.j.second).intValue(), localTreeMap, 1000, null);
    }
    ahap.a(localTreeMap, ((Integer)this.this$0.j.second).intValue(), this.this$0.T, this.this$0.U, this.this$0.AP);
    QfileLocalFileDelFileTabView.a(this.this$0, new QfileLocalFileDelFileTabView.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView.1
 * JD-Core Version:    0.7.0.1
 */