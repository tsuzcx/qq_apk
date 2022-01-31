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
  
  public LineGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
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
      Object localObject = GridView.class.getDeclaredField("mNumColumns");
      ((Field)localObject).setAccessible(true);
      this.d = ((Field)localObject).getInt(this);
      this.a = getChildCount();
      i = 0;
      for (;;)
      {
        if (i >= this.a) {
          return;
        }
        localObject = getChildAt(i);
        f1 = ((View)localObject).getLeft();
        f2 = ((View)localObject).getTop();
        f3 = this.c / 2.0F;
        f4 = ((View)localObject).getRight();
        f5 = ((View)localObject).getTop();
        paramCanvas.drawLine(f1, f3 + f2, f4, this.c / 2.0F + f5, this.b);
        if (this.d + i <= this.a) {
          break;
        }
        paramCanvas.drawLine(((View)localObject).getLeft(), ((View)localObject).getBottom() - this.c / 2.0F, ((View)localObject).getRight(), ((View)localObject).getBottom() - this.c / 2.0F, this.b);
        if (i + 1 == this.a) {
          paramCanvas.drawLine(((View)localObject).getRight(), ((View)localObject).getBottom() - this.c / 2.0F, ((View)localObject).getRight() + (((View)localObject).getRight() - ((View)localObject).getLeft()), ((View)localObject).getBottom() - this.c / 2.0F, this.b);
        }
        if (i % this.d != 0) {
          paramCanvas.drawLine(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getLeft(), ((View)localObject).getBottom(), this.b);
        }
        if ((this.a % this.d != 0) && (i + 1 == this.a)) {
          paramCanvas.drawLine(((View)localObject).getRight(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom(), this.b);
        }
        i += 1;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        int i;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        localIllegalAccessException.printStackTrace();
        continue;
        if (this.d + i == this.a) {
          if (this.a % this.d == 0)
          {
            paramCanvas.drawLine(localIllegalAccessException.getLeft(), localIllegalAccessException.getBottom() - this.c / 2.0F, localIllegalAccessException.getRight(), localIllegalAccessException.getBottom() - this.c / 2.0F, this.b);
          }
          else
          {
            f1 = localIllegalAccessException.getLeft();
            f2 = localIllegalAccessException.getBottom();
            f3 = this.c / 2.0F;
            f4 = localIllegalAccessException.getRight();
            f5 = localIllegalAccessException.getBottom();
            paramCanvas.drawLine(f1, f3 + f2, f4, this.c / 2.0F + f5, this.b);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LineGridView
 * JD-Core Version:    0.7.0.1
 */