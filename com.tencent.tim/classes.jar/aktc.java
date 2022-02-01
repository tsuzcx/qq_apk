import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aktc
  implements TextWatcher
{
  private CharSequence aa;
  private int mEnd;
  private int mStart;
  
  public aktc(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.aa != null) && (aofy.ao(String.valueOf(this.aa), 3) > 100))
    {
      QQToast.a(this.this$0.getActivity(), 1, 2131690679, 0).show();
      paramEditable.delete(this.mStart, this.mEnd);
    }
    this.this$0.rightViewText.setEnabled(AutoReplyEditActivity.a(this.this$0, String.valueOf(AutoReplyEditActivity.a(this.this$0).getText())));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.aa = paramCharSequence;
    this.mStart = paramInt1;
    this.mEnd = (paramInt1 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktc
 * JD-Core Version:    0.7.0.1
 */