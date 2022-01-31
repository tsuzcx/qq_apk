import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class wad
  implements DialogInterface.OnShowListener
{
  wad(vzz paramvzz, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (vzz.a(this.jdField_a_of_type_Vzz) != null) {
      vzz.a(this.jdField_a_of_type_Vzz).a(paramDialogInterface);
    }
    paramDialogInterface = weh.a().a(vzz.a(this.jdField_a_of_type_Vzz), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    vzz.a(this.jdField_a_of_type_Vzz).a(paramDialogInterface);
    wcj.a().a(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wad
 * JD-Core Version:    0.7.0.1
 */