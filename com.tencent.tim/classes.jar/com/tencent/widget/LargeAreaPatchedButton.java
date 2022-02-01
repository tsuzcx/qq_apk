package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import atau.a;

public class LargeAreaPatchedButton
  extends PatchedButton
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
  private int etO;
  
  public LargeAreaPatchedButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public LargeAreaPatchedButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public LargeAreaPatchedButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this.etO = 1;
    this.egD = ((int)paramContext.getDimension(1, this.egD));
    this.egE = ((int)paramContext.getDimension(2, this.egE));
    this.egF = ((int)paramContext.getDimension(3, this.egF));
    this.egG = ((int)paramContext.getDimension(4, this.egG));
    this.etO = paramContext.getInt(5, this.etO);
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
      TouchDelegate localTouchDelegate = new TouchDelegate(new Rect(paramInt1 - this.egE, paramInt2 - this.egG, this.egF + paramInt3, this.egD + paramInt4), this);
      Object localObject1 = getParent();
      paramInt1 = 0;
      while (paramInt1 < this.etO)
      {
        Object localObject2 = localObject1;
        if ((localObject1 instanceof View))
        {
          ((View)localObject1).setTouchDelegate(localTouchDelegate);
          localObject2 = ((ViewParent)localObject1).getParent();
        }
        paramInt1 += 1;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.LargeAreaPatchedButton
 * JD-Core Version:    0.7.0.1
 */