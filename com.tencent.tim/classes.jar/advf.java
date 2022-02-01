import java.util.Random;

public class advf
{
  public static Random random = new Random();
  
  public static final float cos(float paramFloat)
  {
    return advf.a.L[((int)(1303.7972F * paramFloat) & 0x1FFF)];
  }
  
  public static final float sin(float paramFloat)
  {
    return advf.b.L[((int)(1303.7972F * paramFloat) & 0x1FFF)];
  }
  
  static class a
  {
    static final float[] L;
    
    static
    {
      int k = 0;
      L = new float[8192];
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= 8192) {
          break;
        }
        L[i] = ((float)Math.cos((i + 0.5F) / 8192.0F * 6.283186F));
        i += 1;
      }
      while (j < 360)
      {
        L[((int)(j * 22.755556F) & 0x1FFF)] = ((float)Math.cos(j * 0.01745329F));
        j += 90;
      }
    }
  }
  
  static class b
  {
    static final float[] L;
    
    static
    {
      int k = 0;
      L = new float[8192];
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= 8192) {
          break;
        }
        L[i] = ((float)Math.sin((i + 0.5F) / 8192.0F * 6.283186F));
        i += 1;
      }
      while (j < 360)
      {
        L[((int)(j * 22.755556F) & 0x1FFF)] = ((float)Math.sin(j * 0.01745329F));
        j += 90;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advf
 * JD-Core Version:    0.7.0.1
 */