import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nyf
  implements View.OnClickListener
{
  nyf(nye paramnye, CertifiedAccountMeta.StUser paramStUser) {}
  
  public void onClick(View paramView)
  {
    rzd.a(this.jdField_a_of_type_Nye.a, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser);
    sqn.d("auth_follow", "clk_head", 0, 0, new String[0]);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyf
 * JD-Core Version:    0.7.0.1
 */