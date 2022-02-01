package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileRecentDocFileTabView$2
  implements Runnable
{
  QfileRecentDocFileTabView$2(QfileRecentDocFileTabView paramQfileRecentDocFileTabView, String paramString, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (!this.this$0.R.containsKey(this.bGV)) {
      this.this$0.R.put(this.bGV, new ArrayList());
    }
    List localList = (List)this.this$0.R.get(this.bGV);
    if (localList.contains(this.b) == true) {
      return;
    }
    localList.add(0, this.b);
    this.this$0.refreshUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView.2
 * JD-Core Version:    0.7.0.1
 */