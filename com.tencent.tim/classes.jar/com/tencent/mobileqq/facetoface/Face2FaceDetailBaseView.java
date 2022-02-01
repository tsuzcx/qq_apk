package com.tencent.mobileqq.facetoface;

import agat;
import agau;
import agay;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqmp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class Face2FaceDetailBaseView
  extends RelativeLayout
{
  protected View CG;
  public View CH;
  protected View CI;
  protected View CJ;
  long Yd = 0L;
  public a b;
  public Face2FaceFriendBubbleView b;
  protected int cWi;
  protected final int cWj = 8;
  protected final int cWk = 10;
  private boolean ccr = true;
  protected boolean isShowing;
  protected Canvas mCanvas;
  protected View mHeadView;
  protected float wp = 1.5F;
  
  public Face2FaceDetailBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private AnimationSet a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(-paramInt1, 0.0F, -paramInt2, 0.0F);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, 1.0F, paramFloat2, 1.0F, 1, 0.0F, 1, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator(this.wp));
    return localAnimationSet;
  }
  
  private AnimationSet b(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, -paramInt1, 0.0F, -paramInt2);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, paramFloat1, 1.0F, paramFloat2, 1, 0.0F, 1, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator(this.wp));
    return localAnimationSet;
  }
  
  private void init()
  {
    this.mCanvas = new Canvas();
    this.cWi = 2130840369;
  }
  
  public void a(View paramView, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView)
  {
    this.Yd = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$a.dez();
    this.CI = paramView;
    this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView = paramFace2FaceFriendBubbleView;
    gG(this.CI);
    deF();
  }
  
  public boolean akG()
  {
    deG();
    return true;
  }
  
  public View bY()
  {
    return this.mHeadView;
  }
  
  protected void deF()
  {
    long l1 = System.currentTimeMillis();
    this.isShowing = true;
    this.ccr = true;
    this.mHeadView.clearAnimation();
    setVisibility(0);
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.findViewById(2131367680);
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.findViewById(2131367681);
    int i = this.mHeadView.getLeft();
    int j = ((View)localObject1).getLeft();
    int k = ((View)localObject2).getLeft();
    int m = this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.getLeft();
    int n = this.mHeadView.getTop();
    int i1 = ((View)localObject1).getTop();
    int i2 = ((View)localObject2).getTop();
    int i3 = this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.getTop();
    float f = ((View)localObject1).getWidth() * 1.0F / this.mHeadView.getWidth();
    localObject1 = a(i - (j + k + m), n - (i2 + i1 + i3), f, f);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AlphaAnimation)localObject2).setStartOffset(150L);
    ((AlphaAnimation)localObject2).setAnimationListener(new agat(this));
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation1.setStartOffset(350L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation2.setStartOffset(350L);
    this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.deH();
    this.CH.startAnimation((Animation)localObject2);
    this.mHeadView.startAnimation((Animation)localObject1);
    this.CG.startAnimation(localAlphaAnimation1);
    this.CJ.startAnimation(localAlphaAnimation2);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animShow: totalTime=" + (l2 - this.Yd) + ",blurAndVisiableTime:" + (l1 - this.Yd) + ",buildAnimTime:" + (l2 - l1) + "");
    }
  }
  
  protected void deG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animHide, isAnimHideEnd=" + this.ccr);
    }
    if (!this.ccr) {
      return;
    }
    this.ccr = false;
    this.isShowing = false;
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.findViewById(2131367680);
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.findViewById(2131367681);
    int i = this.mHeadView.getLeft();
    int j = ((View)localObject1).getLeft();
    int k = ((View)localObject2).getLeft();
    int m = this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.getLeft();
    int n = this.mHeadView.getTop();
    int i1 = ((View)localObject1).getTop();
    int i2 = ((View)localObject2).getTop();
    int i3 = this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.getTop();
    float f = ((View)localObject1).getWidth() * 1.0F / this.mHeadView.getWidth();
    localObject1 = b(i - (j + k + m), n - (i2 + i1 + i3), f, f);
    this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$a.deB();
    ((AnimationSet)localObject1).setAnimationListener(new agau(this));
    localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AlphaAnimation)localObject2).setFillAfter(true);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(150L);
    localAlphaAnimation1.setFillAfter(true);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(150L);
    localAlphaAnimation2.setFillAfter(true);
    this.CH.startAnimation((Animation)localObject2);
    this.CG.startAnimation(localAlphaAnimation1);
    this.mHeadView.startAnimation((Animation)localObject1);
    this.CJ.startAnimation(localAlphaAnimation2);
  }
  
  protected void gG(View paramView)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
      long l2 = System.currentTimeMillis();
      this.mCanvas.setBitmap(localBitmap);
      paramView.draw(this.mCanvas);
      this.mCanvas.drawColor(Color.parseColor("#70000000"), PorterDuff.Mode.DARKEN);
      long l3 = System.currentTimeMillis();
      paramView = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() / 10, localBitmap.getHeight() / 10, true);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      long l4 = System.currentTimeMillis();
      aqmp.fastblur(paramView, 8);
      long l5 = System.currentTimeMillis();
      if (paramView != null) {
        this.CH.setBackgroundDrawable(new BitmapDrawable(getResources(), paramView));
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Face2FaceDetailBaseView", 2, "blurBackground, createEmptyBmp=" + (l2 - l1) + ", drawBmp=" + (l3 - l2) + ", scale-recyle=" + (l4 - l3) + ", blur=" + (l5 - l4) + " total=" + (l5 - l1));
        return;
        this.CH.setBackgroundResource(this.cWi);
      }
      return;
    }
    catch (OutOfMemoryError paramView)
    {
      this.CH.setBackgroundResource(this.cWi);
      if (QLog.isColorLevel())
      {
        QLog.e("Face2FaceDetailBaseView", 2, "blurBackground:" + paramView.toString());
        return;
      }
    }
    catch (Exception paramView)
    {
      this.CH.setBackgroundResource(this.cWi);
      if (QLog.isColorLevel()) {
        QLog.e("Face2FaceDetailBaseView", 2, "blurBackground:" + paramView.toString());
      }
    }
  }
  
  protected abstract void initView();
  
  public boolean isShowing()
  {
    return this.isShowing;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    initView();
    this.CH = new View(getContext());
    addView(this.CH, 0, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  public void setInfc(a parama)
  {
    this.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(agay paramagay, int paramInt);
    
    public abstract void c(agay paramagay);
    
    public abstract void deA();
    
    public abstract void deB();
    
    public abstract void deC();
    
    public abstract void dez();
    
    public abstract QQAppInterface getApp();
    
    public abstract boolean mi(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView
 * JD-Core Version:    0.7.0.1
 */