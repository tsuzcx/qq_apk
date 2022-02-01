import android.text.TextUtils;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StTagInfo;

public class vta
  extends aadf
{
  private QCircleInitBean a;
  private boolean b;
  
  public vta(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    this.a = paramQCircleInitBean;
    this.b = paramBoolean;
  }
  
  public void a() {}
  
  public void a(aadl paramaadl)
  {
    QCircleGetFeedListRequest localQCircleGetFeedListRequest;
    if ((this.a != null) && (this.a.getTagInfo() != null) && ((!TextUtils.isEmpty(this.a.getTagInfo().tagId.get())) || (!TextUtils.isEmpty(this.a.getTagInfo().tagName.get()))))
    {
      localQCircleGetFeedListRequest = new QCircleGetFeedListRequest(this.a.getTagInfo().tagId.get(), this.a.getTagInfo().tagName.get(), this.b, null, null);
      paramaadl = new vtb(this, localQCircleGetFeedListRequest, paramaadl);
      if (!this.b) {
        break label179;
      }
      localQCircleGetFeedListRequest.setEnableCache(false);
    }
    for (;;)
    {
      VSNetworkHelper.a().a(localQCircleGetFeedListRequest, paramaadl);
      QLog.d("QCircleTagPreLoaderTask", 1, "QCircleTagPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetFeedListRequest.getCmdName() + "| TraceId:" + localQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + localQCircleGetFeedListRequest.getCurrentSeq());
      return;
      label179:
      localQCircleGetFeedListRequest.setEnableCache(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vta
 * JD-Core Version:    0.7.0.1
 */