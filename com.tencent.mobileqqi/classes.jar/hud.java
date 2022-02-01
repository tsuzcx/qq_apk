import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qqconnect.wtlogin.Login;

public class hud
  implements View.OnFocusChangeListener
{
  public hud(Login paramLogin) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.jdField_b_of_type_AndroidWidgetEditText)
    {
      if (true == paramBoolean) {
        this.a.jdField_b_of_type_AndroidWidgetEditText.selectAll();
      }
      if (!paramBoolean) {
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(4);
      }
    }
    while ((paramView != this.a.jdField_a_of_type_AndroidWidgetEditText) || (paramBoolean)) {
      return;
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hud
 * JD-Core Version:    0.7.0.1
 */