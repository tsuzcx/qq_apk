import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

class vdi
  implements DialogInterface.OnClickListener
{
  vdi(vde paramvde) {}
  
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
      ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(vde.a(this.a).a.busiData.get().toByteArray());
      localObject = ((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList;
      paramDialogInterface = (DialogInterface)localObject;
    }
    catch (Exception localException)
    {
      label46:
      break label46;
    }
    paramDialogInterface = new QCircleDoRecommendRequest(vde.a(this.a).a, 0, paramDialogInterface, 1);
    VSNetworkHelper.a().a(paramDialogInterface, new vdj(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdi
 * JD-Core Version:    0.7.0.1
 */