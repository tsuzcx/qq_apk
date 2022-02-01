package com.tencent.biz.widgets;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import swk;
import swl;

public class TabLayout
  extends HorizontalListView
{
  private a a;
  private boolean aNL;
  private Map<Integer, View> gy = new HashMap();
  private Map<Integer, Integer> gz = new HashMap();
  
  public TabLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, false);
    init();
  }
  
  private void init()
  {
    setHorizontalScrollBarEnabled(false);
  }
  
  public void b(int paramInt1, int paramInt2, Animator.AnimatorListener paramAnimatorListener)
  {
    int i = 0;
    if (paramInt2 < getFirstVisiblePosition())
    {
      paramAnimatorListener.onAnimationEnd(null);
      this.aNL = false;
      notifyDataSetChanged();
      return;
    }
    this.aNL = true;
    int j = getFirstVisiblePosition();
    int m = paramInt2 - getFirstVisiblePosition();
    View localView = getChildAt(paramInt1 - j);
    if (localView != null)
    {
      int n = localView.getWidth();
      int k;
      for (j = 0; i < paramInt1 - paramInt2; j = k)
      {
        localObject = getChildAt(i + m);
        k = j;
        if (localObject != null) {
          k = j + ((View)localObject).getWidth();
        }
        i += 1;
      }
      Object localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      ((ValueAnimator)localObject).setDuration(500L);
      ((ValueAnimator)localObject).addUpdateListener(new swk(this, paramInt1, paramInt2, m, n, localView, j));
      ((ValueAnimator)localObject).addListener(new swl(this, paramAnimatorListener));
      ((ValueAnimator)localObject).start();
      return;
    }
    paramAnimatorListener.onAnimationEnd(null);
    this.aNL = false;
    notifyDataSetChanged();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public int eu(int paramInt)
  {
    if (paramInt < this.gy.size()) {
      return ((View)this.gy.get(Integer.valueOf(paramInt))).getMeasuredWidth();
    }
    return 0;
  }
  
  public View f(int paramInt)
  {
    return (View)this.gy.get(Integer.valueOf(paramInt));
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.a != null) && (!this.aNL)) {
      this.a.notifyDataSetChanged();
    }
  }
  
  public void setAdapter(a parama)
  {
    super.setAdapter(parama);
    this.a = parama;
    this.a.a(this);
  }
  
  public void setChildView(int paramInt, View paramView)
  {
    this.gy.put(Integer.valueOf(paramInt), paramView);
  }
  
  public void setChildWidth(int paramInt1, int paramInt2)
  {
    this.gz.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void setSwappingAnimation()
  {
    this.aNL = true;
  }
  
  public void smoothScrollToPositionFromLeftOrRight(int paramInt1, int paramInt2, int paramInt3)
  {
    super.smoothScrollToPositionFromLeftOrRight(paramInt1, paramInt2, paramInt3);
  }
  
  public int ux()
  {
    return this.gy.size();
  }
  
  public static abstract class a<T>
    extends BaseAdapter
  {
    protected Context context;
    protected TabLayout d;
    protected List<T> itemList;
    
    public a(Context paramContext, List<T> paramList)
    {
      this.context = paramContext;
      this.itemList = paramList;
    }
    
    protected abstract void a(a parama, T paramT, int paramInt);
    
    public void a(TabLayout paramTabLayout)
    {
      this.d = paramTabLayout;
    }
    
    public int getCount()
    {
      if (this.itemList != null) {
        return this.itemList.size() + 1;
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.itemList != null) && (paramInt < this.itemList.size())) {
        return this.itemList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1 = null;
      Object localObject2;
      if (paramInt < getCount() - 1)
      {
        localObject2 = this.d.f(paramInt);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          paramView = LayoutInflater.from(this.context).inflate(ha(), paramViewGroup, false);
          paramView.post(new TabLayout.TabAdapter.1(this, paramInt, paramView));
        }
        localObject2 = new a(paramView, null);
        paramView.setTranslationX(0.0F);
        if (this.itemList != null) {
          localObject1 = this.itemList.get(paramInt);
        }
        a((a)localObject2, localObject1, paramInt);
        localObject1 = paramView;
        localObject2 = localObject1;
        localObject1 = paramView;
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject2;
        localObject1 = LayoutInflater.from(this.context).inflate(2131560420, paramViewGroup, false);
        paramView = (View)localObject1;
        localObject2 = paramView;
      }
    }
    
    protected abstract int ha();
    
    public static class a
    {
      private SparseArray<View> aG;
      private View view;
      
      private a(View paramView)
      {
        this.view = paramView;
      }
      
      public View getItemView()
      {
        return this.view;
      }
      
      public <T extends View> T getView(int paramInt)
      {
        if (this.aG == null) {
          this.aG = new SparseArray();
        }
        if ((this.aG.get(paramInt) == null) && (this.view != null)) {
          this.aG.put(paramInt, this.view.findViewById(paramInt));
        }
        return (View)this.aG.get(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout
 * JD-Core Version:    0.7.0.1
 */