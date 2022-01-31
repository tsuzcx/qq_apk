import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.requests.QCircleDeleteFeedRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;

class tta
  implements DialogInterface.OnClickListener
{
  tta(tsv paramtsv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (!tsv.a(this.a).a.isRecomFd.get()) {
        break label118;
      }
      paramDialogInterface = new FeedCloudMeta.StFeed();
      paramDialogInterface.id.set(tsv.a(this.a).a.recomForward.id.get());
      paramDialogInterface.poster.set(tsv.a(this.a).a.recomForward.poster.get());
    }
    for (;;)
    {
      String str = paramDialogInterface.id.get();
      paramDialogInterface = new QCircleDeleteFeedRequest(paramDialogInterface);
      VSNetworkHelper.a().a(paramDialogInterface, new ttb(this, str));
      return;
      label118:
      paramDialogInterface = tsv.a(this.a).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tta
 * JD-Core Version:    0.7.0.1
 */