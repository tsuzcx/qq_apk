import android.text.Editable;
import com.tencent.open.agent.SendStoryActivity.a;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class arss
  implements Comparator<Friend>
{
  public arss(SendStoryActivity.a parama, Editable paramEditable) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return this.g.getSpanStart(paramFriend2) - this.g.getSpanStart(paramFriend1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arss
 * JD-Core Version:    0.7.0.1
 */