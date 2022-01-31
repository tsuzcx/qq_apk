import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.ApolloManager.CheckApolloInfoResult;
import com.tencent.qphone.base.util.QLog;

public class tkr
  extends Handler
{
  public tkr(QQSettingMe paramQQSettingMe, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.n();
      return;
      QQSettingMe.a(this.a);
      return;
      if (QQSettingMe.a(this.a))
      {
        QLog.i("QQSettingRedesign", 1, "MSG_CODE_REFRESH_APOLLO on DrawerClosed!");
        return;
      }
    } while (!(paramMessage.obj instanceof ApolloManager.CheckApolloInfoResult));
    QQSettingMe.a(this.a, (ApolloManager.CheckApolloInfoResult)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkr
 * JD-Core Version:    0.7.0.1
 */