import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;
import com.tencent.mobileqq.pb.PBStringField;

public class wqk
  implements wpb<wlg>
{
  public wqk(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(wpk paramwpk, wlg paramwlg)
  {
    if ((paramwpk.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramwpk = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramwpk.b());
      VSNetworkHelper.a().a(paramwpk, new wql(this, paramwlg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqk
 * JD-Core Version:    0.7.0.1
 */