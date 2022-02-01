import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class vql
  extends zzj
{
  private String a = "QCircleFuelInfoPreLoaderTask";
  
  public void a() {}
  
  public void a(zzp paramzzp)
  {
    if (vog.a().a())
    {
      paramzzp = new QCircleGetTaskCenterListRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramzzp.setEnableCache(true);
      VSNetworkHelper.a().a(paramzzp, new vqm(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vql
 * JD-Core Version:    0.7.0.1
 */