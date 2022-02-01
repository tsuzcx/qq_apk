import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment.a;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;

public class seo
  implements rxq.a<sbf>
{
  public seo(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(rxt paramrxt, sbf paramsbf)
  {
    if ((paramrxt.Mi()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramrxt = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramrxt.c());
      VSNetworkHelper.a().a(paramrxt, new sep(this, paramsbf));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     seo
 * JD-Core Version:    0.7.0.1
 */