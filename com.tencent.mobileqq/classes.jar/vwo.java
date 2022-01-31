import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

public class vwo
  extends FriendListObserver
{
  public vwo(NearbyChatPie paramNearbyChatPie) {}
  
  protected void onAddFriend(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString))
    {
      Intent localIntent = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      localIntent.putExtra("uintype", 0);
      NearbyChatPie.b(this.a, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.f + "Q.nearby.follow", 2, "onAddFriend, addUin:" + paramString + "|updateSession");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwo
 * JD-Core Version:    0.7.0.1
 */