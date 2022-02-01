import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class zfx
  implements DialogInterface.OnShowListener
{
  zfx(zfs paramzfs, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (zfs.a(this.jdField_a_of_type_Zfs) != null) {
      zfs.a(this.jdField_a_of_type_Zfs).a(paramDialogInterface);
    }
    paramDialogInterface = zjz.a().a(zfs.a(this.jdField_a_of_type_Zfs), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    zfs.a(this.jdField_a_of_type_Zfs).a(paramDialogInterface);
    SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfx
 * JD-Core Version:    0.7.0.1
 */