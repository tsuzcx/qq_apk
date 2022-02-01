import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class vdd
  implements MediaPlayer.OnErrorListener
{
  vdd(vda paramvda) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    vda.a(this.a);
    QLog.e("QCircleFolderSplashPart", 1, "play splash video error!what:" + paramInt1 + ",extra:" + paramInt2);
    this.a.b("show_publish_feed_guide_bubble", null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdd
 * JD-Core Version:    0.7.0.1
 */