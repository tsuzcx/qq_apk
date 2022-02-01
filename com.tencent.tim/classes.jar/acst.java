import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import java.util.Comparator;
import java.util.Map.Entry;

public class acst
  implements Comparator<Map.Entry<String, Integer>>
{
  public acst(MsgLruCache paramMsgLruCache) {}
  
  public int compare(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acst
 * JD-Core Version:    0.7.0.1
 */