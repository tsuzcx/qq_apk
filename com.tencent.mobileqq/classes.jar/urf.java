import java.util.Comparator;

final class urf
  implements Comparator<urk>
{
  public int a(urk paramurk1, urk paramurk2)
  {
    int j = paramurk1.a - paramurk2.a;
    int i = j;
    if (j == 0) {
      i = paramurk1.b - paramurk2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urf
 * JD-Core Version:    0.7.0.1
 */