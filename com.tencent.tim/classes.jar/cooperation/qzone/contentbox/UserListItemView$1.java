package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import aqdj;
import com.tencent.mobileqq.app.BaseActivity;

class UserListItemView$1
  implements Runnable
{
  UserListItemView$1(UserListItemView paramUserListItemView, String paramString) {}
  
  public void run()
  {
    if ((UserListItemView.a(this.this$0) == null) || (UserListItemView.a(this.this$0) == null)) {
      return;
    }
    Object localObject = aqdj.g(1, 1);
    localObject = aqdj.a(((BaseActivity)UserListItemView.a(this.this$0)).app, 1, this.val$uin, 1, (Drawable)localObject, (Drawable)localObject, null);
    UserListItemView.a(this.this$0).post(new UserListItemView.1.1(this, (aqdj)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.UserListItemView.1
 * JD-Core Version:    0.7.0.1
 */