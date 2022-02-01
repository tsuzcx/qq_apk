import java.util.Comparator;

public class acse
  implements Comparator<acsf>
{
  private int czO;
  
  public acse(int paramInt)
  {
    this.czO = paramInt;
  }
  
  public int a(acsf paramacsf1, acsf paramacsf2)
  {
    if (this.czO == 2) {
      if (paramacsf1.lastMsgTime <= paramacsf2.lastMsgTime) {}
    }
    while (paramacsf1.totalSize > paramacsf2.totalSize)
    {
      return -1;
      if (paramacsf1.lastMsgTime < paramacsf2.lastMsgTime) {
        return 1;
      }
      return 0;
    }
    if (paramacsf1.totalSize < paramacsf2.totalSize) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acse
 * JD-Core Version:    0.7.0.1
 */