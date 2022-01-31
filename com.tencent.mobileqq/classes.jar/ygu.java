import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;

class ygu
  implements View.OnClickListener
{
  ygu(ygq paramygq, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onClick(View paramView)
  {
    paramView = (ClipboardManager)ygg.i(this.jdField_a_of_type_Ygq.a).getSystemService("clipboard");
    if (paramView != null)
    {
      paramView.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.content.get()));
      ygg.a(this.jdField_a_of_type_Ygq.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygu
 * JD-Core Version:    0.7.0.1
 */