import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class ygl
  implements DialogInterface.OnShowListener
{
  ygl(ygg paramygg, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (ygg.a(this.jdField_a_of_type_Ygg) != null) {
      ygg.a(this.jdField_a_of_type_Ygg).a(paramDialogInterface);
    }
    paramDialogInterface = yma.a().a(ygg.a(this.jdField_a_of_type_Ygg), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    ygg.a(this.jdField_a_of_type_Ygg).a(paramDialogInterface);
    yiw.a().a(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygl
 * JD-Core Version:    0.7.0.1
 */