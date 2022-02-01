package com.tencent.moai.nativepages;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.moai.nativepages.util.UIUtil;
import java.util.Iterator;
import java.util.LinkedList;

public class AdLandingPagesPreviewAnimation
{
  private static final int ANIM_DURATION_EXIT = 300;
  private static final String TAG = "MicroMsg.ImagePreviewAnimation";
  private static final float interpolator = 1.2F;
  private int ANIMATION_IS_CLOSE = 1;
  private int ANIMATION_IS_ENTERING = 2;
  private int ANIMATION_IS_EXITING = 4;
  private int ANIMATION_IS_INIT = 0;
  private int ANIMATION_IS_OPEN = 3;
  private int animationState = this.ANIMATION_IS_INIT;
  private int center_ScrollY = 0;
  private final Context context;
  private int delat_bottom = 0;
  private int delat_left = 0;
  private int delat_right = 0;
  private int delat_top = 0;
  private int enterAnimationDuration = 300;
  private Object imageInfo;
  float mAnimaAlpha = 1.0F;
  private int mBigImgHeight = 0;
  private int mBigImgWidth = 0;
  private Handler mHandler = new Handler();
  private int mHeight = 0;
  private float mHeightScale = 0.0F;
  private int mLeft = 0;
  private int mLeftDelta = 0;
  private int mTop = 0;
  private int mTopDelta = 0;
  private int mWidth = 0;
  private float mWidthScale = 0.0F;
  private float mZoomScale = 0.0F;
  private IparamCallback paramCallback;
  
