import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.math.BigInteger;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;

public class ablp
{
  private static boolean bDG;
  private static int cpK;
  private static int cpL;
  public static int cpM;
  private static final String[] dy = { "http", "https", "GameRes", "GameSandBox" };
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("page_id=").append(paramInt1).append("&").append("module_id=").append(paramInt2).append("&").append("action_type=").append(paramInt3).append("&").append("action_id=").append(paramInt4).append("&").append("item_id=").append(paramInt5).append("&").append("action_source=").append(paramInt6).append("&").append("platform=").append("android").append("&").append("ext3=").append(System.currentTimeMillis() / 1000L);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameTool", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  /* Error */
  public static String a(android.graphics.Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_0
    //   6: ifnull +128 -> 134
    //   9: new 95	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 98	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 104	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 110	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 114	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 120	aqgo:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 123	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 130	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 123	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 123	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_0
    //   127: goto -23 -> 104
    //   130: astore_0
    //   131: goto -60 -> 71
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_2
    //   137: astore_0
    //   138: goto -95 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramBitmap	android.graphics.Bitmap
    //   0	141	1	paramInt	int
    //   4	56	2	localObject1	Object
    //   61	2	2	localIOException1	java.io.IOException
    //   72	41	2	localObject2	Object
    //   118	19	2	localIOException2	java.io.IOException
    //   19	117	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1	77	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	61	java/io/IOException
    //   9	20	68	java/lang/Exception
    //   84	92	94	java/io/IOException
    //   9	20	101	finally
    //   108	116	118	java/io/IOException
    //   22	32	126	finally
    //   34	43	126	finally
    //   73	77	126	finally
    //   22	32	130	java/lang/Exception
    //   34	43	130	java/lang/Exception
  }
  
