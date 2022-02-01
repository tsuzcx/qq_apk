package com.tencent.mobileqq.app;

import acep;
import acer;
import ahmm;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import anpc;
import aqlr;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.tim.timme.TimLeba;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.Constants.LogoutReason;

public class FrameFragment
  extends ReportV4Fragment
  implements ahmm, TabHost.OnTabChangeListener, TabHost.TabContentFactory
{
  long Pw = -1L;
  public QQTabHost a;
  protected boolean aTK;
  private acep b;
  private HashMap<String, TabHost.TabSpec> iM;
  private final Map<String, acep> jk = new HashMap(4);
  protected View mRootView;
  String tabName = null;
  
  protected acep a()
  {
    return this.b;
  }
  
  public acep a(Class<? extends acep> paramClass)
  {
    acep localacep = null;
    if (this.jk != null) {
      localacep = (acep)this.jk.get(paramClass.getName());
    }
    return localacep;
  }
  
  protected void a(View paramView1, Class<? extends acep> paramClass, View paramView2)
  {
    if (this.a == null)
    {
      this.a = ((QQTabHost)paramView1.findViewById(16908306));
      this.a.setup();
      this.a.setOnTabChangedListener(this);
      this.a.setOnTabSelectionListener(new acer(this));
      this.iM = new HashMap(4);
    }
    String str = paramClass.getName();
    paramClass = (TabHost.TabSpec)this.iM.get(str);
    paramView1 = paramClass;
    if (paramClass == null)
    {
      paramView1 = this.a.newTabSpec(str).setIndicator(paramView2).setContent(this);
      this.iM.put(str, paramView1);
    }
    this.a.addTab(paramView1);
  }
  
  public acep b()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameActivity", 2, "mTabHost=null");
      }
      return null;
    }
    return (acep)this.jk.get(this.a.getCurrentTabTag());
  }
  
  public void bMp()
  {
    long l = SystemClock.uptimeMillis() - this.Pw;
    Log.i("AutoMonitor", this.tabName + "TabSwitch, cost=" + l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, this.tabName + "TabSwitch, cost=" + l);
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(aqlr.getUin(), "actSwitch" + this.tabName, true, l, 0L, null, null);
  }
  
  public View createTabContent(String paramString)
  {
    Object localObject = null;
    if (getActivity() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MainFragment", 2, "FrameFragment.createTabContent getActivity == null");
      }
      return null;
    }
    if (paramString.equals(Conversation.class.getName())) {
      localObject = new Conversation();
    }
    for (;;)
    {
      ((acep)localObject).setActivity(getActivity());
      View localView = ((acep)localObject).a(getActivity().getLayoutInflater());
      ((acep)localObject).setContentView(localView);
      ((acep)localObject).onCreate();
      this.jk.put(paramString, localObject);
      return localView;
      if (paramString.equals(Contacts.class.getName())) {
        localObject = new Contacts();
      } else if (paramString.equals(Leba.class.getName())) {
        localObject = new Leba();
      } else if (paramString.equals(Now.class.getName())) {
        localObject = new Now();
      } else if (paramString.equals(ReadinjoyTabFrame.class.getName())) {
        localObject = new ReadinjoyTabFrame(this);
      } else if (paramString.equals(QzoneFrame.class.getName())) {
        localObject = new QzoneFrame();
      } else if (paramString.equals(TimLeba.class.getName())) {
        localObject = new TimLeba();
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    acep localacep = b();
    if (localacep != null) {
      localacep.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void f(Class<? extends acep> paramClass)
  {
    if (this.jk != null)
    {
      acep localacep = a(paramClass);
      if (localacep != null) {
        localacep.onDestroy();
      }
      paramClass = paramClass.getName();
      this.jk.remove(paramClass);
      if (this.iM != null) {
        this.iM.remove(paramClass);
      }
    }
  }
  
  public int getCurrentTab()
  {
    return this.a.getCurrentTab();
  }
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameActivity", 2, "onAccountChanged");
    }
    Iterator localIterator = this.jk.values().iterator();
    while (localIterator.hasNext()) {
      ((acep)localIterator.next()).onAccountChanged();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jk.values().iterator();
    while (localIterator.hasNext()) {
      ((acep)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559520, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jk.values().iterator();
    while (localIterator.hasNext()) {
      ((acep)localIterator.next()).onDestroy();
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    Iterator localIterator = this.jk.values().iterator();
    while (localIterator.hasNext()) {
      ((acep)localIterator.next()).onLogout(paramLogoutReason);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.bKT != 1) && (!this.aTK)) {}
    acep localacep;
    do
    {
      return;
      localacep = b();
    } while (localacep == null);
    localacep.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.bKT != 1) {}
    acep localacep;
    do
    {
      return;
      localacep = b();
    } while ((localacep == null) || (!localacep.PN()));
    localacep.onResume(false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.bKT != 1) {}
    acep localacep;
    do
    {
      return;
      localacep = b();
    } while (localacep == null);
    localacep.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.bKT != 1) && (!this.aTK)) {}
    acep localacep;
    do
    {
      return;
      localacep = b();
    } while (localacep == null);
    localacep.onStop();
  }
  
  public void onTabChanged(String paramString)
  {
    if (paramString != null)
    {
      this.tabName = paramString;
      int i = paramString.lastIndexOf(".");
      if (i >= 0) {
        this.tabName = paramString.substring(i + 1, paramString.length());
      }
      this.Pw = SystemClock.uptimeMillis();
      if ((this.a instanceof QQTabHost)) {
        this.a.setFirstDrawTrue();
      }
    }
    if (this.b != null)
    {
      this.b.onPause();
      this.b.bRz();
    }
    this.b = b();
    if ((this.b != null) && (this.b.PN())) {
      this.b.onResume(true);
    }
  }
  
  protected String setLastActivityName()
  {
    acep localacep = b();
    if (localacep != null) {
      return localacep.setLastActivityName();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment
 * JD-Core Version:    0.7.0.1
 */