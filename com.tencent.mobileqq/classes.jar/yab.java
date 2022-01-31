import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

class yab
  implements yhz
{
  yab(xzz paramxzz, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      yvu.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "clk_unfollow", 0, 0, new String[0]);
      paramString = this.jdField_a_of_type_Xzz.b().iterator();
      while (paramString.hasNext()) {
        if (TextUtils.equals(((CertifiedAccountMeta.StFeed)paramString.next()).poster.id.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get())) {
          paramString.remove();
        }
      }
      this.jdField_a_of_type_Xzz.notifyDataSetChanged();
      QQToast.a(xzz.a(this.jdField_a_of_type_Xzz), 2, alpo.a(2131690715), 0).a();
      if (this.jdField_a_of_type_Xzz.b().size() < 5) {
        this.jdField_a_of_type_Xzz.o();
      }
    }
    if (paramBoolean2) {
      yvu.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "clk_cancel", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yab
 * JD-Core Version:    0.7.0.1
 */