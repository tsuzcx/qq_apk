import java.util.Comparator;

final class udi
  implements Comparator<udn>
{
  public int a(udn paramudn1, udn paramudn2)
  {
    int j = paramudn1.a - paramudn2.a;
    int i = j;
    if (j == 0) {
      i = paramudn1.b - paramudn2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     udi
 * JD-Core Version:    0.7.0.1
 */