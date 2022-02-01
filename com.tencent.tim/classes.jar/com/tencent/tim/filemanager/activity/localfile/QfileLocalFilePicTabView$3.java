package com.tencent.tim.filemanager.activity.localfile;

import audx;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileLocalFilePicTabView$3
  implements Runnable
{
  QfileLocalFilePicTabView$3(QfileLocalFilePicTabView paramQfileLocalFilePicTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = this.d.getGroupName();
    if (!this.this$0.R.containsKey(localObject)) {
      this.this$0.R.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.R.get(this.d.getGroupName());
    if (((List)localObject).contains(this.d) == true) {
      return;
    }
    int j = audx.b((List)localObject, this.d.getDate());
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ((List)localObject).add(i, this.d);
    this.this$0.refreshUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFilePicTabView.3
 * JD-Core Version:    0.7.0.1
 */