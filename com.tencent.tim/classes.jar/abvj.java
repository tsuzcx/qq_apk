import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.apollo.task.ApolloAudioPlayer;
import com.tencent.qphone.base.util.QLog;

public class abvj
  implements MediaPlayer.OnCompletionListener
{
  public abvj(ApolloAudioPlayer paramApolloAudioPlayer, int paramInt, String paramString) {}
  
  public void onCompletion(MediaPlayer arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAudioPlayer", 2, "[onCompletion]");
    }
    int i = this.HW - 1;
    if (i == 0) {}
    do
    {
      synchronized (this.a.mLock)
      {
        ApolloAudioPlayer.a(this.a, null);
        if (ApolloAudioPlayer.a(this.a) != null) {
          ApolloAudioPlayer.a(this.a).onCompletion();
        }
        return;
      }
      if (!this.a.mIsPaused)
      {
        QLog.d("ApolloAudioPlayer", 2, "[repeat play]");
        ApolloAudioPlayer.a(this.a, this.val$path, i);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloAudioPlayer", 2, "Paused. NOT play");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abvj
 * JD-Core Version:    0.7.0.1
 */