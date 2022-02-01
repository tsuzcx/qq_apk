import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class anjn
{
  public static String cen;
  private static String ceo = "";
  private static String cep = "";
  private static int dIA;
  private static int dIB;
  private static int dIC;
  private static int dID = -1;
  private static int dIy;
  private static int dIz;
  private static final String[] gK = { "snpe", "opencl_mali", "opencl_ocl", "opengl" };
  private static final String[] gL = { "NX609J", "NX531J", "vivo X7Plus", "ARS-TL00", "MI 8 Lite", "1807-A01", "ARE-AL00" };
  private static final String[] gM = { "Redmi Note 3" };
  
  static
  {
    cen = "";
    dIy = -1;
    dIz = -1;
    dIA = -1;
    dIB = -1;
    dIC = 0;
  }
  
  /* Error */
  public static int JJ()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 61	anjn:dIz	I
    //   6: iconst_m1
    //   7: if_icmple +12 -> 19
    //   10: getstatic 61	anjn:dIz	I
    //   13: istore_0
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_0
    //   18: ireturn
    //   19: invokestatic 80	anjn:zD	()Ljava/lang/String;
    //   22: invokestatic 84	anjn:ei	(Ljava/lang/String;)I
    //   25: istore_0
    //   26: goto -12 -> 14
    //   29: astore_1
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	13	0	i	int
    //   29	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	14	29	finally
    //   19	26	29	finally
  }
  
  public static int JK()
  {
    int j = 0;
    if (dIA > -1) {
      return dIA;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      dIA = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return dIA;
    }
    if (!axA())
    {
      dIA = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of low-end devices", new Object[0]));
      return dIA;
    }
    int i = anki.JL();
    if (i != -1)
    {
      dIA = i;
      QLog.d("QmcfDevicesStrategy", 1, "DPCInfo:" + i);
      return dIA;
    }
    dIA = 0;
    if ((Build.MODEL.contains("Pixel")) || (Build.MODEL.contains("Nexus")))
    {
      dIA = 4;
      return dIA;
    }
    String[] arrayOfString = gL;
    int k = arrayOfString.length;
    i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        dIA = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
        return dIA;
      }
      i += 1;
    }
    arrayOfString = gM;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        dIA = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule loose");
        return dIA;
      }
      i += 1;
    }
    boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
    boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
    if ((bool1) || (bool2))
    {
      dIA = 4;
      QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
      return dIA;
    }
    dIA = 3;
    return dIA;
  }
  
  private static void QA(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split(";");
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      Object localObject;
      int k;
      int m;
      int n;
      try
      {
        if (cen.contains("Mali"))
        {
          j = arrayOfString.length;
          i = 0;
          bool1 = bool3;
          if (i < j)
          {
            paramString = arrayOfString[i].split("#");
            bool1 = bool3;
            if (paramString.length == 4)
            {
              localObject = paramString[0] + paramString[1];
              if (!cen.contains((CharSequence)localObject)) {
                break label369;
              }
              localObject = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(cen);
              bool1 = ((Matcher)localObject).find();
              if (!bool1) {
                break label369;
              }
            }
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(((Matcher)localObject).group(4));
          m = Integer.parseInt(paramString[2]);
          n = Integer.parseInt(paramString[3]);
          if ((k > n) || (k < m)) {
            break label363;
          }
          bool1 = bool2;
          Qc(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      if (cen.contains("Adreno"))
      {
        j = arrayOfString.length;
        i = 0;
        for (;;)
        {
          for (;;)
          {
            bool1 = bool3;
            if (i >= j) {
              break;
            }
            localObject = arrayOfString[i].split("#");
            paramString = "0";
            Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(cen);
            if (localMatcher.find()) {
              paramString = localMatcher.group(1);
            }
            if ((localObject.length != 3) || (!paramString.substring(0, 1).equals(localObject[0])))
            {
              k = localObject.length;
              if (k != 2) {}
            }
            else
            {
              try
              {
                k = Integer.parseInt(paramString);
                m = Integer.parseInt(localObject[(localObject.length - 2)]);
                n = Integer.parseInt(localObject[(localObject.length - 1)]);
                bool1 = bool3;
                if (k > n) {
                  break;
                }
                bool1 = bool3;
                if (k < m) {
                  break;
                }
                bool1 = true;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
          }
          i += 1;
        }
        label363:
        bool1 = false;
        continue;
        label369:
        i += 1;
      }
    }
  }
  
  private static void QB(String paramString)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.length;
        i = 0;
        boolean bool1 = bool2;
        if (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (cen.contains(localCharSequence)) {
            bool1 = true;
          }
        }
        else
        {
          Qc(bool1);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public static void QC(String paramString)
  {
    if (dID == -1)
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4);
      dID = ((SharedPreferences)localObject).getInt("gl_renderer_flag", 0);
      if (dID == 0)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("gl_renderer", paramString);
        ((SharedPreferences.Editor)localObject).putInt("gl_renderer_flag", 1);
        ((SharedPreferences.Editor)localObject).commit();
        dID = 1;
        QLog.i("QmcfDevicesStrategy", 1, "saveGLRendererInfo:" + paramString);
      }
    }
  }
  
  private static void Qc(boolean paramBoolean)
  {
    if ("white".equals(ceo)) {
      if (paramBoolean) {
        dIy = dIC;
      }
    }
    while ((!"black".equals(ceo)) || (paramBoolean)) {
      return;
    }
    dIy = dIC;
  }
  
  public static boolean a(String paramString, int paramInt, Context paramContext)
  {
    try
    {
      eS(paramContext);
      paramContext = paramContext.getSharedPreferences("qmcf_gpu_config", 0).edit();
      paramContext.putString("cfg_content", paramString);
      paramContext.putInt("cfg_version", paramInt);
      return paramContext.commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QmcfDevicesStrategy", 2, "setQmcfMobileSupport err!", localException);
        }
      }
    }
  }
  
  public static int aA(Context paramContext)
  {
    return paramContext.getSharedPreferences("qmcf_gpu_config", 0).getInt("cfg_version", 0);
  }
  
  public static boolean axA()
  {
    return iow.a(4, 1200000L, 2147483648L);
  }
  
  private static void bA(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("rule").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        hr(str, paramJSONObject.getString(str));
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static void by(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("verdor").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (cen.contains(str)) {
          bz(paramJSONObject.getJSONObject(str));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static void bz(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("strategy").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        ceo = str;
        bA(localJSONObject);
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static void cR(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString1 = paramString.split(";");
    label399:
    label405:
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      String[] arrayOfString2;
      int k;
      int m;
      try
      {
        if (!cen.contains("Mali")) {
          break label226;
        }
        j = arrayOfString1.length;
        i = 0;
        bool1 = bool3;
        if (i < j)
        {
          arrayOfString2 = arrayOfString1[i].split("#");
          if (arrayOfString2.length != 2) {
            break label179;
          }
          paramString = arrayOfString2[0];
          if (!cen.contains(paramString)) {
            break label405;
          }
          paramString = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(cen);
          k = arrayOfString2.length;
          bool1 = paramString.find();
          if (!bool1) {
            break label405;
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(paramString.group((k - 1) * 2));
          m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
          if (paramBoolean)
          {
            bool1 = bool2;
            if (k >= m) {}
          }
          else
          {
            if ((paramBoolean) || (k > m)) {
              break label399;
            }
            bool1 = bool2;
          }
          Qc(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      label179:
      if (arrayOfString2.length == 3)
      {
        paramString = arrayOfString2[0] + arrayOfString2[1];
        continue;
        label226:
        bool1 = bool3;
        if (cen.contains("Adreno"))
        {
          j = arrayOfString1.length;
          i = 0;
          for (;;)
          {
            for (;;)
            {
              bool1 = bool3;
              if (i >= j) {
                break;
              }
              arrayOfString2 = arrayOfString1[i].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(cen);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((arrayOfString2.length != 2) || (!paramString.substring(0, 1).equals(arrayOfString2[0])))
              {
                k = arrayOfString2.length;
                if (k != 1) {}
              }
              else
              {
                try
                {
                  k = Integer.parseInt(paramString);
                  m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
                  if ((!paramBoolean) || (k < m))
                  {
                    bool1 = bool3;
                    if (paramBoolean) {
                      break;
                    }
                    bool1 = bool3;
                    if (k > m) {
                      break;
                    }
                  }
                  bool1 = true;
                }
                catch (Exception paramString)
                {
                  paramString.printStackTrace();
                }
              }
            }
            i += 1;
          }
          bool1 = false;
          continue;
          i += 1;
        }
      }
    }
  }
  
  public static void eS(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("QmcfConfig", 4).edit();
    paramContext.putInt("qmcf_mobile_support", 1);
    paramContext.commit();
  }
  
  public static int ei(String paramString)
  {
    if (dIz > -1) {
      return dIz;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      dIz = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return dIz;
    }
    int i = anki.JL();
    if (i != -1)
    {
      dIz = i;
      QLog.d("QmcfDevicesStrategy", 1, "DPCInfo:" + i);
      return dIz;
    }
    dIz = 0;
    if (Build.MODEL.contains("Pixel"))
    {
      dIz = 4;
      return dIz;
    }
    if (Build.MODEL.contains("Nexus"))
    {
      dIz = 0;
      QLog.d("QmcfDevicesStrategy", 1, "not support because of nexus");
      return dIz;
    }
    String[] arrayOfString = gL;
    int j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        dIz = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
        return dIz;
      }
      i += 1;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((bool1) || (bool2))
      {
        dIz = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
        return dIz;
      }
    }
    if (TextUtils.isEmpty(cen))
    {
      cen = new OpenclInfoManager().xK();
      QLog.d("QmcfDevicesStrategy", 1, "GPUInfo:" + cen);
    }
    if ((TextUtils.isEmpty(cen)) || (cen.startsWith("err")))
    {
      cen = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).getString("gl_renderer", "");
      QLog.i("QmcfDevicesStrategy", 1, "getGLRendererInfo:" + cen);
      if (TextUtils.isEmpty(cen))
      {
        dIz = -2;
        return dIz;
      }
    }
    dIz = ek(paramString);
    if (dIz == 0) {
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support gpu[%s] type[%s]", new Object[] { cen, Integer.valueOf(dIz) }));
    }
    return dIz;
  }
  
  public static int ej(String paramString)
  {
    if (dIB > -1) {
      return dIB;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      dIB = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("multiaio not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return dIB;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((bool1) || (bool2))
      {
        dIB = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
        return dIB;
      }
    }
    if (TextUtils.isEmpty(cen))
    {
      cen = new OpenclInfoManager().xK();
      QLog.d("QmcfDevicesStrategy", 1, "GPUInfo:" + cen);
    }
    if ((TextUtils.isEmpty(cen)) || (cen.startsWith("err")))
    {
      cen = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).getString("gl_renderer", "");
      QLog.i("QmcfDevicesStrategy", 1, "getGLRendererInfo:" + cen);
      if (TextUtils.isEmpty(cen))
      {
        dIB = 4;
        return dIB;
      }
    }
    dIB = ek(paramString);
    return dIB;
  }
  
  private static int ek(String paramString)
  {
    int m = 0;
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        String[] arrayOfString = gK;
        int n = arrayOfString.length;
        i = 0;
        int j = 0;
        int k = m;
        if (i < n)
        {
          Object localObject = arrayOfString[i];
          j += 1;
          if ((!cep.contains((CharSequence)localObject)) && (paramString.has((String)localObject)))
          {
            localObject = paramString.getJSONObject((String)localObject);
            dIC = j;
            by((JSONObject)localObject);
            if (dIy > 0)
            {
              QLog.d("QmcfDevicesStrategy", 1, "support because of config: " + dIy);
              k = dIy;
            }
          }
        }
        else
        {
          return k;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return 4;
      }
      i += 1;
    }
  }
  
  private static void hr(String paramString1, String paramString2)
  {
    if ("large".equals(paramString1)) {
      cR(paramString2, true);
    }
    do
    {
      return;
      if ("less".equals(paramString1))
      {
        cR(paramString2, false);
        return;
      }
      if ("between".equals(paramString1))
      {
        QA(paramString2);
        return;
      }
    } while (!"enum".equals(paramString1));
    QB(paramString2);
  }
  
  private static String zD()
  {
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 0).getString("cfg_content", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = aqhq.py("qmcf_rule_config.xml");
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjn
 * JD-Core Version:    0.7.0.1
 */