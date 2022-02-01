import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zig
  implements View.OnClickListener
{
  public zig(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, zhq paramzhq) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Zhq.a.poster.registerCertifiedAccountUrl.get()))
    {
      zbh.a(this.jdField_a_of_type_Zhq.a.poster.registerCertifiedAccountUrl.get());
      zxp.b(this.jdField_a_of_type_Zhq.a.poster.id.get(), "auth_person", "apply_clk", 0, 0, new String[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zig
 * JD-Core Version:    0.7.0.1
 */