import android.text.Editable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qphone.base.util.QLog;

public class aanf
  implements View.OnFocusChangeListener
{
  public aanf(LoginView paramLoginView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView) {
      if (true == paramBoolean)
      {
        this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setSelection(this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.length());
        if (this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.isPopupShowing()) {
          this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.dismissDropDown();
        }
        if ((this.this$0.pj != null) && (this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length() > 0)) {
          this.this$0.pj.setVisibility(0);
        }
        this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setSelection(this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length());
        if (!aamp.h(aamp.dg)) {}
      }
    }
    while (paramView != this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText)
    {
      return;
      if ((LoginView.a(this.this$0).isActive(this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView)) && (QLog.isColorLevel())) {
        QLog.d("InputMethodRelativeLayout", 2, "isActive(mAutoTextAccount)");
      }
      this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHint("");
      return;
      if ((this.this$0.pj != null) && (this.this$0.pj.isShown())) {
        this.this$0.pj.setVisibility(8);
      }
      paramView = new SpannableString(acfp.m(2131709110));
      paramView.setSpan(new AbsoluteSizeSpan(17, true), 0, paramView.length(), 33);
      this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHint(paramView);
      return;
    }
    if (true == paramBoolean)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().length());
      this.this$0.qX.setVisibility(0);
      if (LoginView.a(this.this$0).isActive(this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText)) {
        LoginView.a(this.this$0).showSoftInput(this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, 2);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHint("");
      return;
    }
    this.this$0.qX.setVisibility(8);
    paramView = new SpannableString(acfp.m(2131707950));
    paramView.setSpan(new AbsoluteSizeSpan(17, true), 0, paramView.length(), 33);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHint(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aanf
 * JD-Core Version:    0.7.0.1
 */