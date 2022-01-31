import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import java.util.Comparator;

public class yel
  implements Comparator
{
  public yel(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  public int a(NewFriendMessage paramNewFriendMessage1, NewFriendMessage paramNewFriendMessage2)
  {
    return (int)(paramNewFriendMessage2.a - paramNewFriendMessage1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yel
 * JD-Core Version:    0.7.0.1
 */