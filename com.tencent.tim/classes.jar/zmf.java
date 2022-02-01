import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

class zmf
  implements TextWatcher
{
  zmf(zme paramzme) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.b.v.getText().toString().trim();
    if (this.b.brD) {
      this.b.a.zy(paramEditable);
    }
    this.b.brD = true;
    if (paramEditable.length() == 0)
    {
      this.b.findViewById(2131368696).setVisibility(8);
      return;
    }
    this.b.findViewById(2131368696).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmf
 * JD-Core Version:    0.7.0.1
 */