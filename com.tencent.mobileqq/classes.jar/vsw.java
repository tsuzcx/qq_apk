import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;

public class vsw
  extends aadf
{
  private String a;
  
  public vsw(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(aadl paramaadl)
  {
    QCircleGetMainPageRequest localQCircleGetMainPageRequest = new QCircleGetMainPageRequest(this.a, null);
    paramaadl = new vsx(this, localQCircleGetMainPageRequest, paramaadl);
    localQCircleGetMainPageRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localQCircleGetMainPageRequest, paramaadl);
    QLog.d("QCirclePersonalDetailPreLoaderTask", 1, "QCirclePersonalDetailPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetMainPageRequest.getCmdName() + "| TraceId:" + localQCircleGetMainPageRequest.getTraceId() + " | SeqId:" + localQCircleGetMainPageRequest.getCurrentSeq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsw
 * JD-Core Version:    0.7.0.1
 */