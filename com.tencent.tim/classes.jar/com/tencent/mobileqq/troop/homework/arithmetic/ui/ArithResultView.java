package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import apgo;
import apgo.a;
import ram;
import rpq;

public class ArithResultView
  extends BaseScaleAndMoveBitmapView
{
  public int Dk = 20;
  private apgo jdField_a_of_type_Apgo;
  private a jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView$a;
  private int dp;
  private Bitmap gs;
  private Paint mPaint = new Paint();
  
  public ArithResultView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ArithResultView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ArithResultView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(-65536);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStrokeWidth(rpq.dip2px(paramContext, 1.0F));
    this.dp = rpq.dip2px(paramContext, 1.0F);
    this.Dk = (this.dp * 5);
    try
    {
      this.gs = BitmapFactory.decodeResource(getResources(), 2130847085);
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      ram.e("QQ.Troop.homework.ArithResultView", "create the mark bitmap out of memory:" + paramContext.toString());
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Canvas paramCanvas)
  {
    paramCanvas.drawRoundRect(new RectF(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), this.Dk, this.Dk, this.mPaint);
    if (this.gs != null)
    {
      Rect localRect1 = new Rect(0, 0, this.gs.getWidth(), this.gs.getHeight());
      Rect localRect2 = new Rect(paramInt1 + paramInt3 + this.dp * 2, paramInt4 / 4 + paramInt2, paramInt1 + paramInt3 + this.dp * 2 + paramInt4 / 2, paramInt4 * 3 / 4 + paramInt2);
      paramCanvas.drawBitmap(this.gs, localRect1, localRect2, null);
    }
  }
  
  private void a(apgo.a parama)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView$a.b(parama);
    }
  }
  
  protected void ad(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = 0;
    if (i < this.jdField_a_of_type_Apgo.Lq())
    {
      paramMotionEvent = this.jdField_a_of_type_Apgo.a(i);
      if (paramMotionEvent.cQq) {}
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      float f8;
      do
      {
        i += 1;
        break;
        f3 = (paramMotionEvent.x + this.pd) * this.mScaleFactor;
        f4 = (paramMotionEvent.y + this.pe) * this.mScaleFactor;
        f5 = paramMotionEvent.width + this.dp * 5 + paramMotionEvent.height / 2;
        f6 = this.mScaleFactor;
        f7 = paramMotionEvent.height;
        f8 = this.mScaleFactor;
      } while ((f1 <= f3) || (f2 <= f4) || (f1 >= f3 + f5 * f6) || (f2 >= f4 + f7 * f8));
      a(paramMotionEvent);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.save();
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Apgo != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_Apgo.Lq())
      {
        apgo.a locala = this.jdField_a_of_type_Apgo.a(i);
        if (locala.cQq) {}
        for (;;)
        {
          i += 1;
          break;
          int j = (int)(locala.x + this.pd - this.dp);
          int k = (int)(locala.y + this.pe - this.dp);
          int m = locala.width;
          int n = this.dp;
          int i1 = locala.height;
          a(j, k, m + n * 2, this.dp * 2 + i1, paramCanvas);
        }
      }
    }
    paramCanvas.restore();
  }
  
  public void setData(apgo paramapgo)
  {
    this.jdField_a_of_type_Apgo = paramapgo;
    invalidate();
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b(apgo.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.ArithResultView
 * JD-Core Version:    0.7.0.1
 */