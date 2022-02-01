import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText.a;

public class nxw
  implements TextWatcher
{
  public nxw(LimitWordCountEditText paramLimitWordCountEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null)
    {
      if (LimitWordCountEditText.a(this.this$0) != null) {
        LimitWordCountEditText.a(this.this$0).sb(0);
      }
      LimitWordCountEditText.a(this.this$0).setText(LimitWordCountEditText.a(this.this$0));
      return;
    }
    if (LimitWordCountEditText.a(this.this$0) != null) {
      LimitWordCountEditText.a(this.this$0).sb(paramCharSequence.length());
    }
    LimitWordCountEditText.a(this.this$0).setText(String.valueOf(LimitWordCountEditText.a(this.this$0) - paramCharSequence.length()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxw
 * JD-Core Version:    0.7.0.1
 */