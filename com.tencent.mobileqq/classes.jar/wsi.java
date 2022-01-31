import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import com.tencent.biz.subscribe.network.DoTipOffRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;

final class wsi
  implements bfph
{
  wsi(CertifiedAccountMeta.StUser paramStUser, CertifiedAccountMeta.StFeed paramStFeed, wsn paramwsn, wsm paramwsm, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfpc.dismiss();
      return;
      paramView = new DoTipOffRequest(0, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, 2);
      VSNetworkHelper.a().a(paramView, new wsj(this));
      if (this.jdField_a_of_type_Wsm != null) {
        this.jdField_a_of_type_Wsm.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsi
 * JD-Core Version:    0.7.0.1
 */