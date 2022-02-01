package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

public class PagerIndicator
  extends LinearLayout
{
  public static final int[] ATTRS = { 16843161, 16843327, 16843245 };
  public final a a = new a(null);
  protected EmptySupportViewPager b;
  protected int bus;
  protected int but;
  protected Drawable dn;
  protected WeakReference<IndicatorAdapter> mWatchingAdapter;
  protected Queue<InnerImageView> z = new LinkedList();
  
  public PagerIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(0);
    super.setGravity(17);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    if (paramContext.hasValue(0)) {}
    for (this.dn = paramContext.getDrawable(0);; this.dn = new ColorDrawable(-7829368))
    {
      this.bus = paramContext.getDimensionPixelSize(1, this.bus);
      this.but = paramContext.getInt(2, this.but);
      paramContext.recycle();
      et(0, this.but);
      Log.d("PagerIndicator", "init");
      return;
    }
  }
  
  protected void a(int paramInt, @Nullable IndicatorAdapter paramIndicatorAdapter)
  {
    int i = 0;
    if (paramIndicatorAdapter != null) {}
    for (paramInt = paramIndicatorAdapter.ek(paramInt);; paramInt = 0)
    {
      if (paramIndicatorAdapter != null) {
        i = paramIndicatorAdapter.tS();
      }
      et(paramInt, i);
      return;
    }
  }
  
  protected void et(int paramInt1, int paramInt2)
  {
    Log.d("PagerIndicator", "updatePoints : current item = " + paramInt1 + ", page count = " + paramInt2);
    int i = super.getChildCount();
    Object localObject;
    if (i > paramInt2)
    {
      i -= 1;
      for (;;)
      {
        if (i < paramInt2) {
          break label208;
        }
        localObject = super.getChildAt(i);
        if (!(localObject instanceof InnerImageView)) {
          break;
        }
        super.removeView((View)localObject);
        this.z.offer((InnerImageView)localObject);
        i -= 1;
      }
      throw new AndroidRuntimeException("find illegal child view, all child view should be InnerImageView");
    }
    if (paramInt2 > i) {
      while (i < paramInt2)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(this.bus, 0, 0, 0);
        InnerImageView localInnerImageView = (InnerImageView)this.z.poll();
        localObject = localInnerImageView;
        if (localInnerImageView == null)
        {
          localObject = new InnerImageView(getContext());
          ((InnerImageView)localObject).setImageDrawable(this.dn.getConstantState().newDrawable());
        }
        super.addView((View)localObject, i, localLayoutParams);
        i += 1;
      }
    }
    label208:
    i = 0;
    if (i < paramInt2)
    {
      localObject = super.getChildAt(i);
      if (paramInt1 == i) {
        ((View)localObject).setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        ((View)localObject).setSelected(false);
      }
    }
  }
  
  public void setViewPager(@Nullable EmptySupportViewPager paramEmptySupportViewPager)
  {
    if (this.b != paramEmptySupportViewPager)
    {
      if (this.b != null)
      {
        this.b.removeOnPageChangeListener(this.a);
        this.b = null;
      }
      if (paramEmptySupportViewPager != null)
      {
        this.b = paramEmptySupportViewPager;
        this.b.addOnPageChangeListener(this.a);
      }
    }
  }
  
  public void setViewPagerAdapter(@Nullable IndicatorAdapter paramIndicatorAdapter)
  {
    if (this.mWatchingAdapter != null) {}
    for (IndicatorAdapter localIndicatorAdapter = (IndicatorAdapter)this.mWatchingAdapter.get();; localIndicatorAdapter = null)
    {
      if (localIndicatorAdapter != paramIndicatorAdapter)
      {
        if (localIndicatorAdapter != null)
        {
          localIndicatorAdapter.unregisterDataSetObserver(this.a);
          this.mWatchingAdapter = null;
        }
        if (paramIndicatorAdapter != null)
        {
          paramIndicatorAdapter.registerDataSetObserver(this.a);
          this.mWatchingAdapter = new WeakReference(paramIndicatorAdapter);
        }
        if (this.b != null) {
          a(this.b.getCurrentItem(), paramIndicatorAdapter);
        }
      }
      return;
    }
  }
  
  public static abstract class IndicatorAdapter
    extends PagerAdapter
  {
    public int ek(int paramInt)
    {
      return paramInt;
    }
    
    public int tS()
    {
      return getCount();
    }
  }
  
  static class InnerImageView
    extends ImageView
  {
    public InnerImageView(Context paramContext)
    {
      super();
    }
    
    public InnerImageView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  class a
    extends DataSetObserver
    implements ViewPager.OnPageChangeListener
  {
    private a() {}
    
    public void onChanged()
    {
      Log.d("PagerIndicator", "onChanged");
      PagerIndicator.this.a(PagerIndicator.this.b.getCurrentItem(), (PagerIndicator.IndicatorAdapter)PagerIndicator.this.b.getAdapter());
    }
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      Log.d("PagerIndicator", "onPageSelected : " + paramInt);
      PagerIndicator.this.a(PagerIndicator.this.b.getCurrentItem(), (PagerIndicator.IndicatorAdapter)PagerIndicator.this.b.getAdapter());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PagerIndicator
 * JD-Core Version:    0.7.0.1
 */