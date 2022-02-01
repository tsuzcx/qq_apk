import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zvk
  implements View.OnClickListener
{
  zvk(zvh paramzvh, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    zux.a(this.jdField_a_of_type_Zvh.a, zux.a(this.jdField_a_of_type_Zvh.a), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, null);
    zux.a(this.jdField_a_of_type_Zvh.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvk
 * JD-Core Version:    0.7.0.1
 */