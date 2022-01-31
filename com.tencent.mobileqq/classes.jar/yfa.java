import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;
import com.tencent.mobileqq.pb.PBStringField;

public class yfa
  implements ydr<xzz>
{
  public yfa(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(yeb paramyeb, xzz paramxzz)
  {
    if ((paramyeb.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramyeb = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramyeb.b());
      VSNetworkHelper.a().a(paramyeb, new yfb(this, paramxzz));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfa
 * JD-Core Version:    0.7.0.1
 */