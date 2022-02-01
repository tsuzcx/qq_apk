import java.util.Comparator;

public class wru
  implements Comparator<wrs>
{
  public int a(wrs paramwrs1, wrs paramwrs2)
  {
    if (paramwrs1.c < paramwrs2.c) {
      return 1;
    }
    if (paramwrs1.c > paramwrs2.c) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wru
 * JD-Core Version:    0.7.0.1
 */