import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uan
  implements View.OnClickListener
{
  uan(uam paramuam, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp) {}
  
  public void onClick(View paramView)
  {
    ServiceAccountFolderActivityNew.b(this.jdField_a_of_type_Uam.a, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uan
 * JD-Core Version:    0.7.0.1
 */