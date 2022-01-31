package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.jni.FaceDetector.IdCardDirection;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.bh;
import com.tencent.token.ui.base.cm;

public class DetectIDPhotoActivity
  extends BaseActivity
{
  private final int F_DETECT_TWOSIDES_OVERTIME = 30000;
  private byte[] backphotoinfo;
  private byte[] frontphotoinfo;
  private Handler handler = new dq(this);
  private boolean mAnimation;
  private String mBackPath;
  private TextView mBorderTipTxt;
  private Runnable mCheckOverTimeThread = new dl(this);
  private int mCurrentSide = 1;
  private boolean mDetectTwoSides = false;
  private String mFrontPath;
  private ImageView mGrid;
  private ImageView mImgBorder;
  private int mImgBorderH;
  private int mImgBorderW;
  private DetectIDPhotoPreview mPreview;
  private ImageView mScan;
  private boolean mStartCheckOverTime = false;
  private long shieldtime;
  
  private void destroyview()
  {
    this.mImgBorder = null;
    if (this.mPreview != null)
    {
      this.mPreview.a();
      this.mPreview = null;
    }
  }
  
  private void initView()
  {
    setContentView(2130968633);
    hideTitle();
    findViewById(2131558776).setOnClickListener(new dm(this));
    findViewById(2131558774).setOnClickListener(new dn(this));
    this.mPreview = ((DetectIDPhotoPreview)findViewById(2131558767));
    this.mPreview.setVisibility(4);
    this.mGrid = ((ImageView)findViewById(2131558769));
    this.mScan = ((ImageView)findViewById(2131558770));
    this.mScan.setBackgroundDrawable(new bh(this));
    this.mImgBorder = ((ImageView)findViewById(2131558768));
    this.mImgBorder.setImageResource(2130837903);
    this.mBorderTipTxt = ((TextView)findViewById(2131558773));
    if (this.mCurrentSide == 2)
    {
      this.mBorderTipTxt.setText(2131231346);
      if (!this.mAnimation) {
        this.mImgBorder.setImageResource(2130837902);
      }
    }
    if (!this.mStartCheckOverTime)
    {
      this.mStartCheckOverTime = true;
      this.mPreview.postDelayed(this.mCheckOverTimeThread, 30000L);
    }
  }
  
  private void showChangeTakepicAlert()
  {
    showUserDialog(2131230929, getResources().getString(2131230926), 2131230927, 2131230886, new ds(this), new dt(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    h.c("resultCoderesultCode=" + paramInt2);
    if (paramInt2 == 10) {
      if (this.mCurrentSide == 1) {
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
        } while (this.mCurrentSide != 2);
        this.mBackPath = null;
        return;
        if (paramInt2 != 20) {
          break;
        }
        if (this.mCurrentSide == 1)
        {
          this.mCurrentSide = 2;
          this.mAnimation = true;
          h.c("onActivityResulton ccurrent_step=" + this.mCurrentSide);
          return;
        }
      } while (this.mCurrentSide != 2);
      paramIntent = new Intent();
      paramIntent.putExtra("frontdata", this.mFrontPath);
      paramIntent.putExtra("backdata", this.mBackPath);
      paramIntent.putExtra("frontphotoinfo", this.frontphotoinfo);
      paramIntent.putExtra("backphotoinfo", this.backphotoinfo);
      h.c("step2 onActivityResult!!!");
      setResult(0, paramIntent);
      finish();
      return;
    } while ((paramInt2 != 0) || (paramIntent == null));
    Intent localIntent = new Intent();
    this.mFrontPath = paramIntent.getStringExtra("frontdata");
    this.mBackPath = paramIntent.getStringExtra("backdata");
    localIntent.putExtra("frontdata", this.mFrontPath);
    localIntent.putExtra("backdata", this.mBackPath);
    h.c("step2 onActivityResult!!!");
    setResult(0, localIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    requestWindowFeature(1);
    getWindow().setFlags(128, 128);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mPreview.a();
    destroyview();
    System.gc();
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
    switch (this.mCurrentSide)
    {
    }
    for (;;)
    {
      Object localObject = new do(this);
      requestRuntimePermissions(new String[] { "android.permission.CAMERA" }, (dy)localObject);
      if (this.mAnimation)
      {
        this.mScan.setVisibility(4);
        this.mGrid.setVisibility(4);
        int i = View.MeasureSpec.makeMeasureSpec(0, 0);
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mImgBorder.measure(i, j);
        this.mImgBorderH = this.mImgBorder.getMeasuredHeight();
        this.mImgBorderW = this.mImgBorder.getMeasuredWidth();
        localObject = new cm(0.0F, 90.0F, this.mImgBorderW / 2, this.mImgBorderH / 2, 310.0F, true);
        ((Animation)localObject).setDuration(400L);
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new dp(this));
        this.mImgBorder.startAnimation((Animation)localObject);
        this.mAnimation = false;
      }
      return;
      this.mPreview.setSide(FaceDetector.IdCardDirection.DT_FRONT);
      continue;
      this.mPreview.setSide(FaceDetector.IdCardDirection.DT_BACK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DetectIDPhotoActivity
 * JD-Core Version:    0.7.0.1
 */