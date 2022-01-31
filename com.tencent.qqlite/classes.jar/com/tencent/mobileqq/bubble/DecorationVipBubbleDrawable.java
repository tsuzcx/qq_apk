package com.tencent.mobileqq.bubble;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.util.StateSet;
import com.tencent.mobileqq.utils.ImageUtil;
import daj;

public class DecorationVipBubbleDrawable
  extends Drawable
{
  private static final ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -26.0F, 0.0F, 1.0F, 0.0F, 0.0F, -26.0F, 0.0F, 0.0F, 1.0F, 0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  private static int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private int jdField_a_of_type_Int = 160;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private daj jdField_a_of_type_Daj;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public DecorationVipBubbleDrawable(Resources paramResources, Bitmap paramBitmap1, Bitmap paramBitmap2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(paramResources, new daj(new NinePatch(paramBitmap1, paramArrayOfByte1, null), new NinePatch(paramBitmap2, paramArrayOfByte2, null)));
  }
  
  public DecorationVipBubbleDrawable(Resources paramResources, Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    this(paramResources, new daj(new NinePatch(paramBitmap, paramArrayOfByte, null)));
  }
  
  public DecorationVipBubbleDrawable(Resources paramResources, daj paramdaj)
  {
    this.jdField_a_of_type_Daj = paramdaj;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    if (paramResources != null) {
      this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
    }
    int i = paramdaj.a.getDensity();
    int j = this.jdField_a_of_type_Int;
    if (i == j)
    {
      this.jdField_b_of_type_Int = paramdaj.a.getWidth();
      this.jdField_c_of_type_Int = paramdaj.a.getHeight();
      return;
    }
    this.jdField_b_of_type_Int = ImageUtil.a(paramdaj.a.getWidth(), i, j);
    this.jdField_c_of_type_Int = ImageUtil.a(paramdaj.a.getHeight(), i, j);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    invalidateSelf();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = paramCanvas.save();
    if (this.jdField_b_of_type_Boolean) {
      paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Daj.a.draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      return;
      this.jdField_a_of_type_Daj.b.draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Daj;
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getOpacity()
  {
    if ((this.jdField_a_of_type_Daj.a.hasAlpha()) || ((this.jdField_a_of_type_AndroidGraphicsPaint != null) && (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() < 255))) {
      return -3;
    }
    return -1;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = StateSet.stateSetMatches(jdField_a_of_type_ArrayOfInt, paramArrayOfInt);
    if (this.jdField_a_of_type_Boolean != bool)
    {
      this.jdField_a_of_type_Boolean = bool;
      Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      if (this.jdField_a_of_type_Boolean) {}
      for (paramArrayOfInt = jdField_a_of_type_AndroidGraphicsColorFilter;; paramArrayOfInt = null)
      {
        localPaint.setColorFilter(paramArrayOfInt);
        invalidateSelf();
        return true;
      }
    }
    return false;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.DecorationVipBubbleDrawable
 * JD-Core Version:    0.7.0.1
 */