import android.text.Editable;
import com.tencent.open.agent.SendStoryActivity;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class arsr
  implements Comparator<Friend>
{
  public arsr(SendStoryActivity paramSendStoryActivity, Editable paramEditable) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return this.g.getSpanStart(paramFriend1) - this.g.getSpanStart(paramFriend2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsr
 * JD-Core Version:    0.7.0.1
 */