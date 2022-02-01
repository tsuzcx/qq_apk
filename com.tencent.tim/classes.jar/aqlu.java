import java.util.Random;

public class aqlu
{
  private static final Random RANDOM = new Random();
  
  public static int nextInt(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return paramInt1;
    }
    return paramInt1 + RANDOM.nextInt(paramInt2 - paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqlu
 * JD-Core Version:    0.7.0.1
 */