import java.util.Comparator;

class pks
  implements Comparator<pkd.a>
{
  pks(pkr parampkr) {}
  
  public int a(pkd.a parama1, pkd.a parama2)
  {
    if (parama1.mCreateTime == parama2.mCreateTime) {
      return 0;
    }
    if (parama1.mCreateTime > parama2.mCreateTime) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pks
 * JD-Core Version:    0.7.0.1
 */