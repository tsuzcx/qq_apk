import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;
import java.lang.ref.WeakReference;

public class bzx
  implements TroopFileError.TroopFileErrorFilter
{
  private WeakReference a;
  
  public bzx(ChatActivity paramChatActivity)
  {
    this.a = new WeakReference(paramChatActivity);
  }
  
  public long a()
  {
    if (this.a != null)
    {
      ChatActivity localChatActivity = (ChatActivity)this.a.get();
      if ((localChatActivity != null) && (localChatActivity.a.jdField_a_of_type_Int == 1)) {
        try
        {
          long l = Long.parseLong(localChatActivity.a.jdField_a_of_type_JavaLangString);
          return l;
        }
        catch (Exception localException)
        {
          return 0L;
        }
      }
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzx
 * JD-Core Version:    0.7.0.1
 */