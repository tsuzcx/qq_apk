package com.tencent.qqmail.activity.setting;

import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class SettingSyncAdapterActivity
  extends BaseActivityEx
{
  private QMBaseView mBaseView;
  
  private void createManualView()
  {
    UITableView localUITableView = new UITableView(this);
    localUITableView.setCaption("手动");
    UITableItemView localUITableItemView1 = localUITableView.addItem("系统触发周期");
    long l = QMSyncAdapterManager.getPeriod();
    localUITableItemView1.setDetail(l + "分钟");
    UITableItemView localUITableItemView2 = localUITableView.addItem("同步邮件时间间隔（普通）");
    l = QMSyncAdapterManager.getNormalLimit();
    localUITableItemView2.setDetail(l + "分钟");
    UITableItemView localUITableItemView3 = localUITableView.addItem("JobScheduler周期");
    l = QMSyncAdapterManager.getJobSchedulerPeriod();
    localUITableItemView3.setDetail(l + "分钟");
    localUITableView.setClickListener(new SettingSyncAdapterActivity.1(this, localUITableItemView1, localUITableItemView2, localUITableItemView3));
    localUITableView.commit();
    this.mBaseView.addContentView(localUITableView);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle("SyncAdapter");
    localQMTopBar.setButtonLeftBack();
  }
  
  private void showToast()
  {
    Toast.makeText(this, QMSyncAdapterManager.getInfo(), 1).show();
  }
  
  public void initDataSource() {}
  
  public void initDom() {}
  
  public void initUI()
  {
    this.mBaseView = initScrollView(this);
    initTopBar();
    createManualView();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSyncAdapterActivity
 * JD-Core Version:    0.7.0.1
 */