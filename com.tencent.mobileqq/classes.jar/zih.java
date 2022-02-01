import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zih
  implements View.OnClickListener
{
  public zih(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, zhq paramzhq) {}
  
  public void onClick(View paramView)
  {
    zbh.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", this.jdField_a_of_type_Zhq.a.poster.id.get()));
    zxp.b(this.jdField_a_of_type_Zhq.a.poster.id.get(), "auth_person", "sync_qzone", 0, 0, new String[0]);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zih
 * JD-Core Version:    0.7.0.1
 */