import java.util.Comparator;

final class wfx
  implements Comparator<wgg>
{
  public int a(wgg paramwgg1, wgg paramwgg2)
  {
    if (paramwgg1.a() > paramwgg2.a()) {}
    do
    {
      return 1;
      if (paramwgg1.a() < paramwgg2.a()) {
        return -1;
      }
      if (paramwgg1.d() == paramwgg2.d()) {
        return 0;
      }
    } while (paramwgg1.d() < paramwgg2.d());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfx
 * JD-Core Version:    0.7.0.1
 */