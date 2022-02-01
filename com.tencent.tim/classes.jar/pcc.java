import com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class pcc
  extends ryn
{
  private String TAG = "QCircleFuelInfoPreLoaderTask";
  
  public void a(ryt paramryt)
  {
    if (pbv.a().HL())
    {
      paramryt = new QCircleGetTaskCenterListRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramryt.setEnableCache(true);
      VSNetworkHelper.a().a(paramryt, new pcd(this));
    }
  }
  
  public void onRemove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcc
 * JD-Core Version:    0.7.0.1
 */