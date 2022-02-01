package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;

class OnlineStatusPanel$1$1
  implements Runnable
{
  OnlineStatusPanel$1$1(OnlineStatusPanel.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    boolean bool = true;
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.cl(this.yr);
    OnlineStatusPanel.a(this.a.this$0);
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.notifyDataSetChanged();
    QQViewPager localQQViewPager = this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    if (this.a.this$0.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter.getCount() > 1) {}
    for (;;)
    {
      localQQViewPager.hy(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.1.1
 * JD-Core Version:    0.7.0.1
 */