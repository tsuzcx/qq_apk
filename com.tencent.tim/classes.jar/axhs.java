import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment;
import java.io.File;

public class axhs
  implements DialogInterface.OnCancelListener
{
  public axhs(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEVideoShelfPreviewFragment.a(this.this$0).cancelSave();
    paramDialogInterface = new File(AEVideoShelfPreviewFragment.a(this.this$0).getOutputVideoPath());
    if (paramDialogInterface.exists())
    {
      TTPTLogger.i(AEVideoShelfPreviewFragment.access$200(), "delete temp silent video");
      paramDialogInterface.delete();
    }
    AEVideoShelfPreviewFragment.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhs
 * JD-Core Version:    0.7.0.1
 */