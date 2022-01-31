import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class tzh
  extends yka
{
  private String a = "QCircleFuelInfoPreLoaderTask";
  
  public void a() {}
  
  public void a(ykg paramykg)
  {
    if (tyz.a().a())
    {
      paramykg = new QCircleGetTaskCenterListRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramykg.setEnableCache(true);
      VSNetworkHelper.a().a(paramykg, new tzi(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzh
 * JD-Core Version:    0.7.0.1
 */