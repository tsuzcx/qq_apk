import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.qphone.base.util.QLog;

public class dxc
  extends TroopObserver
{
  public dxc(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if (paramInt == 3) {
      this.a.a.sendMessage(this.a.a.obtainMessage(7));
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    Handler localHandler;
    if (paramInt == 3)
    {
      if (paramByte == 0)
      {
        this.a.c(this.a.i);
        paramString = this.a.b(TroopMemberListActivity.a(this.a));
        this.a.a.sendMessage(this.a.a.obtainMessage(2, paramString));
      }
      paramString = this.a.a;
      localHandler = this.a.a;
      if (paramByte != 0) {
        break label97;
      }
    }
    label97:
    for (paramInt = 6;; paramInt = 7)
    {
      paramString.sendMessage(localHandler.obtainMessage(paramInt));
      return;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "read troop members from database after updating data from server");
      }
      this.a.getSharedPreferences("last_update_time" + this.a.b.a(), 0).edit().putLong("key_last_update_time" + TroopMemberListActivity.a(this.a), System.currentTimeMillis()).commit();
      this.a.a.removeMessages(1);
      Object[] arrayOfObject = this.a.b(TroopMemberListActivity.a(this.a));
      this.a.a.sendMessage(this.a.a.obtainMessage(2, arrayOfObject));
    }
    catch (Exception localException)
    {
      label147:
      break label147;
    }
    this.a.a.sendMessage(this.a.a.obtainMessage(5));
  }
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3)
  {
    this.a.runOnUiThread(new dxd(this, paramBoolean1, paramString1, paramBoolean2, paramString2, paramString3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dxc
 * JD-Core Version:    0.7.0.1
 */