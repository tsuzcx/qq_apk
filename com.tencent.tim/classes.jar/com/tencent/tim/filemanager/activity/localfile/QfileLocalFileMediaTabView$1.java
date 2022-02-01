package com.tencent.tim.filemanager.activity.localfile;

import android.content.Context;
import audt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class QfileLocalFileMediaTabView$1
  implements Runnable
{
  QfileLocalFileMediaTabView$1(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView, int paramInt, Context paramContext) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Map localMap;
    Iterator localIterator;
    String str;
    if ((this.eqJ & 0x1) > 0)
    {
      localMap = audt.j(this.val$context);
      if (localMap != null)
      {
        localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (str.equalsIgnoreCase("TIMfile_recv") != true) {
            localArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
    if ((this.eqJ & 0x2) > 0)
    {
      localMap = audt.i(this.val$context);
      if (localMap != null)
      {
        localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if ("TIMfile_recv".equalsIgnoreCase(str) != true) {
            localArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
    this.this$0.wB.addAll(localArrayList);
    this.this$0.dfD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileMediaTabView.1
 * JD-Core Version:    0.7.0.1
 */