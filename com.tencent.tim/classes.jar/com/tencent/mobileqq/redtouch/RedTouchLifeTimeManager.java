package com.tencent.mobileqq.redtouch;

import altp;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import awmu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.UEC;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class RedTouchLifeTimeManager
  extends BroadcastReceiver
{
  private static RedTouchLifeTimeManager a;
  private String Uv;
  private boolean aQJ;
  private long ahH;
  private String bYh;
  private String bYi;
  Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks = new altp(this);
  private String mTraceId;
  
  private RedTouchLifeTimeManager()
  {
    register();
  }
  
  public static RedTouchLifeTimeManager a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new RedTouchLifeTimeManager();
      }
      return a;
    }
    finally {}
  }
  
  private void dJE()
  {
    if (!this.aQJ) {
      return;
    }
    this.aQJ = false;
    long l = System.currentTimeMillis() - this.ahH;
    QLog.i("RedTouchLifeTimeManager", 1, "triggleReport time = " + l + " class name " + this.bYh);
    awmu localawmu = new awmu();
    localawmu.mActionId = 133;
    localawmu.eBB = ((int)l);
    localawmu.cNR = String.valueOf(this.Uv);
    localawmu.mTraceId = String.valueOf(this.mTraceId);
    localawmu.eBX = 1;
    localawmu.aBn = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
    localawmu.mAppId = "vab_red";
    localawmu.cNQ = "vab_red";
    ThreadManager.getSubThreadHandler().post(new RedTouchLifeTimeManager.1(this, localawmu));
  }
  
  private void register()
  {
    UEC.a().a(this.mActivityLifecycleCallbacks);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.plugin.state.change");
    BaseApplicationImpl.getApplication().registerReceiver(this, localIntentFilter);
  }
  
  public void OQ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.Uv = paramString.getString("ad_id");
      this.mTraceId = paramString.getString("trace_id");
      this.aQJ = true;
      this.ahH = System.currentTimeMillis();
      if ((TextUtils.isEmpty(this.bYh)) && (Foreground.getTopActivity() != null)) {
        this.bYh = Foreground.getTopActivity().getClass().getName();
      }
      this.bYi = this.bYh;
      QLog.i("RedTouchLifeTimeManager", 1, " triggleWhenRedClick class name " + this.bYh);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("RedTouchLifeTimeManager", 1, "triggleWhenRedClick" + paramString);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {}
    while ((!"com.tencent.plugin.state.change".equals(paramContext)) || (paramIntent.getIntExtra("key_plugin_state", 0) != 0)) {
      return;
    }
    QLog.i("RedTouchLifeTimeManager", 1, "[onReceive] bg action");
    dJE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager
 * JD-Core Version:    0.7.0.1
 */