import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import java.util.Comparator;

public class yhs
  implements Comparator
{
  public yhs(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  public int a(NewFriendMessage paramNewFriendMessage1, NewFriendMessage paramNewFriendMessage2)
  {
    return (int)(paramNewFriendMessage2.a - paramNewFriendMessage1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yhs
 * JD-Core Version:    0.7.0.1
 */