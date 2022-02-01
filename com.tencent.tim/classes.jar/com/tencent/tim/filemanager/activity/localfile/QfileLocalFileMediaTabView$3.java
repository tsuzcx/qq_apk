package com.tencent.tim.filemanager.activity.localfile;

import audx;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileLocalFileMediaTabView$3
  implements Runnable
{
  QfileLocalFileMediaTabView$3(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = audx.gC(this.d.getType());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileMediaTabView.3
 * JD-Core Version:    0.7.0.1
 */