import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;

public class avk
  extends Thread
{
  public avk(ModifyFriendInfoActivity paramModifyFriendInfoActivity) {}
  
  public void run()
  {
    Object localObject = (FriendManager)this.a.app.getManager(8);
    Friends localFriends = ((FriendManager)localObject).c(this.a.jdField_a_of_type_JavaLangString);
    if (localFriends != null)
    {
      this.a.jdField_a_of_type_Int = localFriends.groupid;
      localObject = ((FriendManager)localObject).a(this.a.jdField_a_of_type_Int + "");
      if (localObject != null) {
        this.a.d = ((Groups)localObject).group_name;
      }
    }
    if (this.a.jdField_a_of_type_Int == -1)
    {
      this.a.runOnUiThread(new avl(this));
      return;
    }
    localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 2;
    ((Message)localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avk
 * JD-Core Version:    0.7.0.1
 */