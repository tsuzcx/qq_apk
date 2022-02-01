package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import aqmr;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import yho;
import yhp;

public class ScenesRecommendManager
  extends BroadcastReceiver
  implements Manager
{
  a a;
  QQAppInterface mApp = null;
  List<yho> sG = null;
  
  public ScenesRecommendManager() {}
  
  public ScenesRecommendManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    paramQQAppInterface = new IntentFilter("mqq.scenesrecommendemo.notify.action");
    this.mApp.getApp().getApplicationContext().registerReceiver(this, paramQQAppInterface);
    cis();
  }
  
  public static ScenesRecommendManager a(QQAppInterface paramQQAppInterface)
  {
    return (ScenesRecommendManager)paramQQAppInterface.getManager(364);
  }
  
  private yho b(String paramString)
  {
    if (this.sG == null) {
      return null;
    }
    Iterator localIterator = this.sG.iterator();
    yho localyho;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localyho = (yho)localIterator.next();
    } while ((localyho.pD() == null) || (!localyho.pD().equalsIgnoreCase(paramString)));
    for (paramString = localyho;; paramString = null) {
      return paramString;
    }
  }
  
  private void b(yho paramyho)
  {
    QLog.i("ScenesRecommendManager", 0, "doScenesEmotionRecommend ScenesRecommendItem is " + paramyho.pC());
    if (this.a == null) {
      return;
    }
    this.a.a(paramyho);
  }
  
  private boolean hY(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.hJ(paramString);
  }
  
  public yho a(String paramString)
  {
    if (this.sG == null) {
      return null;
    }
    Iterator localIterator = this.sG.iterator();
    yho localyho;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localyho = (yho)localIterator.next();
    } while ((localyho.pC() == null) || (!localyho.pC().equalsIgnoreCase(paramString)));
    for (paramString = localyho;; paramString = null) {
      return paramString;
    }
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void cis()
  {
    String str = yhp.n(this.mApp);
    QLog.i("ScenesRecommendManager", 0, "loadConfigFromLoacl config is " + str);
    yH(str);
  }
  
  public void g(String paramString1, boolean paramBoolean, String paramString2)
  {
    if ((!paramBoolean) || (hY(paramString2))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString1 = b(paramString1);
        if (paramString1 != null) {
          b(paramString1);
        }
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.mApp.getApp().getApplicationContext().unregisterReceiver(this);
    this.mApp = null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == "mqq.scenesrecommendemo.notify.action")
    {
      paramContext = paramIntent.getStringExtra("scenes_kov");
      boolean bool = paramIntent.getBooleanExtra("need_check_uin", true);
      paramIntent = paramIntent.getStringExtra("check_uin");
      QLog.i("ScenesRecommendManager", 0, "onReceive NOTIFY_SCENES_RECOMMEND_EMO_ACTION is " + paramContext + "|" + bool + "|" + paramIntent);
      g(paramContext, bool, paramIntent);
    }
  }
  
  public void yH(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return;
    }
    if (this.sG == null) {
      this.sG = new ArrayList();
    }
    for (;;)
    {
      paramString = yhp.ag(paramString);
      if (paramString == null) {
        break;
      }
      this.sG.addAll(paramString);
      return;
      this.sG.clear();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(yho paramyho);
    
    public abstract boolean hJ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager
 * JD-Core Version:    0.7.0.1
 */