package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.h;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.dr;
import com.tencent.token.et;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.dd;
import com.tencent.token.utils.w;
import java.util.ArrayList;

public class PCMobileQQVerifyedDevicesActivity
  extends BaseActivity
{
  public static final int MAIL_PROTECT = 1;
  public static final int QQ_PROTECT = 2;
  private static final int QQ_PROTECT_CONFIG_ID = 71;
  private String A2;
  private View.OnClickListener mBindListener = new sz(this);
  private View mContentView;
  private LinearLayout mDevicesView;
  private LinearLayout mEmptyDevicesView;
  private ErrorView mErrorView;
  private Handler mHandler = new tc(this);
  private dd mNeedVerifyView;
  private View mProgressView;
  private View.OnClickListener mRetryListener = new ta(this);
  
  private View createTableCol(DeviceInfo paramDeviceInfo)
  {
    View localView = getLayoutInflater().inflate(2130968792, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131559360);
    TextView localTextView2 = (TextView)localView.findViewById(2131559361);
    localTextView1.setText(paramDeviceInfo.dname);
    localTextView2.setText(paramDeviceInfo.dtype);
    localView.setOnClickListener(new te(this, paramDeviceInfo));
    return localView;
  }
  
  private void gotoQuickLoginWb()
  {
    QQUser localQQUser = do.a().e();
    if ((localQQUser == null) || (localQQUser.mRealUin <= 0L)) {
      return;
    }
    cp.a(getApplicationContext()).a(this, 523005419L, this.mHandler, "" + localQQUser.b());
  }
  
  private void init()
  {
    this.mContentView = findViewById(2131559117);
    this.mProgressView = findViewById(2131559119);
    this.mDevicesView = ((LinearLayout)findViewById(2131559118));
    this.mEmptyDevicesView = ((LinearLayout)findViewById(2131559121));
  }
  
  private void judgeNextStep()
  {
    queryCommonProtectStatus();
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
    cw.a().a(0L, 71, w.a(cp.a(RqdApplication.l()).b()), 523005419, 1, "com.tencent.token", this.A2, this.mHandler);
  }
  
  private void refreshContentView()
  {
    Object localObject = dr.a().i();
    if ((localObject != null) && (((h)localObject).c))
    {
      localObject = dr.a().g.b;
      int i;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.mContentView.setVisibility(0);
        this.mEmptyDevicesView.setVisibility(8);
        this.mDevicesView.setVisibility(0);
        this.mDevicesView.removeAllViews();
        i = 0;
      }
      while (i < ((ArrayList)localObject).size())
      {
        DeviceInfo localDeviceInfo = (DeviceInfo)((ArrayList)localObject).get(i);
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
  
  private void showTipView(int paramInt)
  {
    if (this.mErrorView == null)
    {
      this.mErrorView = new ErrorView(this);
      addContentView(this.mErrorView);
    }
    this.mErrorView.setErrorType(paramInt);
    this.mErrorView.setAction(this.mRetryListener);
    this.mErrorView.a();
    bringChildToFront(this.mErrorView);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((c.f()) && (paramKeyEvent.getAction() == 0)) {}
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1201) || (paramInt1 == 1202)) {
      cp.a(getApplicationContext()).a(paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = do.a().e();
    if ((paramBundle != null) && (!paramBundle.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new dd(this, -3);
      }
      setContentView(this.mNeedVerifyView);
    }
    for (;;)
    {
      setRightTitleImage(2130838011, new tb(this));
      return;
      setContentView(2130968715);
      init();
      cp localcp = cp.a(RqdApplication.l());
      byte[] arrayOfByte = localcp.b(do.a().e().mRealUin);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (!localcp.b("" + paramBundle.mRealUin, 523005419L)))
      {
        this.A2 = w.a(arrayOfByte);
        queryCommonProtectStatus();
      }
      else
      {
        cp.a(RqdApplication.l()).a("" + paramBundle.mRealUin, this.mHandler, 523005419L, 64);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.PCMobileQQVerifyedDevicesActivity
 * JD-Core Version:    0.7.0.1
 */