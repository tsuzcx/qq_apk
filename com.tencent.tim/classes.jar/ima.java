import java.util.Comparator;

final class ima
  implements Comparator<ilz>
{
  public int a(ilz paramilz1, ilz paramilz2)
  {
    if (paramilz1 == paramilz2) {
      return 0;
    }
    if (paramilz1 == null) {
      return -1;
    }
    if (paramilz2 == null) {
      return 1;
    }
    return paramilz1.start - paramilz2.start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ima
 * JD-Core Version:    0.7.0.1
 */