package com.tencent.mobileqq.nearby;

import acfp;
import ahyj;
import ajps;
import ajrk;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import anpc;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import zsz;

public class NearbyFakeActivity
  extends IphoneTitleBarActivity
{
  NearbyResultReceiver a;
  private long adg;
  private long adh;
  private Intent ah;
  private boolean cpM;
  private final int dkl = 0;
  private final int dkm = 1;
  Object lock = new Object();
  private Handler mHandler = new ajps(this);
  private long mStartTime;
  
  private void Rl(int paramInt)
  {
    boolean bool = true;
    if ((this.cpM) || (isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFakeActivity", 2, "OpenNearbyAct from:" + paramInt);
    }
    this.mHandler.removeMessages(0);
    this.cpM = true;
    try
    {
      startActivity(this.ah);
      overridePendingTransition(0, 0);
      long l = System.currentTimeMillis();
      if (this.adg <= 0L) {
        this.adg = (l - this.mStartTime);
      }
      Object localObject = new HashMap();
      ((HashMap)localObject).put("param_NetType", aqiw.getSystemNetwork(null) + "");
      ((HashMap)localObject).put("param_DeviceType", zsz.getDeviceType() + "");
      if (paramInt == 0)
      {
        i = 5;
        ((HashMap)localObject).put("param_enterType", i + "");
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "CMD_PRELOAD_NEARBY", true, this.adg, this.adh, (HashMap)localObject, "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("OpenNearbyAct timeout:");
          if (paramInt != 1) {
            break label321;
          }
          QLog.i("NearbyFakeActivity", 2, bool + ", mPreloadProcTime:" + this.adg);
        }
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyFakeActivity", 2, localException.getMessage(), localException);
          continue;
          if (paramInt == 1)
          {
            i = 6;
            continue;
            label321:
            bool = false;
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  public static void S(Context paramContext, Intent paramIntent)
  {
    boolean bool = arr();
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFakeActivity", 2, "openNearbyActWithPreLoad, isNearbyProcessExist=" + bool);
    }
    if (bool) {
      paramContext.startActivity(paramIntent);
    }
    try
    {
      anot.a(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_act_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      return;
    }
    catch (Exception paramContext) {}
    Intent localIntent = new Intent(paramContext, NearbyFakeActivity.class);
    localIntent.putExtra("intent", paramIntent);
    paramContext.startActivity(localIntent);
    try
    {
      anot.a(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_fake_act_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean arr()
  {
    return ahyj.isProcessExist("com.tencent.mobileqq:tool");
  }
  
  private void initLoadingView()
  {
    setTitle(acfp.m(2131708687));
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840663);
    this.rightViewImg.setEnabled(false);
    Drawable localDrawable = getResources().getDrawable(2130839655);
    TextView localTextView = (TextView)findViewById(2131379401);
    this.centerView.setCompoundDrawablePadding(10);
    this.centerView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    ((Animatable)localDrawable).start();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559686);
    initLoadingView();
    this.a = new NearbyResultReceiver(null);
    this.a.a(this);
    this.ah = ((Intent)getIntent().getParcelableExtra("intent"));
    this.mStartTime = System.currentTimeMillis();
    paramBundle = new Intent(this, NearbyReceiver.class);
    paramBundle.putExtra("nearby_preload_from", 2);
    paramBundle.putExtra("resultreceiver_nearbyfakeactivity", this.a);
    BaseApplicationImpl.getContext().sendBroadcast(paramBundle);
    if (QLog.isColorLevel()) {
      ajrk.f("NearbyFakeActivity", "trace", new Object[] { "NearbyFakeActivity.doOnCreate", Long.valueOf(this.mStartTime) });
    }
    int i = zsz.getDeviceType();
    if (i >= 2)
    {
      this.mHandler.sendEmptyMessageDelayed(0, 5000L);
      return true;
    }
    if (i >= 1)
    {
      this.mHandler.sendEmptyMessageDelayed(0, 6000L);
      return true;
    }
    this.mHandler.sendEmptyMessageDelayed(0, 8000L);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.a != null) {
      this.a.a(null);
    }
    this.mHandler.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
  
  public void dyG()
  {
    this.adg = (System.currentTimeMillis() - this.mStartTime);
    Rl(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFakeActivity
 * JD-Core Version:    0.7.0.1
 */