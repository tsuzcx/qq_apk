import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity;

public class dun
  implements View.OnClickListener
{
  public dun(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((paramView == null) || (paramView.length() == 0)) {
      Toast.makeText(this.a, this.a.getString(2131562031), 0).show();
    }
    while (paramView == null) {
      return;
    }
    this.a.a(paramView);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    VerifyCodeActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dun
 * JD-Core Version:    0.7.0.1
 */