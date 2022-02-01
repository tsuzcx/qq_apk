import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sdh
  implements View.OnClickListener
{
  sdh(scw.d paramd, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void onClick(View paramView)
  {
    scw.b(this.b.this$0, scw.a(this.b.this$0).a(scw.a(this.b.this$0), this.jdField_f_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_f_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
    scw.c(this.b.this$0, true);
    scw.a(this.b.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdh
 * JD-Core Version:    0.7.0.1
 */