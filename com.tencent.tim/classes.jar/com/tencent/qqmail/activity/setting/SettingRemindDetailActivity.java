package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.List;

public class SettingRemindDetailActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_account_id";
  private static final String TAG = "SettingRemindDetailActivity";
  private Account account;
  private int accountId;
  private UITableView.ClickListener detailTableClickListener = new SettingRemindDetailActivity.2(this);
  private UITableItemView groupItemView;
  private UITableItemView inboxItemView;
  private UITableView mDetailTableView;
  private UITableView mMainTableView;
  private QMBaseView mSettingView;
  private UITableItemView mainSwitchItemView;
  private UITableView.ClickListener mainTableClickListener = new SettingRemindDetailActivity.1(this);
  private UITableItemView onlyNotifyInboxItemView;
  private UITableItemView onlyPushAPPItemView;
  private UITableView onlyPushAPPTableView;
  private UITableItemView popMailItemView;
  private UITableItemView subscribeItemView;
  private UITableItemView usrFolderItemView;
  
  private boolean checkFolderPushClose()
  {
    boolean bool = false;
    ArrayList localArrayList1 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 12);
    ArrayList localArrayList2 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 13);
    ArrayList localArrayList3 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 1);
    ArrayList localArrayList4 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 8);
    ArrayList localArrayList5 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 15);
    int m;
    int j;
    int i;
    int k;
    if (localArrayList1 != null)
    {
      m = localArrayList1.size();
      j = 0;
      for (i = 0; j < localArrayList1.size(); i = k)
      {
        k = i;
        if (!((QMFolder)localArrayList1.get(j)).isPush()) {
          k = i + 1;
        }
        j += 1;
      }
      m = 0 + m;
      j = i;
    }
    for (;;)
    {
      i = j;
      k = m;
      int n;
      if (localArrayList2 != null)
      {
        n = localArrayList2.size();
        k = 0;
        i = j;
        j = k;
        while (j < localArrayList2.size())
        {
          k = i;
          if (!((QMFolder)localArrayList2.get(j)).isPush()) {
            k = i + 1;
          }
          j += 1;
          i = k;
        }
        k = m + n;
      }
      j = i;
      m = k;
      if (localArrayList3 != null)
      {
        n = localArrayList3.size();
        j = 0;
        while (j < localArrayList3.size())
        {
          m = i;
          if (!((QMFolder)localArrayList3.get(j)).isPush()) {
            m = i + 1;
          }
          j += 1;
          i = m;
        }
        m = k + n;
        j = i;
      }
      i = j;
      k = m;
      if (localArrayList4 != null)
      {
        n = localArrayList4.size();
        k = 0;
        i = j;
        j = k;
        while (j < localArrayList4.size())
        {
          k = i;
          if (!((QMFolder)localArrayList4.get(j)).isPush()) {
            k = i + 1;
          }
          j += 1;
          i = k;
        }
        k = m + n;
      }
      if (localArrayList5 != null)
      {
        n = localArrayList5.size();
        j = 0;
        while (j < localArrayList5.size())
        {
          m = i;
          if (!((QMFolder)localArrayList5.get(j)).isPush()) {
            m = i + 1;
          }
          j += 1;
          i = m;
        }
      }
      for (j = k + n;; j = k)
      {
        if (i == j) {
          bool = true;
        }
        return bool;
      }
      j = 0;
      m = 0;
    }
  }
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingRemindDetailActivity.class);
    localIntent.putExtra("arg_account_id", paramInt);
    return localIntent;
  }
  
  private void initDetailTable()
  {
    label137:
    label195:
    int i;
    if (this.mDetailTableView == null)
    {
      this.mDetailTableView = new UITableView(this);
      this.mSettingView.addContentView(this.mDetailTableView);
      if (this.mainSwitchItemView.isChecked())
      {
        if (!this.account.isQQMail()) {
          break label573;
        }
        ArrayList localArrayList1 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 1);
        ArrayList localArrayList2 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 8);
        ArrayList localArrayList3 = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 15);
        this.inboxItemView = this.mDetailTableView.addItem(2131719923);
        if ((localArrayList1 == null) || (localArrayList1.size() < 1)) {
          break label487;
        }
        this.inboxItemView.setChecked(((QMFolder)localArrayList1.get(0)).isPush());
        if (!this.account.isBizMail())
        {
          this.groupItemView = this.mDetailTableView.addItem(2131719924);
          if ((localArrayList2 == null) || (localArrayList2.size() < 1)) {
            break label499;
          }
          this.groupItemView.setChecked(((QMFolder)localArrayList2.get(0)).isPush());
          if (!QMSettingManager.sharedInstance().getAggregateSubscribeMail())
          {
            this.subscribeItemView = this.mDetailTableView.addItem(2131719929);
            if ((localArrayList3 == null) || (localArrayList3.size() < 1)) {
              break label511;
            }
            Log.d("mason", "sub 1, " + ((QMFolder)localArrayList3.get(0)).isPush() + ", " + ((QMFolder)localArrayList3.get(0)).getName());
            this.subscribeItemView.setChecked(((QMFolder)localArrayList3.get(0)).isPush());
          }
        }
        label315:
        if (QMMailManager.sharedInstance().getUserFldCnt(this.accountId) > 0)
        {
          this.usrFolderItemView = this.mDetailTableView.addItem(2131719927);
          i = QMMailManager.sharedInstance().getUserFldPushOnCnt(this.accountId);
          if (i > 0) {
            break label532;
          }
          this.usrFolderItemView.setDetail("关闭");
        }
        label365:
        if (QMMailManager.sharedInstance().getPopFolderCount(this.accountId) > 0)
        {
          this.popMailItemView = this.mDetailTableView.addItem(2131719928);
          i = QMMailManager.sharedInstance().getPopFldPushOnCount(this.accountId);
          if (i < 1) {
            break label561;
          }
          Log.d("mason", "popOnCount 1 : " + i);
          this.popMailItemView.setDetail(i + "");
        }
      }
    }
    for (;;)
    {
      this.mDetailTableView.setClickListener(this.detailTableClickListener);
      this.mDetailTableView.commit();
      return;
      this.mDetailTableView.clear();
      break;
      label487:
      this.inboxItemView.setChecked(true);
      break label137;
      label499:
      this.groupItemView.setChecked(true);
      break label195;
      label511:
      Log.d("mason", "sub 2");
      this.subscribeItemView.setChecked(true);
      break label315;
      label532:
      this.usrFolderItemView.setDetail("" + i);
      break label365;
      label561:
      this.popMailItemView.setDetail("关闭");
      continue;
      label573:
      if ((isTencentMail()) && (this.mDetailTableView != null))
      {
        this.mDetailTableView.setVisibility(8);
      }
      else if (!this.account.isPopMail())
      {
        this.onlyNotifyInboxItemView = this.mDetailTableView.addItem(2131719925);
        this.onlyNotifyInboxItemView.setChecked(QMSettingManager.sharedInstance().getPushInboxOnly(this.accountId));
        this.mDetailTableView.setDescription(2131719926);
      }
    }
  }
  
  private void initMainTable()
  {
    this.mMainTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mMainTableView);
    this.mainSwitchItemView = this.mMainTableView.addItem(2131719937);
    this.mainSwitchItemView.setChecked(QMSettingManager.sharedInstance().getNotifyAccountMail(this.accountId));
    this.mMainTableView.setClickListener(this.mainTableClickListener);
    this.mMainTableView.commit();
  }
  
  private void initOnlyPushMailApp() {}
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(this.account.getEmail());
    localQMTopBar.setButtonLeftBack();
  }
  
  private boolean isTencentMail()
  {
    return (this.account != null) && (this.account.getEmail() != null) && (this.account.getEmail().toLowerCase().endsWith("@tencent.com"));
  }
  
  private void setQQMailPushStatus(boolean paramBoolean)
  {
    ArrayList localArrayList = QMFolderManager.sharedInstance().getFoldersByAccountId(this.accountId);
    int[] arrayOfInt = new int[localArrayList.size()];
    String[] arrayOfString = new String[localArrayList.size()];
    boolean[] arrayOfBoolean = new boolean[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((QMFolder)localArrayList.get(i)).getId();
      arrayOfString[i] = ((QMFolder)localArrayList.get(i)).getRemoteId();
      arrayOfBoolean[i] = paramBoolean;
      i += 1;
    }
    QMFolderManager.sharedInstance().updateFolderPushStatus(arrayOfInt, arrayOfBoolean);
    QMMailManager.sharedInstance().updateFolderPushStatus(this.accountId, arrayOfString, arrayOfBoolean);
  }
  
  private void updateFolderPushStatus(int paramInt, boolean paramBoolean)
  {
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(paramInt);
    if (localQMFolder != null)
    {
      QMFolderManager.sharedInstance().updateFolderPushStatus(new int[] { paramInt }, new boolean[] { paramBoolean });
      QMMailManager.sharedInstance().updateFolderPushStatus(this.accountId, new String[] { localQMFolder.getRemoteId() }, new boolean[] { paramBoolean });
    }
  }
  
  public void initDataSource()
  {
    this.accountId = getIntent().getIntExtra("arg_account_id", 0);
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
  }
  
  public void initDom()
  {
    initTopBar();
    initMainTable();
    initDetailTable();
    initOnlyPushMailApp();
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
    int i;
    if (this.popMailItemView != null)
    {
      i = QMMailManager.sharedInstance().getPopFldPushOnCount(this.accountId);
      if (i >= 1) {
        this.popMailItemView.setDetail(i + "");
      }
    }
    else
    {
      if (this.usrFolderItemView != null)
      {
        i = QMMailManager.sharedInstance().getUserFldPushOnCnt(this.accountId);
        if (i > 0) {
          break label172;
        }
        this.usrFolderItemView.setDetail("关闭");
      }
      label80:
      if (this.account.isQQMail())
      {
        if (!checkFolderPushClose()) {
          break label201;
        }
        Log.w("mason", "close mail push main switch.");
        this.mainSwitchItemView.setChecked(false);
        initDetailTable();
        initOnlyPushMailApp();
      }
    }
    for (;;)
    {
      if (((this.account.isBizMail()) || (!this.account.isQQMail())) && (this.onlyPushAPPTableView != null)) {
        this.onlyPushAPPTableView.setVisibility(8);
      }
      return;
      this.popMailItemView.setDetail("关闭");
      break;
      label172:
      this.usrFolderItemView.setDetail("" + i);
      break label80;
      label201:
      if ((this.subscribeItemView != null) && (QMSettingManager.sharedInstance().getAggregateSubscribeMail())) {
        this.subscribeItemView.setVisibility(8);
      }
    }
  }
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingRemindDetailActivity
 * JD-Core Version:    0.7.0.1
 */