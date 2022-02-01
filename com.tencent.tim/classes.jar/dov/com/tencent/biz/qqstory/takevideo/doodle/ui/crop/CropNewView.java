package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import aylk;
import ayll;
import ayln;
import com.tencent.TMG.utils.QLog;
import ras;

public class CropNewView
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ScaleGestureDetector.OnScaleGestureListener, Runnable
{
  private ayll jdField_a_of_type_Ayll;
  private ayln jdField_a_of_type_Ayln = new ayln();
  private a jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$a;
  private boolean aIG;
  private ScaleGestureDetector d;
  private boolean dvF;
  private int eGn;
  private GestureDetector i;
  
  public CropNewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropNewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize(paramContext);
  }
  
  private void a(aylk paramaylk)
  {
    this.jdField_a_of_type_Ayln.setScale(paramaylk.scale);
    this.jdField_a_of_type_Ayln.setRotate(paramaylk.rotate);
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
    paramCanvas.save();
    RectF localRectF = this.jdField_a_of_type_Ayln.k();
    paramCanvas.rotate(this.jdField_a_of_type_Ayln.getRotate(), localRectF.centerX(), localRectF.centerY());
    this.jdField_a_of_type_Ayln.bW(paramCanvas);
    this.jdField_a_of_type_Ayln.ch(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.jdField_a_of_type_Ayln.d(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void eNl()
  {
    invalidate();
    eNm();
    aylk localaylk1 = this.jdField_a_of_type_Ayln.b(getScrollX(), getScrollY());
    aylk localaylk2 = this.jdField_a_of_type_Ayln.c(getScrollX(), getScrollY());
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
    this.i = new GestureDetector(paramContext, new b(null));
    this.d = new ScaleGestureDetector(paramContext, this);
  }
  
  private boolean onScroll(float paramFloat1, float paramFloat2)
  {
    aylk localaylk = this.jdField_a_of_type_Ayln.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localaylk != null)
    {
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$a != null) && (!this.aIG))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$a.eNo();
        setCrop(true);
      }
      a(localaylk);
      return true;
    }
    return bD(getScrollX() + Math.round(paramFloat1), getScrollY() + Math.round(paramFloat2));
  }
  
  boolean aPi()
  {
    return (this.jdField_a_of_type_Ayll != null) && (this.jdField_a_of_type_Ayll.isRunning());
  }
  
  boolean aPl()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onSteady: isHoming=" + aPi());
    }
    if (!aPi())
    {
      this.jdField_a_of_type_Ayln.ak(getScrollX(), getScrollY());
      eNl();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$a != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$a.eNo();
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean aQM()
  {
    this.jdField_a_of_type_Ayln.a(getScrollX(), getScrollY());
    this.jdField_a_of_type_Ayln.YE(true);
    setResetHome(true);
    eNl();
    return true;
  }
  
  public Bitmap aZ()
  {
    float f = 1.0F / this.jdField_a_of_type_Ayln.getScale();
    RectF localRectF = new RectF(this.jdField_a_of_type_Ayln.k());
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(this.jdField_a_of_type_Ayln.getRotate(), localRectF.centerX(), localRectF.centerY());
    ((Matrix)localObject).mapRect(localRectF);
    ((Matrix)localObject).setScale(f, f, localRectF.left, localRectF.top);
    ((Matrix)localObject).mapRect(localRectF);
    localObject = Bitmap.createBitmap(Math.round(localRectF.width()), Math.round(localRectF.height()), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    localCanvas.translate(-localRectF.left, -localRectF.top);
    localCanvas.scale(f, f, localRectF.left, localRectF.top);
    c(localCanvas, false);
    return localObject;
  }
  
  public void aet(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$a != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$a.Ff(paramInt);
    }
  }
  
  public void eNn()
  {
    this.jdField_a_of_type_Ayln.eNf();
    eNl();
  }
  
  public void eSv()
  {
    this.jdField_a_of_type_Ayln.eSv();
    this.jdField_a_of_type_Ayln.YE(true);
    setResetHome(true);
    eNl();
  }
  
  public void eSw()
  {
    this.jdField_a_of_type_Ayln.eSw();
    eNl();
    setCrop(false);
  }
  
  public void eSx()
  {
    if (!aPi())
    {
      this.jdField_a_of_type_Ayln.rotate(-90);
      eNl();
    }
  }
  
  boolean n(MotionEvent paramMotionEvent)
  {
    if (aPi()) {
      return false;
    }
    this.eGn = paramMotionEvent.getPointerCount();
    boolean bool = this.d.onTouchEvent(paramMotionEvent) | at(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      return bool;
    case 0: 
      this.jdField_a_of_type_Ayln.al(paramMotionEvent.getX(), paramMotionEvent.getY());
      aet(1);
      return bool;
    }
    this.jdField_a_of_type_Ayln.aj(getScrollX(), getScrollY());
    aet(2);
    eNl();
    return bool;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationCancel!");
    }
    this.jdField_a_of_type_Ayln.YH(this.jdField_a_of_type_Ayll.isRotate());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationEnd!");
    }
    if (this.jdField_a_of_type_Ayln.b(getScrollX(), getScrollY(), this.jdField_a_of_type_Ayll.isRotate())) {
      a(this.jdField_a_of_type_Ayln.a(getScrollX(), getScrollY()));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationStart!");
    }
    this.jdField_a_of_type_Ayln.YG(this.jdField_a_of_type_Ayll.isRotate());
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Ayln.bv(paramValueAnimator.getAnimatedFraction());
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
    if (paramBoolean) {
      this.jdField_a_of_type_Ayln.ah(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.eGn > 1)
    {
      this.jdField_a_of_type_Ayln.onScale(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.eGn > 1)
    {
      this.jdField_a_of_type_Ayln.dbE();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Ayln.eNj();
    ras.sp("0X800A9AB");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
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
  
  public void setCrop(boolean paramBoolean)
  {
    this.aIG = paramBoolean;
  }
  
  public void setCropListener(a parama)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$a = parama;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Ayln.a(this);
    this.jdField_a_of_type_Ayln.setBitmap(paramBitmap);
    setResetHome(false);
    setCrop(false);
    invalidate();
  }
  
  public void setResetHome(boolean paramBoolean)
  {
    this.dvF = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void Ff(int paramInt);
    
    public abstract void eNo();
  }
  
  class b
    extends GestureDetector.SimpleOnGestureListener
  {
    private b() {}
    
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
      return CropNewView.a(CropNewView.this, paramFloat1, paramFloat2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView
 * JD-Core Version:    0.7.0.1
 */