import android.os.Bundle;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.service.circle.IFriendObserver;
import java.util.Iterator;
import java.util.LinkedList;

public class fel
  extends FriendListObserver
{
  public fel(CircleManager paramCircleManager) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString, Bundle paramBundle)
  {
    if ((paramBundle.getBoolean("isHighPriority", false)) && (this.a.c != null))
    {
      paramBundle = this.a.c.iterator();
      while (paramBundle.hasNext()) {
        ((IFriendObserver)paramBundle.next()).a(paramBoolean, paramArrayOfString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fel
 * JD-Core Version:    0.7.0.1
 */