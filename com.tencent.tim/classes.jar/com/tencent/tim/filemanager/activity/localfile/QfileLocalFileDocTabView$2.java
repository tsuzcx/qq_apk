package com.tencent.tim.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileLocalFileDocTabView$2
  implements Runnable
{
  QfileLocalFileDocTabView$2(QfileLocalFileDocTabView paramQfileLocalFileDocTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = this.this$0.getFileType(this.d.getName());
    if (!this.this$0.R.containsKey(localObject)) {
      this.this$0.R.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.R.get(localObject);
    if (((List)localObject).contains(this.d) == true) {}
    do
    {
      return;
      ((List)localObject).add(this.d);
      this.this$0.refreshUI();
    } while (this.this$0.wB.size() != 1);
    this.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileDocTabView.2
 * JD-Core Version:    0.7.0.1
 */