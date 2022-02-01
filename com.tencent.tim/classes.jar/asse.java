import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.qqconnect.wtlogin.Login;

public class asse
  implements TextWatcher
{
  public asse(Login paramLogin) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0) {
      this.a.Ar.setVisibility(4);
    }
    for (;;)
    {
      this.a.dgv = false;
      this.a.bH.setText("");
      return;
      if (paramInt3 < 2) {
        this.a.Ar.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asse
 * JD-Core Version:    0.7.0.1
 */