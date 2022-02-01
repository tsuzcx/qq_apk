package btmsdkobf;

import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.token.aos;
import com.tmsdk.base.utils.NetworkUtil;

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
    eh.e("SharkHelper", "[shark_init]initSharkQueueInstance(), sharkQueue: ".concat(String.valueOf(paramdc)));
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
    if (paramInt != 152) {
      return paramInt == 1;
    }
    return true;
  }
  
  public static boolean y(String paramString)
  {
    if (aos.d != NetworkUtil.getNetworkType()) {
      return false;
    }
    eh.f("SharkHelper", "[detect_conn]needWifiApprove(), from: ".concat(String.valueOf(paramString)));
    paramString = null;
    try
    {
      String str = ef.a(new ef.a()
      {
        public final void c(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          StringBuilder localStringBuilder = new StringBuilder("[detect_conn]needWifiApprove() callback,  need: ");
          localStringBuilder.append(paramAnonymousBoolean1);
          localStringBuilder.append(" receivedError: ");
          localStringBuilder.append(paramAnonymousBoolean2);
          eh.f("SharkHelper", localStringBuilder.toString());
        }
      });
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder("[detect_conn]needWifiApprove(), exception: ");
      localStringBuilder2.append(localThrowable.toString());
      eh.h("SharkHelper", localStringBuilder2.toString());
    }
    boolean bool = TextUtils.isEmpty(paramString) ^ true;
    StringBuilder localStringBuilder1 = new StringBuilder("[detect_conn]needWifiApprove(),  need approve: ");
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
    //   0: new 155	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 188
    //   6: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore 7
    //   11: aload 7
    //   13: ldc 190
    //   15: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload 7
    //   21: ldc 192
    //   23: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 7
    //   29: aload_0
    //   30: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: ldc 38
    //   36: aload 7
    //   38: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 147	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   47: lstore_1
    //   48: iconst_0
    //   49: istore 6
    //   51: iconst_0
    //   52: istore 5
    //   54: aconst_null
    //   55: astore 8
    //   57: aconst_null
    //   58: astore 9
    //   60: aconst_null
    //   61: astore 7
    //   63: aload 7
    //   65: astore_0
    //   66: new 199	java/net/InetSocketAddress
    //   69: dup
    //   70: ldc 190
    //   72: invokestatic 205	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   75: bipush 80
    //   77: invokespecial 208	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
    //   80: astore 10
    //   82: aload 7
    //   84: astore_0
    //   85: new 210	java/net/Socket
    //   88: dup
    //   89: invokespecial 211	java/net/Socket:<init>	()V
    //   92: astore 7
    //   94: aload 7
    //   96: iconst_0
    //   97: iconst_0
    //   98: invokevirtual 215	java/net/Socket:setSoLinger	(ZI)V
    //   101: aload 7
    //   103: aload 10
    //   105: sipush 5000
    //   108: invokevirtual 219	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   111: iconst_1
    //   112: istore 6
    //   114: iconst_1
    //   115: istore 5
    //   117: iload 5
    //   119: istore_3
    //   120: iload 6
    //   122: istore 4
    //   124: aload 7
    //   126: invokevirtual 222	java/net/Socket:isConnected	()Z
    //   129: ifeq +231 -> 360
    //   132: iload 5
    //   134: istore_3
    //   135: aload 7
    //   137: invokevirtual 225	java/net/Socket:close	()V
    //   140: iload 6
    //   142: istore 4
    //   144: goto +216 -> 360
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 228	java/lang/Throwable:printStackTrace	()V
    //   152: iload_3
    //   153: istore 4
    //   155: goto +205 -> 360
    //   158: astore 8
    //   160: aload 7
    //   162: astore_0
    //   163: aload 8
    //   165: astore 7
    //   167: goto +239 -> 406
    //   170: astore 8
    //   172: goto +21 -> 193
    //   175: astore 8
    //   177: goto +104 -> 281
    //   180: astore 7
    //   182: goto +224 -> 406
    //   185: astore_0
    //   186: aload 8
    //   188: astore 7
    //   190: aload_0
    //   191: astore 8
    //   193: aload 7
    //   195: astore_0
    //   196: new 155	java/lang/StringBuilder
    //   199: dup
    //   200: ldc 230
    //   202: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: astore 9
    //   207: aload 7
    //   209: astore_0
    //   210: aload 9
    //   212: aload 8
    //   214: invokevirtual 233	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 7
    //   223: astore_0
    //   224: ldc 38
    //   226: aload 9
    //   228: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: aload 8
    //   233: invokestatic 237	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   236: iload 6
    //   238: istore 4
    //   240: aload 7
    //   242: ifnull +118 -> 360
    //   245: iload 5
    //   247: istore_3
    //   248: iload 6
    //   250: istore 4
    //   252: aload 7
    //   254: invokevirtual 222	java/net/Socket:isConnected	()Z
    //   257: ifeq +103 -> 360
    //   260: iload 5
    //   262: istore_3
    //   263: aload 7
    //   265: invokevirtual 225	java/net/Socket:close	()V
    //   268: iload 6
    //   270: istore 4
    //   272: goto +88 -> 360
    //   275: astore 8
    //   277: aload 9
    //   279: astore 7
    //   281: aload 7
    //   283: astore_0
    //   284: new 155	java/lang/StringBuilder
    //   287: dup
    //   288: ldc 239
    //   290: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: astore 9
    //   295: aload 7
    //   297: astore_0
    //   298: aload 9
    //   300: aload 8
    //   302: invokevirtual 240	java/io/IOException:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 7
    //   311: astore_0
    //   312: ldc 38
    //   314: aload 9
    //   316: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: aload 8
    //   321: invokestatic 237	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   324: iload 6
    //   326: istore 4
    //   328: aload 7
    //   330: ifnull +30 -> 360
    //   333: iload 5
    //   335: istore_3
    //   336: iload 6
    //   338: istore 4
    //   340: aload 7
    //   342: invokevirtual 222	java/net/Socket:isConnected	()Z
    //   345: ifeq +15 -> 360
    //   348: iload 5
    //   350: istore_3
    //   351: aload 7
    //   353: invokevirtual 225	java/net/Socket:close	()V
    //   356: iload 6
    //   358: istore 4
    //   360: new 155	java/lang/StringBuilder
    //   363: dup
    //   364: ldc 242
    //   366: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   369: astore_0
    //   370: aload_0
    //   371: iload 4
    //   373: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_0
    //   378: ldc 244
    //   380: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload_0
    //   385: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   388: lload_1
    //   389: lsub
    //   390: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: ldc 38
    //   396: aload_0
    //   397: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 147	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: iload 4
    //   405: ireturn
    //   406: aload_0
    //   407: ifnull +22 -> 429
    //   410: aload_0
    //   411: invokevirtual 222	java/net/Socket:isConnected	()Z
    //   414: ifeq +15 -> 429
    //   417: aload_0
    //   418: invokevirtual 225	java/net/Socket:close	()V
    //   421: goto +8 -> 429
    //   424: astore_0
    //   425: aload_0
    //   426: invokevirtual 228	java/lang/Throwable:printStackTrace	()V
    //   429: aload 7
    //   431: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	paramString	String
    //   47	342	1	l	long
    //   119	232	3	bool1	boolean
    //   122	282	4	bool2	boolean
    //   52	297	5	bool3	boolean
    //   49	308	6	bool4	boolean
    //   9	157	7	localObject1	Object
    //   180	1	7	localObject2	Object
    //   188	242	7	localObject3	Object
    //   55	1	8	localObject4	Object
    //   158	6	8	localObject5	Object
    //   170	1	8	localThrowable	Throwable
    //   175	12	8	localIOException1	java.io.IOException
    //   191	41	8	str	String
    //   275	45	8	localIOException2	java.io.IOException
    //   58	257	9	localStringBuilder	StringBuilder
    //   80	24	10	localInetSocketAddress	java.net.InetSocketAddress
    // Exception table:
    //   from	to	target	type
    //   124	132	147	java/lang/Throwable
    //   135	140	147	java/lang/Throwable
    //   252	260	147	java/lang/Throwable
    //   263	268	147	java/lang/Throwable
    //   340	348	147	java/lang/Throwable
    //   351	356	147	java/lang/Throwable
    //   94	111	158	finally
    //   94	111	170	java/lang/Throwable
    //   94	111	175	java/io/IOException
    //   66	82	180	finally
    //   85	94	180	finally
    //   196	207	180	finally
    //   210	221	180	finally
    //   224	236	180	finally
    //   284	295	180	finally
    //   298	309	180	finally
    //   312	324	180	finally
    //   66	82	185	java/lang/Throwable
    //   85	94	185	java/lang/Throwable
    //   66	82	275	java/io/IOException
    //   85	94	275	java/io/IOException
    //   410	421	424	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cx
 * JD-Core Version:    0.7.0.1
 */