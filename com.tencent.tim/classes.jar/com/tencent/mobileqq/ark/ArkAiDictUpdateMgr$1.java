package com.tencent.mobileqq.ark;

import adpo;
import adpq;
import adpq.e;
import adpr;
import aeje.a;
import aeje.m;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArkAiDictUpdateMgr$1
  implements Runnable
{
  public ArkAiDictUpdateMgr$1(adpq paramadpq) {}
  
  public void run()
  {
    if ((QQAppInterface)adpq.a(this.this$0).get() == null) {
      ArkAppCenter.r("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
    }
    for (;;)
    {
      return;
      aeje.a locala1 = adpq.c();
      Object localObject2 = adpq.b(locala1);
      aeje.a locala3 = adpq.d();
      Object localObject1 = new ArrayList();
      Object localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        aeje.m localm = (aeje.m)((Map)localObject2).get(str);
        if (!adpq.a(this.this$0, localm))
        {
          ArkAppCenter.r("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is not integrity, update, id=%s", new Object[] { str }));
          ((ArrayList)localObject1).add(localm);
        }
        else
        {
          ArkAppCenter.r("ArkApp.Dict.Update", String.format("updateLocalDict, local dict is integrity, ignore, id=%s", new Object[] { str }));
        }
      }
      if (((ArrayList)localObject1).isEmpty())
      {
        adpq.c(locala1);
        adpo.o((AppInterface)adpq.a(this.this$0).get());
        return;
      }
      try
      {
        if (adpq.a(this.this$0))
        {
          ArkAppCenter.r("ArkApp.Dict.Update", "updateLocalDict, update in progress, wait current task complete");
          adpq.a(this.this$0, true);
          return;
        }
      }
      finally {}
      adpq.b(this.this$0, true);
      localObject2 = new adpq.e(null);
      ((adpq.e)localObject2).success = true;
      ((adpq.e)localObject2).taskCount = ((ArrayList)localObject1).size();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (aeje.m)((Iterator)localObject1).next();
        adpq.a(this.this$0, locala3, (aeje.m)localObject3, new adpr(this, (aeje.m)localObject3, (adpq.e)localObject2, locala2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1
 * JD-Core Version:    0.7.0.1
 */