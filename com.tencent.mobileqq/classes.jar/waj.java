import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;

class waj
  implements View.OnClickListener
{
  waj(wai paramwai, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    paramView = (ClipboardManager)vzz.c(this.jdField_a_of_type_Wai.a).getSystemService("clipboard");
    if (paramView != null)
    {
      paramView.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.content.get()));
      vzz.a(this.jdField_a_of_type_Wai.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     waj
 * JD-Core Version:    0.7.0.1
 */