import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder;
import com.tencent.mobileqq.data.MessageForLongMsg;

public class dzj
  implements DialogInterface.OnClickListener
{
  public dzj(LongMsgItemBuilder paramLongMsgItemBuilder, MessageForLongMsg paramMessageForLongMsg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(LongMsgItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder), LongMsgItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder), LongMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dzj
 * JD-Core Version:    0.7.0.1
 */