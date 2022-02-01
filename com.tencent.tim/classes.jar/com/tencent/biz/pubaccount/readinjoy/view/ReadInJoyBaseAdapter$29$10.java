package com.tencent.biz.pubaccount.readinjoy.view;

import mye;
import ndi;
import ndx;

public class ReadInJoyBaseAdapter$29$10
  implements Runnable
{
  public ReadInJoyBaseAdapter$29$10(ndx paramndx) {}
  
  public void run()
  {
    this.a.this$0.notifyDataSetChanged();
    if ((!this.a.this$0.jdField_a_of_type_Mye.isPlaying()) && (!this.a.this$0.jdField_a_of_type_Mye.isPause())) {
      this.a.this$0.j(this.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.10
 * JD-Core Version:    0.7.0.1
 */