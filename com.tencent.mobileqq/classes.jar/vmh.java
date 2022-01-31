import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

class vmh
  implements TextWatcher
{
  vmh(vmg paramvmg) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Vmn == null) {}
    do
    {
      return;
      paramInt2 = this.a.a(paramCharSequence.toString());
      if (paramInt2 > 420)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence.subSequence(0, paramInt1));
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt1);
        if (this.a.jdField_a_of_type_Vmn != null) {
          this.a.jdField_a_of_type_Vmn.b(420);
        }
      }
    } while (paramInt2 <= 0);
    this.a.b.setTextColor(Color.parseColor("#12b7f5"));
    this.a.b.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmh
 * JD-Core Version:    0.7.0.1
 */