import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;

public class ykk
  extends yka
{
  private String a;
  
  public ykk(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(ykg paramykg)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.a, null);
    paramykg = new ykl(this, paramykg);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, paramykg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ykk
 * JD-Core Version:    0.7.0.1
 */