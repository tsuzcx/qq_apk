import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;

public class bpy
  implements DialogInterface.OnDismissListener
{
  public bpy(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AccountDetailActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpy
 * JD-Core Version:    0.7.0.1
 */