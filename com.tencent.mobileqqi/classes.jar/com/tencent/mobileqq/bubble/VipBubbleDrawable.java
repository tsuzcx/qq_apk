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
import flc;

public class VipBubbleDrawable
  extends Drawable
{
  private static final ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -26.0F, 0.0F, 1.0F, 0.0F, 0.0F, -26.0F, 0.0F, 0.0F, 1.0F, 0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  private static int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private int jdField_a_of_type_Int = 160;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private flc jdField_a_of_type_Flc;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public VipBubbleDrawable(Resources paramResources, Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    this(paramResources, new flc(new NinePatch(paramBitmap, paramArrayOfByte, null)));
  }
  
  public VipBubbleDrawable(Resources paramResources, flc paramflc)
  {
    this.jdField_a_of_type_Flc = paramflc;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    if (paramResources != null) {
      this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
    }
    int i = paramflc.a.getDensity();
    int j = this.jdField_a_of_type_Int;
    if (i == j)
    {
      this.jdField_b_of_type_Int = paramflc.a.getWidth();
      this.c = paramflc.a.getHeight();
      return;
    }
    this.jdField_b_of_type_Int = ImageUtil.a(paramflc.a.getWidth(), i, j);
    this.c = ImageUtil.a(paramflc.a.getHeight(), i, j);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
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
    this.jdField_a_of_type_Flc.a.draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Flc;
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getOpacity()
  {
    if ((this.jdField_a_of_type_Flc.a.hasAlpha()) || ((this.jdField_a_of_type_AndroidGraphicsPaint != null) && (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() < 255))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.VipBubbleDrawable
 * JD-Core Version:    0.7.0.1
 */