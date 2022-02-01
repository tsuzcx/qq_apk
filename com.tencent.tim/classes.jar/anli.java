import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl;
import java.io.File;

public class anli
{
  anli.c a;
  
  public anli()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.a = new JBMR2VideoConverterImpl();
    }
  }
  
  public boolean a(File paramFile, anli.a parama, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFile, parama, paramBoolean);
    }
    return false;
  }
  
  public boolean cancel()
  {
    return (this.a != null) && (this.a.cancel());
  }
  
  public boolean stop()
  {
    if (this.a != null) {
      return this.a.stop();
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract anli.b a(int paramInt1, int paramInt2);
    
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
  }
  
  public static abstract interface c
  {
    public abstract boolean a(File paramFile, anli.a parama, boolean paramBoolean);
    
    public abstract boolean cancel();
    
    public abstract boolean stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anli
 * JD-Core Version:    0.7.0.1
 */