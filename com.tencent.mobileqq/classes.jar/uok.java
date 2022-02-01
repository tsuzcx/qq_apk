import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uok
  implements View.OnClickListener
{
  uok(uoj paramuoj, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp) {}
  
  public void onClick(View paramView)
  {
    ServiceAccountFolderActivityNew.b(this.jdField_a_of_type_Uoj.a, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uok
 * JD-Core Version:    0.7.0.1
 */