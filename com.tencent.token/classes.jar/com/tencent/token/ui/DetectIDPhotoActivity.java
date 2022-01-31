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
import com.tencent.token.global.e;
import com.tencent.token.ui.base.bf;
import com.tencent.token.ui.base.cu;

public class DetectIDPhotoActivity
  extends BaseActivity
{
  private final int F_DETECT_TWOSIDES_OVERTIME = 30000;
  private byte[] backphotoinfo;
  private byte[] frontphotoinfo;
  private Handler handler = new cz(this);
  private boolean mAnimation;
  private String mBackPath;
  private TextView mBorderTipTxt;
  private Runnable mCheckOverTimeThread = new cv(this);
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
    setContentView(2130903068);
    hideTitle();
    findViewById(2131296490).setOnClickListener(new cw(this));
    findViewById(2131296488).setOnClickListener(new cx(this));
    this.mPreview = ((DetectIDPhotoPreview)findViewById(2131296481));
    this.mGrid = ((ImageView)findViewById(2131296483));
    this.mScan = ((ImageView)findViewById(2131296484));
    this.mScan.setBackgroundDrawable(new bf(this));
    this.mImgBorder = ((ImageView)findViewById(2131296482));
    this.mImgBorder.setImageResource(2130837822);
    this.mBorderTipTxt = ((TextView)findViewById(2131296487));
    if (this.mCurrentSide == 2)
    {
      this.mBorderTipTxt.setText(2131362515);
      if (!this.mAnimation) {
        this.mImgBorder.setImageResource(2130837821);
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
    showUserDialog(2131362778, getResources().getString(2131362779), 2131362780, 2131361804, new db(this), new dc(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    e.c("resultCoderesultCode=" + paramInt2);
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
          e.c("onActivityResulton ccurrent_step=" + this.mCurrentSide);
          return;
        }
      } while (this.mCurrentSide != 2);
      paramIntent = new Intent();
      paramIntent.putExtra("frontdata", this.mFrontPath);
      paramIntent.putExtra("backdata", this.mBackPath);
      paramIntent.putExtra("frontphotoinfo", this.frontphotoinfo);
      paramIntent.putExtra("backphotoinfo", this.backphotoinfo);
      e.c("step2 onActivityResult!!!");
      setResult(0, paramIntent);
      finish();
      return;
    } while ((paramInt2 != 0) || (paramIntent == null));
    Intent localIntent = new Intent();
    this.mFrontPath = paramIntent.getStringExtra("frontdata");
    this.mBackPath = paramIntent.getStringExtra("backdata");
    localIntent.putExtra("frontdata", this.mFrontPath);
    localIntent.putExtra("backdata", this.mBackPath);
    e.c("step2 onActivityResult!!!");
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
    this.mImgBorder = null;
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
    switch (this.mCurrentSide)
    {
    }
    for (;;)
    {
      this.mPreview.a(this, this.handler);
      if (this.mAnimation)
      {
        this.mScan.setVisibility(4);
        this.mGrid.setVisibility(4);
        int i = View.MeasureSpec.makeMeasureSpec(0, 0);
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mImgBorder.measure(i, j);
        this.mImgBorderH = this.mImgBorder.getMeasuredHeight();
        this.mImgBorderW = this.mImgBorder.getMeasuredWidth();
        cu localcu = new cu(0.0F, 90.0F, this.mImgBorderW / 2, this.mImgBorderH / 2, true);
        localcu.setDuration(400L);
        localcu.setFillAfter(true);
        localcu.setAnimationListener(new cy(this));
        this.mImgBorder.startAnimation(localcu);
        this.mAnimation = false;
      }
      return;
      this.mPreview.a(FaceDetector.IdCardDirection.DT_FRONT);
      continue;
      this.mPreview.a(FaceDetector.IdCardDirection.DT_BACK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DetectIDPhotoActivity
 * JD-Core Version:    0.7.0.1
 */