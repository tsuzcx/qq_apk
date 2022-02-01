package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import awit;
import com.tencent.mobileqq.widget.QQToast;
import kxm;
import lgf.c;
import mst;
import mye.b;
import ndi;

public class ReadInJoyBaseAdapter$28
  implements Runnable
{
  public ReadInJoyBaseAdapter$28(ndi paramndi, mye.b paramb) {}
  
  public void run()
  {
    if (!ndi.d(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.this$0.jdField_a_of_type_Lgf$c == null) || (this.this$0.jdField_a_of_type_Lgf$c.a() == null) || (this.n == null));
        this.n.xb = 0L;
      } while ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) || (!ndi.a(this.this$0).nW()));
      int i = this.n.position;
      int j = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyBaseAdapter.28.1(this, i + j));
    } while (!awit.q(kxm.getAppRuntime()));
    QQToast.a(this.this$0.mContext.getApplicationContext(), "为你开启wifi下连续播放功能", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.28
 * JD-Core Version:    0.7.0.1
 */