import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class zvd
  implements zwt
{
  zvd(zux paramzux, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    zux.a(this.jdField_a_of_type_Zux, null);
    if (zux.a(this.jdField_a_of_type_Zux) != null)
    {
      zux.a(this.jdField_a_of_type_Zux).b(null);
      if ((zux.d(this.jdField_a_of_type_Zux)) && (zux.b(this.jdField_a_of_type_Zux) != null)) {
        zux.b(this.jdField_a_of_type_Zux).setText(zux.a(this.jdField_a_of_type_Zux).a());
      }
      zze.a().a(zux.a(this.jdField_a_of_type_Zux), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply, zux.a(this.jdField_a_of_type_Zux).a());
      zux.a(this.jdField_a_of_type_Zux).a("");
    }
    if ((zux.e(this.jdField_a_of_type_Zux)) && (zux.a(this.jdField_a_of_type_Zux) != 0L))
    {
      zux.a(this.jdField_a_of_type_Zux, false);
      zux.d(this.jdField_a_of_type_Zux, false);
    }
    if (zux.a(this.jdField_a_of_type_Zux) != null) {
      zux.a(this.jdField_a_of_type_Zux).l();
    }
    if ((this.jdField_a_of_type_Zux.b != null) && (this.jdField_a_of_type_Zux.b.getVisibility() == 8)) {
      SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvd
 * JD-Core Version:    0.7.0.1
 */