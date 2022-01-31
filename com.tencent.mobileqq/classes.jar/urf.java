import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

public final class urf
  implements ActionSheet.OnDismissListener
{
  public urf(QQAppInterface paramQQAppInterface, int[] paramArrayOfInt) {}
  
  public void onDismiss()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004862", "0X8004862", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ArrayOfInt[3] == 3) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B05", "0X8005B05", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     urf
 * JD-Core Version:    0.7.0.1
 */