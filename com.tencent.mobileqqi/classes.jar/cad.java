import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class cad
  implements ActionSheet.OnButtonClickListener
{
  cad(cac paramcac, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ChatActivityFacade.b(this.jdField_a_of_type_Cac.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Cac.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if (!(this.jdField_a_of_type_Cac.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))
      {
        this.jdField_a_of_type_Cac.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Cac.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
        return;
      }
      ((ChatActivity)this.jdField_a_of_type_Cac.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Cac.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cad
 * JD-Core Version:    0.7.0.1
 */