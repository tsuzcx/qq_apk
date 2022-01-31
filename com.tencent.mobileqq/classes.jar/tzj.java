import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;

public class tzj
  extends yka
{
  private String a;
  
  public tzj(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(ykg paramykg)
  {
    QCircleGetMainPageRequest localQCircleGetMainPageRequest = new QCircleGetMainPageRequest(this.a, null);
    paramykg = new tzk(this, localQCircleGetMainPageRequest, paramykg);
    localQCircleGetMainPageRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localQCircleGetMainPageRequest, paramykg);
    QLog.d("QCirclePersonalDetailPreLoaderTask", 1, "QCirclePersonalDetailPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetMainPageRequest.getCmdName() + "| TraceId:" + localQCircleGetMainPageRequest.getTraceId() + " | SeqId:" + localQCircleGetMainPageRequest.getCurrentSeq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzj
 * JD-Core Version:    0.7.0.1
 */