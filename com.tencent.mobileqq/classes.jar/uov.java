import java.util.Comparator;

public class uov
  implements Comparator<uon>
{
  public uov(uot paramuot) {}
  
  public int a(uon paramuon1, uon paramuon2)
  {
    long l1 = paramuon1.a;
    long l2 = paramuon2.a;
    if (l2 > l1) {
      return 1;
    }
    if (l2 < l1) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uov
 * JD-Core Version:    0.7.0.1
 */