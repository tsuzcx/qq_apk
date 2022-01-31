import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;

public class wqp
  implements View.OnClickListener
{
  public wqp(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, wpz paramwpz) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Wpz.a.poster.registerCertifiedAccountUrl.get()))
    {
      wiv.a(this.jdField_a_of_type_Wpz.a.poster.registerCertifiedAccountUrl.get());
      xhe.b(this.jdField_a_of_type_Wpz.a.poster.id.get(), "auth_person", "apply_clk", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqp
 * JD-Core Version:    0.7.0.1
 */