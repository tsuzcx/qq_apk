import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import com.tencent.mobileqq.widget.ContextMenuTextView;

@TargetApi(16)
public class exs
  implements DialogInterface.OnDismissListener
{
  exs(ContextMenuTextView paramContextMenuTextView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (Build.VERSION.SDK_INT < 16) {
      ContextMenuTextView.a(this.a, null);
    }
    for (;;)
    {
      ContextMenuTextView.a(this.a, null);
      return;
      ContextMenuTextView.b(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     exs
 * JD-Core Version:    0.7.0.1
 */