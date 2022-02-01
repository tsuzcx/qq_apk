import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.Xml;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Pandora.Pandora;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo.1;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class auri
{
  public static String TAG = "QQDeviceInfo";
  private static String Tn;
  private static boolean aOD = false;
  private static String cIR;
  private static String cIS;
  private static final SparseArray<String> dU = new SparseArray();
  private static final Object fW = new Object();
  private static volatile Map<String, Integer> pI;
  
  public static String Fi()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    String str2 = (String)aqmj.a(localBaseApplication, "0", "key_no_login_user_id", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = Pandora.getAndroidID(localBaseApplication);
      str2 = UUID.randomUUID().toString();
      str1 = MD5.toMD5(str1 + str2);
      aqmj.a(localBaseApplication, "0", false, "key_no_login_user_id", str1);
    }
    return str1;
  }
  
  public static void Wa(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT <= 28) || (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {}
    do
    {
      return;
      cIR = rt("huawei_oaid");
    } while ((paramBoolean) || (!TextUtils.isEmpty(cIR)));
    ThreadManager.getFileThreadHandler().post(new QQDeviceInfo.1());
  }
  
  public static String aT(String paramString, int paramInt)
  {
    int j = fN(paramString);
    int i = paramInt;
    if (paramInt == -1) {
      i = j;
    }
    String str2 = gE(i);
    if (!TextUtils.isEmpty(str2))
    {
      paramString = str2;
      return paramString;
    }
    ewv();
    Wa(true);
    if (((Build.VERSION.SDK_INT > 28) || ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))) && (TextUtils.isEmpty(Tn))) {
      if (i >= 5) {
        paramString = getQIMEI();
      }
    }
    for (;;)
    {
      String str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getIMEI, level = " + i + "; result = " + str1);
      }
      paramString = str1;
      if (str1.equals(str2)) {
        break;
      }
      jl("device_id_cache_" + i, str1);
      return str1;
      if (("huawei".equalsIgnoreCase(Build.MANUFACTURER)) && (!TextUtils.isEmpty(cIR)))
      {
        paramString = cIR;
      }
      else
      {
        paramString = getAndroidID();
        continue;
        paramString = getIMEI();
      }
    }
  }
  
  public static String aU(String paramString, int paramInt)
  {
    return ru(paramString);
  }
  
  private static int au(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static void ewu()
  {
    Wa(false);
  }
  
  private static void ewv()
  {
    if (!TextUtils.isEmpty(Tn)) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT < 26)
    {
      Tn = Pandora.getDeviceID(localBaseApplication);
      return;
    }
    Tn = Pandora.getImei(localBaseApplication);
  }
  
  private static void eww()
  {
    localHashMap = new HashMap();
    Object localObject = BaseApplicationImpl.getContext();
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getResources().getAssets().open("SensiveAuthorityFile.xml");
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput((InputStream)localObject, "utf-8");
        i = localXmlPullParser.getEventType();
      }
      catch (IOException localIOException)
      {
        XmlPullParser localXmlPullParser;
        String str1;
        String str2;
        localIOException.printStackTrace();
        pI = localHashMap;
        return;
        localIOException.close();
        continue;
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        localXmlPullParserException.printStackTrace();
        continue;
        int i = 4;
        continue;
        if (i == 1) {
          continue;
        }
        switch (i)
        {
        }
        continue;
      }
      i = localXmlPullParser.next();
      continue;
      if (localXmlPullParser.getName().equalsIgnoreCase("business"))
      {
        str1 = localXmlPullParser.getAttributeValue(null, "id");
        str2 = localXmlPullParser.getAttributeValue(null, "level");
        if (TextUtils.isEmpty(str2)) {
          continue;
        }
        i = au(str2, 4);
        localHashMap.put(str1, Integer.valueOf(i));
        if (QLog.isDevelopLevel()) {
          QLog.d(TAG, 4, "init sensitive au, busiId = " + str1 + "; level = " + i);
        }
      }
    }
  }
  
  private static int fN(String paramString)
  {
    if (pI == null) {}
    do
    {
      synchronized (fW)
      {
        if (pI == null) {
          eww();
        }
        if (pI == null) {
          return 4;
        }
      }
      if (pI.containsKey(paramString)) {
        break;
      }
    } while (!aOD);
    throw new IllegalArgumentException("busiId not registed ,please first regist");
    paramString = (Integer)pI.get(paramString);
    if (paramString == null) {}
    for (int i = 4;; i = paramString.intValue()) {
      return i;
    }
  }
  
  private static String gE(int paramInt)
  {
    synchronized (dU)
    {
      if (dU.indexOfKey(paramInt) < 0) {
        dU.put(paramInt, rt("device_id_cache_" + paramInt));
      }
      String str = (String)dU.get(paramInt);
      return str;
    }
  }
  
  private static String getAndroidID()
  {
    if (!TextUtils.isEmpty(cIS)) {
      return cIS;
    }
    cIS = Pandora.getAndroidID(BaseApplicationImpl.getContext());
    return cIS;
  }
  
  private static String getIMEI()
  {
    
    if (!TextUtils.isEmpty(Tn)) {
      return Tn;
    }
    for (;;)
    {
      try
      {
        localBaseApplication = BaseApplicationImpl.getContext();
        if (Build.VERSION.SDK_INT >= 26) {
          continue;
        }
        Tn = Pandora.getDeviceID(localBaseApplication);
        jl("imei", Tn);
      }
      catch (SecurityException localSecurityException)
      {
        BaseApplication localBaseApplication;
        Tn = "";
        continue;
      }
      catch (Throwable localThrowable)
      {
        Tn = "";
        continue;
      }
      return Tn;
      Tn = Pandora.getImei(localBaseApplication);
    }
  }
  
  public static String getIMEI(String paramString)
  {
    return aT(paramString, -1);
  }
  
  private static String getQIMEI()
  {
    return UserAction.getQIMEI();
  }
  
  @SuppressLint({"HardwareIds"})
  public static String getSerial()
  {
    if (Build.VERSION.SDK_INT < 26) {
      return Build.SERIAL;
    }
    if (Build.VERSION.SDK_INT > 28) {}
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {
      return "unknown";
    }
    if (((BaseActivity)localObject).checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
      ((BaseActivity)localObject).requestPermissions(new String[] { "android.permission.READ_PHONE_STATE" }, 1);
    }
    for (;;)
    {
      return "unknown";
      try
      {
        localObject = Build.getSerial();
        return localObject;
      }
      catch (SecurityException localSecurityException)
      {
        QLog.e(TAG, 2, localSecurityException, new Object[0]);
      }
    }
  }
  
  private static void jl(String paramString1, String paramString2)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("authority", 4).edit().putString(paramString1, paramString2).apply();
  }
  
  private static String rt(String paramString)
  {
    String str = BaseApplicationImpl.getContext().getSharedPreferences("authority", 4).getString(paramString, "");
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    return paramString;
  }
  
  public static String ru(String paramString)
  {
    fN(paramString);
    return Pandora.getImsi(BaseApplicationImpl.getContext());
  }
  
  public static String rv(String paramString)
  {
    fN(paramString);
    paramString = BaseApplicationImpl.getContext();
    try
    {
      paramString = Pandora.getMac(paramString);
      return paramString;
    }
    catch (Exception localException)
    {
      do
      {
        paramString = "";
      } while (!QLog.isDevelopLevel());
      QLog.d(TAG, 2, " getMacAddr exception = ", localException);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     auri
 * JD-Core Version:    0.7.0.1
 */