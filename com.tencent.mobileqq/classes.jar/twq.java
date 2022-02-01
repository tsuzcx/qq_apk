import java.util.Comparator;

final class twq
  implements Comparator<twv>
{
  public int a(twv paramtwv1, twv paramtwv2)
  {
    int j = paramtwv1.a - paramtwv2.a;
    int i = j;
    if (j == 0) {
      i = paramtwv1.b - paramtwv2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twq
 * JD-Core Version:    0.7.0.1
 */