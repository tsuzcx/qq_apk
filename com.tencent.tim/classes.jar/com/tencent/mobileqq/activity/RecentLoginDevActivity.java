package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import acfd;
import afsf;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqmu;
import arhz;
import ausj;
import auss;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import vqr;
import vqs;
import vqt;
import vqu;

public class RecentLoginDevActivity
  extends IphoneTitleBarActivity
{
  private ausj R;
  private String aKU = "";
  private acfd e = new vqu(this);
  private LinearLayout gt;
  private Handler mHandler = new vqr(this);
  private List<SvcDevLoginInfo> qk;
  private arhz w;
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131696152);
    }
    this.R = ((ausj)auss.a(this, null));
    paramString1 = getString(2131696144, new Object[] { str });
    this.R.setMainTitle(paramString1);
    this.R.addButton(getResources().getString(2131696142), 3);
    this.R.addCancelButton(2131721058);
    this.R.a(new vqt(this, paramString2, paramArrayList, paramInt));
    this.R.show();
  }
  
  private void bwV()
  {
    this.mHandler.post(new RecentLoginDevActivity.6(this));
  }
  
  private void fz(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.gt.setVisibility(8);
    }
    int j;
    int i;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.gt.removeAllViews();
      this.gt.setVisibility(0);
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null) {
          break label76;
        }
        i += 1;
      }
    }
    label76:
    View localView = getLayoutInflater().inflate(2131559512, this.gt, false);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131369468);
    ((ImageView)localView.findViewById(2131368846)).setVisibility(0);
    label130:
    Object localObject;
    TextView localTextView;
    if (j == 1)
    {
      localRelativeLayout.setBackgroundResource(2130839682);
      ((TextView)localView.findViewById(2131370084)).setVisibility(8);
      localObject = (TextView)localView.findViewById(2131372190);
      localTextView = (TextView)localView.findViewById(2131369154);
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label389;
      }
      ((TextView)localObject).setText(2131696152);
    }
    for (;;)
    {
      localObject = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject).append(aqmu.getFormatTime(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd  HH:mm"));
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation))
      {
        ((StringBuffer)localObject).append(" ");
        ((StringBuffer)localObject).append(localSvcDevLoginInfo.strLoginLocation);
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
      {
        ((StringBuffer)localObject).append(" ");
        ((StringBuffer)localObject).append(localSvcDevLoginInfo.strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject).length() > 0) {
        localTextView.setText(((StringBuffer)localObject).toString());
      }
      localRelativeLayout.setClickable(true);
      localRelativeLayout.setTag(localSvcDevLoginInfo);
      localRelativeLayout.setOnClickListener(new vqs(this, localRelativeLayout, i));
      this.gt.addView(localView);
      break;
      if (i == 0)
      {
        localRelativeLayout.setBackgroundResource(2130839701);
        break label130;
      }
      if (i == j - 1)
      {
        localRelativeLayout.setBackgroundResource(2130839689);
        break label130;
      }
      localRelativeLayout.setBackgroundResource(2130839695);
      break label130;
      label389:
      ((TextView)localObject).setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new RecentLoginDevActivity.5(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131561310);
    setTitle(2131696151);
    this.gt = ((LinearLayout)findViewById(2131368533));
    try
    {
      this.aKU = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "packName = " + this.aKU);
      }
      addObserver(this.e);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate begin to getRecentLoginDevList");
      }
      bool = afsf.a().b(this.app, this.aKU, 0L);
      if (bool)
      {
        showProgressDialog();
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      boolean bool;
      do
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate getRecentLoginDevList failed ret=" + bool);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bwV();
    removeObserver(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity
 * JD-Core Version:    0.7.0.1
 */