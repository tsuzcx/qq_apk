import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.requests.QCircleDeleteFeedRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;

class oxm
  implements DialogInterface.OnClickListener
{
  oxm(oxh paramoxh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (!oxh.a(this.this$0).feed.isRecomFd.get()) {
        break label118;
      }
      paramDialogInterface = new FeedCloudMeta.StFeed();
      paramDialogInterface.id.set(oxh.a(this.this$0).feed.recomForward.id.get());
      paramDialogInterface.poster.set(oxh.a(this.this$0).feed.recomForward.poster.get());
    }
    for (;;)
    {
      String str = paramDialogInterface.id.get();
      paramDialogInterface = new QCircleDeleteFeedRequest(paramDialogInterface);
      VSNetworkHelper.a().a(paramDialogInterface, new oxn(this, str));
      return;
      label118:
      paramDialogInterface = oxh.a(this.this$0).feed;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxm
 * JD-Core Version:    0.7.0.1
 */