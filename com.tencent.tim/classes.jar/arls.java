import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class arls
  implements ajat.c
{
  arls(arlq paramarlq) {}
  
  public void OC(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TVKVideoController", 4, new Object[] { "onFocusChange focusType:", Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        ((AudioManager)((Context)arlq.a(this.this$0).get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
        if (arlq.a(this.this$0) != null) {
          arlq.a(this.this$0).play();
        }
        arlq.a(this.this$0, 4);
        return;
        if (arlq.a(this.this$0) != null) {
          arlq.a(this.this$0).pause();
        }
        arlq.a(this.this$0, 6);
      } while (arlq.a(this.this$0) == null);
      arlq.a(this.this$0).onVideoStop();
      return;
    } while (arlq.a(this.this$0) == null);
    arlq.a(this.this$0).setMute(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arls
 * JD-Core Version:    0.7.0.1
 */