import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class cmd
  implements View.OnClickListener
{
  public cmd(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.a.jdField_a_of_type_AndroidWidgetEditText, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmd
 * JD-Core Version:    0.7.0.1
 */