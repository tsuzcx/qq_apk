import android.text.Editable;
import com.tencent.open.agent.SendStoryActivity;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class hnr
  implements Comparator
{
  public hnr(SendStoryActivity paramSendStoryActivity, Editable paramEditable) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend1) - this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hnr
 * JD-Core Version:    0.7.0.1
 */