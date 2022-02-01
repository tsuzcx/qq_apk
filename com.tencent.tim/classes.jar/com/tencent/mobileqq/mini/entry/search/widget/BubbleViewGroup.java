package com.tencent.mobileqq.mini.entry.search.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import aqnm;
import java.util.ArrayList;
import java.util.List;

public class BubbleViewGroup
  extends ViewGroup
{
  public static final int HORIZONTAL_SPACE = aqnm.dpToPx(12.0F);
  public static final int MAX_ROW = 3;
  public static final int VERTICAL_SPACE = HORIZONTAL_SPACE;
  private List<WarpLine> mRowLayoutList;
  
  public BubbleViewGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getGravity()
  {
    return 1;
  }
  
  public boolean isFull()
  {
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getPaddingTop();
    paramInt3 = 0;
    while (paramInt3 < this.mRowLayoutList.size())
    {
      paramInt1 = getPaddingLeft();
      WarpLine localWarpLine = (WarpLine)this.mRowLayoutList.get(paramInt3);
      int i = getMeasuredWidth() - localWarpLine.lineWidth;
      paramInt4 = 0;
      while (paramInt4 < localWarpLine.bubbleViews.size())
      {
        View localView = (View)localWarpLine.bubbleViews.get(paramInt4);
        if (isFull())
        {
          localView.layout(paramInt1, paramInt2, localView.getMeasuredWidth() + paramInt1 + i / localWarpLine.bubbleViews.size(), localView.getMeasuredHeight() + paramInt2);
          paramInt1 += localView.getMeasuredWidth() + HORIZONTAL_SPACE + i / localWarpLine.bubbleViews.size();
          paramInt4 += 1;
        }
        else
        {
          switch (getGravity())
          {
          case 1: 
          default: 
            localView.layout(paramInt1, paramInt2, localView.getMeasuredWidth() + paramInt1, localView.getMeasuredHeight() + paramInt2);
          }
          for (;;)
          {
            paramInt1 += localView.getMeasuredWidth() + HORIZONTAL_SPACE;
            break;
            localView.layout(paramInt1 + i, paramInt2, paramInt1 + i + localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
            continue;
            localView.layout(i / 2 + paramInt1, paramInt2, i / 2 + paramInt1 + localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
          }
        }
      }
      paramInt1 = localWarpLine.height;
      paramInt4 = VERTICAL_SPACE;
      paramInt3 += 1;
      paramInt2 += paramInt1 + paramInt4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    int k = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    int i1 = getChildCount();
    measureChildren(paramInt1, paramInt2);
    paramInt2 = i;
    WarpLine localWarpLine;
    switch (k)
    {
    default: 
      paramInt2 = i;
    case 1073741824: 
      localWarpLine = new WarpLine(null);
      this.mRowLayoutList = new ArrayList();
      paramInt1 = 0;
      if ((paramInt1 >= i1) || (this.mRowLayoutList.size() >= 3))
      {
        if ((localWarpLine.bubbleViews.size() > 0) && (!this.mRowLayoutList.contains(localWarpLine)) && (this.mRowLayoutList.size() < 2)) {
          this.mRowLayoutList.add(localWarpLine);
        }
        paramInt1 = getPaddingTop() + getPaddingBottom();
        i = m;
        label186:
        if (i >= this.mRowLayoutList.size()) {
          break label491;
        }
        if (i == 0) {
          break label557;
        }
        paramInt1 += VERTICAL_SPACE;
      }
      break;
    }
    label557:
    for (;;)
    {
      k = ((WarpLine)this.mRowLayoutList.get(i)).height;
      i += 1;
      paramInt1 += k;
      break label186;
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt2 < i1)
      {
        k = paramInt1;
        if (paramInt2 != 0) {
          k = paramInt1 + HORIZONTAL_SPACE;
        }
        paramInt1 = getChildAt(paramInt2).getMeasuredWidth();
        paramInt2 += 1;
        paramInt1 += k;
      }
      paramInt2 = paramInt1 + (getPaddingLeft() + getPaddingRight());
      paramInt1 = paramInt2;
      if (paramInt2 > i) {
        paramInt1 = i;
      }
      paramInt2 = paramInt1;
      break;
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt2 < i1)
      {
        i = paramInt1;
        if (paramInt2 != 0) {
          i = paramInt1 + HORIZONTAL_SPACE;
        }
        paramInt1 = getChildAt(paramInt2).getMeasuredWidth();
        paramInt2 += 1;
        paramInt1 += i;
      }
      paramInt2 = getPaddingLeft() + getPaddingRight() + paramInt1;
      break;
      if (localWarpLine.lineWidth + getChildAt(paramInt1).getMeasuredWidth() + HORIZONTAL_SPACE > paramInt2) {
        if (localWarpLine.bubbleViews.size() == 0)
        {
          localWarpLine.addView(getChildAt(paramInt1));
          this.mRowLayoutList.add(localWarpLine);
          localWarpLine = new WarpLine(null);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.mRowLayoutList.add(localWarpLine);
        localWarpLine = new WarpLine(null);
        localWarpLine.addView(getChildAt(paramInt1));
        continue;
        localWarpLine.addView(getChildAt(paramInt1));
      }
      label491:
      i = paramInt1;
      switch (n)
      {
      default: 
        i = paramInt1;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt2, i);
        return;
        i = j;
        continue;
        i = paramInt1;
        if (paramInt1 > j) {
          i = j;
        }
      }
    }
  }
  
  static class Gravity
  {
    public static final int CENTER = 2;
    public static final int LEFT = 1;
    public static final int RIGHT = 0;
  }
  
  class WarpLine
  {
    private List<View> bubbleViews = new ArrayList();
    private int height;
    private int lineWidth = BubbleViewGroup.this.getPaddingLeft() + BubbleViewGroup.this.getPaddingRight();
    
    private WarpLine() {}
    
    private void addView(View paramView)
    {
      if (this.bubbleViews.size() != 0) {
        this.lineWidth += BubbleViewGroup.HORIZONTAL_SPACE;
      }
      if (this.height > paramView.getMeasuredHeight()) {}
      for (int i = this.height;; i = paramView.getMeasuredHeight())
      {
        this.height = i;
        this.lineWidth += paramView.getMeasuredWidth();
        this.bubbleViews.add(paramView);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.widget.BubbleViewGroup
 * JD-Core Version:    0.7.0.1
 */