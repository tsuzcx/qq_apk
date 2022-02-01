package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import aqcx;

public class VideoFeedsGuideView
  extends View
{
  public static final int[] COLORS = { -1, 16777215 };
  private AnimatorSet D;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideView$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideView$b;
  private c jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideView$c;
  private int aUC = 0;
  private int aUJ;
  private int aUK;
  private int aUL;
  private int aUM;
  private int aUN;
  private int ahe;
  private Bitmap cc;
  public int mMinHeight;
  public int mMinWidth;
  private Paint mPaint;
  private Rect mRect;
  
  public VideoFeedsGuideView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void T(Canvas paramCanvas)
  {
    U(paramCanvas);
    V(paramCanvas);
  }
  
  private void U(Canvas paramCanvas)
  {
    int i = getWidth() / 3;
    int j = getHeight() - this.aUK + 10;
    int k = this.ahe;
    int m = getHeight();
    LinearGradient localLinearGradient = new LinearGradient(0.0F, j, 0.0F, m, COLORS, null, Shader.TileMode.CLAMP);
    this.mPaint.setShader(localLinearGradient);
    this.mRect.set(i, j, i + k, m);
    paramCanvas.drawRect(this.mRect, this.mPaint);
  }
  
  private void V(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.cc, getWidth() / 3, getHeight() - this.aUL - this.aUJ, this.mPaint);
  }
  
  private void W(Canvas paramCanvas)
  {
    X(paramCanvas);
    Y(paramCanvas);
  }
  
  private void X(Canvas paramCanvas)
  {
    int i = getWidth() * 5 / 6 - this.aUM + 10;
    int j = getHeight() - this.cc.getHeight();
    int k = getWidth();
    int m = this.ahe;
    LinearGradient localLinearGradient = new LinearGradient(i, 0.0F, k, 0.0F, COLORS, null, Shader.TileMode.CLAMP);
    this.mPaint.setShader(localLinearGradient);
    this.mRect.set(i, j, k, j + m);
    paramCanvas.drawRect(this.mRect, this.mPaint);
  }
  
  private void Y(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.cc, getWidth() * 5 / 6 - this.aUN - this.aUJ, getHeight() - this.cc.getHeight(), this.mPaint);
  }
  
  private void init()
  {
    this.mMinHeight = aqcx.dip2px(getContext(), 150.0F);
    this.mMinWidth = aqcx.dip2px(getContext(), 180.0F);
    this.ahe = aqcx.dip2px(getContext(), 8.0F);
    this.aUK = aqcx.dip2px(getContext(), 70.0F);
    this.aUM = aqcx.dip2px(getContext(), 70.0F);
    this.aUJ = this.aUK;
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setAntiAlias(true);
    this.mRect = new Rect();
    this.cc = BitmapFactory.decodeResource(getResources(), 2130843934);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideView$a = new a(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideView$b = new b(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideView$c = new c(null);
  }
  
  private int j(int paramInt, boolean paramBoolean)
  {
    int i = View.MeasureSpec.getSize(paramInt);
    if (paramBoolean) {}
    for (paramInt = this.mMinWidth; i < paramInt; paramInt = this.mMinHeight) {
      return paramInt;
    }
    return i;
  }
  
  private void reset(boolean paramBoolean)
  {
    if (this.aUC == 1)
    {
      this.aUL = 0;
      this.aUK = this.aUJ;
    }
    for (;;)
    {
      invalidate();
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideView$a.sendEmptyMessageDelayed(0, 300L);
      }
      return;
      this.aUN = 0;
      this.aUM = this.aUJ;
    }
  }
  
  private void startAnimate()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(200L);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.aUJ });
    localValueAnimator.addUpdateListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideView$c);
    localValueAnimator.setDuration(500L);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localValueAnimator).after(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setStartDelay(400L);
    this.D = new AnimatorSet();
    this.D.play(localObjectAnimator).after(localAnimatorSet);
    this.D.addListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGuideView$b);
    this.D.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.aUC == 0) {
      return;
    }
    if (this.aUC == 1)
    {
      T(paramCanvas);
      return;
    }
    W(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(j(paramInt1, true), j(paramInt2, false));
  }
  
  public void setCurrentMode(int paramInt)
  {
    this.aUC = paramInt;
    invalidate();
  }
  
  class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      VideoFeedsGuideView.a(VideoFeedsGuideView.this);
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    private b() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      super.onAnimationCancel(paramAnimator);
      VideoFeedsGuideView.a(VideoFeedsGuideView.this, false);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      super.onAnimationEnd(paramAnimator);
      VideoFeedsGuideView.a(VideoFeedsGuideView.this, true);
    }
  }
  
  class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    private c() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (VideoFeedsGuideView.a(VideoFeedsGuideView.this) == 1)
      {
        VideoFeedsGuideView.a(VideoFeedsGuideView.this, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
        VideoFeedsGuideView.b(VideoFeedsGuideView.this, VideoFeedsGuideView.b(VideoFeedsGuideView.this) + VideoFeedsGuideView.c(VideoFeedsGuideView.this));
      }
      for (;;)
      {
        VideoFeedsGuideView.this.invalidate();
        return;
        VideoFeedsGuideView.c(VideoFeedsGuideView.this, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
        VideoFeedsGuideView.d(VideoFeedsGuideView.this, VideoFeedsGuideView.b(VideoFeedsGuideView.this) + VideoFeedsGuideView.d(VideoFeedsGuideView.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGuideView
 * JD-Core Version:    0.7.0.1
 */