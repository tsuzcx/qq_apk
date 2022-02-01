package btmsdkobf;

import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tmsdk.base.utils.NetworkUtil;
import tmsdk.QQPIM.ConnectType;

public class cx
{
  private static cl he = null;
  public static boolean iS = false;
  public static boolean iT = false;
  private static Looper iU = null;
  private static Looper iV = null;
  private static boolean iW = false;
  private static String iX = null;
  private static boolean iY = false;
  private static boolean iZ = false;
  private static boolean ja = false;
  private static boolean jb = false;
  private static dc jc = null;
  
  public static void A(String paramString)
  {
    iX = paramString;
  }
  
  public static void a(dc paramdc)
  {
    eh.e("SharkHelper", "[shark_init]initSharkQueueInstance(), sharkQueue: " + paramdc);
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
    if (jc == null) {}
    try
    {
      if (jc == null) {
        jc = new dd(bF());
      }
      return jc;
    }
    finally {}
  }
  
  private static long bF()
  {
    return bu.a(3, 4294967296L);
  }
  
  public static Looper getLooper()
  {
    if (iU == null) {}
    try
    {
      if (iU == null)
      {
        HandlerThread localHandlerThread = ee.cT().L("Shark-Looper");
        localHandlerThread.start();
        iU = localHandlerThread.getLooper();
      }
      return iU;
    }
    finally {}
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
    return (paramInt == 152) || (paramInt == 1);
  }
  
