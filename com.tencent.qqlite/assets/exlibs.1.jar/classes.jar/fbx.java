import android.text.Editable;
import com.tencent.open.agent.SendStoryActivity;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class fbx
  implements Comparator
{
  public fbx(SendStoryActivity paramSendStoryActivity, Editable paramEditable) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend1) - this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fbx
 * JD-Core Version:    0.7.0.1
 */