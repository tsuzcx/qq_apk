package com.tencent.tim.filemanager.activity.localfile;

import atsl;
import atso;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileMediaTabView$2$1
  implements Runnable
{
  QfileLocalFileMediaTabView$2$1(QfileLocalFileMediaTabView.2 param2, HashMap paramHashMap1, HashMap paramHashMap2) {}
  
  public void run()
  {
    this.a.this$0.R.clear();
    if ((QfileLocalFileMediaTabView.a(this.a.this$0) & 0x2) > 0) {
      this.a.this$0.R.put("Camera", new ArrayList());
    }
    Object localObject1 = this.qg.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!this.a.this$0.R.containsKey("已下载的视频")) {
        this.a.this$0.R.put("已下载的视频", new ArrayList());
      }
      ((List)this.a.this$0.R.get("已下载的视频")).addAll((Collection)this.qg.get(localObject2));
      if (!this.a.this$0.wB.contains(this.qg.get(localObject2))) {
        this.a.this$0.wB.addAll((Collection)this.qg.get(localObject2));
      }
    }
    localObject1 = this.qh.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!this.a.this$0.R.containsKey("已下载的音乐")) {
        this.a.this$0.R.put("已下载的音乐", new ArrayList());
      }
      ((List)this.a.this$0.R.get("已下载的音乐")).addAll((Collection)this.qh.get(localObject2));
      if (!this.a.this$0.wB.contains(this.qh.get(localObject2))) {
        this.a.this$0.wB.addAll((Collection)this.qh.get(localObject2));
      }
    }
    Object localObject2 = this.a.this$0.wB.iterator();
    FileInfo localFileInfo;
    while (((Iterator)localObject2).hasNext())
    {
      localFileInfo = (FileInfo)((Iterator)localObject2).next();
      localObject1 = localFileInfo.getGroupName();
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        if ((((String)localObject1).equalsIgnoreCase("camera") != true) && (((String)localObject1).equalsIgnoreCase("Video") != true)) {
          break label674;
        }
        localObject1 = "Camera";
      }
    }
    label674:
    for (;;)
    {
      if (!this.a.this$0.R.containsKey(localObject1)) {
        this.a.this$0.R.put(localObject1, new ArrayList());
      }
      if (((List)this.a.this$0.R.get(localObject1)).contains(localFileInfo)) {
        break;
      }
      ((List)this.a.this$0.R.get(localObject1)).add(localFileInfo);
      break;
      localObject1 = QfileLocalFileMediaTabView.a(this.a.this$0).a().a(1);
      int j;
      int i;
      if ((localObject1 != null) && ((localObject1 instanceof atsl)))
      {
        localObject1 = (atsl)localObject1;
        j = ((atsl)localObject1).Oy();
        i = ((atsl)localObject1).Oz();
      }
      for (;;)
      {
        this.a.this$0.refreshUI();
        if ((j == -1) || (i == -1))
        {
          this.a.this$0.setSelect(0);
          return;
        }
        if (this.a.this$0.b.aWg)
        {
          this.a.this$0.setPos(j, i);
          return;
        }
        this.a.this$0.setSelect(0);
        return;
        i = -1;
        j = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileMediaTabView.2.1
 * JD-Core Version:    0.7.0.1
 */