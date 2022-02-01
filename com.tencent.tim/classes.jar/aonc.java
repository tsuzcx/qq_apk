import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.transfile.RichMediaUtil.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.manager.TicketManager;

public class aonc
{
  public static final Pattern ak;
  public static final Pattern al;
  private static boolean cNm;
  private static int dQm = -1;
  private static final String[] hr = { "T", "U", "L" };
  private static final String[] hs = { "c2c", "grp", "dis" };
  private static String[] ht;
  private static String[] hu;
  private static HashMap<String, aonc.a> nS = new HashMap();
  private static Random random;
  public static String versionCode;
  
  static
  {
    ak = Pattern.compile("https?://(\\d{1,3}\\.){3}\\d{1,3}(:\\d{1,5})?[/\\?].*");
    al = Pattern.compile("https?://[^/]*/{1}");
    random = new Random();
  }
  
  public static String[] O()
  {
    if (hu != null) {
      return hu;
    }
    ArrayList localArrayList = Z("dw");
    hu = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return hu;
  }
  
  public static String[] P()
  {
    if (ht != null) {
      return ht;
    }
    ArrayList localArrayList = Y("up");
    localArrayList.addAll(Y("dw"));
    ht = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return ht;
  }
  
  public static void VZ(int paramInt)
  {
    a("ptt_recv", paramInt, O(), 10000, 600000L);
  }
  
