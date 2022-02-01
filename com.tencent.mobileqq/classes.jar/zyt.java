import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.DoTipOffRequest;

final class zyt
  implements bkzq
{
  zyt(CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, zyw paramzyw, zyv paramzyv, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      paramView = new DoTipOffRequest(0, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, 2);
      VSNetworkHelper.getInstance().sendRequest(paramView, new zyu(this));
      if (this.jdField_a_of_type_Zyv != null) {
        this.jdField_a_of_type_Zyv.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyt
 * JD-Core Version:    0.7.0.1
 */