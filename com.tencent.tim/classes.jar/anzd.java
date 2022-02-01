import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class anzd
{
  private static anzd a;
  private String aDd;
  private long aof = -1L;
  private long aog = -1L;
  private boolean cKO;
  private HashMap<Long, structmsg.StructMsg> nI = new HashMap();
  
  public static anzd a()
  {
    if (a == null) {
      a = new anzd();
    }
    return a;
  }
  
  public void M(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendSystemMsgController", 2, "setUnReadFriendSystemMsgNum count = " + paramInt, new Throwable("debug"));
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putInt("sp_unread_friendsys_count", paramInt).commit();
    }
  }
  
  public void U(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putBoolean("sp_is_sysmsg_over", paramBoolean).commit();
    }
  }
  
  public structmsg.StructMsg a(Long paramLong)
  {
    structmsg.StructMsg localStructMsg = null;
    if (this.nI != null) {
      localStructMsg = (structmsg.StructMsg)this.nI.get(paramLong);
    }
    return localStructMsg;
  }
  
  public void a(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    if (this.nI != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendSystemMsgController", 2, "putStructMsgToMap key=" + paramLong);
      }
      this.nI.put(paramLong, paramStructMsg);
    }
  }
  
  public int ac(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("sp_unread_friendsys_count", 0);
    }
    return i;
  }
  
  public boolean bI(QQAppInterface paramQQAppInterface)
  {
    if ((this.aDd != null) && (!this.aDd.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      this.cKO = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("friend_system_msg_nomore_msg", false);
    }
    return this.cKO;
  }
  
  public boolean bJ(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      bool = paramQQAppInterface.getBoolean("sp_is_sysmsg_over", false);
    }
    return bool;
  }
  
  public void c(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.cKO = paramBoolean;
    this.aDd = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface.execute(new FriendSystemMsgController.1(this, paramQQAppInterface, paramBoolean));
  }
  
  public void dTX()
  {
    a = null;
  }
  
  public void dTY()
  {
    if (this.nI != null) {
      this.nI.clear();
    }
  }
  
  public long he()
  {
    return this.aog;
  }
  
  public long hf()
  {
    return this.aof;
  }
  
  public void lB(long paramLong)
  {
    this.aog = paramLong;
  }
  
  public void lC(long paramLong)
  {
    this.aof = paramLong;
  }
  
  public long p(QQAppInterface paramQQAppInterface)
  {
    long l = 0L;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      l = paramQQAppInterface.getLong("sp_oldest_friendmsg", 0L);
    }
    return l;
  }
  
  public void t(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.edit().putLong("sp_oldest_friendmsg", paramLong).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzd
 * JD-Core Version:    0.7.0.1
 */