  public AdLandingPagesPreviewAnimation(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void prepareAnimationParam(View paramView, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.mLeft == 0) && (this.mTop == 0))
    {
      this.mLeft = (paramView.getWidth() / 2);
      this.mTop = (paramView.getHeight() / 2);
    }
    this.mLeftDelta = (this.mLeft - arrayOfInt[0]);
    this.mTopDelta = (this.mTop - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.mBigImgWidth;
      j = this.mBigImgHeight;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.mWidthScale = (this.mWidth / i);
        this.mHeightScale = (this.mHeight / j);
      }
      if ((this.delat_left != 0) || (this.delat_right != 0) || (this.delat_top != 0) || (this.delat_bottom != 0)) {}
      for (float f1 = 1.1F;; f1 = 1.0F)
      {
        if (paramBoolean)
        {
          if ((this.mBigImgWidth != 0) && (this.mBigImgHeight != 0))
          {
            this.mWidthScale = (this.mWidth / this.mBigImgWidth);
            this.mHeightScale = (this.mHeight / this.mBigImgHeight);
          }
          f1 = 1.0F;
        }
        float f2;
        if (this.mWidthScale > this.mHeightScale)
        {
          this.mZoomScale = (this.mWidthScale * f1);
          this.mTopDelta = ((int)(this.mTopDelta - (j * this.mZoomScale - this.mHeight * f1) / 2.0F));
          this.mTopDelta = ((int)(this.mTopDelta - this.mHeight * (f1 - 1.0F) / 2.0F - this.center_ScrollY * this.mZoomScale / 2.0F));
          this.mLeftDelta = ((int)(this.mLeftDelta - this.mWidth * (f1 - 1.0F) / 2.0F));
          if ((this.mBigImgHeight == 0) || (this.mTop >= (j - this.mBigImgHeight) / 2)) {
            break label547;
          }
          f2 = this.mTopDelta;
        }
        for (this.mTopDelta = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.mTopDelta = ((int)(this.mTopDelta - (f1 - 1.0F) * this.mHeight / 2.0F))) {
          label547:
          do
          {
            if ((this.mWidth == 0) && (this.mHeight == 0))
            {
              this.mZoomScale = 0.5F;
              this.mAnimaAlpha = 0.0F;
              this.mLeftDelta = ((int)(this.mLeftDelta - i * this.mZoomScale / 2.0F));
              this.mTopDelta = ((int)(this.mTopDelta - j * this.mZoomScale / 2.0F - this.center_ScrollY * this.mZoomScale / 2.0F));
            }
            return;
            this.mZoomScale = (this.mHeightScale * f1);
            this.mLeftDelta = ((int)(this.mLeftDelta - (i * this.mZoomScale - this.mWidth * f1) / 2.0F));
            if ((this.mBigImgHeight == 0) || (this.mBigImgHeight >= j)) {
              break;
            }
            this.mTopDelta = ((int)(this.mTopDelta - (j * this.mZoomScale - this.mHeight * f1) / 2.0F));
            break;
          } while ((this.mBigImgHeight == 0) || (this.mTop + this.mHeight <= (this.mBigImgHeight + j) / 2));
        }
      }
    }
  }
  
  public IparamCallback getParamCallback()
  {
    return this.paramCallback;
  }
  
  @TargetApi(16)
  public void runEnterAnimation(View paramView1, LinkedList<View> paramLinkedList, View paramView2, ICallback paramICallback)
  {
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.animationState == this.ANIMATION_IS_ENTERING) || (this.animationState == this.ANIMATION_IS_EXITING) || (this.animationState == this.ANIMATION_IS_OPEN)) {
      return;
    }
    prepareAnimationParam(paramView1, false);
    int i = UIUtil.getStatusBarHeight(this.context);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.mZoomScale);
    paramView1.setScaleY(this.mZoomScale);
    paramView1.setTranslationX(this.mLeftDelta);
    paramView1.setTranslationY(this.mTopDelta);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.enterAnimationDuration).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F);
    }
    paramView2 = paramLinkedList.iterator();
    while (paramView2.hasNext()) {
      ((View)paramView2.next()).setAlpha(0.0F);
    }
    paramView1.animate().setDuration(this.enterAnimationDuration).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(-i).setListener(new AdLandingPagesPreviewAnimation.1(this, paramICallback, paramView1, paramLinkedList));
    this.mHandler.postDelayed(new AdLandingPagesPreviewAnimation.2(this, paramView1, paramLinkedList), this.enterAnimationDuration);
  }
  
  @TargetApi(16)
  public void runExitAnimation(View paramView1, LinkedList<View> paramLinkedList, View paramView2, ICallback paramICallback, ClipCallback paramClipCallback)
  {
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.animationState == this.ANIMATION_IS_ENTERING) || (this.animationState == this.ANIMATION_IS_EXITING) || (this.animationState == this.ANIMATION_IS_CLOSE)) {}
    for (;;)
    {
      return;
      paramView1.getLocationOnScreen(new int[2]);
      prepareAnimationParam(paramView1, true);
      if (paramView2 != null) {
        paramView2.animate().setDuration(300L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F);
      }
      paramView2 = new AnimationSet(true);
      paramClipCallback = new AdLandingPagesPreviewAnimation.3(this, 1.0F, this.mZoomScale, 1.0F, this.mZoomScale, paramView1, paramClipCallback);
      paramClipCallback.setDuration(300L);
      paramClipCallback.setInterpolator(new DecelerateInterpolator(1.2F));
      paramView2.addAnimation(paramClipCallback);
      paramClipCallback = new TranslateAnimation(0.0F, this.mLeftDelta, 0.0F, this.mTopDelta);
      paramClipCallback.setDuration(300L);
      paramClipCallback.setInterpolator(new DecelerateInterpolator(1.2F));
      paramView2.addAnimation(paramClipCallback);
      paramView2.setFillAfter(true);
      paramView2.setAnimationListener(new AdLandingPagesPreviewAnimation.4(this, paramICallback));
      paramView1.startAnimation(paramView2);
      paramView1 = paramLinkedList.iterator();
      while (paramView1.hasNext()) {
        ((View)paramView1.next()).setAlpha(0.0F);
      }
    }
  }
  
  public void setAnimationParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLeft = paramInt1;
    this.mTop = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  public void setBigImgParam(int paramInt1, int paramInt2)
  {
    this.mBigImgWidth = paramInt1;
    this.mBigImgHeight = paramInt2;
  }
  
  public void setCenterScrollParam(int paramInt)
  {
    this.center_ScrollY = paramInt;
  }
  
  public void setEnterAnimationDuration(int paramInt)
  {
    this.enterAnimationDuration = paramInt;
  }
  
  public void setImageIfo(Object paramObject)
  {
    this.imageInfo = paramObject;
  }
  
  public void setParamCallback(IparamCallback paramIparamCallback)
  {
    this.paramCallback = paramIparamCallback;
  }
  
  public void setThumbClipParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.delat_left = paramInt1;
    this.delat_right = paramInt2;
    this.delat_top = paramInt3;
    this.delat_bottom = paramInt4;
  }
  
  @TargetApi(18)
  public static abstract interface ClipCallback
  {
    public abstract void setClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface ICallback
  {
    public abstract void onAnimationEnd();
    
    public abstract void onAnimationStart();
  }
  
  public static abstract interface IparamCallback
  {
    public abstract Rect getAnimationParam(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesPreviewAnimation
 * JD-Core Version:    0.7.0.1
 */