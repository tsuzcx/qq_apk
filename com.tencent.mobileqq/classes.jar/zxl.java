import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zxl
  implements View.OnClickListener
{
  public zxl(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, zwv paramzwv) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Zwv.a.poster.registerCertifiedAccountUrl.get()))
    {
      zqm.a(this.jdField_a_of_type_Zwv.a.poster.registerCertifiedAccountUrl.get());
      aanb.b(this.jdField_a_of_type_Zwv.a.poster.id.get(), "auth_person", "apply_clk", 0, 0, new String[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxl
 * JD-Core Version:    0.7.0.1
 */