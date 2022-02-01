package com.tencent.mobileqq.filemanager.activity.localfile;

import acfp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileLocalFileMediaTabView$1$1
  implements Runnable
{
  QfileLocalFileMediaTabView$1$1(QfileLocalFileMediaTabView.1 param1, ArrayList paramArrayList, HashMap paramHashMap1, HashMap paramHashMap2, LinkedHashMap paramLinkedHashMap) {}
  
  public void run()
  {
    this.a.this$0.wB.clear();
    this.a.this$0.wB.addAll(this.wC);
    this.a.this$0.R.clear();
    if ((this.a.this$0.cdi) && ((QfileLocalFileMediaTabView.a(this.a.this$0) & 0x2) > 0)) {
      this.a.this$0.R.put("Camera", new ArrayList());
    }
    Iterator localIterator = this.kE.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.a.this$0.R.containsKey(acfp.m(2131711099))) {
        this.a.this$0.R.put(acfp.m(2131711085), new ArrayList());
      }
      ((List)this.a.this$0.R.get(acfp.m(2131711095))).addAll((Collection)this.kE.get(str));
    }
    localIterator = this.kF.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.a.this$0.R.containsKey(acfp.m(2131711087))) {
        this.a.this$0.R.put(acfp.m(2131711083), new ArrayList());
      }
      ((List)this.a.this$0.R.get(acfp.m(2131711105))).addAll((Collection)this.kF.get(str));
    }
    this.a.this$0.R.putAll(this.W);
    this.a.this$0.refreshUI();
    this.a.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView.1.1
 * JD-Core Version:    0.7.0.1
 */