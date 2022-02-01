import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;

class aqaj
  implements DialogInterface.OnKeyListener
{
  aqaj(aqai paramaqai) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.this$0.dismiss();
      ((Activity)this.this$0.mActivity.get()).finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqaj
 * JD-Core Version:    0.7.0.1
 */