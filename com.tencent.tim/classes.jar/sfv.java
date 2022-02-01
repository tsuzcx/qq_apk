import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;

public class sfv
  extends ryn
{
  private String mUserId;
  
  public sfv(String paramString)
  {
    this.mUserId = paramString;
  }
  
  public void a(ryt paramryt)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.mUserId, null);
    paramryt = new sfw(this, paramryt);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, paramryt);
  }
  
  public void onRemove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfv
 * JD-Core Version:    0.7.0.1
 */