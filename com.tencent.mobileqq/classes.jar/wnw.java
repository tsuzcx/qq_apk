import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;

class wnw
  implements View.OnClickListener
{
  wnw(wns paramwns, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onClick(View paramView)
  {
    paramView = (ClipboardManager)wni.i(this.jdField_a_of_type_Wns.a).getSystemService("clipboard");
    if (paramView != null)
    {
      paramView.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.content.get()));
      wni.a(this.jdField_a_of_type_Wns.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnw
 * JD-Core Version:    0.7.0.1
 */