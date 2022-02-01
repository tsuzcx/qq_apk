import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.app.VideoAppInterface;

public abstract class iku
{
  protected int aoj;
  protected long lA;
  protected long lz;
  protected VideoAppInterface mApp;
  protected String model;
  protected int sdkVersion;
  
  public iku(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public abstract int an(String paramString);
  
  public abstract void anD();
  
  public abstract boolean ct(String paramString);
  
  public abstract boolean e(int paramInt, String paramString);
  
  public void onCreate()
  {
    this.model = Build.MODEL.toLowerCase();
    this.sdkVersion = Build.VERSION.SDK_INT;
    this.lz = imm.getMaxCpuFreq();
    this.aoj = imm.getNumCores();
    this.lA = aqgz.getSystemTotalMemory();
  }
  
  public abstract void restore();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iku
 * JD-Core Version:    0.7.0.1
 */