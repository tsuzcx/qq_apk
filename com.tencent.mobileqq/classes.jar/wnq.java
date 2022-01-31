import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class wnq
  implements DialogInterface.OnShowListener
{
  wnq(wnl paramwnl, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (wnl.a(this.jdField_a_of_type_Wnl) != null) {
      wnl.a(this.jdField_a_of_type_Wnl).a(paramDialogInterface);
    }
    paramDialogInterface = wsy.a().a(wnl.a(this.jdField_a_of_type_Wnl), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    wnl.a(this.jdField_a_of_type_Wnl).a(paramDialogInterface);
    wpw.a().a(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnq
 * JD-Core Version:    0.7.0.1
 */