  public static void a(String paramString, JSONArray paramJSONArray)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ApolloGameTool", 1, "bitmap is null");
    }
    for (;;)
    {
      try
      {
        paramString = new StringBuilder(new BigInteger(paramString).toString(2)).reverse().toString();
        int k = paramString.length();
        int i = 0;
        if (i < 64)
        {
          if (i < k)
          {
            j = paramString.charAt(i) - '0';
            aA(i, j, 0);
            i += 1;
          }
        }
        else {
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameTool", 1, paramString, new Object[0]);
      }
      int j = 0;
    }
  }
  
  private static void aA(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameTool", 2, "set aio white " + paramInt2);
      }
      if (paramInt2 == 0)
      {
        ablf.M("CMGamePlusPanel", -ablg.cpG);
        return;
      }
    } while (paramInt2 != 1);
    ablf.M("CMGamePlusPanel", ablg.cpG);
  }
  
  public static String aF(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      String str;
      try
      {
        paramString1 = new JSONObject(paramString1);
        String[] arrayOfString = ablg.a.dx;
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label182;
        }
        str = arrayOfString[i];
        if (!paramString1.has(str)) {
          break label198;
        }
        Object localObject = paramString1.opt(str);
        if ((localObject == null) || (localObject.toString().equals(paramString2))) {
          break label198;
        }
        if ((localObject instanceof String))
        {
          paramString1.put(str, paramString2);
          if (!QLog.isColorLevel()) {
            break label198;
          }
          QLog.e("ApolloGameTool", 2, "[filterSSOPara] " + localObject + " " + paramString2);
          break label198;
        }
        if ((localObject instanceof Integer))
        {
          paramString1.put(str, Integer.parseInt(paramString2));
          continue;
        }
        if (!(localObject instanceof Long)) {
          continue;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("ApolloGameTool", 1, new Object[0]);
        return null;
      }
      paramString1.put(str, Long.parseLong(paramString2));
      continue;
      label182:
      paramString1.put("from", "android.H5");
      paramString1 = paramString1.toString();
      return paramString1;
      label198:
      i += 1;
    }
  }
  
  public static String b(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString1))
    {
      try
      {
        if (paramString1.length() > 4096)
        {
          if (!QLog.isColorLevel()) {
            break label749;
          }
          QLog.d("ApolloGameTool", 2, "[urlToPath] too long " + paramString1.substring(0, 100));
          return null;
        }
        localObject1 = URLDecoder.decode(paramString1, "UTF-8");
        paramString1 = (String)localObject1;
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          int i;
          String str;
          int j;
          label154:
          QLog.e("ApolloGameTool", 1, paramString2, new Object[0]);
          localObject1 = paramString1;
          localObject2 = localObject4;
        }
      }
      try
      {
        i = paramString1.indexOf("://");
        localObject1 = paramString1;
        localObject2 = localObject4;
        if (i == -1) {
          break label586;
        }
        if (!paramBoolean) {
          break label736;
        }
        localObject1 = Uri.parse(paramString1);
        str = ((Uri)localObject1).getHost();
        j = ((Uri)localObject1).getPort();
        if (j == 0) {
          break label730;
        }
        localObject1 = paramString1.replace(":" + j, "");
      }
      catch (Throwable paramString2)
      {
        break label691;
        localObject1 = paramString1;
        break label154;
        break label221;
      }
      paramString1 = (String)localObject1;
      localObject2 = localObject1;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = localObject1;
          paramString1 = str + "/";
          localObject2 = localObject1;
          if (!((String)localObject1).contains(paramString1)) {
            continue;
          }
          localObject2 = localObject1;
          paramString1 = ((String)localObject1).replace(paramString1, "");
        }
        label221:
        localObject1 = paramString1;
        localObject2 = paramString1;
        if (paramString1.contains("?"))
        {
          localObject2 = paramString1;
          j = paramString1.indexOf("?");
          if (j == 0) {
            break;
          }
          localObject1 = paramString1;
          if (j != -1)
          {
            localObject2 = paramString1;
            localObject1 = paramString1.substring(0, j);
          }
        }
        localObject2 = localObject1;
        paramString1 = ((String)localObject1).substring(0, i);
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject2 = localObject1;
        localObject3 = dy;
        localObject2 = localObject1;
        j = localObject3.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        localObject2 = localObject1;
        if (!paramString1.equals(localObject3[i])) {
          continue;
        }
        localObject2 = localObject1;
        str = ix(String.valueOf(paramInt));
        localObject2 = localObject1;
        localObject3 = ((String)localObject1).replace(paramString1 + "://", "");
        paramString1 = (String)localObject3;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject2 = localObject1;
          paramString1 = paramString2 + "/" + (String)localObject3;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject2 = localObject1;
        paramString1 = new File(str + "/" + paramString1);
        localObject2 = localObject1;
        paramString2 = new File(str);
        localObject2 = localObject1;
        if (!paramString1.exists()) {
          continue;
        }
        localObject2 = localObject1;
        if (!paramString1.isFile()) {
          continue;
        }
        localObject2 = localObject1;
        paramString2 = paramString2.getCanonicalPath();
        localObject2 = localObject1;
        paramString1 = paramString1.getCanonicalPath();
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject2 = localObject1;
        paramBoolean = paramString1.startsWith(paramString2);
        if (!paramBoolean) {
          continue;
        }
        localObject2 = paramString1;
      }
      catch (Throwable paramString2)
      {
        label586:
        paramString1 = (String)localObject2;
        label691:
        continue;
        localObject2 = localObject4;
        continue;
      }
      localObject3 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloGameTool", 2, "[urlToPath] " + (String)localObject1 + " " + (String)localObject2);
      return localObject2;
      localObject2 = localObject1;
      paramString1 = ((String)localObject1).replace(str, "");
      continue;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        QLog.d("ApolloGameTool", 2, "[urlToPath] path leak");
      }
      paramString1 = null;
      continue;
      i += 1;
      continue;
      label730:
      label736:
      localObject1 = paramString1;
      localObject2 = localObject4;
    }
    label749:
    return localObject3;
  }
  
  public static void cCO()
  {
    bDG = false;
    cpK = 0;
    cpL = 0;
    cpM = 0;
  }
  
  public static void cb(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ApolloGameTool", 1, "app is null");
    }
    do
    {
      return;
      paramQQAppInterface = (aqrb)paramQQAppInterface.getBusinessHandler(71);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.efg();
  }
  
  public static int cf(String paramString)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = new JSONObject(paramString).optInt("xyRootSrc");
      return i;
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameTool", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  public static int fZ(int paramInt)
  {
    Object localObject = abmt.a(paramInt);
    if (localObject != null)
    {
      localObject = ((abos)localObject).c();
      if (localObject != null) {
        return ((CmGameInitParams)localObject).mSrc;
      }
    }
    return 0;
  }
  
  public static String ix(String paramString)
  {
    return ablg.bgO + "/" + paramString;
  }
  
  public static String iy(String paramString)
  {
    String str = paramString;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        str = paramString.replace("\\", "\\\\").replace("'", "\\'");
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameTool", 1, localThrowable, new Object[0]);
    }
    return paramString;
  }
  
  public static String iz(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("extendInfo"))
        {
          paramString = new JSONObject(paramString.optString("extendInfo"));
          if (paramString.has("bk_share_url"))
          {
            paramString = paramString.optString("bk_share_url");
            return paramString;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("ApolloGameTool", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  public static boolean jt(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  public static void setActivityFullScreen(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(5894);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ablp
 * JD-Core Version:    0.7.0.1
 */