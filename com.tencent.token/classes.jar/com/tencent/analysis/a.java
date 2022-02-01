package com.tencent.analysis;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
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
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_0
    //   14: invokevirtual 34	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: astore 7
    //   19: aload 4
    //   21: astore_1
    //   22: aload 5
    //   24: astore_2
    //   25: aload_0
    //   26: ldc 36
    //   28: iconst_0
    //   29: invokevirtual 40	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   32: ldc 42
    //   34: ldc 44
    //   36: invokeinterface 50 3 0
    //   41: astore 6
    //   43: aload 6
    //   45: astore_3
    //   46: aload 4
    //   48: astore_1
    //   49: aload 5
    //   51: astore_2
    //   52: aload 6
    //   54: ldc 44
    //   56: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +6 -> 65
    //   62: ldc 58
    //   64: astore_3
    //   65: aload_3
    //   66: ifnull +83 -> 149
    //   69: aload 4
    //   71: astore_1
    //   72: aload 5
    //   74: astore_2
    //   75: aload 7
    //   77: aload_3
    //   78: invokevirtual 64	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   81: astore_3
    //   82: aload_3
    //   83: astore_1
    //   84: aload_3
    //   85: astore_2
    //   86: new 66	java/util/Properties
    //   89: dup
    //   90: invokespecial 67	java/util/Properties:<init>	()V
    //   93: astore 4
    //   95: aload_3
    //   96: astore_1
    //   97: aload_3
    //   98: astore_2
    //   99: aload 4
    //   101: aload_3
    //   102: invokevirtual 71	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   105: aload_3
    //   106: astore_1
    //   107: aload_3
    //   108: astore_2
    //   109: aload 4
    //   111: ldc 73
    //   113: ldc 28
    //   115: invokevirtual 76	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 4
    //   120: aload 4
    //   122: astore_0
    //   123: aload_3
    //   124: ifnull +122 -> 246
    //   127: aload_3
    //   128: invokevirtual 81	java/io/InputStream:close	()V
    //   131: aload 4
    //   133: areturn
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 85	java/io/IOException:toString	()Ljava/lang/String;
    //   139: astore_0
    //   140: getstatic 88	com/tencent/analysis/b:c	Z
    //   143: ifeq +100 -> 243
    //   146: goto +90 -> 236
    //   149: ldc 28
    //   151: areturn
    //   152: astore_0
    //   153: goto +95 -> 248
    //   156: astore_3
    //   157: aload_2
    //   158: astore_1
    //   159: aload_0
    //   160: ldc 36
    //   162: iconst_0
    //   163: invokevirtual 40	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   166: invokeinterface 92 1 0
    //   171: ldc 42
    //   173: ldc 44
    //   175: invokeinterface 98 3 0
    //   180: invokeinterface 102 1 0
    //   185: pop
    //   186: ldc 28
    //   188: astore_0
    //   189: aload_2
    //   190: astore_1
    //   191: aload_3
    //   192: invokevirtual 103	java/lang/Exception:toString	()Ljava/lang/String;
    //   195: astore_3
    //   196: aload_2
    //   197: astore_1
    //   198: getstatic 88	com/tencent/analysis/b:c	Z
    //   201: ifeq +12 -> 213
    //   204: aload_2
    //   205: astore_1
    //   206: ldc 105
    //   208: aload_3
    //   209: invokestatic 111	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   212: pop
    //   213: aload_2
    //   214: ifnull +32 -> 246
    //   217: aload_2
    //   218: invokevirtual 81	java/io/InputStream:close	()V
    //   221: ldc 28
    //   223: areturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 85	java/io/IOException:toString	()Ljava/lang/String;
    //   229: astore_0
    //   230: getstatic 88	com/tencent/analysis/b:c	Z
    //   233: ifeq +10 -> 243
    //   236: ldc 105
    //   238: aload_0
    //   239: invokestatic 111	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   242: pop
    //   243: ldc 28
    //   245: astore_0
    //   246: aload_0
    //   247: areturn
    //   248: aload_1
    //   249: ifnull +29 -> 278
    //   252: aload_1
    //   253: invokevirtual 81	java/io/InputStream:close	()V
    //   256: goto +22 -> 278
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 85	java/io/IOException:toString	()Ljava/lang/String;
    //   264: astore_1
    //   265: getstatic 88	com/tencent/analysis/b:c	Z
    //   268: ifeq +10 -> 278
    //   271: ldc 105
    //   273: aload_1
    //   274: invokestatic 111	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   277: pop
    //   278: aload_0
    //   279: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramContext	Context
    //   21	232	1	localObject1	Object
    //   259	2	1	localIOException	java.io.IOException
    //   264	10	1	str1	String
    //   24	194	2	localObject2	Object
    //   45	83	3	localObject3	Object
    //   156	36	3	localException	Exception
    //   195	14	3	str2	String
    //   11	121	4	localObject4	Object
    //   8	65	5	localObject5	Object
    //   41	12	6	str3	String
    //   17	59	7	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   127	131	134	java/io/IOException
    //   25	43	152	finally
    //   52	62	152	finally
    //   75	82	152	finally
    //   86	95	152	finally
    //   99	105	152	finally
    //   109	120	152	finally
    //   159	186	152	finally
    //   191	196	152	finally
    //   198	204	152	finally
    //   206	213	152	finally
    //   25	43	156	java/lang/Exception
    //   52	62	156	java/lang/Exception
    //   75	82	156	java/lang/Exception
    //   86	95	156	java/lang/Exception
    //   99	105	156	java/lang/Exception
    //   109	120	156	java/lang/Exception
    //   217	221	224	java/io/IOException
    //   252	256	259	java/io/IOException
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
        paramString1 = new StringBuilder("setUserId error");
        paramString1.append(paramContext.toString());
        paramContext = paramString1.toString();
        if (b.c) {
          Log.i("ApplicationManager", paramContext);
        }
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
      paramGL10 = new StringBuilder("setUserId error");
      paramGL10.append(paramContext.toString());
      paramContext = paramGL10.toString();
      if (b.c) {
        Log.i("ApplicationManager", paramContext);
      }
    }
  }
  
  public static void b()
  {
    b.b = System.currentTimeMillis();
    Object localObject = new StringBuilder("onPause SdkConfig.timeStemp is ");
    ((StringBuilder)localObject).append(b.b);
    localObject = ((StringBuilder)localObject).toString();
    if (b.c) {
      Log.i("ApplicationManager", (String)localObject);
    }
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
        StringBuilder localStringBuilder = new StringBuilder("getQimei Error :");
        localStringBuilder.append(paramContext.toString());
        paramContext = localStringBuilder.toString();
        if (b.c) {
          Log.i("ApplicationManager", paramContext);
        }
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
    Object localObject = new StringBuilder("onResume currentTimeMillis is ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    if (b.c) {
      Log.i("ApplicationManager", (String)localObject);
    }
    localObject = new StringBuilder("onResume SdkConfig.timeStemp is ");
    ((StringBuilder)localObject).append(b.b);
    localObject = ((StringBuilder)localObject).toString();
    if (b.c) {
      Log.i("ApplicationManager", (String)localObject);
    }
    localObject = new StringBuilder("onResume time space  is ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - b.b);
    localObject = ((StringBuilder)localObject).toString();
    if (b.c) {
      Log.i("ApplicationManager", (String)localObject);
    }
    if (System.currentTimeMillis() - b.b > b.a)
    {
      if (b.c) {
        Log.i("ApplicationManager", "startShakeHands ");
      }
      localObject = new com.tencent.analysis.c.b.a();
      com.tencent.analysis.c.a.a.a().a((com.tencent.analysis.c.a.c)localObject);
      if ((paramContext != null) && (paramContext.getSharedPreferences("analysis_sdk", 0).getString("key_resolution", "").equals(""))) {
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
          paramContext = paramContext.toString();
          if (b.c) {
            Log.i("ApplicationManager", paramContext);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a
 * JD-Core Version:    0.7.0.1
 */