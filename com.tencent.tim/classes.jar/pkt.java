import java.util.Comparator;

class pkt
  implements Comparator<pkd>
{
  pkt(pkr parampkr) {}
  
  public int a(pkd parampkd1, pkd parampkd2)
  {
    if (parampkd1.getStartTime() == parampkd2.getStartTime()) {
      return 0;
    }
    if (parampkd1.getStartTime() > parampkd2.getStartTime()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkt
 * JD-Core Version:    0.7.0.1
 */