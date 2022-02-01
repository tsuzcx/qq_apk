import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class vsu
  extends aadf
{
  private String a = "QCircleFuelInfoPreLoaderTask";
  
  public void a() {}
  
  public void a(aadl paramaadl)
  {
    if ((vqo.a().b()) || (!vqo.a().a()))
    {
      paramaadl = new QCircleGetTaskCenterListRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramaadl.setEnableCache(true);
      VSNetworkHelper.a().a(paramaadl, new vsv(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsu
 * JD-Core Version:    0.7.0.1
 */