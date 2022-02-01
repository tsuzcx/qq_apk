package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.RelativeLayoutHelper;
import java.util.Iterator;
import java.util.List;

public class RelativeLayout
  extends Layout
{
  private static final String TAG = "RelativeLayout_TMTEST";
  private RelativeLayoutHelper relativeLayoutHelper = new RelativeLayoutHelper();
  private List<ViewBase> sortedHorizontalView;
  private List<ViewBase> sortedVerticalView;
  
  public RelativeLayout(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  private int getMaxHeight()
  {
    Iterator localIterator = this.mSubViews.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.isGone())
      {
        Params localParams = (Params)localViewBase.getComLayoutParams();
        int j = localParams.mTop;
        j = localViewBase.getComMeasuredHeight() + j + localParams.mLayoutMarginBottom;
        if (j <= i) {
          break label94;
        }
        i = j;
      }
    }
    label94:
    for (;;)
    {
      break;
      return this.mPaddingBottom + (this.mBorderWidth << 1) + i;
    }
  }
  
  private int getMaxWidth()
  {
    Iterator localIterator = this.mSubViews.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.isGone())
      {
        Params localParams = (Params)localViewBase.getComLayoutParams();
        int j = localParams.mLeft;
        j = localViewBase.getComMeasuredWidth() + j + localParams.mLayoutMarginRight;
        if (j <= i) {
          break label94;
        }
        i = j;
      }
    }
    label94:
    for (;;)
    {
      break;
      return this.mPaddingRight + (this.mBorderWidth << 1) + i;
    }
  }
  
  private int getRealHeight(int paramInt1, int paramInt2)
  {
    if (-2147483648 == paramInt1) {
      paramInt2 = getMaxHeight();
    }
    while (1073741824 == paramInt1) {
      return paramInt2;
    }
    return getMaxHeight();
  }
  
  private int getRealWidth(int paramInt1, int paramInt2)
  {
    if (-2147483648 == paramInt1) {
      paramInt2 = getMaxWidth();
    }
    while (1073741824 == paramInt1) {
      return paramInt2;
    }
    return getMaxWidth();
  }
  
  private List<ViewBase> sortHorizontal()
  {
    if ((this.sortedHorizontalView == null) || (this.sortedHorizontalView.size() != this.mSubViews.size()))
    {
      if (this.relativeLayoutHelper.getParent() == null) {
        this.relativeLayoutHelper.setParent(this);
      }
      this.sortedHorizontalView = this.relativeLayoutHelper.getHorizontalSortedView();
    }
    return this.sortedHorizontalView;
  }
  
  private List<ViewBase> sortVertical()
  {
    if ((this.sortedVerticalView == null) || (this.sortedVerticalView.size() != this.mSubViews.size()))
    {
      if (this.relativeLayoutHelper.getParent() == null) {
        this.relativeLayoutHelper.setParent(this);
      }
      this.sortedVerticalView = this.relativeLayoutHelper.getVerticalSortedView();
    }
    return this.sortedVerticalView;
  }
  
  public Params generateParams()
  {
    return new Params();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.mSubViews.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.isGone())
      {
        Params localParams = (Params)localViewBase.getComLayoutParams();
        localViewBase.comLayout(localParams.mLeft + paramInt1, localParams.mTop + paramInt2, localParams.mRight + paramInt1, localParams.mBottom + paramInt2);
      }
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (k != 0) {}
    for (;;)
    {
      if (m != 0) {}
      for (;;)
      {
        List localList = sortHorizontal();
        int n = localList.size();
        boolean bool1;
        boolean bool2;
        label67:
        label70:
        ViewBase localViewBase;
        int i;
        Params localParams;
        if (k != 1073741824)
        {
          bool1 = true;
          if (m == 1073741824) {
            break label198;
          }
          bool2 = true;
          j = 0;
          if (j >= n) {
            break label207;
          }
          localViewBase = (ViewBase)localList.get(j);
          i = paramInt1;
          if (localViewBase.getVisibility() != 8)
          {
            localParams = (Params)localViewBase.getComLayoutParams();
            this.relativeLayoutHelper.applyHorizontalSizeRules(localParams, paramInt1);
            i = paramInt1;
            if (bool1)
            {
              i = paramInt1;
              if (localParams.mLayoutWidth == -1)
              {
                i = getMaxWidth();
                if (i <= 0) {
                  break label204;
                }
                paramInt1 = i;
              }
            }
          }
        }
        label198:
        label204:
        for (;;)
        {
          i = paramInt1;
          this.relativeLayoutHelper.measureChildHorizontal(localViewBase, localParams, i, paramInt2);
          this.relativeLayoutHelper.positionChildHorizontal(localViewBase, localParams, i, bool1);
          j += 1;
          paramInt1 = i;
          break label70;
          bool1 = false;
          break;
          bool2 = false;
          break label67;
        }
        label207:
        localList = sortVertical();
        int j = 0;
        if (j < n)
        {
          localViewBase = (ViewBase)localList.get(j);
          i = paramInt2;
          if (localViewBase.getVisibility() != 8)
          {
            localParams = (Params)localViewBase.getComLayoutParams();
            this.relativeLayoutHelper.applyVerticalSizeRules(localParams, paramInt2);
            i = paramInt2;
            if (bool2) {
              if (localParams.mLayoutHeight != -1)
              {
                i = paramInt2;
                if (!RelativeLayoutHelper.hasVerticleCenterRule(localParams)) {}
              }
              else
              {
                i = getMaxHeight();
                if (i <= 0) {
                  break label347;
                }
                paramInt2 = i;
              }
            }
          }
          label347:
          for (;;)
          {
            i = paramInt2;
            this.relativeLayoutHelper.measureChild(localViewBase, localParams, paramInt1, i);
            this.relativeLayoutHelper.positionChildVertical(localViewBase, localParams, i, bool2);
            j += 1;
            paramInt2 = i;
            break;
          }
        }
        setComMeasuredDimension(getRealWidth(k, paramInt1), getRealHeight(m, paramInt2));
        return;
        paramInt2 = -1;
      }
      paramInt1 = -1;
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool = super.setAttribute(paramInt, paramString);
    if (!bool) {}
    return bool;
  }
  
  public static class Builder
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new RelativeLayout(paramVafContext);
    }
  }
  
  public static class Params
    extends Layout.Params
  {
    public static final int ABOVE_OF = 0;
    public static final int ALIGN_PARENT_BOTTOM = 7;
    public static final int ALIGN_PARENT_CENTER = 10;
    public static final int ALIGN_PARENT_CENTER_HORIZONTAL = 9;
    public static final int ALIGN_PARENT_CENTER_VERTICAL = 8;
    public static final int ALIGN_PARENT_LEFT = 4;
    public static final int ALIGN_PARENT_RIGHT = 5;
    public static final int ALIGN_PARENT_TOP = 6;
    public static final int BELOW_OF = 1;
    public static final int LEFT_OF = 2;
    public static final int RIGHT_OF = 3;
    public static final int[] RULES_HORIZONTAL = { 2, 3 };
    public static final int[] RULES_VERTICAL = { 0, 1 };
    public static final int RULE_COUNT = 11;
    public boolean alignWithParent;
    public int mBottom;
    public int mLeft;
    public int mRight;
    public int mTop;
    private String[] rule = new String[11];
    
    public String[] getRule()
    {
      return this.rule;
    }
    
    public boolean setAttribute(int paramInt, String paramString)
    {
      boolean bool = super.setAttribute(paramInt, paramString);
      if (bool) {
        return bool;
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        return false;
        setRule(3, paramString);
        continue;
        setRule(2, paramString);
        continue;
        setRule(1, paramString);
        continue;
        setRule(0, paramString);
        continue;
        setRule(4, paramString);
        continue;
        setRule(5, paramString);
        continue;
        setRule(6, paramString);
        continue;
        setRule(7, paramString);
        continue;
        setRule(8, paramString);
        continue;
        setRule(9, paramString);
        continue;
        setRule(10, paramString);
      }
    }
    
    public void setRule(int paramInt, String paramString)
    {
      this.rule[paramInt] = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout
 * JD-Core Version:    0.7.0.1
 */