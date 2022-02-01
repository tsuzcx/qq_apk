import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;

class agxh
  implements AudioManager.OnAudioFocusChangeListener
{
  agxh(agxa paramagxa) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (agxa.a(this.this$0) != null) {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "onAudioFocusChange:mVideoView null!");
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          bool = agxa.a(this.this$0).isPlaying();
          if (paramInt != -2) {
            break;
          }
        } while (!bool);
        agxa.a(this.this$0);
        return;
        if (paramInt != 1) {
          break;
        }
      } while ((bool) || (this.this$0.mContext == null) || (!(this.this$0.mContext instanceof FileBrowserActivity)) || (!((FileBrowserActivity)this.this$0.mContext).isResume()));
      agxa.c(this.this$0);
      return;
    } while ((paramInt != -1) || (!bool));
    agxa.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxh
 * JD-Core Version:    0.7.0.1
 */