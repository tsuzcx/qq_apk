import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.a;
import java.util.Comparator;

public final class apry
  implements Comparator<TroopBatchAddFriendMgr.a>
{
  public int a(TroopBatchAddFriendMgr.a parama1, TroopBatchAddFriendMgr.a parama2)
  {
    return Long.signum(parama2.msgTime - parama1.msgTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apry
 * JD-Core Version:    0.7.0.1
 */