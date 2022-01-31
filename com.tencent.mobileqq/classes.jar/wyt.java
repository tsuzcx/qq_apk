import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class wyt
  implements TextWatcher
{
  public wyt(TransactionActivity paramTransactionActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TransactionActivity.a(this.a).getText().length() > 4) {
      if (!TransactionActivity.a(this.a).isEnabled())
      {
        TransactionActivity.a(this.a).setEnabled(true);
        TransactionActivity.a(this.a).setClickable(true);
        this.a.a(TransactionActivity.a(this.a), 128, "transfer.qqid.enable", "", "", TransactionActivity.a(this.a), "");
      }
    }
    try
    {
      if ((TransactionActivity.b(this.a).getText().length() > 0) && (!TransactionActivity.b(this.a).getText().toString().startsWith(".")) && (!TransactionActivity.b(this.a).getText().toString().endsWith(".")) && (TransactionActivity.a(this.a, TransactionActivity.b(this.a).getText().toString())))
      {
        f = Float.parseFloat(paramEditable.toString());
        if ((TransactionActivity.b(this.a) > 0) && (!TextUtils.isEmpty(TransactionActivity.b(this.a))) && (f * 100.0F >= TransactionActivity.b(this.a)) && (!TextUtils.isEmpty(TransactionActivity.b(this.a)))) {
          this.a.a(TransactionActivity.b(this.a));
        }
        if (!TransactionActivity.b(this.a).isEnabled())
        {
          TransactionActivity.b(this.a).setEnabled(true);
          TransactionActivity.b(this.a).setClickable(true);
          this.a.a(TransactionActivity.a(this.a), 128, "transfer.amount.enable", "", "", TransactionActivity.a(this.a), "");
        }
      }
      while (!TransactionActivity.b(this.a).isEnabled())
      {
        float f;
        return;
        if (!TransactionActivity.a(this.a).isEnabled()) {
          break;
        }
        TransactionActivity.a(this.a).setClickable(false);
        TransactionActivity.a(this.a).setEnabled(false);
        this.a.a(TransactionActivity.a(this.a), 128, "transfer.qqid.disable", "", "", TransactionActivity.a(this.a), "");
        break;
      }
      TransactionActivity.b(this.a).setClickable(false);
      TransactionActivity.b(this.a).setEnabled(false);
      this.a.a(TransactionActivity.a(this.a), 128, "transfer.amount.disable", "", "", TransactionActivity.a(this.a), "");
      return;
    }
    catch (Exception paramEditable)
    {
      paramEditable.printStackTrace();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyt
 * JD-Core Version:    0.7.0.1
 */