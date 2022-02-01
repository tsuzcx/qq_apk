import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;

public class zir
  extends zal
{
  private CertifiedAccountMeta.StFeed a;
  
  public zir(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
  }
  
  public void a() {}
  
  public void a(zar paramzar)
  {
    GetSubscribeFeedDetailRequest localGetSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(this.a, null);
    paramzar = new zis(this, paramzar);
    localGetSubscribeFeedDetailRequest.setEnableCache(false);
    VSNetworkHelper.getInstance().sendRequest(localGetSubscribeFeedDetailRequest, paramzar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zir
 * JD-Core Version:    0.7.0.1
 */