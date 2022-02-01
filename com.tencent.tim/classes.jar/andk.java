import java.util.Calendar;

public class andk
{
  public static int jk(int paramInt)
  {
    int i = 0;
    if (paramInt > 0) {
      i = Calendar.getInstance().get(1) - ((0xFFFF0000 & paramInt) >> 16);
    }
    return i;
  }
  
  public static int jl(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return (0xFF00 & paramInt) >> 8;
  }
  
  public static int jm(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return paramInt & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     andk
 * JD-Core Version:    0.7.0.1
 */