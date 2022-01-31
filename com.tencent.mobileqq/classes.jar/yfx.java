import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;

public class yfx
  extends yfn
{
  private String a;
  
  public yfx(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(yft paramyft)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.a, null);
    paramyft = new yfy(this, paramyft);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, paramyft);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfx
 * JD-Core Version:    0.7.0.1
 */