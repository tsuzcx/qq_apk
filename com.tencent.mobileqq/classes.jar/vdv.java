import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

class vdv
  implements DialogInterface.OnClickListener
{
  vdv(vdr paramvdr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VSNetworkHelper.a().a(new QCircleSetUnCareRequest(vdr.a(this.a).id.get(), 1, 1, null), new vdw(this));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdv
 * JD-Core Version:    0.7.0.1
 */