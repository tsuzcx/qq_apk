import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView.a;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aaot
  implements View.OnClickListener
{
  public aaot(TimLoginQQView.a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.a.this$0.u);
    this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this.a.this$0.j);
    this.a.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.a.this$0.r);
    this.a.this$0.mPosition = this.bDs;
    SimpleAccount localSimpleAccount = (SimpleAccount)this.a.this$0.qh.get(this.a.this$0.mPosition);
    ImageView localImageView;
    if (!TimLoginQQView.f(this.a.this$0))
    {
      TimLoginQQView.g(this.a.this$0, true);
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localImageView = this.a.this$0.qX;
      if ((!TimLoginQQView.g(this.a.this$0)) && (!TimLoginQQView.h(this.a.this$0)) && (!TimLoginQQView.e(this.a.this$0))) {
        break label418;
      }
    }
    label418:
    for (int i = 2130847848;; i = 2130845569)
    {
      localImageView.setImageResource(i);
      this.a.this$0.qX.setContentDescription(acfp.m(2131707951));
      if ((this.a.this$0.c != null) && (!this.a.this$0.c.getUin().equals(localSimpleAccount.getUin()))) {
        anpc.report("Login_clickaccountswitch_succeeded_null_null");
      }
      TimLoginQQView.a(this.a.this$0, localSimpleAccount);
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
 * Qualified Name:     aaot
 * JD-Core Version:    0.7.0.1
 */