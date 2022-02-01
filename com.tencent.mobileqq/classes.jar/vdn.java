import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.requests.QCircleDeleteFeedRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;

class vdn
  implements DialogInterface.OnClickListener
{
  vdn(vde paramvde) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (!vde.a(this.a).a.isRecomFd.get()) {
        break label118;
      }
      paramDialogInterface = new FeedCloudMeta.StFeed();
      paramDialogInterface.id.set(vde.a(this.a).a.recomForward.id.get());
      paramDialogInterface.poster.set(vde.a(this.a).a.recomForward.poster.get());
    }
    for (;;)
    {
      String str = paramDialogInterface.id.get();
      paramDialogInterface = new QCircleDeleteFeedRequest(paramDialogInterface);
      VSNetworkHelper.a().a(paramDialogInterface, new vdo(this, str));
      return;
      label118:
      paramDialogInterface = vde.a(this.a).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdn
 * JD-Core Version:    0.7.0.1
 */