package com.tencent.biz.pubaccount.readinjoy.view;

import lbz;
import lhk;

class ReadInJoyListViewGroup$8
  implements Runnable
{
  ReadInJoyListViewGroup$8(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    lhk locallhk = lbz.a().a();
    if (locallhk != null) {
      locallhk.rj(this.this$0.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.8
 * JD-Core Version:    0.7.0.1
 */