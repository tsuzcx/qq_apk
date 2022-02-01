import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class afsn
  implements afxt
{
  afsn(afsi paramafsi) {}
  
  public void a(boolean paramBoolean, aftc paramaftc)
  {
    if (afsi.a(this.this$0) == null)
    {
      QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo null");
      return;
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT suc");
    }
    if (this.this$0.akf())
    {
      ((afsg)afsi.a(this.this$0).getBusinessHandler(127)).a(paramaftc);
      QLog.i("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT suc:" + paramBoolean);
      return;
    }
    QLog.e("ExtendFriendManager", 2, "enterExtendFriend onGetLocationInfo NOT In extendfriend");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsn
 * JD-Core Version:    0.7.0.1
 */