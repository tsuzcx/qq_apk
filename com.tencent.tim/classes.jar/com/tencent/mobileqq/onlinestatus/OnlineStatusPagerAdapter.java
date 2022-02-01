package com.tencent.mobileqq.onlinestatus;

import akto;
import aktz;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class OnlineStatusPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  private aktz jdField_a_of_type_Aktz = new aktz();
  private a jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$a;
  public akto c;
  private int dpe;
  private ArrayList<akto> kr = new ArrayList();
  private Context mContext;
  
  OnlineStatusPagerAdapter(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.dpe = (paramInt * 3);
  }
  
  private List<akto> ah(int paramInt)
  {
    paramInt = this.dpe * paramInt;
    int i = Math.min(this.kr.size(), this.dpe + paramInt);
    return this.kr.subList(paramInt, i);
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$a = parama;
  }
  
  public void cl(ArrayList<akto> paramArrayList)
  {
    this.kr = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof OnlineStatusListLayout))
    {
      paramViewGroup.removeView((OnlineStatusListLayout)paramObject);
      this.jdField_a_of_type_Aktz.x(paramInt, (View)paramObject);
    }
  }
  
  public int getCount()
  {
    int i = this.kr.size();
    int j = i / this.dpe;
    if (i % this.dpe > 0) {}
    for (i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    OnlineStatusListLayout localOnlineStatusListLayout = (OnlineStatusListLayout)this.jdField_a_of_type_Aktz.getScrapView(paramInt);
    if (localOnlineStatusListLayout == null) {
      localOnlineStatusListLayout = new OnlineStatusListLayout(this.mContext);
    }
    for (;;)
    {
      localOnlineStatusListLayout.a(ah(paramInt), this);
      localOnlineStatusListLayout.c(this.c);
      if ((localOnlineStatusListLayout.getParent() != paramViewGroup) && (paramInt < getCount())) {
        paramViewGroup.addView(localOnlineStatusListLayout);
      }
      return localOnlineStatusListLayout;
      localOnlineStatusListLayout.removeAllViews();
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof akto))
    {
      localObject = (akto)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$a.a(this.c, (akto)localObject);
      }
      this.c = ((akto)localObject);
      notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static abstract interface a
  {
    public abstract void a(akto paramakto1, akto paramakto2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter
 * JD-Core Version:    0.7.0.1
 */