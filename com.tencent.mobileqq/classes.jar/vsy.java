import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;

public class vsy
  extends aadf
{
  private QCirclePolymerizationBean a;
  
  public vsy(QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    this.a = paramQCirclePolymerizationBean;
  }
  
  public void a() {}
  
  public void a(aadl paramaadl)
  {
    if (this.a == null) {
      return;
    }
    QCircleGetFeedListRequest localQCircleGetFeedListRequest = new QCircleGetFeedListRequest(this.a, null, null);
    paramaadl = new vsz(this, localQCircleGetFeedListRequest, paramaadl);
    localQCircleGetFeedListRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localQCircleGetFeedListRequest, paramaadl);
    QLog.d("QCirclePolymerizationPreLoaderTask", 1, "QCirclePolymerizationPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetFeedListRequest.getCmdName() + "| TraceId:" + localQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + localQCircleGetFeedListRequest.getCurrentSeq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsy
 * JD-Core Version:    0.7.0.1
 */