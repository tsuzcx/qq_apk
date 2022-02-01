package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.utils.m;
import com.tmsdk.TMSDKContext;
import tmsdk.common.module.pgsdk.PermissionGuide;
import tmsdk.common.module.pgsdk.PermissionGuide.PermissionRequest;
import tmsdk.common.module.pgsdk.RequestCallback;

public class PermissionGuideSubActivity
  extends Activity
{
  protected RelativeLayout animLayout;
  protected ImageView arcImg;
  protected ImageView lineImg;
  protected View mBackArrow;
  protected ImageView mBackArrowImg;
  RelativeLayout mPer1Layout;
  RelativeLayout mPer2Layout;
  private Button mRightOptionButton;
  protected View mTitleBar;
  protected View mTitleDivider;
  protected TextView mTitleText;
  
  private View getContentView()
  {
    return ((ViewGroup)getWindow().getDecorView()).getChildAt(0);
  }
  
  private void initControllers()
  {
    this.mTitleBar = findViewById(2131166111);
    this.mTitleText = ((TextView)findViewById(2131165298));
    this.mTitleDivider = findViewById(2131166112);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTitleBar.getLayoutParams();
    if (IndexActivity.S_RES_HEIGHT > 0) {
      localMarginLayoutParams.height = IndexActivity.S_TITLE_HEIGHT;
    }
    this.mBackArrow = findViewById(2131165291);
    this.mBackArrowImg = ((ImageView)findViewById(2131165293));
    this.mRightOptionButton = ((Button)findViewById(2131165294));
    setDefaultTitle();
    setDefaultBackArrow();
  }
  
  public void hideTitle()
  {
    View localView = this.mTitleBar;
    if (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296397);
    paramBundle = getIntent();
    int j = 0;
    boolean bool1 = paramBundle.getBooleanExtra("app_whitelist", false);
    boolean bool2 = getIntent().getBooleanExtra("auto_start", false);
    this.mPer1Layout = ((RelativeLayout)findViewById(2131165806));
    this.mPer2Layout = ((RelativeLayout)findViewById(2131165807));
    paramBundle = this.mPer1Layout;
    int i;
    if (bool1) {
      i = 0;
    } else {
      i = 8;
    }
    paramBundle.setVisibility(i);
    paramBundle = this.mPer2Layout;
    if (bool2) {
      i = j;
    } else {
      i = 8;
    }
    paramBundle.setVisibility(i);
    if (bool1)
    {
      this.mPer1Layout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PermissionGuide.build(new int[] { 3 }).request(new RequestCallback()
          {
            public void onCallback(int[] paramAnonymous2ArrayOfInt1, int[] paramAnonymous2ArrayOfInt2)
            {
              boolean bool;
              if (paramAnonymous2ArrayOfInt2[0] == 0) {
                bool = true;
              } else {
                bool = false;
              }
              paramAnonymous2ArrayOfInt1 = new StringBuilder();
              paramAnonymous2ArrayOfInt1.append("申请存活权限结果:");
              paramAnonymous2ArrayOfInt1.append(bool);
              Log.i("permission_test", paramAnonymous2ArrayOfInt1.toString());
              if (!bool)
              {
                Toast.makeText(RqdApplication.n(), "授权失败", 0).show();
                return;
              }
              TMSDKContext.saveActionData(1150121);
            }
          });
          TMSDKContext.saveActionData(1150120);
        }
      });
      TMSDKContext.saveActionData(1150119);
    }
    if (bool2)
    {
      this.mPer2Layout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PermissionGuide.build(new int[] { 4 }).request(new RequestCallback()
          {
            public void onCallback(int[] paramAnonymous2ArrayOfInt1, int[] paramAnonymous2ArrayOfInt2)
            {
              boolean bool;
              if (paramAnonymous2ArrayOfInt2[0] == 0) {
                bool = true;
              } else {
                bool = false;
              }
              paramAnonymous2ArrayOfInt1 = new StringBuilder();
              paramAnonymous2ArrayOfInt1.append("申请自启权限结果:");
              paramAnonymous2ArrayOfInt1.append(bool);
              Log.i("permission_test", paramAnonymous2ArrayOfInt1.toString());
              if (!bool)
              {
                Toast.makeText(RqdApplication.n(), "授权失败", 0).show();
                return;
              }
              TMSDKContext.saveActionData(1150118);
            }
          });
          TMSDKContext.saveActionData(1150117);
        }
      });
      TMSDKContext.saveActionData(1150116);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2131296463);
    View localView = getLayoutInflater().inflate(paramInt, null);
    ((RelativeLayout)findViewById(2131165407)).addView(localView, new RelativeLayout.LayoutParams(-1, -1));
    getContentView().setBackgroundDrawable(localView.getBackground());
    this.animLayout = ((RelativeLayout)findViewById(2131165278));
    this.lineImg = ((ImageView)findViewById(2131165660));
    this.arcImg = ((ImageView)findViewById(2131165284));
    initControllers();
    if ((getClass().toString().contains("StartPwd")) && (!getClass().toString().contains("StartPwdGestureIndex")))
    {
      m.a(this, this.mTitleBar, 2130968773);
      return;
    }
    m.a(this, this.mTitleBar, 2130968641);
  }
  
  protected void setDefaultBackArrow()
  {
    if (this.mTitleBar.getVisibility() == 0)
    {
      View localView = this.mBackArrow;
      if (localView != null)
      {
        localView.setVisibility(0);
        this.mBackArrow.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            PermissionGuideSubActivity.this.finish();
          }
        });
      }
    }
  }
  
  public void setDefaultTitle()
  {
    Object localObject;
    try
    {
      ActivityInfo localActivityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      g.c(localNameNotFoundException.toString());
      localObject = null;
    }
    if ((localObject != null) && (localObject.labelRes != 0))
    {
      View localView = this.mTitleBar;
      if (localView != null)
      {
        if (this.mTitleText == null) {
          return;
        }
        localView.setVisibility(0);
        this.mTitleText.setText(getString(localObject.labelRes));
        return;
      }
      return;
    }
    hideTitle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.PermissionGuideSubActivity
 * JD-Core Version:    0.7.0.1
 */