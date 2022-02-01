package com.tencent.mobileqq.msgbackup.fragment;

import ajdt;
import ajdu;
import ajea;
import ajee;
import ajer;
import ajev;
import ajfa;
import ajfb;
import ajfc;
import ajgp;
import ajgu;
import ajgv;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqha;
import aqju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MsgBackupBaseFragment
  extends IphoneTitleBarFragment
  implements ajea, Handler.Callback, View.OnClickListener
{
  protected ImageView Bb;
  protected ImageView Bc;
  protected ImageView Bd;
  public TextView UG;
  protected TextView UH;
  protected TextView UI;
  protected TextView UJ;
  protected TextView UK;
  protected ajdu a = new ajfa(this);
  protected FormSimpleItem aG;
  protected FormSimpleItem aH;
  public long ach;
  protected long aci;
  protected ProgressBar aj;
  protected ProgressBar ak;
  protected boolean cnT;
  public boolean cnU;
  public int diq;
  protected int dix = -1;
  public int diy;
  public int diz = 2;
  protected Button gI;
  public Button gJ;
  protected Runnable ha = new MsgBackupBaseFragment.1(this);
  protected Runnable hb = new MsgBackupBaseFragment.3(this);
  protected Runnable hc = new MsgBackupBaseFragment.6(this);
  protected boolean isCompleted;
  public boolean isStart;
  protected LinearLayout jj;
  protected LinearLayout jk;
  protected LinearLayout jl;
  protected LinearLayout jm;
  protected LinearLayout jn;
  protected ProgressBar mProgressBar;
  public int mTotalCount;
  protected MqqHandler mUIHandler;
  protected MqqHandler t;
  
  private void initUI()
  {
    this.aG = ((FormSimpleItem)this.mContentView.findViewById(2131376962));
    this.aH = ((FormSimpleItem)this.mContentView.findViewById(2131376955));
    this.jj = ((LinearLayout)this.mContentView.findViewById(2131371517));
    this.jk = ((LinearLayout)this.mContentView.findViewById(2131375290));
    this.jl = ((LinearLayout)this.mContentView.findViewById(2131371515));
    this.jm = ((LinearLayout)this.mContentView.findViewById(2131371509));
    this.gI = ((Button)this.mContentView.findViewById(2131371510));
    this.Bb = ((ImageView)this.mContentView.findViewById(2131371514));
    this.UG = ((TextView)this.mContentView.findViewById(2131371513));
    this.UH = ((TextView)this.mContentView.findViewById(2131371522));
    this.Bc = ((ImageView)this.mContentView.findViewById(2131375291));
    this.aj = ((ProgressBar)this.mContentView.findViewById(2131370799));
    this.jn = ((LinearLayout)this.mContentView.findViewById(2131372272));
    this.UI = ((TextView)this.mContentView.findViewById(2131372271));
    this.Bd = ((ImageView)this.mContentView.findViewById(2131371519));
    this.UJ = ((TextView)this.mContentView.findViewById(2131371518));
    this.UK = ((TextView)this.mContentView.findViewById(2131371520));
    this.gJ = ((Button)this.mContentView.findViewById(2131371521));
    this.mProgressBar = ((ProgressBar)this.mContentView.findViewById(2131380168));
    this.ak = ((ProgressBar)this.mContentView.findViewById(2131378712));
  }
  
  public void LT(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "netConnectionState!!! isConnected = " + paramBoolean);
    }
    this.cnT = paramBoolean;
    if (paramBoolean) {
      return;
    }
    this.aci = SystemClock.elapsedRealtime();
  }
  
  public void LU(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "transportStart！------------->isStart = " + paramBoolean);
    }
    Message localMessage = this.mUIHandler.obtainMessage(10011);
    this.mUIHandler.sendMessage(localMessage);
    ajgu.reset();
    ajgu.track(null, "total_transport_cost");
  }
  
  public void a(ajer paramajer) {}
  
  public void a(ajev paramajev) {}
  
  protected void aZv()
  {
    initProgress();
    if (this.dix != 4) {
      ajee.cnJ = false;
    }
    ajee.cnG = false;
  }
  
  protected void asB()
  {
    Object localObject = getActivity().app;
    ajgv.b("MsgBackup.MsgBackupBaseFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", new Object[] { Boolean.valueOf(((QQAppInterface)localObject).isBackground_Stop), Boolean.valueOf(((QQAppInterface)localObject).isBackground_Pause) });
    if ((((QQAppInterface)localObject).isBackground_Pause) || (((QQAppInterface)localObject).isBackground_Stop))
    {
      ajgv.b("MsgBackup.MsgBackupBaseFragment", "fight notification start ....", new Object[0]);
      localObject = new Intent(BaseApplicationImpl.getContext(), SplashActivity.class);
      ((Intent)localObject).putExtra("param_notifyid", 524);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130842268).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
      localBuilder.setContentText("QQ正在进行聊天记录迁移，请保持QQ在前台显示。").setContentIntent((PendingIntent)localObject);
      localObject = localBuilder.build();
      QQNotificationManager.getInstance().notify("MsgBackup", 524, (Notification)localObject);
    }
  }
  
  public void bC(boolean paramBoolean, Object paramObject) {}
  
  protected void bindData() {}
  
  public void ca(Activity paramActivity)
  {
    PublicFragmentActivity.start(paramActivity, new Intent(), MsgBackupWelcomeFragment.class);
    if (paramActivity != null)
    {
      paramActivity.setResult(1001);
      paramActivity.finish();
    }
    ajee.a().onDestroy();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    initTitle();
    initUI();
    aZv();
    kJ();
    bindData();
  }
  
  protected void dwL()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    ajee.a().a().exit();
    ajgp.b().onDestroy();
    aqha.b(localFragmentActivity, 0, localFragmentActivity.getString(2131690750), localFragmentActivity.getString(2131690749), localFragmentActivity.getString(2131690789), localFragmentActivity.getString(2131690788), new ajfb(this), new ajfc(this)).show();
  }
  
  public void dwM()
  {
    ajee.a().onDestroy();
    dwN();
  }
  
  protected void dwN()
  {
    if (ajgp.b().getRole() == 2)
    {
      MsgBackupCompleteFragment.m(getActivity(), this.mTotalCount, this.diq);
      return;
    }
    MsgBackupCompleteFragment.o(getActivity(), this.mTotalCount, this.diq);
  }
  
  protected void dwO() {}
  
  public void exit(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "对端退出了！------------->isExit!!!");
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561664;
  }
  
  protected long gk()
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (localActivityManager != null) {
      localActivityManager.getMemoryInfo(localMemoryInfo);
    }
    return localMemoryInfo.availMem / 1024L;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (getActivity() == null) {
      ajgv.b("MsgBackup.MsgBackupBaseFragment", "activity is null------------->", new Object[0]);
    }
    do
    {
      return false;
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 10009: 
        this.cnU = true;
        dwO();
        return false;
      case 10010: 
        dwL();
        return false;
      }
    } while (this.ak == null);
    this.ak.setVisibility(8);
    return false;
  }
  
  public void iC(int paramInt1, int paramInt2)
  {
    ajgv.c("MsgBackup.MsgBackupBaseFragment", "isCompleted = %b, finishedSessions = %d, totalSession = %d", new Object[] { Boolean.valueOf(this.isCompleted), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == paramInt2)
    {
      ajgu.track("total_transport_cost", null);
      ajgu.dxv();
    }
  }
  
  public void iD(int paramInt1, int paramInt2) {}
  
  protected void initProgress()
  {
    if (this.mProgressBar != null) {
      this.mProgressBar.setMax(100);
    }
  }
  
  protected void initTitle() {}
  
  protected void kJ() {}
  
  public void kg(long paramLong)
  {
    ajgv.c("MsgBackup.MsgBackupBaseFragment", "speedState------> increment = " + paramLong, new Object[0]);
  }
  
  public void m(Integer paramInteger) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((1000 == paramInt1) && (paramInt2 == 1001))
    {
      if (getActivity() != null) {
        getActivity().setResult(1001);
      }
      onBackEvent();
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUIHandler = new MqqHandler(this);
    this.t = new MqqHandler(ThreadManager.getSubThreadLooper());
    this.diy = ajdt.a().Gi();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "toPage = " + this.dix + "; mBizType = " + this.diy);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.t.removeCallbacks(this.hb);
    this.t.removeCallbacks(this.hc);
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void setViewText(TextView paramTextView, String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (paramTextView != null)
      {
        paramTextView.setText(paramString);
        paramTextView.setVisibility(0);
      }
      return;
    }
    this.mUIHandler.post(new MsgBackupBaseFragment.7(this, paramTextView, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
 * JD-Core Version:    0.7.0.1
 */