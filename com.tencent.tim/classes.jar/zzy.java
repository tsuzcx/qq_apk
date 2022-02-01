import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class zzy
  implements DialogInterface.OnClickListener
{
  public zzy(TransactionActivity paramTransactionActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.a(TransactionActivity.b(this.this$0), 128, "transfer.amount.go", "", "", TransactionActivity.b(this.this$0), "");
    this.this$0.ctf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zzy
 * JD-Core Version:    0.7.0.1
 */