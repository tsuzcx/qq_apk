import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;

public class veh
  implements View.OnClickListener
{
  public veh(StructingMsgItemBuilder paramStructingMsgItemBuilder, ImageView paramImageView, ChatMessage paramChatMessage, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (StructingMsgItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder)) {
      return;
    }
    StructingMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, true);
    StructingMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X800631E", "0X800631E", 0, 0, "" + this.jdField_a_of_type_Long, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     veh
 * JD-Core Version:    0.7.0.1
 */