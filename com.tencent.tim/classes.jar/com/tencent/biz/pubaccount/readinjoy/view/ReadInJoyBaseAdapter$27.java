package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import mye;
import mye.b;
import ndi;
import wja;

public class ReadInJoyBaseAdapter$27
  implements Runnable
{
  public ReadInJoyBaseAdapter$27(ndi paramndi, mye.b paramb1, mye.b paramb2) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount() + this.l.position + 1;
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "setSelectionFromTop selectIndex:" + i);
    }
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(i, wja.dp2px(175.0F, this.this$0.mContext.getResources()));
    if (this.this$0.jdField_a_of_type_Mye.qc() == 7)
    {
      this.this$0.e(this.m);
      return;
    }
    this.this$0.jdField_a_of_type_Lgf$c = null;
    this.this$0.e(this.m, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.27
 * JD-Core Version:    0.7.0.1
 */