import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.PeakJceServiceBase.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public abstract class amzt
{
  public static HashMap<String, UniPacket> mZ = new HashMap();
  public static volatile int seq;
  private volatile boolean cEA;
  private DecimalFormat decimalFormat = new DecimalFormat("0.00");
  private ConcurrentHashMap<String, swr> gX;
  
  public UniPacket a(ToServiceMsg paramToServiceMsg)
  {
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
    {
      String str = paramToServiceMsg.extraData.getString("filepath");
      UniPacket localUniPacket = (UniPacket)mZ.get(str);
      Object localObject;
      if (localUniPacket == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PeakJceServiceBase", 2, "no saved packet, new one " + str);
        }
        localObject = new amzu(true);
        mZ.clear();
        mZ.put(str, localObject);
      }
      for (;;)
      {
        paramToServiceMsg = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
        int i = anqo.b(str);
        if (paramToServiceMsg.shortValue() <= i)
        {
          mZ.remove(str);
          if (QLog.isColorLevel()) {
            QLog.d("PeakJceServiceBase", 2, "last stream, remove " + i + ", " + paramToServiceMsg);
          }
        }
        return localObject;
        localObject = localUniPacket;
        if (QLog.isColorLevel())
        {
          QLog.d("PeakJceServiceBase", 2, "got last packet, reuse it " + str);
          localObject = localUniPacket;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PeakJceServiceBase", 2, "not stream ptt");
    }
    return new UniPacket(true);
  }
  
  public swr a(String paramString)
  {
    if (!this.cEA) {}
    int i;
    try
    {
      if (!this.cEA) {
        aTq();
      }
      i = paramString.indexOf('.');
      if (i <= 1) {
        return null;
      }
    }
    finally {}
    paramString = paramString.substring(0, i);
    return (swr)this.gX.get(paramString);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, aefh paramaefh, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakJceServiceBase", 2, "handleRequest request is null. ");
      }
      return;
    }
    paramToServiceMsg = new PeakJceServiceBase.1(this, paramToServiceMsg, paramaefh, paramClass);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramToServiceMsg, 10, null, false);
      return;
    }
    paramToServiceMsg.run();
  }
  
  /* Error */
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 209	amzt:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   9: astore 8
    //   11: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   14: aload_2
    //   15: getfield 56	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   18: ldc 217
    //   20: invokevirtual 221	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   23: lsub
    //   24: l2f
    //   25: ldc 222
    //   27: fdiv
    //   28: fstore 5
    //   30: iload_1
    //   31: ifeq +220 -> 251
    //   34: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +66 -> 103
    //   40: ldc 78
    //   42: iconst_2
    //   43: new 80	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   50: ldc 224
    //   52: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 227	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   59: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 229
    //   64: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 233	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   71: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc 235
    //   76: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 36	amzt:decimalFormat	Ljava/text/DecimalFormat;
    //   83: fload 5
    //   85: f2d
    //   86: invokevirtual 239	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   89: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 241
    //   94: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_2
    //   104: ldc 243
    //   106: invokevirtual 247	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   109: checkcast 249	com/tencent/qphone/base/remote/IBaseActionListener
    //   112: astore 4
    //   114: aload 4
    //   116: ifnull +9 -> 125
    //   119: aload_2
    //   120: aload 4
    //   122: putfield 253	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   125: aload_0
    //   126: aload_3
    //   127: invokevirtual 227	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   130: invokevirtual 255	amzt:a	(Ljava/lang/String;)Lswr;
    //   133: astore 9
    //   135: iload_1
    //   136: ifeq +323 -> 459
    //   139: aload 9
    //   141: ifnull +273 -> 414
    //   144: aload 9
    //   146: aload_2
    //   147: aload_3
    //   148: invokevirtual 259	swr:h	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   151: aload 9
    //   153: aload_2
    //   154: aload_3
    //   155: invokevirtual 262	swr:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/Object;
    //   158: astore 4
    //   160: aload_0
    //   161: aload_3
    //   162: invokevirtual 266	amzt:i	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   165: aload 9
    //   167: ifnull -163 -> 4
    //   170: invokestatic 272	acct:ae	()Ljava/util/Map;
    //   173: aload_3
    //   174: invokevirtual 227	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   177: invokeinterface 275 2 0
    //   182: checkcast 277	[I
    //   185: astore 9
    //   187: aload 9
    //   189: ifnull -185 -> 4
    //   192: aload 9
    //   194: arraylength
    //   195: ifle -191 -> 4
    //   198: aload 9
    //   200: arraylength
    //   201: istore 7
    //   203: iconst_0
    //   204: istore 6
    //   206: iload 6
    //   208: iload 7
    //   210: if_icmpge -206 -> 4
    //   213: aload 8
    //   215: aload 9
    //   217: iload 6
    //   219: iaload
    //   220: invokevirtual 283	com/tencent/common/app/AppInterface:getBusinessHandler	(I)Ljava/lang/Object;
    //   223: checkcast 285	accg
    //   226: astore 10
    //   228: aload 10
    //   230: ifnull +12 -> 242
    //   233: aload 10
    //   235: aload_2
    //   236: aload_3
    //   237: aload 4
    //   239: invokevirtual 289	accg:onReceive	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V
    //   242: iload 6
    //   244: iconst_1
    //   245: iadd
    //   246: istore 6
    //   248: goto -42 -> 206
    //   251: aload 4
    //   253: ifnull +88 -> 341
    //   256: new 291	java/io/ByteArrayOutputStream
    //   259: dup
    //   260: invokespecial 292	java/io/ByteArrayOutputStream:<init>	()V
    //   263: astore 9
    //   265: aload 4
    //   267: new 294	java/io/PrintStream
    //   270: dup
    //   271: aload 9
    //   273: invokespecial 297	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   276: invokevirtual 301	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   279: new 48	java/lang/String
    //   282: dup
    //   283: aload 9
    //   285: invokevirtual 305	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   288: invokespecial 308	java/lang/String:<init>	([B)V
    //   291: astore 4
    //   293: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq -193 -> 103
    //   299: ldc 78
    //   301: iconst_2
    //   302: new 80	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 310
    //   312: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_3
    //   316: invokevirtual 227	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   319: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc 137
    //   324: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 4
    //   329: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: goto -235 -> 103
    //   341: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq -241 -> 103
    //   347: ldc 78
    //   349: iconst_2
    //   350: new 80	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   357: ldc 224
    //   359: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_3
    //   363: invokevirtual 227	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   366: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 312
    //   372: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_3
    //   376: invokevirtual 315	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   379: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc 235
    //   384: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_0
    //   388: getfield 36	amzt:decimalFormat	Ljava/text/DecimalFormat;
    //   391: fload 5
    //   393: f2d
    //   394: invokevirtual 239	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   397: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc 241
    //   402: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 318	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: goto -308 -> 103
    //   414: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +12 -> 429
    //   420: ldc 78
    //   422: iconst_2
    //   423: ldc_w 320
    //   426: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aconst_null
    //   430: astore 4
    //   432: goto -272 -> 160
    //   435: astore 4
    //   437: aload 4
    //   439: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   442: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +14 -> 459
    //   448: ldc 78
    //   450: iconst_2
    //   451: ldc_w 324
    //   454: aload 4
    //   456: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   459: aconst_null
    //   460: astore 4
    //   462: goto -302 -> 160
    //   465: astore 11
    //   467: aload 11
    //   469: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   472: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq -233 -> 242
    //   478: ldc 78
    //   480: iconst_2
    //   481: new 80	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   488: aload 10
    //   490: invokevirtual 331	java/lang/Object:getClass	()Ljava/lang/Class;
    //   493: invokevirtual 336	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   496: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc_w 338
    //   502: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: aload 11
    //   510: invokestatic 340	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   513: goto -271 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	amzt
    //   0	516	1	paramBoolean	boolean
    //   0	516	2	paramToServiceMsg	ToServiceMsg
    //   0	516	3	paramFromServiceMsg	FromServiceMsg
    //   0	516	4	paramException	Exception
    //   28	364	5	f	float
    //   204	43	6	i	int
    //   201	10	7	j	int
    //   9	205	8	localAppInterface	AppInterface
    //   133	151	9	localObject	Object
    //   226	263	10	localaccg	accg
    //   465	44	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   144	160	435	java/lang/Exception
    //   414	429	435	java/lang/Exception
    //   233	242	465	java/lang/Exception
  }
  
  protected boolean a(swr paramswr)
  {
    int i = 0;
    String[] arrayOfString = paramswr.y();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    while (i < arrayOfString.length)
    {
      this.gX.put(arrayOfString[i], paramswr);
      i += 1;
    }
    return true;
  }
  
  protected void aTq()
  {
    try
    {
      if (this.gX == null) {
        this.gX = new ConcurrentHashMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, aefh paramaefh, Class<? extends MSFServlet> paramClass)
  {
    int i = 1;
    AppInterface localAppInterface = getAppInterface();
    Object localObject1 = paramToServiceMsg.getServiceCmd();
    swr localswr = a((String)localObject1);
    Object localObject2;
    int j;
    if (localswr != null)
    {
      localObject2 = a(paramToServiceMsg);
      ((UniPacket)localObject2).setEncodeName("utf-8");
      j = seq;
      seq = j + 1;
      ((UniPacket)localObject2).setRequestId(j);
      if (localswr.yg())
      {
        localObject2 = localswr.a(paramToServiceMsg);
        if (localObject2 == null) {
          break label314;
        }
        paramToServiceMsg.putWupBuffer((byte[])localObject2);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramToServiceMsg.actionListener = paramaefh;
        paramaefh = new NewIntent(localAppInterface.getApplication(), paramClass);
        paramaefh.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
        localAppInterface.startServlet(paramaefh);
        long l = System.currentTimeMillis();
        paramToServiceMsg.extraData.putLong("sendtimekey", l);
      }
      do
      {
        do
        {
          return;
          if (!localswr.a(paramToServiceMsg, (UniPacket)localObject2)) {
            break label314;
          }
          paramToServiceMsg.putWupBuffer(((UniPacket)localObject2).encode());
          break;
        } while (localswr == null);
        paramaefh = new FromServiceMsg(localAppInterface.getCurrentAccountUin(), (String)localObject1);
        paramClass = (int[])acct.ad().get(localObject1);
      } while ((paramClass == null) || (paramClass.length <= 0));
      j = paramClass.length;
      i = 0;
      while (i < j)
      {
        localObject1 = (accg)localAppInterface.getBusinessHandler(paramClass[i]);
        if (localObject1 != null) {}
        try
        {
          ((accg)localObject1).onReceive(paramToServiceMsg, paramaefh, null);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("PeakJceServiceBase", 2, localObject1.getClass().getSimpleName() + " onReceive error,", localException);
            }
          }
        }
      }
      label314:
      i = 0;
    }
  }
  
  protected void dOJ()
  {
    try
    {
      this.cEA = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract AppInterface getAppInterface();
  
  protected void i(FromServiceMsg paramFromServiceMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzt
 * JD-Core Version:    0.7.0.1
 */