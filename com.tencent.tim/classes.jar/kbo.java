import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.PublicAccountMenuBar;

public class kbo
  implements DialogInterface.OnDismissListener
{
  public kbo(PublicAccountMenuBar paramPublicAccountMenuBar) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PublicAccountMenuBar.a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbo
 * JD-Core Version:    0.7.0.1
 */