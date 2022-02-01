import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import mqq.util.WeakReference;

public abstract class aluw
  implements DialogInterface.OnDismissListener
{
  public DialogInterface.OnDismissListener a()
  {
    return new aluw.a(this);
  }
  
  public class a
    implements DialogInterface.OnDismissListener
  {
    WeakReference<DialogInterface.OnDismissListener> aU;
    
    a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.aU = new WeakReference(paramOnDismissListener);
    }
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      DialogInterface.OnDismissListener localOnDismissListener = (DialogInterface.OnDismissListener)this.aU.get();
      if (localOnDismissListener != null) {
        localOnDismissListener.onDismiss(paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aluw
 * JD-Core Version:    0.7.0.1
 */