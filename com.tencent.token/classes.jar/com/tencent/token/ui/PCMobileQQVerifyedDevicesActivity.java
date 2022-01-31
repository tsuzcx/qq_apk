package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.g;
import com.tencent.token.fq;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dk;
import com.tencent.token.utils.s;
import com.tencent.token.x;
import java.util.ArrayList;

public class PCMobileQQVerifyedDevicesActivity
  extends BaseActivity
{
  public static final int MAIL_PROTECT = 1;
  public static final int QQ_PROTECT = 2;
  private static final int QQ_PROTECT_CONFIG_ID = 71;
  private String A2;
  private View.OnClickListener mBindListener = new tv(this);
  private View mContentView;
  private LinearLayout mDevicesView;
  private LinearLayout mEmptyDevicesView;
  private ErrorView mErrorView;
  private Handler mHandler = new ty(this);
  private dk mNeedVerifyView;
  private View mProgressView;
  private View.OnClickListener mRetryListener = new tw(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  
  private View createTableCol(DeviceInfo paramDeviceInfo)
  {
    View localView = getLayoutInflater().inflate(2130903229, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131297200);
    TextView localTextView2 = (TextView)localView.findViewById(2131297201);
    localTextView1.setText(paramDeviceInfo.dname);
    localTextView2.setText(paramDeviceInfo.dtype);
    localView.setOnClickListener(new ua(this, paramDeviceInfo));
    return localView;
  }
  
  private void init()
  {
    this.mContentView = findViewById(2131296909);
    this.mProgressView = findViewById(2131296911);
    this.mDevicesView = ((LinearLayout)findViewById(2131296910));
    this.mEmptyDevicesView = ((LinearLayout)findViewById(2131296913));
    this.mTipBindQQDesc = getResources().getString(2131362193);
    this.mTipBindQQBtnDesc = getResources().getString(2131362297);
    refreshContentView();
  }
  
  private void queryCommonProtectStatus()
  {
    if (this.A2 == null) {
      return;
    }
    refreshContentView();
    this.mProgressView.setVisibility(0);
    this.mContentView.setVisibility(8);
    this.mEmptyDevicesView.setVisibility(8);
    af.a().b(0L, 71, s.a(x.a(RqdApplication.i()).c()), "com.tencent.token", this.A2, this.mHandler);
  }
  
  private void refreshContentView()
  {
    if (ba.a().i().c)
    {
      ArrayList localArrayList = ba.a().g.b;
      int i;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.mContentView.setVisibility(0);
        this.mEmptyDevicesView.setVisibility(8);
        this.mDevicesView.setVisibility(0);
        this.mDevicesView.removeAllViews();
        i = 0;
      }
      while (i < localArrayList.size())
      {
        DeviceInfo localDeviceInfo = (DeviceInfo)localArrayList.get(i);
        this.mDevicesView.addView(createTableCol(localDeviceInfo));
        i += 1;
        continue;
        this.mContentView.setVisibility(8);
        this.mEmptyDevicesView.setVisibility(0);
        this.mDevicesView.setVisibility(8);
        this.mDevicesView.removeAllViews();
      }
      return;
    }
    this.mContentView.setVisibility(8);
    this.mEmptyDevicesView.setVisibility(0);
    this.mDevicesView.setVisibility(8);
    this.mDevicesView.removeAllViews();
  }
  
  private void showTipDialog(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    showUserDialog(paramString);
  }
  
  private void showTipView(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.mErrorView == null)
    {
      this.mErrorView = new ErrorView(this);
      addContentView(this.mErrorView);
    }
    this.mErrorView.a(paramInt);
    if (paramBoolean) {
      this.mErrorView.a(this.mBindListener);
    }
    for (;;)
    {
      this.mErrorView.setVisibility(0);
      bringChildToFront(this.mErrorView);
      return;
      this.mErrorView.a(this.mRetryListener);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((b.d()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
      finish();
      return true;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ax.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dk(this, -3);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130837951, new tx(this));
      return;
      setContentView(2130903153);
      init();
      byte[] arrayOfByte = x.a(RqdApplication.i()).a(ax.a().e().mRealUin);
      if (arrayOfByte != null)
      {
        this.A2 = s.a(arrayOfByte);
        queryCommonProtectStatus();
      }
      else
      {
        x.a(RqdApplication.i()).a(this, "" + paramBundle.mRealUin, this.mHandler, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.PCMobileQQVerifyedDevicesActivity
 * JD-Core Version:    0.7.0.1
 */