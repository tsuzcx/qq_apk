import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class alsq
  extends QIPCModule
{
  private static alsq a;
  private static Object sLock = new Object();
  
  private alsq(String paramString)
  {
    super(paramString);
  }
  
  public static alsq a()
  {
    if (a != null) {
      return a;
    }
    synchronized (sLock)
    {
      if (a == null) {
        a = new alsq("REAL_NAME");
      }
      alsq localalsq = a;
      return localalsq;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RealName", 2, "onCall s: " + paramString);
    }
    if (paramBundle == null) {}
    do
    {
      return null;
      paramInt = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("source");
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "result is : " + paramInt);
      }
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle != null) && (paramString != null) && (TextUtils.equals(paramBundle, "watchtogether")))
      {
        paramBundle = (accy)paramString.getBusinessHandler(4);
        if (paramBundle != null)
        {
          if (paramInt == 0) {}
          for (boolean bool = true;; bool = false)
          {
            if (bool) {
              paramString.getPreferences().edit().putBoolean("has_auth_real_name_av", bool).commit();
            }
            if (QLog.isColorLevel()) {
              QLog.i("RealName", 2, "notifyUI");
            }
            paramBundle.notifyUI(15, true, new Object[] { Boolean.valueOf(bool) });
            return null;
          }
        }
      }
    } while ((paramInt == 0) || (paramString == null));
    ((accy)paramString.getBusinessHandler(4)).cId();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsq
 * JD-Core Version:    0.7.0.1
 */