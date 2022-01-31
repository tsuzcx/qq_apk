import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity;

public class xad
  implements View.OnClickListener
{
  public xad(PayCodeEntryActivity paramPayCodeEntryActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a("payCodeEntry.payCode", "actQQWlxclick", "0001");
    PayCodeEntryActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xad
 * JD-Core Version:    0.7.0.1
 */