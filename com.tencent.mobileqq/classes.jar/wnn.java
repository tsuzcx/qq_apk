import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class wnn
  implements DialogInterface.OnShowListener
{
  wnn(wni paramwni, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (wni.a(this.jdField_a_of_type_Wni) != null) {
      wni.a(this.jdField_a_of_type_Wni).a(paramDialogInterface);
    }
    paramDialogInterface = wsv.a().a(wni.a(this.jdField_a_of_type_Wni), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    wni.a(this.jdField_a_of_type_Wni).a(paramDialogInterface);
    wpt.a().a(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnn
 * JD-Core Version:    0.7.0.1
 */