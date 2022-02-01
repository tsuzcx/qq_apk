import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class sdc
  implements peo.b
{
  sdc(scw paramscw, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onDismiss()
  {
    scw.a(this.this$0, null);
    if (scw.a(this.this$0) != null)
    {
      scw.a(this.this$0).qG(null);
      if ((scw.d(this.this$0)) && (scw.b(this.this$0) != null)) {
        scw.b(this.this$0).setText(scw.a(this.this$0).getText());
      }
      shf.a().a(scw.a(this.this$0), this.jdField_e_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_e_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply, scw.a(this.this$0).getText());
      scw.a(this.this$0).setText("");
    }
    if ((scw.e(this.this$0)) && (scw.a(this.this$0) != 0L))
    {
      scw.a(this.this$0, false);
      scw.d(this.this$0, false);
    }
    if (scw.a(this.this$0) != null) {
      scw.a(this.this$0).bxM();
    }
    if ((this.this$0.mCommentContainer != null) && (this.this$0.mCommentContainer.getVisibility() == 8)) {
      rwv.a().a(new CommentListShowStateEvent(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdc
 * JD-Core Version:    0.7.0.1
 */