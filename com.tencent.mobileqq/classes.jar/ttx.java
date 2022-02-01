import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ttx
  implements View.OnClickListener
{
  ttx(ttw paramttw, CertifiedAccountMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    aaej.a(this.jdField_a_of_type_Ttw.a, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser);
    abbe.b("auth_follow", "clk_head", 0, 0, new String[0]);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttx
 * JD-Core Version:    0.7.0.1
 */