import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StTagInfo;

public class tzl
  extends yka
{
  private QCircleInitBean a;
  
  public tzl(QCircleInitBean paramQCircleInitBean)
  {
    this.a = paramQCircleInitBean;
  }
  
  public void a() {}
  
  public void a(ykg paramykg)
  {
    if ((this.a != null) && (this.a.getTagInfo() != null) && ((!TextUtils.isEmpty(this.a.getTagInfo().tagId.get())) || (!TextUtils.isEmpty(this.a.getTagInfo().tagName.get()))))
    {
      QCircleGetFeedListRequest localQCircleGetFeedListRequest = new QCircleGetFeedListRequest(this.a.getTagInfo().tagId.get(), this.a.getTagInfo().tagName.get(), null);
      paramykg = new tzm(this, localQCircleGetFeedListRequest, paramykg);
      localQCircleGetFeedListRequest.setEnableCache(true);
      VSNetworkHelper.a().a(localQCircleGetFeedListRequest, paramykg);
      QLog.d("QCircleTagPreLoaderTask", 1, "QCircleTagPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetFeedListRequest.getCmdName() + "| TraceId:" + localQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + localQCircleGetFeedListRequest.getCurrentSeq());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzl
 * JD-Core Version:    0.7.0.1
 */