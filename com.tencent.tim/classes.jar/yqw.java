import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class yqw
  extends accn
{
  yqw(yqv paramyqv) {}
  
  protected void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    yqv.a(this.b, yqv.a(this.b, paramInt));
    if ((yqv.a(this.b)) && (yqv.a(this.b) != null)) {
      this.b.zg(yqv.a(this.b).getCurrentUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqw
 * JD-Core Version:    0.7.0.1
 */