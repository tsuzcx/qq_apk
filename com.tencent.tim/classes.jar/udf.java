import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class udf
  implements View.OnFocusChangeListener
{
  public udf(AddAccountActivity paramAddAccountActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView) {
      if (true == paramBoolean)
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.isPopupShowing()) {
          this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.dismissDropDown();
        }
        if ((this.this$0.pj != null) && (this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length() > 0)) {
          this.this$0.pj.setVisibility(0);
        }
        this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setSelection(this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length());
      }
    }
    while ((paramView != this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText) || (true != paramBoolean))
    {
      do
      {
        return;
      } while ((this.this$0.pj == null) || (!this.this$0.pj.isShown()));
      this.this$0.pj.setVisibility(8);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udf
 * JD-Core Version:    0.7.0.1
 */