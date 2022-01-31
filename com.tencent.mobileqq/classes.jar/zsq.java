import java.util.Comparator;

public class zsq
  implements Comparator
{
  public int a(zsp paramzsp1, zsp paramzsp2)
  {
    if (paramzsp1.b < paramzsp2.b) {
      return -1;
    }
    if (paramzsp1.b > paramzsp2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsq
 * JD-Core Version:    0.7.0.1
 */