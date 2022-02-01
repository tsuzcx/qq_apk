import PersonalState.UserProfile;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.Comparator;

public class gie
  implements Comparator
{
  public gie(StatusManager paramStatusManager) {}
  
  public int a(UserProfile paramUserProfile1, UserProfile paramUserProfile2)
  {
    return (int)(paramUserProfile2.richTime - paramUserProfile1.richTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gie
 * JD-Core Version:    0.7.0.1
 */