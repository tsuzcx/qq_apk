import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public final class hbj
  implements Runnable
{
  public hbj(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantUtil", 2, "Bulk fetch pendant id, size=" + AvatarPendantUtil.a().size());
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.a(1);
    if (localFriendListHandler != null)
    {
      String[] arrayOfString = new String[AvatarPendantUtil.a().size()];
      localFriendListHandler.d((String[])AvatarPendantUtil.a().toArray(arrayOfString));
    }
    AvatarPendantUtil.a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hbj
 * JD-Core Version:    0.7.0.1
 */