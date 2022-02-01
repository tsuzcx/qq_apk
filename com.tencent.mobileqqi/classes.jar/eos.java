import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.recent.LocalSearchBar;

public class eos
  implements DialogInterface.OnDismissListener
{
  public eos(LocalSearchBar paramLocalSearchBar) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LocalSearchBar.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eos
 * JD-Core Version:    0.7.0.1
 */