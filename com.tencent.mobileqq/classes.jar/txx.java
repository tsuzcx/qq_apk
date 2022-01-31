import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;

public class txx
  extends yfn
{
  private String a;
  
  public txx(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(yft paramyft)
  {
    QCircleGetMainPageRequest localQCircleGetMainPageRequest = new QCircleGetMainPageRequest(this.a, null);
    paramyft = new txy(this, paramyft);
    localQCircleGetMainPageRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localQCircleGetMainPageRequest, paramyft);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txx
 * JD-Core Version:    0.7.0.1
 */