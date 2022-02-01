import java.util.Comparator;

final class tnr
  implements Comparator<tnp>
{
  public int a(tnp paramtnp1, tnp paramtnp2)
  {
    if ((paramtnp1 == null) && (paramtnp2 == null)) {}
    do
    {
      return 0;
      if ((paramtnp1 == null) && (paramtnp2 != null)) {
        return 1;
      }
      if ((paramtnp1 != null) && (paramtnp2 == null)) {
        return -1;
      }
      if (paramtnp1.uX() > paramtnp2.uX()) {
        return -1;
      }
    } while (paramtnp1.uX() >= paramtnp2.uX());
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tnr
 * JD-Core Version:    0.7.0.1
 */