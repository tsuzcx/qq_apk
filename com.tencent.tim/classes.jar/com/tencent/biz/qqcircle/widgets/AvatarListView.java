package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import aqdj;
import atau.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.List;
import ous;

public class AvatarListView
  extends ViewGroup
{
  private boolean azE;
  private int bhU;
  private int bhV;
  private int bhW;
  private float lS;
  private int mIconHeight;
  private int mIconWidth;
  
  public AvatarListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AvatarListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet);
  }
  
  private void av(String paramString, boolean paramBoolean)
  {
    SquareImageView localSquareImageView = new SquareImageView(getContext());
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(this.mIconWidth, this.mIconHeight);
    if ((this.bhV != -1) && (this.bhW != 0))
    {
      localSquareImageView.setPadding(this.bhW, this.bhW, this.bhW, this.bhW);
      localSquareImageView.setCircleBgColor(this.bhV);
    }
    localSquareImageView.setLayoutParams(localLayoutParams);
    localSquareImageView.setRoundRect(this.bhU);
    if (paramBoolean) {
      ous.b(paramString, localSquareImageView);
    }
    for (;;)
    {
      addView(localSquareImageView);
      return;
      localSquareImageView.setImageDrawable(aqdj.a(((BaseActivity)getContext()).app, 1, 4, paramString));
    }
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.AvatarListView);
    if (paramContext != null)
    {
      this.bhU = paramContext.getInteger(1, 90);
      this.lS = paramContext.getFloat(10, 0.8F);
      this.mIconWidth = ((int)paramContext.getDimension(2, 30.0F));
      this.mIconHeight = ((int)paramContext.getDimension(0, 30.0F));
      this.azE = paramContext.getBoolean(9, false);
      this.bhV = paramContext.getColor(7, -1);
      this.bhW = ((int)paramContext.getDimension(8, 0.0F));
      paramContext.recycle();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    View localView;
    int j;
    if (this.azE)
    {
      paramInt4 = paramInt3 - paramInt1;
      paramInt3 -= paramInt1;
      paramInt2 = i - 1;
      paramInt1 = paramInt4;
      if (paramInt2 >= 0)
      {
        localView = getChildAt(i - 1 - paramInt2);
        paramInt4 = localView.getMeasuredWidth();
        j = localView.getMeasuredHeight();
        if (paramInt2 == i - 1) {
          paramInt1 -= paramInt4;
        }
        for (;;)
        {
          localView.layout(paramInt1, 0, paramInt3, j);
          paramInt3 = (int)(paramInt3 - paramInt4 * this.lS);
          paramInt2 -= 1;
          break;
          paramInt1 = (int)(paramInt1 - paramInt4 * this.lS);
        }
      }
    }
    else
    {
      paramInt3 = 0;
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramInt2 < i)
      {
        localView = getChildAt(paramInt2);
        paramInt4 = localView.getMeasuredWidth();
        j = localView.getMeasuredHeight();
        if (paramInt2 == 0) {
          paramInt1 += paramInt4;
        }
        for (;;)
        {
          localView.layout(paramInt3, 0, paramInt1, j);
          paramInt3 = (int)(paramInt3 + paramInt4 * this.lS);
          paramInt2 += 1;
          break;
          paramInt1 = (int)(paramInt1 + paramInt4 * this.lS);
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i3 = getChildCount();
    int k = 0;
    int i = 0;
    if (k < i3)
    {
      View localView = getChildAt(k);
      measureChild(localView, paramInt1, paramInt2);
      int i5 = localView.getMeasuredWidth();
      int i4 = localView.getMeasuredHeight();
      if (k == 0) {
        j += i5;
      }
      for (;;)
      {
        i = Math.max(i, i4);
        k += 1;
        break;
        j = (int)(j + i5 * this.lS);
      }
    }
    if (i2 == 1073741824)
    {
      paramInt1 = n;
      if (i1 != 1073741824) {
        break label160;
      }
    }
    label160:
    for (paramInt2 = m;; paramInt2 = i)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = j;
      break;
    }
  }
  
  public void setData(List<String> paramList)
  {
    setData(paramList, false);
  }
  
  public void setData(List<String> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      setVisibility(8);
    }
    for (;;)
    {
      return;
      setVisibility(0);
      removeAllViews();
      int j = paramList.size();
      int i;
      if (this.azE)
      {
        i = j - 1;
        while (i >= 0)
        {
          av((String)paramList.get(i), paramBoolean);
          i -= 1;
        }
      }
      else
      {
        i = 0;
        while (i < j)
        {
          av((String)paramList.get(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.AvatarListView
 * JD-Core Version:    0.7.0.1
 */