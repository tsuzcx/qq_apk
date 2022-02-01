import android.content.res.AssetManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils.1;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class npv
{
  private static QQHashMap<String, npi> a = new QQHashMap(2019, 10, 10000);
  public static String anp = "version_id";
  public static String anq = "support_min_version_id";
  public static String anr = "is_merged";
  private static Map<String, npv.a> eM = new ConcurrentHashMap();
  
  public static List<String> a(AssetManager paramAssetManager, String paramString)
    throws IOException
  {
    return b(paramAssetManager.open(paramString + "/" + "manifest"));
  }
  
  public static npi a(String paramString)
  {
    try
    {
      paramString = (npi)a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static npv.a a(String paramString)
  {
    npv.a locala = (npv.a)eM.get(paramString);
    if (locala != null) {
      return locala;
    }
    locala = new npv.a();
    String str = jpe.dO(paramString);
    if (str == null)
    {
      QLog.d("OfflineUtils", 2, "checkOffLineProteusConfig: offline root dir is null");
      locala.isValid = false;
      eM.put(paramString, locala);
      return locala;
    }
    str = str + paramString;
    str = str + "/" + "proteus_config.geojson";
    File localFile = new File(str);
    try
    {
      if (!localFile.exists())
      {
        QLog.d("OfflineUtils", 2, "checkOffLineProteusConfig: there is not file " + str);
        locala.isValid = true;
        return locala;
      }
      locala.isValid = false;
      return locala;
    }
    catch (Exception localException)
    {
      QLog.e("OfflineUtils", 1, "checkOffLineProteusConfig: ", localException);
      return locala;
    }
    finally
    {
      eM.put(paramString, locala);
    }
  }
  
  public static void a(String paramString, npi paramnpi)
  {
    try
    {
      a.put(paramString, paramnpi);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void aZY()
  {
    String str = awit.sn("default_feeds_proteus_offline_bid");
    aqhq.cn(jpe.dO(str) + str);
  }
  
  /* Error */
  public static List<String> b(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 152	java/io/BufferedReader
    //   3: dup
    //   4: new 154	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 157	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 160	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 162	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 163	java/util/ArrayList:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +29 -> 59
    //   33: aload_1
    //   34: aload_3
    //   35: invokeinterface 172 2 0
    //   40: pop
    //   41: goto -17 -> 24
    //   44: astore_2
    //   45: ldc 98
    //   47: iconst_2
    //   48: ldc 174
    //   50: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: invokevirtual 179	java/io/InputStream:close	()V
    //   57: aload_1
    //   58: areturn
    //   59: aload_0
    //   60: invokevirtual 179	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: areturn
    //   65: astore_0
    //   66: aload_1
    //   67: areturn
    //   68: astore_1
    //   69: ldc 98
    //   71: iconst_2
    //   72: ldc 181
    //   74: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: invokevirtual 179	java/io/InputStream:close	()V
    //   81: aconst_null
    //   82: areturn
    //   83: astore_0
    //   84: aconst_null
    //   85: areturn
    //   86: astore_1
    //   87: aload_0
    //   88: invokevirtual 179	java/io/InputStream:close	()V
    //   91: aload_1
    //   92: athrow
    //   93: astore_0
    //   94: aload_1
    //   95: areturn
    //   96: astore_0
    //   97: goto -6 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramInputStream	java.io.InputStream
    //   23	44	1	localArrayList	ArrayList
    //   68	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   86	9	1	localList	List<String>
    //   15	10	2	localBufferedReader	java.io.BufferedReader
    //   44	1	2	localIOException	IOException
    //   28	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   24	29	44	java/io/IOException
    //   33	41	44	java/io/IOException
    //   59	63	65	java/io/IOException
    //   24	29	68	java/lang/OutOfMemoryError
    //   33	41	68	java/lang/OutOfMemoryError
    //   77	81	83	java/io/IOException
    //   24	29	86	finally
    //   33	41	86	finally
    //   45	53	86	finally
    //   69	77	86	finally
    //   53	57	93	java/io/IOException
    //   87	91	96	java/io/IOException
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString3 = getVersionArr("3.4.4");
      paramString3.add(Integer.valueOf(Integer.parseInt("3058")));
      paramString1 = getVersionArr(paramString1);
      paramString2 = getVersionArr(paramString2);
    } while ((paramString1.size() != paramString3.size() - 1) || (paramString2.size() != paramString3.size() - 1) || (compare(paramString1, paramString2) > 0) || (compare(paramString3, paramString1) < 0) || (compare(paramString3, paramString2) > 0));
    return true;
  }
  
  private static int compare(List<Integer> paramList1, List<Integer> paramList2)
  {
    int j = Math.min(paramList1.size(), paramList2.size());
    int i = 0;
    while (i < j)
    {
      if (((Integer)paramList1.get(i)).intValue() > ((Integer)paramList2.get(i)).intValue()) {
        return 1;
      }
      if (((Integer)paramList1.get(i)).intValue() < ((Integer)paramList2.get(i)).intValue()) {
        return -1;
      }
      i += 1;
    }
    return 0;
  }
  
  private static List<Integer> getVersionArr(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\\.");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      localArrayList.add(Integer.valueOf(Integer.parseInt(paramString[i])));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void init()
  {
    kvw.init();
    jpa.init();
  }
  
  public static void oy(String paramString)
  {
    eM.remove(paramString);
  }
  
  public static void pX(boolean paramBoolean)
  {
    ThreadManager.executeOnFileThread(new OfflineUtils.1(paramBoolean));
  }
  
  /* Error */
  public static String readInputStreamAsString(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 152	java/io/BufferedReader
    //   3: dup
    //   4: new 154	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 157	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 160	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 50	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +30 -> 60
    //   33: aload_1
    //   34: aload_3
    //   35: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: goto -15 -> 24
    //   42: astore_2
    //   43: ldc 98
    //   45: iconst_2
    //   46: ldc 174
    //   48: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: invokevirtual 179	java/io/InputStream:close	()V
    //   55: aload_1
    //   56: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: areturn
    //   60: aload_0
    //   61: invokevirtual 179	java/io/InputStream:close	()V
    //   64: goto -9 -> 55
    //   67: astore_0
    //   68: goto -13 -> 55
    //   71: astore_1
    //   72: ldc 98
    //   74: iconst_2
    //   75: ldc 181
    //   77: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: invokevirtual 179	java/io/InputStream:close	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aload_0
    //   91: invokevirtual 179	java/io/InputStream:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: astore_0
    //   97: goto -42 -> 55
    //   100: astore_0
    //   101: goto -7 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramInputStream	java.io.InputStream
    //   23	33	1	localStringBuilder	java.lang.StringBuilder
    //   71	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   89	6	1	localObject	Object
    //   15	10	2	localBufferedReader	java.io.BufferedReader
    //   42	1	2	localIOException	IOException
    //   28	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   24	29	42	java/io/IOException
    //   33	39	42	java/io/IOException
    //   60	64	67	java/io/IOException
    //   24	29	71	java/lang/OutOfMemoryError
    //   33	39	71	java/lang/OutOfMemoryError
    //   80	84	86	java/io/IOException
    //   24	29	89	finally
    //   33	39	89	finally
    //   43	51	89	finally
    //   72	80	89	finally
    //   51	55	96	java/io/IOException
    //   90	94	100	java/io/IOException
  }
  
  public static class a
  {
    public lan a = new lan();
    public final HashMap<String, String> dz = new HashMap();
    public int errorCode = 1002;
    public boolean isValid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npv
 * JD-Core Version:    0.7.0.1
 */