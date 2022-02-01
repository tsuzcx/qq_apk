import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicWaveformManager.2;

public class azbf
{
  private azbe a;
  private azbe.a b = new azbg(this);
  private boolean dCl;
  private boolean dCp;
  private int eNB;
  private Runnable iU = new MusicWaveformManager.2(this);
  private MusicItemInfo m;
  private boolean mIsPlaying;
  
  public static boolean aRD()
  {
    return ("Meizu".equals(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT <= 22);
  }
  
  private void eUF()
  {
    this.a = new azbe();
    this.dCl = true;
    ThreadManager.postImmediately(this.iU, null, true);
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, int paramInt)
  {
    if (paramMusicItemInfo == null) {
      onDestroy();
    }
    do
    {
      do
      {
        return;
        if (!this.mIsPlaying) {
          break;
        }
      } while ((paramMusicItemInfo.equals(this.m)) && (this.eNB <= paramInt) && (paramMusicItemInfo.musicStart == this.m.musicStart) && (paramMusicItemInfo.musicEnd == this.m.musicEnd));
      onDestroy();
      this.mIsPlaying = true;
      this.m = paramMusicItemInfo.copy();
      this.a = null;
      this.eNB = paramInt;
      if (!aRD()) {
        break;
      }
      this.dCp = true;
    } while (!QLog.isColorLevel());
    QLog.e("MusicWaveformManager", 2, "musicSoundFile create give up, is rubbish Meizu");
    return;
    eUF();
  }
  
  public float getCurrentGain(int paramInt)
  {
    if ((this.mIsPlaying) && (this.dCp)) {
      return 0.5F;
    }
    if ((this.mIsPlaying) && (this.a != null) && (this.a.dCo) && (paramInt >= this.eNB)) {
      return this.a.B(paramInt - this.eNB);
    }
    return -1.0F;
  }
  
  public void onDestroy()
  {
    if (!this.mIsPlaying) {
      return;
    }
    this.dCl = false;
    if (this.a != null) {
      this.a = null;
    }
    this.mIsPlaying = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azbf
 * JD-Core Version:    0.7.0.1
 */