import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class wno
  implements wnh
{
  wno(wni paramwni, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    wni.a(this.jdField_a_of_type_Wni, null);
    if (wni.a(this.jdField_a_of_type_Wni) != null)
    {
      wni.a(this.jdField_a_of_type_Wni).b(null);
      if ((wni.d(this.jdField_a_of_type_Wni)) && (wni.b(this.jdField_a_of_type_Wni) != null)) {
        wni.b(this.jdField_a_of_type_Wni).setText(wni.a(this.jdField_a_of_type_Wni).a());
      }
      wsv.a().a(wni.a(this.jdField_a_of_type_Wni), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply, wni.a(this.jdField_a_of_type_Wni).a());
      wni.a(this.jdField_a_of_type_Wni).a("");
    }
    if ((wni.e(this.jdField_a_of_type_Wni)) && (wni.a(this.jdField_a_of_type_Wni) != 0L))
    {
      wni.a(this.jdField_a_of_type_Wni, false);
      wni.d(this.jdField_a_of_type_Wni, false);
    }
    if (wni.a(this.jdField_a_of_type_Wni) != null) {
      wni.a(this.jdField_a_of_type_Wni).j();
    }
    if ((this.jdField_a_of_type_Wni.b != null) && (this.jdField_a_of_type_Wni.b.getVisibility() == 8)) {
      wpt.a().a(new CommentListShowStateEvent(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wno
 * JD-Core Version:    0.7.0.1
 */