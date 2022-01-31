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
import com.tencent.token.global.e;
import com.tencent.token.ui.base.cu;

public class RealNameTakeIDPhotoActivity
  extends BaseActivity
{
  private Handler handler = new yi(this);
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
    setContentView(2130903177);
    hideTitle();
    findViewById(2131296490).setOnClickListener(new ye(this));
    this.mPreview = ((RealNameTakeIDPhotoPreview)findViewById(2131296481));
    this.mPhotoBorder = ((ImageView)findViewById(2131296482));
    this.mPhotoBorder.setImageResource(2130837822);
    this.mTipTxt = ((TextView)findViewById(2131296487));
    if (this.mCurrentStep == 2)
    {
      this.mTipTxt.setText(2131362515);
      if (!this.mIsAnimation) {
        this.mPhotoBorder.setImageResource(2130837821);
      }
    }
    this.mTakePicBtn = ((ImageView)findViewById(2131296993));
    this.mTakePicBtn.setOnClickListener(new yf(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    e.c("resultCoderesultCode=" + paramInt2);
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
        e.c("onActivityResulton ccurrent_step=" + this.mCurrentStep);
        return;
      }
    } while (this.mCurrentStep != 2);
    paramIntent = new Intent();
    paramIntent.putExtra("frontdata", this.mFrontPath);
    paramIntent.putExtra("backdata", this.mBackPath);
    e.c("step2 onActivityResult!!!");
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
    this.mTakePicBtn = null;
    this.mPhotoBorder = null;
    if (this.mPreview != null)
    {
      this.mPreview.a();
      this.mPreview = null;
    }
    System.gc();
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
    this.mPreview.a(this, this.handler);
    if (this.mIsAnimation)
    {
      this.mCanTakePic = false;
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.mPhotoBorder.measure(i, j);
      this.height = this.mPhotoBorder.getMeasuredHeight();
      this.width = this.mPhotoBorder.getMeasuredWidth();
      cu localcu = new cu(0.0F, 90.0F, this.width / 2, this.height / 2, true);
      localcu.setDuration(400L);
      localcu.setFillAfter(true);
      localcu.setAnimationListener(new yh(this));
      this.mPhotoBorder.startAnimation(localcu);
      this.mIsAnimation = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameTakeIDPhotoActivity
 * JD-Core Version:    0.7.0.1
 */