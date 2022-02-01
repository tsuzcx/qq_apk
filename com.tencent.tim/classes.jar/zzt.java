import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class zzt
  implements TextWatcher
{
  public zzt(TransactionActivity paramTransactionActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    for (boolean bool = true;; bool = false)
    {
      try
      {
        Button localButton = TransactionActivity.a(this.this$0);
        if (TextUtils.isEmpty(paramEditable.toString())) {
          continue;
        }
        localButton.setEnabled(bool);
        float f = Float.parseFloat(paramEditable.toString());
        int i = TransactionActivity.a(this.this$0).getText().length();
        paramEditable = TransactionActivity.a(this.this$0, f);
        if (aqmr.isEmpty(paramEditable))
        {
          TransactionActivity.a(this.this$0).setVisibility(0);
          TransactionActivity.a(this.this$0).setVisibility(8);
          TransactionActivity.a(this.this$0).setVisibility(8);
        }
        while ((i > 0) && (!TransactionActivity.a(this.this$0).getText().toString().startsWith(".")) && (!TransactionActivity.a(this.this$0).getText().toString().endsWith(".")) && (TransactionActivity.a(this.this$0, TransactionActivity.a(this.this$0).getText().toString())))
        {
          if ((TransactionActivity.a(this.this$0) > 0) && (!TextUtils.isEmpty(TransactionActivity.a(this.this$0))) && (f * 100.0F >= TransactionActivity.a(this.this$0)) && (!TextUtils.isEmpty(TransactionActivity.a(this.this$0)))) {
            this.this$0.e(TransactionActivity.a(this.this$0));
          }
          if (TransactionActivity.a(this.this$0).isEnabled()) {
            break label406;
          }
          TransactionActivity.a(this.this$0).setEnabled(true);
          this.this$0.a(TransactionActivity.b(this.this$0), 128, "transfer.amount.enable", "", "", TransactionActivity.b(this.this$0), "");
          return;
          TransactionActivity.a(this.this$0).setVisibility(8);
          TransactionActivity.a(this.this$0).setVisibility(0);
          TransactionActivity.a(this.this$0).setVisibility(0);
          TransactionActivity.a(this.this$0).setText(paramEditable);
        }
        if (!TransactionActivity.a(this.this$0).isEnabled()) {
          break label406;
        }
      }
      catch (Exception paramEditable)
      {
        paramEditable.printStackTrace();
        return;
      }
      TransactionActivity.a(this.this$0).setEnabled(false);
      this.this$0.a(TransactionActivity.b(this.this$0), 128, "transfer.amount.disable", "", "", TransactionActivity.b(this.this$0), "");
      label406:
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zzt
 * JD-Core Version:    0.7.0.1
 */