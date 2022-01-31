import java.util.Comparator;

final class uei
  implements Comparator<uer>
{
  public int a(uer paramuer1, uer paramuer2)
  {
    if ((paramuer1 == paramuer2) || (paramuer1.b == paramuer2.b)) {
      return 0;
    }
    if (paramuer1.b < paramuer2.b) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uei
 * JD-Core Version:    0.7.0.1
 */