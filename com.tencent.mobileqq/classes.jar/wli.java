import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;

class wli
  implements wth
{
  wli(wlg paramwlg, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      xhb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "clk_unfollow", 0, 0, new String[0]);
      paramString = this.jdField_a_of_type_Wlg.b().iterator();
      while (paramString.hasNext()) {
        if (TextUtils.equals(((CertifiedAccountMeta.StFeed)paramString.next()).poster.id.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get())) {
          paramString.remove();
        }
      }
      this.jdField_a_of_type_Wlg.notifyDataSetChanged();
      bcql.a(wlg.a(this.jdField_a_of_type_Wlg), 2, ajya.a(2131690663), 0).a();
      if (this.jdField_a_of_type_Wlg.b().size() < 5) {
        this.jdField_a_of_type_Wlg.o();
      }
    }
    if (paramBoolean2) {
      xhb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_follow", "clk_cancel", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wli
 * JD-Core Version:    0.7.0.1
 */