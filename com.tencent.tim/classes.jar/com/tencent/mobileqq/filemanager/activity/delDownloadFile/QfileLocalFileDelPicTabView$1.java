package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import agfa;
import ahap;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class QfileLocalFileDelPicTabView$1
  implements Runnable
{
  QfileLocalFileDelPicTabView$1(QfileLocalFileDelPicTabView paramQfileLocalFileDelPicTabView) {}
  
  public void run()
  {
    if (this.this$0.isRunning) {
      return;
    }
    this.this$0.isRunning = true;
    this.this$0.T.clear();
    TreeMap localTreeMap = new TreeMap(new agfa(this));
    Iterator localIterator = QfileLocalFileDelPicTabView.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      QfileTabBarView.a locala = (QfileTabBarView.a)localIterator.next();
      QfileLocalFileDelPicTabView.a(this.this$0, locala.wd(), locala, this.this$0.AQ, 0, localTreeMap, 1000, null);
    }
    ahap.a(localTreeMap, 0, this.this$0.T, null, this.this$0.AP);
    QfileLocalFileDelPicTabView.a(this.this$0, new QfileLocalFileDelPicTabView.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView.1
 * JD-Core Version:    0.7.0.1
 */