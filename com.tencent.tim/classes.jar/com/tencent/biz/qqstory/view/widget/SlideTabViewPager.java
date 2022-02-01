package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import rss;
import rst;
import wja;

public class SlideTabViewPager
  extends RelativeLayout
  implements View.OnClickListener
{
  private a jdField_a_of_type_ComTencentBizQqstoryViewWidgetSlideTabViewPager$a;
  private ViewPagerTapBlockView jdField_a_of_type_ComTencentBizQqstoryViewWidgetViewPagerTapBlockView;
  private int buS = -8421505;
  private int buT = -12143138;
  private int buU;
  protected View.OnClickListener cN = new rst(this);
  private LinearLayout fd;
  private Context mContext;
  protected ViewPager.OnPageChangeListener mOnPageChangeListener = new rss(this);
  private ViewPager mViewPager;
  private ArrayList<TextView> nM = new ArrayList();
  private ArrayList<View> nO = new ArrayList();
  private int textSize = 14;
  private TextView zi;
  private TextView zj;
  
  public SlideTabViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideTabViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideTabViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private int dp2px(float paramFloat)
  {
    return wja.dp2px(paramFloat, this.mContext.getResources());
  }
  
  private void initView(Context paramContext)
  {
    this.mContext = paramContext;
    inflate(paramContext, 2131562049, this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetViewPagerTapBlockView = ((ViewPagerTapBlockView)findViewById(2131379250));
    this.fd = ((LinearLayout)findViewById(2131379251));
    this.mViewPager = ((ViewPager)findViewById(2131365573));
  }
  
  public void onClick(View paramView) {}
  
  public void setOnPageSelected(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetSlideTabViewPager$a = parama;
  }
  
  public void setSlideBlockColor(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetViewPagerTapBlockView.setBlockColor(paramInt);
  }
  
  public void setTab(int paramInt)
  {
    if (this.mViewPager != null) {
      this.mViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void setTabTextStyle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.textSize = paramInt1;
    this.buS = paramInt2;
    this.buT = paramInt3;
  }
  
  public void xW(int paramInt)
  {
    int i = 0;
    if (i < this.nM.size())
    {
      TextView localTextView = (TextView)this.nM.get(i);
      if (i == paramInt) {
        localTextView.setTextColor(this.buT);
      }
      for (;;)
      {
        i += 1;
        break;
        localTextView.setTextColor(this.buS);
      }
    }
  }
  
  public class TabViewAdapter
    extends PagerAdapter
  {
    private ArrayList<View> nO;
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)this.nO.get(paramInt));
    }
    
    public int getCount()
    {
      return this.nO.size();
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = (View)this.nO.get(paramInt);
      paramViewGroup.addView(localView);
      return localView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.SlideTabViewPager
 * JD-Core Version:    0.7.0.1
 */