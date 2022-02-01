package com.tencent.mobileqq.activity.leba;

import acep;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import anlm;
import avsn;
import avsr;
import avzl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import zjr;
import zjs;
import zjt;

public class QzoneFrame
  extends acep
{
  public static String bam = "qzone_publish_queue_notify";
  public static int cdx = 1;
  public static int cdy = 2;
  BroadcastReceiver broadcastReceiver = new zjr(this);
  private boolean bru = true;
  private boolean brv = true;
  private int cdw = 255;
  private ViewGroup dD;
  private ViewGroup dE;
  private ViewGroup dF;
  private Drawable eh;
  private Fragment f;
  private Fragment g;
  private Fragment h;
  private boolean isStop = true;
  private View mRootView;
  private TextView mTitleTextView;
  private a onSwitchQzoneTabListener = new zjs(this);
  
  public void BK(boolean paramBoolean)
  {
    QLog.i("QzoneFrame", 1, "onSwitchToQzone:" + paramBoolean);
    avzl.a().Il(0);
    ThreadManager.executeOnSubThread(new QzoneFrame.3(this));
    LpReportInfo_pf00064.allReport(637, 30, 1);
    LpReportInfo_pf00064.allReport(637, 31, 1);
    if (paramBoolean)
    {
      zjt.cpD();
      return;
    }
    LpReportInfo_pf00064.allReport(637, 23, 2);
  }
  
  public boolean PN()
  {
    return this.f != null;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.mRootView = paramLayoutInflater.inflate(2131562523, null);
    return this.mRootView;
  }
  
  public void bMe()
  {
    super.bMe();
    release();
  }
  
  public void cpC()
  {
    if ((this.f != null) && ((this.f instanceof avsr))) {
      ((avsr)this.f).setQzoneSwitchlistener(this.onSwitchQzoneTabListener);
    }
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    avsn.g(a(), this.app);
    onCreate();
    onResume(false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.f == null) {
      return;
    }
    this.f.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.g != null) {
      this.g.onConfigurationChanged(paramConfiguration);
    }
    if (this.h != null) {
      this.h.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate()
  {
    QLog.d("QzoneFrame", 1, "onCreate: ");
    super.onCreate();
    avsn.c(a(), this.app);
    avsn.d(a(), this.app);
    this.dE = ((ViewGroup)this.mRootView.findViewById(2131376104));
    this.dD = ((ViewGroup)this.dE.findViewById(2131375722));
    this.dF = ((ViewGroup)this.mRootView.findViewById(2131376097));
    this.g = avsn.a(a(), this.app, "com.qzone.feed.ui.activity.QQLebaFriendFeedFragment");
    this.f = this.g;
    cpC();
    Object localObject;
    if (this.f != null)
    {
      ((avsr)this.g).setTitleView(this.dD);
      this.f.onAttach(a());
      this.f.onCreate(null);
      localObject = this.f.onCreateView(a().getLayoutInflater(), null, null);
      if (localObject == null) {
        return;
      }
      this.dF.addView((View)localObject);
      this.f.onActivityCreated(null);
      this.f.onStart();
    }
    if (this.bru) {
      this.bru = false;
    }
    for (;;)
    {
      localObject = new IntentFilter(new IntentFilter(bam));
      try
      {
        a().registerReceiver(this.broadcastReceiver, (IntentFilter)localObject);
        QZoneLoginReportHelper.reportLoginFromSimpleMode();
        return;
        if (!(this.g instanceof avsr)) {
          continue;
        }
        ((avsr)this.g).forceRefresh();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("QzoneFrame", 1, "registerReceiver" + localException);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.d("QzoneFrame", 1, "onDestroy: ");
    super.onDestroy();
    try
    {
      a().unregisterReceiver(this.broadcastReceiver);
      if (this.f == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("QzoneFrame", 1, "registerReceiver" + localException);
        }
        if (this.g != null)
        {
          this.g.onDestroy();
          this.g = null;
        }
      } while (this.h == null);
      this.h.onDestroy();
      this.h = null;
    }
  }
  
  public void onPause()
  {
    QLog.d("QzoneFrame", 1, "onPause: ");
    super.onPause();
    if (this.f == null) {
      return;
    }
    this.f.onPause();
    FrameHelperActivity.EO(true);
  }
  
  public void onPostThemeChanged()
  {
    release();
    anlm.bgColor = 0;
    anlm.textColor = 0;
    onCreate();
  }
  
  public void onResume(boolean paramBoolean)
  {
    QLog.d("QzoneFrame", 1, "onResume: ");
    super.onResume(paramBoolean);
    if (this.g == null) {}
    do
    {
      return;
      if ((this.dE != null) && (this.dE.findViewById(2131369579) != null)) {
        this.dE.findViewById(2131369579).setVisibility(8);
      }
      this.f.onResume();
      FrameHelperActivity.EO(true);
    } while (!FrameHelperActivity.ZW());
    FrameHelperActivity.cuA();
    FrameHelperActivity.EO(false);
  }
  
  public void onStart()
  {
    QLog.d("QzoneFrame", 1, "onStart: ");
    super.onStart();
    if (this.f == null) {
      return;
    }
    this.isStop = false;
    this.f.onStart();
  }
  
  public void onStop()
  {
    QLog.d("QzoneFrame", 1, "onStop: ");
    super.onStop();
    if (this.f == null) {
      return;
    }
    this.isStop = true;
    this.f.onStop();
  }
  
  public void onSwitchOutofQzone()
  {
    try
    {
      avzl.a().eCO();
      ImmersiveUtils.setStatusTextColor(anlm.ayp(), a().getWindow());
      ImageLoader.getInstance().clear(false);
      if (this.f != null) {
        ((avsr)this.f).onSwitchOutofQzone();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QzoneFrame", 1, "onSwitchOutofQzone" + localThrowable);
    }
  }
  
  public void pE(boolean paramBoolean) {}
  
  public void release()
  {
    this.dF.removeAllViews();
    this.dD.removeAllViews();
    if (this.g != null) {
      this.g.onDestroy();
    }
    if (this.h != null) {
      this.h.onDestroy();
    }
    if ((this.g instanceof avsr)) {
      ((avsr)this.g).clearCache();
    }
    if ((this.h instanceof avsr)) {
      ((avsr)this.h).clearCache();
    }
    this.g = null;
    this.h = null;
    a().getIntent().putExtra("newflag", true);
  }
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    super.setActivity(paramBaseActivity);
  }
  
  public abstract class a
  {
    public a() {}
    
    public abstract void Fn(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.QzoneFrame
 * JD-Core Version:    0.7.0.1
 */