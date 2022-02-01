import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;

public class zxw
  extends zpq
{
  private CertifiedAccountMeta.StFeed a;
  
  public zxw(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
  }
  
  public void a() {}
  
  public void a(zpw paramzpw)
  {
    GetSubscribeFeedDetailRequest localGetSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(this.a, null);
    paramzpw = new zxx(this, paramzpw);
    localGetSubscribeFeedDetailRequest.setEnableCache(false);
    VSNetworkHelper.getInstance().sendRequest(localGetSubscribeFeedDetailRequest, paramzpw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxw
 * JD-Core Version:    0.7.0.1
 */