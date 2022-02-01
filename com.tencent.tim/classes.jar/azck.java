import android.os.Build.VERSION;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class azck
{
  azck.c a;
  
  public azck()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a(File paramFile, azck.a parama, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, parama, paramBoolean);
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract azck.b a(int paramInt1, int paramInt2);
    
    public abstract void ahK();
    
    public abstract void f(Throwable paramThrowable);
    
    public abstract void onCanceled();
    
    public abstract void onProgress(int paramInt);
  }
  
  public static class b
  {
    public int agP = 1;
    public File as;
    public long beginTime = -1L;
    public int bjC;
    public int bjD;
    public int bjE;
    public int bjF;
    public boolean cHW;
    public boolean cHX;
    public boolean cHY;
    public int dzA = -1;
    public long endTime = -1L;
    public boolean isMute;
    public int level;
    public int profile;
    public float scaleRate;
    public int videoBitRate;
    public int videoFrameRate;
    
    public String toString()
    {
      return "VideoConvertConfig{videoBitRate=" + this.videoBitRate + ", videoFrameRate=" + this.videoFrameRate + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", scaleRate=" + this.scaleRate + ", iFrameInterval=" + this.agP + ", setProfileLevel=" + this.cHW + ", profile=" + this.profile + ", level=" + this.level + ", setRotation=" + this.cHX + ", isMute=" + this.isMute + ", accurateSeek=" + this.cHY + ", cropX=" + this.bjC + ", cropY=" + this.bjD + ", cropWidth=" + this.bjE + ", cropHeight=" + this.bjF + '}';
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(File paramFile, azck.a parama, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azck
 * JD-Core Version:    0.7.0.1
 */