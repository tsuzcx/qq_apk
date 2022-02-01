import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zol
{
  public static zof a(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int i = paramSessionInfo.cZ;
    Object localObject = null;
    if (paramSessionInfo.bPu == 3) {
      paramSessionInfo = new zoo(paramContext, paramSessionInfo, paramQQAppInterface);
    }
    do
    {
      return paramSessionInfo;
      switch (i)
      {
      default: 
        paramContext = localObject;
        paramSessionInfo = paramContext;
      }
    } while (!QLog.isColorLevel());
    paramQQAppInterface = new StringBuilder().append("getChatPie uinType = ").append(i).append(" miniPie ");
    if (paramContext == null) {}
    for (paramSessionInfo = "null";; paramSessionInfo = Integer.valueOf(paramContext.hashCode()))
    {
      QLog.i("MiniPieFactory", 2, paramSessionInfo);
      return paramContext;
      paramContext = new zom(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new zon(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new zor(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new zoq(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
      paramContext = new zop(paramContext, paramSessionInfo, paramQQAppInterface);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zol
 * JD-Core Version:    0.7.0.1
 */