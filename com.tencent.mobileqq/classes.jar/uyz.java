import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class uyz
  implements ActionSheet.OnButtonClickListener
{
  public uyz(MixedMsgItemBuilder paramMixedMsgItemBuilder, MessageForMixedMsg paramMessageForMixedMsg, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      long l;
      do
      {
        return;
        l = SystemClock.uptimeMillis();
      } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.c < 500L);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.c = l;
      paramView = (MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyz
 * JD-Core Version:    0.7.0.1
 */