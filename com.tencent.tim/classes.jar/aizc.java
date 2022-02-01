import android.content.Intent;
import com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.manager.Manager;

public class aizc
  implements Manager
{
  public static String bQi = "QQ";
  public static String bQj = "extra_notify_msg";
  public RecentItemPullActivePush a;
  public Intent ae;
  private MessageForText b;
  private QQAppInterface mApp;
  
  public aizc(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public MessageForText a()
  {
    if (this.a == null) {
      return null;
    }
    if (this.b == null)
    {
      this.b = ((MessageForText)anbi.d(-1000));
      this.b.msgtype = -1000;
      this.b.istroop = 9653;
      this.b.isread = false;
      this.b.selfuin = this.mApp.getCurrentAccountUin();
      this.b.senderuin = acbn.blt;
      this.b.frienduin = acbn.blt;
      if (this.ae != null) {
        this.b.msg = this.ae.getStringExtra(bQj);
      }
      this.b.time = this.a.time;
    }
    if ((this.b.msg == null) || (!this.b.msg.equals(this.a.mTitleName))) {
      this.b.msg = this.a.mTitleName;
    }
    if (this.b.time != this.a.time) {
      this.b.time = this.a.time;
    }
    return this.b;
  }
  
  public void aIH()
  {
    this.a = null;
  }
  
  public void dA(Intent paramIntent)
  {
    if (this.a == null)
    {
      localObject = new RecentUser(acbn.blt, 9653);
      ((RecentUser)localObject).msgType = -1000;
      this.a = new RecentItemPullActivePush((RecentUser)localObject);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = paramIntent.getStringExtra(bQj);
    this.a.init((String)localObject, l);
    this.ae = paramIntent;
  }
  
  public int getUnreadCount()
  {
    if (this.a == null) {
      return 0;
    }
    return 1;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizc
 * JD-Core Version:    0.7.0.1
 */