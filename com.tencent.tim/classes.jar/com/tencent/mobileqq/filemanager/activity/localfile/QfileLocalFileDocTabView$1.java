package com.tencent.mobileqq.filemanager.activity.localfile;

import ahaf;
import ahap;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
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
    if (this.this$0.a.sB() != 8) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = this.this$0.AS.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ahap.a(bool, ((QfileTabBarView.a)((Iterator)localObject1).next()).wd(), ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, null);
      }
    }
    if (this.this$0.cdi) {}
    for (Object localObject1 = ahaf.a().vY();; localObject1 = null)
    {
      if (localObject1 != null) {
        ahap.a(bool, (String)localObject1, ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, null);
      }
      localObject1 = new HashMap();
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        String str = QfileLocalFileDocTabView.a(this.this$0, (String)localObject2);
        localObject2 = (List)localHashMap.get(localObject2);
        if (!((HashMap)localObject1).containsKey(str)) {
          ((HashMap)localObject1).put(str, new ArrayList());
        }
        ((List)((HashMap)localObject1).get(str)).addAll((Collection)localObject2);
      }
    }
    ahap.ai((Map)localObject1);
    QfileLocalFileDocTabView.a(this.this$0, new QfileLocalFileDocTabView.1.1(this, (HashMap)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView.1
 * JD-Core Version:    0.7.0.1
 */