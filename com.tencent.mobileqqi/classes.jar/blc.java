import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public final class blc
  implements ActionSheet.OnButtonClickListener
{
  public blc(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean, Context paramContext, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        break;
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
      }
    } while (!this.jdField_a_of_type_JavaLangString.equals("2010741172"));
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    if (paramView != null)
    {
      paramView = XMLMessageUtils.a(paramView);
      if (paramView != null)
      {
        paramView = (PAMessage.Item)paramView.items.get(0);
        if (paramView.url != null) {
          PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.url);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      break;
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blc
 * JD-Core Version:    0.7.0.1
 */