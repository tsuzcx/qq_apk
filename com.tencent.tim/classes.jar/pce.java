import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;

public class pce
  extends ryn
{
  private String mUserId;
  
  public pce(String paramString)
  {
    this.mUserId = paramString;
  }
  
  public void a(ryt paramryt)
  {
    QCircleGetMainPageRequest localQCircleGetMainPageRequest = new QCircleGetMainPageRequest(this.mUserId, null);
    paramryt = new pcf(this, localQCircleGetMainPageRequest, paramryt);
    localQCircleGetMainPageRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localQCircleGetMainPageRequest, paramryt);
    QLog.d("QCirclePersonalDetailPreLoaderTask", 1, "QCirclePersonalDetailPreLoaderTask->sendQCircleRequest: CmdName:" + localQCircleGetMainPageRequest.getCmdName() + "| TraceId:" + localQCircleGetMainPageRequest.getTraceId() + " | SeqId:" + localQCircleGetMainPageRequest.getCurrentSeq());
  }
  
  public void onRemove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pce
 * JD-Core Version:    0.7.0.1
 */