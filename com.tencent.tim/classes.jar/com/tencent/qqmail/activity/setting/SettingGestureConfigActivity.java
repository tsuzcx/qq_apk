package com.tencent.qqmail.activity.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.fingerprint.BaseFingerprintManager;
import com.tencent.qqmail.view.fingerprint.FingerPrintDialog;
import com.tencent.qqmail.view.fingerprint.FingerPrintDialog.FingerprintCallback;
import com.tencent.qqmail.view.fingerprint.FingerprintFactory;

public class SettingGestureConfigActivity
  extends BaseActivityEx
  implements FingerPrintDialog.FingerprintCallback
{
  private static final int REQUEST_CODE_FINGERPRINT = 1;
  private static final String TAG = "SettingGestureConfigActivity";
  private UITableView.ClickListener enableGestureClickListener = new SettingGestureConfigActivity.4(this);
  private FingerPrintDialog fingerPrintDialog;
  private UITableView.ClickListener fingerprintClickListener = new SettingGestureConfigActivity.1(this);
  private UITableItemView gesturePasswordOpenItem;
  private boolean mEnableGesture;
  private UITableItemView mFingerprintItemView;
  private UITableView mFingerprintTableView;
  private UITableView mModifyGestureTableView;
  private QMBaseView mSettingView;
  private UITableItemView showTrackItem;
  
  private void createEnableGestureTable()
  {
    UITableView localUITableView = new UITableView(this);
    this.mSettingView.addContentView(localUITableView);
    this.gesturePasswordOpenItem = localUITableView.addItem(2131719864);
    this.gesturePasswordOpenItem.setChecked(this.mEnableGesture);
    localUITableView.setClickListener(this.enableGestureClickListener);
    localUITableView.commit();
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingGestureConfigActivity.class);
  }
  
  public static Intent createIntentForSetPsw()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingGestureConfigActivity.class);
    localIntent.putExtra("arg_page_state", 0);
    return localIntent;
  }
  
  private void createModifyGestureTable()
  {
    this.mModifyGestureTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mModifyGestureTableView);
    this.showTrackItem = this.mModifyGestureTableView.addItem(2131719871);
    this.showTrackItem.setChecked(SharedPreferenceUtil.isGesturePasswordShowTrack());
    UITableItemView localUITableItemView = this.mModifyGestureTableView.addItem(2131719860);
    this.mModifyGestureTableView.setClickListener(new SettingGestureConfigActivity.5(this, localUITableItemView));
    this.mModifyGestureTableView.commit();
  }
  
  public static void disableGesturePassword()
  {
    SharedPreferenceUtil.setGesturePswEnabled(false);
    SharedPreferenceUtil.removeGesturePwd();
    QMMailManager.sharedInstance().setGesturePwd("");
    QMNotification.postNotification("BROADCAST_WIDGET_ACCOUNT_CHANGE", null);
  }
  
  private void gotoSetting()
  {
    Intent localIntent = new Intent("android.settings.SETTINGS");
    if (localIntent.resolveActivity(getActivity().getPackageManager()) != null)
    {
      startActivity(localIntent);
      return;
    }
    QMLog.log(5, "SettingGestureConfigActivity", "No Intent available to handle ACTION_SETTINGS");
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719864);
    localQMTopBar.setButtonLeftBack();
  }
  
  private boolean isPwdEnable()
  {
    return SharedPreferenceUtil.isGesturePswEnabled();
  }
  
  private void setupGesturePassword()
  {
    SharedPreferenceUtil.setGesturePasswordShowTrack(true);
    startActivity(SettingGestureActivity.createIntent(0));
  }
  
  public void createEnableFingerprintTable()
  {
    if (FingerprintFactory.createInstance().isHarewareDetected())
    {
      this.mFingerprintTableView = new UITableView(this);
      this.mSettingView.addContentView(this.mFingerprintTableView);
      this.mFingerprintItemView = this.mFingerprintTableView.addItem(2131719855);
      if ((!FingerprintFactory.createInstance().isHarewareDetected()) || (FingerprintFactory.createInstance().isEnrolled())) {
        break label117;
      }
      this.mFingerprintItemView.setChecked(false);
    }
    for (;;)
    {
      this.mFingerprintTableView.setDescription(2131719856);
      this.mFingerprintTableView.setClickListener(this.fingerprintClickListener);
      this.mFingerprintTableView.commit();
      this.fingerPrintDialog = new FingerPrintDialog();
      return;
      label117:
      this.mFingerprintItemView.setChecked(SharedPreferenceUtil.isFingerprintOpen());
    }
  }
  
  public void initDataSource()
  {
    Bundle localBundle = getIntent().getExtras();
    if ((!SharedPreferenceUtil.isGesturePswEnabled()) && (localBundle.containsKey("arg_page_state")) && (localBundle.getInt("arg_page_state") == 0)) {
      startActivity(SettingGestureActivity.createIntent(0));
    }
  }
  
  public void initDom()
  {
    initTopBar();
    createEnableGestureTable();
    createModifyGestureTable();
    createEnableFingerprintTable();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    boolean bool = paramIntent.getBooleanExtra("pwd_passed", false);
    QMLog.log(4, "SettingGestureConfigActivity", "fingerprint_result: " + bool);
    onAuthenticated();
  }
  
  public void onAuthenticated()
  {
    QMNotification.postNotification("BROADCAST_WIDGET_ACCOUNT_CHANGE", null);
    this.mFingerprintItemView.setChecked(false);
    SharedPreferenceUtil.setFingerprintOpen(false);
    DataCollector.logEvent("Event_Fingerprint_diable_setting");
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onError() {}
  
  public void onRelease()
  {
    this.fingerPrintDialog = null;
  }
  
  public void refreshData()
  {
    this.mEnableGesture = isPwdEnable();
  }
  
  public void render()
  {
    if (this.mEnableGesture)
    {
      this.mModifyGestureTableView.setVisibility(0);
      this.showTrackItem.setChecked(SharedPreferenceUtil.isGesturePasswordShowTrack());
      this.gesturePasswordOpenItem.setChecked(this.mEnableGesture);
      if ((FingerprintFactory.createInstance().isHarewareDetected()) && (this.mEnableGesture)) {
        break label101;
      }
      if (this.mFingerprintTableView != null) {
        this.mFingerprintTableView.setVisibility(8);
      }
      if (this.mFingerprintItemView != null) {
        this.mFingerprintItemView.setVisibility(8);
      }
    }
    label101:
    do
    {
      return;
      this.mModifyGestureTableView.setVisibility(8);
      break;
      if (this.mFingerprintTableView != null) {
        this.mFingerprintTableView.setVisibility(0);
      }
    } while (this.mFingerprintItemView == null);
    this.mFingerprintItemView.setVisibility(0);
    this.mFingerprintItemView.setChecked(FingerprintFactory.createInstance().isAvailable());
  }
  
  public void showTipsForSettingFingerprint()
  {
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131697345)).setMessage(2131719857).addAction(2131691246, new SettingGestureConfigActivity.3(this))).addAction(2131696547, new SettingGestureConfigActivity.2(this))).create();
    localQMUIDialog.setCancelable(false);
    localQMUIDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureConfigActivity
 * JD-Core Version:    0.7.0.1
 */