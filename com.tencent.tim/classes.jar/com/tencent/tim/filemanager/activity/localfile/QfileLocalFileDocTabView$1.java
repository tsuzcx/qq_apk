package com.tencent.tim.filemanager.activity.localfile;

import audn;
import audt;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class QfileLocalFileDocTabView$1
  implements Runnable
{
  QfileLocalFileDocTabView$1(QfileLocalFileDocTabView paramQfileLocalFileDocTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = audn.a().vZ();
    if (this.this$0.b.sB() != 9) {}
    for (boolean bool = true;; bool = false)
    {
      audt.a(bool, (String)localObject1, ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, null);
      localObject1 = audn.a().vY();
      if (localObject1 != null) {
        audt.a(bool, (String)localObject1, ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, null);
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
    }
    audt.ai((Map)localObject1);
    QfileLocalFileDocTabView.a(this.this$0, new QfileLocalFileDocTabView.1.1(this, (HashMap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileDocTabView.1
 * JD-Core Version:    0.7.0.1
 */