package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class MailContentServiceActivity
  extends BaseActivityEx
{
  public static final String TAG = "SettingAppActivity";
  private final UITableView.ClickListener appTableOnClickListener = new MailContentServiceActivity.1(this);
  private QMBaseView baseView;
  private UITableItemView creditcardItemView;
  private UITableView tableView;
  
  private void createAppTableView()
  {
    this.tableView = new UITableView(this);
    this.baseView.addContentView(this.tableView);
    this.tableView.setClickListener(this.appTableOnClickListener);
    this.creditcardItemView = this.tableView.addItem(2131718764);
    this.tableView.commit();
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), MailContentServiceActivity.class);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719887);
    localQMTopBar.setButtonLeftBack();
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
    createAppTableView();
  }
  
  public void initUI()
  {
    this.baseView = initScrollView(this);
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
 * Qualified Name:     com.tencent.qqmail.activity.setting.MailContentServiceActivity
 * JD-Core Version:    0.7.0.1
 */