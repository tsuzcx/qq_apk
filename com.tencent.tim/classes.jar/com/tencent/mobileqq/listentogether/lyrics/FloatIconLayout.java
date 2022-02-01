package com.tencent.mobileqq.listentogether.lyrics;

import acfp;
import aioy;
import aioz;
import aipa;
import aipb;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aoop;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;

public class FloatIconLayout
  extends FloatBaseLayout
  implements ValueAnimator.AnimatorUpdateListener, View.OnClickListener, URLDrawable.URLDrawableListener
{
  ImageView AR;
  View DL;
  public View DM;
  ValueAnimator aq;
  ValueAnimator ar;
  boolean ckX = false;
  int dep;
  ImageView ji;
  URLDrawable k;
  RelativeLayout kQ;
  String mAlbumUrl;
  DownloadParams.DecodeHandler mDecodeHandler = new aioz(this);
  ImageView mIcon;
  public int mIconWidth;
  boolean mIsPlaying = false;
  Paint mMaskPaint;
  float wV;
  
  public FloatIconLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void LP(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatBaseLayout.Icon", 2, "updateMusicIcon url:" + paramString + " mAlbumUrl:" + this.mAlbumUrl);
    }
    if (TextUtils.equals(paramString, this.mAlbumUrl)) {
      return;
    }
    this.mAlbumUrl = paramString;
    this.DL.setRotation(0.0F);
    if (!TextUtils.isEmpty(this.mAlbumUrl))
    {
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mMemoryCacheKeySuffix = "round";
      int i = this.mIconWidth;
      paramString.mRequestWidth = i;
      paramString.mRequestHeight = i;
      paramString.mFailedDrawable = aoop.TRANSPARENT;
      paramString.mLoadingDrawable = aoop.TRANSPARENT;
      if (this.k != null)
      {
        this.k.setURLDrawableListener(null);
        this.k = null;
      }
      this.k = URLDrawable.getDrawable(this.mAlbumUrl, paramString);
      this.k.setDecodeHandler(this.mDecodeHandler);
      this.k.startDownload();
      this.k.setURLDrawableListener(this);
      this.mIcon.setImageDrawable(this.k);
      return;
    }
    if (this.k != null)
    {
      this.k.setURLDrawableListener(null);
      this.k = null;
    }
    this.mIcon.setImageDrawable(null);
    dto();
  }
  
  private void aR(float paramFloat)
  {
    float f = this.DM.getRotation();
    if (Math.abs(paramFloat - f) < 0.5F)
    {
      this.DM.setRotation(paramFloat);
      return;
    }
    if ((this.ar != null) && (this.ar.isRunning())) {
      this.ar.cancel();
    }
    this.ar = ValueAnimator.ofFloat(new float[] { f, paramFloat });
    this.ar.setDuration((Math.abs(paramFloat - f) * 200.0F / 28.0F));
    this.ar.addUpdateListener(new aioy(this));
    this.ar.start();
  }
  
  private void dtn()
  {
    if (isVisible())
    {
      if (this.mIsPlaying)
      {
        if (!this.ckX)
        {
          this.wV = 0.0F;
          this.aq.start();
          this.ckX = true;
          aR(0.0F);
        }
        return;
      }
      this.aq.cancel();
      this.wV = 0.0F;
      aR(-28.0F);
      this.ckX = false;
      return;
    }
    this.aq.cancel();
    this.wV = 0.0F;
    this.ckX = false;
  }
  
  private void dto()
  {
    this.AR.setVisibility(8);
  }
  
  private void dtp()
  {
    this.AR.setVisibility(0);
  }
  
  private void init()
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131561193, null);
    this.kQ = ((RelativeLayout)((View)localObject).findViewById(2131368725));
    this.ji = ((ImageView)((View)localObject).findViewById(2131364694));
    this.mIcon = ((ImageView)((View)localObject).findViewById(2131372097));
    this.AR = ((ImageView)((View)localObject).findViewById(2131372098));
    this.DL = ((View)localObject).findViewById(2131377575);
    this.DM = ((View)localObject).findViewById(2131372118);
    addView((View)localObject, new FrameLayout.LayoutParams(-2, -2));
    this.ji.setOnClickListener(this);
    this.mIcon.setOnClickListener(this);
    this.mIcon.setContentDescription(acfp.m(2131706341));
    this.ji.setContentDescription(acfp.m(2131706342));
    this.dem = ((int)getResources().getDimension(2131297626));
    this.den = ((int)getResources().getDimension(2131297625));
    this.mIconWidth = wja.dp2px(40.0F, getResources());
    this.mLayoutParams.width = this.dem;
    this.mLayoutParams.height = this.den;
    this.aq = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
    localObject = new LinearInterpolator();
    this.aq.setInterpolator((TimeInterpolator)localObject);
    this.aq.addUpdateListener(this);
    this.aq.setDuration(10000L);
    this.aq.setRepeatCount(-1);
    this.DL.setPivotX(wja.dp2px(40.0F, getResources()) / 2);
    this.DL.setPivotY(wja.dp2px(40.0F, getResources()) / 2);
    this.mMaskPaint = new Paint();
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    this.dep = this.mMaskPaint.getColor();
    this.DM.setPivotX(wja.dp2px(20.0F, getResources()));
    this.DM.setPivotY(wja.dp2px(3.0F, getResources()));
    this.DM.setRotation(-28.0F);
    this.wV = 0.0F;
    dto();
  }
  
  public int a(aipb paramaipb)
  {
    return paramaipb.deq - this.dem / 2;
  }
  
  public void a(aipb paramaipb)
  {
    if (paramaipb == null) {
      return;
    }
    if ((paramaipb.isForeground) && (!paramaipb.cld) && (paramaipb.cla)) {
      LP(paramaipb.albumUrl);
    }
    paramaipb.aOw = this.dem;
    paramaipb.BT = this.den;
  }
  
  public boolean a(aipb paramaipb)
  {
    boolean bool1 = true;
    if (paramaipb == null) {
      return false;
    }
    boolean bool2 = isVisible();
    if ((paramaipb.isForeground) && (!paramaipb.cld) && (paramaipb.cla)) {
      if (apm()) {}
    }
    for (;;)
    {
      if (bool2 != isVisible()) {
        dtn();
      }
      return bool1;
      bool1 = false;
      continue;
      if (apn()) {
        bool1 = false;
      }
    }
  }
  
  public boolean apn()
  {
    boolean bool = super.apn();
    dtn();
    return bool;
  }
  
  public int b(aipb paramaipb)
  {
    return paramaipb.der - this.den / 2;
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.k != null)
    {
      this.k.setURLDrawableListener(null);
      this.k = null;
    }
    this.mIcon.setImageDrawable(null);
    this.aq.cancel();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.mMaskPaint.getColorFilter() == null) {
          this.mMaskPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
        }
        this.mMaskPaint.setColor(this.dep);
        paramCanvas.saveLayer(null, this.mMaskPaint, 31);
      }
      super.dispatchDraw(paramCanvas);
      if (i != 0) {
        paramCanvas.restore();
      }
      return;
    }
  }
  
  protected void dtl()
  {
    super.dtl();
    this.mIcon.setAlpha(1.0F);
    this.ji.setAlpha(1.0F);
  }
  
  protected void dtm()
  {
    super.dtm();
    this.mIcon.setAlpha(1.0F);
    this.ji.setAlpha(1.0F);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f3 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.DL.getRotation() + (f3 - this.wV);
    float f1 = f2;
    if (f2 > 360.0F) {
      f1 = f2 - 360.0F;
    }
    this.DL.setRotation(f1);
    this.wV = f3;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a != null)
      {
        this.a.dtt();
        continue;
        if (this.a != null) {
          this.a.dts();
        }
      }
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    dto();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    dtp();
  }
  
  public void onThemeChange()
  {
    invalidate();
  }
  
  public void setPlayState(boolean paramBoolean)
  {
    this.mIsPlaying = paramBoolean;
    dtn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout
 * JD-Core Version:    0.7.0.1
 */