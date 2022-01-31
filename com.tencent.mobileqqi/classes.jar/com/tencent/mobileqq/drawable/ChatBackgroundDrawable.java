package com.tencent.mobileqq.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

public class ChatBackgroundDrawable
  extends BitmapDrawable
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(2);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  
  public ChatBackgroundDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  protected Rect a(Rect paramRect)
  {
    int i = getBitmap().getHeight();
    int j = getBitmap().getWidth();
    float f1 = paramRect.height() / paramRect.width();
    float f2 = i / j;
    if (((paramRect.width() >= j) && (paramRect.height() >= i)) || (f1 >= f2)) {
      return new Rect(0, 0, j, i);
    }
    int k = paramRect.height() * j / paramRect.width();
    return new Rect(0, (i - k) / 2, j, (i + k) / 2);
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = a(getBounds());
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.drawable.ChatBackgroundDrawable
 * JD-Core Version:    0.7.0.1
 */