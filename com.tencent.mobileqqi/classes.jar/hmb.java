import com.tencent.open.base.LogUtility;
import com.tencent.open.business.viareport.ReportManager;

public class hmb
  implements Runnable
{
  public hmb(ReportManager paramReportManager, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.a) {
      LogUtility.b("viareport", "isUploading ---return");
    }
    while (!this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.a(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenBusinessViareportReportManager.a(this.jdField_a_of_type_JavaLangString, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hmb
 * JD-Core Version:    0.7.0.1
 */