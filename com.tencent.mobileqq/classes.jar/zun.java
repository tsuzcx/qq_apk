import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import java.util.Comparator;
import java.util.Map.Entry;

public class zun
  implements Comparator
{
  public zun(MsgLruCache paramMsgLruCache) {}
  
  public int a(Map.Entry paramEntry1, Map.Entry paramEntry2)
  {
    if (((Integer)paramEntry1.getValue()).intValue() < ((Integer)paramEntry2.getValue()).intValue()) {
      return 1;
    }
    if (paramEntry1.getValue() == paramEntry2.getValue()) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zun
 * JD-Core Version:    0.7.0.1
 */