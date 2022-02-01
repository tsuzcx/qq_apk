package com.tencent.mobileqq.search.searchengine;

import ampx;
import amqc;
import amwd;
import amwe;
import amwh;
import amwt;
import amxk;
import amxl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MiniProgramSearchEngine
  implements amwd<amqc>, Runnable
{
  protected MiniAppLocalSearchManager a;
  protected int fromType = -1;
  protected QQAppInterface mApp;
  
  public MiniProgramSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mApp = paramQQAppInterface;
    this.fromType = paramInt;
  }
  
  public List<amqc> a(amwt paramamwt)
  {
    int i = 0;
    Object localObject = this.a.getLocalSearchData();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList(((List)localObject).size() + 1);
    ArrayList localArrayList2 = new ArrayList(((List)localObject).size() + 1);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MiniAppLocalSearchEntity localMiniAppLocalSearchEntity = (MiniAppLocalSearchEntity)((Iterator)localObject).next();
      int[] arrayOfInt = amxk.a(paramamwt.keyword, localMiniAppLocalSearchEntity.appName, false);
      if ((arrayOfInt != null) && (arrayOfInt.length >= 3) && (arrayOfInt[0] > -1))
      {
        amqc localamqc = new amqc(this.mApp, this.fromType, localMiniAppLocalSearchEntity, paramamwt.keyword);
        localamqc.nd = arrayOfInt;
        if (localMiniAppLocalSearchEntity.appName.equals(paramamwt.keyword)) {
          localArrayList2.add(0, localamqc);
        } else {
          localArrayList2.add(localamqc);
        }
      }
    }
    localArrayList1.addAll(localArrayList2);
    Collections.sort(localArrayList2, new amwh(this));
    int j = localArrayList1.size();
    while (i < j)
    {
      amxl.a((ampx)localArrayList1.get(i), j, i);
      i += 1;
    }
    return localArrayList1;
  }
  
  public void a(amwt paramamwt, amwe<amqc> paramamwe) {}
  
  public void cancel() {}
  
  public void destroy() {}
  
  public void init()
  {
    this.a = ((MiniAppLocalSearchManager)this.mApp.getManager(310));
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MiniProgramSearchEngine
 * JD-Core Version:    0.7.0.1
 */