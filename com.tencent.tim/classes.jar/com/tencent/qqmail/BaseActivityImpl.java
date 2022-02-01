package com.tencent.qqmail;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.watcher.QueryProviderWatcher;
import com.tencent.qqmail.accountlist.fragment.AccountListFragment;
import com.tencent.qqmail.activity.compose.ComposeFeedbackActivity;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.readmail.ReadMailFragment;
import com.tencent.qqmail.activity.setting.GesturePwdActivity;
import com.tencent.qqmail.activity.setting.PasswordErrHandling;
import com.tencent.qqmail.activity.setting.SettingGestureActivity;
import com.tencent.qqmail.activity.watcher.ForwardToWeiYunWatcher;
import com.tencent.qqmail.activity.watcher.SaveToMyFtnWatcher;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.fragment.CalendarListFragment;
import com.tencent.qqmail.calendar.fragment.CalendarMainFragment;
import com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast;
import com.tencent.qqmail.calendar.watcher.CalendarFollowWatcher;
import com.tencent.qqmail.folderlist.FolderListFragment;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.model.mail.watcher.AccountStateWatcher;
import com.tencent.qqmail.model.mail.watcher.AppUpdateWatcher;
import com.tencent.qqmail.model.mail.watcher.CalendarNotifyWatcher;
import com.tencent.qqmail.model.mail.watcher.SecurityAppWatcher;
import com.tencent.qqmail.model.mail.watcher.SendMailSuccWatcher;
import com.tencent.qqmail.model.mail.watcher.WipeAppWatcher;
import com.tencent.qqmail.model.mail.watcher.XqqwxPublicAccountWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.ReuseMail;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.pushconfig.QMPushConfigDialog;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.MockQMTips;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import moai.core.watcher.Watchers;

public class BaseActivityImpl
{
  public static final String FROM_ACTIVITY = "fromActivity";
  public static final String REQUEST_CODE = "requestCode";
  private static final String TAG = "BaseActivityImpl";
  public static String curActivityName;
  private static boolean isFadeBackground = false;
  private static final ConcurrentHashMap<Integer, String> tags = new ConcurrentHashMap();
  private final int ReviseAccountProtocolRequestId = 100;
  private AccountStateWatcher accountStateWatcher = new BaseActivityImpl.10(this);
  private AppUpdateWatcher appUpdateWatcher = new BaseActivityImpl.4(this);
  private boolean bResumed;
  private QMUIDialog calendarDialog;
  private final CalendarFollowWatcher calendarFollowWatcher = new BaseActivityImpl.18(this);
  public CalendarNotifyWatcher calendarWatcher = new BaseActivityImpl.15(this);
  public IObserver cancelFailIObserver = new IObserver(new BaseActivityImpl.25(this));
  public IObserver cancelProtocolFailIObserver = new IObserver(new BaseActivityImpl.24(this));
  private QMUIDialog closeQQWxDialog;
  private final ForwardToWeiYunWatcher forwardToWeiYunWatcher = new BaseActivityImpl.19(this);
  private boolean isRunningStatus = false;
  private double lastX;
  private double lastY;
  private boolean mDestroyed = false;
  private final int mMaximumVelocity;
  private PageProvider mPage;
  private PrivateAccess mPrivateAccess;
  private Map<String, Long> mShowAccountInvalidDialogTimeMap;
  private VelocityTracker mVelocityTracker;
  protected IObserver pushLoginIObserver = new IObserver(new BaseActivityImpl.23(this));
  private QueryProviderWatcher queryProviderWatcher = new BaseActivityImpl.1(this);
  private SecurityAppWatcher secAppWatcher = new BaseActivityImpl.6(this);
  private SendMailSuccWatcher sendMailSuccWatcher = new BaseActivityImpl.3(this);
  private List<StoredToast> storedToast = new ArrayList();
  protected IObserver syncAdRuleIObserver = new IObserver(new BaseActivityImpl.22(this));
  private volatile QMTips tips;
  private boolean userClickXQQWX = false;
  private SaveToMyFtnWatcher wechatFtnWatcher = new BaseActivityImpl.2(this);
  private WipeAppWatcher wipeWatcher = new BaseActivityImpl.5(this);
  private XqqwxPublicAccountWatcher xqqwxWatcher = new BaseActivityImpl.14(this);
  
