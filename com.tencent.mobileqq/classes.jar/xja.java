import android.content.res.Resources;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideHandler;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qphone.base.util.QLog;

public class xja
  implements View.OnFocusChangeListener
{
  public xja(LoginView paramLoginView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView) {
      if (true == paramBoolean)
      {
        if (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.isPopupShowing()) {
          this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.dismissDropDown();
        }
        if ((this.a.b != null) && (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length() > 0)) {
          this.a.b.setVisibility(0);
        }
        this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setSelection(this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length());
        if (!GuideHandler.a(GuideHandler.a)) {}
      }
    }
    label112:
    while (paramView != this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText)
    {
      do
      {
        do
        {
          break label112;
          do
          {
            return;
          } while (!LoginView.a(this.a).isActive(this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView));
          if (QLog.isColorLevel()) {
            QLog.d("InputMethodRelativeLayout", 2, "isActive(mAutoTextAccount)");
          }
        } while (((LoginView.d(this.a)) && (LoginView.f(this.a))) || (LoginView.b(this.a)));
        int i = (int)(35.0F * this.a.getResources().getDisplayMetrics().density);
        this.a.e.scrollTo(0, i);
        LoginView.d(this.a, true);
        return;
      } while ((this.a.b == null) || (!this.a.b.isShown()));
      this.a.b.setVisibility(8);
      return;
    }
    if (true == paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().length());
      this.a.c.setVisibility(0);
      return;
    }
    this.a.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xja
 * JD-Core Version:    0.7.0.1
 */