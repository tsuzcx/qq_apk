package btmsdkobf;

import android.content.Context;
import android.os.Process;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.aoj;
import com.tencent.token.ass;
import com.tmsdk.base.AbsTMSBaseConfig;
import com.tmsdk.base.utils.NetworkUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class cd
{
  private static aoj hw;
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
      if (!paramf.jL)
      {
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
    }
    else
    {
      paramArrayList = new StringBuilder("[shark_v4][shark_fin] must take sharkfin: !isTcpChannel: ");
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
    }
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
              paramArrayOfByte2 = new StringBuilder("[shark_v4][shark_cmd]dataForReceive2JceStruct(), getJceStruct() return null! jceData: ");
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
  
  private static aoj a(Context paramContext, boolean paramBoolean, cs.b paramb, String paramString, cl paramcl)
  {
    if (paramcl == null) {
      return null;
    }
    aoj localaoj = new aoj();
    if (paramb != null) {
      paramb = paramb.ir;
    } else {
      paramb = "";
    }
    if (paramBoolean) {
      paramb = "";
    }
    localaoj.e = paramb;
    localaoj.f = bc.o().getBuildNo();
    localaoj.a = e(paramContext);
    localaoj.g = NetworkUtil.getNetType();
    localaoj.b = aV();
    paramContext = new StringBuilder("[ip_list][conn_monitor]checkSharkfin(), apn=");
    paramContext.append(localaoj.a);
    paramContext.append(" isWifi=");
    if (ei.om == 3) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    paramContext.append(paramBoolean);
    paramContext.append(" authType=");
    paramContext.append(localaoj.b);
    eh.f("ConverterUtil", paramContext.toString());
    localaoj.c = paramString;
    localaoj.h = paramcl.aI();
    localaoj.i = paramcl.aM();
    localaoj.j = paramcl.bn();
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
    localaoj.d = hx;
    return localaoj;
  }
  
  private static void a(aoj paramaoj, String paramString)
  {
    if (paramaoj == null)
    {
      paramaoj = new StringBuilder("[shark_v4]");
      paramaoj.append(paramString);
      paramaoj.append(": null");
      eh.f("ConverterUtil", paramaoj.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("[shark_v4]");
    localStringBuilder.append(paramString);
    localStringBuilder.append(": sharkfin.buildno: ");
    localStringBuilder.append(paramaoj.f);
    localStringBuilder.append(" sharkfin.apn: ");
    localStringBuilder.append(paramaoj.a);
    localStringBuilder.append(" sharkfin.netType: ");
    localStringBuilder.append(paramaoj.g);
    localStringBuilder.append(" sharkfin.authType: ");
    localStringBuilder.append(paramaoj.b);
    localStringBuilder.append(" sharkfin.guid: ");
    localStringBuilder.append(paramaoj.c);
    localStringBuilder.append(" sharkfin.ext1: ");
    localStringBuilder.append(paramaoj.d);
    localStringBuilder.append(" sharkfin.accountId: ");
    localStringBuilder.append(paramaoj.h);
    localStringBuilder.append(" sharkfin.bootType: ");
    localStringBuilder.append(paramaoj.i);
    localStringBuilder.append(" sharkfin.wsGuid: ");
    localStringBuilder.append(paramaoj.j);
    eh.f("ConverterUtil", localStringBuilder.toString());
  }
  
  private static boolean a(aoj paramaoj1, aoj paramaoj2)
  {
    if ((paramaoj1 == null) && (paramaoj2 == null)) {
      return true;
    }
    if (paramaoj1 != null)
    {
      if (paramaoj2 == null) {
        return false;
      }
      if ((paramaoj1.a == paramaoj2.a) && (paramaoj1.b == paramaoj2.b) && (a(paramaoj1.c, paramaoj2.c)) && (a(paramaoj1.d, paramaoj2.d)) && (a(paramaoj1.e, paramaoj2.e)) && (paramaoj1.f == paramaoj2.f) && (paramaoj1.g == paramaoj2.g) && (paramaoj1.h == paramaoj2.h) && (paramaoj1.i == paramaoj2.i) && (a(paramaoj1.j, paramaoj2.j))) {
        return true;
      }
    }
    return false;
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
    for (;;)
    {
      try
      {
        if (paramArrayOfByte.length > 50)
        {
          localObject = e(paramArrayOfByte);
          paramContext = (Context)localObject;
          if (paramas == null) {
            continue;
          }
          int j = paramas.di;
          if ((localObject == null) || (localObject.length >= paramArrayOfByte.length)) {
            continue;
          }
          paramas.di &= 0xFFFFFFFE;
          paramContext = new StringBuilder("[shark_compress]compressed, length: ");
          paramContext.append(paramArrayOfByte.length);
          paramContext.append(" -> ");
          paramContext.append(localObject.length);
          paramContext.append(" cmdId: ");
          paramContext.append(paramInt);
          paramContext.append(" flag: ");
          paramContext.append(Integer.toBinaryString(j));
          paramContext.append(" -> ");
          paramContext.append(Integer.toBinaryString(paramas.di));
          eh.f("ConverterUtil", paramContext.toString());
          paramContext = (Context)localObject;
          continue;
          i = localObject.length;
          paramas.di |= 0x1;
          paramContext = new StringBuilder("[shark_compress]donnot compress, length: ");
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
          continue;
        }
        if (paramas == null) {
          continue;
        }
        i = paramas.di;
        paramas.di |= 0x1;
        localObject = new StringBuilder("[shark_compress]without compress, length: ");
        if (paramArrayOfByte == null) {
          continue;
        }
        paramContext = new StringBuilder();
        paramContext.append(paramArrayOfByte.length);
        paramContext = paramContext.toString();
      }
      catch (Exception paramContext)
      {
        Object localObject;
        int i;
        continue;
        paramContext = "null";
        continue;
        paramContext = paramArrayOfByte;
        continue;
      }
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(" cmdId: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" flag: ");
      ((StringBuilder)localObject).append(Integer.toBinaryString(i));
      ((StringBuilder)localObject).append(" -> ");
      ((StringBuilder)localObject).append(Integer.toBinaryString(paramas.di));
      eh.f("ConverterUtil", ((StringBuilder)localObject).toString());
      continue;
      paramContext = b(paramInt, paramContext);
      return paramContext;
      eh.h("ConverterUtil", "jceStruct2DataForSend(), exception: ".concat(String.valueOf(paramContext)));
      return null;
      if (localObject == null) {
        i = -1;
      }
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
          paramContext = ass.b(paramArrayOfByte2, paramArrayOfByte1);
        }
        catch (Exception paramContext)
        {
          eh.g("ConverterUtil", "[shark_v4]dataForReceive2JceBytes(), decrypt exception: ".concat(String.valueOf(paramContext)));
          paramContext = null;
        }
      }
      if ((paramContext != null) && (paramContext.length >= 4))
      {
        try
        {
          paramArrayOfByte1 = d(paramContext);
          int i = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte1)).readInt();
          paramArrayOfByte2 = new StringBuilder("[shark_cmd]dataForReceive2JceBytes(), header bytes: ");
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
          eh.g("ConverterUtil", "[shark_cmd][shark_v4]dataForReceive2JceBytes(), read header exception: ".concat(String.valueOf(paramArrayOfByte1)));
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
        paramArrayOfByte1 = new StringBuilder("[shark_v4]dataForReceive2JceBytes(), data should be at least 4 bytes: ");
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
    paramContext = new StringBuilder("[shark_v4]dataForReceive2JceBytes(), null or empty data, null? ");
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
    paramcl = new StringBuilder("createSendBytes(), isHello? ");
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
      localStringBuilder = new StringBuilder("[shark_cmd]appendIntHeader(), header bytes: ");
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
      eh.g("ConverterUtil", "[shark_v4]appendIntHeader(), exception: ".concat(String.valueOf(paramArrayOfByte)));
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
    Object localObject = new StringBuilder("[shark_v4]deleteIntHeader(), mixData is not valid, len: ");
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
    Object localObject = new StringBuilder("[shark_v4]getIntHeader(), mixData is not valid, len: ");
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
        paramArrayOfByte1 = ass.b(paramArrayOfByte1, paramArrayOfByte2);
        return paramArrayOfByte1;
      }
      catch (Throwable paramArrayOfByte1)
      {
        paramArrayOfByte2 = new StringBuilder("decrypt(), exception: ");
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
    //   0: new 393	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 394	java/io/ByteArrayOutputStream:<init>	()V
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
    //   27: invokevirtual 410	java/io/ByteArrayOutputStream:toByteArray	()[B
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
    //   49: goto +37 -> 86
    //   52: astore_0
    //   53: ldc 62
    //   55: ldc_w 459
    //   58: aload_0
    //   59: invokestatic 318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   62: invokevirtual 322	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 87	btmsdkobf/eh:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_1
    //   69: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 456	java/util/zip/DeflaterOutputStream:close	()V
    //   76: goto +8 -> 84
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   84: aconst_null
    //   85: areturn
    //   86: aload_1
    //   87: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   90: aload_2
    //   91: invokevirtual 456	java/util/zip/DeflaterOutputStream:close	()V
    //   94: goto +8 -> 102
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   41	46	1	localIOException1	java.io.IOException
    //   97	2	1	localIOException2	java.io.IOException
    //   16	75	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   53	68	48	finally
    //   17	31	52	java/lang/Throwable
    //   68	76	79	java/io/IOException
    //   86	94	97	java/io/IOException
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
        paramArrayOfByte1 = ass.a(paramArrayOfByte1, paramArrayOfByte2);
        return paramArrayOfByte1;
      }
      catch (Throwable paramArrayOfByte1)
      {
        paramArrayOfByte2 = new StringBuilder("encrypt(), exception: ");
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
    //   18: new 393	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 394	java/io/ByteArrayOutputStream:<init>	()V
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
    //   45: invokevirtual 410	java/io/ByteArrayOutputStream:toByteArray	()[B
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
    //   75: goto +43 -> 118
    //   78: astore 4
    //   80: ldc 62
    //   82: ldc_w 476
    //   85: aload 4
    //   87: invokestatic 318	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokevirtual 322	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   93: invokestatic 87	btmsdkobf/eh:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: invokevirtual 473	java/io/ByteArrayInputStream:close	()V
    //   100: aload_2
    //   101: invokevirtual 474	java/util/zip/InflaterInputStream:close	()V
    //   104: aload_3
    //   105: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   108: goto +8 -> 116
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: aload_0
    //   119: invokevirtual 473	java/io/ByteArrayInputStream:close	()V
    //   122: aload_2
    //   123: invokevirtual 474	java/util/zip/InflaterInputStream:close	()V
    //   126: aload_3
    //   127: invokevirtual 455	java/io/ByteArrayOutputStream:close	()V
    //   130: goto +8 -> 138
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 457	java/io/IOException:printStackTrace	()V
    //   138: aload 4
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramArrayOfByte	byte[]
    //   30	8	1	i	int
    //   17	106	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   25	102	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   48	23	4	arrayOfByte	byte[]
    //   73	1	4	localObject	Object
    //   78	61	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   50	62	65	java/io/IOException
    //   26	31	73	finally
    //   36	41	73	finally
    //   44	50	73	finally
    //   80	96	73	finally
    //   26	31	78	java/lang/Exception
    //   36	41	78	java/lang/Exception
    //   44	50	78	java/lang/Exception
    //   96	108	111	java/io/IOException
    //   118	130	133	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cd
 * JD-Core Version:    0.7.0.1
 */