package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import org.apache.commons.lang3.StringUtils;

public class SettingQmDefaultAliasActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_account_id";
  public static final String TAG = "SettingQmDefaultAliasActivity";
  private Account account;
  private int accountId;
  private String[] aliases = null;
  private int defaultComposeAliasId = 0;
  private QMRadioGroup.OnCheckedChangeListener mDefaultComposeAccountCheckListener = new SettingQmDefaultAliasActivity.2(this);
  private QMRadioGroup mDefaultComposeAliasRadioGroup;
  private QMBaseView mSettingView;
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingQmDefaultAliasActivity.class);
    localIntent.putExtra("arg_account_id", paramInt);
    return localIntent;
  }
  
  private int indexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    if (paramArrayOfObject != null)
    {
      int j = paramArrayOfObject.length;
      if (j > 0)
      {
        int i = 0;
        if (i < j)
        {
          if (paramArrayOfObject[i] == null) {}
          while (!paramArrayOfObject[i].equals(paramObject))
          {
            i += 1;
            break;
          }
          return i;
        }
      }
    }
    return -1;
  }
  
  private void initDefaultComposeAccountRadioGroup()
  {
    this.mDefaultComposeAliasRadioGroup = new QMRadioGroup(this);
    this.mDefaultComposeAliasRadioGroup.setDescription(2131719640);
    this.mSettingView.addContentView(this.mDefaultComposeAliasRadioGroup);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131689738);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void renderDefaultComposeAccountRadioGroup()
  {
    if (this.account == null) {
      finish();
    }
    this.mDefaultComposeAliasRadioGroup.clear();
    if ((this.aliases != null) && (this.aliases.length > 0))
    {
      int i = 0;
      if (i < this.aliases.length)
      {
        if (StringUtils.isEmpty(this.aliases[i])) {}
        for (;;)
        {
          i += 1;
          break;
          this.mDefaultComposeAliasRadioGroup.addItem(i, this.aliases[i]);
        }
      }
    }
    this.mDefaultComposeAliasRadioGroup.setOnCheckedChangeListener(this.mDefaultComposeAccountCheckListener);
    this.mDefaultComposeAliasRadioGroup.setClickListenerWithoutSelector();
    this.mDefaultComposeAliasRadioGroup.commit();
    this.mDefaultComposeAliasRadioGroup.setSelectedItem(this.defaultComposeAliasId);
  }
  
  public void finish()
  {
    if (QMActivityManager.shareInstance().getActivitySize() <= 1)
    {
      startActivity(SettingAccountActivity.createIntent(this.accountId));
      overridePendingTransition(2130772421, 2130772420);
    }
    super.finish();
  }
  
  public void initDataSource()
  {
    this.accountId = getIntent().getIntExtra("arg_account_id", 0);
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
  }
  
  public void initDom()
  {
    initTopBar();
    initDefaultComposeAccountRadioGroup();
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
    if (QMComposeDataManager.sharedInstance().getQMDefaultNick(this.accountId) == null) {
      Threads.runInBackground(new SettingQmDefaultAliasActivity.1(this));
    }
    this.aliases = QMComposeDataManager.sharedInstance().getQMAlias(this.accountId);
    this.defaultComposeAliasId = indexOf(this.aliases, QMComposeDataManager.sharedInstance().getQMDefaultAlias(this.accountId));
  }
  
  public void render()
  {
    renderDefaultComposeAccountRadioGroup();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultAliasActivity
 * JD-Core Version:    0.7.0.1
 */