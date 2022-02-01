import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import java.io.File;
import java.util.Locale;
import mqq.os.MqqHandler;

class xtg
  implements DialogInterface.OnClickListener
{
  xtg(xtf paramxtf, File paramFile) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.U.getParentFile().getName().toLowerCase(Locale.US) + ".mp4";
    ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.U.getAbsolutePath(), this.a.this$0.b, paramDialogInterface, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtg
 * JD-Core Version:    0.7.0.1
 */