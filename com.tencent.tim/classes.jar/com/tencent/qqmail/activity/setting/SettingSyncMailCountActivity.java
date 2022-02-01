package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class SettingSyncMailCountActivity
  extends BaseActivityEx
{
  private static final String ARG_ACC_ID = "accountId";
  private Account account;
  private int accountId;
  private int defaultSyncMailCount;
  private QMBaseView mSettingView;
  private QMRadioGroup.OnCheckedChangeListener mSyncMailCountCheckListener = new SettingSyncMailCountActivity.1(this);
  private QMRadioGroup mSyncMailCountRadioGroup;
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingSyncMailCountActivity.class);
    localIntent.putExtra("accountId", paramInt);
    return localIntent;
  }
  
  private void initSyncMailCountRadioGroup()
  {
    this.mSyncMailCountRadioGroup = new QMRadioGroup(this);
    this.mSettingView.addContentView(this.mSyncMailCountRadioGroup);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (this.account.isActiveSyncMail()) {}
    for (int i = 2131719985;; i = 2131719980)
    {
      localQMTopBar.setTitle(i);
      localQMTopBar.setButtonLeftBack();
      return;
    }
  }
  
  private void renderSyncMailCountRadioGroup()
  {
    if (this.account == null) {
      finish();
    }
    if (this.mSyncMailCountRadioGroup == null) {
      initSyncMailCountRadioGroup();
    }
    this.mSyncMailCountRadioGroup.clear();
    if (this.account.isActiveSyncMail())
    {
      this.mSyncMailCountRadioGroup.addItem(20000, 2131719986);
      this.mSyncMailCountRadioGroup.addItem(10000, 2131719989);
      this.mSyncMailCountRadioGroup.addItem(10001, 2131719990);
      this.mSyncMailCountRadioGroup.addItem(10002, 2131719991);
      this.mSyncMailCountRadioGroup.addItem(10003, 2131719988);
    }
    for (;;)
    {
      this.mSyncMailCountRadioGroup.setOnCheckedChangeListener(this.mSyncMailCountCheckListener);
      this.mSyncMailCountRadioGroup.setClickListenerWithoutSelector();
      this.mSyncMailCountRadioGroup.commit();
      this.mSyncMailCountRadioGroup.setSelectedItem(this.defaultSyncMailCount);
      return;
      this.mSyncMailCountRadioGroup.addItem(100, 2131719982);
      this.mSyncMailCountRadioGroup.addItem(200, 2131719983);
      this.mSyncMailCountRadioGroup.addItem(500, 2131719981);
      this.mSyncMailCountRadioGroup.setDescription(2131719984);
    }
  }
  
  public void initDataSource()
  {
    this.accountId = getIntent().getIntExtra("accountId", 0);
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    if (this.account.isActiveSyncMail()) {}
    for (int i = 10002;; i = 500)
    {
      this.defaultSyncMailCount = i;
      return;
    }
  }
  
  public void initDom()
  {
    initTopBar();
    initSyncMailCountRadioGroup();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData()
  {
    if (this.account.isActiveSyncMail())
    {
      this.defaultSyncMailCount = QMSyncManager.sharedInstance().getSyncMailDay(this.accountId);
      return;
    }
    this.defaultSyncMailCount = QMSyncManager.sharedInstance().getSyncMailCount(this.accountId);
  }
  
  public void render()
  {
    renderSyncMailCountRadioGroup();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSyncMailCountActivity
 * JD-Core Version:    0.7.0.1
 */