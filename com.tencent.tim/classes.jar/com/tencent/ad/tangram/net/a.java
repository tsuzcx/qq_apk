package com.tencent.ad.tangram.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class a
{
  private static final String TAG = "AdNet";
  
  /* Error */
  public static int getType(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual 23	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   10: astore 7
    //   12: aload 7
    //   14: ifnonnull +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: new 25	java/lang/Integer
    //   22: dup
    //   23: iconst_1
    //   24: invokespecial 28	java/lang/Integer:<init>	(I)V
    //   27: astore_2
    //   28: new 25	java/lang/Integer
    //   31: dup
    //   32: iconst_2
    //   33: invokespecial 28	java/lang/Integer:<init>	(I)V
    //   36: astore 4
    //   38: new 25	java/lang/Integer
    //   41: dup
    //   42: iconst_3
    //   43: invokespecial 28	java/lang/Integer:<init>	(I)V
    //   46: astore 5
    //   48: aload 4
    //   50: astore_0
    //   51: ldc 30
    //   53: ldc 32
    //   55: invokevirtual 38	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   58: ldc 30
    //   60: invokevirtual 44	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: astore_3
    //   64: aload 4
    //   66: astore_0
    //   67: aload_3
    //   68: astore_2
    //   69: ldc 30
    //   71: ldc 46
    //   73: invokevirtual 38	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   76: ldc 30
    //   78: invokevirtual 44	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore 4
    //   83: aload 4
    //   85: astore_0
    //   86: aload_3
    //   87: astore_2
    //   88: ldc 30
    //   90: ldc 48
    //   92: invokevirtual 38	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   95: ldc 30
    //   97: invokevirtual 44	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: astore 6
    //   102: aload 4
    //   104: astore_2
    //   105: aload 6
    //   107: astore_0
    //   108: aload 7
    //   110: ldc 50
    //   112: invokevirtual 54	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   115: checkcast 56	android/net/ConnectivityManager
    //   118: astore 4
    //   120: aload 4
    //   122: ifnonnull +24 -> 146
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_3
    //   128: ldc 8
    //   130: ldc 57
    //   132: aload_3
    //   133: invokestatic 63	com/tencent/ad/tangram/log/AdLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_2
    //   137: astore_3
    //   138: aload_0
    //   139: astore_2
    //   140: aload 5
    //   142: astore_0
    //   143: goto -35 -> 108
    //   146: aload 4
    //   148: invokevirtual 67	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   151: astore 4
    //   153: aload 4
    //   155: ifnonnull +5 -> 160
    //   158: iconst_0
    //   159: ireturn
    //   160: aload 4
    //   162: invokevirtual 72	android/net/NetworkInfo:getType	()I
    //   165: tableswitch	default:+130 -> 295, 0:+43->208, 1:+132->297, 2:+43->208, 3:+43->208, 4:+43->208, 5:+43->208, 6:+132->297
    //   209: lload_0
    //   210: ldc 74
    //   212: iconst_1
    //   213: anewarray 34	java/lang/Class
    //   216: dup
    //   217: iconst_0
    //   218: getstatic 78	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   221: aastore
    //   222: invokevirtual 82	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   225: ldc 30
    //   227: iconst_1
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload 4
    //   235: invokevirtual 85	android/net/NetworkInfo:getSubtype	()I
    //   238: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: aastore
    //   242: invokevirtual 95	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   245: astore 4
    //   247: aload 4
    //   249: aload_3
    //   250: invokevirtual 99	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   253: ifeq +5 -> 258
    //   256: iconst_2
    //   257: ireturn
    //   258: aload 4
    //   260: aload_2
    //   261: invokevirtual 99	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   264: ifeq +5 -> 269
    //   267: iconst_3
    //   268: ireturn
    //   269: aload 4
    //   271: aload_0
    //   272: invokevirtual 99	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   275: istore_1
    //   276: iload_1
    //   277: ifeq +5 -> 282
    //   280: iconst_4
    //   281: ireturn
    //   282: iconst_0
    //   283: ireturn
    //   284: astore_0
    //   285: ldc 8
    //   287: ldc 57
    //   289: aload_0
    //   290: invokestatic 102	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   293: iconst_0
    //   294: ireturn
    //   295: iconst_0
    //   296: ireturn
    //   297: iconst_1
    //   298: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramContext	Context
    //   275	2	1	bool	boolean
    //   27	234	2	localObject1	Object
    //   63	24	3	localObject2	Object
    //   127	6	3	localThrowable	java.lang.Throwable
    //   137	113	3	localObject3	Object
    //   36	234	4	localObject4	Object
    //   46	95	5	localInteger	java.lang.Integer
    //   100	6	6	localObject5	Object
    //   10	99	7	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   51	64	127	java/lang/Throwable
    //   69	83	127	java/lang/Throwable
    //   88	102	127	java/lang/Throwable
    //   108	120	284	java/lang/Throwable
    //   146	153	284	java/lang/Throwable
    //   160	208	284	java/lang/Throwable
    //   208	256	284	java/lang/Throwable
    //   258	267	284	java/lang/Throwable
    //   269	276	284	java/lang/Throwable
  }
  
  public static boolean isNetValid(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    return getType(paramContext) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.net.a
 * JD-Core Version:    0.7.0.1
 */