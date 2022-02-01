package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import auvk;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import lgl;
import now;
import noz;
import npe;
import npg;
import nph;
import oud;

public class ZImageView
  extends ImageView
{
  static int FADE_DURATION = 300;
  static Drawable sColorDrawable = new ColorDrawable(-1);
  private boolean hasSetAlphaBgDrawable;
  private boolean isRound;
  private ValueAnimator mAlphaAnimator;
  private Drawable mBackgroundDrawableTemp;
  protected now mController;
  private URL mUrl;
  private boolean startAplhaOnce;
  private String tag = "zimage.ZImageView.v" + hashCode();
  
  public ZImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ZImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ZImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mController = new now(sColorDrawable, this);
    this.mAlphaAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
    this.mAlphaAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.mAlphaAnimator.setDuration(FADE_DURATION);
    this.mAlphaAnimator.addListener(new npg(this));
    this.mAlphaAnimator.addUpdateListener(new nph(this));
  }
  
  private void resetBgDrawable()
  {
    if (this.hasSetAlphaBgDrawable)
    {
      setBackgroundDrawable(this.mBackgroundDrawableTemp);
      this.hasSetAlphaBgDrawable = false;
      if (QLog.isColorLevel()) {
        npe.log(this.tag, "cancel alpha bg drawable !");
      }
    }
  }
  
  private void setBgDrawable()
  {
    if ((!this.hasSetAlphaBgDrawable) && (this.mController.mPlaceHolder != sColorDrawable))
    {
      this.mBackgroundDrawableTemp = getBackground();
      setBackgroundDrawable(this.mController.mPlaceHolder);
      this.hasSetAlphaBgDrawable = true;
      if (QLog.isColorLevel()) {
        npe.log(this.tag, "set alpha bg drawable !");
      }
    }
  }
  
  public void doAlphaAnimationInNextDraw()
  {
    this.startAplhaOnce = true;
    this.mAlphaAnimator.cancel();
  }
  
  @Deprecated
  public boolean isRound()
  {
    return this.isRound;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel())
    {
      localObject = getParent();
      if (localObject == null) {
        break label63;
      }
    }
    label63:
    for (Object localObject = localObject.getClass().getName();; localObject = null)
    {
      npe.log(this.tag, "onAttachedToWindow, parent: " + (String)localObject);
      this.mController.oq("onAttachedToWindow");
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      npe.log(this.tag, "onDetachedFromWindow");
    }
    this.mController.op("onDetachedFromWindow");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mUrl != null)
    {
      if (QLog.isColorLevel()) {
        npe.log(this.tag, "onDraw dispatch load image");
      }
      noz localnoz = new noz();
      localnoz.url = this.mUrl;
      localnoz.reqWidth = getWidth();
      localnoz.reqHeight = getHeight();
      this.mController.f(localnoz);
      this.mUrl = null;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if (QLog.isColorLevel()) {
      npe.log(this.tag, "onFinishTemporaryDetach");
    }
    this.mController.oq("onFinishTemporaryDetach");
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (QLog.isColorLevel())
    {
      localObject = getParent();
      if (localObject == null) {
        break label63;
      }
    }
    label63:
    for (Object localObject = localObject.getClass().getName();; localObject = null)
    {
      npe.log(this.tag, "onStartTemporaryDetach, parent: " + (String)localObject);
      this.mController.op("onStartTemporaryDetach");
      return;
    }
  }
  
  public ZImageView setImage(URL paramURL)
  {
    auvk.traceBegin("ZImageView.setImage");
    if (paramURL == null)
    {
      auvk.traceEnd();
      return this;
    }
    if ((this.mUrl != null) && (this.mUrl.getPath().equals(paramURL.getPath()))) {
      QLog.d("ZImageView", 2, "setImage | same");
    }
    this.mUrl = null;
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT >= 19) {
        bool = isAttachedToWindow();
      }
      npe.log(this.tag, "setImage " + paramURL + " width " + getWidth() + " isAttach " + bool);
    }
    if (getWidth() > 0)
    {
      auvk.traceBegin("ZImageView.newImageRequest");
      noz localnoz = new noz();
      localnoz.url = paramURL;
      localnoz.reqWidth = getWidth();
      localnoz.reqHeight = getHeight();
      lgl.a(1, localnoz);
      this.mController.f(localnoz);
      auvk.traceEnd();
    }
    for (;;)
    {
      auvk.traceEnd();
      return this;
      this.mUrl = paramURL;
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mAlphaAnimator.cancel();
      setBgDrawable();
      setImageDrawable(paramDrawable);
      this.mAlphaAnimator.start();
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  public ZImageView setImageForImageCollection(noz paramnoz, oud paramoud)
  {
    if ((paramnoz == null) || (paramnoz.url == null)) {
      return this;
    }
    if (paramoud != null) {
      this.mController.setPublicAccountImageDownListener(paramoud);
    }
    this.mUrl = null;
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "setImageForImageCollection url = " + paramnoz.url + " reqWidth = " + paramnoz.reqWidth + " reqHeight = " + paramnoz.reqHeight);
    }
    this.mController.f(paramnoz);
    return this;
  }
  
  public ZImageView setImagePlaceHolder(Drawable paramDrawable)
  {
    this.mUrl = null;
    this.mController.G(paramDrawable);
    return this;
  }
  
  public void setPublicAccountImageDownListener(oud paramoud)
  {
    if (paramoud != null) {
      this.mController.setPublicAccountImageDownListener(paramoud);
    }
  }
  
  @Deprecated
  public void setRound(boolean paramBoolean)
  {
    this.isRound = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView
 * JD-Core Version:    0.7.0.1
 */