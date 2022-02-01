package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.CrashComposeCheck;
import com.tencent.qqmail.GesturePasswordManager;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMGesture;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMGesturePasswordView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.fingerprint.BaseFingerprintManager;
import com.tencent.qqmail.view.fingerprint.FingerPrintDialog;
import com.tencent.qqmail.view.fingerprint.FingerPrintDialog.FingerprintCallback;
import com.tencent.qqmail.view.fingerprint.FingerprintFactory;

public class SettingGestureActivity
  extends BaseActivityEx
  implements FingerPrintDialog.FingerprintCallback
{
  public static final String ARG_HIDE_TOP_BAR = "arg_hide_top_bar";
  public static final String ARG_PAGE_TYPE = "arg_page_state";
  public static final int PAGE_TYPE_CLOSE_PWD_VERIFY = 4;
  public static final int PAGE_TYPE_MODIFY_PWD = 3;
  public static final int PAGE_TYPE_MODIFY_PWD_VERIFY = 5;
  public static final int PAGE_TYPE_SECOND_SETTING_PWD = 1;
  public static final int PAGE_TYPE_SETTING_PWD = 0;
  public static final int PAGE_TYPE_VERIFY = 2;
  public static final int PAGE_TYPE_VERIFY_FINGERPRINT = 6;
  public static final String RESULT_PASSWORD_PASSED = "pwd_passed";
  private static final String TAG = "SettingGestureActivity";
  private QMBaseView baseView;
  private FingerPrintDialog fingerPrintDialog;
  private String fistInputPwd = "";
  private QMGesturePasswordView gesturePasswordView;
  private boolean hideTopbar = false;
  private int page_type = 0;
  private QMGesture pwdView;
  
  static
  {
    if (!SettingGestureActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingGestureActivity.class);
    localIntent.putExtra("arg_page_state", paramInt);
    return localIntent;
  }
  
  private String getPwd()
  {
    return SharedPreferenceUtil.getGesturePwd();
  }
  
  private void handleSecondSetting(String paramString)
  {
    if (this.fistInputPwd.equals(paramString))
    {
      setPwd(paramString);
      this.pwdView.setFinishReset(false);
      toSettingPwdSuccessView(this.fistInputPwd);
      paramString = getTips();
      paramString.setCallback(new SettingGestureActivity.4(this));
      paramString.showSuccess(2131719872, 1000L);
      return;
    }
    this.fistInputPwd = "";
    this.page_type = 0;
    this.pwdView.setPswFail(true, paramString);
    this.pwdView.postInvalidate();
    setMask();
    toSecondPwdErrorView();
  }
  
  private void handleVerify(String paramString, int paramInt, VerifyCallback paramVerifyCallback)
  {
    assert (paramVerifyCallback != null);
    String str = getPwd();
    if ((str != null) && (str.equals(paramString)))
    {
      paramVerifyCallback.handleSuccess();
      return;
    }
    if (paramInt + 1 >= 5)
    {
      paramVerifyCallback.handleExceedMaxTimes();
      return;
    }
    this.pwdView.setPswFail(true, paramString);
    this.pwdView.postInvalidate();
    setMask();
    paramVerifyCallback.handleError(paramInt + 1);
  }
  
  private void paintSmallCircle(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    this.gesturePasswordView.selectSmallCircles(paramString);
  }
  
  private void resetSmallCircle()
  {
    this.gesturePasswordView.selectSmallCircles("");
  }
  
  private void setGesturePwdPassed(boolean paramBoolean)
  {
    GesturePasswordManager.getInstance().setGesturePwdPassed(paramBoolean);
    Intent localIntent = new Intent();
    localIntent.putExtra("pwd_passed", true);
    setResult(-1, localIntent);
  }
  
  private void setMask()
  {
    Threads.runOnMainThread(new SettingGestureActivity.5(this));
    Threads.runOnMainThread(new SettingGestureActivity.6(this), QMGesture.PSW_FAIL_TIME);
  }
  
  private void setPwd(String paramString)
  {
    SharedPreferenceUtil.setGesturePwd(paramString);
  }
  
  private void toPwdTooShortView()
  {
    this.gesturePasswordView.showError(2131719867);
    resetSmallCircle();
  }
  
  private void toSecondPwdErrorView()
  {
    this.gesturePasswordView.showError(2131719868);
    resetSmallCircle();
  }
  
  private void toSecondPwdView(String paramString)
  {
    this.gesturePasswordView.showTips(2131719869);
    paintSmallCircle(paramString);
  }
  
  private void toSettingPwdSuccessView(String paramString)
  {
    this.gesturePasswordView.showTips(2131719872);
    paintSmallCircle(paramString);
    QMMailManager.sharedInstance().setGesturePwd(paramString);
  }
  
  public void initDataSource()
  {
    Bundle localBundle = getIntent().getExtras();
    this.page_type = localBundle.getInt("arg_page_state");
    this.hideTopbar = localBundle.getBoolean("arg_hide_top_bar");
  }
  
  public void initDom()
  {
    this.fingerPrintDialog = new FingerPrintDialog();
    this.fingerPrintDialog.setDismissListener(new SettingGestureActivity.1(this));
    if ((this.page_type == 0) || (this.page_type == 3))
    {
      this.gesturePasswordView = new QMGesturePasswordView(QMGesturePasswordView.TYPE_SETTING);
      this.baseView.addView(this.gesturePasswordView);
      if (!this.hideTopbar) {
        break label231;
      }
      getTopBar().setVisibility(8);
    }
    for (;;)
    {
      this.pwdView = ((QMGesture)this.gesturePasswordView.findViewById(QMGesturePasswordView.ID_GESTURE_PASSWORD));
      this.pwdView.setPasswordMinLength(4);
      this.pwdView.setOnRollingListener(new SettingGestureActivity.3(this));
      return;
      if (this.page_type == 2)
      {
        this.gesturePasswordView = new QMGesturePasswordView(QMGesturePasswordView.TYPE_UNLOCK);
        this.gesturePasswordView.showTips(2131719873);
        this.gesturePasswordView.findViewById(QMGesturePasswordView.ID_RESET_PASSWORD).setOnClickListener(new SettingGestureActivity.2(this));
        break;
      }
      if ((this.page_type != 4) && (this.page_type != 5) && (this.page_type != 6)) {
        break;
      }
      this.gesturePasswordView = new QMGesturePasswordView(QMGesturePasswordView.TYPE_MODIFY_UNLOCK);
      this.gesturePasswordView.showTips(2131719861);
      break;
      label231:
      getTopBar().setButtonLeftBack();
      if ((this.page_type == 5) || (this.page_type == 4) || (this.page_type == 6)) {
        getTopBar().setTitle(2131719866);
      } else {
        getTopBar().setTitle(2131719870);
      }
    }
  }
  
  public void initUI()
  {
    this.baseView = initBaseView(this);
  }
  
  public void onAuthenticated()
  {
    QMLog.log(4, "SettingGestureActivity", "onAuthenticated Fingerprint");
    DataCollector.logEvent("Event_Fingerprint_auth_success");
    QMSettingManager.sharedInstance().saveTryGestureTimes(0);
    setGesturePwdPassed(true);
    finish();
    if (QMActivityManager.shareInstance().getActivitySize() <= 0)
    {
      overridePendingTransition(2130772023, 2130772423);
      return;
    }
    overridePendingTransition(2130772423, 2130772025);
  }
  
  public void onBackground()
  {
    super.onBackground();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    if (this.page_type == 2) {}
    do
    {
      return false;
      assert (this.pwdView != null);
    } while (((paramMotionEvent.getAction() & 0xFF) == 1) && (this.pwdView.getCheckPointSize() != 0));
    return true;
  }
  
  public void onError() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.page_type == 2)
    {
      moveTaskToBack(true);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public Intent onLastFinish()
  {
    Intent localIntent2 = CrashComposeCheck.checkCrashComposeMail(this);
    Intent localIntent1 = localIntent2;
    int i;
    if (localIntent2 == null)
    {
      i = AccountManager.shareInstance().getAccountList().size();
      if (i == 1)
      {
        QMLog.log(4, "SettingGestureActivity", "SettingGestureActivity onLastFinish.acc size:1");
        localIntent1 = MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId());
      }
    }
    else
    {
      return localIntent1;
    }
    QMLog.log(4, "SettingGestureActivity", "SettingGestureActivity onLastFinish.acc size:" + i);
    return MailFragmentActivity.createIntentToAccountList();
  }
  
  public void onRelease()
  {
    this.fingerPrintDialog = null;
  }
  
  public void refreshData() {}
  
  public void render()
  {
    Log.i("SettingGestureActivity", "FingerprintAdapter render");
    if ((this.page_type == 2) && (FingerprintFactory.createInstance().isAvailable()) && (!this.fingerPrintDialog.isAdded()))
    {
      this.gesturePasswordView.findViewById(QMGesturePasswordView.ID_FINGERPRINT_PASSWORD).setOnClickListener(new SettingGestureActivity.7(this));
      if (FingerPrintDialog.isRequestNormal())
      {
        this.fingerPrintDialog.show(getFragmentManager(), "FingerPrintDialog");
        this.gesturePasswordView.switchState(true);
      }
    }
  }
  
  static abstract interface VerifyCallback
  {
    public abstract void handleError(int paramInt);
    
    public abstract void handleExceedMaxTimes();
    
    public abstract void handleSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureActivity
 * JD-Core Version:    0.7.0.1
 */