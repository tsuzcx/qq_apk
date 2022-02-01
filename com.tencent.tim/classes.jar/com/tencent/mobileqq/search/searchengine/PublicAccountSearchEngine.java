package com.tencent.mobileqq.search.searchengine;

import acja;
import ampt;
import amqy;
import amwd;
import amwe;
import amwr;
import amws;
import amwt;
import android.text.TextUtils;
import asgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kbp;
import ocp;

public class PublicAccountSearchEngine
  implements amwd<amqy>, Runnable
{
  private static final Comparator<amqy> X = new amwr();
  private static final Comparator<amqy> Z = new amws();
  private acja a;
  private int fromType = -1;
  private final QQAppInterface mApp;
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mApp = paramQQAppInterface;
    this.a = ((acja)paramQQAppInterface.getManager(56));
    this.fromType = paramInt;
  }
  
  private static int a(ampt paramampt1, ampt paramampt2)
  {
    int j = 0;
    int i = j;
    if (paramampt2.getTitle() != null)
    {
      i = j;
      if (paramampt1.getTitle() != null) {
        i = paramampt1.getTitle().toString().compareTo(paramampt2.getTitle().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramampt2.f() != null)
      {
        j = i;
        if (paramampt1.f() != null) {
          j = paramampt1.f().toString().compareTo(paramampt2.f().toString());
        }
      }
    }
    return j;
  }
  
  public List<amqy> a(amwt paramamwt)
  {
    long l1 = System.currentTimeMillis();
    while (this.a.abh()) {}
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = this.a.cx();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountSearchEngine", 2, "all publicAccountInfoList is null or empty");
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    int j = localArrayList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject3 = (Entity)localArrayList.get(i);
      if ((localObject3 == null) || (!(localObject3 instanceof PublicAccountInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject4 = (asgx)this.mApp.getManager(165);
        if ((localObject4 == null) || (!((asgx)localObject4).sM(((PublicAccountInfo)localObject3).getUin())))
        {
          localObject3 = (PublicAccountInfo)localObject3;
          if ((!TextUtils.equals(((PublicAccountInfo)localObject3).getUin(), "2173223560")) && ((this.fromType != 12) || (ocp.m(this.mApp, ((PublicAccountInfo)localObject3).getUin()))))
          {
            localObject4 = new amqy(this.mApp, (PublicAccountInfo)localObject3, this.fromType);
            ((amqy)localObject4).aw(paramamwt.keyword);
            if (((amqy)localObject4).gN() != -9223372036854775808L)
            {
              amqy localamqy = (amqy)((HashMap)localObject2).get(((amqy)localObject4).S());
              if ((localamqy == null) || (localamqy.gN() < ((amqy)localObject4).gN())) {
                ((HashMap)localObject2).put(((amqy)localObject4).S(), localObject4);
              }
            }
            if ((localObject3 != null) && (((PublicAccountInfo)localObject3).displayNumber != null) && (((PublicAccountInfo)localObject3).displayNumber.equalsIgnoreCase(((amqy)localObject4).getKeyword()))) {
              ((List)localObject1).add(localObject4);
            }
          }
        }
      }
    }
    localArrayList = new ArrayList();
    localArrayList.addAll(((HashMap)localObject2).values());
    Collections.sort(localArrayList, X);
    i = Math.min(localArrayList.size(), 30);
    localObject2 = localArrayList.subList(0, i);
    Collections.sort((List)localObject2, Z);
    paramamwt = new ArrayList();
    paramamwt.addAll((Collection)localObject2);
    paramamwt.addAll(localArrayList.subList(i, localArrayList.size()));
    paramamwt.removeAll((Collection)localObject1);
    paramamwt.addAll(0, (Collection)localObject1);
    localObject1 = paramamwt.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (amqy)((Iterator)localObject1).next();
      i += 1;
      ((amqy)localObject2).UA(i);
    }
    long l3 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
    }
    return paramamwt;
  }
  
  public void a(amwt paramamwt, amwe<amqy> paramamwe)
  {
    ThreadManager.postImmediately(new PublicAccountSearchEngine.1(this, paramamwt, paramamwe), null, true);
    if (!TextUtils.isEmpty(paramamwt.keyword)) {
      kbp.a(this.mApp, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 0, "", "", paramamwt.keyword, "", false);
    }
  }
  
  public void cancel() {}
  
  public void destroy() {}
  
  public void init()
  {
    if (this.a == null) {}
    while (this.a.bIJ) {
      return;
    }
    ThreadManager.post(this, 5, null, true);
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void run()
  {
    this.a.cLa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine
 * JD-Core Version:    0.7.0.1
 */