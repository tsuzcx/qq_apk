package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;

public class LabelContainer
  extends FrameLayout
{
  protected SparseArray<ArrayList<View>> dc = new SparseArray();
  protected int dmi;
  protected int dmj;
  
  public LabelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LabelContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.dc.size();
    paramInt1 = 0;
    paramInt2 = 0;
    if (paramInt2 < j)
    {
      ArrayList localArrayList = (ArrayList)this.dc.get(paramInt2);
      if (localArrayList == null) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        int k = localArrayList.size();
        paramInt4 = 0;
        paramInt3 = 0;
        int i = 0;
        while (paramInt3 < k)
        {
          View localView = (View)localArrayList.get(paramInt3);
          i = localView.getMeasuredHeight();
          int m = localView.getMeasuredWidth();
          localView.layout(paramInt4, paramInt1, paramInt4 + m, paramInt1 + i);
          paramInt4 += this.dmi + m;
          paramInt3 += 1;
        }
        paramInt1 = this.dmj + i + paramInt1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.dc.clear();
    int m = getMeasuredWidth();
    int n = getChildCount();
    int j = 0;
    int i = 0;
    paramInt2 = 0;
    paramInt1 = 0;
    if (j < n)
    {
      View localView = getChildAt(j);
      int k = localView.getMeasuredWidth() + this.dmi;
      if (i + k <= m)
      {
        k += i;
        i = paramInt2;
      }
      for (paramInt2 = k;; paramInt2 = k)
      {
        ArrayList localArrayList2 = (ArrayList)this.dc.get(i);
        ArrayList localArrayList1 = localArrayList2;
        k = paramInt1;
        if (localArrayList2 == null)
        {
          localArrayList1 = new ArrayList();
          this.dc.append(i, localArrayList1);
          k = paramInt1 + (localView.getMeasuredHeight() + this.dmj);
        }
        localArrayList1.add(localView);
        j += 1;
        paramInt1 = paramInt2;
        paramInt2 = i;
        i = paramInt1;
        paramInt1 = k;
        break;
        i = paramInt2 + 1;
      }
    }
    paramInt2 = paramInt1;
    if (paramInt1 > this.dmj) {
      paramInt2 = paramInt1 - this.dmj;
    }
    setMeasuredDimension(m, paramInt2);
  }
  
  public void setSpace(int paramInt1, int paramInt2)
  {
    this.dmi = paramInt1;
    this.dmj = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.LabelContainer
 * JD-Core Version:    0.7.0.1
 */