package com.tencent.qqmail.popularize.businessfilter;

import com.tencent.qqmail.popularize.PopularizeManager;
import java.util.ArrayList;

class CommFilter$1
  implements Runnable
{
  CommFilter$1(CommFilter paramCommFilter, ArrayList paramArrayList) {}
  
  public void run()
  {
    PopularizeManager.sharedInstance().updatePopularizeListIsRender(this.val$fRet, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.businessfilter.CommFilter.1
 * JD-Core Version:    0.7.0.1
 */