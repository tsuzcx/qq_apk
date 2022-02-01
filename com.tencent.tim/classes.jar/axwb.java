import java.util.Random;

public class axwb
{
  private static Random sRandom = new Random();
  
  public static axwb.a a()
  {
    int i = azbx.SCREEN_WIDTH / 4;
    int j = sRandom.nextInt(azbx.SCREEN_WIDTH / 2);
    int k = azbx.SCREEN_WIDTH / 4;
    int m = sRandom.nextInt(azbx.SCREEN_WIDTH / 2);
    return new axwb.a(i - j + azbx.SCREEN_WIDTH / 2, k - m + (azbx.cIE - azbx.dip2px(249.0F)) / 2);
  }
  
  public static class a
  {
    public int x;
    public int y;
    
    public a(int paramInt1, int paramInt2)
    {
      this.x = paramInt1;
      this.y = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwb
 * JD-Core Version:    0.7.0.1
 */