import java.util.Random;

public final class imt
{
  static final int apX = (int)Math.sqrt(16384.0D);
  private static final float gj = 1.0F / (apX - 1);
  public static Random random = new Random();
  
  public static final float N()
  {
    return random.nextFloat();
  }
  
  public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  public static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static final float m(float paramFloat)
  {
    return imt.a.L[((int)(45.511112F * paramFloat) & 0x3FFF)];
  }
  
  public static final float n(float paramFloat)
  {
    return imt.a.L[((int)((90.0F + paramFloat) * 45.511112F) & 0x3FFF)];
  }
  
  public static final float o(float paramFloat)
  {
    return random.nextFloat() * paramFloat;
  }
  
  public static final int random(int paramInt)
  {
    return random.nextInt(paramInt + 1);
  }
  
  public static final boolean uc()
  {
    return random.nextBoolean();
  }
  
  static class a
  {
    static final float[] L;
    
    static
    {
      int k = 0;
      L = new float[16384];
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= 16384) {
          break;
        }
        L[i] = ((float)Math.sin((i + 0.5F) / 16384.0F * 6.283186F));
        i += 1;
      }
      while (j < 360)
      {
        L[((int)(j * 45.511112F) & 0x3FFF)] = ((float)Math.sin(j * 0.01745329F));
        j += 90;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imt
 * JD-Core Version:    0.7.0.1
 */