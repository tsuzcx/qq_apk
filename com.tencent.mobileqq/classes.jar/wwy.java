import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity;

public class wwy
  implements View.OnClickListener
{
  public wwy(PayCodeEntryActivity paramPayCodeEntryActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a("payCodeEntry.payCode", "actQQWlxclick", "0001");
    PayCodeEntryActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wwy
 * JD-Core Version:    0.7.0.1
 */