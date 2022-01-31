package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.cm;

public class RealNameTakeIDPhotoActivity
  extends BaseActivity
{
  private Handler handler = new xy(this);
  int height;
  private String mBackPath;
  private boolean mCanTakePic = true;
  private int mCurrentStep = 1;
  private String mFrontPath;
  private boolean mIsAnimation = false;
  private ImageView mPhotoBorder;
  private RealNameTakeIDPhotoPreview mPreview;
  private int mScene = 1;
  private ImageView mTakePicBtn;
  private TextView mTipTxt;
  PowerManager wakeLock;
  int width;
  
  private void destroyview()
  {
    this.mTakePicBtn = null;
    this.mPhotoBorder = null;
    if (this.mPreview != null)
    {
      this.mPreview.a();
      this.mPreview = null;
    }
  }
  
  private void initView()
  {
    setContentView(2130968736);
    hideTitle();
    findViewById(2131558776).setOnClickListener(new xt(this));
    this.mPreview = ((RealNameTakeIDPhotoPreview)findViewById(2131558767));
    this.mPreview.setVisibility(4);
    this.mPhotoBorder = ((ImageView)findViewById(2131558768));
    this.mPhotoBorder.setImageResource(2130837903);
    this.mTipTxt = ((TextView)findViewById(2131558773));
    if (this.mCurrentStep == 2)
    {
      this.mTipTxt.setText(2131231346);
      if (!this.mIsAnimation) {
        this.mPhotoBorder.setImageResource(2130837902);
      }
    }
    this.mTakePicBtn = ((ImageView)findViewById(2131559186));
    this.mTakePicBtn.setOnClickListener(new xu(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    h.c("resultCoderesultCode=" + paramInt2);
    if (paramInt2 == 10) {
      if (this.mCurrentStep == 1) {
        this.mFrontPath = null;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.mCurrentStep != 1);
        this.mBackPath = null;
        return;
      } while (paramInt2 != 20);
      if (this.mCurrentStep == 1)
      {
        this.mCurrentStep += 1;
        this.mIsAnimation = true;
        h.c("onActivityResulton ccurrent_step=" + this.mCurrentStep);
        return;
      }
    } while (this.mCurrentStep != 2);
    paramIntent = new Intent();
    paramIntent.putExtra("frontdata", this.mFrontPath);
    paramIntent.putExtra("backdata", this.mBackPath);
    h.c("step2 onActivityResult!!!");
    setResult(0, paramIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    requestWindowFeature(1);
    getWindow().setFlags(128, 128);
    this.mScene = getIntent().getIntExtra("scene", 1);
    if ((getIntent().getStringExtra("frontdata") != null) && (getIntent().getStringExtra("frontdata").length() > 0))
    {
      this.mFrontPath = getIntent().getStringExtra("frontdata");
      this.mCurrentStep = 2;
    }
    initView();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.mPreview.a != null) {
      this.mPreview.a();
    }
    destroyview();
    System.gc();
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
    Object localObject = new xw(this);
    requestRuntimePermissions(new String[] { "android.permission.CAMERA" }, (dy)localObject);
    if (this.mIsAnimation)
    {
      this.mCanTakePic = false;
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.mPhotoBorder.measure(i, j);
      this.height = this.mPhotoBorder.getMeasuredHeight();
      this.width = this.mPhotoBorder.getMeasuredWidth();
      localObject = new cm(0.0F, 90.0F, this.width / 2, this.height / 2, 310.0F, true);
      ((Animation)localObject).setDuration(400L);
      ((Animation)localObject).setFillAfter(true);
      ((Animation)localObject).setAnimationListener(new xx(this));
      this.mPhotoBorder.startAnimation((Animation)localObject);
      this.mIsAnimation = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameTakeIDPhotoActivity
 * JD-Core Version:    0.7.0.1
 */