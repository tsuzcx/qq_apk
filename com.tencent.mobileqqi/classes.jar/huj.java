import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity2;
import com.tencent.qqconnect.wtlogin.Login;

public class huj
  implements View.OnClickListener
{
  public huj(Login paramLogin) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton) {
      this.a.e();
    }
    do
    {
      return;
      if (paramView == Login.a(this.a))
      {
        this.a.setResult(0);
        this.a.finish();
        return;
      }
      if (paramView == this.a.jdField_a_of_type_AndroidViewView)
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
        return;
      }
      if (paramView == this.a.jdField_b_of_type_AndroidViewView)
      {
        this.a.jdField_b_of_type_AndroidWidgetEditText.setText("");
        return;
      }
    } while (paramView != this.a.jdField_a_of_type_AndroidWidgetTextView);
    paramView = new Intent(this.a, LoginPhoneNumActivity2.class);
    paramView.putExtra("key_req_src", this.a.i);
    this.a.startActivityForResult(paramView, 10000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     huj
 * JD-Core Version:    0.7.0.1
 */