import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.LocationItemBuilder;
import com.tencent.mobileqq.data.MessageForText;

public class uxj
  implements DialogInterface.OnClickListener
{
  public uxj(LocationItemBuilder paramLocationItemBuilder, MessageForText paramMessageForText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForText);
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxj
 * JD-Core Version:    0.7.0.1
 */