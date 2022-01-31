import java.util.Comparator;

final class uir
  implements Comparator<uja>
{
  public int a(uja paramuja1, uja paramuja2)
  {
    if ((paramuja1 == paramuja2) || (paramuja1.b == paramuja2.b)) {
      return 0;
    }
    if (paramuja1.b < paramuja2.b) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uir
 * JD-Core Version:    0.7.0.1
 */