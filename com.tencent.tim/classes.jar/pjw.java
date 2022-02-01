import java.util.Comparator;

final class pjw
  implements Comparator<pkd>
{
  public int a(pkd parampkd1, pkd parampkd2)
  {
    if (parampkd1.getState() > parampkd2.getState()) {}
    do
    {
      return 1;
      if (parampkd1.getState() < parampkd2.getState()) {
        return -1;
      }
      if (parampkd1.dA() == parampkd2.dA()) {
        return 0;
      }
    } while (parampkd1.dA() < parampkd2.dA());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjw
 * JD-Core Version:    0.7.0.1
 */