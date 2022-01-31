package com.tencent.biz.qrcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.SkinUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ViewfinderView
  extends View
{
  protected static final long a = 20L;
  protected static final long b = 5000L;
  protected double a;
  protected final int a;
  protected final Paint a;
  protected Rect a;
  protected Drawable a;
  protected AtomicBoolean a;
  protected int b;
  protected Drawable b;
  protected int c;
  protected long c;
  
  public ViewfinderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_Int = 2130706432;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = super.getResources().getDrawable(2130838496);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = super.getResources().getDrawable(2130838506);
    if (SkinUtils.a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable) != null) {
      this.jdField_c_of_type_Int = SkinUtils.a(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).getHeight();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
        super.postInvalidateDelayed(20L, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = super.getWidth();
    int j = super.getHeight();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      paramCanvas.drawRect(0.0F, 0.0F, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    do
    {
      return;
      paramCanvas.drawRect(0.0F, 0.0F, i, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, i, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.bottom, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    i = (int)((System.currentTimeMillis() - this.jdField_c_of_type_Long) * this.jdField_a_of_type_Double) % this.jdField_b_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top + i, this.jdField_a_of_type_AndroidGraphicsRect.right, i + this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    super.postInvalidateDelayed(20L, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
  }
  
  public void setFlippedFrameingRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
    this.jdField_b_of_type_Int = (paramRect.height() - this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Double = (this.jdField_b_of_type_Int / 5000.0D);
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.ViewfinderView
 * JD-Core Version:    0.7.0.1
 */