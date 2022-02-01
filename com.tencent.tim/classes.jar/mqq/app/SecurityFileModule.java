package mqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;

public class SecurityFileModule
  extends QIPCModule
{
  public static final String ACTION_GET_BUSINESS_ROOT_PATH = "ACTION_GET_BUSINESS_ROOT_PATH";
  public static final String BUNDLE_KEY_RETURN_FILE_PATH = "BUNDLE_KEY_RETURN_FILE_PATH";
  public static final String BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME = "BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME";
  public static final String NAME = "SecurityFileModule";
  public static SecurityFileModule mInstance;
  
  public SecurityFileModule(String paramString)
  {
    super(paramString);
  }
  
  public static SecurityFileModule getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new SecurityFileModule("SecurityFileModule");
      }
      return mInstance;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecurityFileModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    if ("ACTION_GET_BUSINESS_ROOT_PATH".equals(paramString))
    {
      if (paramBundle != null)
      {
        paramString = paramBundle.getString("BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME");
        if (!TextUtils.isEmpty(paramString))
        {
          try
          {
            paramBundle = Class.forName(paramString);
            if (QLog.isColorLevel()) {
              QLog.d("SecurityFileModule", 2, new Object[] { "className=", paramString, " realClassName=", paramBundle.getName() });
            }
            paramString = (ISecurityFileHelper)paramBundle.newInstance();
          }
          catch (ClassNotFoundException paramString)
          {
            for (;;)
            {
              QLog.d("SecurityFileModule", 1, paramString.getMessage());
              paramString = null;
            }
          }
          catch (IllegalAccessException paramString)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SecurityFileModule", 2, paramString.getMessage());
              }
              paramString = null;
            }
          }
          catch (InstantiationException paramString)
          {
            label130:
            label170:
            if (!QLog.isColorLevel()) {
              break label257;
            }
            QLog.d("SecurityFileModule", 2, paramString.getMessage());
          }
          if (QLog.isColorLevel())
          {
            if (paramString != null) {
              break label262;
            }
            paramBundle = "helper = null ";
            QLog.d("SecurityFileModule", 2, paramBundle);
          }
          paramBundle = ((SecurityFileFrameworkManagerImpl)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(8)).getUINRootFile(paramString);
          if (QLog.isColorLevel())
          {
            if (paramBundle != null) {
              break label290;
            }
            paramString = "result = null";
            QLog.d("SecurityFileModule", 2, paramString);
          }
          paramString = new Bundle();
          if (paramBundle != null) {
            break label316;
          }
          paramString.putString("BUNDLE_KEY_RETURN_FILE_PATH", "");
        }
      }
      for (;;)
      {
        return EIPCResult.createSuccessResult(paramString);
        label257:
        paramString = null;
        break;
        label262:
        paramBundle = "helper=" + paramString.declareBusinessFileName();
        break label130;
        label290:
        paramString = "result = " + paramBundle.getAbsolutePath();
        break label170;
        label316:
        paramString.putString("BUNDLE_KEY_RETURN_FILE_PATH", paramBundle.getAbsolutePath());
      }
    }
    return EIPCResult.createExceptionResult(new Throwable("Action=" + paramString + " Not Found"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.SecurityFileModule
 * JD-Core Version:    0.7.0.1
 */