import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;

public class dyy
  implements TextWatcher
{
  public dyy(RoamSearchDialog paramRoamSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.a.getText().toString().trim().length() == 0)
    {
      this.a.findViewById(2131297955).setVisibility(8);
      return;
    }
    this.a.findViewById(2131297955).setVisibility(0);
    this.a.a();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dyy
 * JD-Core Version:    0.7.0.1
 */