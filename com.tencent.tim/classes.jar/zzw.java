import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class zzw
  implements TextWatcher
{
  public zzw(TransactionActivity paramTransactionActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TransactionActivity.b(this.this$0).getText().length() > 4) {
      if (!TransactionActivity.b(this.this$0).isEnabled())
      {
        TransactionActivity.b(this.this$0).setEnabled(true);
        TransactionActivity.b(this.this$0).setClickable(true);
        this.this$0.a(TransactionActivity.b(this.this$0), 128, "transfer.qqid.enable", "", "", TransactionActivity.b(this.this$0), "");
      }
    }
    while (!TransactionActivity.b(this.this$0).isEnabled()) {
      return;
    }
    TransactionActivity.b(this.this$0).setClickable(false);
    TransactionActivity.b(this.this$0).setEnabled(false);
    this.this$0.a(TransactionActivity.b(this.this$0), 128, "transfer.qqid.disable", "", "", TransactionActivity.b(this.this$0), "");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zzw
 * JD-Core Version:    0.7.0.1
 */