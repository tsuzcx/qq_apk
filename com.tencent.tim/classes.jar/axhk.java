import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;

public class axhk
  implements DialogInterface.OnCancelListener
{
  public axhk(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEVideoShelfEditFragment.a(this.this$0).cancelSave();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhk
 * JD-Core Version:    0.7.0.1
 */