import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.c;

class mtm
  implements VideoFeedsPlayManager.c
{
  mtm(mtg parammtg) {}
  
  public void onProgressChanged(long paramLong)
  {
    if (mtg.a(this.this$0) != null) {
      mtg.a(this.this$0).onProgressChanged(paramLong);
    }
    if ((mtg.a(this.this$0) instanceof mtg.b))
    {
      localb = (mtg.b)mtg.a(this.this$0);
      if ((knd.a(localb)) && (((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null))
      {
        ((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setGestureAdInfo(localb, mtg.a(this.this$0));
        knd.a(((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView, ((mtg.b)mtg.a(this.this$0)).dZ);
      }
      if ((paramLong >= knd.a((mtg.b)mtg.a(this.this$0), true)) && (paramLong <= knd.a((mtg.b)mtg.a(this.this$0), false))) {
        if (((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          ((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(0);
          ((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.mz(true);
        }
      }
    }
    while (!(mtg.a(this.this$0) instanceof mtg.g))
    {
      mtg.b localb;
      for (;;)
      {
        if (((localb.itemType == 5) || (localb.itemType == 7)) && (paramLong >= obt.rL) && (!mtg.h(this.this$0)) && (mtg.a(this.this$0) != null))
        {
          mtg.a(this.this$0).sendEmptyMessage(6);
          mtg.f(this.this$0, true);
        }
        if (((localb.itemType == 5) || (localb.itemType == 7)) && (!mtg.i(this.this$0)) && (!mtg.j(this.this$0)) && (knc.b(localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b)) && (mtg.a(this.this$0) != null) && ((!localb.aor) || (mtg.f(localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d))) && (localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b.mShowAdButton))
        {
          int j = ((Integer)knc.a(localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b.mAdExtInfo, "ad_card_show_time", Integer.valueOf(obt.bdY))).intValue() * 1000;
          int i = j;
          if (j < 0) {
            i = obt.bdY * 1000;
          }
          j = i;
          if (mtg.f(localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d))
          {
            j = i;
            if (localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b != null) {
              j = localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b.aGZ * 1000;
            }
          }
          if ((paramLong >= j) && ((!knd.a(localb)) || (mtg.f(localb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d))))
          {
            if (localb.be.getVisibility() == 0) {
              localb.be.setVisibility(8);
            }
            mtg.a(this.this$0).sendEmptyMessage(9);
            mtg.g(this.this$0, true);
          }
        }
        return;
        if (((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
        {
          ((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
          ((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.mz(false);
          ((mtg.b)mtg.a(this.this$0)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.resetState();
        }
      }
    }
    mtg.f(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtm
 * JD-Core Version:    0.7.0.1
 */