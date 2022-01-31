import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;

public class vmm
  implements View.OnClickListener
{
  public vmm(StructingMsgItemBuilder paramStructingMsgItemBuilder, TextView paramTextView, ChatMessage paramChatMessage, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (StructingMsgItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder)) {
      return;
    }
    StructingMsgItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, true);
    StructingMsgItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8006512", "0X8006512", 0, 0, "", "" + this.jdField_a_of_type_JavaLangString, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vmm
 * JD-Core Version:    0.7.0.1
 */