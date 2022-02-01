import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import java.util.List;

public abstract class altk
{
  private static int seed;
  public int key;
  
  public altk()
  {
    int i = seed;
    seed = i + 1;
    this.key = i;
  }
  
  public abstract void g(String paramString, List<NumRedMsg.NumMsgBusi> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altk
 * JD-Core Version:    0.7.0.1
 */