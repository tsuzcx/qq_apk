package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.badge.BadgeUtil;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SettingMailRemindActivity
  extends BaseActivityEx
{
  private static final String DEFAULT = "default";
  private static final String TAG = "SettingMailRemindActivity";
  private List<Integer> accountIds = new ArrayList();
  private UITableView.ClickListener accountTableClickListener = new SettingMailRemindActivity.6(this);
  private UITableView.ClickListener adMailAndRemindImportantClickListener = new SettingMailRemindActivity.4(this);
  private UITableItemView adMailNotifyItemView;
  private UITableView.ClickListener badgeClickListener = new SettingMailRemindActivity.5(this);
  private boolean hasInit = false;
  private UITableView mADMailNotifyAndRemindVipAndShowMailDetailTable;
  private UITableView mAccountTable;
  private UITableItemView mBadgeOnlyIncrement;
  private UITableItemView mBadgeOpened;
  private UITableView mBadgeTable;
  private UITableItemView mChildRemindTime;
  private UITableItemView mChildRemindVipTable;
  private UITableItemView mChildSoundTableNewMail;
  private UITableItemView mChildSoundTableVip;
  private UITableView mMainTable;
  private UITableView mRemindTimeTable;
  private QMBaseView mSettingView;
  private UITableItemView mShowMailDetail;
  private UITableView mSoundEffectsTable;
  private UITableView mVoiceAndVibrateTable;
  private UITableView.ClickListener mainTableClickListener = new SettingMailRemindActivity.1(this);
  private UITableItemView newMailPushMainItemView;
  private UITableItemView newMailPushVibrateItemView;
  private UITableItemView newMailPushVoiceItemView;
  private UITableView.ClickListener remindTimeTableClickListener = new SettingMailRemindActivity.7(this);
  private UITableView.ClickListener soundAndVibrateClickListener = new SettingMailRemindActivity.2(this);
  private UITableView.ClickListener soundTableClickListener = new SettingMailRemindActivity.3(this);
  
  private void createADMailNotifyAndRemindVipAndShowMailDetailTable()
  {
    this.mADMailNotifyAndRemindVipAndShowMailDetailTable = new UITableView(this);
    this.mSettingView.addContentView(this.mADMailNotifyAndRemindVipAndShowMailDetailTable);
    this.adMailNotifyItemView = this.mADMailNotifyAndRemindVipAndShowMailDetailTable.addItem(2131719649);
    UITableItemView localUITableItemView = this.adMailNotifyItemView;
    if (!QMSettingManager.sharedInstance().getNotifyAdMail()) {}
    for (boolean bool = true;; bool = false)
    {
      localUITableItemView.setChecked(bool);
      if (!QMSettingManager.sharedInstance().getAggregateAdMail()) {
        this.adMailNotifyItemView.setVisibility(8);
      }
      this.mChildRemindVipTable = this.mADMailNotifyAndRemindVipAndShowMailDetailTable.addItem(2131719879);
      this.mChildRemindVipTable.setChecked(QMSettingManager.sharedInstance().getOnlyNotifyVIP());
      this.mShowMailDetail = this.mADMailNotifyAndRemindVipAndShowMailDetailTable.addItem(2131719959);
      this.mShowMailDetail.setChecked(QMSettingManager.sharedInstance().getShowMailDetail());
      this.mADMailNotifyAndRemindVipAndShowMailDetailTable.setClickListener(this.adMailAndRemindImportantClickListener);
      this.mADMailNotifyAndRemindVipAndShowMailDetailTable.commit();
      return;
    }
  }
  
  private void createAccountTable()
  {
    this.mAccountTable = new UITableView(this);
    this.mSettingView.addContentView(this.mAccountTable);
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i = 0;
    while (i < localAccountList.size())
    {
      this.mAccountTable.addItem(localAccountList.get(i).getEmail());
      this.accountIds.add(Integer.valueOf(localAccountList.get(i).getId()));
      i += 1;
    }
    this.mAccountTable.setDescription(2131719934);
    this.mAccountTable.setClickListener(this.accountTableClickListener);
    this.mAccountTable.commit();
  }
  
  private void createBadgeTable()
  {
    this.mBadgeTable = new UITableView(this);
    this.mSettingView.addContentView(this.mBadgeTable);
    this.mBadgeOpened = this.mBadgeTable.addItem(2131690811);
    this.mBadgeOnlyIncrement = this.mBadgeTable.addItem(2131690810);
    this.mBadgeOpened.setChecked(SharedPreferenceUtil.isBadgeOpen());
    this.mBadgeOnlyIncrement.setChecked(SharedPreferenceUtil.isBadgeIncrement());
    UITableItemView localUITableItemView = this.mBadgeOnlyIncrement;
    if (SharedPreferenceUtil.isBadgeOpen()) {}
    for (int i = 0;; i = 8)
    {
      localUITableItemView.setVisibility(i);
      this.mBadgeTable.setClickListener(this.badgeClickListener);
      this.mBadgeTable.commit();
      return;
    }
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingMailRemindActivity.class);
  }
  
  private void createRemindTimeTable()
  {
    this.mRemindTimeTable = new UITableView(this);
    this.mSettingView.addContentView(this.mRemindTimeTable);
    this.mChildRemindTime = this.mRemindTimeTable.addItem(2131719899);
    this.mChildRemindTime.setChecked(QMSettingManager.sharedInstance().getUseNightMode());
    this.mRemindTimeTable.setDescription(2131719900);
    this.mRemindTimeTable.setClickListener(this.remindTimeTableClickListener);
    this.mRemindTimeTable.commit();
  }
  
  private void createSoundEffectsTable()
  {
    this.mSoundEffectsTable = new UITableView(this);
    this.mSettingView.addContentView(this.mSoundEffectsTable);
    this.mChildSoundTableNewMail = this.mSoundEffectsTable.addItem(2131719893);
    this.mChildSoundTableVip = this.mSoundEffectsTable.addItem(2131719884);
    this.mChildSoundTableNewMail.setDetail("");
    this.mChildSoundTableVip.setDetail("");
    this.mSoundEffectsTable.setClickListener(this.soundTableClickListener);
    this.mSoundEffectsTable.commit();
  }
  
  private void createVoiceAndVibrateTable()
  {
    this.mVoiceAndVibrateTable = new UITableView(this);
    this.mSettingView.addContentView(this.mVoiceAndVibrateTable);
    this.newMailPushVoiceItemView = this.mVoiceAndVibrateTable.addItem(2131719935);
    this.newMailPushVoiceItemView.setChecked(QMSettingManager.sharedInstance().getEnableSoundPushNewMail());
    this.newMailPushVibrateItemView = this.mVoiceAndVibrateTable.addItem(2131719936);
    this.newMailPushVibrateItemView.setChecked(QMSettingManager.sharedInstance().getEnablePushNewMailVibrate());
    this.mVoiceAndVibrateTable.setClickListener(this.soundAndVibrateClickListener);
    this.mVoiceAndVibrateTable.commit();
  }
  
  private void initSoundTable(boolean paramBoolean)
  {
    UITableItemView localUITableItemView;
    if (paramBoolean)
    {
      localUITableItemView = this.mChildSoundTableNewMail;
      if (localUITableItemView != null) {
        break label25;
      }
    }
    for (;;)
    {
      return;
      localUITableItemView = this.mChildSoundTableVip;
      break;
      label25:
      String str1;
      if ((QMPushManager.isMiPushWorking()) && (AccountManager.shareInstance().getAccountList().hasQQMailAccounts()))
      {
        i = 1;
        if (!paramBoolean) {
          break label100;
        }
        str1 = QMSettingManager.sharedInstance().getSoundTypeNewMailFrom();
        label57:
        if (!paramBoolean) {
          break label111;
        }
      }
      label100:
      label111:
      for (String str2 = QMSettingManager.sharedInstance().getSoundTypeNewMailString();; str2 = QMSettingManager.sharedInstance().getSoundTypeKeyManString())
      {
        if (!str2.equals("default")) {
          break label122;
        }
        localUITableItemView.setDetail(getResources().getString(2131720011));
        return;
        i = 0;
        break;
        str1 = QMSettingManager.sharedInstance().getSoundTypeKeyManFrom();
        break label57;
      }
      label122:
      if (i != 0)
      {
        str2 = str2.split("\\.")[0];
        if (QMPushManager.OWN_SOUND_LIST.contains(str2))
        {
          if ("0".equals(str1))
          {
            if (!paramBoolean) {
              break label210;
            }
            QMSettingManager.sharedInstance().setSoundTypeNewMail(str2, true);
            QMPrivateProtocolManager.sharedInstance().setNotifyNewMailSound("mipush_" + str2);
          }
          for (;;)
          {
            localUITableItemView.setDetail(str2);
            return;
            QMSettingManager.sharedInstance().setSoundTypeKeyMan(str2, true);
            QMPrivateProtocolManager.sharedInstance().setPushVipSound("mipush_" + str2);
          }
        }
        if (paramBoolean)
        {
          QMSettingManager.sharedInstance().setSoundTypeNewMail("default", true);
          QMPrivateProtocolManager.sharedInstance().setNotifyNewMailSound("default");
        }
        for (;;)
        {
          localUITableItemView.setDetail(getResources().getString(2131720011));
          return;
          QMSettingManager.sharedInstance().setSoundTypeKeyMan("default", true);
          QMPrivateProtocolManager.sharedInstance().setPushVipSound("default");
        }
      }
      label210:
      File[] arrayOfFile = new File("/system/media/audio/notifications").listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length <= 0)) {
        break label474;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        String str3 = localFile.getName().split("\\.")[0];
        if ((localFile.getName().equals(str2)) || (str3.equals(str2)))
        {
          if ("1".equals(str1))
          {
            if (!paramBoolean) {
              break label441;
            }
            QMSettingManager.sharedInstance().setSoundTypeNewMail(localFile.getName(), false);
            QMPrivateProtocolManager.sharedInstance().setNotifyNewMailSound(localFile.getName());
          }
          for (;;)
          {
            localUITableItemView.setDetail(str2.split("\\.")[0]);
            return;
            label441:
            QMSettingManager.sharedInstance().setSoundTypeKeyMan(localFile.getName(), true);
            QMPrivateProtocolManager.sharedInstance().setPushVipSound(localFile.getName());
          }
        }
        i += 1;
      }
    }
    label474:
    if (paramBoolean)
    {
      QMSettingManager.sharedInstance().setSoundTypeNewMail("default", false);
      QMPrivateProtocolManager.sharedInstance().setNotifyNewMailSound("default");
    }
    for (;;)
    {
      localUITableItemView.setDetail(getResources().getString(2131720011));
      return;
      QMSettingManager.sharedInstance().setSoundTypeKeyMan("default", false);
      QMPrivateProtocolManager.sharedInstance().setPushVipSound("default");
    }
  }
  
  private void initTable()
  {
    if (this.mMainTable == null)
    {
      this.mMainTable = new UITableView(this);
      this.mSettingView.addContentView(this.mMainTable);
      boolean bool1 = QMSettingManager.sharedInstance().getNotifyNewMail();
      this.newMailPushMainItemView = this.mMainTable.addItem(2131719937);
      this.newMailPushMainItemView.setChecked(bool1);
      this.mMainTable.setClickListener(this.mainTableClickListener);
      this.mMainTable.commit();
      if (!bool1) {
        break label273;
      }
      if (this.hasInit) {
        break label210;
      }
      boolean bool2 = AccountManager.shareInstance().getAccountList().hasProtocolAccount();
      if ((!QMPushManager.isHwPushWorking()) || (bool2)) {
        createVoiceAndVibrateTable();
      }
      if ((!QMPushManager.isHwPushWorking()) || (bool2)) {
        createSoundEffectsTable();
      }
      createADMailNotifyAndRemindVipAndShowMailDetailTable();
      if ((BadgeUtil.getInstance().isSupportBadge()) && ((!QMPushManager.isHwPushWorking()) || (bool2))) {
        createBadgeTable();
      }
      createAccountTable();
      createRemindTimeTable();
      this.hasInit = true;
      label167:
      if (this.mSoundEffectsTable != null)
      {
        if ((!bool1) || (!QMSettingManager.sharedInstance().getEnableSoundPushNewMail())) {
          break label340;
        }
        this.mSoundEffectsTable.setVisibility(0);
      }
    }
    for (;;)
    {
      updateAccountTableVisibility();
      return;
      this.mMainTable.clear();
      break;
      label210:
      if (this.mVoiceAndVibrateTable != null) {
        this.mVoiceAndVibrateTable.setVisibility(0);
      }
      if (this.mADMailNotifyAndRemindVipAndShowMailDetailTable != null) {
        this.mADMailNotifyAndRemindVipAndShowMailDetailTable.setVisibility(0);
      }
      if (this.mBadgeTable != null) {
        this.mBadgeTable.setVisibility(0);
      }
      if (this.mRemindTimeTable == null) {
        break label167;
      }
      this.mRemindTimeTable.setVisibility(0);
      break label167;
      label273:
      if (this.mVoiceAndVibrateTable != null) {
        this.mVoiceAndVibrateTable.setVisibility(8);
      }
      if (this.mADMailNotifyAndRemindVipAndShowMailDetailTable != null) {
        this.mADMailNotifyAndRemindVipAndShowMailDetailTable.setVisibility(8);
      }
      if (this.mBadgeTable != null) {
        this.mBadgeTable.setVisibility(8);
      }
      if (this.mRemindTimeTable == null) {
        break label167;
      }
      this.mRemindTimeTable.setVisibility(8);
      break label167;
      label340:
      this.mSoundEffectsTable.setVisibility(8);
    }
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719937);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void updateAccountTableVisibility()
  {
    if (this.mAccountTable != null)
    {
      if ((QMSettingManager.sharedInstance().getNotifyNewMail()) && (!QMSettingManager.sharedInstance().getOnlyNotifyVIP())) {
        this.mAccountTable.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.mAccountTable.setVisibility(8);
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
    initTable();
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
    initSoundTable(true);
    initSoundTable(false);
  }
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingMailRemindActivity
 * JD-Core Version:    0.7.0.1
 */