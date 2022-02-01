import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class zvc
  implements DialogInterface.OnShowListener
{
  zvc(zux paramzux, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (zux.a(this.jdField_a_of_type_Zux) != null) {
      zux.a(this.jdField_a_of_type_Zux).a(paramDialogInterface);
    }
    paramDialogInterface = zze.a().a(zux.a(this.jdField_a_of_type_Zux), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    zux.a(this.jdField_a_of_type_Zux).a(paramDialogInterface);
    SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvc
 * JD-Core Version:    0.7.0.1
 */