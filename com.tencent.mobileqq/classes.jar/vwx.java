import java.util.Comparator;

final class vwx
  implements Comparator<vxg>
{
  public int a(vxg paramvxg1, vxg paramvxg2)
  {
    if (paramvxg1.a() > paramvxg2.a()) {}
    do
    {
      return 1;
      if (paramvxg1.a() < paramvxg2.a()) {
        return -1;
      }
      if (paramvxg1.d() == paramvxg2.d()) {
        return 0;
      }
    } while (paramvxg1.d() < paramvxg2.d());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwx
 * JD-Core Version:    0.7.0.1
 */