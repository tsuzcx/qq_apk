package com.tencent.mobileqq.troop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class UsingTimeReportManager
  extends BroadcastReceiver
  implements Manager
{
  private IntentFilter e;
  private AppInterface mApp;
  private List<a> wF = new ArrayList();
  
  public UsingTimeReportManager(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.e = new IntentFilter();
    this.e.addAction("android.intent.action.SCREEN_OFF");
    this.e.addAction("mqq.intent.action.QQ_BACKGROUND");
    this.e.addAction("mqq.intent.action.QQ_FOREGROUND");
    this.e.addAction("mqq.intent.action.ACCOUNT_KICKED");
    try
    {
      paramAppInterface = paramAppInterface.getApp();
      if (paramAppInterface != null) {
        paramAppInterface.registerReceiver(this, this.e);
      }
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("UsingTimeReportManager", 1, "init," + paramAppInterface.toString(), paramAppInterface);
    }
  }
  
  private void ecs()
  {
    try
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.wF);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((a)((Iterator)localObject1).next()).ebW();
      }
    }
    finally {}
  }
  
  private void ect()
  {
    try
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.wF);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((a)((Iterator)localObject1).next()).ebX();
      }
    }
    finally {}
  }
  
  public void a(a parama)
  {
    try
    {
      if (!this.wF.contains(parama)) {
        this.wF.add(parama);
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void b(a parama)
  {
    try
    {
      if (this.wF.contains(parama)) {
        this.wF.remove(parama);
      }
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void ecu()
  {
    try
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.wF);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((a)((Iterator)localObject1).next()).ebY();
      }
    }
    finally {}
  }
  
  public void onDestroy()
  {
    try
    {
      this.wF.clear();
      try
      {
        BaseApplication localBaseApplication = this.mApp.getApp();
        if (localBaseApplication != null) {
          localBaseApplication.unregisterReceiver(this);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("UsingTimeReportManager", 1, "unInit" + localException.toString(), localException);
        }
      }
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      ecs();
    }
    do
    {
      return;
      if ("android.intent.action.SCREEN_ON".equals(paramContext))
      {
        ect();
        return;
      }
      if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext))
      {
        ecs();
        return;
      }
      if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
      {
        ect();
        return;
      }
    } while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext));
    ecu();
  }
  
  public static abstract interface a
  {
    public abstract void ebW();
    
    public abstract void ebX();
    
    public abstract void ebY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.UsingTimeReportManager
 * JD-Core Version:    0.7.0.1
 */