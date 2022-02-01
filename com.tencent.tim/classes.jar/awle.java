import android.support.annotation.NonNull;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public class awle
{
  public EGLConfig b;
  public String cRd;
  public EGLContext d;
  public boolean dqQ = true;
  public int height;
  public String resMD5;
  public String resUrl;
  public int width;
  
  @NonNull
  public String toString()
  {
    return " width = " + this.width + " height = " + this.height + " isNeedOffScreen = " + this.dqQ + " resUrl = " + this.resUrl + " resFilePath = " + this.cRd + " resMD5 = " + this.resMD5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awle
 * JD-Core Version:    0.7.0.1
 */