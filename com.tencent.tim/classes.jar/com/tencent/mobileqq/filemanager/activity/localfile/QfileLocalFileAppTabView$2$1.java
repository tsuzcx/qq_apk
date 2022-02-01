package com.tencent.mobileqq.filemanager.activity.localfile;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileAppTabView$2$1
  implements Runnable
{
  QfileLocalFileAppTabView$2$1(QfileLocalFileAppTabView.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.V != null)
    {
      Iterator localIterator = this.a.this$0.V.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)this.a.this$0.V.get(str)).size() == 0) {
          localIterator.remove();
        }
      }
    }
    this.a.this$0.R.putAll(this.a.this$0.V);
    this.a.this$0.refreshUI();
    this.a.this$0.setSelect(0);
    this.a.this$0.V.clear();
    this.a.this$0.IU(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.2.1
 * JD-Core Version:    0.7.0.1
 */