import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ar.view.ARScanEntryView;

public class adlk
  implements DialogInterface.OnDismissListener
{
  public adlk(ARScanEntryView paramARScanEntryView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ARScanEntryView.a(this.this$0, null);
    ARScanEntryView.a(this.this$0).resume();
    ARScanEntryView.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adlk
 * JD-Core Version:    0.7.0.1
 */