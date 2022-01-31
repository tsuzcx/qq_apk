import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class xmd
  implements View.OnClickListener
{
  public xmd(LoginView paramLoginView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (this.a.b.isShown())) {
      this.a.b.setVisibility(8);
    }
    this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    libsafeedit.clearPassBuffer();
    LoginView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmd
 * JD-Core Version:    0.7.0.1
 */