package com.tencent.mobileqq.microapp.a;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.microapp.R.anim;
import com.tencent.mobileqq.microapp.widget.media.b;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public String a;
  public String b;
  
  public static int a()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static File a(InputStream paramInputStream, String paramString)
  {
    try
    {
      paramString = new File(BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/tmp" + paramString);
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      localFileOutputStream.close();
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      System.out.println();
      return null;
    }
    paramInputStream.close();
    return paramString;
  }
  
  public static File a(String paramString)
  {
    File localFile = null;
    Object localObject1 = BaseApplicationImpl.getContext().getAssets();
    try
    {
      localObject1 = ((AssetManager)localObject1).open(paramString);
      if (localObject1 != null) {
        localFile = a((InputStream)localObject1, paramString);
      }
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 173	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 164	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 176	java/io/InputStream:available	()I
    //   15: newarray byte
    //   17: astore_2
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 121	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload_1
    //   27: astore_0
    //   28: new 178	java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: ldc 180
    //   35: invokespecial 183	java/lang/String:<init>	([BLjava/lang/String;)V
    //   38: astore_2
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 145	java/io/InputStream:close	()V
    //   47: aload_2
    //   48: areturn
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   58: aload_1
    //   59: ifnull +7 -> 66
    //   62: aload_1
    //   63: invokevirtual 145	java/io/InputStream:close	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 145	java/io/InputStream:close	()V
    //   79: aload_1
    //   80: athrow
    //   81: astore_0
    //   82: aload_2
    //   83: areturn
    //   84: astore_0
    //   85: goto -19 -> 66
    //   88: astore_0
    //   89: goto -10 -> 79
    //   92: astore_1
    //   93: goto -22 -> 71
    //   96: astore_2
    //   97: goto -45 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramContext	android.content.Context
    //   0	100	1	paramString	String
    //   17	31	2	localObject	Object
    //   49	34	2	localException1	Exception
    //   96	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	49	java/lang/Exception
    //   0	9	68	finally
    //   43	47	81	java/io/IOException
    //   62	66	84	java/io/IOException
    //   75	79	88	java/io/IOException
    //   11	18	92	finally
    //   20	26	92	finally
    //   28	39	92	finally
    //   54	58	92	finally
    //   11	18	96	java/lang/Exception
    //   20	26	96	java/lang/Exception
    //   28	39	96	java/lang/Exception
  }
  
  public static String a(File paramFile)
  {
    try
    {
      paramFile = b(paramFile);
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      paramFile.printStackTrace();
    }
    return "";
  }
  
  public static JSONArray a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
    throws JSONException
  {
    int k = 0;
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramJSONArray1.length()) {
        break;
      }
      localJSONArray.put(paramJSONArray1.get(i));
      i += 1;
    }
    while (j < paramJSONArray2.length())
    {
      localJSONArray.put(paramJSONArray2.get(j));
      j += 1;
    }
    return localJSONArray;
  }
  
  public static JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return paramString;
    }
    if (paramJSONObject == null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        label63:
        for (;;) {}
      }
      catch (Exception paramString)
      {
        try
        {
          paramJSONObject.put("errMsg", paramString + ":ok");
          for (;;)
          {
            return paramJSONObject;
            paramString = paramString;
          }
        }
        catch (Exception paramString)
        {
          break label63;
        }
      }
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +19 -> 23
    //   7: aload_1
    //   8: astore_0
    //   9: aload_1
    //   10: ifnonnull +11 -> 21
    //   13: new 216	org/json/JSONObject
    //   16: dup
    //   17: invokespecial 217	org/json/JSONObject:<init>	()V
    //   20: astore_0
    //   21: aload_0
    //   22: areturn
    //   23: aload_1
    //   24: ifnonnull +89 -> 113
    //   27: new 216	org/json/JSONObject
    //   30: dup
    //   31: invokespecial 217	org/json/JSONObject:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: astore_1
    //   37: new 83	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 227
    //   50: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: astore_3
    //   54: aload_2
    //   55: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +24 -> 82
    //   61: ldc 189
    //   63: astore_0
    //   64: aload_1
    //   65: ldc 219
    //   67: aload_3
    //   68: aload_0
    //   69: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 224	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: goto +37 -> 116
    //   82: new 83	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   89: ldc 229
    //   91: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_0
    //   102: goto -38 -> 64
    //   105: astore_0
    //   106: goto +10 -> 116
    //   109: astore_0
    //   110: goto +6 -> 116
    //   113: goto -76 -> 37
    //   116: aload_1
    //   117: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramString1	String
    //   0	118	1	paramJSONObject	JSONObject
    //   0	118	2	paramString2	String
    //   34	34	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	35	105	java/lang/Exception
    //   37	61	109	java/lang/Exception
    //   64	79	109	java/lang/Exception
    //   82	102	109	java/lang/Exception
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramObject);
      return localJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("JSONUtil", 1, paramJSONObject, new Object[0]);
    }
    return localJSONObject;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {
      paramActivity.overridePendingTransition(R.anim.b, R.anim.c);
    }
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    try
    {
      paramString = b(new File(paramString));
      paramWebView.evaluateJavascript(paramString, null);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private static void a(File paramFile, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((!paramFile.getParentFile().exists()) && (!paramFile.getParentFile().mkdirs())) {
      throw new RuntimeException("Create folder fail:" + paramFile.getParentFile().getAbsolutePath());
    }
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramFile.write(paramArrayOfByte);
      return;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static void a(String paramString, com.tencent.mobileqq.microapp.widget.media.c paramc)
  {
    new b(paramc).execute(new String[] { paramString });
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  public static void a(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        a((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return 1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D < 0.5D;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = a(paramString1, paramString2, "");
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +12 -> 19
    //   10: aload_1
    //   11: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: istore_3
    //   15: iload_3
    //   16: ifeq +10 -> 26
    //   19: iconst_0
    //   20: istore_3
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: new 81	java/io/File
    //   29: dup
    //   30: aload_1
    //   31: aload_2
    //   32: invokespecial 380	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: invokevirtual 270	java/io/File:exists	()Z
    //   38: ifeq +8 -> 46
    //   41: iconst_1
    //   42: istore_3
    //   43: goto -22 -> 21
    //   46: aload_0
    //   47: aload_1
    //   48: aload_2
    //   49: invokestatic 382	com/tencent/mobileqq/microapp/a/c:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   52: istore_3
    //   53: goto -32 -> 21
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramString1	String
    //   0	62	1	paramString2	String
    //   0	62	2	paramString3	String
    //   14	39	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	15	56	finally
    //   26	41	56	finally
    //   46	53	56	finally
  }
  
  /* Error */
  public static String b(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 270	java/io/File:exists	()Z
    //   16: ifeq +85 -> 101
    //   19: aload_0
    //   20: invokevirtual 385	java/io/File:isDirectory	()Z
    //   23: ifeq +37 -> 60
    //   26: new 79	java/io/IOException
    //   29: dup
    //   30: new 83	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 387
    //   40: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: ldc_w 392
    //   50: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 393	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: aload_0
    //   61: invokevirtual 396	java/io/File:canRead	()Z
    //   64: ifne +71 -> 135
    //   67: new 79	java/io/IOException
    //   70: dup
    //   71: new 83	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 387
    //   81: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: ldc_w 398
    //   91: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 393	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   100: athrow
    //   101: new 400	java/io/FileNotFoundException
    //   104: dup
    //   105: new 83	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 387
    //   115: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: ldc_w 402
    //   125: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 403	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   134: athrow
    //   135: new 405	java/io/FileInputStream
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 406	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: astore_3
    //   144: new 408	java/io/InputStreamReader
    //   147: dup
    //   148: aload_3
    //   149: ldc_w 410
    //   152: invokespecial 413	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   155: astore_2
    //   156: aload_0
    //   157: invokevirtual 416	java/io/File:length	()J
    //   160: l2i
    //   161: istore_1
    //   162: iload_1
    //   163: sipush 12288
    //   166: if_icmple +100 -> 266
    //   169: sipush 4096
    //   172: newarray char
    //   174: astore_0
    //   175: new 83	java/lang/StringBuilder
    //   178: dup
    //   179: sipush 12288
    //   182: invokespecial 419	java/lang/StringBuilder:<init>	(I)V
    //   185: astore 5
    //   187: aload_2
    //   188: aload_0
    //   189: invokevirtual 422	java/io/InputStreamReader:read	([C)I
    //   192: istore_1
    //   193: iconst_m1
    //   194: iload_1
    //   195: if_icmpeq +42 -> 237
    //   198: aload 5
    //   200: aload_0
    //   201: iconst_0
    //   202: iload_1
    //   203: invokevirtual 425	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: goto -20 -> 187
    //   210: astore_0
    //   211: aload_2
    //   212: astore_0
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 145	java/io/InputStream:close	()V
    //   221: aload 4
    //   223: astore_3
    //   224: aload_0
    //   225: ifnull -215 -> 10
    //   228: aload_0
    //   229: invokevirtual 426	java/io/InputStreamReader:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aconst_null
    //   236: areturn
    //   237: aload 5
    //   239: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore_0
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 145	java/io/InputStream:close	()V
    //   251: aload_0
    //   252: astore_3
    //   253: aload_2
    //   254: ifnull -244 -> 10
    //   257: aload_2
    //   258: invokevirtual 426	java/io/InputStreamReader:close	()V
    //   261: aload_0
    //   262: areturn
    //   263: astore_2
    //   264: aload_0
    //   265: areturn
    //   266: iload_1
    //   267: newarray char
    //   269: astore_0
    //   270: new 178	java/lang/String
    //   273: dup
    //   274: aload_0
    //   275: iconst_0
    //   276: aload_2
    //   277: aload_0
    //   278: invokevirtual 422	java/io/InputStreamReader:read	([C)I
    //   281: invokespecial 429	java/lang/String:<init>	([CII)V
    //   284: astore_0
    //   285: goto -42 -> 243
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_3
    //   291: aconst_null
    //   292: astore_2
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 145	java/io/InputStream:close	()V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 426	java/io/InputStreamReader:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_3
    //   312: goto -61 -> 251
    //   315: astore_2
    //   316: goto -95 -> 221
    //   319: astore_3
    //   320: goto -19 -> 301
    //   323: astore_2
    //   324: goto -15 -> 309
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_2
    //   330: goto -37 -> 293
    //   333: astore_0
    //   334: goto -41 -> 293
    //   337: astore_0
    //   338: aconst_null
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_3
    //   342: goto -129 -> 213
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -135 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramFile	File
    //   161	106	1	i	int
    //   155	103	2	localInputStreamReader	java.io.InputStreamReader
    //   263	14	2	localException1	Exception
    //   292	14	2	localObject1	Object
    //   315	1	2	localException2	Exception
    //   323	1	2	localException3	Exception
    //   329	1	2	localObject2	Object
    //   9	289	3	localObject3	Object
    //   311	1	3	localException4	Exception
    //   319	1	3	localException5	Exception
    //   341	1	3	localObject4	Object
    //   1	221	4	localObject5	Object
    //   185	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   156	162	210	java/lang/Exception
    //   169	187	210	java/lang/Exception
    //   187	193	210	java/lang/Exception
    //   198	207	210	java/lang/Exception
    //   237	243	210	java/lang/Exception
    //   266	285	210	java/lang/Exception
    //   228	232	234	java/lang/Exception
    //   257	261	263	java/lang/Exception
    //   135	144	288	finally
    //   247	251	311	java/lang/Exception
    //   217	221	315	java/lang/Exception
    //   297	301	319	java/lang/Exception
    //   305	309	323	java/lang/Exception
    //   144	156	327	finally
    //   156	162	333	finally
    //   169	187	333	finally
    //   187	193	333	finally
    //   198	207	333	finally
    //   237	243	333	finally
    //   266	285	333	finally
    //   135	144	337	java/lang/Exception
    //   144	156	345	java/lang/Exception
  }
  
  public static String b(String paramString)
  {
    String str = Uri.parse("file:///" + paramString).getPath();
    paramString = str;
    if (str != null)
    {
      paramString = str;
      if (str.startsWith("/")) {
        paramString = str.substring(1);
      }
    }
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        List localList = URLEncodedUtils.parse(new URI(paramString1), "UTF-8");
        localObject1 = localObject2;
        int j = localList.size();
        int i = 0;
        paramString1 = (String)localObject2;
        localObject1 = paramString1;
        if (i < j)
        {
          localObject1 = paramString1;
          localObject2 = (NameValuePair)localList.get(i);
          localObject1 = paramString1;
          if (((NameValuePair)localObject2).getName().equals(paramString2))
          {
            localObject1 = paramString1;
            paramString1 = ((NameValuePair)localObject2).getValue();
            i += 1;
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (URISyntaxException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static JSONObject b(String paramString, JSONObject paramJSONObject)
  {
    return a(paramString, paramJSONObject, null);
  }
  
  public static void b(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(R.anim.a, R.anim.d);
    }
  }
  
  /* Error */
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +80 -> 100
    //   23: new 83	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   30: new 81	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 280	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc_w 487
    //   47: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore_1
    //   54: aconst_null
    //   55: astore 7
    //   57: new 489	java/io/RandomAccessFile
    //   60: dup
    //   61: aload_0
    //   62: ldc_w 491
    //   65: invokespecial 492	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 496	java/io/RandomAccessFile:readByte	()B
    //   73: bipush 190
    //   75: if_icmpeq +40 -> 115
    //   78: new 275	java/lang/RuntimeException
    //   81: dup
    //   82: ldc_w 498
    //   85: invokespecial 281	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: astore_1
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 499	java/io/RandomAccessFile:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: new 81	java/io/File
    //   103: dup
    //   104: aload_2
    //   105: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 280	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: astore_2
    //   112: goto -58 -> 54
    //   115: aload_0
    //   116: ldc2_w 500
    //   119: invokevirtual 505	java/io/RandomAccessFile:seek	(J)V
    //   122: aload_0
    //   123: invokevirtual 508	java/io/RandomAccessFile:readInt	()I
    //   126: istore 4
    //   128: new 510	java/util/ArrayList
    //   131: dup
    //   132: iload 4
    //   134: invokespecial 511	java/util/ArrayList:<init>	(I)V
    //   137: astore 9
    //   139: iconst_0
    //   140: istore_3
    //   141: iload_3
    //   142: iload 4
    //   144: if_icmpge +141 -> 285
    //   147: aload_0
    //   148: invokevirtual 508	java/io/RandomAccessFile:readInt	()I
    //   151: istore 5
    //   153: iload 5
    //   155: newarray byte
    //   157: astore 7
    //   159: aload_0
    //   160: aload 7
    //   162: iconst_0
    //   163: iload 5
    //   165: invokevirtual 514	java/io/RandomAccessFile:read	([BII)I
    //   168: pop
    //   169: new 81	java/io/File
    //   172: dup
    //   173: new 178	java/lang/String
    //   176: dup
    //   177: aload 7
    //   179: iconst_0
    //   180: iload 5
    //   182: invokespecial 516	java/lang/String:<init>	([BII)V
    //   185: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 280	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   191: astore 8
    //   193: aload 8
    //   195: astore 7
    //   197: aload_2
    //   198: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifne +54 -> 255
    //   204: aload 8
    //   206: aload_2
    //   207: invokevirtual 445	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   210: istore 6
    //   212: iload 6
    //   214: ifne +13 -> 227
    //   217: aload_0
    //   218: ifnull +7 -> 225
    //   221: aload_0
    //   222: invokevirtual 499	java/io/RandomAccessFile:close	()V
    //   225: iconst_0
    //   226: ireturn
    //   227: aload 8
    //   229: aload_2
    //   230: new 83	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   237: aload_2
    //   238: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc_w 487
    //   244: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokevirtual 519	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   253: astore 7
    //   255: aload 9
    //   257: new 6	com/tencent/mobileqq/microapp/a/c$a
    //   260: dup
    //   261: aload 7
    //   263: aload_0
    //   264: invokevirtual 508	java/io/RandomAccessFile:readInt	()I
    //   267: aload_0
    //   268: invokevirtual 508	java/io/RandomAccessFile:readInt	()I
    //   271: invokespecial 522	com/tencent/mobileqq/microapp/a/c$a:<init>	(Ljava/lang/String;II)V
    //   274: invokevirtual 525	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   277: pop
    //   278: iload_3
    //   279: iconst_1
    //   280: iadd
    //   281: istore_3
    //   282: goto -141 -> 141
    //   285: aload 9
    //   287: invokevirtual 526	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   290: astore_2
    //   291: aload_2
    //   292: invokeinterface 326 1 0
    //   297: ifeq +86 -> 383
    //   300: aload_2
    //   301: invokeinterface 330 1 0
    //   306: checkcast 6	com/tencent/mobileqq/microapp/a/c$a
    //   309: astore 7
    //   311: new 81	java/io/File
    //   314: dup
    //   315: aload_1
    //   316: aload 7
    //   318: getfield 528	com/tencent/mobileqq/microapp/a/c$a:a	Ljava/lang/String;
    //   321: invokespecial 380	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: astore 8
    //   326: aload_0
    //   327: aload 7
    //   329: getfield 529	com/tencent/mobileqq/microapp/a/c$a:b	I
    //   332: i2l
    //   333: invokevirtual 505	java/io/RandomAccessFile:seek	(J)V
    //   336: aload 7
    //   338: getfield 530	com/tencent/mobileqq/microapp/a/c$a:c	I
    //   341: newarray byte
    //   343: astore 9
    //   345: aload_0
    //   346: aload 9
    //   348: iconst_0
    //   349: aload 7
    //   351: getfield 530	com/tencent/mobileqq/microapp/a/c$a:c	I
    //   354: invokevirtual 514	java/io/RandomAccessFile:read	([BII)I
    //   357: pop
    //   358: aload 8
    //   360: aload 9
    //   362: invokestatic 532	com/tencent/mobileqq/microapp/a/c:a	(Ljava/io/File;[B)V
    //   365: goto -74 -> 291
    //   368: astore_2
    //   369: aload_0
    //   370: astore_1
    //   371: aload_2
    //   372: astore_0
    //   373: aload_1
    //   374: ifnull +7 -> 381
    //   377: aload_1
    //   378: invokevirtual 499	java/io/RandomAccessFile:close	()V
    //   381: aload_0
    //   382: athrow
    //   383: aload_0
    //   384: ifnull +7 -> 391
    //   387: aload_0
    //   388: invokevirtual 499	java/io/RandomAccessFile:close	()V
    //   391: iconst_1
    //   392: ireturn
    //   393: astore_0
    //   394: goto -169 -> 225
    //   397: astore_0
    //   398: goto -7 -> 391
    //   401: astore_0
    //   402: goto -304 -> 98
    //   405: astore_1
    //   406: goto -25 -> 381
    //   409: astore_0
    //   410: aconst_null
    //   411: astore_1
    //   412: goto -39 -> 373
    //   415: astore_0
    //   416: aload 7
    //   418: astore_0
    //   419: goto -329 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	paramString1	String
    //   0	422	1	paramString2	String
    //   0	422	2	paramString3	String
    //   140	142	3	i	int
    //   126	19	4	j	int
    //   151	30	5	k	int
    //   210	3	6	bool	boolean
    //   55	362	7	localObject1	Object
    //   191	168	8	localObject2	Object
    //   137	224	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   69	89	89	java/lang/Exception
    //   115	139	89	java/lang/Exception
    //   147	193	89	java/lang/Exception
    //   197	212	89	java/lang/Exception
    //   227	255	89	java/lang/Exception
    //   255	278	89	java/lang/Exception
    //   285	291	89	java/lang/Exception
    //   291	365	89	java/lang/Exception
    //   69	89	368	finally
    //   115	139	368	finally
    //   147	193	368	finally
    //   197	212	368	finally
    //   227	255	368	finally
    //   255	278	368	finally
    //   285	291	368	finally
    //   291	365	368	finally
    //   221	225	393	java/lang/Exception
    //   387	391	397	java/lang/Exception
    //   94	98	401	java/lang/Exception
    //   377	381	405	java/lang/Exception
    //   57	69	409	finally
    //   57	69	415	java/lang/Exception
  }
  
  public static Map c(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = Uri.parse("file:///" + paramString);
    Iterator localIterator = paramString.getQueryParameterNames().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramString.getQueryParameter(str));
    }
    return localHashMap;
  }
  
  private static boolean c(String paramString1, String paramString2, String paramString3)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      String str1;
      do
      {
        String str2;
        do
        {
          return false;
          str1 = new File(paramString2, paramString3).getAbsolutePath();
          str2 = str1 + "Tmp";
          a(str2, false);
        } while (!b(paramString1, paramString2, paramString3));
        paramString1 = new File(str2);
      } while (!paramString1.exists());
      paramString2 = new File(str1);
      a(str1, false);
    } while ((!a(paramString1, paramString2)) || (!paramString2.exists()));
    return true;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("?");
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public static int[] e(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return new int[0];
    }
    paramString = paramString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
    int[] arrayOfInt = new int[paramString.length];
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        label65:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label65;
      }
    }
  }
  
  public static int f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    String str = paramString;
    if (paramString.length() == 7) {
      str = "#FF" + paramString.substring(1);
    }
    return Color.parseColor(str);
  }
  
  /* Error */
  public static Bitmap g(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 594	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   6: ifeq +7 -> 13
    //   9: aload_2
    //   10: astore_0
    //   11: aload_0
    //   12: areturn
    //   13: new 405	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 595	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: new 597	java/io/BufferedInputStream
    //   25: dup
    //   26: aload_0
    //   27: sipush 8192
    //   30: invokespecial 600	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokestatic 606	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   38: astore_3
    //   39: aload_3
    //   40: astore_2
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 607	java/io/FileInputStream:close	()V
    //   49: aload_2
    //   50: astore_0
    //   51: aload_1
    //   52: ifnull -41 -> 11
    //   55: aload_1
    //   56: invokevirtual 608	java/io/BufferedInputStream:close	()V
    //   59: aload_2
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   66: aload_2
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_1
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 607	java/io/FileInputStream:close	()V
    //   81: aload_2
    //   82: astore_0
    //   83: aload_1
    //   84: ifnull -73 -> 11
    //   87: aload_1
    //   88: invokevirtual 608	java/io/BufferedInputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 607	java/io/FileInputStream:close	()V
    //   113: aload_2
    //   114: astore_0
    //   115: aload_1
    //   116: ifnull -105 -> 11
    //   119: aload_1
    //   120: invokevirtual 608	java/io/BufferedInputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 607	java/io/FileInputStream:close	()V
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 608	java/io/BufferedInputStream:close	()V
    //   153: aload_2
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_1
    //   166: goto -29 -> 137
    //   169: astore_2
    //   170: goto -33 -> 137
    //   173: astore_1
    //   174: aconst_null
    //   175: astore_1
    //   176: goto -71 -> 105
    //   179: astore_3
    //   180: goto -75 -> 105
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_1
    //   186: goto -113 -> 73
    //   189: astore_3
    //   190: goto -117 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramString	String
    //   33	133	1	localBufferedInputStream	java.io.BufferedInputStream
    //   173	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   175	1	1	localObject1	Object
    //   183	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   185	1	1	localObject2	Object
    //   1	113	2	localObject3	Object
    //   132	22	2	localObject4	Object
    //   163	1	2	localObject5	Object
    //   169	1	2	localObject6	Object
    //   38	2	3	localBitmap	Bitmap
    //   179	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   189	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   45	49	61	java/io/IOException
    //   55	59	61	java/io/IOException
    //   13	22	68	java/lang/OutOfMemoryError
    //   77	81	93	java/io/IOException
    //   87	91	93	java/io/IOException
    //   13	22	100	java/io/FileNotFoundException
    //   109	113	125	java/io/IOException
    //   119	123	125	java/io/IOException
    //   13	22	132	finally
    //   141	145	155	java/io/IOException
    //   149	153	155	java/io/IOException
    //   22	34	163	finally
    //   34	39	169	finally
    //   22	34	173	java/io/FileNotFoundException
    //   34	39	179	java/io/FileNotFoundException
    //   22	34	183	java/lang/OutOfMemoryError
    //   34	39	189	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static java.io.ByteArrayInputStream h(String paramString)
  {
    // Byte code:
    //   0: new 81	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 270	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 405	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 406	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: new 597	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_2
    //   32: sipush 8192
    //   35: invokespecial 600	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   38: astore_3
    //   39: new 612	java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial 613	java/io/ByteArrayOutputStream:<init>	()V
    //   46: astore_0
    //   47: aload_3
    //   48: astore 6
    //   50: aload_0
    //   51: astore 5
    //   53: aload_2
    //   54: astore 4
    //   56: sipush 1024
    //   59: newarray byte
    //   61: astore 7
    //   63: aload_3
    //   64: astore 6
    //   66: aload_0
    //   67: astore 5
    //   69: aload_2
    //   70: astore 4
    //   72: aload_3
    //   73: aload 7
    //   75: invokevirtual 614	java/io/BufferedInputStream:read	([B)I
    //   78: istore_1
    //   79: iload_1
    //   80: iconst_m1
    //   81: if_icmpeq +72 -> 153
    //   84: aload_3
    //   85: astore 6
    //   87: aload_0
    //   88: astore 5
    //   90: aload_2
    //   91: astore 4
    //   93: aload_0
    //   94: aload 7
    //   96: iconst_0
    //   97: iload_1
    //   98: invokevirtual 615	java/io/ByteArrayOutputStream:write	([BII)V
    //   101: goto -38 -> 63
    //   104: astore 7
    //   106: aload_3
    //   107: astore 6
    //   109: aload_0
    //   110: astore 5
    //   112: aload_2
    //   113: astore 4
    //   115: aload 7
    //   117: invokevirtual 616	java/io/FileNotFoundException:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 617	java/io/ByteArrayOutputStream:close	()V
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 608	java/io/BufferedInputStream:close	()V
    //   136: aload_2
    //   137: ifnull -121 -> 16
    //   140: aload_2
    //   141: invokevirtual 607	java/io/FileInputStream:close	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: aload_3
    //   154: astore 6
    //   156: aload_0
    //   157: astore 5
    //   159: aload_2
    //   160: astore 4
    //   162: new 619	java/io/ByteArrayInputStream
    //   165: dup
    //   166: aload_0
    //   167: invokevirtual 623	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   170: invokespecial 625	java/io/ByteArrayInputStream:<init>	([B)V
    //   173: astore 7
    //   175: aload_0
    //   176: ifnull +7 -> 183
    //   179: aload_0
    //   180: invokevirtual 617	java/io/ByteArrayOutputStream:close	()V
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 608	java/io/BufferedInputStream:close	()V
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 607	java/io/FileInputStream:close	()V
    //   199: aload 7
    //   201: areturn
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   207: goto -8 -> 199
    //   210: astore 7
    //   212: aconst_null
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_2
    //   218: aload_3
    //   219: astore 6
    //   221: aload_0
    //   222: astore 5
    //   224: aload_2
    //   225: astore 4
    //   227: aload 7
    //   229: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 617	java/io/ByteArrayOutputStream:close	()V
    //   240: aload_3
    //   241: ifnull +7 -> 248
    //   244: aload_3
    //   245: invokevirtual 608	java/io/BufferedInputStream:close	()V
    //   248: aload_2
    //   249: ifnull -233 -> 16
    //   252: aload_2
    //   253: invokevirtual 607	java/io/FileInputStream:close	()V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   263: aconst_null
    //   264: areturn
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_3
    //   268: aconst_null
    //   269: astore 5
    //   271: aconst_null
    //   272: astore_2
    //   273: aload 5
    //   275: ifnull +8 -> 283
    //   278: aload 5
    //   280: invokevirtual 617	java/io/ByteArrayOutputStream:close	()V
    //   283: aload_3
    //   284: ifnull +7 -> 291
    //   287: aload_3
    //   288: invokevirtual 608	java/io/BufferedInputStream:close	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 607	java/io/FileInputStream:close	()V
    //   299: aload_0
    //   300: athrow
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   306: goto -7 -> 299
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_3
    //   312: aconst_null
    //   313: astore 5
    //   315: goto -42 -> 273
    //   318: astore_0
    //   319: aconst_null
    //   320: astore 5
    //   322: goto -49 -> 273
    //   325: astore_0
    //   326: aload 6
    //   328: astore_3
    //   329: aload 4
    //   331: astore_2
    //   332: goto -59 -> 273
    //   335: astore 7
    //   337: aconst_null
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -123 -> 218
    //   344: astore 7
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -130 -> 218
    //   351: astore 7
    //   353: goto -135 -> 218
    //   356: astore 7
    //   358: aconst_null
    //   359: astore_3
    //   360: aconst_null
    //   361: astore_0
    //   362: aconst_null
    //   363: astore_2
    //   364: goto -258 -> 106
    //   367: astore 7
    //   369: aconst_null
    //   370: astore_3
    //   371: aconst_null
    //   372: astore_0
    //   373: goto -267 -> 106
    //   376: astore 7
    //   378: aconst_null
    //   379: astore_0
    //   380: goto -274 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramString	String
    //   78	20	1	i	int
    //   26	270	2	localFileInputStream1	java.io.FileInputStream
    //   301	2	2	localIOException1	IOException
    //   331	33	2	localObject1	Object
    //   38	333	3	localObject2	Object
    //   54	276	4	localFileInputStream2	java.io.FileInputStream
    //   51	270	5	str	String
    //   48	279	6	localObject3	Object
    //   61	34	7	arrayOfByte	byte[]
    //   104	12	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   173	27	7	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   210	18	7	localIOException2	IOException
    //   335	1	7	localIOException3	IOException
    //   344	1	7	localIOException4	IOException
    //   351	1	7	localIOException5	IOException
    //   356	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   367	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   376	1	7	localFileNotFoundException4	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   56	63	104	java/io/FileNotFoundException
    //   72	79	104	java/io/FileNotFoundException
    //   93	101	104	java/io/FileNotFoundException
    //   162	175	104	java/io/FileNotFoundException
    //   124	128	146	java/io/IOException
    //   132	136	146	java/io/IOException
    //   140	144	146	java/io/IOException
    //   179	183	202	java/io/IOException
    //   187	191	202	java/io/IOException
    //   195	199	202	java/io/IOException
    //   18	27	210	java/io/IOException
    //   236	240	258	java/io/IOException
    //   244	248	258	java/io/IOException
    //   252	256	258	java/io/IOException
    //   18	27	265	finally
    //   278	283	301	java/io/IOException
    //   287	291	301	java/io/IOException
    //   295	299	301	java/io/IOException
    //   27	39	309	finally
    //   39	47	318	finally
    //   56	63	325	finally
    //   72	79	325	finally
    //   93	101	325	finally
    //   115	120	325	finally
    //   162	175	325	finally
    //   227	232	325	finally
    //   27	39	335	java/io/IOException
    //   39	47	344	java/io/IOException
    //   56	63	351	java/io/IOException
    //   72	79	351	java/io/IOException
    //   93	101	351	java/io/IOException
    //   162	175	351	java/io/IOException
    //   18	27	356	java/io/FileNotFoundException
    //   27	39	367	java/io/FileNotFoundException
    //   39	47	376	java/io/FileNotFoundException
  }
  
  /* Error */
  public static java.io.ByteArrayInputStream i(String paramString)
  {
    // Byte code:
    //   0: new 81	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 405	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 406	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore 5
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_0
    //   28: aload 5
    //   30: invokevirtual 627	java/io/FileInputStream:read	([B)I
    //   33: istore_2
    //   34: iload_2
    //   35: iconst_m1
    //   36: if_icmpne +106 -> 142
    //   39: aload_3
    //   40: iconst_0
    //   41: aload_3
    //   42: arraylength
    //   43: invokestatic 631	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   46: getstatic 51	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   49: iconst_1
    //   50: invokevirtual 635	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   53: astore 6
    //   55: aload 6
    //   57: iconst_1
    //   58: invokevirtual 639	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   61: new 612	java/io/ByteArrayOutputStream
    //   64: dup
    //   65: invokespecial 613	java/io/ByteArrayOutputStream:<init>	()V
    //   68: astore 5
    //   70: aload 5
    //   72: astore 4
    //   74: aload_0
    //   75: astore_3
    //   76: aload 6
    //   78: getstatic 645	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   81: bipush 100
    //   83: aload 5
    //   85: invokevirtual 649	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   88: pop
    //   89: aload 5
    //   91: astore 4
    //   93: aload_0
    //   94: astore_3
    //   95: new 619	java/io/ByteArrayInputStream
    //   98: dup
    //   99: aload 5
    //   101: invokevirtual 623	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   104: invokespecial 625	java/io/ByteArrayInputStream:<init>	([B)V
    //   107: astore 6
    //   109: aload 5
    //   111: ifnull +8 -> 119
    //   114: aload 5
    //   116: invokevirtual 617	java/io/ByteArrayOutputStream:close	()V
    //   119: iconst_0
    //   120: ifeq +11 -> 131
    //   123: new 651	java/lang/NullPointerException
    //   126: dup
    //   127: invokespecial 652	java/lang/NullPointerException:<init>	()V
    //   130: athrow
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 607	java/io/FileInputStream:close	()V
    //   139: aload 6
    //   141: areturn
    //   142: aload_3
    //   143: ifnonnull +40 -> 183
    //   146: iconst_0
    //   147: istore_1
    //   148: iload_1
    //   149: iload_2
    //   150: iadd
    //   151: newarray byte
    //   153: astore 4
    //   155: aload_3
    //   156: ifnull +33 -> 189
    //   159: aload_3
    //   160: iconst_0
    //   161: aload 4
    //   163: iconst_0
    //   164: aload_3
    //   165: arraylength
    //   166: invokestatic 656	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   169: aload 5
    //   171: iconst_0
    //   172: aload 4
    //   174: aload_3
    //   175: arraylength
    //   176: iload_2
    //   177: invokestatic 656	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   180: goto +321 -> 501
    //   183: aload_3
    //   184: arraylength
    //   185: istore_1
    //   186: goto -38 -> 148
    //   189: aload 5
    //   191: iconst_0
    //   192: aload 4
    //   194: iconst_0
    //   195: iload_2
    //   196: invokestatic 656	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   199: goto +302 -> 501
    //   202: astore 6
    //   204: aconst_null
    //   205: astore 5
    //   207: aload 5
    //   209: astore 4
    //   211: aload_0
    //   212: astore_3
    //   213: aload 6
    //   215: invokevirtual 616	java/io/FileNotFoundException:printStackTrace	()V
    //   218: aload 5
    //   220: ifnull +8 -> 228
    //   223: aload 5
    //   225: invokevirtual 617	java/io/ByteArrayOutputStream:close	()V
    //   228: iconst_0
    //   229: ifeq +11 -> 240
    //   232: new 651	java/lang/NullPointerException
    //   235: dup
    //   236: invokespecial 652	java/lang/NullPointerException:<init>	()V
    //   239: athrow
    //   240: aload_0
    //   241: ifnull +7 -> 248
    //   244: aload_0
    //   245: invokevirtual 607	java/io/FileInputStream:close	()V
    //   248: aconst_null
    //   249: areturn
    //   250: astore_0
    //   251: aload_0
    //   252: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   255: aload 6
    //   257: areturn
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   263: goto -15 -> 248
    //   266: astore_0
    //   267: aconst_null
    //   268: astore 5
    //   270: aconst_null
    //   271: astore_0
    //   272: aload 5
    //   274: astore 4
    //   276: aload_0
    //   277: astore_3
    //   278: invokestatic 659	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +19 -> 300
    //   284: aload 5
    //   286: astore 4
    //   288: aload_0
    //   289: astore_3
    //   290: ldc_w 661
    //   293: iconst_2
    //   294: ldc_w 663
    //   297: invokestatic 667	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload 5
    //   302: ifnull +8 -> 310
    //   305: aload 5
    //   307: invokevirtual 617	java/io/ByteArrayOutputStream:close	()V
    //   310: iconst_0
    //   311: ifeq +11 -> 322
    //   314: new 651	java/lang/NullPointerException
    //   317: dup
    //   318: invokespecial 652	java/lang/NullPointerException:<init>	()V
    //   321: athrow
    //   322: aload_0
    //   323: ifnull +7 -> 330
    //   326: aload_0
    //   327: invokevirtual 607	java/io/FileInputStream:close	()V
    //   330: aconst_null
    //   331: areturn
    //   332: astore_0
    //   333: aload_0
    //   334: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   337: goto -7 -> 330
    //   340: astore 6
    //   342: aconst_null
    //   343: astore 5
    //   345: aconst_null
    //   346: astore_0
    //   347: aload 5
    //   349: astore 4
    //   351: aload_0
    //   352: astore_3
    //   353: aload 6
    //   355: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   358: aload 5
    //   360: ifnull +8 -> 368
    //   363: aload 5
    //   365: invokevirtual 617	java/io/ByteArrayOutputStream:close	()V
    //   368: iconst_0
    //   369: ifeq +11 -> 380
    //   372: new 651	java/lang/NullPointerException
    //   375: dup
    //   376: invokespecial 652	java/lang/NullPointerException:<init>	()V
    //   379: athrow
    //   380: aload_0
    //   381: ifnull -133 -> 248
    //   384: aload_0
    //   385: invokevirtual 607	java/io/FileInputStream:close	()V
    //   388: goto -140 -> 248
    //   391: astore_0
    //   392: aload_0
    //   393: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   396: goto -148 -> 248
    //   399: astore 5
    //   401: aconst_null
    //   402: astore 4
    //   404: aconst_null
    //   405: astore_0
    //   406: aload 4
    //   408: ifnull +8 -> 416
    //   411: aload 4
    //   413: invokevirtual 617	java/io/ByteArrayOutputStream:close	()V
    //   416: iconst_0
    //   417: ifeq +11 -> 428
    //   420: new 651	java/lang/NullPointerException
    //   423: dup
    //   424: invokespecial 652	java/lang/NullPointerException:<init>	()V
    //   427: athrow
    //   428: aload_0
    //   429: ifnull +7 -> 436
    //   432: aload_0
    //   433: invokevirtual 607	java/io/FileInputStream:close	()V
    //   436: aload 5
    //   438: athrow
    //   439: astore_0
    //   440: aload_0
    //   441: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   444: goto -8 -> 436
    //   447: astore 5
    //   449: aconst_null
    //   450: astore 4
    //   452: goto -46 -> 406
    //   455: astore 5
    //   457: aload_3
    //   458: astore_0
    //   459: goto -53 -> 406
    //   462: astore 6
    //   464: aconst_null
    //   465: astore 5
    //   467: goto -120 -> 347
    //   470: astore 6
    //   472: goto -125 -> 347
    //   475: astore_3
    //   476: aconst_null
    //   477: astore 5
    //   479: goto -207 -> 272
    //   482: astore_3
    //   483: goto -211 -> 272
    //   486: astore 6
    //   488: aconst_null
    //   489: astore 5
    //   491: aconst_null
    //   492: astore_0
    //   493: goto -286 -> 207
    //   496: astore 6
    //   498: goto -291 -> 207
    //   501: aload 4
    //   503: astore_3
    //   504: goto -477 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	paramString	String
    //   147	39	1	i	int
    //   33	163	2	j	int
    //   26	432	3	localObject1	Object
    //   475	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   482	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   503	1	3	localObject2	Object
    //   72	430	4	localObject3	Object
    //   23	341	5	localObject4	Object
    //   399	38	5	localObject5	Object
    //   447	1	5	localObject6	Object
    //   455	1	5	localObject7	Object
    //   465	25	5	localObject8	Object
    //   53	87	6	localObject9	Object
    //   202	54	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   340	14	6	localIOException1	IOException
    //   462	1	6	localIOException2	IOException
    //   470	1	6	localIOException3	IOException
    //   486	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   496	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   18	25	202	java/io/FileNotFoundException
    //   27	34	202	java/io/FileNotFoundException
    //   39	70	202	java/io/FileNotFoundException
    //   148	155	202	java/io/FileNotFoundException
    //   159	180	202	java/io/FileNotFoundException
    //   183	186	202	java/io/FileNotFoundException
    //   189	199	202	java/io/FileNotFoundException
    //   114	119	250	java/io/IOException
    //   123	131	250	java/io/IOException
    //   135	139	250	java/io/IOException
    //   223	228	258	java/io/IOException
    //   232	240	258	java/io/IOException
    //   244	248	258	java/io/IOException
    //   9	18	266	java/lang/OutOfMemoryError
    //   305	310	332	java/io/IOException
    //   314	322	332	java/io/IOException
    //   326	330	332	java/io/IOException
    //   9	18	340	java/io/IOException
    //   363	368	391	java/io/IOException
    //   372	380	391	java/io/IOException
    //   384	388	391	java/io/IOException
    //   9	18	399	finally
    //   411	416	439	java/io/IOException
    //   420	428	439	java/io/IOException
    //   432	436	439	java/io/IOException
    //   18	25	447	finally
    //   27	34	447	finally
    //   39	70	447	finally
    //   148	155	447	finally
    //   159	180	447	finally
    //   183	186	447	finally
    //   189	199	447	finally
    //   76	89	455	finally
    //   95	109	455	finally
    //   213	218	455	finally
    //   278	284	455	finally
    //   290	300	455	finally
    //   353	358	455	finally
    //   18	25	462	java/io/IOException
    //   27	34	462	java/io/IOException
    //   39	70	462	java/io/IOException
    //   148	155	462	java/io/IOException
    //   159	180	462	java/io/IOException
    //   183	186	462	java/io/IOException
    //   189	199	462	java/io/IOException
    //   76	89	470	java/io/IOException
    //   95	109	470	java/io/IOException
    //   18	25	475	java/lang/OutOfMemoryError
    //   27	34	475	java/lang/OutOfMemoryError
    //   39	70	475	java/lang/OutOfMemoryError
    //   148	155	475	java/lang/OutOfMemoryError
    //   159	180	475	java/lang/OutOfMemoryError
    //   183	186	475	java/lang/OutOfMemoryError
    //   189	199	475	java/lang/OutOfMemoryError
    //   76	89	482	java/lang/OutOfMemoryError
    //   95	109	482	java/lang/OutOfMemoryError
    //   9	18	486	java/io/FileNotFoundException
    //   76	89	496	java/io/FileNotFoundException
    //   95	109	496	java/io/FileNotFoundException
  }
  
  static final class a
  {
    String a;
    int b;
    int c;
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      this.a = paramString;
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    public String toString()
    {
      return "WxapkgFile{name='" + this.a + '\'' + ", start=" + this.b + ", length=" + this.c + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.c
 * JD-Core Version:    0.7.0.1
 */