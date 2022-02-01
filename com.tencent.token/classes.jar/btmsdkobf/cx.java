package btmsdkobf;

import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tmsdk.base.utils.NetworkUtil;
import tmsdk.QQPIM.ConnectType;

public class cx
{
  private static cl he;
  public static boolean iS = false;
  public static boolean iT = false;
  private static Looper iU;
  private static Looper iV;
  private static boolean iW = false;
  private static String iX;
  private static boolean iY = false;
  private static boolean iZ = false;
  private static boolean ja = false;
  private static boolean jb = false;
  private static dc jc;
  
  public static void A(String paramString)
  {
    iX = paramString;
  }
  
  public static void a(dc paramdc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[shark_init]initSharkQueueInstance(), sharkQueue: ");
    localStringBuilder.append(paramdc);
    eh.e("SharkHelper", localStringBuilder.toString());
    jc = paramdc;
  }
  
  public static boolean ax()
  {
    return iY;
  }
  
  public static boolean ay()
  {
    return iZ;
  }
  
  public static boolean az()
  {
    return ja;
  }
  
  public static boolean bB()
  {
    return iW;
  }
  
  public static String bC()
  {
    return iX;
  }
  
  public static boolean bD()
  {
    return jb;
  }
  
  public static dc bE()
  {
    if (jc == null) {
      try
      {
        if (jc == null) {
          jc = new dd(bF());
        }
      }
      finally {}
    }
    return jc;
  }
  
  private static long bF()
  {
    return bu.a(3, 4294967296L);
  }
  
  public static Looper getLooper()
  {
    if (iU == null) {
      try
      {
        if (iU == null)
        {
          HandlerThread localHandlerThread = ee.cT().L("Shark-Looper");
          localHandlerThread.start();
          iU = localHandlerThread.getLooper();
        }
      }
      finally {}
    }
    return iU;
  }
  
