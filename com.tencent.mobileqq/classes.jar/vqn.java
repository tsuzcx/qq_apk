import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;

public class vqn
  extends zzj
{
  private String a;
  
  public vqn(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(zzp paramzzp)
  {
    QCircleGetMainPageRequest localQCircleGetMainPageRequest = new QCircleGetMainPageRequest(this.a, null);
    paramzzp = new vqo(this, localQCircleGetMainPageRequest, paramzzp);
    localQCircleGetMainPageRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localQCircleGetMainPageRequest, paramzzp);
    QLog.d("QCirclePersonalDetailPreLoaderTask", 1, "QCirclePersonalDetailPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetMainPageRequest.getCmdName() + "| TraceId:" + localQCircleGetMainPageRequest.getTraceId() + " | SeqId:" + localQCircleGetMainPageRequest.getCurrentSeq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqn
 * JD-Core Version:    0.7.0.1
 */