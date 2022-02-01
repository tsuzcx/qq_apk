package com.tencent.tim.cloudfile.feeds;

import ahal;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import atgi;
import atma;
import atmb;
import atmc;
import atmd;
import atme;
import atmf;
import atmh;
import atmh.a;
import audx;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class CloudUploadingListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  atmh a = null;
  private CloudFileCallbackCenter c = new atmf(this);
  Comparator<atmh.a> comparator = new atma(this);
  private FPSSwipListView f;
  private Button hG;
  private Button hH;
  private LinearLayout ma;
  private LinearLayout mb;
  private LinearLayout mc;
  private HashMap<Long, atmh.a> qe = new HashMap();
  
  private void HD()
  {
    QLog.w("CloudUploadingListActivity", 1, "onFetchUploadList start at " + System.currentTimeMillis());
    atgi.a().e(new atmb(this));
  }
  
  private boolean aJi()
  {
    Iterator localIterator = this.qe.values().iterator();
    while (localIterator.hasNext())
    {
      atmh.a locala = (atmh.a)localIterator.next();
      if ((locala.uploadStatus != 3) && (locala.uploadStatus != 4)) {
        return false;
      }
    }
    return true;
  }
  
  private void aaw(int paramInt)
  {
    atgi.a().aao(paramInt);
  }
  
  private void azy()
  {
    ArrayList localArrayList = new ArrayList(this.qe.values());
    QLog.w("CloudUploadingListActivity", 1, "updateListView start at " + System.currentTimeMillis());
    Collections.sort(localArrayList, this.comparator);
    QLog.w("CloudUploadingListActivity", 1, "updateListView end at " + System.currentTimeMillis());
    ThreadManager.getUIHandler().post(new CloudUploadingListActivity.7(this, localArrayList));
  }
  
  private void eub()
  {
    ArrayList localArrayList = new ArrayList(this.qe.keySet());
    atgi.a().deleteUploadFile(localArrayList);
  }
  
  private void euc()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qe.values().iterator();
    while (localIterator.hasNext())
    {
      atmh.a locala = (atmh.a)localIterator.next();
      if ((locala.uploadStatus == 3) || (locala.uploadStatus == 4)) {
        localArrayList.add(Long.valueOf(locala.taskId));
      }
    }
    atgi.a().startUploadFile(localArrayList);
  }
  
  private void initUI()
  {
    this.mb = ((LinearLayout)findViewById(2131381356));
    this.ma = ((LinearLayout)findViewById(2131370561));
    this.f = ((FPSSwipListView)findViewById(2131370527));
    this.f.setDivider(null);
    this.f.setDragEnable(true);
    this.mc = ((LinearLayout)findViewById(2131372651));
    this.hG = ((Button)findViewById(2131364779));
    this.hG.setOnClickListener(this);
    this.hH = ((Button)findViewById(2131364778));
    this.hH.setOnClickListener(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558993);
    setTitle(2131721615);
    initUI();
    this.a = new atmh(this);
    this.f.setAdapter(this.a);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mSystemBarComp.init();
      ((FrameLayout)findViewById(2131377546)).setFitsSystemWindows(true);
      int i = getResources().getColor(2131167361);
      if (ImmersiveUtils.a(getWindow(), true)) {
        i = getResources().getColor(2131167562);
      }
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    atgi.c(this.c);
  }
  
  public void doOnResume()
  {
    atgi.a().a(this.c);
    HD();
  }
  
  public void eua()
  {
    ThreadManager.getUIHandler().post(new CloudUploadingListActivity.8(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aJi())
      {
        if (audx.amK())
        {
          ahal.a(paramView.getContext(), 2131693826, 2131693829, new atmc(this));
        }
        else
        {
          euc();
          this.hG.setText(2131691672);
        }
      }
      else
      {
        aaw(3);
        this.hG.setText(2131691673);
        continue;
        ReportDialog localReportDialog = new ReportDialog(this, 2131756467);
        localReportDialog.setContentView(2131559127);
        TextView localTextView = (TextView)localReportDialog.findViewById(2131365863);
        if (localTextView != null) {
          localTextView.setText("全部取消所有进程？");
        }
        localTextView = (TextView)localReportDialog.findViewById(2131365852);
        if (localTextView != null)
        {
          localTextView.setText(2131721058);
          localTextView.setOnClickListener(new atmd(this, localReportDialog));
        }
        localTextView = (TextView)localReportDialog.findViewById(2131365858);
        if (localTextView != null)
        {
          localTextView.setText(2131718741);
          localTextView.setOnClickListener(new atme(this, localReportDialog));
        }
        localReportDialog.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity
 * JD-Core Version:    0.7.0.1
 */