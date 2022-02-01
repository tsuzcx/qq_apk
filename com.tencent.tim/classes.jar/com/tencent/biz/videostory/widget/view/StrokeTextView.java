package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class StrokeTextView
  extends TextView
{
  private TextView AU;
  
  public StrokeTextView(Context paramContext)
  {
    super(paramContext);
    this.AU = new TextView(paramContext);
    init();
  }
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.AU = new TextView(paramContext, paramAttributeSet);
    init();
  }
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.AU = new TextView(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public void init()
  {
    TextPaint localTextPaint = this.AU.getPaint();
    localTextPaint.setStrokeWidth(3.0F);
    localTextPaint.setStyle(Paint.Style.STROKE);
    this.AU.setTextColor(Color.parseColor("#000000"));
    this.AU.setGravity(getGravity());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.AU.draw(paramCanvas);
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.AU.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    CharSequence localCharSequence = this.AU.getText();
    if ((localCharSequence == null) || (!localCharSequence.equals(getText())))
    {
      this.AU.setText(getText());
      postInvalidate();
    }
    this.AU.measure(paramInt1, paramInt2);
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setLayoutParams(paramLayoutParams);
    this.AU.setLayoutParams(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.StrokeTextView
 * JD-Core Version:    0.7.0.1
 */