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

public class SettingRemindFoldersActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_account_id";
  private static final String TAG = "SettingRemindFoldersActivity";
  private int accountId;
  private UITableView.ClickListener detailTableClickListener = new SettingRemindFoldersActivity.2(this);
  private List<QMFolder> folderList;
  private int folderOnCount;
  private UITableView mDetailTableView;
  private UITableView mMainTableView;
  private QMBaseView mSettingView;
  private UITableView.ClickListener mainTableClickListener = new SettingRemindFoldersActivity.1(this);
  private UITableItemView myFolderItemView;
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingRemindFoldersActivity.class);
    localIntent.putExtra("arg_account_id", paramInt);
    return localIntent;
  }
  
  private void initDetailTable()
  {
    this.mDetailTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mDetailTableView);
    this.mDetailTableView.setCaption(2131719927);
    int i = 0;
    while (i < this.folderList.size())
    {
      QMFolder localQMFolder = (QMFolder)this.folderList.get(i);
      this.mDetailTableView.addItem(localQMFolder.getName()).setChecked(localQMFolder.isPush());
      i += 1;
    }
    this.mDetailTableView.setClickListener(this.detailTableClickListener);
    this.mDetailTableView.commit();
  }
  
  private void initMainTable()
  {
    this.mMainTableView = new UITableView(this);
    this.mSettingView.addContentView(this.mMainTableView);
    this.myFolderItemView = this.mMainTableView.addItem(2131719927);
    UITableItemView localUITableItemView = this.myFolderItemView;
    if (this.folderOnCount > 0) {}
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
    localQMTopBar.setTitle(2131719927);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void saveRemindFolders()
  {
    if (this.mDetailTableView != null)
    {
      boolean[] arrayOfBoolean = new boolean[this.folderList.size()];
      int[] arrayOfInt = new int[this.folderList.size()];
      String[] arrayOfString = new String[this.folderList.size()];
      int i = 0;
      while (i < this.folderList.size())
      {
        arrayOfInt[i] = ((QMFolder)this.folderList.get(i)).getId();
        arrayOfString[i] = ((QMFolder)this.folderList.get(i)).getRemoteId();
        i += 1;
      }
      if ((this.mMainTableView != null) && (this.myFolderItemView.isChecked())) {
        i = 1;
      }
      while (i < this.folderList.size() + 1)
      {
        arrayOfBoolean[(i - 1)] = ((UITableItemView)this.mDetailTableView.getChildAt(i)).isChecked();
        i += 1;
        continue;
        i = 0;
        while (i < this.folderList.size())
        {
          arrayOfBoolean[i] = false;
          i += 1;
        }
      }
      QMFolderManager.sharedInstance().updateFolderPushStatus(arrayOfInt, arrayOfBoolean);
      QMMailManager.sharedInstance().updateFolderPushStatus(this.accountId, arrayOfString, arrayOfBoolean);
    }
  }
  
  private void setDetailTableAllCheck(boolean paramBoolean)
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
    this.folderList = QMFolderManager.sharedInstance().getFoldersByAccountAndType(this.accountId, 12);
    int i = 0;
    while (i < this.folderList.size())
    {
      QMFolder localQMFolder = (QMFolder)this.folderList.get(i);
      if ((localQMFolder != null) && (localQMFolder.isPush())) {
        this.folderOnCount += 1;
      }
      i += 1;
    }
  }
  
  public void initDom()
  {
    initTopBar();
    initMainTable();
    if (this.folderOnCount > 0) {
      initDetailTable();
    }
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBackPressed()
  {
    saveRemindFolders();
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onButtonBackClick()
  {
    saveRemindFolders();
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
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingRemindFoldersActivity
 * JD-Core Version:    0.7.0.1
 */