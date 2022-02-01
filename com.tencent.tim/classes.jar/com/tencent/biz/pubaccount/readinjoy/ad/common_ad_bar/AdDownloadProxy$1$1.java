package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.util.Pair;
import java.util.List;
import kjt;
import kju;
import kkp;
import kkr;
import kns;

public class AdDownloadProxy$1$1
  implements Runnable
{
  AdDownloadProxy$1$1(AdDownloadProxy.1 param1, Activity paramActivity, Pair paramPair) {}
  
  public void run()
  {
    if (!this.val$activity.isFinishing())
    {
      if ((this.a.this$0.jdField_a_of_type_Kns != null) && (this.a.this$0.jdField_a_of_type_Kns.isShowing())) {
        this.a.this$0.jdField_a_of_type_Kns.dismiss();
      }
      this.a.this$0.jdField_a_of_type_Kns = new kns(this.a.this$0.context, this.a.this$0.aJm);
      this.a.this$0.jdField_a_of_type_Kns.mu(true);
      this.a.this$0.jdField_a_of_type_Kns.a(this.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
      this.a.this$0.jdField_a_of_type_Kns.a((List)this.b.first, (List)this.b.second, this.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.packageName, this.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.a.aae, this.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.a.giftName, this.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.appid, this.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.a.a.aaj);
      this.a.this$0.jdField_a_of_type_Kns.a(new kju(this));
      this.a.this$0.jdField_a_of_type_Kns.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.AdDownloadProxy.1.1
 * JD-Core Version:    0.7.0.1
 */