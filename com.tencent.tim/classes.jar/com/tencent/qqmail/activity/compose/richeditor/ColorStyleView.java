package com.tencent.qqmail.activity.compose.richeditor;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.annotation.Nullable;
import com.tencent.androidqqmail.R.styleable;

public class ColorStyleView
  extends View
{
  private static final int DEFAULT_COLOR_THEME = -16716288;
  private int color;
  private int innerRadius;
  private int outterRadius;
  private Paint paint;
  private boolean pressed = false;
  private boolean selected = false;
  private int stroke = 4;
  
  public ColorStyleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorStyleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ColorStyleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.paint = new Paint();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ColorCircle);
    this.color = paramContext.getColor(R.styleable.ColorCircle_themeColor, -16716288);
    paramContext.recycle();
    this.paint.setColor(this.color);
    this.paint.setAntiAlias(true);
  }
  
  private int measureDimension(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824) {
      paramInt2 = i;
    }
    do
    {
      return paramInt2;
      paramInt2 = paramInt1;
    } while (j != -2147483648);
    return Math.min(paramInt1, i);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.paint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, this.innerRadius, this.paint);
    if ((this.selected) || (this.pressed))
    {
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setStrokeWidth(this.stroke);
      paramCanvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, this.outterRadius, this.paint);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = measureDimension(200, paramInt1);
    paramInt2 = measureDimension(200, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
    this.outterRadius = (Math.min(paramInt1, paramInt2) / 2 - this.stroke);
    this.innerRadius = (this.outterRadius - 6);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.pressed = true;
      invalidate();
      return true;
    }
    if ((i == 1) || (i == 3))
    {
      this.pressed = false;
      invalidate();
      performClick();
      return false;
    }
    return false;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.selected = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.richeditor.ColorStyleView
 * JD-Core Version:    0.7.0.1
 */