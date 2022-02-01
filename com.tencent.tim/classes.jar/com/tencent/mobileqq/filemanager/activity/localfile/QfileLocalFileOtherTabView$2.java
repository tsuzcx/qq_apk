package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileLocalFileOtherTabView$2
  implements Runnable
{
  QfileLocalFileOtherTabView$2(QfileLocalFileOtherTabView paramQfileLocalFileOtherTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = this.this$0.kN(this.d.getName());
    if (!this.this$0.R.containsKey(localObject)) {
      this.this$0.R.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.R.get(localObject);
    if (((List)localObject).contains(this.d) == true) {
      return;
    }
    ((List)localObject).add(0, this.d);
    this.this$0.refreshUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView.2
 * JD-Core Version:    0.7.0.1
 */