package com.tencent.tim.filemanager.activity.delDownloadFile;

import audn;
import audt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class QfileLocalFileDelPicTabView$1
  implements Runnable
{
  QfileLocalFileDelPicTabView$1(QfileLocalFileDelPicTabView paramQfileLocalFileDelPicTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    audt.a(false, audn.a().vZ(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
    Object localObject1 = audn.a().vY();
    if (localObject1 != null) {
      audt.a(false, (String)localObject1, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
    }
    localObject1 = new HashMap();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      String str = this.this$0.getFileType((String)localObject2);
      localObject2 = (List)localHashMap.get(localObject2);
      if (!((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).put(str, new ArrayList());
      }
      ((List)((HashMap)localObject1).get(str)).addAll((Collection)localObject2);
    }
    audt.ai((Map)localObject1);
    QfileLocalFileDelPicTabView.a(this.this$0, new QfileLocalFileDelPicTabView.1.1(this, (HashMap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView.1
 * JD-Core Version:    0.7.0.1
 */