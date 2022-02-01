package com.tencent.tim.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFilePicTabView$2
  implements Runnable
{
  QfileLocalFilePicTabView$2(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void run()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("手机相册", new ArrayList());
    localLinkedHashMap.put("已下载图片", new ArrayList());
    for (;;)
    {
      try
      {
        Iterator localIterator = this.this$0.wB.iterator();
        if (localIterator.hasNext())
        {
          FileInfo localFileInfo = (FileInfo)localIterator.next();
          Object localObject3 = localFileInfo.getGroupName();
          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
            break label226;
          }
          Object localObject1 = localObject3;
          if (((String)localObject3).equalsIgnoreCase("TIMfile_recv")) {
            break label226;
          }
          localObject3 = localObject1;
          if (localObject1.equalsIgnoreCase("camera") == true) {
            localObject3 = "手机相册";
          }
          if (!localLinkedHashMap.containsKey(localObject3)) {
            localLinkedHashMap.put(localObject3, new ArrayList());
          }
          ((List)localLinkedHashMap.get(localObject3)).add(localFileInfo);
          continue;
        }
        localObject2 = localLinkedHashMap.keySet().iterator();
      }
      catch (Exception localException)
      {
        QfileLocalFilePicTabView.a(this.this$0, new QfileLocalFilePicTabView.2.1(this, localLinkedHashMap));
        return;
      }
      while (((Iterator)localObject2).hasNext()) {
        if (((List)localLinkedHashMap.get((String)((Iterator)localObject2).next())).size() == 0) {
          ((Iterator)localObject2).remove();
        }
      }
      continue;
      label226:
      Object localObject2 = "已下载图片";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFilePicTabView.2
 * JD-Core Version:    0.7.0.1
 */