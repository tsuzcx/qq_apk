package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import aqnm;
import java.lang.reflect.Array;

public class MiniGamePublicAccountViewPagerIndicator
  extends LinearLayout
  implements ViewPager.OnPageChangeListener
{
  public ViewPager mViewPager;
  
  public MiniGamePublicAccountViewPagerIndicator(Context paramContext)
  {
    super(paramContext);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public MiniGamePublicAccountViewPagerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public ViewPager getViewPager()
  {
    return this.mViewPager;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    IndicatorView localIndicatorView = (IndicatorView)getChildAt(paramInt1);
    if (localIndicatorView != null) {
      localIndicatorView.update(paramFloat);
    }
    if (paramInt1 < getChildCount() - 1) {
      ((IndicatorView)getChildAt(paramInt1 + 1)).update(1.0F - paramFloat);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.mViewPager == null) {}
    while ((this.mViewPager.getAdapter() == null) || (super.getChildCount() <= paramInt)) {
      return;
    }
    int i = 0;
    label28:
    IndicatorView localIndicatorView;
    if (i < super.getChildCount())
    {
      localIndicatorView = (IndicatorView)super.getChildAt(i);
      if (localIndicatorView != null) {
        if (i != paramInt) {
          break label71;
        }
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      localIndicatorView.setSelected(bool);
      i += 1;
      break label28;
      break;
    }
  }
  
  public void refreshIndicator()
  {
    if (this.mViewPager == null) {}
    Object localObject;
    do
    {
      return;
      localObject = this.mViewPager.getAdapter();
    } while (localObject == null);
    int k = ((PagerAdapter)localObject).getCount();
    if (k <= 1)
    {
      super.setVisibility(4);
      return;
    }
    super.setVisibility(0);
    super.removeAllViews();
    int j = this.mViewPager.getCurrentItem();
    int i = j;
    if (j >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      j = 0;
      while (j < k)
      {
        super.addView(new IndicatorView(getContext()));
        j += 1;
      }
      j = 0;
      label110:
      if (j < super.getChildCount())
      {
        localObject = (IndicatorView)super.getChildAt(j);
        if (localObject != null) {
          if (j != i) {
            break label155;
          }
        }
      }
      label155:
      for (boolean bool = true;; bool = false)
      {
        ((IndicatorView)localObject).setSelected(bool);
        j += 1;
        break label110;
        break;
      }
    }
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
    if (this.mViewPager != null) {
      this.mViewPager.setOnPageChangeListener(this);
    }
  }
  
  static class IndicatorView
    extends View
  {
    private static final int HEIGHT;
    private static final int NORMAL_COLOR = Color.parseColor("#D0D8F2");
    private static final int NORMAL_WIDTH = aqnm.dpToPx(14.0F);
    private static final int SELECTED_COLOR = Color.parseColor("#3857FF");
    private static final int SELECTED_WIDTH = aqnm.dpToPx(32.0F);
    private static final int SPACE;
    
    static
    {
      HEIGHT = aqnm.dpToPx(2.0F);
      SPACE = aqnm.dpToPx(2.5F);
    }
    
    public IndicatorView(Context paramContext)
    {
      super();
      init(paramContext);
    }
    
    public IndicatorView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      init(paramContext);
    }
    
    public IndicatorView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      init(paramContext);
    }
    
    private int getCurrentColor(float paramFloat)
    {
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, 3 });
      arrayOfInt[0][0] = ((SELECTED_COLOR & 0xFF0000) >> 16);
      arrayOfInt[0][1] = ((SELECTED_COLOR & 0xFF00) >> 8);
      arrayOfInt[0][2] = (SELECTED_COLOR & 0xFF);
      arrayOfInt[1][0] = ((NORMAL_COLOR & 0xFF0000) >> 16);
      arrayOfInt[1][1] = ((NORMAL_COLOR & 0xFF00) >> 8);
      arrayOfInt[1][2] = (NORMAL_COLOR & 0xFF);
      int[] arrayOfInt1 = new int[3];
      int i = 0;
      while (i < 3)
      {
        arrayOfInt1[i] = ((int)(arrayOfInt[0][i] + (arrayOfInt[1][i] - arrayOfInt[0][i]) * paramFloat));
        i += 1;
      }
      return Color.rgb(arrayOfInt1[0], arrayOfInt1[1], arrayOfInt1[2]);
    }
    
    private void init(Context paramContext)
    {
      paramContext = new LinearLayout.LayoutParams(NORMAL_WIDTH, HEIGHT);
      paramContext.gravity = 17;
      paramContext.leftMargin = SPACE;
      paramContext.rightMargin = SPACE;
      setLayoutParams(paramContext);
      setClickable(false);
      setFocusable(false);
    }
    
    public void setSelected(boolean paramBoolean)
    {
      ViewGroup.LayoutParams localLayoutParams;
      if (paramBoolean)
      {
        i = SELECTED_COLOR;
        setBackgroundColor(i);
        localLayoutParams = getLayoutParams();
        if (!paramBoolean) {
          break label44;
        }
      }
      label44:
      for (int i = SELECTED_WIDTH;; i = NORMAL_WIDTH)
      {
        localLayoutParams.width = i;
        setLayoutParams(localLayoutParams);
        return;
        i = NORMAL_COLOR;
        break;
      }
    }
    
    public void update(float paramFloat)
    {
      setBackgroundColor(getCurrentColor(paramFloat));
      int i = (int)(SELECTED_WIDTH + (NORMAL_WIDTH - SELECTED_WIDTH) * paramFloat);
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.width = i;
      setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountViewPagerIndicator
 * JD-Core Version:    0.7.0.1
 */