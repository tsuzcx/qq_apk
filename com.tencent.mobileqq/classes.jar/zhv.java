import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import java.util.Comparator;

public class zhv
  implements Comparator
{
  public zhv(NewFriendManager paramNewFriendManager) {}
  
  public int a(NewFriendMessage paramNewFriendMessage1, NewFriendMessage paramNewFriendMessage2)
  {
    return (int)(paramNewFriendMessage2.a - paramNewFriendMessage1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhv
 * JD-Core Version:    0.7.0.1
 */