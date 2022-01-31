import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;
import com.tencent.mobileqq.pb.PBStringField;

public class wqn
  implements wpe<wlj>
{
  public wqn(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(wpn paramwpn, wlj paramwlj)
  {
    if ((paramwpn.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramwpn = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramwpn.b());
      VSNetworkHelper.a().a(paramwpn, new wqo(this, paramwlj));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqn
 * JD-Core Version:    0.7.0.1
 */