package com.tencent.token.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import java.lang.reflect.Field;

public class LineGridView
  extends GridView
{
  private int a = 0;
  private Paint b = new Paint();
  private float c = 1.5F;
  private int d = 3;
  
  public LineGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LineGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(-1842205);
    this.c = 1.5F;
    this.b.setStrokeWidth(this.c);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    try
    {
      Field localField = GridView.class.getDeclaredField("mNumColumns");
      localField.setAccessible(true);
      this.d = localField.getInt(this);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    this.a = getChildCount();
    int i = 0;
    while (i < this.a)
    {
      View localView = getChildAt(i);
      paramCanvas.drawLine(localView.getLeft(), localView.getTop() + this.c / 2.0F, localView.getRight(), localView.getTop() + this.c / 2.0F, this.b);
      int j = this.d;
      int k = this.a;
      if (i + j > k)
      {
        paramCanvas.drawLine(localView.getLeft(), localView.getBottom() - this.c / 2.0F, localView.getRight(), localView.getBottom() - this.c / 2.0F, this.b);
        if (i + 1 == this.a) {
          paramCanvas.drawLine(localView.getRight(), localView.getBottom() - this.c / 2.0F, localView.getRight() + (localView.getRight() - localView.getLeft()), localView.getBottom() - this.c / 2.0F, this.b);
        }
      }
      else if (i + j == k)
      {
        if (k % j == 0) {
          paramCanvas.drawLine(localView.getLeft(), localView.getBottom() - this.c / 2.0F, localView.getRight(), localView.getBottom() - this.c / 2.0F, this.b);
        } else {
          paramCanvas.drawLine(localView.getLeft(), localView.getBottom() + this.c / 2.0F, localView.getRight(), localView.getBottom() + this.c / 2.0F, this.b);
        }
      }
      if (i % this.d != 0) {
        paramCanvas.drawLine(localView.getLeft(), localView.getTop(), localView.getLeft(), localView.getBottom(), this.b);
      }
      j = this.a;
      if ((j % this.d != 0) && (i + 1 == j)) {
        paramCanvas.drawLine(localView.getRight(), localView.getTop(), localView.getRight(), localView.getBottom(), this.b);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LineGridView
 * JD-Core Version:    0.7.0.1
 */