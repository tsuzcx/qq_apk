package com.tencent.mobileqq.nearby.now;

import ajpj;
import ajxs;
import android.text.TextUtils;
import anov;
import com.tencent.mobileqq.nearby.now.model.VideoData;

class StoryPlayController$7
  implements Runnable
{
  StoryPlayController$7(StoryPlayController paramStoryPlayController, VideoData paramVideoData, ajpj paramajpj) {}
  
  public void run()
  {
    anov localanov = new anov(this.this$0.app).a("dc00899").b("grp_lbs").c("video").d("playpage_right_slide").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.ads));
    int i = this.jdField_a_of_type_Ajpj.GA();
    String str2 = ajxs.from;
    if (TextUtils.equals(ajxs.from, "2")) {}
    for (String str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.id);; str1 = "")
    {
      localanov.a(new String[] { "", String.valueOf(i), str2, str1 }).report();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.7
 * JD-Core Version:    0.7.0.1
 */