import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

class sbh
  implements shk.c
{
  sbh(sbf paramsbf, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void g(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      sqn.c(this.d.poster.id.get(), "auth_follow", "clk_unfollow", 0, 0, new String[0]);
      paramString = this.c.getDataList().iterator();
      while (paramString.hasNext()) {
        if (TextUtils.equals(((CertifiedAccountMeta.StFeed)paramString.next()).poster.id.get(), this.d.poster.id.get())) {
          paramString.remove();
        }
      }
      this.c.notifyDataSetChanged();
      QQToast.a(sbf.a(this.c), 2, acfp.m(2131691359), 0).show();
      if (this.c.getDataList().size() < 5) {
        this.c.onRefreshData();
      }
    }
    if (paramBoolean2) {
      sqn.c(this.d.poster.id.get(), "auth_follow", "clk_cancel", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbh
 * JD-Core Version:    0.7.0.1
 */