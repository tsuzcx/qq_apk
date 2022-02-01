import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zge
  implements View.OnClickListener
{
  zge(zgc paramzgc, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    if (zfs.a(this.jdField_a_of_type_Zgc.a) != null)
    {
      zfs.a(this.jdField_a_of_type_Zgc.a, zfs.a(this.jdField_a_of_type_Zgc.a).a(zfs.a(this.jdField_a_of_type_Zgc.a), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      zfs.c(this.jdField_a_of_type_Zgc.a, true);
    }
    zfs.a(this.jdField_a_of_type_Zgc.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zge
 * JD-Core Version:    0.7.0.1
 */