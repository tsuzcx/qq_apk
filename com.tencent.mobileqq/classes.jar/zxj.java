import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;

public class zxj
  implements zow<zsx>
{
  public zxj(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(zoz paramzoz, zsx paramzsx)
  {
    if ((paramzoz.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramzoz = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramzoz.b());
      VSNetworkHelper.getInstance().sendRequest(paramzoz, new zxk(this, paramzsx));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxj
 * JD-Core Version:    0.7.0.1
 */