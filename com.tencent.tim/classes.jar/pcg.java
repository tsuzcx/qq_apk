import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StTagInfo;

public class pcg
  extends ryn
{
  private QCircleInitBean a;
  
  public pcg(QCircleInitBean paramQCircleInitBean)
  {
    this.a = paramQCircleInitBean;
  }
  
  public void a(ryt paramryt)
  {
    if ((this.a != null) && (this.a.getTagInfo() != null) && ((!TextUtils.isEmpty(this.a.getTagInfo().tagId.get())) || (!TextUtils.isEmpty(this.a.getTagInfo().tagName.get()))))
    {
      QCircleGetFeedListRequest localQCircleGetFeedListRequest = new QCircleGetFeedListRequest(this.a.getTagInfo().tagId.get(), this.a.getTagInfo().tagName.get(), null);
      paramryt = new pch(this, localQCircleGetFeedListRequest, paramryt);
      localQCircleGetFeedListRequest.setEnableCache(true);
      VSNetworkHelper.a().a(localQCircleGetFeedListRequest, paramryt);
      QLog.d("QCircleTagPreLoaderTask", 1, "QCircleTagPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetFeedListRequest.getCmdName() + "| TraceId:" + localQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + localQCircleGetFeedListRequest.getCurrentSeq());
    }
  }
  
  public void onRemove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcg
 * JD-Core Version:    0.7.0.1
 */