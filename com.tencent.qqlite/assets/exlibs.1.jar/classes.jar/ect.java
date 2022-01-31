import PersonalState.UserProfile;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.Comparator;

public class ect
  implements Comparator
{
  public ect(StatusManager paramStatusManager) {}
  
  public int a(UserProfile paramUserProfile1, UserProfile paramUserProfile2)
  {
    return (int)(paramUserProfile2.richTime - paramUserProfile1.richTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ect
 * JD-Core Version:    0.7.0.1
 */