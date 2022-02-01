import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zvm
  implements View.OnClickListener
{
  zvm(zvh paramzvh, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onClick(View paramView)
  {
    zux.b(this.jdField_a_of_type_Zvh.a, zux.a(this.jdField_a_of_type_Zvh.a).a(zux.a(this.jdField_a_of_type_Zvh.a), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
    zux.c(this.jdField_a_of_type_Zvh.a, true);
    zux.a(this.jdField_a_of_type_Zvh.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvm
 * JD-Core Version:    0.7.0.1
 */