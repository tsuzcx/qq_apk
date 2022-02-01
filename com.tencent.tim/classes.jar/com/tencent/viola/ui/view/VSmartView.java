package com.tencent.viola.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.ArrayList;
import java.util.List;

public class VSmartView
  extends VFrameLayout
  implements View.OnTouchListener
{
  private float offset = 0.0F;
  private List<RecyclerViewWrapper> recyclerViews = new ArrayList();
  private RvScrollListener scrollListener = new RvScrollListener(null);
  private VSmartHeaderView smartHeaderView;
  private VPageSliderView.VPagerSliderScrollListener vPagerSliderScrollListener = new VSmartView.1(this);
  private VPageSliderView viewPager;
  
  public VSmartView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private float getTranslationYLimit()
  {
    if (this.smartHeaderView == null) {
      return 0.0F;
    }
    return this.smartHeaderView.getHeight() - this.offset;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void addRecyclerView(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    if (paramRecyclerView == null) {
      return;
    }
    RecyclerViewWrapper localRecyclerViewWrapper = new RecyclerViewWrapper(null);
    localRecyclerViewWrapper.recyclerView = paramRecyclerView;
    localRecyclerViewWrapper.ignoreScrollEvent = paramBoolean;
    paramRecyclerView.setOnTouchListener(this);
    paramRecyclerView.setOnScrollListener(this.scrollListener);
    paramRecyclerView.setTag(localRecyclerViewWrapper);
    this.recyclerViews.add(localRecyclerViewWrapper);
  }
  
  public void destroy()
  {
    if (this.viewPager != null) {
      this.viewPager.removeScrollListener(this.vPagerSliderScrollListener);
    }
    this.recyclerViews.clear();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof RecyclerViewWrapper)) {
      ((RecyclerViewWrapper)paramView).ignoreScrollEvent = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOffset(float paramFloat)
  {
    this.offset = paramFloat;
  }
  
  public void setSmartHeaderView(VSmartHeaderView paramVSmartHeaderView)
  {
    this.smartHeaderView = paramVSmartHeaderView;
  }
  
  public void setViewPager(VPageSliderView paramVPageSliderView)
  {
    if (paramVPageSliderView == null) {
      return;
    }
    this.viewPager = paramVPageSliderView;
    paramVPageSliderView.setOverScrollMode(2);
    paramVPageSliderView.addScrollListener(this.vPagerSliderScrollListener);
  }
  
  static class RecyclerViewWrapper
  {
    boolean ignoreScrollEvent = true;
    RecyclerView recyclerView;
  }
  
  class RvScrollListener
    extends RecyclerView.OnScrollListener
  {
    private RvScrollListener() {}
    
    private void scrollOtherRV(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      int i = 0;
      if (i < VSmartView.this.recyclerViews.size())
      {
        VSmartView.RecyclerViewWrapper localRecyclerViewWrapper = (VSmartView.RecyclerViewWrapper)VSmartView.this.recyclerViews.get(i);
        if (localRecyclerViewWrapper.recyclerView == paramRecyclerView) {}
        for (;;)
        {
          i += 1;
          break;
          localRecyclerViewWrapper.recyclerView.scrollBy(paramInt1, paramInt2);
        }
      }
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      if (VSmartView.this.smartHeaderView == null) {}
      Object localObject;
      do
      {
        do
        {
          do
          {
            float f3;
            do
            {
              do
              {
                return;
                localObject = paramRecyclerView.getTag();
              } while ((!(localObject instanceof VSmartView.RecyclerViewWrapper)) || (((VSmartView.RecyclerViewWrapper)localObject).ignoreScrollEvent));
              if (paramInt2 <= 0) {
                break;
              }
              f3 = VSmartView.this.getTranslationYLimit();
            } while (VSmartView.this.smartHeaderView.getTranslationY() <= -f3);
            f2 = VSmartView.this.smartHeaderView.getTranslationY() + -paramInt2;
            f1 = f2;
            if (f2 < -f3) {
              f1 = -f3;
            }
            VSmartView.this.smartHeaderView.setTranslationY(f1);
            scrollOtherRV(paramRecyclerView, paramInt1, paramInt2);
            return;
          } while (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager));
          localObject = paramRecyclerView.findViewHolderForAdapterPosition(1);
        } while (localObject == null);
        localObject = ((RecyclerView.ViewHolder)localObject).itemView;
      } while ((localObject == null) || (((View)localObject).getTop() <= VSmartView.this.smartHeaderView.getHeight() + VSmartView.this.smartHeaderView.getTranslationY()));
      float f2 = -paramInt2 + VSmartView.this.smartHeaderView.getTranslationY();
      float f1 = f2;
      if (f2 > 0.0F) {
        f1 = 0.0F;
      }
      VSmartView.this.smartHeaderView.setTranslationY(f1);
      scrollOtherRV(paramRecyclerView, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSmartView
 * JD-Core Version:    0.7.0.1
 */