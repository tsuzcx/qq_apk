import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;

public final class avql
  implements DialogInterface.OnDismissListener
{
  public avql(FragmentActivity paramFragmentActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avql
 * JD-Core Version:    0.7.0.1
 */