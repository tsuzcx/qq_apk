import java.util.Comparator;

public class arkg
  implements Comparator<arkf>
{
  public int a(arkf paramarkf1, arkf paramarkf2)
  {
    if (paramarkf1.getTimeInMillis() < paramarkf2.getTimeInMillis()) {
      return -1;
    }
    if (paramarkf1.getTimeInMillis() == paramarkf2.getTimeInMillis()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkg
 * JD-Core Version:    0.7.0.1
 */