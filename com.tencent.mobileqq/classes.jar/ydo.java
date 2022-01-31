import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import mqq.os.MqqHandler;

class ydo
  implements DialogInterface.OnClickListener
{
  ydo(ydn paramydn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.a.a.b, this.a.a.a, this.a.a.g + ".mp4", true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ydo
 * JD-Core Version:    0.7.0.1
 */