import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class sdb
  implements DialogInterface.OnShowListener
{
  sdb(scw paramscw, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (scw.a(this.this$0) != null) {
      scw.a(this.this$0).a(paramDialogInterface);
    }
    paramDialogInterface = shf.a().c(scw.a(this.this$0), this.jdField_e_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_e_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply);
    scw.a(this.this$0).setText(paramDialogInterface);
    rwv.a().a(new CommentListShowStateEvent(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdb
 * JD-Core Version:    0.7.0.1
 */