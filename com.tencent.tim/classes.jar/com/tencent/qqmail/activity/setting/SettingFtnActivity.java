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
import com.tencent.qqmail.ftn.Ftn.ShowUsrOutput;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnUserProfile;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.FtnQueryAccountWatcher;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingFtnActivity
  extends BaseActivityEx
{
  public static final String TAG = "SettingFtnActivity";
  private int accountId;
  private UITableView.ClickListener accountTableClickListener = new SettingFtnActivity.4(this);
  private boolean checked;
  private UITableItemView defaultAccountItemView;
  private UITableView mAccountTable;
  private QMBaseView mSettingView;
  private UITableView mShowTable;
  private UITableView mStatusTable;
  private UITableItemView showItemView;
  private UITableView.ClickListener showTableClickListener = new SettingFtnActivity.3(this);
  private UITableItemView statusItemView;
  private UITableView.ClickListener statusTableClickListener = new SettingFtnActivity.2(this);
  private UITableItemView timeItemView;
  private UITableItemView usageItemView;
  private FtnQueryAccountWatcher watcher = new SettingFtnActivity.1(this);
  
  private String buildUsage(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1 / 1024.0F;
    String str1 = "M";
    paramFloat1 = f;
    if (f > 1024.0F)
    {
      paramFloat1 = f / 1024.0F;
      str1 = "G";
    }
    f = paramFloat1;
    if (paramFloat1 > 1024.0F)
    {
      f = paramFloat1 / 1024.0F;
      str1 = "T";
    }
    paramFloat2 /= 1024.0F;
    String str2 = "G";
    paramFloat1 = paramFloat2;
    if (paramFloat2 > 1024.0F)
    {
      paramFloat1 = paramFloat2 / 1024.0F;
      str2 = "T";
    }
    BigDecimal localBigDecimal = new BigDecimal(f);
    return localBigDecimal.setScale(1, 4).floatValue() + str1 + " / " + paramFloat1 + str2;
  }
  
  private void createAccountTable()
  {
    this.mAccountTable = new UITableView(this);
    this.mSettingView.addContentView(this.mAccountTable);
    this.defaultAccountItemView = this.mAccountTable.addItem(2131719725);
    this.defaultAccountItemView.setDetail("");
    int i = QMSettingManager.sharedInstance().getDefaultFtnAccountID();
    Object localObject;
    if (i != -1)
    {
      localObject = AccountManager.shareInstance().getAccountList().getAccountById(i);
      if (getQQAccountNum() >= 2) {
        break label127;
      }
      UITableItemView localUITableItemView1 = this.defaultAccountItemView;
      localObject = ((Account)localObject).getEmail();
      UITableItemView localUITableItemView2 = this.defaultAccountItemView;
      localUITableItemView1.setDetail((String)localObject, UITableItemView.STYLE_GRAY);
      this.defaultAccountItemView.setEnabled(false);
    }
    for (;;)
    {
      this.mAccountTable.setClickListener(this.accountTableClickListener);
      this.mAccountTable.commit();
      return;
      label127:
      this.defaultAccountItemView.setDetail(((Account)localObject).getEmail());
    }
  }
  
  private void createFtnInfoTable()
  {
    float f1 = 0.0F;
    UITableView localUITableView = new UITableView(this);
    this.mSettingView.addContentView(localUITableView);
    long l = 0L;
    Object localObject = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    float f2;
    if (localObject != null)
    {
      localObject = readFtnUserProfile(((QQMailAccount)localObject).getUin());
      if (localObject != null)
      {
        f2 = ((FtnUserProfile)localObject).getUsage();
        f1 = ((FtnUserProfile)localObject).getStorage();
        l = ((FtnUserProfile)localObject).getPreserverDay();
      }
    }
    for (;;)
    {
      localObject = buildUsage(f2, f1);
      this.usageItemView = localUITableView.addItem(2131719849);
      this.usageItemView.hideArrow();
      this.usageItemView.setDetail((String)localObject, UITableItemView.STYLE_GRAY);
      this.timeItemView = localUITableView.addItem(2131719848);
      this.timeItemView.hideArrow();
      this.timeItemView.setDetail(l + "天", UITableItemView.STYLE_GRAY);
      localUITableView.commit();
      return;
      f2 = 0.0F;
    }
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingFtnActivity.class);
  }
  
  private void createShowTable()
  {
    this.mShowTable = new UITableView(this);
    this.mSettingView.addContentView(this.mShowTable);
    this.mShowTable.setClickListener(this.showTableClickListener);
    this.showItemView = this.mShowTable.addItem(2131719652);
    if (FolderDataManager.getInnerAppIdList().indexOf(Integer.valueOf(-5)) == -1) {
      this.showItemView.setChecked(true);
    }
    for (;;)
    {
      this.mShowTable.commit();
      return;
      this.showItemView.setChecked(false);
    }
  }
  
  private void createStatusTable()
  {
    this.mStatusTable = new UITableView(this);
    this.mSettingView.addContentView(this.mStatusTable);
    this.checked = QMSettingManager.sharedInstance().getFtnDisplay();
    this.statusItemView = this.mStatusTable.addItem(2131694073);
    this.statusItemView.setChecked(this.checked);
    this.mStatusTable.setClickListener(this.statusTableClickListener);
    this.mStatusTable.commit();
  }
  
  private int getQQAccountNum()
  {
    return AccountManager.shareInstance().getAccountList().getQQAccountList().size();
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131694073);
    localQMTopBar.setButtonLeftBack();
  }
  
  private FtnUserProfile readFtnUserProfile(String paramString)
  {
    FtnManager localFtnManager = FtnManager.sharedInstance();
    if ((!StringExtention.isNullOrEmpty(paramString)) && (localFtnManager != null)) {
      return localFtnManager.getUserProfile(paramString);
    }
    return null;
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
    createStatusTable();
    createShowTable();
    createAccountTable();
    createFtnInfoTable();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    if (FtnManager.sharedInstance() != null) {
      FtnManager.sharedInstance().bindFtnQueryAccountListener(this.watcher, paramBoolean);
    }
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData()
  {
    this.accountId = QMSettingManager.sharedInstance().getDefaultFtnAccountID();
    Object localObject;
    if (this.accountId != -1)
    {
      localObject = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
      this.defaultAccountItemView.setDetail(((Account)localObject).getEmail());
    }
    if (FtnManager.sharedInstance() != null) {
      FtnManager.sharedInstance().queryAccount();
    }
    if ((SettingActivity.ADDACCOUNT == SettingActivity.ADDING) && (getQQAccountNum() > 0))
    {
      QMSettingManager.sharedInstance().setFtnDisplay(true);
      this.statusItemView.setChecked(true);
      SettingActivity.ADDACCOUNT = SettingActivity.ADDSUCCESS;
      this.checked = QMSettingManager.sharedInstance().getFtnDisplay();
      if (!this.checked) {
        break label261;
      }
      this.mAccountTable.setVisibility(0);
      this.usageItemView.setVisibility(0);
      this.timeItemView.setVisibility(0);
      this.mShowTable.setVisibility(0);
    }
    for (;;)
    {
      localObject = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
      if (localObject != null)
      {
        localObject = readFtnUserProfile(((QQMailAccount)localObject).getUin());
        if (localObject != null)
        {
          String str = buildUsage(((FtnUserProfile)localObject).getUsage(), ((FtnUserProfile)localObject).getStorage());
          if (this.usageItemView != null) {
            this.usageItemView.setDetail(str);
          }
          localObject = ((FtnUserProfile)localObject).getPreserverDay() + "天";
          if (this.timeItemView != null) {
            this.timeItemView.setDetail((String)localObject);
          }
        }
      }
      return;
      if ((SettingActivity.ADDACCOUNT != SettingActivity.ADDING) || (getQQAccountNum() != 0)) {
        break;
      }
      SettingActivity.ADDACCOUNT = SettingActivity.NOADD;
      break;
      label261:
      this.mAccountTable.setVisibility(4);
      this.usageItemView.setVisibility(4);
      this.timeItemView.setVisibility(4);
      this.mShowTable.setVisibility(4);
    }
  }
  
  public void render() {}
  
  public void setFtnDetail(HashMap<String, Object> paramHashMap)
  {
    paramHashMap = (ShowUsrOutput)paramHashMap.get("paramqueryaccountinfo");
    if (paramHashMap == null) {}
    do
    {
      return;
      String str = buildUsage(paramHashMap.usage, paramHashMap.storage);
      if (this.usageItemView != null) {
        this.usageItemView.setDetail(str);
      }
      paramHashMap = paramHashMap.storeday + "天";
    } while (this.timeItemView == null);
    this.timeItemView.setDetail(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingFtnActivity
 * JD-Core Version:    0.7.0.1
 */