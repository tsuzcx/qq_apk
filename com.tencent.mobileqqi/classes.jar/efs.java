import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder;
import com.tencent.mobileqq.data.MessageForShakeWindow;

public class efs
  implements DialogInterface.OnClickListener
{
  public efs(ShakeItemBuilder paramShakeItemBuilder, MessageForShakeWindow paramMessageForShakeWindow) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(ShakeItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder), ShakeItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder), ShakeItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShakeWindow.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     efs
 * JD-Core Version:    0.7.0.1
 */