package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

public class CustomHorizontalLoadingBar
  extends View
  implements Handler.Callback
{
  protected static final float a = 1000.0F;
  protected static final int a = 50;
  protected static final int b = 2000;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private float b;
  
  public CustomHorizontalLoadingBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CustomHorizontalLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public CustomHorizontalLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130839309);
    this.b = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((getVisibility() == 0) && (paramMessage.what == 0))
    {
      if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) {
        break label51;
      }
      this.b = 0.0F;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, 1000, 0, 2000);
    }
    for (;;)
    {
      postInvalidate();
      return true;
      label51:
      this.b = (this.jdField_a_of_type_AndroidWidgetScroller.getCurrX() / 1000.0F);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k;
    int i;
    int j;
    int m;
    float f2;
    float f1;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      k = getHeight();
      i = getWidth();
      j = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      m = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      f2 = (i + j) * this.b;
      if (f2 > j) {
        break label139;
      }
      i = (int)(j - f2);
      f1 = 0.0F;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(i, 0, j, m);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f1, 0.0F, f2, k);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 50L);
      }
      return;
      label139:
      if (f2 >= i)
      {
        j = (int)(f2 - i);
        f1 = i - j;
        f2 = i;
        i = 0;
      }
      else
      {
        f1 = f2 - j;
        i = 0;
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (getVisibility() != paramInt)
    {
      if (paramInt != 0) {
        break label65;
      }
      this.b = 0.0F;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, 1000, 0, 2000);
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      }
      postInvalidate();
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      label65:
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.CustomHorizontalLoadingBar
 * JD-Core Version:    0.7.0.1
 */