import java.util.Comparator;

final class amkj
  implements Comparator<amka>
{
  public int a(amka paramamka1, amka paramamka2)
  {
    long l1 = paramamka1.gN();
    long l2 = paramamka2.gN();
    if (l1 < l2) {
      return 1;
    }
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkj
 * JD-Core Version:    0.7.0.1
 */