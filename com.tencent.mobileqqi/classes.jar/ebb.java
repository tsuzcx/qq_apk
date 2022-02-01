import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.data.MessageForText;

public class ebb
  implements DialogInterface.OnClickListener
{
  public ebb(TextItemBuilder paramTextItemBuilder, MessageForText paramMessageForText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(TextItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder), TextItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder), TextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg, this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ebb
 * JD-Core Version:    0.7.0.1
 */