import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;

public class wrh
  extends wqx
{
  private String a;
  
  public wrh(String paramString)
  {
    this.a = paramString;
  }
  
  public void a() {}
  
  public void a(wrd paramwrd)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.a, null);
    paramwrd = new wri(this, paramwrd);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, paramwrd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrh
 * JD-Core Version:    0.7.0.1
 */