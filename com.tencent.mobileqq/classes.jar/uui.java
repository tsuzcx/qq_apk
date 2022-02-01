import android.content.Context;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import java.util.ArrayList;

final class uui
  implements bkzq
{
  uui(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean, Context paramContext, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().onCurrentMessageDeleted(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        break;
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
      }
    } while (!this.jdField_a_of_type_JavaLangString.equals("2010741172"));
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    if (paramView != null)
    {
      paramView = afuo.a(paramView);
      if (paramView != null)
      {
        paramView = (PAMessage.Item)paramView.items.get(0);
        if (paramView.url != null) {
          uuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.url);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().removeMsgByUniseq(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().onCurrentMessageDeleted(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      break;
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uui
 * JD-Core Version:    0.7.0.1
 */