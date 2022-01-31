import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.qqconnect.wtlogin.Login;

public class fiq
  implements TextWatcher
{
  public fiq(Login paramLogin) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 2)
    {
      this.a.jdField_b_of_type_Boolean = false;
      if (paramCharSequence.length() == 0) {
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(4);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fiq
 * JD-Core Version:    0.7.0.1
 */