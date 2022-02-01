import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.g;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.liveroom.LiveRoomProxyActivity;

class lpu
  implements View.OnClickListener
{
  lpu(lps paramlps, int paramInt, ndi paramndi, lie paramlie) {}
  
  public void onClick(View paramView)
  {
    if (this.aMg == 120) {
      LiveRoomProxyActivity.open(this.c.getActivity(), this.b.a().mSocialFeedInfo.a.playUrl, "kandian feed click");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ndi.d locald = this.c.a();
      if (locald != null) {
        locald.a(paramView, this.b.a(), 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpu
 * JD-Core Version:    0.7.0.1
 */