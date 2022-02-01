package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import apgx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.homework.arithmetic.data.HWGuideItem;
import java.util.ArrayList;
import java.util.List;

public class HomeworkGuideFragment
  extends IphoneTitleBarFragment
{
  protected List<a> HN = new ArrayList();
  protected TextView aaE;
  protected DotStyleNavBar b;
  protected ViewPager k;
  protected ArrayList<HWGuideItem> mData;
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mData = getArguments().getParcelableArrayList("EXTRA_GUIDE_ITEM_LIST");
    paramLayoutInflater = getArguments().getString("EXTRA_GO_BUTTON_TXT");
    paramViewGroup = getArguments().getString("EXTRA_TITLE_TXT");
    this.k = ((ViewPager)this.mContentView.findViewById(2131381930));
    this.b = ((DotStyleNavBar)this.mContentView.findViewById(2131366046));
    this.aaE = ((TextView)this.mContentView.findViewById(2131363876));
    this.k.setAdapter(new ContentAdapter(getActivity()));
    if (this.k.getAdapter().getCount() > 1) {
      this.b.setViewPager(this.k);
    }
    for (;;)
    {
      this.b.setOnPageChangeListener(new PagerListener());
      this.aaE.setText(paramLayoutInflater);
      this.aaE.setOnClickListener(new apgx(this));
      setTitle(paramViewGroup);
      return;
      this.b.setVisibility(4);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560816;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public class ContentAdapter
    extends PagerAdapter
  {
    protected LayoutInflater mInflater;
    
    public ContentAdapter(Context paramContext)
    {
      this.mInflater = LayoutInflater.from(paramContext);
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return HomeworkGuideFragment.this.mData.size();
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = this.mInflater.inflate(2131560817, paramViewGroup, false);
      HomeworkGuideFragment.a locala = new HomeworkGuideFragment.a(HomeworkGuideFragment.this);
      locala.m(paramInt, localView);
      localView.setTag(locala);
      HomeworkGuideFragment.this.HN.add(locala);
      paramViewGroup.addView(localView, 0);
      return localView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
  
  public class PagerListener
    implements ViewPager.OnPageChangeListener
  {
    public PagerListener() {}
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt) {}
  }
  
  public class a
  {
    public ImageView Ew;
    public int mPosition;
    public TextView wG;
    
    public a() {}
    
    public void m(int paramInt, View paramView)
    {
      this.Ew = ((ImageView)paramView.findViewById(2131373231));
      this.wG = ((TextView)paramView.findViewById(2131365720));
      this.mPosition = paramInt;
      this.wG.setText(((HWGuideItem)HomeworkGuideFragment.this.mData.get(this.mPosition)).coP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.HomeworkGuideFragment
 * JD-Core Version:    0.7.0.1
 */