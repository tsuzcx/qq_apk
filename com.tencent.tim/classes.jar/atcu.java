import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.activity.CallActivity;
import com.tencent.tim.call.activity.CallActivity.4.1;
import com.tencent.tim.call.activity.CallActivity.4.2;
import com.tencent.tim.call.activity.CallActivity.4.3;

public class atcu
  extends acfd
{
  public atcu(CallActivity paramCallActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CallTab", 2, " call.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {}
    while (aqft.equalsWithNullCheck(paramString, this.this$0.app.getCurrentAccountUin())) {
      return;
    }
    this.this$0.runOnUiThread(new CallActivity.4.1(this, paramString));
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CallTab", 2, "refresh CallTab, from_onupdatedelfriend");
      }
      this.this$0.etd();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CallTab", 2, "onUpdateFriendInfo uin = " + paramString + ", isSc = " + paramBoolean);
    }
    if (!paramBoolean) {}
    while (aqft.equalsWithNullCheck(paramString, this.this$0.app.getAccount())) {
      return;
    }
    this.this$0.etd();
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CallTab", 2, "refresh CallTab, from_onupdatefriendlist");
      }
      this.this$0.etd();
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CallTab", 4, "onUpdateOnlineFriend| isSuc = " + paramBoolean);
    }
    if ((CallActivity.a(this.this$0) != null) && (CallActivity.a(this.this$0).aUR))
    {
      this.this$0.runOnUiThread(new CallActivity.4.2(this, paramBoolean));
      return;
    }
    if ((paramBoolean) && (CallActivity.a(this.this$0) != null)) {
      this.this$0.runOnUiThread(new CallActivity.4.3(this));
    }
    this.this$0.etd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcu
 * JD-Core Version:    0.7.0.1
 */