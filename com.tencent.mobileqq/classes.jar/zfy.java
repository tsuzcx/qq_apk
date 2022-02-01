import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;

class zfy
  implements zho
{
  zfy(zfs paramzfs, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    zfs.a(this.jdField_a_of_type_Zfs, null);
    if (zfs.a(this.jdField_a_of_type_Zfs) != null)
    {
      zfs.a(this.jdField_a_of_type_Zfs).b(null);
      if ((zfs.d(this.jdField_a_of_type_Zfs)) && (zfs.b(this.jdField_a_of_type_Zfs) != null)) {
        zfs.b(this.jdField_a_of_type_Zfs).setText(zfs.a(this.jdField_a_of_type_Zfs).a());
      }
      zjz.a().a(zfs.a(this.jdField_a_of_type_Zfs), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply, zfs.a(this.jdField_a_of_type_Zfs).a());
      zfs.a(this.jdField_a_of_type_Zfs).a("");
    }
    if ((zfs.e(this.jdField_a_of_type_Zfs)) && (zfs.a(this.jdField_a_of_type_Zfs) != 0L))
    {
      zfs.a(this.jdField_a_of_type_Zfs, false);
      zfs.d(this.jdField_a_of_type_Zfs, false);
    }
    if (zfs.a(this.jdField_a_of_type_Zfs) != null) {
      zfs.a(this.jdField_a_of_type_Zfs).l();
    }
    if ((this.jdField_a_of_type_Zfs.b != null) && (this.jdField_a_of_type_Zfs.b.getVisibility() == 8)) {
      SimpleEventBus.getInstance().dispatchEvent(new CommentListShowStateEvent(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfy
 * JD-Core Version:    0.7.0.1
 */