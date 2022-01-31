package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.global.h;
import com.tencent.token.utils.x;
import com.tmsdk.TMSDKContext;

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
    this.mTitleBar = findViewById(2131558691);
    this.mTitleText = ((TextView)findViewById(2131558692));
    this.mTitleDivider = findViewById(2131558697);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTitleBar.getLayoutParams();
    if (IndexActivity.S_RES_HEIGHT > 0) {
      localMarginLayoutParams.height = IndexActivity.S_TITLE_HEIGHT;
    }
    this.mBackArrow = findViewById(2131558693);
    this.mBackArrowImg = ((ImageView)findViewById(2131558694));
    this.mRightOptionButton = ((Button)findViewById(2131559307));
    setDefaultTitle();
    setDefaultBackArrow();
  }
  
  public void hideTitle()
  {
    if (this.mTitleBar == null) {
      return;
    }
    this.mTitleBar.setVisibility(8);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    int j = 0;
    super.onCreate(paramBundle);
    setContentView(2130968716);
    boolean bool1 = getIntent().getBooleanExtra("app_whitelist", false);
    boolean bool2 = getIntent().getBooleanExtra("auto_start", false);
    this.mPer1Layout = ((RelativeLayout)findViewById(2131559122));
    this.mPer2Layout = ((RelativeLayout)findViewById(2131559123));
    paramBundle = this.mPer1Layout;
    if (bool1)
    {
      i = 0;
      paramBundle.setVisibility(i);
      paramBundle = this.mPer2Layout;
      if (!bool2) {
        break label154;
      }
    }
    label154:
    for (int i = j;; i = 8)
    {
      paramBundle.setVisibility(i);
      if (bool1)
      {
        this.mPer1Layout.setOnClickListener(new ti(this));
        TMSDKContext.saveActionData(1150119);
      }
      if (bool2)
      {
        this.mPer2Layout.setOnClickListener(new tk(this));
        TMSDKContext.saveActionData(1150116);
      }
      return;
      i = 8;
      break;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2130968782);
    View localView = getLayoutInflater().inflate(paramInt, null);
    ((RelativeLayout)findViewById(2131559316)).addView(localView, new RelativeLayout.LayoutParams(-1, -1));
    getContentView().setBackgroundDrawable(localView.getBackground());
    this.animLayout = ((RelativeLayout)findViewById(2131559319));
    this.lineImg = ((ImageView)findViewById(2131559320));
    this.arcImg = ((ImageView)findViewById(2131559321));
    initControllers();
    if ((getClass().toString().contains("StartPwd")) && (!getClass().toString().contains("StartPwdGestureIndex")))
    {
      x.a(this, this.mTitleBar, 2131493039);
      return;
    }
    x.a(this, this.mTitleBar, 2131492909);
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new tm(this));
    }
  }
  
  public void setDefaultTitle()
  {
    try
    {
      ActivityInfo localActivityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
      if ((localActivityInfo == null) || (localActivityInfo.labelRes == 0))
      {
        hideTitle();
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject;
      do
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
          h.c(localNameNotFoundException.toString());
          localObject = null;
        }
      } while ((this.mTitleBar == null) || (this.mTitleText == null));
      this.mTitleBar.setVisibility(0);
      this.mTitleText.setText(getString(localObject.labelRes));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.PermissionGuideSubActivity
 * JD-Core Version:    0.7.0.1
 */