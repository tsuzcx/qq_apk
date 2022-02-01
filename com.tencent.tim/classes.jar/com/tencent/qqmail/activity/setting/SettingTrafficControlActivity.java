package com.tencent.qqmail.activity.setting;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import androidx.annotation.NonNull;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.launcher.desktop.LauncherActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.timer.QMAlarmManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingTrafficControlActivity
  extends BaseActivityEx
{
  private QMBaseView mBaseView;
  private UITableView mRebootView;
  private UITableView mReportView;
  
  private void createRebootView()
  {
    this.mRebootView = new UITableView(this);
    this.mRebootView.addItem("点击5秒后重启").hideArrow();
    this.mRebootView.setClickListener(new SettingTrafficControlActivity.2(this));
    this.mRebootView.commit();
    this.mBaseView.addContentView(this.mRebootView);
  }
  
  private void createReportView()
  {
    this.mReportView = new UITableView(this);
    this.mReportView.setCaption("流量类型");
    UITableItemView localUITableItemView1 = this.mReportView.addItem("Osslog & Kvlog");
    localUITableItemView1.hideArrow();
    localUITableItemView1.setChecked(true);
    UITableItemView localUITableItemView2 = this.mReportView.addItem("灯塔");
    localUITableItemView2.hideArrow();
    UITableItemView localUITableItemView3 = this.mReportView.addItem("LogStream");
    localUITableItemView3.hideArrow();
    localUITableItemView3.setChecked(QMLogStream.getEnable());
    UITableItemView localUITableItemView4 = this.mReportView.addItem("UMA");
    localUITableItemView4.hideArrow();
    localUITableItemView4.setChecked(DataCollector.getEnable());
    this.mReportView.setClickListener(new SettingTrafficControlActivity.1(this, localUITableItemView1, localUITableItemView2, localUITableItemView3, localUITableItemView4));
    this.mReportView.commit();
    this.mBaseView.addContentView(this.mReportView);
  }
  
  @NonNull
  private List<Integer> getAllPid(Context paramContext)
  {
    int i = Process.myUid();
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    paramContext = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.uid == i)) {
        paramContext.add(Integer.valueOf(localRunningAppProcessInfo.pid));
      }
    }
    return paramContext;
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle("流量控制");
    localQMTopBar.setButtonLeftBack();
  }
  
  private void reboot()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LauncherActivity.class);
    localIntent.addFlags(268435456);
    QMAlarmManager.registerSingleExactlyAlarm(1000L, PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, localIntent, 0));
    killAll(QMApplicationContext.sharedInstance());
  }
  
  public void initDataSource() {}
  
  public void initDom() {}
  
  public void initUI()
  {
    this.mBaseView = initScrollView(this);
    initTopBar();
    createReportView();
    createRebootView();
  }
  
  public void killAll(Context paramContext)
  {
    paramContext = getAllPid(paramContext).iterator();
    while (paramContext.hasNext())
    {
      int i = ((Integer)paramContext.next()).intValue();
      if (i != Process.myPid()) {
        Process.killProcess(i);
      }
    }
    Process.killProcess(Process.myPid());
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingTrafficControlActivity
 * JD-Core Version:    0.7.0.1
 */