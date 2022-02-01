import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

class zsz
  implements zzq
{
  zsz(zsx paramzsx, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      aanb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "clk_unfollow", 0, 0, new String[0]);
      paramString = this.jdField_a_of_type_Zsx.a().iterator();
      while (paramString.hasNext()) {
        if (TextUtils.equals(((CertifiedAccountMeta.StFeed)paramString.next()).poster.id.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get())) {
          paramString.remove();
        }
      }
      this.jdField_a_of_type_Zsx.notifyDataSetChanged();
      QQToast.a(zsx.a(this.jdField_a_of_type_Zsx), 2, anvx.a(2131690747), 0).a();
      if (this.jdField_a_of_type_Zsx.a().size() < 5) {
        this.jdField_a_of_type_Zsx.a();
      }
    }
    if (paramBoolean2) {
      aanb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "clk_cancel", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsz
 * JD-Core Version:    0.7.0.1
 */