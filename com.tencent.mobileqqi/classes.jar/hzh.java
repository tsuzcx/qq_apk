import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import com.tencent.sharp.jni.TraeMediaPlayer.OnCompletionListener;
import java.util.TimerTask;

public class hzh
  extends TimerTask
{
  public hzh(TraeMediaPlayer paramTraeMediaPlayer) {}
  
  public void run()
  {
    if (TraeMediaPlayer.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "TraeMediaPlay | play timeout");
      }
      if (TraeMediaPlayer.a(this.a) != null) {
        TraeMediaPlayer.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzh
 * JD-Core Version:    0.7.0.1
 */