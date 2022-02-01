package com.tencent.mobileqq.filemanager.activity.recentfile;

import ahcb;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileRecentTDocFileTabView$1
  implements Runnable
{
  QfileRecentTDocFileTabView$1(QfileRecentTDocFileTabView paramQfileRecentTDocFileTabView, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    Object localObject = ahcb.bt(this.b.srvTime);
    if (!this.this$0.R.containsKey(localObject)) {
      this.this$0.R.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.R.get(localObject);
    if (((List)localObject).contains(this.b) == true) {
      return;
    }
    ((List)localObject).add(0, this.b);
    this.this$0.refreshUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView.1
 * JD-Core Version:    0.7.0.1
 */