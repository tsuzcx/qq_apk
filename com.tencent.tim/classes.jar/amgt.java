import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.widget.QQToast;

public class amgt
  implements TextWatcher
{
  private CharSequence aa;
  private int mEnd;
  private int mStart;
  
  public amgt(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.aa != null) && (aofy.ao(String.valueOf(this.aa), 3) > 50))
    {
      QQToast.a(this.this$0.getActivity(), 1, 2131690679, 0).show();
      paramEditable.delete(this.mStart, this.mEnd);
    }
    if ((paramEditable == null) || (paramEditable.length() == 0))
    {
      SignatureHistoryFragment.a(this.this$0).setEnabled(false);
      return;
    }
    SignatureHistoryFragment.a(this.this$0).setEnabled(true);
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
 * Qualified Name:     amgt
 * JD-Core Version:    0.7.0.1
 */