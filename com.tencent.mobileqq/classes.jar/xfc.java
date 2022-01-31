import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;

class xfc
  implements View.OnFocusChangeListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  xfc(xfa paramxfa) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      GoldMsgAioState.a(this.jdField_a_of_type_Xfa.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldMsgSettingActivity.getWindow(), this.jdField_a_of_type_Xfa.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldMsgSettingActivity, paramView);
    }
    do
    {
      return;
      this.jdField_a_of_type_Xfa.c = true;
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Xfa.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_Xfa.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Xfa.jdField_a_of_type_AndroidTextTextWatcher);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfc
 * JD-Core Version:    0.7.0.1
 */