package com.tencent.tim.dingdong;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import aqge;
import aqlr;
import atni;
import atnk;
import atnq.a;
import atns;
import aupe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.TodoListActivity;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import jjl;
import jkg;

public class ScheduleTipsDialog
  extends BaseActivity
  implements View.OnClickListener
{
  private static final long[] v = { 100L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L };
  private TextView Am;
  private BroadcastReceiver X;
  private TextView afd;
  private TextView afe;
  private TextView aff;
  private LinkedHashMap<String, DingdongPluginDataFactory.ScheduleSummaryData> am = new LinkedHashMap();
  private atnq.a b = new atns(this);
  private String cHK;
  private String cHL;
  private boolean dio;
  private boolean hasAlarm;
  private boolean isAlive;
  private long mBeginTime;
  private long mEndTime;
  protected PowerManager.WakeLock mWakeLock;
  private TextView oq;
  private View sR;
  
  private void c(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    String str = paramScheduleSummaryData.id;
    long l1 = paramScheduleSummaryData.beginTime;
    long l2 = paramScheduleSummaryData.offsetTime;
    this.am.put(str, paramScheduleSummaryData);
    str = str + (l1 - l2);
    this.afe.setTag(str);
    this.aff.setTag(str);
    d(paramScheduleSummaryData);
    atni.aU("0X8007E3F", 0, 1);
  }
  
  private boolean cB(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (aqge.LR() != 0)
    {
      bool1 = bool2;
      if (!jkg.isCalling(paramContext)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean cC(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (aqge.LR() != 0)
    {
      bool1 = bool2;
      if (!jkg.isRingerVibrate(paramContext))
      {
        bool1 = bool2;
        if (!jkg.isRingEqualsZero(paramContext))
        {
          bool1 = bool2;
          if (!jkg.isCalling(paramContext)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void cOx()
  {
    this.am.clear();
    this.cHK = null;
  }
  
  private void d(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    if (paramScheduleSummaryData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ScheduleTipsDialog", 2, "updateNotificationContent is null ");
      }
      return;
    }
    this.cHK = paramScheduleSummaryData.id;
    this.mBeginTime = paramScheduleSummaryData.beginTime;
    this.mEndTime = paramScheduleSummaryData.endTime;
    this.cHL = paramScheduleSummaryData.todoId;
    q(this.oq, paramScheduleSummaryData.title);
    if (TextUtils.isEmpty(paramScheduleSummaryData.todoId))
    {
      q(this.afd, atni.f(paramScheduleSummaryData.beginTime, paramScheduleSummaryData.endTime, true));
      this.afd.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.aff.setText(2131719198);
    }
    for (;;)
    {
      q(this.Am, paramScheduleSummaryData.location);
      if ((this.Am == null) || (this.Am.getText().toString().length() > 0)) {
        break;
      }
      this.sR.setVisibility(8);
      return;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
      this.afd.setText(localSimpleDateFormat.format(new Date(paramScheduleSummaryData.beginTime)));
      this.afd.setCompoundDrawablesWithIntrinsicBounds(2130840127, 0, 0, 0);
      this.aff.setText(2131719200);
      aupe.L(this.app, "0X80091D4", 1);
    }
  }
  
  private void ef(Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool;
    do
    {
      Serializable localSerializable;
      do
      {
        return;
        localSerializable = paramIntent.getSerializableExtra("summaryinfo");
        this.dio = paramIntent.getBooleanExtra("isforeground", false);
      } while ((localSerializable == null) || (!(localSerializable instanceof DingdongPluginDataFactory.ScheduleSummaryData)));
      paramIntent = (DingdongPluginDataFactory.ScheduleSummaryData)localSerializable;
      bool = paramIntent.hasAlarm;
      c(paramIntent);
    } while (!bool);
    this.hasAlarm = true;
    gb(this);
    gc(this);
  }
  
  private void gb(Context paramContext)
  {
    if (cB(paramContext))
    {
      paramContext = (Vibrator)paramContext.getSystemService("vibrator");
      if (paramContext != null) {
        paramContext.vibrate(v, -1);
      }
    }
  }
  
  private void gc(Context paramContext)
  {
    if (cC(paramContext))
    {
      if (!jjl.cK("dingdong_schedule_notify.mp3")) {
        break label56;
      }
      aqge.a(Uri.fromFile(new File(jjl.hr() + "dingdong_schedule_notify.mp3")), 6, null);
    }
    label56:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ScheduleTipsDialog", 2, "startRing not download ");
      }
      paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ScheduleTipsDialog", 2, "tempApp is null ");
    return;
    jjl.y(paramContext);
  }
  
  private void gd(Context paramContext)
  {
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext != null) {
      paramContext.cancel();
    }
    aqge.bVz();
  }
  
  private void initView()
  {
    this.oq = ((TextView)findViewById(2131380976));
    this.afd = ((TextView)findViewById(2131380765));
    this.Am = ((TextView)findViewById(2131380792));
    this.afe = ((TextView)findViewById(2131365852));
    this.aff = ((TextView)findViewById(2131365858));
    this.sR = findViewById(2131370853);
    this.afe.setOnClickListener(this);
    this.aff.setOnClickListener(this);
  }
  
  private void k(Window paramWindow)
  {
    if (cA(this)) {
      paramWindow.addFlags(524288);
    }
    for (;;)
    {
      paramWindow.addFlags(2097152);
      paramWindow.addFlags(256);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        paramWindow.addFlags(4194304);
      } else {
        paramWindow.addFlags(4718592);
      }
    }
  }
  
  private void q(TextView paramTextView, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setText(paramString);
    paramTextView.setVisibility(0);
  }
  
  @TargetApi(16)
  public boolean cA(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      try
      {
        KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
        if (QLog.isColorLevel()) {
          QLog.e("ScheduleTipsDialog", 2, "isKeyguardLocked = " + localKeyguardManager.isKeyguardLocked() + ". isKeyguardSecure =" + localKeyguardManager.isKeyguardSecure());
        }
        if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
        {
          boolean bool = localKeyguardManager.isKeyguardSecure();
          if (bool) {
            return true;
          }
        }
        return false;
      }
      catch (SecurityException localSecurityException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ScheduleTipsDialog", 2, "isKeyguardLocked() = " + localSecurityException);
        }
        return aqlr.isScreenLocked(paramContext);
      }
    }
    return aqlr.isScreenLocked(paramContext);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.isAlive = true;
    k(getWindow());
    setContentView(2131559241);
    ((atnk)this.app.getManager(115)).a(this.b);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.X = new a();
    super.registerReceiver(this.X, paramBundle);
    this.mWakeLock = ((PowerManager)getSystemService("power")).newWakeLock(268435462, "ScheduleTipsDialog");
    this.mWakeLock.acquire(5000L);
    initView();
    ef(getIntent());
    return true;
  }
  
  public void doOnDestroy()
  {
    this.isAlive = false;
    if (this.X != null)
    {
      super.unregisterReceiver(this.X);
      this.X = null;
    }
    ((atnk)this.app.getManager(115)).eui();
    if (this.hasAlarm) {
      gd(this);
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772002, 0);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2131365852: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        atni.aU("0X8007E41", 0, 1);
        atni.gN("0X800652E", 1);
        if (!TextUtils.isEmpty(this.cHL)) {
          aupe.L(this.app, "0X80091D5", 1);
        }
        this.am.remove(this.cHK);
        if (this.am.size() > 0)
        {
          Iterator localIterator = this.am.keySet().iterator();
          for (localObject = null; localIterator.hasNext(); localObject = (String)localIterator.next()) {}
          d((DingdongPluginDataFactory.ScheduleSummaryData)this.am.get(localObject));
        }
        else
        {
          cOx();
          finish();
        }
      }
    }
    atni.aU("0X8007E40", 0, 1);
    atni.gN("0X800652D", 1);
    if (TextUtils.isEmpty(this.cHL))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("schedule_feed_id", this.cHK);
      ((Intent)localObject).putExtra("schedule_begin_time", this.mBeginTime);
      ((Intent)localObject).putExtra("schedule_end_time", this.mEndTime);
      ((Intent)localObject).putExtra("schedule_create_form_reminder_bool", true);
      if (this.dio)
      {
        ((Intent)localObject).putExtra("schedule_need_update_bool", true);
        atni.startPluginActivityForResult(this, "com.dingdong.business.Schedule.Activity.ScheduleDetailActivity", (Intent)localObject, -1);
      }
    }
    for (;;)
    {
      cOx();
      finish();
      break;
      ((Intent)localObject).putExtra("from_url", true);
      ((Intent)localObject).putExtra("schedule_need_update_bool", false);
      atni.startPluginActivityForResult(this, "com.dingdong.business.Schedule.Activity.ScheduleListActivity", (Intent)localObject, -1);
      continue;
      localObject = new Intent(this, TodoListActivity.class);
      ((Intent)localObject).putExtra("highlight_todo_id", this.cHL);
      startActivity((Intent)localObject);
      aupe.L(this.app, "0X80091D6", 1);
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
      {
        paramContext = paramIntent.getStringExtra("reason");
        if ((paramContext != null) && (paramContext.equals("homekey")) && (ScheduleTipsDialog.a(ScheduleTipsDialog.this))) {
          ScheduleTipsDialog.a(ScheduleTipsDialog.this, ScheduleTipsDialog.this);
        }
      }
      while ((!paramContext.equals("android.intent.action.SCREEN_OFF")) || (!ScheduleTipsDialog.a(ScheduleTipsDialog.this))) {
        return;
      }
      ScheduleTipsDialog.a(ScheduleTipsDialog.this, ScheduleTipsDialog.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.dingdong.ScheduleTipsDialog
 * JD-Core Version:    0.7.0.1
 */