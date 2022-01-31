package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

public class CardView
  extends RelativeLayout
{
  public static final int a = 63;
  protected static final float c = 680.0F;
  protected static final float d = 307.0F;
  protected final int b;
  protected final int c;
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    new DisplayMetrics();
    paramContext = super.getResources().getDisplayMetrics();
    this.b = paramContext.widthPixels;
    this.c = paramContext.heightPixels;
  }
  
  protected float a()
  {
    return 2.214984F;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    while (paramInt1 < super.getChildCount())
    {
      View localView = super.getChildAt(paramInt1);
      paramInt2 = (getWidth() - localView.getWidth()) / 2;
      paramInt3 = (getHeight() - localView.getHeight()) / 2;
      localView.layout(paramInt2, paramInt3, localView.getWidth() + paramInt2, localView.getHeight() + paramInt3);
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = getContext().getResources().getDimension(2131493113);
    f1 = this.b - f1 * 2.0F;
    float f2 = f1 / a();
    super.setMeasuredDimension((int)f1, (int)f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.CardView
 * JD-Core Version:    0.7.0.1
 */