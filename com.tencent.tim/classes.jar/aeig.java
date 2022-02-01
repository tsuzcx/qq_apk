import com.qq.android.dexposed.XC_MethodHook;
import com.qq.android.dexposed.XC_MethodHook.MethodHookParam;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class aeig
{
  private aeig.b jdField_a_of_type_Aeig$b = new aeig.b(null);
  private aeig.c jdField_a_of_type_Aeig$c = new aeig.c(null);
  private aeig.d jdField_a_of_type_Aeig$d = new aeig.d(null);
  private List<Member> yU = new ArrayList();
  
  public static aeig a()
  {
    return aeig.a.a;
  }
  
  private static void a(Exception paramException, String paramString1, String paramString2)
  {
    annt.e(new QConfigureException(paramException, "TAG: " + paramString2 + " Message: " + paramException.getMessage()), paramString1);
  }
  
  private void b(aehv paramaehv, aeic[] paramArrayOfaeic, int paramInt, Exception paramException) {}
  
  private void b(aehw paramaehw, File paramFile, Exception paramException) {}
  
  private void b(Class paramClass, Exception paramException) {}
  
  private static String ti()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("-----------------------------------------------\n");
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfStackTraceElement[i].toString();
        if ((!str.contains("com.tencent.mobileqq.config.QConfigWatchDog")) && (!str.contains("com.qq.android.dexposed.DexposedBridge")) && (!str.contains("me.weishu.epic.art")) && (!str.contains("java.lang.reflect.Method.invoke")) && (!str.contains("dalvik.system.VMStack.getThreadStackTrace")) && (!str.contains("java.lang.Thread.getStackTrace")) && (!str.contains("org.json.JSONTokener")) && (!str.contains("org.json.JSONObject.<init>"))) {
          localStringBuilder.append(str).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a(aehv paramaehv, aeic[] paramArrayOfaeic, int paramInt, Exception paramException)
  {
    int i = paramaehv.type();
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedJsonOrXmlException, parsed type=" + i + ", version=" + paramInt, paramException);
    }
    a(paramException, "parsed config failed, type=" + i + ", version=" + paramInt, "QConfigWatchDog_parsedConfig");
    b(paramaehv, paramArrayOfaeic, paramInt, paramException);
  }
  
  public void a(aehw paramaehw, File paramFile, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedIOException", paramException);
    }
    a(paramException, "write\\read IO failed", "QConfigWatchDog_parsedIO");
    b(paramaehw, paramFile, paramException);
  }
  
  public void a(Class paramClass, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedJsonOrXmlException", paramException);
    }
    a(paramException, "parsed json\\Xml failed", "QConfigWatchDog_parsedIO");
    b(paramClass, paramException);
  }
  
  static final class a
  {
    public static final aeig a = new aeig(null);
  }
  
  static final class b
    extends XC_MethodHook
  {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
      throws Throwable
    {
      try
      {
        paramMethodHookParam = aeig.access$300();
        if ((!paramMethodHookParam.contains("QConfigManager.readSync")) && (!paramMethodHookParam.contains("QConfigManager.loadConObj")) && (!paramMethodHookParam.contains("QConfigManager.save"))) {
          aeig.b(new QConfigureException(paramMethodHookParam), "Can not parse json beyond QConfigManager when app starting.", "QConfigWatchDog_Json");
        }
        return;
      }
      catch (Exception paramMethodHookParam)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("QConfigWatchDog", 2, "hook json exception.", paramMethodHookParam);
      }
    }
  }
  
  static final class c
    extends XC_MethodHook
  {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
      throws Throwable
    {
      try
      {
        paramMethodHookParam = aeig.access$300();
        if ((paramMethodHookParam.contains("QConfigManager.save")) && (paramMethodHookParam.contains("onParsed"))) {
          aeig.b(new QConfigureException(paramMethodHookParam), "Can not switch thread when parsing config.", "QConfigWatchDog_threadswitch");
        }
        return;
      }
      catch (Exception paramMethodHookParam)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("QConfigWatchDog", 2, "hook thread exception.", paramMethodHookParam);
      }
    }
  }
  
  static final class d
    extends XC_MethodHook
  {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
      throws Throwable
    {
      try
      {
        paramMethodHookParam = aeig.access$300();
        if ((!paramMethodHookParam.contains("QConfigManager.readSync")) && (!paramMethodHookParam.contains("QConfigManager.loadConObj")) && (!paramMethodHookParam.contains("QConfigManager.save")) && (!paramMethodHookParam.contains("android.app.SharedPreferencesImpl"))) {
          aeig.b(new QConfigureException(paramMethodHookParam), "Can not parse xml beyond QConfigManager when app starting.", "QConfigWatchDog_Xml");
        }
        return;
      }
      catch (Exception paramMethodHookParam)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("QConfigWatchDog", 2, "hook xml exception.", paramMethodHookParam);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeig
 * JD-Core Version:    0.7.0.1
 */