import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;

public class wqn
  implements View.OnClickListener
{
  public wqn(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, wpw paramwpw) {}
  
  public void onClick(View paramView)
  {
    wis.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", this.jdField_a_of_type_Wpw.a.poster.id.get()));
    xhb.b(this.jdField_a_of_type_Wpw.a.poster.id.get(), "auth_person", "sync_qzone", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqn
 * JD-Core Version:    0.7.0.1
 */