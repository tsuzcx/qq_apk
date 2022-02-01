package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import atau.a;

public class LargeTouchAreaButton
  extends Button
{
  private int egA = -1;
  private int egB = -1;
  private final int egC = 0;
  private int egD;
  private int egE;
  private int egF;
  private int egG;
  private int egy = -1;
  private int egz = -1;
  
  public LargeTouchAreaButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public LargeTouchAreaButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public LargeTouchAreaButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qU);
    int i = (int)paramContext.getDimension(0, 0.0F);
    this.egD = i;
    this.egE = i;
    this.egF = i;
    this.egG = i;
    this.egD = ((int)paramContext.getDimension(1, this.egD));
    this.egE = ((int)paramContext.getDimension(2, this.egE));
    this.egF = ((int)paramContext.getDimension(3, this.egF));
    this.egG = ((int)paramContext.getDimension(4, this.egG));
    paramContext.recycle();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.egy) || (paramInt2 != this.egB) || (paramInt3 != this.egz) || (paramInt4 != this.egA))
    {
      this.egy = paramInt1;
      this.egB = paramInt2;
      this.egz = paramInt3;
      this.egA = paramInt4;
      ((View)getParent()).setTouchDelegate(new TouchDelegate(new Rect(paramInt1 - this.egE, paramInt2 - this.egG, this.egF + paramInt3, this.egD + paramInt4), this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.LargeTouchAreaButton
 * JD-Core Version:    0.7.0.1
 */