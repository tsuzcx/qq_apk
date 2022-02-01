import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class aazq
  implements DialogInterface.OnClickListener
{
  aazq(aazp paramaazp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.this$0.mHandler.get() != null) {
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.a.this$0.mVideoPath, (MqqHandler)this.a.this$0.mHandler.get(), this.a.this$0.mMd5 + ".mp4", true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazq
 * JD-Core Version:    0.7.0.1
 */