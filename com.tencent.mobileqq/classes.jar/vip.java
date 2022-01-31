import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.VideoVipItemBuilder;
import com.tencent.mobileqq.data.MessageForVideoVip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;

public class vip
  implements View.OnClickListener
{
  public vip(VideoVipItemBuilder paramVideoVipItemBuilder, MessageForVideoVip paramMessageForVideoVip, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideoVip.url);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder.a, "CliOper", "", "", "0X80063FF", "0X80063FF", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder.a, "CliOper", "", "", "0X80063EF", "0X80063EF", 14, 0, "", "", "", "");
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 3000) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder.a, "CliOper", "", "", "0X8006400", "0X8006400", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder.a, "CliOper", "", "", "0X80063EF", "0X80063EF", 13, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vip
 * JD-Core Version:    0.7.0.1
 */