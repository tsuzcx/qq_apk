package com.tencent.biz.publicAccountImageCollection;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class PublicAccountImageView
  extends URLImageView
{
  private c a;
  float[] aA = new float[9];
  boolean ayt = false;
  boolean ayu = false;
  private float lF;
  private float lG;
  float lH;
  Context mContext;
  private GestureDetector mGestureDetector;
  Handler mHandler;
  private Matrix mMatrix = new Matrix();
  float mMaxScale;
  private float mScale;
  
  public PublicAccountImageView(Context paramContext, Handler paramHandler, Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, null);
    this.mContext = paramContext;
    paramContext = new b();
    setOnTouchListener(paramContext);
    this.mGestureDetector = new GestureDetector(getContext(), new a(paramContext));
    setBackgroundColor(-16777216);
    if (paramInt1 == 1) {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    for (;;)
    {
      this.mMatrix.set(paramMatrix);
      this.mMatrix.getValues(this.aA);
      this.mHandler = paramHandler;
      this.lG = paramInt3;
      this.lF = paramInt2;
      initData();
      return;
      setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  public PublicAccountImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramContext = new b();
    setOnTouchListener(paramContext);
    this.mGestureDetector = new GestureDetector(getContext(), new a(paramContext));
    setBackgroundColor(-16777216);
    setScaleType(ImageView.ScaleType.MATRIX);
    initData();
  }
  
  private void bht()
  {
    if (PublicAccountImageCollectionMainActivity.ayr)
    {
      this.mHandler.sendEmptyMessage(2);
      return;
    }
    this.mHandler.sendEmptyMessage(1);
  }
  
  private void initData()
  {
    float[] arrayOfFloat = new float[9];
    this.mMatrix.getValues(arrayOfFloat);
    if (QLog.isColorLevel())
    {
      QLog.d("PublicAccountImageView", 2, "image height is" + this.lG);
      QLog.d("PublicAccountImageView", 2, "image width is" + this.lF);
    }
    this.mScale = arrayOfFloat[0];
    this.mMaxScale = 5.5F;
    this.lH = 5.0F;
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private final PublicAccountImageView.b a;
    
    public a(PublicAccountImageView.b paramb)
    {
      this.a = paramb;
    }
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      PublicAccountImageView.a(PublicAccountImageView.this);
      return false;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      PublicAccountImageView.a(PublicAccountImageView.this);
      return super.onSingleTapConfirmed(paramMotionEvent);
    }
  }
  
  public class b
    implements View.OnTouchListener
  {
    private PointF K = new PointF();
    boolean ayv;
    boolean ayw;
    boolean ayx = false;
    private float lI;
    private int mMode;
    private Matrix x = new Matrix();
    
    public b() {}
    
    private void G(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getPointerCount() < 2) {}
      float f1;
      do
      {
        return;
        f1 = distance(paramMotionEvent);
      } while (f1 <= 10.0F);
      float f2 = f1 / this.lI;
      this.lI = f1;
      PublicAccountImageView.this.ayt = false;
      PublicAccountImageView.this.ayu = false;
      this.x.set(PublicAccountImageView.this.getImageMatrix());
      paramMotionEvent = new float[9];
      this.x.getValues(paramMotionEvent);
      if (paramMotionEvent[0] > PublicAccountImageView.b(PublicAccountImageView.this) * PublicAccountImageView.this.mMaxScale)
      {
        f1 = 1.0F;
        PublicAccountImageView.this.ayt = true;
      }
      for (;;)
      {
        this.x.postScale(f1, f1, PublicAccountImageView.this.getWidth() / 2, PublicAccountImageView.this.getHeight() / 2);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageView", 2, "the current scale is" + f1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageView", 2, "scale of x is" + paramMotionEvent[0]);
        }
        PublicAccountImageView.this.setImageMatrix(this.x);
        return;
        f1 = f2;
        if (paramMotionEvent[0] < PublicAccountImageView.b(PublicAccountImageView.this))
        {
          PublicAccountImageView.this.ayu = true;
          f1 = f2;
        }
      }
    }
    
    private boolean Hr()
    {
      boolean bool = false;
      float[] arrayOfFloat = new float[9];
      PublicAccountImageView.this.getImageMatrix().getValues(arrayOfFloat);
      if (arrayOfFloat[0] != PublicAccountImageView.b(PublicAccountImageView.this)) {
        bool = true;
      }
      return bool;
    }
    
    private boolean Hs()
    {
      boolean bool = false;
      float[] arrayOfFloat = new float[9];
      PublicAccountImageView.this.getImageMatrix().getValues(arrayOfFloat);
      if (arrayOfFloat[0] < PublicAccountImageView.b(PublicAccountImageView.this)) {
        bool = true;
      }
      return bool;
    }
    
    private float a(float[] paramArrayOfFloat, float paramFloat)
    {
      float f2 = PublicAccountImageView.this.getHeight();
      float f1;
      if (PublicAccountImageView.c(PublicAccountImageView.this) * paramArrayOfFloat[4] / PublicAccountImageView.this.aA[4] < f2) {
        f1 = 0.0F;
      }
      do
      {
        return f1;
        if (paramArrayOfFloat[5] + paramFloat > 0.0F) {
          return -paramArrayOfFloat[5];
        }
        f1 = paramFloat;
      } while (paramArrayOfFloat[5] + paramFloat >= -(PublicAccountImageView.c(PublicAccountImageView.this) * paramArrayOfFloat[4] / PublicAccountImageView.this.aA[4] - f2));
      return -(PublicAccountImageView.c(PublicAccountImageView.this) * paramArrayOfFloat[4] / PublicAccountImageView.this.aA[4] - f2) - paramArrayOfFloat[5];
    }
    
    private float b(float[] paramArrayOfFloat, float paramFloat)
    {
      float f2 = PublicAccountImageView.this.getWidth();
      float f1;
      if (PublicAccountImageView.a(PublicAccountImageView.this) * paramArrayOfFloat[0] / PublicAccountImageView.this.aA[0] < f2) {
        f1 = 0.0F;
      }
      do
      {
        return f1;
        if (paramArrayOfFloat[2] + paramFloat > 0.0F) {
          return -paramArrayOfFloat[2];
        }
        f1 = paramFloat;
      } while (paramArrayOfFloat[2] + paramFloat >= -(PublicAccountImageView.a(PublicAccountImageView.this) * paramArrayOfFloat[0] / PublicAccountImageView.this.aA[0] - f2));
      return -(PublicAccountImageView.a(PublicAccountImageView.this) * paramArrayOfFloat[0] / PublicAccountImageView.this.aA[0] - f2) - paramArrayOfFloat[2];
    }
    
    private void bhu()
    {
      if (PublicAccountImageView.a(PublicAccountImageView.this) != null) {
        PublicAccountImageView.a(PublicAccountImageView.this).bhu();
      }
    }
    
    private void bhv()
    {
      this.ayv = true;
      this.ayw = true;
      this.ayx = true;
      float[] arrayOfFloat = new float[9];
      PublicAccountImageView.this.getImageMatrix().getValues(arrayOfFloat);
      if (arrayOfFloat[2] >= 0.0F) {
        this.ayw = false;
      }
      float f1 = PublicAccountImageView.a(PublicAccountImageView.this);
      float f2 = arrayOfFloat[0];
      if (arrayOfFloat[2] + f1 * f2 <= PublicAccountImageView.this.getWidth()) {
        this.ayv = false;
      }
    }
    
    private void bhw()
    {
      float f = PublicAccountImageView.this.lH / PublicAccountImageView.this.mMaxScale;
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageView", 2, "back scale is" + f);
      }
      this.x.postScale(f, f, PublicAccountImageView.this.getWidth() / 2, PublicAccountImageView.this.getHeight() / 2);
      PublicAccountImageView.this.setImageMatrix(this.x);
    }
    
    private void bhx()
    {
      if (Hs())
      {
        this.x.set(PublicAccountImageView.a(PublicAccountImageView.this));
        PublicAccountImageView.this.setImageMatrix(this.x);
        PublicAccountImageView.this.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
    }
    
    private void bhy()
    {
      if (PublicAccountImageView.this.getScaleType() != ImageView.ScaleType.CENTER)
      {
        PublicAccountImageView.this.setScaleType(ImageView.ScaleType.MATRIX);
        return;
      }
      this.mMode = 3;
    }
    
    private float distance(MotionEvent paramMotionEvent)
    {
      float f1 = paramMotionEvent.getX(1) - paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(1) - paramMotionEvent.getY(0);
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    
    private void startDrag()
    {
      if (PublicAccountImageView.a(PublicAccountImageView.this) != null) {
        PublicAccountImageView.a(PublicAccountImageView.this).startDrag();
      }
    }
    
    public void F(MotionEvent paramMotionEvent)
    {
      if (Hr())
      {
        float f1 = paramMotionEvent.getX() - this.K.x;
        float f2 = paramMotionEvent.getY() - this.K.y;
        if (Math.sqrt(f1 * f1 + f2 * f2) > 10.0D)
        {
          this.K.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          this.x.set(PublicAccountImageView.this.getImageMatrix());
          paramMotionEvent = new float[9];
          this.x.getValues(paramMotionEvent);
          f2 = a(paramMotionEvent, f2);
          f1 = b(paramMotionEvent, f1);
          this.x.postTranslate(f1, f2);
          PublicAccountImageView.this.setImageMatrix(this.x);
        }
        return;
      }
      bhu();
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool = true;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        bool = PublicAccountImageView.a(PublicAccountImageView.this).onTouchEvent(paramMotionEvent);
        do
        {
          return bool;
          this.mMode = 1;
          this.K.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          bhy();
          startDrag();
          bhv();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageView", 2, "the current state is action up");
          }
          if (PublicAccountImageView.this.ayt)
          {
            bhw();
            PublicAccountImageView.this.ayt = false;
            break;
          }
          if (!PublicAccountImageView.this.ayu) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageView", 2, "back to init matrix");
          }
          PublicAccountImageView.this.setImageMatrix(PublicAccountImageView.a(PublicAccountImageView.this));
          PublicAccountImageView.this.setScaleType(ImageView.ScaleType.FIT_CENTER);
          break;
          bhx();
          break;
          if (this.mMode == 2)
          {
            G(paramMotionEvent);
            break;
          }
          if (this.mMode == 1)
          {
            F(paramMotionEvent);
            break;
          }
          bhu();
          break;
        } while (this.mMode == 3);
        this.mMode = 2;
        this.lI = distance(paramMotionEvent);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void bhu();
    
    public abstract void startDrag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageView
 * JD-Core Version:    0.7.0.1
 */