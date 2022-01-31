import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class abr
  implements ActionSheet.OnButtonClickListener
{
  abr(abq paramabq, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ChatActivityFacade.b(this.jdField_a_of_type_Abq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Abq.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if (!(this.jdField_a_of_type_Abq.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))
      {
        this.jdField_a_of_type_Abq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Abq.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
        return;
      }
      ((ChatActivity)this.jdField_a_of_type_Abq.jdField_a_of_type_AndroidContentContext).a().a(this.jdField_a_of_type_Abq.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     abr
 * JD-Core Version:    0.7.0.1
 */