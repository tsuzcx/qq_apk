package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

public class SettingContactActivity
  extends BaseActivityEx
{
  private static final String TAG = "SettingContactActivity";
  private boolean checked;
  private QMBaseView mSettingView;
  private UITableView mShowTable;
  private UITableView mStatusTable;
  private UITableItemView showItemView;
  private UITableView.ClickListener showTableClickListener = new SettingContactActivity.2(this);
  private UITableItemView statusItemView;
  private UITableView.ClickListener statusTableClickListener = new SettingContactActivity.1(this);
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingContactActivity.class);
  }
  
  private void createShowTable()
  {
    this.mShowTable = new UITableView(this);
    this.mSettingView.addContentView(this.mShowTable);
    this.mShowTable.setClickListener(this.showTableClickListener);
    this.showItemView = this.mShowTable.addItem(2131719652);
    if (FolderDataManager.getInnerAppIdList().indexOf(Integer.valueOf(-22)) == -1) {
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
    this.statusItemView = this.mStatusTable.addItem(2131692063);
    this.checked = QMSettingManager.sharedInstance().getContactDisplay();
    this.statusItemView.setChecked(this.checked);
    this.mStatusTable.setClickListener(this.statusTableClickListener);
    this.mStatusTable.commit();
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131692063);
    localQMTopBar.setButtonLeftBack();
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
    createStatusTable();
    createShowTable();
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
  
  public void refreshData() {}
  
  public void render()
  {
    if (this.checked)
    {
      this.mShowTable.setVisibility(0);
      return;
    }
    this.mShowTable.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingContactActivity
 * JD-Core Version:    0.7.0.1
 */