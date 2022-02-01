import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.e;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class aiwi
  extends aehv<LoginWelcomeManager.e>
{
  @NonNull
  public LoginWelcomeManager.e a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new LoginWelcomeManager.e();
  }
  
  @Nullable
  public LoginWelcomeManager.e a(aeic[] paramArrayOfaeic)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("WelcomeConfigProcessor", 2, "onParsed :" + paramArrayOfaeic);
      if (paramArrayOfaeic != null)
      {
        j = paramArrayOfaeic.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfaeic[i];
          if (localObject1 != null) {
            QLog.d("WelcomeConfigProcessor", 2, "onParsed item: " + ((aeic)localObject1).content);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      j = paramArrayOfaeic.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfaeic[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((aeic)localObject2).content))) {
          try
          {
            localObject1 = new LoginWelcomeManager.e();
            localObject2 = new JSONObject(((aeic)localObject2).content);
            if (((JSONObject)localObject2).has("popup_url")) {
              ((LoginWelcomeManager.e)localObject1).bPM = ((JSONObject)localObject2).getString("popup_url");
            }
            if (((JSONObject)localObject2).has("fixed_entrance_url")) {
              ((LoginWelcomeManager.e)localObject1).fixed_entrance_url = ((JSONObject)localObject2).getString("fixed_entrance_url");
            }
            if (((JSONObject)localObject2).has("request_interval")) {
              ((LoginWelcomeManager.e)localObject1).dft = ((JSONObject)localObject2).getInt("request_interval");
            }
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("WelcomeConfigProcessor", 1, localThrowable, new Object[0]);
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void b(LoginWelcomeManager.e parame)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onUpdate");
    }
    if (parame != null) {
      ((LoginWelcomeManager)BaseApplicationImpl.sApplication.getRuntime().getManager(146)).a(parame);
    }
  }
  
  public Class<LoginWelcomeManager.e> clazz()
  {
    return LoginWelcomeManager.e.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 454;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwi
 * JD-Core Version:    0.7.0.1
 */