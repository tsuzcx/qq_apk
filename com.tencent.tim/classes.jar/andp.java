import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.mobile_get_config_req;
import QMF_PROTOCAL.mobile_get_config_rsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.WNSStream;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class andp
{
  public static String FIELD_UIN = "hostuin";
  private static AtomicInteger mSeq = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
  
  public static JceStruct a(int paramInt, long paramLong)
  {
    localObject3 = null;
    Object localObject2 = null;
    try
    {
      localObject1 = sxc.nV();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        int i;
        label86:
        Object localObject1 = localObject3;
        QLog.e("UndealCount.QZoneFeedCountPackeger", 1, localThrowable1, new Object[0]);
        continue;
        localObject1 = "";
      }
    }
    try
    {
      QLog.d("UndealCount.QZoneFeedCountPackeger", 1, "getCongfigPacket cookies: " + (String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label168;
      }
      i = ((String)localObject1).indexOf("&TjSwTm_" + paramLong);
      if (i >= 0) {
        break label168;
      }
      QLog.d("UndealCount.QZoneFeedCountPackeger", 1, "getCongfigPacket: cookies cleared");
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable2)
    {
      break label141;
      break label86;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("GetUndealCountTag", 4, "config Scene=" + paramInt);
    }
    if (localObject1 != null) {
      return new mobile_get_config_req(1000027, paramInt, (String)localObject1);
    }
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new WNSStream();
    try
    {
      localObject1 = ((WNSStream)localObject1).unpack(aqnv.J(paramArrayOfByte));
      paramArrayOfByte = new UniAttribute();
      if ((localObject1 != null) && (((QmfDownstream)localObject1).WnsCode == 0))
      {
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject1).Extra);
        Object localObject2 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
        {
          localObject2 = WNSStream.decompress(((QmfDownstream)localObject1).BusiBuff);
          if (localObject2 == null) {
            break label186;
          }
          ((QmfDownstream)localObject1).BusiBuff = ((byte[])localObject2);
        }
        localObject2 = new UniAttribute();
        ((UniAttribute)localObject2).setEncodeName("utf-8");
        ((UniAttribute)localObject2).decode(((QmfDownstream)localObject1).BusiBuff);
        paramString = (JceStruct)((UniAttribute)localObject2).get(paramString);
        ThreadManager.post(new QZoneFeedCountPackeger.1(paramArrayOfByte, paramQQAppInterface), 8, null, true);
        return paramString;
      }
      if (localObject1 != null)
      {
        int i = ((QmfDownstream)localObject1).WnsCode;
        if (i != 0) {
          return null;
        }
      }
      if (localObject1 == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
    label186:
    return null;
  }
  
  private static void a(UniAttribute paramUniAttribute, QQAppInterface paramQQAppInterface)
  {
    if (paramUniAttribute != null) {
      try
      {
        Object localObject = paramUniAttribute.get("conf_info_rsp_len");
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UndealCount.QZoneFeedCountPackeger", 2, "processConfig pack get conf_info_rsp_len is null ");
          }
        }
        else
        {
          int i = ((Integer)localObject).intValue();
          localObject = (byte[])paramUniAttribute.get("conf_info_rsp");
          paramUniAttribute = (UniAttribute)localObject;
          if (localObject != null)
          {
            paramUniAttribute = (UniAttribute)localObject;
            if (i != 0) {
              paramUniAttribute = WNSStream.decompress((byte[])localObject);
            }
          }
          if (paramUniAttribute != null)
          {
            paramUniAttribute = WNSStream.decodeWup(mobile_get_config_rsp.class, paramUniAttribute);
            if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null) && (paramUniAttribute != null))
            {
              a(paramQQAppInterface, (mobile_get_config_rsp)paramUniAttribute);
              return;
            }
          }
        }
      }
      catch (Error paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
        return;
      }
      catch (Exception paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, mobile_get_config_rsp parammobile_get_config_rsp)
  {
    if ((parammobile_get_config_rsp != null) && (parammobile_get_config_rsp.config != null) && (!parammobile_get_config_rsp.config.isEmpty())) {}
    try
    {
      sxb.a(parammobile_get_config_rsp.config, true);
      label32:
      String str2 = BaseApplication.getContext().getPackageName();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "unknow";
      }
      if (QLog.isColorLevel()) {
        QLog.i("ConfigProvider", 2, "qq config update:" + str1);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("UndealCount.QZoneFeedCountPackeger", 4, "UndealCount.QZoneFeedCountPackeger saveConfigToProvider");
      }
      sxc.a(parammobile_get_config_rsp.config, parammobile_get_config_rsp.cookies, str1, paramQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  /* Error */
  public static byte[] a(JceStruct paramJceStruct, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 52
    //   2: iconst_1
    //   3: new 54	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 260
    //   13: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: lload_2
    //   17: invokevirtual 82	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: new 131	com/qq/jce/wup/UniAttribute
    //   29: dup
    //   30: invokespecial 132	com/qq/jce/wup/UniAttribute:<init>	()V
    //   33: astore 7
    //   35: aload 7
    //   37: ldc_w 262
    //   40: invokevirtual 144	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   43: aload 7
    //   45: getstatic 14	andp:FIELD_UIN	Ljava/lang/String;
    //   48: lload_2
    //   49: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokevirtual 272	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   55: aload_0
    //   56: ifnull +21 -> 77
    //   59: aload_1
    //   60: ifnull +17 -> 77
    //   63: aload_1
    //   64: invokevirtual 275	java/lang/String:length	()I
    //   67: ifle +10 -> 77
    //   70: aload 7
    //   72: aload_1
    //   73: aload_0
    //   74: invokevirtual 272	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   77: aload 7
    //   79: invokevirtual 279	com/qq/jce/wup/UniAttribute:encode	()[B
    //   82: astore 9
    //   84: new 54	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 281
    //   94: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload 4
    //   99: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc_w 283
    //   105: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 5
    //   110: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore 8
    //   118: new 54	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   125: astore 10
    //   127: aload 10
    //   129: ldc_w 285
    //   132: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokestatic 290	avpp:a	()Lavpp;
    //   138: invokevirtual 293	avpp:getDeviceInfor	()Ljava/lang/String;
    //   141: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc_w 295
    //   148: invokestatic 300	aneq:a	(Ljava/lang/String;)Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   151: astore 11
    //   153: ldc 113
    //   155: astore 7
    //   157: ldc 113
    //   159: astore_0
    //   160: aload 11
    //   162: ifnonnull +160 -> 322
    //   165: ldc_w 295
    //   168: invokestatic 303	aneq:Qt	(Ljava/lang/String;)V
    //   171: aload 10
    //   173: bipush 38
    //   175: invokevirtual 306	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   178: ldc_w 308
    //   181: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 10
    //   191: bipush 38
    //   193: invokevirtual 306	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   196: ldc_w 310
    //   199: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 7
    //   204: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 8
    //   210: astore_0
    //   211: aload 10
    //   213: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   219: ifne +27 -> 246
    //   222: new 54	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   229: aload 8
    //   231: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 10
    //   236: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: astore_0
    //   246: new 118	cooperation/qzone/WNSStream
    //   249: dup
    //   250: ldc 104
    //   252: invokestatic 315	avpw:getQUA	()Ljava/lang/String;
    //   255: lload_2
    //   256: iconst_0
    //   257: newarray byte
    //   259: aload_0
    //   260: invokespecial 318	cooperation/qzone/WNSStream:<init>	(ILjava/lang/String;J[BLjava/lang/String;)V
    //   263: astore 8
    //   265: aload 9
    //   267: ifnull +111 -> 378
    //   270: aconst_null
    //   271: astore_0
    //   272: iload 6
    //   274: lload_2
    //   275: invokestatic 320	andp:a	(IJ)Lcom/qq/taf/jce/JceStruct;
    //   278: astore 7
    //   280: aload 7
    //   282: astore_0
    //   283: aload 8
    //   285: getstatic 39	andp:mSeq	Ljava/util/concurrent/atomic/AtomicInteger;
    //   288: invokevirtual 323	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   291: new 54	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 325
    //   301: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_1
    //   305: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: aload 9
    //   313: iconst_0
    //   314: aload_0
    //   315: invokevirtual 329	cooperation/qzone/WNSStream:packForUndeal	(ILjava/lang/String;[BZLcom/qq/taf/jce/JceStruct;)[B
    //   318: invokestatic 331	aqnv:I	([B)[B
    //   321: areturn
    //   322: dconst_1
    //   323: aload 11
    //   325: getfield 336	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   328: i2d
    //   329: dmul
    //   330: ldc2_w 337
    //   333: ddiv
    //   334: invokestatic 341	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   337: astore 7
    //   339: dconst_1
    //   340: aload 11
    //   342: getfield 344	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   345: i2d
    //   346: dmul
    //   347: ldc2_w 337
    //   350: ddiv
    //   351: invokestatic 341	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   354: astore_0
    //   355: goto -184 -> 171
    //   358: astore 7
    //   360: ldc 52
    //   362: iconst_1
    //   363: aload 7
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   372: goto -89 -> 283
    //   375: astore_0
    //   376: aconst_null
    //   377: areturn
    //   378: aconst_null
    //   379: areturn
    //   380: astore_0
    //   381: goto -236 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramJceStruct	JceStruct
    //   0	384	1	paramString	String
    //   0	384	2	paramLong	long
    //   0	384	4	paramInt1	int
    //   0	384	5	paramInt2	int
    //   0	384	6	paramInt3	int
    //   33	305	7	localObject1	Object
    //   358	6	7	localError	Error
    //   116	168	8	localObject2	Object
    //   82	230	9	arrayOfByte	byte[]
    //   125	110	10	localStringBuilder	java.lang.StringBuilder
    //   151	190	11	localGpsInfo	cooperation.qzone.LbsDataV2.GpsInfo
    // Exception table:
    //   from	to	target	type
    //   272	280	358	java/lang/Error
    //   0	55	375	java/lang/Throwable
    //   63	77	375	java/lang/Throwable
    //   77	127	375	java/lang/Throwable
    //   127	145	375	java/lang/Throwable
    //   145	153	375	java/lang/Throwable
    //   165	171	375	java/lang/Throwable
    //   171	208	375	java/lang/Throwable
    //   211	246	375	java/lang/Throwable
    //   246	265	375	java/lang/Throwable
    //   272	280	375	java/lang/Throwable
    //   283	322	375	java/lang/Throwable
    //   322	355	375	java/lang/Throwable
    //   360	372	375	java/lang/Throwable
    //   127	145	380	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     andp
 * JD-Core Version:    0.7.0.1
 */