import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class xtf
  implements View.OnClickListener
{
  xtf(xtd paramxtd, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Xtd.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Xtd.a.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_Xtd.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this.jdField_a_of_type_Xtd.a.b);
    this.jdField_a_of_type_Xtd.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Xtd.a.jdField_c_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_Xtd.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramView = (SimpleAccount)this.jdField_a_of_type_Xtd.a.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Xtd.a.jdField_a_of_type_Int);
    ImageView localImageView;
    if (!LoginView.c(this.jdField_a_of_type_Xtd.a))
    {
      LoginView.c(this.jdField_a_of_type_Xtd.a, true);
      this.jdField_a_of_type_Xtd.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localImageView = this.jdField_a_of_type_Xtd.a.jdField_c_of_type_AndroidWidgetImageView;
      if ((!LoginView.d(this.jdField_a_of_type_Xtd.a)) && (!LoginView.e(this.jdField_a_of_type_Xtd.a)) && (!LoginView.b(this.jdField_a_of_type_Xtd.a))) {
        break label365;
      }
    }
    label365:
    for (int i = 2130843934;; i = 2130842110)
    {
      localImageView.setImageResource(i);
      this.jdField_a_of_type_Xtd.a.jdField_c_of_type_AndroidWidgetImageView.setContentDescription("隐藏密码");
      LoginView.a(this.jdField_a_of_type_Xtd.a, paramView);
      this.jdField_a_of_type_Xtd.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Xtd.a.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_Xtd.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.jdField_a_of_type_Xtd.a.b);
      this.jdField_a_of_type_Xtd.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_Xtd.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Xtd.a.jdField_c_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_Xtd.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
      this.jdField_a_of_type_Xtd.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_Xtd.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a().setVisibility(8);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtf
 * JD-Core Version:    0.7.0.1
 */