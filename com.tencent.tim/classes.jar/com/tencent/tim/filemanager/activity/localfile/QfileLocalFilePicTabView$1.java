package com.tencent.tim.filemanager.activity.localfile;

import android.content.Context;
import audn;
import audt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class QfileLocalFilePicTabView$1
  implements Runnable
{
  QfileLocalFilePicTabView$1(QfileLocalFilePicTabView paramQfileLocalFilePicTabView, Context paramContext) {}
  
  public void run()
  {
    HashMap localHashMap = (HashMap)audt.h(this.val$context);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      audt.a(true, audn.a().vZ(), ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
      Object localObject1 = audn.a().vY();
      if (localObject1 != null) {
        audt.a(true, (String)localObject1, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
      }
      audt.ai(localHashMap);
      if (localHashMap != null)
      {
        localObject1 = localHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          if ("TIMfile_recv".equalsIgnoreCase((String)localObject2) != true)
          {
            localObject2 = (List)localHashMap.get(localObject2);
            this.this$0.wB.addAll((Collection)localObject2);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFilePicTabView.1
 * JD-Core Version:    0.7.0.1
 */