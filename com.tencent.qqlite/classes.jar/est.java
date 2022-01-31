import java.util.Comparator;

public final class est
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    long l1 = Long.parseLong(((java.lang.String[])(java.lang.String[])paramObject1)[1]);
    long l2 = Long.parseLong(((java.lang.String[])(java.lang.String[])paramObject2)[1]);
    if (l1 == l2) {
      return 0;
    }
    if (l1 < l2) {
      return 2;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     est
 * JD-Core Version:    0.7.0.1
 */