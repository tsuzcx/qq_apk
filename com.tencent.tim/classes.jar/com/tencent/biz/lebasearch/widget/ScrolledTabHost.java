package com.tencent.biz.lebasearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import jso;

public class ScrolledTabHost
  extends FrameLayout
  implements View.OnClickListener
{
  a a;
  ViewGroup aH;
  HorizontalScrollView b;
  int curIndex = 0;
  List<View> fL = new ArrayList();
  public View iJ;
  Context mContext;
  
  public ScrolledTabHost(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public ScrolledTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public ScrolledTabHost(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(this.mContext).inflate(2131561153, this);
    this.aH = ((ViewGroup)findViewById(2131379148));
    this.b = ((HorizontalScrollView)findViewById(2131379162));
    this.iJ = findViewById(2131367235);
  }
  
  public void ci(int paramInt1, int paramInt2)
  {
    View localView1 = s(paramInt1);
    View localView2 = s(paramInt2);
    localView1 = localView1.findViewById(2131379136);
    localView2 = localView2.findViewById(2131379136);
    if (paramInt1 == paramInt2)
    {
      localView2.setVisibility(0);
      return;
    }
    Object localObject1 = new int[2];
    int[] arrayOfInt = new int[2];
    localView1.getLocationInWindow((int[])localObject1);
    localView2.getLocationInWindow(arrayOfInt);
    Object localObject2 = new int[2];
    this.aH.getLocationInWindow((int[])localObject2);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.iJ.getLayoutParams();
    localLayoutParams.leftMargin = (localObject1[0] - localObject2[0]);
    localLayoutParams.width = localView2.getMeasuredWidth();
    this.iJ.setLayoutParams(localLayoutParams);
    localObject2 = new AnimationSet(false);
    localObject1 = new TranslateAnimation(0.0F, arrayOfInt[0] - localObject1[0], 0.0F, 0.0F);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(false);
    ((AnimationSet)localObject2).addAnimation((Animation)localObject1);
    ((AnimationSet)localObject2).setAnimationListener(new jso(this, localView1, localView2, paramInt2));
    this.iJ.setVisibility(0);
    localView1.setVisibility(4);
    this.iJ.startAnimation((Animation)localObject2);
  }
  
  public void clearAllTabs()
  {
    int i = 0;
    while (i < this.aH.getChildCount())
    {
      View localView = this.aH.getChildAt(i);
      localView.findViewById(2131379136).setVisibility(4);
      this.fL.add(localView);
      i += 1;
    }
    oe(0);
    this.aH.removeAllViews();
    this.curIndex = 0;
  }
  
  public void ll(String paramString)
  {
    if (this.fL.size() == 0) {}
    for (View localView = LayoutInflater.from(getContext()).inflate(2131561157, null);; localView = (View)this.fL.remove(0))
    {
      ((TextView)localView.findViewById(2131380976)).setText(paramString);
      localView.setTag(-3, paramString);
      if (localView.getParent() == null) {
        break;
      }
      return;
    }
    localView.findViewById(2131379136).setVisibility(4);
    this.aH.addView(localView);
    localView.setOnClickListener(this);
  }
  
  public void oe(int paramInt)
  {
    Object localObject = s(paramInt);
    if (localObject == null) {
      return;
    }
    int i = ((View)localObject).getWidth();
    int[] arrayOfInt = new int[2];
    ((View)localObject).getLocationInWindow(arrayOfInt);
    int j = arrayOfInt[0];
    int k = this.mContext.getResources().getDisplayMetrics().widthPixels;
    if (j < 0)
    {
      this.b.smoothScrollBy(j, 0);
      label64:
      i = 0;
      label66:
      if (i < this.aH.getChildCount())
      {
        localObject = (TextView)this.aH.getChildAt(i).findViewById(2131380976);
        if (i != paramInt) {
          break label146;
        }
        ((TextView)localObject).setTextColor(getResources().getColor(2131167309));
      }
    }
    for (;;)
    {
      i += 1;
      break label66;
      break;
      if (j + i <= k) {
        break label64;
      }
      this.b.smoothScrollBy(j + i - k, 0);
      break label64;
      label146:
      ((TextView)localObject).setTextColor(getResources().getColor(2131167380));
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null)
    {
      this.a.of(this.aH.indexOfChild(paramView));
      this.a.jY(this.aH.indexOfChild(paramView));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void reset()
  {
    if (this.aH != null)
    {
      this.curIndex = 0;
      int i = 0;
      if (i < this.aH.getChildCount())
      {
        View localView = this.aH.getChildAt(i).findViewById(2131379136);
        if (i == 0) {
          localView.setVisibility(0);
        }
        for (;;)
        {
          i += 1;
          break;
          localView.setVisibility(4);
        }
      }
      if (this.a != null) {
        this.a.of(0);
      }
    }
  }
  
  public View s(int paramInt)
  {
    return this.aH.getChildAt(paramInt);
  }
  
  public void setCurrentTab(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.aH.getChildCount())) {
      return;
    }
    int j = this.curIndex;
    this.curIndex = paramInt;
    if (this.a != null) {
      this.a.of(paramInt);
    }
    int i = 0;
    if (i < this.aH.getChildCount())
    {
      TextView localTextView = (TextView)this.aH.getChildAt(i).findViewById(2131380976);
      if (i == paramInt) {
        localTextView.setTextColor(getResources().getColor(2131167309));
      }
      for (;;)
      {
        i += 1;
        break;
        localTextView.setTextColor(getResources().getColor(2131167380));
      }
    }
    ci(j, this.curIndex);
  }
  
  public void setOnTabSelectedListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void jY(int paramInt);
    
    public abstract void of(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.lebasearch.widget.ScrolledTabHost
 * JD-Core Version:    0.7.0.1
 */