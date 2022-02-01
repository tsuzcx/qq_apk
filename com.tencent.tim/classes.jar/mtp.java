import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mtp
  implements View.OnClickListener
{
  mtp(mtg.a parama, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.isAD)
    {
      AdvertisementInfo localAdvertisementInfo = knl.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b);
      knd.a(localAdvertisementInfo, 2005, mtg.a(this.jdField_a_of_type_Mtg$a.this$0));
      mtg.a(this.jdField_a_of_type_Mtg$a.this$0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, localAdvertisementInfo, 2005);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtp
 * JD-Core Version:    0.7.0.1
 */