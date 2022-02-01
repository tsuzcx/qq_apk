package btmsdkobf;

import android.content.Context;
import android.os.Process;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.AbsTMSBaseConfig;
import com.tmsdk.base.utils.NetworkUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import tmsdk.Protocol.MCommon.Sharkfin;
import tmsdk.common.tcc.b;

public class cd
{
  private static Sharkfin hw;
  private static String hx;
  private static boolean hy = false;
  
  private static at a(Context paramContext, boolean paramBoolean, cy.f paramf, cs.b paramb, ArrayList<as> paramArrayList, String paramString, cl paramcl)
  {
    at localat = cp.bp();
    localat.dc = paramf.jQ;
    localat.dl = 4;
    localat.dn = paramArrayList;
    if ((paramBoolean) && (!paramf.jJ) && (!paramf.jK) && (!paramf.jM))
    {
      if (paramf.jL) {
        return localat;
      }
      paramContext = a(paramContext, false, paramb, paramString, paramcl);
      if (!a(paramContext, hw))
      {
        eh.e("ConverterUtil", "[shark_v4][shark_fin] sharkfin changed, needed!");
        a(hw, "[shark_fin][last]");
      }
      for (;;)
      {
        a(paramContext, "[shark_fin][cur]");
        localat.dm = paramContext;
        hw = paramContext;
        hy = false;
        return localat;
        if (!hy) {
          break;
        }
        eh.g("ConverterUtil", "[shark_v4][shark_fin] mazu said need sharkfin!");
      }
      eh.f("ConverterUtil", "[shark_v4][shark_fin] sharkfin unchanged, no need to take sharkfin");
      return localat;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("[shark_v4][shark_fin] must take sharkfin: !isTcpChannel: ");
    paramArrayList.append(paramBoolean ^ true);
    paramArrayList.append(" isRsa: ");
    paramArrayList.append(paramf.jJ);
    paramArrayList.append(" isGuid: ");
    paramArrayList.append(paramf.jK);
    paramArrayList.append(" isFP: ");
    paramArrayList.append(paramf.jM);
    eh.e("ConverterUtil", paramArrayList.toString());
    paramContext = a(paramContext, paramf.jJ, paramb, paramString, paramcl);
    localat.dm = paramContext;
    hw = paramContext;
    hy = false;
    a(paramContext, "[shark_fin][must take]");
    return localat;
  }
  
  public static JceStruct a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, JceStruct paramJceStruct, boolean paramBoolean, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte2 != null)
    {
      if (paramArrayOfByte2.length == 0) {
        return null;
      }
      paramArrayOfByte1 = a(paramContext, paramArrayOfByte1, paramArrayOfByte2, paramInt);
      localObject1 = localObject2;
      if (paramArrayOfByte1 != null)
      {
        localObject1 = localObject2;
        if (paramArrayOfByte1.length > 0)
        {
          localObject1 = localObject2;
          if (paramJceStruct != null)
          {
            paramContext = cp.a(paramArrayOfByte1, paramJceStruct, paramBoolean);
            localObject1 = paramContext;
            if (paramContext == null)
            {
              paramArrayOfByte2 = new StringBuilder();
              paramArrayOfByte2.append("[shark_v4][shark_cmd]dataForReceive2JceStruct(), getJceStruct() return null! jceData: ");
              paramArrayOfByte2.append(Arrays.toString(paramArrayOfByte1));
              eh.g("ConverterUtil", paramArrayOfByte2.toString());
              localObject1 = paramContext;
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, JceStruct paramJceStruct)
  {
    return cp.a(paramArrayOfByte, paramJceStruct, false);
  }
  
  private static Sharkfin a(Context paramContext, boolean paramBoolean, cs.b paramb, String paramString, cl paramcl)
  {
    if (paramcl == null) {
      return null;
    }
    Sharkfin localSharkfin = new Sharkfin();
    if (paramb != null) {
      paramb = paramb.ir;
    } else {
      paramb = "";
    }
    if (paramBoolean) {
      paramb = "";
    }
    localSharkfin.sessionId = paramb;
    localSharkfin.buildno = bc.o().getBuildNo();
    localSharkfin.apn = e(paramContext);
    localSharkfin.netType = NetworkUtil.getNetType();
    localSharkfin.authType = aV();
    paramContext = new StringBuilder();
    paramContext.append("[ip_list][conn_monitor]checkSharkfin(), apn=");
    paramContext.append(localSharkfin.apn);
    paramContext.append(" isWifi=");
    if (ei.om == 3) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    paramContext.append(paramBoolean);
    paramContext.append(" authType=");
    paramContext.append(localSharkfin.authType);
    eh.f("ConverterUtil", paramContext.toString());
    localSharkfin.guid = paramString;
    localSharkfin.accountId = paramcl.aI();
    localSharkfin.bootType = paramcl.aM();
    localSharkfin.wsGuid = paramcl.bn();
    if (hx == null)
    {
      int i = Process.myPid();
      paramb = new StringBuilder();
      if (paramcl.ax()) {
        paramContext = "b";
      } else {
        paramContext = "f";
      }
      paramb.append(paramContext);
      paramb.append(i);
      hx = paramb.toString();
    }
    localSharkfin.ext1 = hx;
    return localSharkfin;
  }
  
  private static void a(Sharkfin paramSharkfin, String paramString)
  {
    if (paramSharkfin == null)
    {
      paramSharkfin = new StringBuilder();
      paramSharkfin.append("[shark_v4]");
      paramSharkfin.append(paramString);
      paramSharkfin.append(": null");
      eh.f("ConverterUtil", paramSharkfin.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[shark_v4]");
    localStringBuilder.append(paramString);
    localStringBuilder.append(": sharkfin.buildno: ");
    localStringBuilder.append(paramSharkfin.buildno);
    localStringBuilder.append(" sharkfin.apn: ");
    localStringBuilder.append(paramSharkfin.apn);
    localStringBuilder.append(" sharkfin.netType: ");
    localStringBuilder.append(paramSharkfin.netType);
    localStringBuilder.append(" sharkfin.authType: ");
    localStringBuilder.append(paramSharkfin.authType);
    localStringBuilder.append(" sharkfin.guid: ");
    localStringBuilder.append(paramSharkfin.guid);
    localStringBuilder.append(" sharkfin.ext1: ");
    localStringBuilder.append(paramSharkfin.ext1);
    localStringBuilder.append(" sharkfin.accountId: ");
    localStringBuilder.append(paramSharkfin.accountId);
    localStringBuilder.append(" sharkfin.bootType: ");
    localStringBuilder.append(paramSharkfin.bootType);
    localStringBuilder.append(" sharkfin.wsGuid: ");
    localStringBuilder.append(paramSharkfin.wsGuid);
    eh.f("ConverterUtil", localStringBuilder.toString());
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  private static boolean a(Sharkfin paramSharkfin1, Sharkfin paramSharkfin2)
  {
    if ((paramSharkfin1 == null) && (paramSharkfin2 == null)) {
      return true;
    }
    if (paramSharkfin1 != null)
    {
      if (paramSharkfin2 == null) {
        return false;
      }
      return (paramSharkfin1.apn == paramSharkfin2.apn) && (paramSharkfin1.authType == paramSharkfin2.authType) && (a(paramSharkfin1.guid, paramSharkfin2.guid)) && (a(paramSharkfin1.ext1, paramSharkfin2.ext1)) && (a(paramSharkfin1.sessionId, paramSharkfin2.sessionId)) && (paramSharkfin1.buildno == paramSharkfin2.buildno) && (paramSharkfin1.netType == paramSharkfin2.netType) && (paramSharkfin1.accountId == paramSharkfin2.accountId) && (paramSharkfin1.bootType == paramSharkfin2.bootType) && (a(paramSharkfin1.wsGuid, paramSharkfin2.wsGuid));
    }
    return false;
  }
  
  public static byte[] a(Context paramContext, JceStruct paramJceStruct, int paramInt, as paramas)
  {
    if (paramJceStruct != null) {
      paramJceStruct = cp.b(paramJceStruct);
    } else {
      paramJceStruct = null;
    }
    return a(paramContext, paramJceStruct, paramInt, paramas);
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte, int paramInt, as paramas)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 50)
      {
        paramContext = e(paramArrayOfByte);
        if (paramas == null) {
          break label482;
        }
        int j = paramas.di;
        if ((paramContext == null) || (paramContext.length >= paramArrayOfByte.length)) {
          break label472;
        }
        paramas.di &= 0xFFFFFFFE;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[shark_compress]compressed, length: ");
        localStringBuilder.append(paramArrayOfByte.length);
        localStringBuilder.append(" -> ");
        localStringBuilder.append(paramContext.length);
        localStringBuilder.append(" cmdId: ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" flag: ");
        localStringBuilder.append(Integer.toBinaryString(j));
        localStringBuilder.append(" -> ");
        localStringBuilder.append(Integer.toBinaryString(paramas.di));
        eh.f("ConverterUtil", localStringBuilder.toString());
        break label482;
        i = paramContext.length;
        label166:
        paramas.di |= 0x1;
        paramContext = new StringBuilder();
        paramContext.append("[shark_compress]donnot compress, length: ");
        paramContext.append(paramArrayOfByte.length);
        paramContext.append(" (if compress)|-> ");
        paramContext.append(i);
        paramContext.append(" cmdId: ");
        paramContext.append(paramInt);
        paramContext.append(" flag: ");
        paramContext.append(Integer.toBinaryString(j));
        paramContext.append(" -> ");
        paramContext.append(Integer.toBinaryString(paramas.di));
        eh.f("ConverterUtil", paramContext.toString());
        paramContext = paramArrayOfByte;
        break label431;
      }
      paramContext = paramArrayOfByte;
      if (paramas == null) {
        break label431;
      }
      i = paramas.di;
      paramas.di |= 0x1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[shark_compress]without compress, length: ");
      if (paramArrayOfByte == null) {
        break label489;
      }
      paramContext = new StringBuilder();
      paramContext.append("");
      paramContext.append(paramArrayOfByte.length);
      paramContext = paramContext.toString();
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        int i;
        continue;
        paramContext = "null";
      }
    }
    localStringBuilder.append(paramContext);
    localStringBuilder.append(" cmdId: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" flag: ");
    localStringBuilder.append(Integer.toBinaryString(i));
    localStringBuilder.append(" -> ");
    localStringBuilder.append(Integer.toBinaryString(paramas.di));
    eh.f("ConverterUtil", localStringBuilder.toString());
    paramContext = paramArrayOfByte;
    label431:
    label472:
    label482:
    for (;;)
    {
      paramContext = b(paramInt, paramContext);
      return paramContext;
      paramContext = new StringBuilder();
      paramContext.append("jceStruct2DataForSend(), exception: ");
      paramContext.append(paramArrayOfByte);
      eh.h("ConverterUtil", paramContext.toString());
      return null;
      if (paramContext != null) {
        break;
      }
      i = -1;
      break label166;
    }
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    boolean bool = true;
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0))
    {
      paramContext = paramArrayOfByte2;
      if ((paramInt & 0x2) == 0) {
        try
        {
          paramContext = b.decrypt(paramArrayOfByte2, paramArrayOfByte1);
        }
        catch (Exception paramContext)
        {
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append("[shark_v4]dataForReceive2JceBytes(), decrypt exception: ");
          paramArrayOfByte1.append(paramContext);
          eh.g("ConverterUtil", paramArrayOfByte1.toString());
          paramContext = null;
        }
      }
      if ((paramContext != null) && (paramContext.length >= 4))
      {
        try
        {
          paramArrayOfByte1 = d(paramContext);
          int i = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte1)).readInt();
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append("[shark_cmd]dataForReceive2JceBytes(), header bytes: ");
          paramArrayOfByte2.append(Arrays.toString(paramArrayOfByte1));
          paramArrayOfByte2.append(" to int: ");
          paramArrayOfByte2.append(i);
          paramArrayOfByte2.append(" jce bytes count: ");
          paramArrayOfByte2.append(paramContext.length - 4);
          eh.e("ConverterUtil", paramArrayOfByte2.toString());
        }
        catch (Exception paramArrayOfByte1)
        {
          paramArrayOfByte1.printStackTrace();
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append("[shark_cmd][shark_v4]dataForReceive2JceBytes(), read header exception: ");
          paramArrayOfByte2.append(paramArrayOfByte1);
          eh.g("ConverterUtil", paramArrayOfByte2.toString());
        }
        paramArrayOfByte1 = c(paramContext);
        if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
        {
          paramContext = paramArrayOfByte1;
          if ((0x1 & paramInt) == 0) {
            paramContext = f(paramArrayOfByte1);
          }
          if (paramContext == null) {
            eh.g("ConverterUtil", "[shark_v4]dataForReceive2JceBytes(), decompress failed!");
          }
          return paramContext;
        }
      }
      else
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("[shark_v4]dataForReceive2JceBytes(), data should be at least 4 bytes: ");
        if (paramContext != null) {
          paramInt = paramContext.length;
        } else {
          paramInt = -1;
        }
        paramArrayOfByte1.append(paramInt);
        eh.g("ConverterUtil", paramArrayOfByte1.toString());
      }
      return null;
    }
    paramContext = new StringBuilder();
    paramContext.append("[shark_v4]dataForReceive2JceBytes(), null or empty data, null? ");
    if (paramArrayOfByte2 != null) {
      bool = false;
    }
    paramContext.append(bool);
    eh.g("ConverterUtil", paramContext.toString());
    return null;
  }
  
