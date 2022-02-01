import java.util.Comparator;

public class wma
  implements Comparator<wly>
{
  public int a(wly paramwly1, wly paramwly2)
  {
    if (paramwly1.c < paramwly2.c) {
      return 1;
    }
    if (paramwly1.c > paramwly2.c) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wma
 * JD-Core Version:    0.7.0.1
 */