  public static boolean i(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length == 1);
  }
  
  public static void r(boolean paramBoolean)
  {
    iW = paramBoolean;
  }
  
  public static void s(boolean paramBoolean)
  {
    iY = paramBoolean;
  }
  
  public static void t(boolean paramBoolean)
  {
    iZ = paramBoolean;
  }
  
  public static void u(boolean paramBoolean)
  {
    ja = paramBoolean;
  }
  
  public static void v(boolean paramBoolean)
  {
    jb = paramBoolean;
  }
  
  public static boolean y(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 152)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean y(String paramString)
  {
    if (ConnectType.CT_WIFI != NetworkUtil.getNetworkType()) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[detect_conn]needWifiApprove(), from: ");
    ((StringBuilder)localObject).append(paramString);
    eh.f("SharkHelper", ((StringBuilder)localObject).toString());
    paramString = null;
    try
    {
      localObject = ef.a(new ef.a()
      {
        public void c(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[detect_conn]needWifiApprove() callback,  need: ");
          localStringBuilder.append(paramAnonymousBoolean1);
          localStringBuilder.append(" receivedError: ");
          localStringBuilder.append(paramAnonymousBoolean2);
          eh.f("SharkHelper", localStringBuilder.toString());
        }
      });
      paramString = (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[detect_conn]needWifiApprove(), exception: ");
      localStringBuilder2.append(localThrowable.toString());
      eh.h("SharkHelper", localStringBuilder2.toString());
    }
    boolean bool = TextUtils.isEmpty(paramString) ^ true;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[detect_conn]needWifiApprove(),  need approve: ");
    localStringBuilder1.append(bool);
    localStringBuilder1.append(" approve url: ");
    localStringBuilder1.append(paramString);
    eh.f("SharkHelper", localStringBuilder1.toString());
    return bool;
  }
  
  public static boolean z(int paramInt)
  {
    return (paramInt == 997) || (paramInt == 999);
  }
  
  /* Error */
  public static boolean z(String paramString)
  {
    // Byte code:
    //   0: new 38	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 180
    //   13: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 7
    //   19: ldc 182
    //   21: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 7
    //   27: ldc 184
    //   29: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 7
    //   35: aload_0
    //   36: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 50
    //   42: aload 7
    //   44: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 150	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   53: lstore_1
    //   54: iconst_0
    //   55: istore 6
    //   57: iconst_0
    //   58: istore 5
    //   60: aconst_null
    //   61: astore 8
    //   63: aconst_null
    //   64: astore 9
    //   66: aconst_null
    //   67: astore 7
    //   69: aload 7
    //   71: astore_0
    //   72: new 191	java/net/InetSocketAddress
    //   75: dup
    //   76: ldc 182
    //   78: invokestatic 197	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   81: bipush 80
    //   83: invokespecial 200	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
    //   86: astore 10
    //   88: aload 7
    //   90: astore_0
    //   91: new 202	java/net/Socket
    //   94: dup
    //   95: invokespecial 203	java/net/Socket:<init>	()V
    //   98: astore 7
    //   100: aload 7
    //   102: iconst_0
    //   103: iconst_0
    //   104: invokevirtual 207	java/net/Socket:setSoLinger	(ZI)V
    //   107: aload 7
    //   109: aload 10
    //   111: sipush 5000
    //   114: invokevirtual 211	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   117: iconst_1
    //   118: istore 6
    //   120: iconst_1
    //   121: istore 5
    //   123: iload 5
    //   125: istore_3
    //   126: iload 6
    //   128: istore 4
    //   130: aload 7
    //   132: invokevirtual 214	java/net/Socket:isConnected	()Z
    //   135: ifeq +249 -> 384
    //   138: iload 5
    //   140: istore_3
    //   141: aload 7
    //   143: invokevirtual 217	java/net/Socket:close	()V
    //   146: iload 6
    //   148: istore 4
    //   150: goto +234 -> 384
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 220	java/lang/Throwable:printStackTrace	()V
    //   158: iload_3
    //   159: istore 4
    //   161: goto +223 -> 384
    //   164: astore 8
    //   166: aload 7
    //   168: astore_0
    //   169: aload 8
    //   171: astore 7
    //   173: goto +262 -> 435
    //   176: astore 8
    //   178: goto +21 -> 199
    //   181: astore 8
    //   183: goto +113 -> 296
    //   186: astore 7
    //   188: goto +247 -> 435
    //   191: astore_0
    //   192: aload 8
    //   194: astore 7
    //   196: aload_0
    //   197: astore 8
    //   199: aload 7
    //   201: astore_0
    //   202: new 38	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   209: astore 9
    //   211: aload 7
    //   213: astore_0
    //   214: aload 9
    //   216: ldc 222
    //   218: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 7
    //   224: astore_0
    //   225: aload 9
    //   227: aload 8
    //   229: invokevirtual 225	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   232: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 7
    //   238: astore_0
    //   239: ldc 50
    //   241: aload 9
    //   243: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: aload 8
    //   248: invokestatic 229	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   251: iload 6
    //   253: istore 4
    //   255: aload 7
    //   257: ifnull +127 -> 384
    //   260: iload 5
    //   262: istore_3
    //   263: iload 6
    //   265: istore 4
    //   267: aload 7
    //   269: invokevirtual 214	java/net/Socket:isConnected	()Z
    //   272: ifeq +112 -> 384
    //   275: iload 5
    //   277: istore_3
    //   278: aload 7
    //   280: invokevirtual 217	java/net/Socket:close	()V
    //   283: iload 6
    //   285: istore 4
    //   287: goto +97 -> 384
    //   290: astore 8
    //   292: aload 9
    //   294: astore 7
    //   296: aload 7
    //   298: astore_0
    //   299: new 38	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   306: astore 9
    //   308: aload 7
    //   310: astore_0
    //   311: aload 9
    //   313: ldc 231
    //   315: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 7
    //   321: astore_0
    //   322: aload 9
    //   324: aload 8
    //   326: invokevirtual 232	java/io/IOException:getMessage	()Ljava/lang/String;
    //   329: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 7
    //   335: astore_0
    //   336: ldc 50
    //   338: aload 9
    //   340: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: aload 8
    //   345: invokestatic 229	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   348: iload 6
    //   350: istore 4
    //   352: aload 7
    //   354: ifnull +30 -> 384
    //   357: iload 5
    //   359: istore_3
    //   360: iload 6
    //   362: istore 4
    //   364: aload 7
    //   366: invokevirtual 214	java/net/Socket:isConnected	()Z
    //   369: ifeq +15 -> 384
    //   372: iload 5
    //   374: istore_3
    //   375: aload 7
    //   377: invokevirtual 217	java/net/Socket:close	()V
    //   380: iload 6
    //   382: istore 4
    //   384: new 38	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   391: astore_0
    //   392: aload_0
    //   393: ldc 234
    //   395: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_0
    //   400: iload 4
    //   402: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_0
    //   407: ldc 236
    //   409: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload_0
    //   414: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   417: lload_1
    //   418: lsub
    //   419: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: ldc 50
    //   425: aload_0
    //   426: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 150	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: iload 4
    //   434: ireturn
    //   435: aload_0
    //   436: ifnull +22 -> 458
    //   439: aload_0
    //   440: invokevirtual 214	java/net/Socket:isConnected	()Z
    //   443: ifeq +15 -> 458
    //   446: aload_0
    //   447: invokevirtual 217	java/net/Socket:close	()V
    //   450: goto +8 -> 458
    //   453: astore_0
    //   454: aload_0
    //   455: invokevirtual 220	java/lang/Throwable:printStackTrace	()V
    //   458: aload 7
    //   460: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	paramString	String
    //   53	365	1	l	long
    //   125	250	3	bool1	boolean
    //   128	305	4	bool2	boolean
    //   58	315	5	bool3	boolean
    //   55	326	6	bool4	boolean
    //   7	165	7	localObject1	Object
    //   186	1	7	localObject2	Object
    //   194	265	7	localObject3	Object
    //   61	1	8	localObject4	Object
    //   164	6	8	localObject5	Object
    //   176	1	8	localThrowable	Throwable
    //   181	12	8	localIOException1	java.io.IOException
    //   197	50	8	str	String
    //   290	54	8	localIOException2	java.io.IOException
    //   64	275	9	localStringBuilder	StringBuilder
    //   86	24	10	localInetSocketAddress	java.net.InetSocketAddress
    // Exception table:
    //   from	to	target	type
    //   130	138	153	java/lang/Throwable
    //   141	146	153	java/lang/Throwable
    //   267	275	153	java/lang/Throwable
    //   278	283	153	java/lang/Throwable
    //   364	372	153	java/lang/Throwable
    //   375	380	153	java/lang/Throwable
    //   100	117	164	finally
    //   100	117	176	java/lang/Throwable
    //   100	117	181	java/io/IOException
    //   72	88	186	finally
    //   91	100	186	finally
    //   202	211	186	finally
    //   214	222	186	finally
    //   225	236	186	finally
    //   239	251	186	finally
    //   299	308	186	finally
    //   311	319	186	finally
    //   322	333	186	finally
    //   336	348	186	finally
    //   72	88	191	java/lang/Throwable
    //   91	100	191	java/lang/Throwable
    //   72	88	290	java/io/IOException
    //   91	100	290	java/io/IOException
    //   439	450	453	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cx
 * JD-Core Version:    0.7.0.1
 */