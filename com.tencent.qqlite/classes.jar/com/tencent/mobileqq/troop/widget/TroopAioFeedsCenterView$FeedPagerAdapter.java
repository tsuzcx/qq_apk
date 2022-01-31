package com.tencent.mobileqq.troop.widget;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import java.util.List;

public class TroopAioFeedsCenterView$FeedPagerAdapter
  extends PagerAdapter
{
  public TroopAioFeedsCenterView$FeedPagerAdapter(TroopAioFeedsCenterView paramTroopAioFeedsCenterView) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.a((View)paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    super.finishUpdate(paramViewGroup);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetDotIndexView.setDotSelected(this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem(), true);
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (TroopFeedViewFactory.ViewHolder)((View)paramObject).getTag();
    int j;
    if (paramObject.a == null)
    {
      j = -2;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size()) {
        break label79;
      }
      j = i;
      if (paramObject.a.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.get(i))) {
        break;
      }
      i += 1;
    }
    label79:
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.size() <= paramInt) {
      return null;
    }
    Object localObject = (TroopFeedItem)this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.get(paramInt);
    if (paramInt + 1 == getCount()) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.a((TroopFeedItem)localObject, paramInt, bool);
      paramViewGroup.addView((View)localObject, 0);
      return localObject;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView.FeedPagerAdapter
 * JD-Core Version:    0.7.0.1
 */