  public static byte[] a(cy.f paramf, boolean paramBoolean, String paramString, cl paramcl)
  {
    if (paramf == null) {
      return null;
    }
    if (paramf.jL)
    {
      paramString = new byte[1];
      paramString[0] = paramf.jX;
    }
    else
    {
      paramString = cp.b(a(bc.n(), paramBoolean, paramf, paramf.jR, paramf.jT, paramString, paramcl));
    }
    paramcl = new StringBuilder();
    paramcl.append("createSendBytes(), isHello? ");
    paramcl.append(paramf.jL);
    paramcl.append(" sendData.length: ");
    int i;
    if (paramString != null) {
      i = paramString.length;
    } else {
      i = -1;
    }
    paramcl.append(i);
    eh.e("ConverterUtil", paramcl.toString());
    return paramString;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    return cp.b(paramJceStruct);
  }
  
  public static void aU()
  {
    hy = true;
  }
  
  private static int aV()
  {
    return 0;
  }
  
  private static byte[] b(int paramInt, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = localStringBuilder;
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      localObject = localStringBuilder;
      localDataOutputStream.writeInt(paramInt);
      if (paramArrayOfByte != null)
      {
        localObject = localStringBuilder;
        if (paramArrayOfByte.length > 0)
        {
          localObject = localStringBuilder;
          localDataOutputStream.write(paramArrayOfByte);
        }
      }
      localObject = localStringBuilder;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject = paramArrayOfByte;
      localStringBuilder = new StringBuilder();
      localObject = paramArrayOfByte;
      localStringBuilder.append("[shark_cmd]appendIntHeader(), header bytes: ");
      localObject = paramArrayOfByte;
      localStringBuilder.append(Arrays.toString(d(paramArrayOfByte)));
      localObject = paramArrayOfByte;
      localStringBuilder.append(" header value: ");
      localObject = paramArrayOfByte;
      localStringBuilder.append(paramInt);
      localObject = paramArrayOfByte;
      localStringBuilder.append(" mixData.length: ");
      localObject = paramArrayOfByte;
      localStringBuilder.append(paramArrayOfByte.length);
      localObject = paramArrayOfByte;
      eh.f("ConverterUtil", localStringBuilder.toString());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[shark_v4]appendIntHeader(), exception: ");
      localStringBuilder.append(paramArrayOfByte);
      eh.g("ConverterUtil", localStringBuilder.toString());
    }
    return localObject;
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4))
    {
      localObject = new byte[paramArrayOfByte.length - 4];
      System.arraycopy(paramArrayOfByte, 4, localObject, 0, paramArrayOfByte.length - 4);
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_v4]deleteIntHeader(), mixData is not valid, len: ");
    int i;
    if (paramArrayOfByte != null) {
      i = paramArrayOfByte.length;
    } else {
      i = -1;
    }
    ((StringBuilder)localObject).append(i);
    eh.g("ConverterUtil", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public static byte[] d(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4))
    {
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 4);
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_v4]getIntHeader(), mixData is not valid, len: ");
    int i;
    if (paramArrayOfByte != null) {
      i = paramArrayOfByte.length;
    } else {
      i = -1;
    }
    ((StringBuilder)localObject).append(i);
    eh.g("ConverterUtil", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte1.length == 0) {
        return paramArrayOfByte1;
      }
      try
      {
        paramArrayOfByte1 = b.decrypt(paramArrayOfByte1, paramArrayOfByte2);
        return paramArrayOfByte1;
      }
      catch (Throwable paramArrayOfByte1)
      {
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("decrypt(), exception: ");
        paramArrayOfByte2.append(paramArrayOfByte1.toString());
        eh.h("ConverterUtil", paramArrayOfByte2.toString());
        arrayOfByte = null;
      }
    }
    return arrayOfByte;
  }
  
  public static int e(Context paramContext)
  {
    ei.ol = false;
    ei.n(paramContext);
    if (3 == ei.om) {
      return 1;
    }
    switch (ei.oo)
    {
    default: 
      return 0;
    case 8: 
      return 10;
    case 7: 
      return 9;
    case 6: 
      return 8;
    case 5: 
      return 7;
    case 4: 
      return 6;
    case 3: 
      return 5;
    case 2: 
      return 4;
    case 1: 
      return 3;
    }
    return 2;
  }
  
  /* Error */
  private static byte[] e(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 394	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 395	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 447	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 448	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 449	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 452	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 411	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 456	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: goto +52 -> 101
    //   52: astore_0
    //   53: new 94	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   60: astore_3
    //   61: aload_3
    //   62: ldc_w 459
    //   65: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: aload_0
    //   71: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: ldc 62
    //   77: aload_3
    //   78: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 87	btmsdkobf/eh:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_1
    //   85: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_2
    //   89: invokevirtual 456	java/util/zip/DeflaterOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: aload_1
    //   102: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   105: aload_2
    //   106: invokevirtual 456	java/util/zip/DeflaterOutputStream:close	()V
    //   109: goto +8 -> 117
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   117: aload_0
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   41	61	1	localIOException1	java.io.IOException
    //   112	2	1	localIOException2	java.io.IOException
    //   16	90	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    //   60	18	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   53	84	48	finally
    //   17	31	52	java/lang/Throwable
    //   84	92	94	java/io/IOException
    //   101	109	112	java/io/IOException
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte1.length == 0) {
        return paramArrayOfByte1;
      }
      try
      {
        paramArrayOfByte1 = b.encrypt(paramArrayOfByte1, paramArrayOfByte2);
        return paramArrayOfByte1;
      }
      catch (Throwable paramArrayOfByte1)
      {
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("encrypt(), exception: ");
        paramArrayOfByte2.append(paramArrayOfByte1.toString());
        eh.h("ConverterUtil", paramArrayOfByte2.toString());
        arrayOfByte = null;
      }
    }
    return arrayOfByte;
  }
  
  /* Error */
  private static byte[] f(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 339	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 342	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 466	java/util/zip/InflaterInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 467	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 394	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 395	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 470	java/util/zip/InflaterInputStream:read	()I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +11 -> 44
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 472	java/io/ByteArrayOutputStream:write	(I)V
    //   41: goto -15 -> 26
    //   44: aload_3
    //   45: invokevirtual 411	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 473	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: invokevirtual 474	java/util/zip/InflaterInputStream:close	()V
    //   58: aload_3
    //   59: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   62: aload 4
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   70: aload 4
    //   72: areturn
    //   73: astore 4
    //   75: goto +62 -> 137
    //   78: astore 4
    //   80: new 94	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   87: astore 5
    //   89: aload 5
    //   91: ldc_w 476
    //   94: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 5
    //   100: aload 4
    //   102: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: ldc 62
    //   108: aload 5
    //   110: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 87	btmsdkobf/eh:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: invokevirtual 473	java/io/ByteArrayInputStream:close	()V
    //   120: aload_2
    //   121: invokevirtual 474	java/util/zip/InflaterInputStream:close	()V
    //   124: aload_3
    //   125: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   135: aconst_null
    //   136: areturn
    //   137: aload_0
    //   138: invokevirtual 473	java/io/ByteArrayInputStream:close	()V
    //   141: aload_2
    //   142: invokevirtual 474	java/util/zip/InflaterInputStream:close	()V
    //   145: aload_3
    //   146: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   149: goto +8 -> 157
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   157: aload 4
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramArrayOfByte	byte[]
    //   30	8	1	i	int
    //   17	125	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   25	121	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   48	23	4	arrayOfByte	byte[]
    //   73	1	4	localObject	Object
    //   78	80	4	localException	Exception
    //   87	22	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	62	65	java/io/IOException
    //   26	31	73	finally
    //   36	41	73	finally
    //   44	50	73	finally
    //   80	116	73	finally
    //   26	31	78	java/lang/Exception
    //   36	41	78	java/lang/Exception
    //   44	50	78	java/lang/Exception
    //   116	128	130	java/io/IOException
    //   137	149	152	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cd
 * JD-Core Version:    0.7.0.1
 */