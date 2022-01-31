import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.NewFriendManager;
import java.util.HashSet;
import java.util.Iterator;

public class zib
  implements Runnable
{
  public zib(NewFriendManager paramNewFriendManager) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = NewFriendManager.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((String)localIterator.next());
      localStringBuilder.append("#");
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("new_friend", 0).edit().putString("new_friend_list", localStringBuilder.toString()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zib
 * JD-Core Version:    0.7.0.1
 */