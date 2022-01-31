import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;

public class xcr
  implements Runnable
{
  public xcr(PhotoListActivity paramPhotoListActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064(723, 2, this.jdField_a_of_type_Int);
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
    PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, "aio_sync_qzone", "operation_type", this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcr
 * JD-Core Version:    0.7.0.1
 */