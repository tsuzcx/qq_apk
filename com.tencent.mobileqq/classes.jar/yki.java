import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;

public class yki
  extends yka
{
  private CertifiedAccountMeta.StFeed a;
  
  public yki(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
  }
  
  public void a() {}
  
  public void a(ykg paramykg)
  {
    GetSubscribeFeedDetailRequest localGetSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(this.a, null);
    paramykg = new ykj(this, paramykg);
    localGetSubscribeFeedDetailRequest.setEnableCache(false);
    VSNetworkHelper.a().a(localGetSubscribeFeedDetailRequest, paramykg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yki
 * JD-Core Version:    0.7.0.1
 */