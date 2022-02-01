package com.tencent.tim.filemanager.activity.cloudfile;

import auem;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileCloudFileTabView$5
  implements Runnable
{
  public void run()
  {
    Object localObject = auem.cl(this.a.mtime);
    if (!this.this$0.R.containsKey(localObject)) {
      this.this$0.R.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.R.get(localObject);
    if (((List)localObject).contains(this.a) == true) {
      return;
    }
    ((List)localObject).add(0, this.a);
    this.this$0.refreshUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.cloudfile.QfileCloudFileTabView.5
 * JD-Core Version:    0.7.0.1
 */