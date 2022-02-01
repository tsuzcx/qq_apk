package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.List;

public class SettingSelectAccountActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_account_id";
  private static final String ARG_ACTIVITY = "arg_from_activity";
  private static final int FROM_BOTTLE = 3;
  private static final int FROM_ERROR = 0;
  private static final int FROM_FTN = 2;
  private static final int FROM_NOTE = 1;
  private static final String TAG = "SettingSelectAccountActivity";
  private int accountId;
  private List<Integer> accounts;
  private int mFromActivityId;
  private QMRadioGroup mRadioGroup;
  private QMBaseView mSettingView;
  
  public static Intent createBottleIntent(int paramInt)
  {
    Intent localIntent = createIntent(paramInt);
    localIntent.putExtra("arg_from_activity", 3);
    return localIntent;
  }
  
  public static Intent createFtnIntent(int paramInt)
  {
    Intent localIntent = createIntent(paramInt);
    localIntent.putExtra("arg_from_activity", 2);
    return localIntent;
  }
  
  private static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingSelectAccountActivity.class);
    localIntent.putExtra("arg_account_id", paramInt);
    return localIntent;
  }
  
  public static Intent createNoteIntent(int paramInt)
  {
    Intent localIntent = createIntent(paramInt);
    localIntent.putExtra("arg_from_activity", 1);
    return localIntent;
  }
  
  private void createRadioGroup()
  {
    int m = 0;
    this.mRadioGroup = new QMRadioGroup(this);
    this.mSettingView.addContentView(this.mRadioGroup);
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    this.accounts = new ArrayList();
    int i = 0;
    int k;
    for (int j = 0; i < localAccountList.size(); j = k)
    {
      Account localAccount = localAccountList.get(i);
      k = j;
      if (localAccount.isQQMail()) {
        if (this.mFromActivityId == 3)
        {
          k = j;
          if (localAccount.isBizMail()) {}
        }
        else
        {
          this.mRadioGroup.addItem(j, localAccount.getEmail());
          this.accounts.add(Integer.valueOf(localAccount.getId()));
          k = j + 1;
        }
      }
      i += 1;
    }
    this.mRadioGroup.commit();
    i = m;
    for (;;)
    {
      if (i < this.accounts.size())
      {
        if (((Integer)this.accounts.get(i)).intValue() == this.accountId) {
          this.mRadioGroup.setSelectedItem(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719725);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void saveSelectAccount()
  {
    int i;
    if ((this.mRadioGroup != null) && (this.mRadioGroup.hasChange()))
    {
      i = this.mRadioGroup.getSelectedItem();
      if (this.mFromActivityId != 1) {
        break label76;
      }
      if ((this.accounts != null) && (i < this.accounts.size())) {
        QMSettingManager.sharedInstance().setDefaultNoteAccountID(((Integer)this.accounts.get(i)).intValue());
      }
    }
    label76:
    QQMailAccount localQQMailAccount;
    do
    {
      do
      {
        do
        {
          return;
          if (this.mFromActivityId != 3) {
            break;
          }
        } while ((this.accounts == null) || (i >= this.accounts.size()));
        if (((Integer)this.accounts.get(i)).intValue() != QMSettingManager.sharedInstance().getDefaultBottleAccountID()) {
          FolderDataManager.sharedInstance().setInnerBottleUnreadCount(0);
        }
        QMSettingManager.sharedInstance().setDefaultBottleAccountID(((Integer)this.accounts.get(i)).intValue());
        return;
      } while ((this.mFromActivityId != 2) || (this.accounts == null) || (i >= this.accounts.size()));
      if (((Integer)this.accounts.get(i)).intValue() != QMSettingManager.sharedInstance().getDefaultFtnAccountID()) {
        FolderDataManager.sharedInstance().setInnerFtnUnreadCount(0);
      }
      QMSettingManager.sharedInstance().setDefaultFtnAccountID(((Integer)this.accounts.get(i)).intValue());
      localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    } while ((localQQMailAccount == null) || (localQQMailAccount.getLoginUser() != null));
    localQQMailAccount.autoLogin();
  }
  
  public void initDataSource()
  {
    this.mFromActivityId = getIntent().getIntExtra("arg_from_activity", 0);
    this.accountId = getIntent().getIntExtra("arg_account_id", 0);
  }
  
  public void initDom()
  {
    initTopBar();
    createRadioGroup();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBackPressed()
  {
    saveSelectAccount();
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onButtonBackClick()
  {
    saveSelectAccount();
    super.onButtonBackClick();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSelectAccountActivity
 * JD-Core Version:    0.7.0.1
 */