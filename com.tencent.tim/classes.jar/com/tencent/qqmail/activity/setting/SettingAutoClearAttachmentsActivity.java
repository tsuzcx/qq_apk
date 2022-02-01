package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class SettingAutoClearAttachmentsActivity
  extends BaseActivityEx
{
  public static final String AUTO_CLEAR_ATTACHMETNS_LEVEL = "clear_attachment_period_level";
  public static final int AUTO_CLEAR_ATTACHMETNS_LEVEL_0 = 0;
  public static final int AUTO_CLEAR_ATTACHMETNS_LEVEL_1 = 3;
  public static final int AUTO_CLEAR_ATTACHMETNS_LEVEL_2 = 10;
  public static final int AUTO_CLEAR_ATTACHMETNS_LEVEL_3 = 30;
  public static final String AUTO_CLEAR_ATTACHMETNS_PERIOD = "clear_attachment_period";
  public static final int DEFAULT_CLEAR_ATTACHMENTS_TIME = 864000000;
  private UITableItemView cleanEvery30dItemView;
  private UITableItemView cleanEvery3dItemView;
  private UITableItemView cleanEvery7dItemView;
  private UITableView cleanListTableView;
  private QMBaseView mSettingView;
  private UITableItemView neverCleanItemView;
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingAutoClearAttachmentsActivity.class);
  }
  
  private void createSettingListTable()
  {
    this.cleanListTableView = new UITableView(this);
    this.mSettingView.addContentView(this.cleanListTableView);
    this.neverCleanItemView = this.cleanListTableView.addItem(2131719654);
    this.neverCleanItemView.setTailImage(2130850509);
    this.neverCleanItemView.setTag(Integer.valueOf(0));
    this.cleanEvery3dItemView = this.cleanListTableView.addItem(2131719656);
    this.cleanEvery3dItemView.setTailImage(2130850509);
    this.cleanEvery3dItemView.setTag(Integer.valueOf(3));
    this.cleanEvery7dItemView = this.cleanListTableView.addItem(2131719657);
    this.cleanEvery7dItemView.setTailImage(2130850509);
    this.cleanEvery7dItemView.setTag(Integer.valueOf(10));
    this.cleanEvery30dItemView = this.cleanListTableView.addItem(2131719658);
    this.cleanEvery30dItemView.setTailImage(2130850509);
    this.cleanEvery30dItemView.setTag(Integer.valueOf(30));
    this.cleanListTableView.setClickListener(new SettingAutoClearAttachmentsActivity.1(this));
    this.cleanListTableView.commit();
  }
  
  public static String getClearLevel()
  {
    int i = 0;
    switch (QMApplicationContext.sharedInstance().getSharedPreferences("clear_attachment_period", 0).getInt("clear_attachment_period_level", 10))
    {
    }
    while (i == 0)
    {
      return "";
      i = 2131719655;
      continue;
      i = 2131719656;
      continue;
      i = 2131719657;
      continue;
      i = 2131719658;
    }
    return QMApplicationContext.sharedInstance().getString(i);
  }
  
  private void initChecked()
  {
    switch (getSharedPreferences("clear_attachment_period", 0).getInt("clear_attachment_period_level", 10))
    {
    default: 
      return;
    case 0: 
      this.neverCleanItemView.setChecked(true);
      return;
    case 3: 
      this.cleanEvery3dItemView.setChecked(true);
      return;
    case 10: 
      this.cleanEvery7dItemView.setChecked(true);
      return;
    }
    this.cleanEvery30dItemView.setChecked(true);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setTitle(getString(2131719653));
    localQMTopBar.setButtonLeftBack();
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
    createSettingListTable();
    initChecked();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAutoClearAttachmentsActivity
 * JD-Core Version:    0.7.0.1
 */