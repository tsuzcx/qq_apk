package com.tencent.mobileqq.msgbackup.fragment;

import ajdt;
import ajea;
import ajee;
import ajek;
import ajew;
import ajfd;
import ajfe;
import ajgp;
import ajgt;
import ajgu;
import ajgv;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqha;
import aqju;
import aqnm;
import arkn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class MsgBackupCompleteFragment
  extends IphoneTitleBarFragment
  implements ajea, Handler.Callback, View.OnClickListener, arkn
{
  private TextView Ai;
  private View EE;
  private View EF;
  private TextView UL;
  private boolean cnI;
  private boolean cnV;
  private boolean cnW;
  private boolean cnX;
  private int diA;
  private int diB;
  private Button gK;
  private Button gL;
  private int mPageType;
  private ProgressBar mProgressBar;
  private MqqHandler mUIHandler;
  private ImageView me;
  private TextView vq;
  
  private static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a(paramContext, paramInt1, paramInt2, paramInt3, false, false, paramBoolean);
  }
  
  private static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ajgv.b("MsgBackupCompleteFragment", "go is called! isfromMsgTab = %b, auto = %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    Intent localIntent;
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      localIntent = new Intent();
      localIntent.putExtra("import_total_count", paramInt1);
      localIntent.putExtra("import_finish_count", paramInt2);
      localIntent.putExtra("page_type", paramInt3);
      localIntent.putExtra("auto_import_key", paramBoolean1);
      localIntent.putExtra("is_from_pc_handle", paramBoolean3);
      if (paramBoolean2) {
        PublicFragmentActivity.start(paramContext, localIntent, MsgBackupCompleteFragment.class);
      }
    }
    else
    {
      return;
    }
    PublicFragmentActivity.startForResult(paramContext, localIntent, MsgBackupCompleteFragment.class, 1000);
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramInt1, paramInt2, 3, paramBoolean);
  }
  
  private void dwP()
  {
    Bundle localBundle = getArguments();
    this.mPageType = localBundle.getInt("page_type", 0);
    this.cnW = localBundle.getBoolean("auto_import_key", false);
    this.diA = localBundle.getInt("import_total_count", this.diA);
    this.diB = localBundle.getInt("import_finish_count", this.diB);
    ajgt.dxs();
    ajgt.a.acr = this.diB;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupCompleteFragment", 2, "handlerArg, page type = " + this.mPageType + " ;import total count = " + this.diA + "; finish count = " + this.diB);
    }
    if (this.mPageType == 0) {
      ajgt.report("0X800A240");
    }
  }
  
  private void dwQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupCompleteFragment", 2, "startImport is called!");
    }
    ajgu.acL = 0L;
    ajgu.track(null, "total_daoru_cost");
    this.cnV = true;
    this.vg.setRightButton(2131689655);
    Object localObject = ajee.a().ga;
    if ((localObject == null) || (((ConcurrentHashMap)localObject).size() == 0)) {
      QQToast.a(getActivity(), "no session to import", 0).show();
    }
    HashSet localHashSet;
    do
    {
      return;
      localHashSet = new HashSet();
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajew localajew = (ajew)((Iterator)localObject).next();
        if (localajew.isCompleted)
        {
          MsgBackupMsgUserData localMsgBackupMsgUserData = new MsgBackupMsgUserData();
          localMsgBackupMsgUserData.uin = localajew.uin;
          localMsgBackupMsgUserData.uinType = localajew.uinType;
          localHashSet.add(localMsgBackupMsgUserData);
        }
      }
      if (localHashSet.size() != 0) {
        break;
      }
      ajgv.c("MsgBackupCompleteFragment", "no session is completed!--------so jump completed page!", new Object[0]);
      if (this.mPageType == 1)
      {
        r(getActivity(), ajee.dio, this.diB);
        return;
      }
    } while (this.mPageType != 4);
    t(getActivity(), ajee.dio, this.diB);
    return;
    ajee.a().ga.clear();
    localObject = new ajek();
    ((ajek)localObject).dir = 2;
    ((ajek)localObject).bj = localHashSet;
    ((ajek)localObject).totalCount = localHashSet.size();
    ajee.a().a(this);
    ajee.a().f((ajek)localObject);
  }
  
  private void dwR()
  {
    if (getActivity() != null)
    {
      ajee.a().onDestroy();
      if (getActivity() != null)
      {
        getActivity().setResult(1001);
        getActivity().finish();
      }
    }
  }
  
  private void dwS()
  {
    if (this.cnV)
    {
      if (this.mPageType == 1) {
        ajgt.cN("0X800A252", 5);
      }
      for (;;)
      {
        dwT();
        return;
        if ((this.mPageType == 4) && (this.cnI)) {
          ajgt.cN("0X800A266", 2);
        }
      }
    }
    dwR();
  }
  
  private void dwT()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    aqha.b(getActivity(), 0, localFragmentActivity.getString(2131690774), localFragmentActivity.getString(2131690773), localFragmentActivity.getString(2131690783), localFragmentActivity.getString(2131690772), new ajfd(this), new ajfe(this)).show();
  }
  
  private void hc(View paramView)
  {
    this.EE = paramView.findViewById(2131371517);
    this.EF = paramView.findViewById(2131371515);
    this.me = ((ImageView)paramView.findViewById(2131371514));
    this.Ai = ((TextView)paramView.findViewById(2131371513));
    this.vq = ((TextView)paramView.findViewById(2131371522));
    this.gK = ((Button)paramView.findViewById(2131371510));
    this.gL = ((Button)paramView.findViewById(2131371521));
    this.UL = ((TextView)paramView.findViewById(2131380927));
    this.mProgressBar = ((ProgressBar)paramView.findViewById(2131372945));
  }
  
  private void iE(int paramInt1, int paramInt2)
  {
    if (getActivity() == null) {
      return;
    }
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      this.vg.setOnItemSelectListener(this);
      this.me.setImageResource(2130842116);
      String str = getString(2131690777, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      this.Ai.setText(str);
      if (ajdt.a().Gi() == 3) {
        this.vq.setText(2131690737);
      }
      for (;;)
      {
        aqnm.setVisible(this.gK, 8);
        if ((paramInt2 <= 0) || (this.mProgressBar == null)) {
          break;
        }
        paramInt1 = paramInt1 * 100 / paramInt2;
        aqnm.setVisible(this.mProgressBar, 0);
        this.mProgressBar.setProgress(paramInt1);
        return;
        this.vq.setText(2131690737);
      }
    }
  }
  
  private void iF(int paramInt1, int paramInt2)
  {
    if (getActivity() == null) {
      return;
    }
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      this.vg.setOnItemSelectListener(this);
      this.me.setImageResource(2130842118);
      String str = getString(2131690777, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      this.Ai.setText(str);
      if (ajdt.a().Gi() == 3) {
        this.vq.setText(2131690737);
      }
      for (;;)
      {
        aqnm.setVisible(this.gK, 8);
        if ((paramInt2 <= 0) || (this.mProgressBar == null)) {
          break;
        }
        paramInt1 = paramInt1 * 100 / paramInt2;
        aqnm.setVisible(this.mProgressBar, 0);
        this.mProgressBar.setProgress(paramInt1);
        return;
        this.vq.setText(2131690737);
      }
    }
  }
  
  private void iG(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupCompleteFragment", 2, "auto import ------> initImportPage!!! finishedCount = " + paramInt1 + ", total" + paramInt2 + ", mPageType = " + this.mPageType);
    }
    if (!isDetached())
    {
      Message localMessage = this.mUIHandler.obtainMessage(1);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      this.mUIHandler.sendMessage(localMessage);
    }
  }
  
  private void init()
  {
    aqnm.setVisible(this.EE, 8);
    aqnm.setVisible(this.EF, 0);
    aqnm.setVisible(this.gK, 8);
    aqnm.setVisible(this.gL, 0);
    if (!this.cnW) {
      this.me.setImageResource(2130842113);
    }
    this.vg.setTitle(getString(2131690732));
    this.vg.setLeftBackVisible(8);
    switch (this.mPageType)
    {
    default: 
      return;
    case 0: 
      aqnm.setVisible(this.gL, 0);
      aqnm.setVisible(this.gK, 8);
      this.vg.setTitle(getString(2131690732));
      this.Ai.setText(2131690775);
      this.vq.setText(getString(2131690776, new Object[] { Integer.valueOf(this.diB), Integer.valueOf(this.diA) }));
      return;
    case 1: 
      this.vg.setTitle(getString(2131690732));
      aqnm.setVisible(this.gL, 8);
      if (this.cnW)
      {
        iG(0, this.diA);
        dwQ();
      }
      for (;;)
      {
        this.vg.setOnItemSelectListener(this);
        return;
        aqnm.setVisible(this.gK, 0);
        this.vg.setRightButton(2131689655);
        this.Ai.setText(2131690782);
        i = this.diB;
        j = ajee.din;
        this.vq.setText(getString(2131690739, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.diA) }));
        this.gK.setText(2131690778);
        if (AppSetting.enableTalkBack) {
          this.gK.setContentDescription(getString(2131690778));
        }
        ajgt.report("0X800A24B");
      }
    case 2: 
      this.vg.setTitle(getString(2131690732));
      aqnm.setVisible(this.gL, 0);
      aqnm.setVisible(this.gK, 8);
      i = this.diB;
      j = ajee.din;
      ajgv.b("MsgBackupCompleteFragment", "TYPE_PHONE_IMPORT_COMPLETE ----> mImportFinishCount = %d, sSkipSessionCount = %d", new Object[] { Integer.valueOf(this.diB), Integer.valueOf(ajee.din) });
      this.Ai.setText(2131690779);
      this.vq.setText(getString(2131690760, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.diA) }));
      ajgt.report("0X800A24F");
      return;
    case 3: 
      this.vg.setTitle(getString(2131690706));
      aqnm.setVisible(this.gL, 0);
      aqnm.setVisible(this.gK, 8);
      aqnm.setVisible(this.UL, 0);
      this.Ai.setText(2131690769);
      this.vq.setText(getString(2131690801, new Object[] { Integer.valueOf(this.diB), Integer.valueOf(this.diA) }));
      this.vg.setOnItemSelectListener(this);
      ajgt.report("0X800A262");
      return;
    case 4: 
      this.vg.setTitle(getString(2131690703));
      aqnm.setVisible(this.gL, 8);
      if (this.cnW)
      {
        this.vg.setRightViewTextVisible(8);
        iG(0, this.diA);
        dwQ();
        return;
      }
      this.gK.setText(2131690778);
      if (AppSetting.enableTalkBack) {
        this.gK.setContentDescription(getString(2131690778));
      }
      aqnm.setVisible(this.gK, 0);
      this.vg.setRightButton(2131689655);
      this.Ai.setText(2131690782);
      i = this.diB;
      j = ajee.din;
      this.vq.setText(getString(2131690739, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.diA) }));
      this.vg.setOnItemSelectListener(this);
      return;
    }
    this.vg.setTitle(getString(2131690703));
    aqnm.setVisible(this.gL, 0);
    aqnm.setVisible(this.gK, 8);
    int i = this.diB;
    int j = ajee.din;
    ajgv.b("MsgBackupCompleteFragment", "TYPE_PC_IMPORT_COMPLETED ----> mImportFinishCount = %d, sSkipSessionCount = %d", new Object[] { Integer.valueOf(this.diB), Integer.valueOf(ajee.din) });
    this.Ai.setText(2131690770);
    this.vq.setText(getString(2131690802, new Object[] { Integer.valueOf(i - j), Integer.valueOf(this.diA) }));
    ajgt.report("0X800A286");
  }
  
  public static void m(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 0, false);
  }
  
  public static void n(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 0, false, true, false);
  }
  
  public static void o(Context paramContext, int paramInt1, int paramInt2)
  {
    ajgv.b("MsgBackupCompleteFragment", "tranfer not auto completed! so display whether import page!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 1, false);
  }
  
  public static void p(Context paramContext, int paramInt1, int paramInt2)
  {
    ajgv.b("MsgBackupCompleteFragment", "tranfer auto completed! so auto import data!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 1, true, false, false);
  }
  
  public static void q(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 1, true, true, false);
  }
  
  public static void r(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 2, false);
  }
  
  public static void s(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 3, false, true, ajee.cnI);
  }
  
  private void setListener()
  {
    this.gL.setOnClickListener(this);
    this.UL.setOnClickListener(this);
    this.gK.setOnClickListener(this);
  }
  
  public static void t(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 5, false);
  }
  
  public static void u(Context paramContext, int paramInt1, int paramInt2)
  {
    ajgv.b("MsgBackupCompleteFragment", "restore not auto completed! so display whether import page!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 4, false);
  }
  
  public static void v(Context paramContext, int paramInt1, int paramInt2)
  {
    ajgv.b("MsgBackupCompleteFragment", "restore auto completed! so auto import data!", new Object[0]);
    a(paramContext, paramInt1, paramInt2, 4, true, false, false);
  }
  
  public static void w(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, 4, true, true, false);
  }
  
  public void LT(boolean paramBoolean) {}
  
  public void LU(boolean paramBoolean) {}
  
  protected void asB()
  {
    Object localObject = getActivity().app;
    ajgv.b("MsgBackupCompleteFragment", "fight notification start ..app.isBackground_Stop =%b.app,.isBackground_Pause = %b,.", new Object[] { Boolean.valueOf(((QQAppInterface)localObject).isBackground_Stop), Boolean.valueOf(((QQAppInterface)localObject).isBackground_Pause) });
    if ((((QQAppInterface)localObject).isBackground_Pause) || (((QQAppInterface)localObject).isBackground_Stop))
    {
      ajgv.b("MsgBackupCompleteFragment", "fight notification start ....", new Object[0]);
      localObject = new Intent(BaseApplicationImpl.getContext(), SplashActivity.class);
      ((Intent)localObject).putExtra("param_notifyid", 524);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_OTHER").setSmallIcon(2130842268).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
      localBuilder.setContentText("QQ正在进行聊天记录迁移，请保持QQ在前台显示。").setContentIntent((PendingIntent)localObject);
      localObject = localBuilder.build();
      QQNotificationManager.getInstance().notify("MsgBackup", 524, (Notification)localObject);
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      dwS();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void exit(boolean paramBoolean) {}
  
  public int getContentLayoutId()
  {
    return 2131561664;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      if (i == j)
      {
        ajgu.track("total_daoru_cost", null);
        if (this.mPageType == 1) {
          r(getActivity(), i, i);
        } else if (this.mPageType == 4) {
          t(getActivity(), i, i);
        }
      }
      else if (this.mPageType == 1)
      {
        iE(i, j);
      }
      else if (this.mPageType == 4)
      {
        iF(i, j);
      }
    }
  }
  
  public void iC(int paramInt1, int paramInt2) {}
  
  public void iD(int paramInt1, int paramInt2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupCompleteFragment", 2, "importProgress!!! finishedCount = " + paramInt1 + ", total" + paramInt2 + ", mPageType = " + this.mPageType);
    }
    if (!isDetached())
    {
      Message localMessage = this.mUIHandler.obtainMessage(1);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      this.mUIHandler.sendMessage(localMessage);
    }
    if ((this.mPageType == 1) && (!this.cnX)) {
      if (!this.cnW) {
        break label133;
      }
    }
    label133:
    for (paramInt1 = i;; paramInt1 = 1)
    {
      ajgt.cN("0X800A24E", paramInt1);
      this.cnX = true;
      return;
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void kg(long paramLong) {}
  
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click migrate button!");
      }
      dwQ();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click sure btn!");
      }
      dwR();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupCompleteFragment", 2, "completed page, click space clean btn!");
      }
      ajgt.report("0X800A263");
      ajee.a().onDestroy();
      Intent localIntent = new Intent();
      localIntent.putExtra("set_display_type", 1);
      PublicFragmentActivity.start(getActivity(), localIntent, QQSettingMsgClearFragment.class);
      if (getActivity() != null)
      {
        getActivity().setResult(1001);
        getActivity().finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUIHandler = new MqqHandler(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ajee.a().a(null);
    ajgv.b("MsgBackupCompleteFragment", "onDestroyView is from page = %d", new Object[] { Integer.valueOf(this.mPageType) });
    ajee.a().onDestroy();
    ajee.a().dwG();
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130772157);
    }
  }
  
  public void onItemSelect(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    dwS();
  }
  
  public void onPause()
  {
    super.onPause();
    ajee.a().bZ(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    ajee.a().bY(getActivity());
  }
  
  public void onStop()
  {
    asB();
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    dwP();
    hc(paramView);
    init();
    setListener();
    ajgp.b().onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment
 * JD-Core Version:    0.7.0.1
 */