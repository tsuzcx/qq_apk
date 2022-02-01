package com.tencent.mobileqq.ark;

import acfp;
import afpt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import wja;

public class ArkPanelPagerAdapter
  extends PagerAdapter
{
  private int OE;
  int TL = 4;
  afpt a;
  int bPm = 2;
  ViewGroup container;
  View.OnClickListener dI;
  Context mContext;
  private final Drawable mDefaultDrawable = new ColorDrawable(0);
  ArrayList<ArkAppManagerPanel.a> uI;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.a = new afpt();
    this.OE = wja.dp2px(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, IconLinearLayout paramIconLinearLayout)
  {
    int n = this.TL;
    int i1 = this.bPm;
    paramIconLinearLayout.setPage(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.bPm)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramIconLinearLayout.getChildAt(j);
      int k = 0;
      if (k < this.TL)
      {
        View localView = localLinearLayout.getChildAt(k);
        a locala = (a)localView.getTag();
        int m = n * i1 * paramInt + i;
        ArkAppManagerPanel.a locala1;
        label159:
        Object localObject;
        if (m < this.uI.size())
        {
          locala1 = (ArkAppManagerPanel.a)this.uI.get(m);
          locala.sk.setVisibility(0);
          if ((m == this.uI.size() - 1) && (locala1.bQv))
          {
            locala.sk.setBackgroundDrawable(localView.getResources().getDrawable(2130838738));
            locala.Il.setText(locala1.arkAppName);
            localObject = locala.sl;
            if (!locala1.beg) {
              break label347;
            }
            m = 0;
            label190:
            ((ImageView)localObject).setVisibility(m);
            locala.appId = locala1.bvh;
            localView.setContentDescription(locala1.arkAppName + acfp.m(2131702848));
            localView.setOnClickListener(this.dI);
            localView.setEnabled(true);
            aqcl.Q(localView, true);
          }
        }
        for (;;)
        {
          aqcl.Q(locala.Il, false);
          i += 1;
          k += 1;
          break;
          localObject = URLDrawable.URLDrawableOptions.obtain();
          Drawable localDrawable = this.mDefaultDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
          m = this.OE;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = m;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = m;
          locala.sk.setBackgroundDrawable(URLDrawable.getDrawable(locala1.bvi, (URLDrawable.URLDrawableOptions)localObject));
          break label159;
          label347:
          m = 8;
          break label190;
          locala.sk.setVisibility(4);
          locala.sk.setImageBitmap(null);
          locala.Il.setText(null);
          locala.sl.setVisibility(8);
          locala.appId = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          aqcl.Q(localView, false);
        }
      }
      j += 1;
    }
  }
  
  public void dW(ArrayList<ArkAppManagerPanel.a> paramArrayList)
  {
    this.uI = paramArrayList;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    IconLinearLayout localIconLinearLayout = (IconLinearLayout)paramObject;
    ((ViewGroup)paramView).removeView(localIconLinearLayout);
    localIconLinearLayout.clear();
    this.a.gx((View)paramObject);
  }
  
  public int getColumnNum()
  {
    return this.TL;
  }
  
  public int getCount()
  {
    if ((this.TL == 0) || (this.bPm == 0) || (this.uI == null)) {
      return 0;
    }
    return (this.uI.size() + this.TL * this.bPm - 1) / (this.TL * this.bPm);
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (((paramObject instanceof IconLinearLayout)) && (((IconLinearLayout)paramObject).page >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public int getRowNum()
  {
    return this.bPm;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkPanelPagerAdapter", 2, "instantiateItem position=" + paramInt);
    }
    IconLinearLayout localIconLinearLayout = (IconLinearLayout)this.a.bW();
    Object localObject;
    if (localIconLinearLayout != null)
    {
      localObject = localIconLinearLayout.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localIconLinearLayout.getTag()).intValue() != XPanelContainer.evb))
      {
        this.a.dbs();
        localIconLinearLayout = null;
      }
    }
    for (;;)
    {
      this.container = ((ViewGroup)paramView);
      localObject = localIconLinearLayout;
      if (localIconLinearLayout == null) {
        localObject = new IconLinearLayout(this.mContext, null);
      }
      ((IconLinearLayout)localObject).setPage(paramInt);
      a(paramInt, (IconLinearLayout)localObject);
      if ((((IconLinearLayout)localObject).getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView((View)localObject);
      }
      return localObject;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void update(int paramInt)
  {
    if (this.container == null) {}
    for (;;)
    {
      return;
      if (paramInt >= 0)
      {
        int i = 0;
        while (i < this.container.getChildCount())
        {
          IconLinearLayout localIconLinearLayout = (IconLinearLayout)this.container.getChildAt(i);
          if ((localIconLinearLayout != null) && (paramInt == localIconLinearLayout.page))
          {
            a(paramInt, localIconLinearLayout);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void w(View.OnClickListener paramOnClickListener)
  {
    this.dI = paramOnClickListener;
  }
  
  class IconLinearLayout
    extends RelativeLayout
  {
    private LayoutInflater mInflater;
    int page;
    
    public IconLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.mInflater = LayoutInflater.from(paramContext);
      int k = ArkPanelPagerAdapter.this.getColumnNum();
      int m = ArkPanelPagerAdapter.this.getRowNum();
      int n = wja.dp2px(15.0F, getContext().getResources());
      int i = 0;
      while (i < m)
      {
        this$1 = new LinearLayout(paramContext);
        int j = (XPanelContainer.aLe - XPanelContainer.evb - n) / m;
        paramAttributeSet = new RelativeLayout.LayoutParams(-1, j);
        paramAttributeSet.leftMargin = wja.dp2px(20.0F, getContext().getResources());
        paramAttributeSet.rightMargin = wja.dp2px(20.0F, getContext().getResources());
        ArkPanelPagerAdapter.this.setOrientation(0);
        if (i == 0) {}
        for (paramAttributeSet.topMargin = (XPanelContainer.evb / (m + 1));; paramAttributeSet.topMargin = (j * i + XPanelContainer.evb * (i + 2) / (m + 1) / 2))
        {
          j = 0;
          while (j < k)
          {
            Object localObject = new LinearLayout.LayoutParams(-1, -1);
            ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
            if (this.mInflater == null) {
              this.mInflater = LayoutInflater.from(paramContext);
            }
            View localView = LayoutInflater.from(paramContext).inflate(2131558934, null);
            ArkPanelPagerAdapter.this.addView(localView, (ViewGroup.LayoutParams)localObject);
            localObject = new ArkPanelPagerAdapter.a();
            ((ArkPanelPagerAdapter.a)localObject).sk = ((ImageView)localView.findViewById(2131368847));
            ((ArkPanelPagerAdapter.a)localObject).sl = ((ImageView)localView.findViewById(2131367211));
            ((ArkPanelPagerAdapter.a)localObject).Il = ((TextView)localView.findViewById(2131379420));
            localView.setTag(localObject);
            j += 1;
          }
        }
        addView(ArkPanelPagerAdapter.this, paramAttributeSet);
        i += 1;
      }
      setTag(Integer.valueOf(XPanelContainer.evb));
    }
    
    public void clear()
    {
      int i = 0;
      while (i < getChildCount())
      {
        Object localObject = getChildAt(i);
        if (localObject != null)
        {
          localObject = (ArkPanelPagerAdapter.a)((View)localObject).getTag();
          if ((localObject != null) && (((ArkPanelPagerAdapter.a)localObject).sk != null)) {
            ((ArkPanelPagerAdapter.a)localObject).sk.setBackgroundDrawable(null);
          }
        }
        i += 1;
      }
      this.page = -1;
    }
    
    public void setPage(int paramInt)
    {
      this.page = paramInt;
    }
  }
  
  public static class a
  {
    TextView Il;
    String appId;
    ImageView sk;
    ImageView sl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkPanelPagerAdapter
 * JD-Core Version:    0.7.0.1
 */