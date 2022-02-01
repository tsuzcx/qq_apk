import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;

public class zxy
  extends zpq
{
  private String a;
  
  public zxy(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(zpw paramzpw)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.a, null);
    paramzpw = new zxz(this, paramzpw);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.getInstance().sendRequest(localSubscribePersonalDetailRequest, paramzpw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxy
 * JD-Core Version:    0.7.0.1
 */