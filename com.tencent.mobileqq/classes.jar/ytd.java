import java.util.Comparator;

final class ytd
  implements Comparator<ytb>
{
  public int a(ytb paramytb1, ytb paramytb2)
  {
    if ((paramytb1 == null) && (paramytb2 == null)) {}
    do
    {
      return 0;
      if ((paramytb1 == null) && (paramytb2 != null)) {
        return 1;
      }
      if ((paramytb1 != null) && (paramytb2 == null)) {
        return -1;
      }
      if (paramytb1.a() > paramytb2.a()) {
        return -1;
      }
    } while (paramytb1.a() >= paramytb2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ytd
 * JD-Core Version:    0.7.0.1
 */