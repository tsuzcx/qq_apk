import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.GridViewAdapter;

public class xwz
  implements View.OnKeyListener
{
  public xwz(SelectMemberActivity paramSelectMemberActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67)
    {
      if (paramKeyEvent.getAction() != 0) {
        break label35;
      }
      this.a.r = TextUtils.isEmpty(this.a.jdField_a_of_type_AndroidWidgetEditText.getText());
    }
    for (;;)
    {
      return false;
      label35:
      if ((paramKeyEvent.getAction() == 1) && (this.a.r)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwz
 * JD-Core Version:    0.7.0.1
 */