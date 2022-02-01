package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.qphone.base.util.QLog;
import lfx;

class ReadInJoyListViewGroup$47
  implements Runnable
{
  ReadInJoyListViewGroup$47(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if (lfx.dH(this.this$0.nh()))
    {
      this.this$0.lP(true);
      QLog.i("ReadInJoyListViewGroup", 1, "[handleDailyJumpToRecommendChannel], backToTop refresh, channelID = " + this.this$0.nh());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.47
 * JD-Core Version:    0.7.0.1
 */