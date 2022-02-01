package com.tencent.tim.filemanager.activity.cloudfile;

import auem;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class QfileCloudFileTabView$4
  implements Runnable
{
  QfileCloudFileTabView$4(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void run()
  {
    this.this$0.R.clear();
    Iterator localIterator = this.this$0.wB.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      String str = auem.cl(localWeiYunFileInfo.mtime);
      if (!this.this$0.R.containsKey(str)) {
        this.this$0.R.put(str, new ArrayList());
      }
      ((List)this.this$0.R.get(str)).add(localWeiYunFileInfo);
    }
    this.this$0.refreshUI();
    this.this$0.setSelect(0);
    this.this$0.IU(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.cloudfile.QfileCloudFileTabView.4
 * JD-Core Version:    0.7.0.1
 */