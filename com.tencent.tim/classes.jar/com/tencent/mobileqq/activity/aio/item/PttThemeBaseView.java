package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import wja;

public abstract class PttThemeBaseView
  extends View
{
  protected RectF aj;
  protected RectF ak;
  protected int bUe = -1;
  protected int bUo;
  protected int bUp = -1;
  protected int bUq = 8;
  protected boolean bhE;
  protected Bitmap bitmapSrc;
  protected Paint bo;
  protected int bottom;
  protected PorterDuffXfermode c;
  protected Xfermode c;
  protected Bitmap eg;
  protected Canvas j;
  protected Canvas l;
  protected int left;
  protected int mStrokeWidth = 1;
  protected int right;
  protected int top;
  
  public PttThemeBaseView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PttThemeBaseView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PttThemeBaseView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cdW()
  {
    this.l.drawColor(0, PorterDuff.Mode.CLEAR);
    int i = this.l.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
    aB(this.l);
    aD(this.l);
    this.l.restoreToCount(i);
  }
  
  protected abstract boolean SA();
  
  protected abstract void aB(Canvas paramCanvas);
  
  protected void aD(Canvas paramCanvas)
  {
    if (this.bUo != 0)
    {
      cdV();
      this.bo.setXfermode(this.jdField_c_of_type_AndroidGraphicsXfermode);
      paramCanvas.drawBitmap(this.bitmapSrc, this.left, this.top, this.bo);
      this.bo.setXfermode(null);
    }
  }
  
  protected void cdV()
  {
    if ((this.j == null) || (this.bitmapSrc == null) || (!this.bhE)) {
      return;
    }
    this.bo.setXfermode(this.jdField_c_of_type_AndroidGraphicsPorterDuffXfermode);
    this.j.drawPaint(this.bo);
    this.bo.setXfermode(null);
    this.bo.setColor(this.bUo);
    this.j.drawRect(this.ak, this.bo);
  }
  
  public void destory()
  {
    if ((this.bitmapSrc != null) && (!this.bitmapSrc.isRecycled())) {
      this.bitmapSrc.recycle();
    }
    if ((this.eg != null) && (!this.eg.isRecycled())) {
      this.eg.recycle();
    }
    this.bitmapSrc = null;
    this.eg = null;
  }
  
  protected void init(int paramInt)
  {
    this.bo = new Paint();
    this.bo.setAntiAlias(true);
    this.bo.setStrokeWidth(this.mStrokeWidth);
    this.jdField_c_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    this.jdField_c_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.bUq = wja.dp2px(paramInt, getContext().getResources());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.aj == null) || (this.bhE)) {
      this.aj = new RectF(this.left, this.top, this.right, this.bottom);
    }
    if (SA())
    {
      if (this.bhE)
      {
        cdW();
        this.bhE = false;
      }
      paramCanvas.save();
      paramCanvas.drawBitmap(this.eg, null, this.ak, this.bo);
      paramCanvas.restore();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel()) {
      QLog.d("PttBaseView", 2, "onLayout changed=" + paramBoolean + " left=" + paramInt1 + " top=" + paramInt2 + " right=" + paramInt3 + " bottom=" + paramInt4);
    }
    if (paramBoolean)
    {
      this.bUp = ((getMeasuredWidth() - getPaddingRight() + getPaddingLeft()) / 2);
      this.bUe = ((getMeasuredHeight() + getPaddingTop() - getPaddingBottom()) / 2);
      if (this.bUp < 0) {
        this.bUp = 0;
      }
      if (this.bUe < 0) {
        this.bUe = 0;
      }
      this.left = (this.bUp - this.bUq);
      this.right = (this.bUp + this.bUq);
      this.top = (this.bUe - this.bUq);
      this.bottom = (this.bUe + this.bUq);
      this.bitmapSrc = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
      this.j = new Canvas(this.bitmapSrc);
      this.eg = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
      this.l = new Canvas(this.eg);
      this.ak = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      this.bhE = true;
    }
  }
  
  public void setThemeColor(int paramInt)
  {
    if (this.bUo != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttBaseView", 2, "setThemeColor " + Integer.toHexString(this.bUo));
      }
      this.bUo = paramInt;
      this.bhE = true;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttThemeBaseView
 * JD-Core Version:    0.7.0.1
 */