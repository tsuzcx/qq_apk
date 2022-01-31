import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.qphone.base.util.BaseApplication;

public class zrl
  implements Runnable
{
  public zrl(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext();
    String str = this.a.getCurrentAccountUin();
    localObject = ConfigManager.getInstance((Context)localObject, this.a, this.a.getAppid(), str);
    if (localObject != null) {
      ((ConfigManager)localObject).onProxyIpChanged(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrl
 * JD-Core Version:    0.7.0.1
 */