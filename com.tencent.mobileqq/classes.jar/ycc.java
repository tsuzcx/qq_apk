import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class ycc
  implements DialogInterface.OnShowListener
{
  ycc(ybx paramybx, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (ybx.a(this.jdField_a_of_type_Ybx) != null) {
      ybx.a(this.jdField_a_of_type_Ybx).a(paramDialogInterface);
    }
    paramDialogInterface = yhn.a().a(ybx.a(this.jdField_a_of_type_Ybx), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    ybx.a(this.jdField_a_of_type_Ybx).a(paramDialogInterface);
    yej.a().a(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ycc
 * JD-Core Version:    0.7.0.1
 */