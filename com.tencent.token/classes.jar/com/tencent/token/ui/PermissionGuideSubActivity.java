package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
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
import com.tencent.token.aaz;
import com.tencent.token.aut;
import com.tencent.token.aut.a;
import com.tencent.token.auv;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.xv;
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
    this.mTitleBar = findViewById(2131166159);
    this.mTitleText = ((TextView)findViewById(2131165305));
    this.mTitleDivider = findViewById(2131166160);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mTitleBar.getLayoutParams();
    if (IndexActivity.S_RES_HEIGHT > 0) {
      localMarginLayoutParams.height = IndexActivity.S_TITLE_HEIGHT;
    }
    this.mBackArrow = findViewById(2131165298);
    this.mBackArrowImg = ((ImageView)findViewById(2131165300));
    this.mRightOptionButton = ((Button)findViewById(2131165301));
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296407);
    paramBundle = getIntent();
    int j = 0;
    boolean bool1 = paramBundle.getBooleanExtra("app_whitelist", false);
    boolean bool2 = getIntent().getBooleanExtra("auto_start", false);
    this.mPer1Layout = ((RelativeLayout)findViewById(2131165830));
    this.mPer2Layout = ((RelativeLayout)findViewById(2131165834));
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
        public final void onClick(View paramAnonymousView)
        {
          aut.a(new int[] { 3 }).a(new auv()
          {
            public final void a(int[] paramAnonymous2ArrayOfInt)
            {
              int i;
              if (paramAnonymous2ArrayOfInt[0] == 0) {
                i = 1;
              } else {
                i = 0;
              }
              if (i == 0)
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
        public final void onClick(View paramAnonymousView)
        {
          aut.a(new int[] { 4 }).a(new auv()
          {
            public final void a(int[] paramAnonymous2ArrayOfInt)
            {
              int i;
              if (paramAnonymous2ArrayOfInt[0] == 0) {
                i = 1;
              } else {
                i = 0;
              }
              if (i == 0)
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
    super.setContentView(2131296477);
    View localView = getLayoutInflater().inflate(paramInt, null);
    ((RelativeLayout)findViewById(2131165421)).addView(localView, new RelativeLayout.LayoutParams(-1, -1));
    getContentView().setBackgroundDrawable(localView.getBackground());
    this.animLayout = ((RelativeLayout)findViewById(2131165284));
    this.lineImg = ((ImageView)findViewById(2131165681));
    this.arcImg = ((ImageView)findViewById(2131165290));
    initControllers();
    if ((getClass().toString().contains("StartPwd")) && (!getClass().toString().contains("StartPwdGestureIndex")))
    {
      aaz.a(this, this.mTitleBar, 2130968774);
      return;
    }
    aaz.a(this, this.mTitleBar, 2130968641);
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
          public final void onClick(View paramAnonymousView)
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
      xv.c(localNameNotFoundException.toString());
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