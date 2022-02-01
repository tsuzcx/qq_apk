import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;

public class sft
  extends ryn
{
  private CertifiedAccountMeta.StFeed mFeed;
  
  public sft(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
  }
  
  public void a(ryt paramryt)
  {
    GetSubscribeFeedDetailRequest localGetSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(this.mFeed, null);
    paramryt = new sfu(this, paramryt);
    localGetSubscribeFeedDetailRequest.setEnableCache(false);
    VSNetworkHelper.a().a(localGetSubscribeFeedDetailRequest, paramryt);
  }
  
  public void onRemove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sft
 * JD-Core Version:    0.7.0.1
 */