  public static boolean y(String paramString)
  {
    boolean bool = false;
    if (ConnectType.CT_WIFI != NetworkUtil.getNetworkType()) {
      return false;
    }
    eh.f("SharkHelper", "[detect_conn]needWifiApprove(), from: " + paramString);
    paramString = null;
    try
    {
      String str = ef.a(new ef.a()
      {
        public void c(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          eh.f("SharkHelper", "[detect_conn]needWifiApprove() callback,  need: " + paramAnonymousBoolean1 + " receivedError: " + paramAnonymousBoolean2);
        }
      });
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eh.h("SharkHelper", "[detect_conn]needWifiApprove(), exception: " + localThrowable.toString());
      }
    }
    if (!TextUtils.isEmpty(paramString)) {
      bool = true;
    }
    eh.f("SharkHelper", "[detect_conn]needWifiApprove(),  need approve: " + bool + " approve url: " + paramString);
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
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 59
    //   4: new 61	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   11: ldc 187
    //   13: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 189
    //   18: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 191
    //   23: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 157	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: invokestatic 196	java/lang/System:currentTimeMillis	()J
    //   39: lstore_3
    //   40: aconst_null
    //   41: astore_0
    //   42: aconst_null
    //   43: astore 6
    //   45: aload_0
    //   46: astore 5
    //   48: new 198	java/net/InetSocketAddress
    //   51: dup
    //   52: ldc 189
    //   54: invokestatic 204	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   57: bipush 80
    //   59: invokespecial 207	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
    //   62: astore 7
    //   64: aload_0
    //   65: astore 5
    //   67: new 209	java/net/Socket
    //   70: dup
    //   71: invokespecial 210	java/net/Socket:<init>	()V
    //   74: astore_0
    //   75: aload_0
    //   76: astore 5
    //   78: aload_0
    //   79: iconst_0
    //   80: iconst_0
    //   81: invokevirtual 214	java/net/Socket:setSoLinger	(ZI)V
    //   84: aload_0
    //   85: astore 5
    //   87: aload_0
    //   88: aload 7
    //   90: sipush 5000
    //   93: invokevirtual 218	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   96: iconst_1
    //   97: istore_2
    //   98: iload_2
    //   99: istore_1
    //   100: aload_0
    //   101: ifnull +18 -> 119
    //   104: iload_2
    //   105: istore_1
    //   106: aload_0
    //   107: invokevirtual 221	java/net/Socket:isConnected	()Z
    //   110: ifeq +9 -> 119
    //   113: aload_0
    //   114: invokevirtual 224	java/net/Socket:close	()V
    //   117: iload_2
    //   118: istore_1
    //   119: ldc 59
    //   121: new 61	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   128: ldc 226
    //   130: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: iload_1
    //   134: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   137: ldc 228
    //   139: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokestatic 196	java/lang/System:currentTimeMillis	()J
    //   145: lload_3
    //   146: lsub
    //   147: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 157	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: iload_1
    //   157: ireturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 234	java/lang/Throwable:printStackTrace	()V
    //   163: iload_2
    //   164: istore_1
    //   165: goto -46 -> 119
    //   168: astore 6
    //   170: aconst_null
    //   171: astore_0
    //   172: aload_0
    //   173: astore 5
    //   175: ldc 59
    //   177: new 61	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   184: ldc 236
    //   186: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload 6
    //   191: invokevirtual 239	java/io/IOException:getMessage	()Ljava/lang/String;
    //   194: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: aload 6
    //   202: invokestatic 243	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: iload_2
    //   206: istore_1
    //   207: aload_0
    //   208: ifnull -89 -> 119
    //   211: iload_2
    //   212: istore_1
    //   213: aload_0
    //   214: invokevirtual 221	java/net/Socket:isConnected	()Z
    //   217: ifeq -98 -> 119
    //   220: aload_0
    //   221: invokevirtual 224	java/net/Socket:close	()V
    //   224: iload_2
    //   225: istore_1
    //   226: goto -107 -> 119
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 234	java/lang/Throwable:printStackTrace	()V
    //   234: iload_2
    //   235: istore_1
    //   236: goto -117 -> 119
    //   239: astore 5
    //   241: aload 6
    //   243: astore_0
    //   244: aload 5
    //   246: astore 6
    //   248: aload_0
    //   249: astore 5
    //   251: ldc 59
    //   253: new 61	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   260: ldc 245
    //   262: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 6
    //   267: invokevirtual 246	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   270: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: aload 6
    //   278: invokestatic 243	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   281: iload_2
    //   282: istore_1
    //   283: aload_0
    //   284: ifnull -165 -> 119
    //   287: iload_2
    //   288: istore_1
    //   289: aload_0
    //   290: invokevirtual 221	java/net/Socket:isConnected	()Z
    //   293: ifeq -174 -> 119
    //   296: aload_0
    //   297: invokevirtual 224	java/net/Socket:close	()V
    //   300: iload_2
    //   301: istore_1
    //   302: goto -183 -> 119
    //   305: astore_0
    //   306: aload_0
    //   307: invokevirtual 234	java/lang/Throwable:printStackTrace	()V
    //   310: iload_2
    //   311: istore_1
    //   312: goto -193 -> 119
    //   315: astore_0
    //   316: aload 5
    //   318: ifnull +16 -> 334
    //   321: aload 5
    //   323: invokevirtual 221	java/net/Socket:isConnected	()Z
    //   326: ifeq +8 -> 334
    //   329: aload 5
    //   331: invokevirtual 224	java/net/Socket:close	()V
    //   334: aload_0
    //   335: athrow
    //   336: astore 5
    //   338: aload 5
    //   340: invokevirtual 234	java/lang/Throwable:printStackTrace	()V
    //   343: goto -9 -> 334
    //   346: astore_0
    //   347: goto -31 -> 316
    //   350: astore 6
    //   352: goto -104 -> 248
    //   355: astore 6
    //   357: goto -185 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramString	String
    //   99	213	1	bool1	boolean
    //   1	310	2	bool2	boolean
    //   39	107	3	l	long
    //   46	128	5	str1	String
    //   239	6	5	localThrowable1	Throwable
    //   249	81	5	str2	String
    //   336	3	5	localThrowable2	Throwable
    //   43	1	6	localObject1	Object
    //   168	74	6	localIOException1	java.io.IOException
    //   246	31	6	localObject2	Object
    //   350	1	6	localThrowable3	Throwable
    //   355	1	6	localIOException2	java.io.IOException
    //   62	27	7	localInetSocketAddress	java.net.InetSocketAddress
    // Exception table:
    //   from	to	target	type
    //   106	117	158	java/lang/Throwable
    //   48	64	168	java/io/IOException
    //   67	75	168	java/io/IOException
    //   213	224	229	java/lang/Throwable
    //   48	64	239	java/lang/Throwable
    //   67	75	239	java/lang/Throwable
    //   289	300	305	java/lang/Throwable
    //   48	64	315	finally
    //   67	75	315	finally
    //   251	281	315	finally
    //   321	334	336	java/lang/Throwable
    //   78	84	346	finally
    //   87	96	346	finally
    //   175	205	346	finally
    //   78	84	350	java/lang/Throwable
    //   87	96	350	java/lang/Throwable
    //   78	84	355	java/io/IOException
    //   87	96	355	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cx
 * JD-Core Version:    0.7.0.1
 */