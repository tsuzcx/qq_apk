import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zgf
  implements View.OnClickListener
{
  zgf(zgc paramzgc, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    zfs.a(this.jdField_a_of_type_Zgc.a, zfs.a(this.jdField_a_of_type_Zgc.a), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, null);
    zfs.a(this.jdField_a_of_type_Zgc.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgf
 * JD-Core Version:    0.7.0.1
 */