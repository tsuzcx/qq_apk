package com.tencent.moai.nativepages.component;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.moai.nativepages.model.AdLandingPageComponentGroupList;
import com.tencent.moai.nativepages.util.DataUtil;
import com.tencent.moai.nativepages.view.AdLandingControlView;

class AdLandingPageGroupList$1
  implements ViewPager.OnPageChangeListener
{
  AdLandingPageGroupList$1(AdLandingPageGroupList paramAdLandingPageGroupList, AdLandingPageGroupList.TurnPagerAdapter paramTurnPagerAdapter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AdLandingPageGroupList.access$000(this.this$0).setPage(paramInt);
    AdLandingPageGroupList.access$102(this.this$0, paramInt);
    if (this.this$0.getViewAppeared())
    {
      this.val$adapter.startRightIconAnimation(paramInt);
      this.val$adapter.didToPage(paramInt);
    }
    DataUtil.collect(this.this$0.getInfo().cId, "Event_Native_AD_Component_Scroll_Group_Scroll_Count", 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageGroupList.1
 * JD-Core Version:    0.7.0.1
 */