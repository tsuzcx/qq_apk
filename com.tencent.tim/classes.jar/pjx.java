import java.util.Comparator;

final class pjx
  implements Comparator<pkd.a>
{
  public int a(pkd.a parama1, pkd.a parama2)
  {
    if ((parama1 == parama2) || (parama1.mCreateTime == parama2.mCreateTime)) {
      return 0;
    }
    if (parama1.mCreateTime < parama2.mCreateTime) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjx
 * JD-Core Version:    0.7.0.1
 */