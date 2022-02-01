import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;

public class zie
  implements yzr<zds>
{
  public zie(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(yzu paramyzu, zds paramzds)
  {
    if ((paramyzu.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramyzu = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramyzu.b());
      VSNetworkHelper.getInstance().sendRequest(paramyzu, new zif(this, paramzds));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zie
 * JD-Core Version:    0.7.0.1
 */