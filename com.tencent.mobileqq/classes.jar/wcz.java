import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;
import com.tencent.mobileqq.pb.PBStringField;

public class wcz
  implements wbr<vya>
{
  public wcz(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(wca paramwca, vya paramvya)
  {
    if ((paramwca.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramwca = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramwca.a());
      VSNetworkHelper.a().a(paramwca, new wda(this, paramvya));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wcz
 * JD-Core Version:    0.7.0.1
 */