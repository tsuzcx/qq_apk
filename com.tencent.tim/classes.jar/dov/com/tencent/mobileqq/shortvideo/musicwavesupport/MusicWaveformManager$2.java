package dov.com.tencent.mobileqq.shortvideo.musicwavesupport;

import android.os.SystemClock;
import azbe;
import azbf;
import com.tencent.qphone.base.util.QLog;

public class MusicWaveformManager$2
  implements Runnable
{
  public MusicWaveformManager$2(azbf paramazbf) {}
  
  public void run()
  {
    try
    {
      long l = SystemClock.elapsedRealtimeNanos();
      boolean bool = azbf.a(this.this$0).a(azbf.a(this.this$0), azbf.a(this.this$0), azbf.a(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("MusicWaveformManager", 2, "createSoundFile time: " + (SystemClock.elapsedRealtimeNanos() - l) / 1000000L + "ms");
      }
      if (!bool)
      {
        azbf.a(this.this$0, false);
        if (QLog.isColorLevel()) {
          QLog.e("MusicWaveformManager", 2, "create musicSoundFile fail");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        azbf.a(this.this$0, false);
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("MusicWaveformManager", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicWaveformManager.2
 * JD-Core Version:    0.7.0.1
 */