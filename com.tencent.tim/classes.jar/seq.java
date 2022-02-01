import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment.a;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class seq
  implements View.OnClickListener
{
  public seq(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, SubscribeBaseBottomPersonalFragment.a parama) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.b.a.poster.registerCertifiedAccountUrl.get()))
    {
      rzd.sW(this.b.a.poster.registerCertifiedAccountUrl.get());
      sqn.c(this.b.a.poster.id.get(), "auth_person", "apply_clk", 0, 0, new String[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     seq
 * JD-Core Version:    0.7.0.1
 */