import java.util.Comparator;

final class zcs
  implements Comparator<zcq>
{
  public int a(zcq paramzcq1, zcq paramzcq2)
  {
    if ((paramzcq1 == null) && (paramzcq2 == null)) {}
    do
    {
      return 0;
      if ((paramzcq1 == null) && (paramzcq2 != null)) {
        return 1;
      }
      if ((paramzcq1 != null) && (paramzcq2 == null)) {
        return -1;
      }
      if (paramzcq1.a() > paramzcq2.a()) {
        return -1;
      }
    } while (paramzcq1.a() >= paramzcq2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcs
 * JD-Core Version:    0.7.0.1
 */