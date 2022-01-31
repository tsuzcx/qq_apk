package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.Action;

public class SSOAccountObserver
  implements BusinessObserver, Constants.Action
{
  public static final String TAG = "SSOAccountObserver";
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle) {}
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle) {}
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = paramBundle.getInt("code");
    String str = paramBundle.getString("ssoAccount");
    int k = paramBundle.getInt("targetTicket", 4096);
    int m = paramBundle.getInt("ret");
    byte[] arrayOfByte = paramBundle.getByteArray("wtTicket");
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("account:").append(str).append(" action:").append(paramInt).append(" code:").append(j).append(" isSuccess:").append(paramBoolean).append(" ret:").append(m).append(" wtTicketArr:");
      if (arrayOfByte == null)
      {
        localObject = "null";
        QLog.d("SSOAccountObserver", 2, localObject);
      }
    }
    else
    {
      i = 0;
      if (m == 0) {
        i = 1;
      }
    }
    switch (paramInt)
    {
    default: 
    case 1100: 
    case 1101: 
      do
      {
        return;
        localObject = Integer.valueOf(arrayOfByte.length);
        break;
        if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
          i = 0;
        }
        if (i == 0) {
          break label245;
        }
        if (paramInt == 1100)
        {
          onLoginSuccess(str, arrayOfByte, k, paramBundle);
          return;
        }
      } while (paramInt != 1101);
      onGetTicketNoPasswd(str, arrayOfByte, k, paramBundle);
      return;
      label245:
      if (j == 2006)
      {
        onUserCancel(str, paramInt, paramBundle);
        return;
      }
      onFailed(str, paramInt, m, paramBundle);
      return;
    }
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      i = 0;
    }
    if (i != 0)
    {
      onGetA1WithA1(str, m, arrayOfByte, k, paramBundle);
      return;
    }
    if (j == 2006)
    {
      onUserCancel(str, paramInt, paramBundle);
      return;
    }
    onFailed(str, paramInt, m, paramBundle);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.observer.SSOAccountObserver
 * JD-Core Version:    0.7.0.1
 */