  private static ArrayList<String> Y(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = hs;
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str1 = arrayOfString1[i];
      String[] arrayOfString2 = hr;
      int m = arrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        String str2 = arrayOfString2[j];
        localArrayList.add(k(str1, "pic", paramString, str2));
        localArrayList.add(k(str1, "raw", paramString, str2));
        localArrayList.add(k(str1, "thu", paramString, str2));
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static ArrayList<String> Z(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = hs;
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString1[i];
      String[] arrayOfString2 = hr;
      int m = arrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        localArrayList.add(k(str, "ptt", paramString, arrayOfString2[j]));
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static aonh a(String paramString)
  {
    if ((ak == null) || (paramString == null)) {}
    while ((!ak.matcher(paramString).matches()) || (paramString.split("/").length < 3)) {
      return null;
    }
    aonh localaonh = new aonh();
    paramString = paramString.split("/")[2].split(":");
    localaonh.mIp = paramString[0];
    if (paramString.length == 2)
    {
      localaonh.port = Integer.valueOf(paramString[1]).intValue();
      return localaonh;
    }
    localaonh.port = 80;
    return localaonh;
  }
  
  public static void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    a("T", fG(paramInt1), paramBoolean, fH(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    a("U", fG(paramInt1), paramBoolean, fH(paramInt2), paramString1, paramString2, paramString3, paramThrowable);
  }
  
  public static void a(String paramString, int paramInt1, String[] paramArrayOfString, int paramInt2, long paramLong)
  {
    synchronized (nS)
    {
      if (nS.containsKey(paramString)) {
        return;
      }
      if ((paramInt2 < 2) || (random.nextInt(paramInt2) == 1) || (aAh())) {
        synchronized (nS)
        {
          cNm = true;
          if ((QLog.isColorLevel()) || (cNm)) {
            QLog.d("RichMediaUtil", 2, "activeReport start : " + paramString);
          }
          nS.put(paramString, new aonc.a(paramInt1, paramArrayOfString));
          QLog.startColorLog(paramArrayOfString);
          paramString = new RichMediaUtil.1(paramString);
          new Timer().schedule(paramString, paramLong);
          return;
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString4);
    localStringBuilder.append(" \tstep:");
    localStringBuilder.append(paramString5);
    localStringBuilder.append(" \tcont:");
    localStringBuilder.append(paramString6);
    localStringBuilder.append(" \tver:");
    localStringBuilder.append(getVersionCode());
    if ("T".equals(paramString1))
    {
      localStringBuilder.append(" \ttid:");
      localStringBuilder.append(Thread.currentThread().getId());
    }
    paramString1 = k(paramString2, paramString3, "fw", paramString1);
    if (paramThrowable != null) {
      QLog.e(paramString1, 1, localStringBuilder.toString(), paramThrowable);
    }
    while ((!QLog.isColorLevel()) && (!cNm)) {
      return;
    }
    QLog.d(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString4);
    if (paramBoolean)
    {
      paramString4 = "up";
      localStringBuilder.append(" \tstep:");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(" \tcont:");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(" \tver:");
      localStringBuilder.append(getVersionCode());
      if ("T".equals(paramString1))
      {
        localStringBuilder.append(" \ttid:");
        localStringBuilder.append(Thread.currentThread().getId());
      }
      paramString1 = k(paramString2, paramString3, paramString4, paramString1);
      if (paramThrowable == null) {
        break label146;
      }
      QLog.e(paramString1, 1, localStringBuilder.toString(), paramThrowable);
    }
    label146:
    while ((!QLog.isColorLevel()) && (!cNm))
    {
      return;
      paramString4 = "dw";
      break;
    }
    QLog.d(paramString1, 2, localStringBuilder.toString());
  }
  
  private static boolean aAh()
  {
    if (dQm == -1)
    {
      String str = aqlr.a(ServerConfigManager.ConfigType.app, "active_log_upload");
      if ((str == null) || (!str.equals("1"))) {
        break label44;
      }
    }
    label44:
    for (dQm = 1; dQm == 1; dQm = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean aAi()
  {
    return cNm;
  }
  
  public static void aN(boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "image_sending";
    }
    i("image_sending", paramBoolean, str);
  }
  
  public static void aO(boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "ptt_recv";
    }
    i("ptt_recv", paramBoolean, str);
  }
  
  public static void b(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    a("U", fG(paramInt1), paramBoolean, fH(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void b(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    b("L", fG(paramInt1), paramBoolean, fH(paramInt2), paramString1, paramString2, paramString3, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString4);
    if (paramBoolean)
    {
      paramString4 = "up";
      localStringBuilder.append(" \tstep:");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(" \tcont:");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(" \tver:");
      localStringBuilder.append(getVersionCode());
      if ("T".equals(paramString1))
      {
        localStringBuilder.append(" \ttid:");
        localStringBuilder.append(Thread.currentThread().getId());
      }
      paramString1 = k(paramString2, paramString3, paramString4, paramString1);
      if (paramThrowable == null) {
        break label146;
      }
      QLog.e(paramString1, 2, localStringBuilder.toString(), paramThrowable);
    }
    label146:
    while ((!QLog.isColorLevel()) && (!cNm))
    {
      return;
      paramString4 = "dw";
      break;
    }
    QLog.e(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void b(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a("T", paramString1, paramBoolean, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  public static String bJ(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString2 != null)
      {
        str = paramString1;
        if (paramString2.length() > 0) {
          str = paramString1.replaceFirst("https?://[^/\\s]*/", paramString2);
        }
      }
    }
    return str;
  }
  
  public static void c(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    a("L", fG(paramInt1), paramBoolean, fH(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static String fF(int paramInt)
  {
    String str = "" + paramInt;
    switch (paramInt)
    {
    default: 
      return str;
    case 0: 
      return "dw";
    case 1: 
      return "up";
    }
    return "fw";
  }
  
  public static String fG(int paramInt)
  {
    String str = "" + paramInt;
    switch (paramInt)
    {
    default: 
      return str;
    case 0: 
      return "c2c";
    case 1: 
      return "grp";
    }
    return "dis";
  }
  
  public static String fH(int paramInt)
  {
    String str = "" + paramInt;
    switch (paramInt)
    {
    default: 
      return str;
    case 65537: 
      return "thu";
    case 1: 
      return "pic";
    case 65538: 
      return "emo";
    case 131075: 
      return "raw";
    case 2: 
      return "ptt";
    case 0: 
      return "fil";
    case 131078: 
      return "msg";
    case 131076: 
      return "url";
    }
    return "shortvideo";
  }
  
  public static int gC(int paramInt)
  {
    switch (paramInt)
    {
    case 65537: 
    default: 
      return 65537;
    case 1: 
      return 1;
    }
    return 131075;
  }
  
  /* Error */
  public static String getVersionCode()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 346	aonc:versionCode	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 346	aonc:versionCode	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: ldc_w 348
    //   21: putstatic 346	aonc:versionCode	Ljava/lang/String;
    //   24: invokestatic 354	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   27: invokevirtual 358	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   30: invokestatic 354	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   36: iconst_0
    //   37: invokevirtual 367	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   40: astore_0
    //   41: new 207	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   48: aload_0
    //   49: getfield 372	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   52: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 374
    //   58: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 376	android/content/pm/PackageInfo:versionCode	I
    //   65: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: putstatic 346	aonc:versionCode	Ljava/lang/String;
    //   74: getstatic 346	aonc:versionCode	Ljava/lang/String;
    //   77: astore_0
    //   78: goto -65 -> 13
    //   81: astore_0
    //   82: ldc_w 348
    //   85: putstatic 346	aonc:versionCode	Ljava/lang/String;
    //   88: aload_0
    //   89: invokevirtual 379	java/lang/Exception:printStackTrace	()V
    //   92: goto -18 -> 74
    //   95: astore_0
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	66	0	localObject1	Object
    //   81	8	0	localException	java.lang.Exception
    //   95	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	74	81	java/lang/Exception
    //   3	13	95	finally
    //   18	24	95	finally
    //   24	74	95	finally
    //   74	78	95	finally
    //   82	92	95	finally
  }
  
  public static void i(String paramString1, boolean paramBoolean, String paramString2)
  {
    synchronized (nS)
    {
      if (nS.containsKey(paramString1))
      {
        if ((QLog.isColorLevel()) || (cNm)) {
          QLog.d("RichMediaUtil", 2, "activeReport stop : " + paramString1 + ", " + paramBoolean);
        }
        aonc.a locala = (aonc.a)nS.remove(paramString1);
        if (locala != null)
        {
          paramString1 = BaseApplicationImpl.sApplication.getRuntime();
          if (paramString1 != null)
          {
            TicketManager localTicketManager = (TicketManager)paramString1.getManager(2);
            String str = paramString1.getAccount();
            paramString1 = "";
            if (localTicketManager != null) {
              paramString1 = localTicketManager.getSkey(str);
            }
            QLog.endColorLog(locala.tags, locala.appid, paramBoolean, paramString2, str, paramString1);
          }
        }
        if (nS.isEmpty()) {
          cNm = false;
        }
      }
      return;
    }
  }
  
  public static String k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder("Q.richmedia.");
    localStringBuilder.append(paramString4).append(".");
    localStringBuilder.append(paramString1).append(".");
    localStringBuilder.append(paramString2).append(".");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static String ow(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      Matcher localMatcher = Pattern.compile("http://([^/\\s]*)/").matcher(paramString);
      str = paramString;
      if (localMatcher.find()) {
        str = localMatcher.group(0);
      }
    }
    return str;
  }
  
  public static boolean qi(String paramString)
  {
    boolean bool = false;
    int j;
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      j = JpegExifReader.getRotationDegree(paramString);
      if (j != 90)
      {
        i = j;
        if (j != 270) {}
      }
      else
      {
        bool = true;
      }
    }
    for (int i = j;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaUtil", 2, "isPicLandscape .result =  " + bool + ",degree = " + i + ",path = " + paramString);
      }
      return bool;
    }
  }
  
  public static String z(String paramString, boolean paramBoolean)
  {
    if ((a(paramString) == null) && (!paramBoolean)) {}
    Matcher localMatcher;
    do
    {
      return paramString;
      localMatcher = al.matcher(paramString);
    } while (!localMatcher.find());
    return paramString.replace(localMatcher.group(), "");
  }
  
  static class a
  {
    int appid;
    String[] tags;
    
    a(int paramInt, String[] paramArrayOfString)
    {
      this.tags = paramArrayOfString;
      this.appid = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonc
 * JD-Core Version:    0.7.0.1
 */