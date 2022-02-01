import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;

public class zit
  extends zal
{
  private String a;
  
  public zit(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(zar paramzar)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.a, null);
    paramzar = new ziu(this, paramzar);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.getInstance().sendRequest(localSubscribePersonalDetailRequest, paramzar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zit
 * JD-Core Version:    0.7.0.1
 */