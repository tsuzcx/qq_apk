import java.util.Comparator;

final class zcv
  implements Comparator<zct>
{
  public int a(zct paramzct1, zct paramzct2)
  {
    if ((paramzct1 == null) && (paramzct2 == null)) {}
    do
    {
      return 0;
      if ((paramzct1 == null) && (paramzct2 != null)) {
        return 1;
      }
      if ((paramzct1 != null) && (paramzct2 == null)) {
        return -1;
      }
      if (paramzct1.a() > paramzct2.a()) {
        return -1;
      }
    } while (paramzct1.a() >= paramzct2.a());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcv
 * JD-Core Version:    0.7.0.1
 */