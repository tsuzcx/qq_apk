import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class etx
  implements View.OnClickListener
{
  public etx(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_b_of_type_Boolean) {
      ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.finish();
      return;
      ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     etx
 * JD-Core Version:    0.7.0.1
 */