  public BaseActivityImpl(PageProvider paramPageProvider, PrivateAccess paramPrivateAccess)
  {
    this.mPage = paramPageProvider;
    this.mPrivateAccess = paramPrivateAccess;
    this.mMaximumVelocity = ViewConfiguration.get(this.mPage.getActivity()).getScaledMaximumFlingVelocity();
  }
  
  private void bindCancelWatcher(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QMNotification.registNotification("cancel_after_success", this.cancelFailIObserver);
      QMNotification.registNotification("cancel_protocol_after_success", this.cancelProtocolFailIObserver);
      return;
    }
    QMNotification.unregistNotification("cancel_after_success", this.cancelFailIObserver);
    QMNotification.unregistNotification("cancel_protocol_after_success", this.cancelProtocolFailIObserver);
  }
  
  private void buildAsyncDeleteClockMailDialog(Context paramContext)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setTitle(2131691551)).setMessage(2131692979).addAction(2131696547, new BaseActivityImpl.30(this))).create().show();
  }
  
  private void buildCancelFailDialog(ComposeMailUI paramComposeMailUI)
  {
    Object localObject;
    if ((this.mPage instanceof BaseActivity)) {
      localObject = (BaseActivity)this.mPage;
    }
    for (;;)
    {
      int i;
      if (paramComposeMailUI.getClockSendTime() > 0L)
      {
        i = 1;
        label29:
        if (!canEnterOtherActivity()) {
          break label216;
        }
        localMessageDialogBuilder = new QMUIDialog.MessageDialogBuilder((Context)localObject);
        localMessageDialogBuilder.setTitle(2131689590);
        localMessageDialogBuilder.addAction(2131691246, new BaseActivityImpl.26(this));
        if (i == 0) {
          break label165;
        }
        localMessageDialogBuilder.setMessage(String.format(((Context)localObject).getString(2131689593), new Object[] { paramComposeMailUI.getInformation().getSubject() }));
        localMessageDialogBuilder.addAction(0, 2131692498, 2, new BaseActivityImpl.27(this, (Context)localObject, paramComposeMailUI));
      }
      for (;;)
      {
        localMessageDialogBuilder.create().show();
        return;
        if (!(this.mPage instanceof QMBaseFragment)) {
          break label305;
        }
        localObject = ((QMBaseFragment)this.mPage).getActivity();
        break;
        i = 0;
        break label29;
        label165:
        localMessageDialogBuilder.setMessage(String.format(((Context)localObject).getString(2131689592), new Object[] { paramComposeMailUI.getInformation().getSubject() }));
        localMessageDialogBuilder.addAction(2131691237, new BaseActivityImpl.28(this, paramComposeMailUI));
      }
      label216:
      QMUIDialog.MessageDialogBuilder localMessageDialogBuilder = (QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder((Context)localObject).setTitle(2131689590);
      if (i != 0) {}
      for (localObject = ((Context)localObject).getString(2131689593);; localObject = ((Context)localObject).getString(2131689592))
      {
        ((QMUIDialog.MessageDialogBuilder)localMessageDialogBuilder.setMessage(String.format((String)localObject, new Object[] { paramComposeMailUI.getInformation().getSubject() })).addAction(2131696547, new BaseActivityImpl.29(this))).create().show();
        return;
      }
      label305:
      localObject = null;
    }
  }
  
  private void clickStreamLog()
  {
    PageProvider localPageProvider = this.mPage;
    ConcurrentHashMap localConcurrentHashMap = tags;
    if ((localPageProvider != null) && (localPageProvider.getActivity() != null) && (localConcurrentHashMap != null)) {
      Threads.runInBackground(new BaseActivityImpl.21(this, localPageProvider, localConcurrentHashMap));
    }
  }
  
  private boolean dragBack(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 > 1000.0F) && (Math.abs((paramFloat4 - this.lastY) / Math.max(paramFloat3 - this.lastX, 1.0D)) < 0.8D))
    {
      this.mPage.onBackPressed();
      return true;
    }
    return false;
  }
  
  private boolean existPage(Class<?> paramClass)
  {
    return QMActivityManager.shareInstance().existPage(paramClass);
  }
  
  private void finishGesturePasswordActivity()
  {
    PrivateAccess localPrivateAccess = QMActivityManager.shareInstance().getPage(GesturePwdActivity.class);
    if (localPrivateAccess != null) {
      QMActivityManager.shareInstance().finishTopActivityInclusive(localPrivateAccess.getPage());
    }
  }
  
  private void finishReadMailFragment()
  {
    PrivateAccess localPrivateAccess = QMActivityManager.shareInstance().getPage(ReadMailFragment.class);
    if (localPrivateAccess != null) {
      QMActivityManager.shareInstance().finishTopActivityInclusive(localPrivateAccess.getPage());
    }
  }
  
  private void gotoAccountList()
  {
    Threads.runOnMainThread(new BaseActivityImpl.12(this));
  }
  
  private void gotoAccountTypeList()
  {
    Threads.runOnMainThread(new BaseActivityImpl.11(this));
  }
  
  private void gotoFolderList(int paramInt)
  {
    Threads.runOnMainThread(new BaseActivityImpl.13(this, paramInt));
  }
  
  private void handleAccountStateChange(String paramString, Account paramAccount, int paramInt)
  {
    QMLog.log(6, "BaseActivityImpl", "handlePwdError:" + paramAccount.getId() + "," + paramAccount.getEmail() + ", tip:" + paramString + ", state:" + paramInt);
    if (this.mShowAccountInvalidDialogTimeMap == null) {
      this.mShowAccountInvalidDialogTimeMap = new ConcurrentHashMap();
    }
    if (this.mShowAccountInvalidDialogTimeMap.containsKey(paramAccount.getEmail()))
    {
      long l = System.currentTimeMillis() - ((Long)this.mShowAccountInvalidDialogTimeMap.get(paramAccount.getEmail())).longValue();
      if (l < 3600000L)
      {
        QMLog.log(5, "BaseActivityImpl", "handleAccountStateChange, do not show account reverify dialog, interval: " + l + "ms");
        return;
      }
    }
    this.mShowAccountInvalidDialogTimeMap.put(paramAccount.getEmail(), Long.valueOf(System.currentTimeMillis()));
    PasswordErrHandling.setHandling(true);
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131720003;
      if (paramAccount.isGMail())
      {
        paramString = String.format(this.mPage.getActivity().getString(2131695529), new Object[] { paramAccount.getEmail() });
        i = 2131694370;
        j = 2131695531;
      }
      break;
    }
    for (;;)
    {
      paramString = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.mPage.getActivity()).setTitle(i)).setMessage(paramString).addAction(2131691246, new BaseActivityImpl.8(this))).addAction(j, new BaseActivityImpl.7(this, paramAccount, paramInt))).create();
      paramString.setOnDismissListener(new BaseActivityImpl.9(this));
      paramString.setCanceledOnTouchOutside(false);
      paramString.show();
      return;
      i = 2131721664;
      break;
      int k = 2131696311;
      j = i;
      i = k;
    }
  }
  
  private void initXDialog(int paramInt, String paramString)
  {
    Object localObject1 = this.mPage;
    if (localObject1 == null) {}
    do
    {
      do
      {
        return;
        localObject2 = ((PageProvider)localObject1).getActivity();
      } while (localObject2 == null);
      localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    } while (localObject1 == null);
    this.userClickXQQWX = false;
    localObject1 = paramString.replace("$mailaddress$", ((Account)localObject1).getEmail());
    Object localObject2 = (QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder((Context)localObject2).setTitle(QMApplicationContext.sharedInstance().getString(2131721819));
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "";
    }
    this.closeQQWxDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)localObject2).setMessage(paramString).addAction(2131691246, new BaseActivityImpl.32(this, paramInt))).addAction(2131696547, new BaseActivityImpl.31(this, paramInt))).create();
    this.closeQQWxDialog.setOnDismissListener(new BaseActivityImpl.33(this, paramInt));
  }
  
  private boolean pageCanShowCalendarDialog()
  {
    return ((this.mPage instanceof FolderListFragment)) || ((this.mPage instanceof AccountListFragment)) || ((this.mPage instanceof CalendarMainFragment));
  }
  
  private boolean pageReadyForTips_compose()
  {
    return (!(this.mPage instanceof ComposeMailActivity)) && (!(this.mPage instanceof ComposeNoteActivity));
  }
  
  private boolean pageReadyForTips_initializing()
  {
    return (!(this.mPage instanceof WelcomePagesActivity)) && (!(this.mPage instanceof WelcomeActivity)) && (!(this.mPage instanceof SettingGestureActivity));
  }
  
  private void restoreToast()
  {
    if ((GesturePasswordManager.getInstance().isGesturePwdPassed()) && (this.storedToast.size() > 0) && (this.mPage.getActivity() != null))
    {
      int i = 0;
      while (i < this.storedToast.size())
      {
        Toast.makeText(this.mPage.getActivity().getApplicationContext(), ((StoredToast)this.storedToast.get(i)).msg, ((StoredToast)this.storedToast.get(i)).duration).show();
        i += 1;
      }
      this.storedToast.clear();
    }
  }
  
  private void showFollowShareCalendarFailDialog(String paramString)
  {
    getTips().showError(paramString);
  }
  
  private void showFollowShareCalendarSuccessDialog()
  {
    if (!(this.mPage instanceof CalendarListFragment))
    {
      if ((this.mPage.getActivity() instanceof CalendarFragmentActivity)) {
        this.mPage.getActivity().finish();
      }
      startActivity(CalendarFragmentActivity.createIntentToCalendarListAfterShare());
    }
  }
  
  private void startReadMailFragment(MailUI paramMailUI)
  {
    ReuseMail localReuseMail = new ReuseMail();
    localReuseMail.setContent(paramMailUI.getContent());
    localReuseMail.setInfo(paramMailUI.getInformation());
    localReuseMail.setIsRead(paramMailUI.isRead());
    localReuseMail.setStatus(paramMailUI.getStatus());
    localReuseMail.setVote(paramMailUI.getVote());
    paramMailUI = MailFragmentActivity.createIntentToReadmailById(paramMailUI.getInformation().getAccountId(), paramMailUI.getInformation().getRemoteId());
    paramMailUI.putExtra("arg_cancel_fail_mail", localReuseMail);
    paramMailUI.putExtra("arg_is_cancel_fail", true);
    finishReadMailFragment();
    if (QMActivityManager.shareInstance().getVisibleActivity() == null)
    {
      Log.v("cyz", "visibleActivity null " + this);
      return;
    }
    QMActivityManager.shareInstance().getVisibleActivity().startActivity(paramMailUI);
  }
  
  private void storeToast(String paramString, int paramInt)
  {
    this.storedToast.add(new StoredToast(paramString, paramInt));
  }
  
  public boolean canEnterComposeMailActivity()
  {
    if (existPage(ComposeNoteActivity.class))
    {
      Toast.makeText(this.mPage.getActivity().getApplicationContext(), this.mPage.getActivity().getString(2131720158), 0).show();
      return false;
    }
    if (existPage(ComposeFeedbackActivity.class))
    {
      Toast.makeText(this.mPage.getActivity().getApplicationContext(), this.mPage.getActivity().getString(2131720157), 0).show();
      return false;
    }
    return true;
  }
  
  public boolean canEnterComposeNoteActivity()
  {
    if (existPage(ComposeMailActivity.class))
    {
      Toast.makeText(this.mPage.getActivity().getApplicationContext(), this.mPage.getActivity().getString(2131720157), 0).show();
      return false;
    }
    if (existPage(ComposeFeedbackActivity.class))
    {
      Toast.makeText(this.mPage.getActivity().getApplicationContext(), this.mPage.getActivity().getString(2131720157), 0).show();
      return false;
    }
    return true;
  }
  
  public boolean canEnterOtherActivity()
  {
    if ((existPage(ComposeMailActivity.class)) || (existPage(ComposeFeedbackActivity.class))) {}
    while (existPage(ComposeNoteActivity.class)) {
      return false;
    }
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mPage.onDragBack(paramMotionEvent)) {
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    for (;;)
    {
      return false;
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      for (;;)
      {
        this.lastX = paramMotionEvent.getRawX();
        this.lastY = paramMotionEvent.getRawY();
        break;
        this.mVelocityTracker.clear();
      }
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.addMovement(paramMotionEvent);
        continue;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
          if (dragBack(this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity(), paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) {
            paramMotionEvent.setAction(3);
          }
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
          continue;
          if (this.mVelocityTracker != null)
          {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            continue;
            if (this.mVelocityTracker != null)
            {
              this.mVelocityTracker.recycle();
              this.mVelocityTracker = null;
            }
          }
        }
      }
    }
  }
  
  public void finish()
  {
    QMLog.log(4, "BaseActivityImpl", "finish: " + this.mPage);
    QMActivityManager.shareInstance().popActivity(this.mPrivateAccess);
    this.mPrivateAccess.super_finish();
  }
  
  public void finishActivity(int paramInt)
  {
    QMLog.log(4, "BaseActivityImpl", "finishActivity: " + this.mPage);
    QMActivityManager.shareInstance().popActivity(this.mPrivateAccess);
    this.mPrivateAccess.super_finishActivity(paramInt);
  }
  
  public void finishWithNoCheck()
  {
    QMLog.log(4, "BaseActivityImpl", "finishWithNoCheck: " + this.mPage);
    QMActivityManager.shareInstance().popActivity(this.mPrivateAccess);
    this.mPrivateAccess.super_finish();
  }
  
  public Activity getActivity()
  {
    return this.mPage.getActivity();
  }
  
  public QMTips getTips()
  {
    
    if (this.tips == null)
    {
      if (this.mPage != null) {
        break label43;
      }
      QMLog.log(6, "BaseActivityImpl", "page has been alread destroy! just new a mock tips and done nothing");
      this.tips = new MockQMTips();
    }
    for (;;)
    {
      return this.tips;
      label43:
      this.tips = new QMTips(this.mPage.getActivity());
      this.mPage.initTips(this.tips);
    }
  }
  
  public boolean hideKeyBoard()
  {
    if ((this.mPage != null) && (this.mPage.getActivity() != null)) {
      return ((InputMethodManager)this.mPage.getActivity().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mPage.getActivity().findViewById(16908290).getWindowToken(), 0);
    }
    return false;
  }
  
  public boolean isActivityResumed()
  {
    return this.bResumed;
  }
  
  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  public boolean isFadeBackground()
  {
    return isFadeBackground;
  }
  
  public void myCalendarRemindDialog(int paramInt, String paramString)
  {
    if (this.mPage == null) {
      return;
    }
    paramString = (QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.mPage.getActivity()).setTitle(2131691102)).setMessage(paramString).addAction(2131691096, new BaseActivityImpl.17(this, paramInt))).addAction(2131691097, new BaseActivityImpl.16(this));
    this.calendarDialog = paramString.create();
    paramString.getTextView().setMaxLines(2);
    paramString.getTextView().setEllipsize(TextUtils.TruncateAt.END);
    this.calendarDialog.setCanceledOnTouchOutside(false);
    this.calendarDialog.setCancelable(false);
    this.calendarDialog.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onCreate:");
    if (this.mPage != null) {}
    for (String str = this.mPage.toString();; str = "")
    {
      QMLog.log(4, "BaseActivityImpl", str + " obs:" + QMNotification.getTotalObserver() + " act:" + QMActivityManager.shareInstance().getActivitySize() + " network:" + QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()));
      this.mPrivateAccess.super_onCreate(paramBundle);
      if ((!(this.mPrivateAccess.getPage() instanceof GesturePwdActivity)) && (!(this.mPage.getActivity() instanceof LoginFragmentActivity)) && (this.mPrivateAccess.checkGesturePassword())) {
        finishGesturePasswordActivity();
      }
      QMActivityManager.shareInstance().pushActivity(this.mPrivateAccess);
      return;
    }
  }
  
  public void onDestroy()
  {
    this.mDestroyed = true;
    StringBuilder localStringBuilder = new StringBuilder().append("onDestroy: ");
    if (this.mPage != null) {}
    for (String str = this.mPage.toString();; str = "")
    {
      QMLog.log(4, "BaseActivityImpl", str);
      QMActivityManager.shareInstance().popActivity(this.mPrivateAccess);
      if (this.tips != null) {
        this.tips.recycle();
      }
      this.mPrivateAccess.super_onDestroy();
      this.mPage = null;
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return paramInt == 82;
  }
  
  public void onPause()
  {
    if (!isFadeBackground()) {
      AppStatusUtil.willGotoBackground();
    }
    this.bResumed = false;
    this.mPrivateAccess.super_onPause();
    StringBuilder localStringBuilder = new StringBuilder().append("onPause: ").append(getClass().getSimpleName()).append(",");
    if (this.mPage != null) {}
    for (String str = this.mPage.toString();; str = "")
    {
      QMLog.log(4, "BaseActivityImpl", str);
      return;
    }
  }
  
  public void onResume()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onResume:");
    Object localObject;
    if (this.mPage != null)
    {
      localObject = this.mPage.toString();
      QMLog.log(4, "BaseActivityImpl", (String)localObject + " obs:" + QMNotification.getTotalObserver() + " act:" + QMActivityManager.shareInstance().getActivitySize() + " network:" + QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()));
      this.mPrivateAccess.super_onResume();
      if ((this.mPage != null) && (this.mPage.getActivity() != null))
      {
        restoreToast();
        if (!isFadeBackground()) {
          AppStatusUtil.didGotoForeground();
        }
        if ((QMPushConfigUtil.getForceShowType() == 1) && (QMPushConfigUtil.showUpgradeVersion()))
        {
          localObject = QMPushConfigUtil.getUpgradeForceDialog();
          if ((localObject != null) && (QMPushConfigUtil.getForceType() != 0)) {
            Threads.runOnMainThread(new BaseActivityImpl.20(this, (QMPushConfigDialog)localObject));
          }
        }
      }
      this.isRunningStatus = false;
      isFadeBackground = false;
      this.bResumed = true;
      clickStreamLog();
      if ((pageCanShowCalendarDialog()) && (QMRemindererBroadcast.calendarRemindIdQueue != null) && (QMRemindererBroadcast.calendarRemindIdQueue.size() > 0) && ((this.calendarDialog == null) || (!this.calendarDialog.isShowing()))) {
        break label234;
      }
    }
    label234:
    while (QMRemindererBroadcast.calendarRemindIdQueue.size() <= 0)
    {
      return;
      localObject = "";
      break;
    }
    myCalendarRemindDialog(((Integer)QMRemindererBroadcast.calendarRemindIdQueue.peek()).intValue(), (String)QMRemindererBroadcast.calendarSubjectQueue.peek());
  }
  
  public void onStart()
  {
    this.mPrivateAccess.super_onStart();
    StringBuilder localStringBuilder = new StringBuilder().append("onStart: ");
    if (this.mPage != null) {}
    for (String str = this.mPage.toString();; str = "")
    {
      QMLog.log(4, "BaseActivityImpl", str);
      return;
    }
  }
  
  public void onStop()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onStop: ");
    if (this.mPage != null) {}
    for (String str = this.mPage.toString();; str = "")
    {
      QMLog.log(4, "BaseActivityImpl", str);
      this.mPrivateAccess.super_onStop();
      return;
    }
  }
  
  public void registerNotification(boolean paramBoolean)
  {
    QMNotification.registNotification("receivePushAdvertise", this.syncAdRuleIObserver, paramBoolean);
    QMNotification.registNotification("receivePushLogin", this.pushLoginIObserver, paramBoolean);
    QMPushConfigUtil.bindAppUpdateWatcher(this.appUpdateWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindWipeAppWatcher(this.wipeWatcher, paramBoolean);
    AccountManager.shareInstance().bindAccountStateWatcher(this.accountStateWatcher, paramBoolean);
    Watchers.bind(this.xqqwxWatcher, paramBoolean);
    Watchers.bind(this.wechatFtnWatcher, paramBoolean);
    Watchers.bind(this.calendarWatcher, paramBoolean);
    Watchers.bind(this.calendarFollowWatcher, paramBoolean);
    MailServiceManager.getInstance().bindQueryProviderListener(this.queryProviderWatcher, paramBoolean);
    Watchers.bind(this.secAppWatcher, paramBoolean);
    Watchers.bind(this.forwardToWeiYunWatcher, paramBoolean);
    Watchers.bind(this.sendMailSuccWatcher, paramBoolean);
    bindCancelWatcher(paramBoolean);
  }
  
  public void setFadeBackground()
  {
    isFadeBackground = true;
  }
  
  public void startActivity(Intent paramIntent)
  {
    if ((this.isRunningStatus) && (!this.mPrivateAccess.isMultiStartAllowed()))
    {
      if ((paramIntent != null) && (paramIntent.getComponent() != null))
      {
        paramIntent = paramIntent.getComponent().getClassName();
        if (paramIntent != null) {
          QMLog.log(4, "BaseActivityImpl", "Ignore " + paramIntent);
        }
      }
      else
      {
        return;
      }
      QMLog.log(4, "BaseActivityImpl", "Ignore classname is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("startActivity: ").append(this).append(",");
    Object localObject;
    if (paramIntent == null) {
      localObject = "intent null";
    }
    for (;;)
    {
      QMLog.log(4, "BaseActivityImpl", localObject);
      paramIntent.putExtra("fromActivity", getClass().getName());
      this.mPrivateAccess.super_startActivity(paramIntent);
      this.isRunningStatus = true;
      return;
      if (paramIntent.getComponent() == null) {
        localObject = "intent component null";
      } else {
        localObject = paramIntent.getComponent();
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("startActivityForResult: ").append(this).append(",");
    Object localObject;
    if (paramIntent == null) {
      localObject = "intent null";
    }
    for (;;)
    {
      QMLog.log(4, "BaseActivityImpl", localObject);
      paramIntent.putExtra("fromActivity", getClass().getName());
      paramIntent.putExtra("requestCode", paramInt);
      this.mPrivateAccess.super_startActivityForResult(paramIntent, paramInt);
      return;
      if (paramIntent.getComponent() == null) {
        localObject = "intent component null";
      } else {
        localObject = paramIntent.getComponent();
      }
    }
  }
  
  public void toast(String paramString, int paramInt)
  {
    if ((GesturePasswordManager.getInstance().isGesturePwdPassed()) && (QMActivityManager.shareInstance().getVisiblePage() == this.mPage))
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), paramString, paramInt).show();
      return;
    }
    storeToast(paramString, paramInt);
  }
  
  public static abstract interface PageProvider
  {
    public abstract boolean dispatchTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract Activity getActivity();
    
    public abstract QMTips getTips();
    
    public abstract QMTopBar getTopBar();
    
    public abstract void initTips(QMTips paramQMTips);
    
    public abstract boolean isPage(Class<?> paramClass);
    
    public abstract void onBackPressed();
    
    public abstract boolean onDragBack(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface PrivateAccess
  {
    public abstract boolean checkGesturePassword();
    
    public abstract boolean checkWelcomePopularize();
    
    public abstract Object getPage();
    
    public abstract boolean isMultiStartAllowed();
    
    public abstract void removeSelf();
    
    public abstract void super_finish();
    
    public abstract void super_finishActivity(int paramInt);
    
    public abstract void super_onCreate(Bundle paramBundle);
    
    public abstract void super_onDestroy();
    
    public abstract void super_onPause();
    
    public abstract void super_onResume();
    
    public abstract void super_onStart();
    
    public abstract void super_onStop();
    
    public abstract void super_startActivity(Intent paramIntent);
    
    public abstract void super_startActivityForResult(Intent paramIntent, int paramInt);
  }
  
  static class StoredToast
  {
    public int duration;
    public String msg;
    
    public StoredToast(String paramString, int paramInt)
    {
      this.msg = paramString;
      this.duration = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl
 * JD-Core Version:    0.7.0.1
 */