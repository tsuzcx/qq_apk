import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

class rgz
  implements TextWatcher
{
  rgz(rgy paramrgy) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a == null) {}
    do
    {
      return;
      paramInt2 = this.a.bi(paramCharSequence.toString());
      if (paramInt2 > 420)
      {
        this.a.ag.setText(paramCharSequence.subSequence(0, paramInt1));
        this.a.ag.setSelection(paramInt1);
        if (this.a.a != null) {
          this.a.a.xj(420);
        }
      }
    } while (paramInt2 <= 0);
    this.a.yz.setTextColor(Color.parseColor("#12b7f5"));
    this.a.yz.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgz
 * JD-Core Version:    0.7.0.1
 */