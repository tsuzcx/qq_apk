package com.tencent.biz.richframework.part.block.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import rxu;

public class NestScrollRecyclerView
  extends RecyclerViewCompat
  implements NestedScrollingParent
{
  private static String TAG = "NestScrollRecyclerView";
  private NestedScrollingParentHelper jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper;
  private RefreshHeaderView jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseRefreshHeaderView;
  private int bvR;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private int mTouchSlop;
  private View py;
  private View pz;
  
  public NestScrollRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean Mj()
  {
    if (this.pz == null) {}
    while (this.pz.getTop() <= 0) {
      return false;
    }
    return true;
  }
  
  private void a(RefreshHeaderView paramRefreshHeaderView)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseRefreshHeaderView = paramRefreshHeaderView;
  }
  
  private boolean a(int paramInt, RecyclerView paramRecyclerView)
  {
    e(paramRecyclerView);
    return ((paramInt > 0) && (Mj())) || ((paramInt < 0) && (!paramRecyclerView.canScrollVertically(-1)));
  }
  
  private void e(RecyclerView paramRecyclerView)
  {
    if (((paramRecyclerView instanceof NestScrollRecyclerView)) && ((getAdapter() instanceof rxu)) && (((rxu)getAdapter()).isEnableRefresh()) && (((NestScrollRecyclerView)paramRecyclerView).a() == null)) {
      ((NestScrollRecyclerView)paramRecyclerView).a(((rxu)getAdapter()).b());
    }
  }
  
  private void init()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public RefreshHeaderView a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseRefreshHeaderView;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    return super.fling(paramInt1, paramInt2);
  }
  
  public int getNestedScrollAxes()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getAction();
    int j = paramMotionEvent.getActionIndex();
    boolean bool1;
    switch (i)
    {
    case 1: 
    default: 
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    case 0: 
      this.mInitialTouchX = ((int)(paramMotionEvent.getX() + 0.5F));
      this.mInitialTouchY = ((int)(paramMotionEvent.getY() + 0.5F));
      this.bvR = MotionEventCompat.findPointerIndex(paramMotionEvent, j);
      this.py = null;
      this.pz = null;
    }
    do
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.mInitialTouchX;
      i = (int)((i - this.mInitialTouchY) * 0.6F);
      if (Math.abs(j) > this.mTouchSlop)
      {
        bool1 = bool2;
        if (Math.abs(j) >= Math.abs(i)) {
          break;
        }
      }
      bool1 = bool2;
      if ((this.py instanceof NestScrollRecyclerView)) {
        break;
      }
    } while ((Math.abs(j) <= this.mTouchSlop) || (Math.abs(i) <= Math.abs(j)));
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if (((paramView instanceof NestScrollRecyclerView)) && (a((int)paramFloat2, (NestScrollRecyclerView)paramView))) {
      fling((int)paramFloat1, (int)paramFloat2);
    }
    for (boolean bool = true;; bool = false)
    {
      Log.d(TAG, String.format("----onNestedPreFling---------------- ret:%s, velocityY:%s", new Object[] { Boolean.valueOf(bool), Float.valueOf(paramFloat2) }));
      return bool;
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (((paramView instanceof RecyclerView)) && (a(paramInt2, (RecyclerView)paramView)))
    {
      scrollBy(0, paramInt2);
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d(TAG, "----父布局onNestedScroll----------------");
  }
  
  @SuppressLint({"NewApi"})
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.py = paramView2;
    this.pz = paramView1;
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    Log.d(TAG, "----父布局onStopNestedScroll----------------");
    this.jdField_a_of_type_AndroidSupportV4ViewNestedScrollingParentHelper.onStopNestedScroll(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((getAdapter() instanceof rxu)) && (((rxu)getAdapter()).isEnableRefresh()) && (((rxu)getAdapter()).b() != null)) {
      ((rxu)getAdapter()).b().P(paramMotionEvent);
    }
    if (a() != null) {
      a().P(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */