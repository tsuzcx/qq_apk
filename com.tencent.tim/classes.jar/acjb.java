import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountHandler.4.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;

public class acjb
  implements QQPermissionCallback
{
  public acjb(PublicAccountHandler paramPublicAccountHandler, int paramInt, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PublicAccountHandler", 1, "User requestPermissions denied...");
    ThreadManager.getSubThreadHandler().post(new PublicAccountHandler.4.1(this));
    aqha.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PublicAccountHandler", 1, "User requestPermissions grant...");
    PublicAccountHandler.a(this.this$0, this.val$type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acjb
 * JD-Core Version:    0.7.0.1
 */