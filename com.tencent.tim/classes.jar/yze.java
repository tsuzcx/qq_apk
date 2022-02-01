import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class yze
  extends yqy
{
  public yze(Contacts paramContacts) {}
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.onGetAddFriendBlockedRedPoint, success=" + paramBoolean1 + ",blockedUin=" + paramString);
    }
    ((ysf)this.a.app.getManager(34)).clp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yze
 * JD-Core Version:    0.7.0.1
 */