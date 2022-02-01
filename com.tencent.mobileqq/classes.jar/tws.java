import java.util.Comparator;

final class tws
  implements Comparator<twx>
{
  public int a(twx paramtwx1, twx paramtwx2)
  {
    int j = paramtwx1.a - paramtwx2.a;
    int i = j;
    if (j == 0) {
      i = paramtwx1.b - paramtwx2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tws
 * JD-Core Version:    0.7.0.1
 */