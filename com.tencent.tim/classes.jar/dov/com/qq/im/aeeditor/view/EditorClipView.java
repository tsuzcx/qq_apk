package dov.com.qq.im.aeeditor.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import axoj;
import aylk;
import ayll;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;

public class EditorClipView
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ScaleGestureDetector.OnScaleGestureListener, Runnable
{
  private axoj jdField_a_of_type_Axoj = new axoj();
  private ayll jdField_a_of_type_Ayll;
  private a jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$a;
  private b jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$b;
  private c jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$c;
  private boolean aIG;
  private ScaleGestureDetector d;
  private double du = 1.0D;
  private boolean dvF;
  private int eGn;
  private int eGo = -1;
  private GestureDetector i;
  
  public EditorClipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditorClipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize(paramContext);
  }
  
  private void a(aylk paramaylk)
  {
    this.jdField_a_of_type_Axoj.setScale(paramaylk.scale);
    this.jdField_a_of_type_Axoj.setRotate(paramaylk.rotate);
    if (!bD(Math.round(paramaylk.x), Math.round(paramaylk.y))) {
      invalidate();
    }
  }
  
  private void a(aylk paramaylk1, aylk paramaylk2)
  {
    if (this.jdField_a_of_type_Ayll == null)
    {
      this.jdField_a_of_type_Ayll = new ayll();
      this.jdField_a_of_type_Ayll.addUpdateListener(this);
      this.jdField_a_of_type_Ayll.addListener(this);
    }
    this.jdField_a_of_type_Ayll.b(paramaylk1, paramaylk2);
    this.jdField_a_of_type_Ayll.start();
  }
  
  private boolean at(MotionEvent paramMotionEvent)
  {
    return this.i.onTouchEvent(paramMotionEvent);
  }
  
  private boolean bD(int paramInt1, int paramInt2)
  {
    if ((getScrollX() != paramInt1) || (getScrollY() != paramInt2))
    {
      scrollTo(paramInt1, paramInt2);
      return true;
    }
    return false;
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.drawColor(getContext().getResources().getColor(2131165255));
    paramCanvas.save();
    RectF localRectF = this.jdField_a_of_type_Axoj.k();
    paramCanvas.rotate(this.jdField_a_of_type_Axoj.getRotate(), localRectF.centerX(), localRectF.centerY());
    this.jdField_a_of_type_Axoj.bW(paramCanvas);
    this.jdField_a_of_type_Axoj.k(paramCanvas, getScrollX(), getScrollY());
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.jdField_a_of_type_Axoj.d(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void eNl()
  {
    invalidate();
    eNm();
    aylk localaylk1 = this.jdField_a_of_type_Axoj.b(getScrollX(), getScrollY());
    aylk localaylk2 = this.jdField_a_of_type_Axoj.c(getScrollX(), getScrollY());
    if (this.dvF)
    {
      setResetHome(false);
      localaylk2.x = 0.0F;
      localaylk2.y = 0.0F;
    }
    a(localaylk1, localaylk2);
  }
  
  private void eNm()
  {
    if (this.jdField_a_of_type_Ayll != null) {
      this.jdField_a_of_type_Ayll.cancel();
    }
  }
  
  private void initialize(Context paramContext)
  {
    this.i = new GestureDetector(paramContext, new d(null));
    this.d = new ScaleGestureDetector(paramContext, this);
  }
  
  public EditorPicInfo a()
  {
    return a(this.jdField_a_of_type_Axoj.l(), this.jdField_a_of_type_Axoj.k());
  }
  
  public EditorPicInfo a(RectF paramRectF1, RectF paramRectF2)
  {
    EditorPicInfo localEditorPicInfo = new EditorPicInfo();
    float f1 = paramRectF1.width();
    float f2 = paramRectF1.height();
    float f3 = paramRectF2.width();
    float f4 = paramRectF2.height();
    localEditorPicInfo.x = ((paramRectF2.left - paramRectF1.left) / f1);
    localEditorPicInfo.y = ((paramRectF2.top - paramRectF1.top) / f2);
    localEditorPicInfo.w = (f3 / f1);
    localEditorPicInfo.h = (f4 / f2);
    return localEditorPicInfo;
  }
  
  boolean aPi()
  {
    return (this.jdField_a_of_type_Ayll != null) && (this.jdField_a_of_type_Ayll.isRunning());
  }
  
  boolean aPl()
  {
    if (!aPi())
    {
      this.jdField_a_of_type_Axoj.ak(getScrollX(), getScrollY());
      eNl();
      if (this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$c != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$c.eNo();
      }
      return true;
    }
    return false;
  }
  
  public void aet(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$c != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$c.Ff(paramInt);
    }
  }
  
  public void aeu(int paramInt)
  {
    this.jdField_a_of_type_Axoj.aes(paramInt);
  }
  
  public void eNk()
  {
    this.jdField_a_of_type_Axoj.eNk();
  }
  
  public void eNn()
  {
    this.jdField_a_of_type_Axoj.eNf();
    eNl();
  }
  
  public RectF m()
  {
    return this.jdField_a_of_type_Axoj.l();
  }
  
  public RectF n()
  {
    return this.jdField_a_of_type_Axoj.k();
  }
  
  boolean n(MotionEvent paramMotionEvent)
  {
    if (aPi()) {
      return false;
    }
    this.eGn = paramMotionEvent.getPointerCount();
    boolean bool1 = this.d.onTouchEvent(paramMotionEvent);
    boolean bool2 = at(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return bool1 | bool2;
      this.jdField_a_of_type_Axoj.g(paramMotionEvent.getX(), paramMotionEvent.getY(), false);
      aet(1);
      continue;
      this.jdField_a_of_type_Axoj.aj(getScrollX(), getScrollY());
      aet(2);
      eNl();
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Axoj.YH(this.jdField_a_of_type_Ayll.isRotate());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Axoj.b(getScrollX(), getScrollY(), this.jdField_a_of_type_Ayll.isRotate())) {
      a(this.jdField_a_of_type_Axoj.a(getScrollX(), getScrollY()));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_Axoj.YG(this.jdField_a_of_type_Ayll.isRotate());
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Axoj.bv(paramValueAnimator.getAnimatedFraction());
    a((aylk)paramValueAnimator.getAnimatedValue());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    c(paramCanvas, true);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = (int)(paramInt3 - paramInt1 - 10.0F);
    if (this.eGo != j)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$b != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$b.aei(j);
      }
      this.eGo = j;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Axoj.ah(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.eGn > 1)
    {
      this.jdField_a_of_type_Axoj.onScale(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.eGn > 1)
    {
      this.jdField_a_of_type_Axoj.dbE();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Axoj.eNj();
  }
  
  public boolean onScroll(float paramFloat1, float paramFloat2)
  {
    aylk localaylk = this.jdField_a_of_type_Axoj.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localaylk != null)
    {
      if ((this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$c != null) && (!this.aIG))
      {
        this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$c.eNo();
        setCrop(true);
      }
      a(localaylk);
      return true;
    }
    return bD(getScrollX() + Math.round(paramFloat1), getScrollY() + Math.round(paramFloat2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$a != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$a.eLV();
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return n(paramMotionEvent);
      removeCallbacks(this);
      continue;
      postDelayed(this, 1000L);
    }
  }
  
  public void run()
  {
    if (!aPl()) {
      postDelayed(this, 400L);
    }
  }
  
  public void setClipViewOperateListener(a parama)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$a = parama;
  }
  
  public void setClipWindowWidthChangeListener(b paramb)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$b = paramb;
  }
  
  public void setCrop(boolean paramBoolean)
  {
    this.aIG = paramBoolean;
  }
  
  public void setCropListener(c paramc)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewEditorClipView$c = paramc;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Axoj.a(this);
    this.jdField_a_of_type_Axoj.setBitmap(paramBitmap);
    setResetHome(false);
    setCrop(false);
    invalidate();
  }
  
  public void setRate(double paramDouble)
  {
    this.du = paramDouble;
  }
  
  public void setResetHome(boolean paramBoolean)
  {
    this.dvF = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void eLV();
  }
  
  public static abstract interface b
  {
    public abstract void aei(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void Ff(int paramInt);
    
    public abstract void eNo();
  }
  
  class d
    extends GestureDetector.SimpleOnGestureListener
  {
    private d() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return EditorClipView.this.onScroll(paramFloat1, paramFloat2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.EditorClipView
 * JD-Core Version:    0.7.0.1
 */