package mqq.app;

import com.tencent.mobileqq.Pandora.util.Log.ILogCallback;
import com.tencent.qphone.base.util.QLog;

class WtloginPrivacyListenerImpl$1
  implements Log.ILogCallback
{
  WtloginPrivacyListenerImpl$1(WtloginPrivacyListenerImpl paramWtloginPrivacyListenerImpl) {}
  
  public void onWriteLog(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  public void onWriteLog(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void onWriteLog(String paramString, byte[] paramArrayOfByte)
  {
    QLog.d(paramString, 1, new Object[] { paramArrayOfByte });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.WtloginPrivacyListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */