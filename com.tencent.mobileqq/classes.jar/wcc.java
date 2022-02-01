import java.util.Comparator;

final class wcc
  implements Comparator<wcl>
{
  public int a(wcl paramwcl1, wcl paramwcl2)
  {
    if (paramwcl1.a() > paramwcl2.a()) {}
    do
    {
      return 1;
      if (paramwcl1.a() < paramwcl2.a()) {
        return -1;
      }
      if (paramwcl1.d() == paramwcl2.d()) {
        return 0;
      }
    } while (paramwcl1.d() < paramwcl2.d());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcc
 * JD-Core Version:    0.7.0.1
 */