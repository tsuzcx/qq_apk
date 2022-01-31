import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.mobileqq.pb.PBStringField;

public class yjp
  implements View.OnClickListener
{
  public yjp(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment, yiz paramyiz) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Yiz.a.poster.registerCertifiedAccountUrl.get()))
    {
      ybt.a(this.jdField_a_of_type_Yiz.a.poster.registerCertifiedAccountUrl.get());
      zaj.b(this.jdField_a_of_type_Yiz.a.poster.id.get(), "auth_person", "apply_clk", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yjp
 * JD-Core Version:    0.7.0.1
 */