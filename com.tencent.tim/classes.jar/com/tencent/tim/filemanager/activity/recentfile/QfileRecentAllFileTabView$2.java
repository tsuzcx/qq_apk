package com.tencent.tim.filemanager.activity.recentfile;

import auem;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileRecentAllFileTabView$2
  implements Runnable
{
  QfileRecentAllFileTabView$2(QfileRecentAllFileTabView paramQfileRecentAllFileTabView, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    Object localObject = auem.cl(this.b.srvTime);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.recentfile.QfileRecentAllFileTabView.2
 * JD-Core Version:    0.7.0.1
 */