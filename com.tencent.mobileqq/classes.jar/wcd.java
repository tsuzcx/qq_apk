import java.util.Comparator;

final class wcd
  implements Comparator<wcm>
{
  public int a(wcm paramwcm1, wcm paramwcm2)
  {
    if ((paramwcm1 == paramwcm2) || (paramwcm1.b == paramwcm2.b)) {
      return 0;
    }
    if (paramwcm1.b < paramwcm2.b) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcd
 * JD-Core Version:    0.7.0.1
 */