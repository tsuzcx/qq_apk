import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;

public class wrk
  extends wra
{
  private String a;
  
  public wrk(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(wrg paramwrg)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.a, null);
    paramwrg = new wrl(this, paramwrg);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, paramwrg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrk
 * JD-Core Version:    0.7.0.1
 */