package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.List;

public class SettingRemindSubAccountActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_account_id";
  private static final String TAG = "SettingRemindSubAccountActivity";
  private int accountId;
  private UITableView.ClickListener detailTableClickListener = new SettingRemindSubAccountActivity.2(this);
  private int folderOnCount;
  private List<QMFolder> folders;
  private UITableView mDetailTableView;
  private UITableView mMainTableView;
  private QMBaseView mSettingView;
  private UITableItemView mainSwitchItemView;
  private UITableView.ClickListener mainTableClickListener = new SettingRemindSubAccountActivity.1(this);
  private int popOnCount;
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingRemindSubAccountActivity.class);
    localIntent.putExtra("arg_account_id", paramInt);
    return localIntent;
  }
  
  private void initDetailTable()
  {
    this.mDetailTableView = new UITableView(this);
    this.mDetailTableView.setCaption(2131719928);
    this.mSettingView.addContentView(this.mDetailTableView);
    this.folders = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 13);
    int i = 0;
    while (i < this.folders.size())
    {
      QMFolder localQMFolder = (QMFolder)this.folders.get(i);
      this.mDetailTableView.addItem(localQMFolder.getName()).setChecked(localQMFolder.isPush());
      if (localQMFolder.isPush()) {
        this.folderOnCount += 1;
      }
      i += 1;
    }
    this.mDetailTableView.setClickListener(this.detailTableClickListener);
    this.mDetailTableView.commit();
  }
  
  private void initMainTable()
  {
    this.mMainTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mMainTableView);
    this.mainSwitchItemView = this.mMainTableView.addItem(2131719928);
    UITableItemView localUITableItemView = this.mainSwitchItemView;
    if (this.popOnCount > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localUITableItemView.setChecked(bool);
      this.mMainTableView.setClickListener(this.mainTableClickListener);
      this.mMainTableView.commit();
      return;
    }
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719928);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void saveRemindSubAccount()
  {
    int j = 1;
    int m = 0;
    int k = 0;
    if (this.mDetailTableView != null)
    {
      int n = this.mDetailTableView.getChildCount();
      boolean[] arrayOfBoolean = new boolean[this.folders.size()];
      int[] arrayOfInt = new int[this.folders.size()];
      String[] arrayOfString = new String[this.folders.size()];
      int i = j;
      if (this.mMainTableView != null)
      {
        i = j;
        if (this.mainSwitchItemView.isChecked())
        {
          i = 1;
          for (;;)
          {
            j = k;
            if (i >= n) {
              break;
            }
            arrayOfBoolean[(i - 1)] = ((UITableItemView)this.mDetailTableView.getChildAt(i)).isChecked();
            i += 1;
          }
          while (j < this.folders.size())
          {
            arrayOfInt[j] = ((QMFolder)this.folders.get(j)).getId();
            arrayOfString[j] = ((QMFolder)this.folders.get(j)).getRemoteId();
            j += 1;
          }
        }
      }
      for (;;)
      {
        j = m;
        if (i >= n) {
          break;
        }
        arrayOfBoolean[(i - 1)] = false;
        i += 1;
      }
      while (j < this.folders.size())
      {
        arrayOfInt[j] = ((QMFolder)this.folders.get(j)).getId();
        arrayOfString[j] = ((QMFolder)this.folders.get(j)).getRemoteId();
        j += 1;
      }
      QMFolderManager.sharedInstance().updateFolderPushStatus(arrayOfInt, arrayOfBoolean);
      QMMailManager.sharedInstance().updateFolderPushStatus(this.accountId, arrayOfString, arrayOfBoolean);
    }
  }
  
  private void setDetailTableCheck(boolean paramBoolean)
  {
    if (this.mDetailTableView != null)
    {
      int i = 1;
      while (i < this.mDetailTableView.getChildCount())
      {
        ((UITableItemView)this.mDetailTableView.getChildAt(i)).setChecked(paramBoolean);
        i += 1;
      }
    }
  }
  
  public void initDataSource()
  {
    this.accountId = getIntent().getIntExtra("arg_account_id", 0);
    this.popOnCount = QMMailManager.sharedInstance().getPopFldPushOnCount(this.accountId);
  }
  
  public void initDom()
  {
    initTopBar();
    initMainTable();
    if (this.popOnCount > 0) {
      initDetailTable();
    }
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBackPressed()
  {
    saveRemindSubAccount();
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onButtonBackClick()
  {
    saveRemindSubAccount();
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
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingRemindSubAccountActivity
 * JD-Core Version:    0.7.0.1
 */