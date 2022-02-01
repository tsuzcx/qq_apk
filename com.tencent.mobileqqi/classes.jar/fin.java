import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;

public class fin
  extends FriendListObserver
{
  private fin(UpdateFriend paramUpdateFriend) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.a.a(6);
    }
    while ((!paramBoolean1) || (!paramBoolean2)) {
      return;
    }
    UpdateFriend.a(this.a).a.edit().putBoolean("isFriendlistok", true).commit();
    UpdateFriend.b(this.a).a(3, true, Integer.valueOf(1));
    this.a.a(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fin
 * JD-Core Version:    0.7.0.1
 */