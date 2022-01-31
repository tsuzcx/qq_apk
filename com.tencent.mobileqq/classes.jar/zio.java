import java.util.Comparator;

public class zio
  implements Comparator
{
  public int a(zin paramzin1, zin paramzin2)
  {
    if (paramzin1.b < paramzin2.b) {
      return -1;
    }
    if (paramzin1.b > paramzin2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zio
 * JD-Core Version:    0.7.0.1
 */