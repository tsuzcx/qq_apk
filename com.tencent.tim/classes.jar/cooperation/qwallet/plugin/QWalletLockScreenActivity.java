package cooperation.qwallet.plugin;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqlr;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.Foreground;

public class QWalletLockScreenActivity
  extends AppActivity
  implements View.OnClickListener
{
  public static final String FROM_WALLET_UNLOCK = "key_wallet_unlock";
  public static int lsActivity_count;
  private final int MSG_FINISH_ACTIVITY = 2;
  private final int MSG_START_UNLOCKACTIVITY = 9;
  private QQAppInterface app;
  String content;
  TextView contentView;
  private Handler handler = new QWalletLockScreenActivity.1(this, Looper.getMainLooper());
  private RelativeLayout mBackBtn;
  ScreenBroadcastReceiver mScreenReceiver;
  String time;
  TextView timeView;
  String title;
  TextView titleView;
  
  @TargetApi(16)
  private boolean isKeyguardLock()
  {
    if ((Build.VERSION.SDK_INT == 20) && (Build.VERSION.RELEASE.equals("L"))) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.push", 2, "QWalletLockScreenActivity isKeyguardLock SDK is androidL !");
      }
    }
    for (;;)
    {
      return true;
      if (Build.VERSION.SDK_INT >= 16) {
        try
        {
          KeyguardManager localKeyguardManager = (KeyguardManager)getSystemService("keyguard");
          if (QLog.isColorLevel()) {
            QLog.e("Q.qwallet.push", 2, "QWalletLockScreenActivity kgm.isKeyguardLocked()=" + localKeyguardManager.isKeyguardLocked() + ". kgm.isKeyguardSecure()=" + localKeyguardManager.isKeyguardSecure());
          }
          if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
          {
            bool = localKeyguardManager.isKeyguardSecure();
            if (!bool) {}
          }
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (SecurityException localSecurityException) {}
      }
    }
    QLog.e("Q.qwallet.push", 2, "QWalletLockScreenActivity kgm.isKeyguardLocked()=" + localSecurityException);
    return true;
  }
  
  private void registerListener()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    registerReceiver(this.mScreenReceiver, localIntentFilter);
  }
  
  private void unlockAndStartPayBridgeActivity()
  {
    boolean bool = isKeyguardLock();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity isKeyGuardLock=" + bool);
    }
    if (!bool)
    {
      Intent localIntent = new Intent(this, QQLSUnlockActivity.class);
      localIntent.putExtra("key_wallet_unlock", true);
      startActivity(localIntent);
      return;
    }
    moveTaskToBack(true);
    finish();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity onBackPressed=== ");
    }
    if (!isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity onBackPressed not finish ");
      }
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnCreate taskId" + getTaskId() + Thread.currentThread().getId());
    }
    setContentView(2131562192);
    getWindow().addFlags(524288);
    this.mScreenReceiver = new ScreenBroadcastReceiver(null);
    registerListener();
    this.app = ((QQAppInterface)getAppRuntime());
    if (this.app == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity app null,  finish");
      }
      finish();
    }
    do
    {
      return true;
      this.title = getIntent().getStringExtra("title");
      this.content = getIntent().getStringExtra("content");
      this.time = getIntent().getStringExtra("time");
      this.titleView = ((TextView)findViewById(2131379783));
      this.contentView = ((TextView)findViewById(2131374920));
      this.timeView = ((TextView)findViewById(2131374925));
      this.titleView.setText(this.title);
      this.contentView.setText(this.content);
      this.timeView.setText(this.time);
      this.mBackBtn = ((RelativeLayout)findViewById(2131363823));
      this.mBackBtn.setOnClickListener(this);
      this.contentView.setOnClickListener(this);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity new brightWakeLock");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mScreenReceiver != null) {
      unregisterReceiver(this.mScreenReceiver);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Object localObject = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnPause by :" + (String)localObject);
      }
      if ("com.tencent.mobileqq.activity.GesturePWDUnlockActivity".equals(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnPause by locking activity need to front");
        }
        localObject = new Intent(this, QWalletLockScreenActivity.class);
        ((Intent)localObject).addFlags(131072);
        startActivity((Intent)localObject);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnPause taskId" + getTaskId());
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    boolean bool = aqlr.isScreenLocked(this);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity doOnStart isScreenLocked=" + bool);
    }
    if (!bool) {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Message localMessage = this.handler.obtainMessage(9);
      Handler localHandler = this.handler;
      if (GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) {}
      for (long l = 500L;; l = 0L)
      {
        localHandler.sendMessageDelayed(localMessage, l);
        break;
      }
      localMessage = this.handler.obtainMessage(2);
      this.handler.sendMessageDelayed(localMessage, 1500L);
    }
  }
  
  public void onStart()
  {
    Foreground.sCountActivity -= 1;
    super.onStart();
  }
  
  public void onStop()
  {
    Foreground.sCountActivity += 1;
    super.onStop();
  }
  
  class ScreenBroadcastReceiver
    extends BroadcastReceiver
  {
    private String action;
    
    private ScreenBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      this.action = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(this.action)) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity ACTION_SCREEN_ON");
        }
      }
      do
      {
        do
        {
          return;
          if (!"android.intent.action.SCREEN_OFF".equals(this.action)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity ACTION_SCREEN_OFF");
        return;
      } while ((!"android.intent.action.USER_PRESENT".equals(this.action)) || (!QLog.isColorLevel()));
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity ACTION_USER_PRESENT");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletLockScreenActivity
 * JD-Core Version:    0.7.0.1
 */