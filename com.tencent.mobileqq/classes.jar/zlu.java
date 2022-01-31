import java.util.Comparator;

public class zlu
  implements Comparator
{
  public int a(zlt paramzlt1, zlt paramzlt2)
  {
    if (paramzlt1.b < paramzlt2.b) {
      return -1;
    }
    if (paramzlt1.b > paramzlt2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zlu
 * JD-Core Version:    0.7.0.1
 */