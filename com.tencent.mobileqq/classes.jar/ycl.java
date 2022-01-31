import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;

class ycl
  implements View.OnClickListener
{
  ycl(ych paramych, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onClick(View paramView)
  {
    paramView = (ClipboardManager)ybx.i(this.jdField_a_of_type_Ych.a).getSystemService("clipboard");
    if (paramView != null)
    {
      paramView.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.content.get()));
      ybx.a(this.jdField_a_of_type_Ych.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ycl
 * JD-Core Version:    0.7.0.1
 */