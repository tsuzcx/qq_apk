package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class QCircleFolderTabViewPager
  extends ViewPagerCompat
{
  private TopGestureLayout a;
  
  public QCircleFolderTabViewPager(Context paramContext)
  {
    super(paramContext);
    bku();
    a(this);
  }
  
  public QCircleFolderTabViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bku();
    a(this);
  }
  
  public static void a(ViewPager paramViewPager)
  {
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mDefaultGutterSize");
      localField.setAccessible(true);
      localField.set(paramViewPager, Integer.valueOf(0));
      paramViewPager.requestLayout();
      return;
    }
    catch (Exception paramViewPager)
    {
      QLog.e("QCircleFolderTabViewPag", 1, "clearGutterSize:", paramViewPager);
    }
  }
  
  DataSetObserver a(ViewPager paramViewPager)
  {
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mObserver");
      localField.setAccessible(true);
      paramViewPager = (DataSetObserver)localField.get(paramViewPager);
      return paramViewPager;
    }
    catch (Exception paramViewPager)
    {
      paramViewPager.printStackTrace();
    }
    return null;
  }
  
  void a(PagerAdapter paramPagerAdapter, DataSetObserver paramDataSetObserver)
  {
    try
    {
      Method localMethod = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", new Class[] { DataSetObserver.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramPagerAdapter, new Object[] { paramDataSetObserver });
      return;
    }
    catch (Exception paramPagerAdapter)
    {
      paramPagerAdapter.printStackTrace();
    }
  }
  
  protected void bku()
  {
    if ((this.a == null) && ((getContext() instanceof FragmentActivity)))
    {
      Object localObject = (ViewGroup)((FragmentActivity)getContext()).getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.a = ((TopGestureLayout)localObject);
      }
    }
  }
  
  public boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView != this) && ((paramView instanceof QCircleMultiPicViewPager)))
    {
      QCircleMultiPicViewPager localQCircleMultiPicViewPager = (QCircleMultiPicViewPager)paramView;
      if (localQCircleMultiPicViewPager.HX())
      {
        if (paramInt1 > 0) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          if (localQCircleMultiPicViewPager.T(paramBoolean)) {
            rt(false);
          }
          return true;
        }
      }
    }
    if (((paramView instanceof RecyclerView)) && ((((RecyclerView)paramView).getLayoutManager() instanceof LinearLayoutManager)) && (((RecyclerView)paramView).getLayoutManager().canScrollHorizontally()))
    {
      rt(false);
      return true;
    }
    rt(true);
    return super.canScroll(paramView, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  protected void rt(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setInterceptScrollLRFlag(paramBoolean);
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    PagerAdapter localPagerAdapter = getAdapter();
    if (localPagerAdapter != null) {
      a(localPagerAdapter, null);
    }
    super.setAdapter(paramPagerAdapter);
    a(paramPagerAdapter, a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFolderTabViewPager
 * JD-Core Version:    0.7.0.1
 */