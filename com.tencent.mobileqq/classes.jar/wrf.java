import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;

public class wrf
  extends wqx
{
  private CertifiedAccountMeta.StFeed a;
  
  public wrf(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
  }
  
  public void a() {}
  
  public void a(wrd paramwrd)
  {
    GetSubscribeFeedDetailRequest localGetSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(this.a, null);
    paramwrd = new wrg(this, paramwrd);
    localGetSubscribeFeedDetailRequest.setEnableCache(false);
    VSNetworkHelper.a().a(localGetSubscribeFeedDetailRequest, paramwrd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrf
 * JD-Core Version:    0.7.0.1
 */