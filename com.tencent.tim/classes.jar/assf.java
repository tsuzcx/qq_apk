import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.qqconnect.wtlogin.Login;

public class assf
  implements TextWatcher
{
  public assf(Login paramLogin) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 2)
    {
      this.a.dgv = false;
      if (paramCharSequence.length() == 0) {
        this.a.Kj.setVisibility(4);
      }
    }
    else
    {
      return;
    }
    this.a.Kj.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assf
 * JD-Core Version:    0.7.0.1
 */