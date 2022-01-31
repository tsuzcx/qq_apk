import android.os.Handler;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class bdr
  implements AsyncBack
{
  int jdField_a_of_type_Int = 0;
  
  public bdr(QQMapActivity paramQQMapActivity) {}
  
  public void a(int paramInt)
  {
    if (paramInt - this.jdField_a_of_type_Int >= 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.a.post(new bds(this, paramInt));
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.a.post(new bdt(this));
      ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_tx_download", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.a.post(new bdu(this));
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_tx_download", 0, 1, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bdr
 * JD-Core Version:    0.7.0.1
 */