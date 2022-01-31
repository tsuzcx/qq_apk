import java.util.Comparator;

final class uiq
  implements Comparator<uiz>
{
  public int a(uiz paramuiz1, uiz paramuiz2)
  {
    if (paramuiz1.a() > paramuiz2.a()) {}
    do
    {
      return 1;
      if (paramuiz1.a() < paramuiz2.a()) {
        return -1;
      }
      if (paramuiz1.d() == paramuiz2.d()) {
        return 0;
      }
    } while (paramuiz1.d() < paramuiz2.d());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uiq
 * JD-Core Version:    0.7.0.1
 */