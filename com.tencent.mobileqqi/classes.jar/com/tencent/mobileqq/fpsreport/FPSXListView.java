package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.widget.XListView;

public class FPSXListView
  extends XListView
{
  private FPSCalculator a;
  
  public FPSXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FPSXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public FPSXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.a = new FPSCalculator();
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSXListView
 * JD-Core Version:    0.7.0.1
 */