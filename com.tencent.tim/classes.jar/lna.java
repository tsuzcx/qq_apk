import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.g;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.liveroom.LiveRoomProxyActivity;

class lna
  implements View.OnClickListener
{
  lna(lmx paramlmx, lie paramlie, ndi paramndi) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.a() != null) && (this.b.a().mSocialFeedInfo != null) && (this.b.a().mSocialFeedInfo.a != null)) {
      LiveRoomProxyActivity.open(this.c.getActivity(), this.b.a().mSocialFeedInfo.a.playUrl, "kandian biu feed click");
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
 * Qualified Name:     lna
 * JD-Core Version:    0.7.0.1
 */