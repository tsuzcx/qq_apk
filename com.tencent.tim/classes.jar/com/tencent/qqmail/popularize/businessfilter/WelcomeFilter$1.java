package com.tencent.qqmail.popularize.businessfilter;

import com.tencent.qqmail.popularize.PopularizeManager;
import java.util.ArrayList;

class WelcomeFilter$1
  implements Runnable
{
  WelcomeFilter$1(WelcomeFilter paramWelcomeFilter, ArrayList paramArrayList) {}
  
  public void run()
  {
    PopularizeManager.sharedInstance().updatePopularizeListIsRender(this.val$popularizeArrayList, true);
    PopularizeManager.sharedInstance().updatePopularizeListRenderTime(this.val$popularizeArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.WelcomeFilter.1
 * JD-Core Version:    0.7.0.1
 */