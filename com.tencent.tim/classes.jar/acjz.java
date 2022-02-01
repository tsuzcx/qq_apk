import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public class acjz
{
  private acgs a = new ackb(this);
  private QQAppInterface app;
  private BroadcastReceiver mBroadcastReceiver = new acka(this);
  private Context mContext;
  
  public acjz(String paramString)
  {
    try
    {
      this.mContext = BaseApplication.getContext();
      this.app = ((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString));
      paramString = new IntentFilter();
      paramString.addAction("com.tencent.mobileqq.addLbsObserver");
      paramString.addAction("com.tencent.mobileqq.removeLbsObserver");
      paramString.addAction("com.tencent.mobileqq.getStreetViewUrl");
      paramString.addAction("com.tencent.mobileqq.unregisterReceiver");
      paramString.addAction("com.tencent.mobileqq.getLbsShareSearch");
      paramString.addAction("com.tencent.mobileqq.getLbsShareShop");
      paramString.addAction("com.tencent.mobileqq.getShareShopDetail");
      this.mContext.registerReceiver(this.mBroadcastReceiver, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("QQMapActivityProxy", 2, "QQMapActivityProxy-create, registerReceiver:" + hashCode() + ", " + this.mBroadcastReceiver.hashCode());
      }
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQMapActivityProxy", 2, "AccountNotMatchException " + paramString.toString());
        }
      }
    }
  }
  
  public void onDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivityProxy", 2, "onDestory,  hashCode=" + hashCode());
    }
    if (this.app != null) {
      this.app.removeObserver(this.a);
    }
    try
    {
      this.mContext.unregisterReceiver(this.mBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QQMapActivityProxy", 2, "onDestory, mBroadcastReceiver throw an exception when receive UNREGISTER_RECEIVER : " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acjz
 * JD-Core Version:    0.7.0.1
 */