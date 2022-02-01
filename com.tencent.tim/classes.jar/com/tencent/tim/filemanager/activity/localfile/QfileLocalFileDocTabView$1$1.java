package com.tencent.tim.filemanager.activity.localfile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileDocTabView$1$1
  implements Runnable
{
  QfileLocalFileDocTabView$1$1(QfileLocalFileDocTabView.1 param1, HashMap paramHashMap) {}
  
  public void run()
  {
    this.a.this$0.R.clear();
    Iterator localIterator = this.kD.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)this.kD.get(str);
      if (localList.size() != 0) {
        this.a.this$0.R.put(str, localList);
      }
    }
    this.a.this$0.refreshUI();
    this.a.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileDocTabView.1.1
 * JD-Core Version:    0.7.0.1
 */