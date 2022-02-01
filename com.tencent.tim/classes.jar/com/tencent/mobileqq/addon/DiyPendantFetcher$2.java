package com.tencent.mobileqq.addon;

import abgl;
import abgl.a;
import abgm;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class DiyPendantFetcher$2
  implements Runnable
{
  public DiyPendantFetcher$2(abgl paramabgl, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject2;
    if (!this.this$0.h.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "now query mUnCacheDiyId: " + TextUtils.join(",", this.this$0.h));
      }
      this.this$0.bW(this.val$app);
      if (!this.this$0.h.isEmpty())
      {
        localObject1 = (abgm)this.val$app.getBusinessHandler(114);
        localObject2 = new ArrayList();
        Iterator localIterator = this.this$0.h.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject2).add(Long.valueOf(Long.parseLong(((java.lang.String)localIterator.next()).split("_")[0])));
        }
        ((abgm)localObject1).a((List)localObject2, null);
        this.this$0.h.clear();
      }
    }
    if (!this.this$0.i.isEmpty()) {
      this.this$0.cBr();
    }
    Object localObject1 = this.this$0.E.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (abgl.a)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((abgl.a)localObject2).L() == null)) {
        this.this$0.E.remove(localObject2);
      }
    }
    abgl.Nl = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.2
 * JD-Core Version:    0.7.0.1
 */