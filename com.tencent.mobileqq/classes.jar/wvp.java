import java.util.Comparator;

public class wvp
  implements Comparator<wvn>
{
  public int a(wvn paramwvn1, wvn paramwvn2)
  {
    if (paramwvn1.c < paramwvn2.c) {
      return 1;
    }
    if (paramwvn1.c > paramwvn2.c) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvp
 * JD-Core Version:    0.7.0.1
 */