import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;

public class jrk
  implements SoundPool.OnLoadCompleteListener
{
  public jrk(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.this$0.mSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SensorApi", 2, "play failure url=" + this.val$url);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrk
 * JD-Core Version:    0.7.0.1
 */