import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;
import com.tencent.mobileqq.pb.PBStringField;

public class yjn
  implements yia<yei>
{
  public yjn(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(yii paramyii, yei paramyei)
  {
    if ((paramyii.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramyii = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramyii.b());
      VSNetworkHelper.a().a(paramyii, new yjo(this, paramyei));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yjn
 * JD-Core Version:    0.7.0.1
 */