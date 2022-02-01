import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class zzx
  implements TextView.OnEditorActionListener
{
  public zzx(TransactionActivity paramTransactionActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (TransactionActivity.a(this.this$0).isEnabled()) {
        TransactionActivity.a(this.this$0).performClick();
      }
      if (TransactionActivity.a(this.this$0) != null) {
        ((InputMethodManager)TransactionActivity.a(this.this$0).getSystemService("input_method")).hideSoftInputFromWindow(TransactionActivity.c(this.this$0).getWindowToken(), 0);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zzx
 * JD-Core Version:    0.7.0.1
 */