import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.ToastStyleDialog;

public class zx
  implements Runnable
{
  public zx(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362980));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      }
    }
    while (((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zx
 * JD-Core Version:    0.7.0.1
 */