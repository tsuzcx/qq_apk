import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.DoTipOffRequest;

final class sgu
  implements ausj.a
{
  sgu(CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, sgs.b paramb, sgs.a parama, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      paramView = new DoTipOffRequest(0, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser, this.e, 2);
      VSNetworkHelper.a().a(paramView, new sgv(this));
      if (this.jdField_a_of_type_Sgs$a != null) {
        this.jdField_a_of_type_Sgs$a.ut(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgu
 * JD-Core Version:    0.7.0.1
 */