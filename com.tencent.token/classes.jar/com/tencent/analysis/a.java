package com.tencent.analysis;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.analysis.d.a.d;
import javax.microedition.khronos.opengles.GL10;

public class a
{
  public static Context a;
  private static a b;
  private volatile boolean c = false;
  
  public static a a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new a();
        }
      }
      finally {}
    }
    return b;
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +6 -> 7
    //   4: ldc 28
    //   6: areturn
    //   7: aconst_null
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 5
    //   13: aload_0
    //   14: invokevirtual 34	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: astore 8
    //   19: aload 5
    //   21: astore_3
    //   22: aload 6
    //   24: astore_2
    //   25: aload_0
    //   26: ldc 36
    //   28: iconst_0
    //   29: invokevirtual 40	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   32: ldc 42
    //   34: ldc 44
    //   36: invokeinterface 50 3 0
    //   41: astore 7
    //   43: aload 7
    //   45: astore 4
    //   47: aload 5
    //   49: astore_3
    //   50: aload 6
    //   52: astore_2
    //   53: aload 7
    //   55: ldc 44
    //   57: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +7 -> 67
    //   63: ldc 58
    //   65: astore 4
    //   67: aload 4
    //   69: ifnull +81 -> 150
    //   72: aload 5
    //   74: astore_3
    //   75: aload 6
    //   77: astore_2
    //   78: aload 8
    //   80: aload 4
    //   82: invokevirtual 64	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   85: astore 4
    //   87: aload 4
    //   89: astore_3
    //   90: aload 4
    //   92: astore_2
    //   93: new 66	java/util/Properties
    //   96: dup
    //   97: invokespecial 67	java/util/Properties:<init>	()V
    //   100: astore 5
    //   102: aload 4
    //   104: astore_3
    //   105: aload 4
    //   107: astore_2
    //   108: aload 5
    //   110: aload 4
    //   112: invokevirtual 71	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   115: aload 4
    //   117: astore_3
    //   118: aload 4
    //   120: astore_2
    //   121: aload 5
    //   123: ldc 73
    //   125: ldc 28
    //   127: invokevirtual 76	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 5
    //   132: aload 5
    //   134: astore_0
    //   135: aload 4
    //   137: ifnull +80 -> 217
    //   140: aload 4
    //   142: astore_2
    //   143: aload 5
    //   145: astore 4
    //   147: goto +56 -> 203
    //   150: ldc 28
    //   152: areturn
    //   153: astore_0
    //   154: goto +65 -> 219
    //   157: aload_2
    //   158: astore_3
    //   159: aload_0
    //   160: ldc 36
    //   162: iconst_0
    //   163: invokevirtual 40	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   166: invokeinterface 80 1 0
    //   171: ldc 42
    //   173: ldc 44
    //   175: invokeinterface 86 3 0
    //   180: invokeinterface 90 1 0
    //   185: pop
    //   186: ldc 28
    //   188: astore 4
    //   190: aload_2
    //   191: astore_3
    //   192: getstatic 93	com/tencent/analysis/b:c	Z
    //   195: istore_1
    //   196: aload 4
    //   198: astore_0
    //   199: aload_2
    //   200: ifnull +17 -> 217
    //   203: aload_2
    //   204: invokevirtual 98	java/io/InputStream:close	()V
    //   207: aload 4
    //   209: areturn
    //   210: ldc 28
    //   212: astore_0
    //   213: getstatic 93	com/tencent/analysis/b:c	Z
    //   216: istore_1
    //   217: aload_0
    //   218: areturn
    //   219: aload_3
    //   220: ifnull +14 -> 234
    //   223: aload_3
    //   224: invokevirtual 98	java/io/InputStream:close	()V
    //   227: goto +7 -> 234
    //   230: getstatic 93	com/tencent/analysis/b:c	Z
    //   233: istore_1
    //   234: aload_0
    //   235: athrow
    //   236: astore_3
    //   237: goto -80 -> 157
    //   240: astore_0
    //   241: goto -31 -> 210
    //   244: astore_2
    //   245: goto -15 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramContext	Context
    //   195	39	1	bool	boolean
    //   24	180	2	localObject1	Object
    //   244	1	2	localIOException	java.io.IOException
    //   21	203	3	localObject2	Object
    //   236	1	3	localException	Exception
    //   45	163	4	localObject3	Object
    //   11	133	5	localObject4	Object
    //   8	68	6	localObject5	Object
    //   41	13	7	str	String
    //   17	62	8	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   25	43	153	finally
    //   53	63	153	finally
    //   78	87	153	finally
    //   93	102	153	finally
    //   108	115	153	finally
    //   121	132	153	finally
    //   159	186	153	finally
    //   192	196	153	finally
    //   25	43	236	java/lang/Exception
    //   53	63	236	java/lang/Exception
    //   78	87	236	java/lang/Exception
    //   93	102	236	java/lang/Exception
    //   108	115	236	java/lang/Exception
    //   121	132	236	java/lang/Exception
    //   203	207	240	java/io/IOException
    //   223	227	244	java/io/IOException
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getString(PrismCenter.INIT_CHANNEL_PATH);
    if ((paramBundle != null) && (!paramBundle.equals(""))) {
      paramContext.getSharedPreferences("analysis_sdk", 0).edit().putString("key_channelpath", paramBundle).commit();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("#");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      try
      {
        paramString1 = com.tencent.analysis.d.a.c.b().b.c(paramString1.getBytes());
        paramContext.getSharedPreferences("analysis_sdk", 0).edit().putString("key_user", paramString1).commit();
        return;
      }
      catch (Exception paramContext)
      {
        new StringBuilder("setUserId error").append(paramContext.toString());
        boolean bool = b.c;
      }
    }
  }
  
  public static void a(Context paramContext, GL10 paramGL10)
  {
    if (paramGL10 == null) {
      return;
    }
    String str = paramGL10.glGetString(7937);
    paramGL10.glGetString(7936);
    paramGL10.glGetString(7938);
    paramGL10.glGetString(7939);
    try
    {
      paramGL10 = com.tencent.analysis.d.a.c.b().b.c(str.getBytes());
      paramContext.getSharedPreferences("analysis_sdk", 0).edit().putString("gpu_user", paramGL10).commit();
      return;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("setUserId error").append(paramContext.toString());
      boolean bool = b.c;
    }
  }
  
  public static void b()
  {
    b.b = System.currentTimeMillis();
    new StringBuilder("onPause SdkConfig.timeStemp is ").append(b.b);
    boolean bool = b.c;
  }
  
  public final String b(Context paramContext)
  {
    if (this.c)
    {
      if (paramContext == null) {
        return "UNKNOWN";
      }
      try
      {
        paramContext = paramContext.getSharedPreferences("analysis_sdk", 0).getString("key_qimei", "UNKNOWN");
        if (paramContext.equals("UNKNOWN")) {
          return "UNKNOWN";
        }
        paramContext = new String(com.tencent.analysis.d.a.c.b().b.a(com.tencent.analysis.d.a.b.a(paramContext)), "UTF-8");
        return paramContext;
      }
      catch (Exception paramContext)
      {
        new StringBuilder("getQimei Error :").append(paramContext.toString());
        boolean bool = b.c;
        return "UNKNOWN";
      }
    }
    throw new IllegalStateException("Function onResume() must be called before function getQimei() ");
  }
  
  public final void c(Context paramContext)
  {
    this.c = true;
    if (paramContext != null) {
      a = paramContext.getApplicationContext();
    }
    new StringBuilder("onResume currentTimeMillis is ").append(System.currentTimeMillis());
    boolean bool = b.c;
    new StringBuilder("onResume SdkConfig.timeStemp is ").append(b.b);
    bool = b.c;
    new StringBuilder("onResume time space  is ").append(System.currentTimeMillis() - b.b);
    bool = b.c;
    Object localObject;
    if (System.currentTimeMillis() - b.b > b.a)
    {
      bool = b.c;
      localObject = new com.tencent.analysis.c.b.a();
      com.tencent.analysis.c.a.a.a().a((com.tencent.analysis.c.a.c)localObject);
      if ((paramContext == null) || (!paramContext.getSharedPreferences("analysis_sdk", 0).getString("key_resolution", "").equals(""))) {}
    }
    try
    {
      localObject = new DisplayMetrics();
      ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((DisplayMetrics)localObject).widthPixels);
      localStringBuilder.append("*");
      localStringBuilder.append(((DisplayMetrics)localObject).heightPixels);
      localObject = localStringBuilder.toString();
      paramContext.getSharedPreferences("analysis_sdk", 0).edit().putString("key_resolution", (String)localObject).commit();
      return;
    }
    catch (Exception paramContext)
    {
      label236:
      break label236;
    }
    bool = b.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a
 * JD-Core Version:    0.7.0.1
 */