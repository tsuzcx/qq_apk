import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

class vfm
  implements DialogInterface.OnClickListener
{
  vfm(vfi paramvfi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = new QQCircleFeedBase.StFeedBusiReqData();
      paramDialogInterface = null;
    }
    try
    {
      ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(vfi.a(this.a).a.busiData.get().toByteArray());
      localObject = ((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList;
      paramDialogInterface = (DialogInterface)localObject;
    }
    catch (Exception localException)
    {
      label46:
      break label46;
    }
    paramDialogInterface = new QCircleDoRecommendRequest(vfi.a(this.a).a, 0, paramDialogInterface, 1);
    VSNetworkHelper.a().a(paramDialogInterface, new vfn(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfm
 * JD-Core Version:    0.7.0.1
 */