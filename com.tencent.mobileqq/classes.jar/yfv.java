import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;

public class yfv
  extends yfn
{
  private CertifiedAccountMeta.StFeed a;
  
  public yfv(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
  }
  
  public void a() {}
  
  public void a(yft paramyft)
  {
    GetSubscribeFeedDetailRequest localGetSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(this.a, null);
    paramyft = new yfw(this, paramyft);
    localGetSubscribeFeedDetailRequest.setEnableCache(false);
    VSNetworkHelper.a().a(localGetSubscribeFeedDetailRequest, paramyft);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfv
 * JD-Core Version:    0.7.0.1
 */