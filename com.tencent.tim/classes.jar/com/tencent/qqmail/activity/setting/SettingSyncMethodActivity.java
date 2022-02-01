package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushStartUpReason;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

public class SettingSyncMethodActivity
  extends BaseActivityEx
{
  private static final String ARG_ACC_ID = "accountId";
  private int accountId;
  private int defaultPollingInterval;
  private final QMRadioGroup.OnCheckedChangeListener mPollingIntervalCheckListener = new SettingSyncMethodActivity.5(this);
  private QMBaseView mSettingView;
  private final QMRadioGroup.OnCheckedChangeListener mSyncMethodCheckListener = new SettingSyncMethodActivity.1(this);
  private QMRadioGroup mSyncMethodRadioGroup;
  private QMRadioGroup mSyncPollingIntervalRadioGroup;
  private int selectSyncMethodId;
  private ArrayList<Integer> syncMethodIds;
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingSyncMethodActivity.class);
    localIntent.putExtra("accountId", paramInt);
    return localIntent;
  }
  
  private void initSyncLocalPollingIntervalRadioGroup()
  {
    this.mSyncPollingIntervalRadioGroup = new QMRadioGroup(this);
    this.mSettingView.addContentView(this.mSyncPollingIntervalRadioGroup);
    this.mSyncPollingIntervalRadioGroup.setCaption(2131719999);
    this.mSyncPollingIntervalRadioGroup.addItem(1800, 2131720000);
    this.mSyncPollingIntervalRadioGroup.addItem(3600, 2131720002);
    this.mSyncPollingIntervalRadioGroup.addItem(7200, 2131720001);
    this.mSyncPollingIntervalRadioGroup.setOnCheckedChangeListener(this.mPollingIntervalCheckListener);
    this.mSyncPollingIntervalRadioGroup.commit();
  }
  
  private void initSyncMethodRadioGroup()
  {
    this.mSyncMethodRadioGroup = new QMRadioGroup(this);
    this.mSettingView.addContentView(this.mSyncMethodRadioGroup);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719992);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void renderSyncLocalPollingIntervalRadioGroup()
  {
    setPollingIntervalItemChecked(this.defaultPollingInterval, false);
  }
  
  private void renderSyncMethodRadioGroup()
  {
    if (this.mSyncMethodRadioGroup == null) {
      initSyncMethodRadioGroup();
    }
    this.mSyncMethodRadioGroup.clear();
    if (this.syncMethodIds.contains(Integer.valueOf(1))) {
      this.mSyncMethodRadioGroup.addItem(1, 2131719997);
    }
    if (this.syncMethodIds.contains(Integer.valueOf(2))) {
      this.mSyncMethodRadioGroup.addItem(2, 2131719993);
    }
    if (this.syncMethodIds.contains(Integer.valueOf(3))) {
      this.mSyncMethodRadioGroup.addItem(3, 2131719995);
    }
    this.mSyncMethodRadioGroup.setOnCheckedChangeListener(this.mSyncMethodCheckListener);
    this.mSyncMethodRadioGroup.setDescription(2131719992);
    this.mSyncMethodRadioGroup.commit();
    setSyncMethodItemChecked(this.selectSyncMethodId, false);
  }
  
  private void setPollingIntervalItemChecked(int paramInt, boolean paramBoolean)
  {
    this.mSyncPollingIntervalRadioGroup.setSelectedItem(paramInt);
    if (paramBoolean) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      QMMailManager.sharedInstance().setNewMailPushRate(this.accountId, QMSyncManager.sharedInstance().transformNewMailRateToServer(paramInt));
      QMServiceManager.startPushService(QMPushService.PushStartUpReason.OTHER);
      return;
      QMSyncManager.sharedInstance().setSyncMethod(this.accountId, 1800, 2);
      continue;
      QMSyncManager.sharedInstance().setSyncMethod(this.accountId, 3600, 2);
      continue;
      QMSyncManager.sharedInstance().setSyncMethod(this.accountId, 7200, 2);
    }
  }
  
  private void setSyncMethodItemChecked(int paramInt, boolean paramBoolean)
  {
    this.mSyncMethodRadioGroup.setSelectedItem(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (paramBoolean) {
        QMServiceManager.startPushService(QMPushService.PushStartUpReason.OTHER);
      }
      return;
      this.mSyncMethodRadioGroup.setDescription(2131719998);
      this.mSyncPollingIntervalRadioGroup.setVisibility(8);
      if (paramBoolean)
      {
        QMSyncManager.sharedInstance().setSyncMethod(this.accountId, 1);
        runInBackground(new SettingSyncMethodActivity.2(this));
        continue;
        this.mSyncMethodRadioGroup.setDescription(2131719994);
        this.mSyncPollingIntervalRadioGroup.setVisibility(0);
        if (paramBoolean)
        {
          QMSyncManager.sharedInstance().setSyncMethod(this.accountId, 2);
          runInBackground(new SettingSyncMethodActivity.3(this));
          continue;
          this.mSyncMethodRadioGroup.setDescription(2131719996);
          this.mSyncPollingIntervalRadioGroup.setVisibility(8);
          if (paramBoolean)
          {
            QMSyncManager.sharedInstance().setSyncMethod(this.accountId, 3);
            runInBackground(new SettingSyncMethodActivity.4(this));
          }
        }
      }
    }
  }
  
  public void initDataSource()
  {
    this.accountId = getIntent().getIntExtra("accountId", 0);
  }
  
  public void initDom()
  {
    initTopBar();
    initSyncMethodRadioGroup();
    initSyncLocalPollingIntervalRadioGroup();
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
    this.syncMethodIds = QMSyncManager.sharedInstance().getSyncMethodList(this.accountId);
    this.selectSyncMethodId = QMSyncManager.sharedInstance().getSyncMethod(this.accountId);
    this.defaultPollingInterval = QMSyncManager.sharedInstance().getPollingInterval(this.accountId);
  }
  
  public void render()
  {
    renderSyncMethodRadioGroup();
    renderSyncLocalPollingIntervalRadioGroup();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSyncMethodActivity
 * JD-Core Version:    0.7.0.1
 */