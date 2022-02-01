import android.opengl.GLES20;
import java.util.HashMap;

public class akzt
{
  public static int FBPFQ_HIGH = 3;
  public static int FBPFQ_LOW = 1;
  public static int FBPFQ_MEDIUM = 2;
  public HashMap<String, Integer> mk = new HashMap();
  private int[] mq = new int[1];
  
  private void Sy(int paramInt)
  {
    float f = new float[] { 1.0F, 1.0F, 0.95F, 0.9F }[paramInt];
    if (paramInt == FBPFQ_HIGH) {
      f = 1.1F;
    }
    for (;;)
    {
      a(f, "quality");
      a(0.0F, "add_red");
      a(0.0F, "red_m");
      a(0.0F, "green_m");
      a(0.0F, "blue_m");
      return;
      if (paramInt == FBPFQ_MEDIUM) {
        f = 1.0F;
      }
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    a(paramFloat1, "percent1");
    a(paramFloat2, "percent2");
    a(paramFloat3, "percent3");
    a(paramFloat4, "percent4");
    a(paramFloat5, "percent5");
    a(paramFloat6, "percent6");
    a(paramFloat7, "percent7");
  }
  
  private void a(float paramFloat, String paramString)
  {
    int i = ((Integer)this.mk.get(paramString)).intValue();
    if (i >= 0) {
      GLES20.glUniform1f(i, paramFloat);
    }
  }
  
  public void Sx(int paramInt)
  {
    float f5 = 0.2F;
    float f1;
    float f2;
    float f3;
    float f4;
    if (paramInt == FBPFQ_LOW)
    {
      f1 = 0.455F;
      f2 = 0.17F;
      f3 = 0.177F;
      f4 = 0.0F;
    }
    for (;;)
    {
      a(0.0F, f1, f2, f3, 0.0F, f5, f4);
      Sy(paramInt);
      return;
      if (paramInt == FBPFQ_MEDIUM)
      {
        f1 = 0.62F;
        f2 = 0.375F;
        f3 = 0.07F;
        f5 = 0.125F;
        f4 = 0.26F;
      }
      else if (paramInt == FBPFQ_HIGH)
      {
        f1 = 0.824F;
        f2 = 0.461F;
        f3 = 0.152F;
        f4 = 0.0F;
      }
      else
      {
        f4 = 0.0F;
        f5 = 0.0F;
        f3 = 0.0F;
        f2 = 0.0F;
        f1 = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzt
 * JD-Core Version:    0.7.0.1
 */