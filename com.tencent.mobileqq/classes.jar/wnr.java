import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class wnr
  implements wnk
{
  wnr(wnl paramwnl, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    wnl.a(this.jdField_a_of_type_Wnl, null);
    if (wnl.a(this.jdField_a_of_type_Wnl) != null)
    {
      wnl.a(this.jdField_a_of_type_Wnl).b(null);
      if ((wnl.d(this.jdField_a_of_type_Wnl)) && (wnl.b(this.jdField_a_of_type_Wnl) != null)) {
        wnl.b(this.jdField_a_of_type_Wnl).setText(wnl.a(this.jdField_a_of_type_Wnl).a());
      }
      wsy.a().a(wnl.a(this.jdField_a_of_type_Wnl), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply, wnl.a(this.jdField_a_of_type_Wnl).a());
      wnl.a(this.jdField_a_of_type_Wnl).a("");
    }
    if ((wnl.e(this.jdField_a_of_type_Wnl)) && (wnl.a(this.jdField_a_of_type_Wnl) != 0L))
    {
      wnl.a(this.jdField_a_of_type_Wnl, false);
      wnl.d(this.jdField_a_of_type_Wnl, false);
    }
    if (wnl.a(this.jdField_a_of_type_Wnl) != null) {
      wnl.a(this.jdField_a_of_type_Wnl).j();
    }
    if ((this.jdField_a_of_type_Wnl.b != null) && (this.jdField_a_of_type_Wnl.b.getVisibility() == 8)) {
      wpw.a().a(new CommentListShowStateEvent(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnr
 * JD-Core Version:    0.7.0.1
 */