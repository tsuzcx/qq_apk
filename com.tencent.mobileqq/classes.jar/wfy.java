import java.util.Comparator;

final class wfy
  implements Comparator<wgh>
{
  public int a(wgh paramwgh1, wgh paramwgh2)
  {
    if ((paramwgh1 == paramwgh2) || (paramwgh1.b == paramwgh2.b)) {
      return 0;
    }
    if (paramwgh1.b < paramwgh2.b) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfy
 * JD-Core Version:    0.7.0.1
 */