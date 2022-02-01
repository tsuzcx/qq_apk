package com.tencent.mobileqq.nearby.profilecard;

import akgm;
import android.widget.TextView;
import com.tencent.mobileqq.widget.BounceScrollView;

public class NearbyProfileEditTribePanel$8
  implements Runnable
{
  public NearbyProfileEditTribePanel$8(akgm paramakgm) {}
  
  public void run()
  {
    int i = this.this$0.VV.getTop();
    int j = (int)(this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity * 20.0F);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollTo(0, i - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.8
 * JD-Core Version:    0.7.0.1
 */