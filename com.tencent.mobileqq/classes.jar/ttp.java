import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.requests.QCircleDeleteFeedRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;

class ttp
  implements DialogInterface.OnClickListener
{
  ttp(ttl paramttl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (!ttl.a(this.a).a.isRecomFd.get()) {
        break label118;
      }
      paramDialogInterface = new FeedCloudMeta.StFeed();
      paramDialogInterface.id.set(ttl.a(this.a).a.recomForward.id.get());
      paramDialogInterface.poster.set(ttl.a(this.a).a.recomForward.poster.get());
    }
    for (;;)
    {
      String str = paramDialogInterface.id.get();
      paramDialogInterface = new QCircleDeleteFeedRequest(paramDialogInterface);
      VSNetworkHelper.a().a(paramDialogInterface, new ttq(this, str));
      return;
      label118:
      paramDialogInterface = ttl.a(this.a).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttp
 * JD-Core Version:    0.7.0.1
 */