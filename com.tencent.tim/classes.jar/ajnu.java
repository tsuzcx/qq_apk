import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ajnu
{
  private static HashMap<String, Integer> lN = new HashMap();
  public static HashMap<String, Integer> lO;
  public static HashMap<String, Integer> lP;
  
  static
  {
    lN.put("hot_reactive_gray_intimate_lover_1_icon", Integer.valueOf(2130851182));
    lN.put("hot_reactive_gray_intimate_lover_2_icon", Integer.valueOf(2130851183));
    lN.put("hot_reactive_gray_intimate_lover_3_icon", Integer.valueOf(2130851184));
    lN.put("hot_reactive_gray_intimate_guimi_1_icon", Integer.valueOf(2130851176));
    lN.put("hot_reactive_gray_intimate_guimi_2_icon", Integer.valueOf(2130851177));
    lN.put("hot_reactive_gray_intimate_guimi_3_icon", Integer.valueOf(2130851178));
    lN.put("hot_reactive_gray_intimate_jiyou_1_icon", Integer.valueOf(2130851179));
    lN.put("hot_reactive_gray_intimate_jiyou_2_icon", Integer.valueOf(2130851180));
    lN.put("hot_reactive_gray_intimate_jiyou_3_icon", Integer.valueOf(2130851181));
    lN.put("hot_reactive_gray_friendship_1_icon", Integer.valueOf(2130851173));
    lN.put("hot_reactive_gray_friendship_2_icon", Integer.valueOf(2130851174));
    lN.put("hot_reactive_gray_friendship_3_icon", Integer.valueOf(2130851175));
    lN.put("gray_small_fire", Integer.valueOf(2130851200));
    lN.put("gray_big_fire", Integer.valueOf(2130851158));
    lN.put("gray_small_zan", Integer.valueOf(2130851204));
    lN.put("gray_big_zan", Integer.valueOf(2130851162));
    lN.put("gray_small_lover", Integer.valueOf(2130851192));
    lN.put("gray_big_lover", Integer.valueOf(2130851191));
    lN.put("qzone_gray_qzone_visit_normal", Integer.valueOf(2130851198));
    lN.put("qzone_gray_qzone_visit_super", Integer.valueOf(2130851199));
    lN.put("gray_small_ship", Integer.valueOf(2130851203));
    lN.put("gray_big_ship", Integer.valueOf(2130851161));
    lO = new HashMap();
    lO.put("skin_icon_small_fire", Integer.valueOf(2130851200));
    lO.put("skin_icon_big_fire", Integer.valueOf(2130851158));
    lO.put("skin_icon_small_flower", Integer.valueOf(2130851203));
    lO.put("skin_icon_big_flower", Integer.valueOf(2130851161));
    lO.put("skin_icon_small_praise", Integer.valueOf(2130851204));
    lO.put("skin_icon_big_praise", Integer.valueOf(2130851162));
    lO.put("skin_icon_lover_small", Integer.valueOf(2130851192));
    lO.put("skin_icon_lover_big", Integer.valueOf(2130851191));
    lO.put("skin_icon_qzone_visit_normal", Integer.valueOf(2130851198));
    lO.put("skin_icon_qzone_visit_super", Integer.valueOf(2130851199));
    lO.put("skin_icon_frdship_1", Integer.valueOf(2130851173));
    lO.put("skin_icon_frdship_2", Integer.valueOf(2130851174));
    lO.put("skin_icon_frdship_3", Integer.valueOf(2130851175));
    lO.put("skin_icon_intimate_lover_1", Integer.valueOf(2130851182));
    lO.put("skin_icon_intimate_lover_2", Integer.valueOf(2130851183));
    lO.put("skin_icon_intimate_lover_3", Integer.valueOf(2130851184));
    lO.put("skin_icon_intimate_guimi_1", Integer.valueOf(2130851176));
    lO.put("skin_icon_intimate_guimi_2", Integer.valueOf(2130851177));
    lO.put("skin_icon_intimate_guimi_3", Integer.valueOf(2130851178));
    lO.put("skin_icon_intimate_jiyou_1", Integer.valueOf(2130851179));
    lO.put("skin_icon_intimate_jiyou_2", Integer.valueOf(2130851180));
    lO.put("skin_icon_intimate_jiyou_3", Integer.valueOf(2130851181));
    lO.put("skin_icon_mutual_x_character_1", Integer.valueOf(2130851197));
    lO.put("skin_icon_mentorship", Integer.valueOf(2130851195));
    lO.put("skin_icon_mentorship_svip", Integer.valueOf(2130851194));
    lO.put("skin_icon_mentorship_yellowvip", Integer.valueOf(2130851196));
    lO.put("skin_icon_mentorship_newyear", Integer.valueOf(2130851193));
    lO.put("skin_icon_kapu_1", Integer.valueOf(2130851188));
    lO.put("skin_icon_kapu_2", Integer.valueOf(2130851189));
    lO.put("skin_icon_kapu_3", Integer.valueOf(2130851190));
    lO.put("skin_icon_forget_me_not_1", Integer.valueOf(2130851170));
    lO.put("skin_icon_forget_me_not_2", Integer.valueOf(2130851171));
    lO.put("skin_icon_forget_me_not_3", Integer.valueOf(2130851172));
    lP = new HashMap();
    lP.putAll(lN);
    lP.putAll(lO);
    lP.putAll(ajod.lQ);
  }
  
  public static int Gv()
  {
    return aqmu.aj(NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static ArrayList<ajnu.a> Q(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    while (paramString.find())
    {
      ajnu.a locala = new ajnu.a();
      locala.template = paramString.group();
      locala.start = paramString.start();
      locala.end = (locala.start + locala.template.length());
      locala.url = paramString.group(1);
      if ((!TextUtils.isEmpty(locala.url)) && (locala.url.contains("client/42px-")))
      {
        Matcher localMatcher = Pattern.compile("x_character/([^\\)]+?)/client").matcher(locala.url);
        if (localMatcher.find()) {
          locala.name = localMatcher.group(1);
        }
      }
      localArrayList.add(locala);
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkUtils", 2, "getMutualMarkImageUrlTemplateInfos. url:" + locala.url + " template:" + locala.template);
      }
    }
    return localArrayList;
  }
  
  public static long ao(String paramString)
  {
    long l = 0L;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l = Long.valueOf(Long.parseLong(paramString)).longValue() % 10L;
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("MutualMarkUtils", 1, "getTypeLevel error:" + paramString.getMessage());
    }
    return 0L;
  }
  
  public static long ap(String paramString)
  {
    long l = 0L;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = Long.valueOf(Long.parseLong(paramString));
      l = (paramString.longValue() - 100000L - paramString.longValue() % 10L) / 10L;
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("MutualMarkUtils", 1, "getType error:" + paramString.getMessage());
    }
    return 0L;
  }
  
  public static boolean be(QQAppInterface paramQQAppInterface)
  {
    return true;
  }
  
  public static boolean cn(long paramLong)
  {
    if (paramLong <= 0L) {}
    int i;
    do
    {
      return false;
      i = Gv();
    } while ((i < 18) || (i >= 24) || (aqmu.J(paramLong) == 2131721204));
    return true;
  }
  
  public static boolean co(long paramLong)
  {
    boolean bool2 = false;
    long[] arrayOfLong = ajnm.ak;
    int j = arrayOfLong.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfLong[i] == paramLong) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean cp(long paramLong)
  {
    long[] arrayOfLong;
    int j;
    int i;
    if (co(paramLong))
    {
      arrayOfLong = ajnm.aj;
      j = arrayOfLong.length;
      i = 0;
    }
    while (i < j)
    {
      if (arrayOfLong[i] == paramLong) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String eB(int paramInt)
  {
    Iterator localIterator = lO.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (String)localEntry.getKey();
      }
    }
    localIterator = ajod.lQ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (String)localEntry.getKey();
      }
    }
    return "";
  }
  
  public static int f(long paramLong1, long paramLong2)
  {
    return (int)(100000L + 10L * paramLong1 + paramLong2);
  }
  
  public static List<String> fI()
  {
    ArrayList localArrayList = new ArrayList(lP.keySet());
    Collections.sort(localArrayList, new ajnv());
    return localArrayList;
  }
  
  public static String i(long paramLong1, long paramLong2)
  {
    return String.valueOf(100000L + 10L * paramLong1 + paramLong2);
  }
  
  public static boolean kx(int paramInt)
  {
    if ((paramInt <= 100000) || (paramInt >= 200000)) {}
    while (ap(String.valueOf(paramInt)) <= 0L) {
      return false;
    }
    return true;
  }
  
  public static boolean ky(int paramInt)
  {
    return (paramInt == 2097153) || (paramInt == 2097154) || (paramInt == 2097155);
  }
  
  public static String mj(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return new String(aqgo.decode(paramString, 0));
  }
  
  public static String mk(String paramString)
  {
    Object localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    if (((Matcher)localObject).matches())
    {
      localObject = ((Matcher)localObject).group(1);
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkUtils", 2, "getMutualMarkImageUrlTemplateUrl. url:" + (String)localObject + " template:" + paramString);
      }
      return localObject;
    }
    return null;
  }
  
  public static boolean nw(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.startsWith("#image_url"))
      {
        bool1 = bool2;
        if (Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString).matches()) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkUtils", 2, "isMutualMarkImageUrlTemplate. res:" + bool1 + " template:" + paramString);
    }
    return bool1;
  }
  
  /* Error */
  public static String xr()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_0
    //   4: ldc_w 386
    //   7: astore_3
    //   8: invokestatic 462	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 468	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   14: ldc_w 470
    //   17: invokevirtual 476	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: astore_1
    //   25: aload_2
    //   26: invokestatic 481	jqo:e	(Ljava/io/InputStream;)Ljava/lang/String;
    //   29: astore 4
    //   31: aload 4
    //   33: astore_0
    //   34: aload_0
    //   35: astore_1
    //   36: aload_2
    //   37: ifnull +9 -> 46
    //   40: aload_2
    //   41: invokevirtual 486	java/io/InputStream:close	()V
    //   44: aload_0
    //   45: astore_1
    //   46: aload_1
    //   47: areturn
    //   48: astore_2
    //   49: aload_0
    //   50: astore_1
    //   51: aload_2
    //   52: invokevirtual 489	java/lang/Throwable:printStackTrace	()V
    //   55: aload_3
    //   56: astore_1
    //   57: aload_0
    //   58: ifnull -12 -> 46
    //   61: aload_0
    //   62: invokevirtual 486	java/io/InputStream:close	()V
    //   65: ldc_w 386
    //   68: areturn
    //   69: astore_0
    //   70: ldc_w 386
    //   73: areturn
    //   74: astore_0
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 486	java/io/InputStream:close	()V
    //   83: aload_0
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: goto -6 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	59	0	localObject1	Object
    //   69	1	0	localIOException1	java.io.IOException
    //   74	13	0	str1	String
    //   1	79	1	localObject2	Object
    //   85	1	1	localIOException2	java.io.IOException
    //   88	1	1	localIOException3	java.io.IOException
    //   20	21	2	localInputStream	java.io.InputStream
    //   48	4	2	localThrowable	java.lang.Throwable
    //   7	49	3	str2	String
    //   29	3	4	str3	String
    // Exception table:
    //   from	to	target	type
    //   8	21	48	java/lang/Throwable
    //   25	31	48	java/lang/Throwable
    //   61	65	69	java/io/IOException
    //   8	21	74	finally
    //   25	31	74	finally
    //   51	55	74	finally
    //   40	44	85	java/io/IOException
    //   79	83	88	java/io/IOException
  }
  
  public static class a
  {
    public int end;
    public String name;
    public int start;
    public String template;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnu
 * JD-Core Version:    0.7.0.1
 */