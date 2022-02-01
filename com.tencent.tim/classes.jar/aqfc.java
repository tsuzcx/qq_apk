import android.animation.AnimatorSet;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class aqfc
  implements DialogInterface.OnDismissListener
{
  aqfc(AnimatorSet paramAnimatorSet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.av.isRunning()) {
      this.av.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfc
 * JD-Core Version:    0.7.0.1
 */