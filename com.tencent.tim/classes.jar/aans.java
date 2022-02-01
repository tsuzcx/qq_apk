import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView.a;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aans
  implements View.OnClickListener
{
  public aans(LoginView.a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.a.this$0.u);
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this.a.this$0.j);
    this.a.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.a.this$0.r);
    this.a.this$0.mPosition = this.bDs;
    SimpleAccount localSimpleAccount = (SimpleAccount)this.a.this$0.qh.get(this.a.this$0.mPosition);
    ImageView localImageView;
    if (!LoginView.h(this.a.this$0))
    {
      LoginView.i(this.a.this$0, true);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localImageView = this.a.this$0.qX;
      if ((!LoginView.d(this.a.this$0)) && (!LoginView.e(this.a.this$0)) && (!LoginView.f(this.a.this$0))) {
        break label377;
      }
    }
    label377:
    for (int i = 2130847848;; i = 2130845569)
    {
      localImageView.setImageResource(i);
      this.a.this$0.qX.setContentDescription(acfp.m(2131707951));
      LoginView.a(this.a.this$0, localSimpleAccount);
      this.a.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.a.this$0.u);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.a.this$0.j);
      this.a.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.a.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.a.this$0.r);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.B().setVisibility(8);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aans
 * JD-Core Version:    0.7.0.1
 */