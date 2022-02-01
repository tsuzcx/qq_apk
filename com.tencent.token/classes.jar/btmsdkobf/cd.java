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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
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
    if ((!paramBoolean) || (paramf.jJ) || (paramf.jK) || (paramf.jM))
    {
      paramArrayList = new StringBuilder().append("[shark_v4][shark_fin] must take sharkfin: !isTcpChannel: ");
      if (!paramBoolean)
      {
        paramBoolean = true;
        eh.e("ConverterUtil", paramBoolean + " isRsa: " + paramf.jJ + " isGuid: " + paramf.jK + " isFP: " + paramf.jM);
        paramContext = a(paramContext, paramf.jJ, paramb, paramString, paramcl);
        localat.dm = paramContext;
        hw = paramContext;
        hy = false;
        a(paramContext, "[shark_fin][must take]");
      }
    }
    while (paramf.jL) {
      for (;;)
      {
        return localat;
        paramBoolean = false;
      }
    }
    paramContext = a(paramContext, false, paramb, paramString, paramcl);
    if (!a(paramContext, hw))
    {
      eh.e("ConverterUtil", "[shark_v4][shark_fin] sharkfin changed, needed!");
      a(hw, "[shark_fin][last]");
      a(paramContext, "[shark_fin][cur]");
      localat.dm = paramContext;
      hw = paramContext;
      hy = false;
      return localat;
    }
    if (hy)
    {
      eh.g("ConverterUtil", "[shark_v4][shark_fin] mazu said need sharkfin!");
      a(paramContext, "[shark_fin][cur]");
      localat.dm = paramContext;
      hw = paramContext;
      hy = false;
      return localat;
    }
    eh.f("ConverterUtil", "[shark_v4][shark_fin] sharkfin unchanged, no need to take sharkfin");
    return localat;
  }
  
  public static JceStruct a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, JceStruct paramJceStruct, boolean paramBoolean, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte2 != null)
    {
      if (paramArrayOfByte2.length != 0) {
        break label23;
      }
      localObject1 = localObject2;
    }
    label23:
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            paramArrayOfByte1 = a(paramContext, paramArrayOfByte1, paramArrayOfByte2, paramInt);
            localObject1 = localObject2;
          } while (paramArrayOfByte1 == null);
          localObject1 = localObject2;
        } while (paramArrayOfByte1.length <= 0);
        localObject1 = localObject2;
      } while (paramJceStruct == null);
      paramContext = cp.a(paramArrayOfByte1, paramJceStruct, paramBoolean);
      localObject1 = paramContext;
    } while (paramContext != null);
    eh.g("ConverterUtil", "[shark_v4][shark_cmd]dataForReceive2JceStruct(), getJceStruct() return null! jceData: " + Arrays.toString(paramArrayOfByte1));
    return paramContext;
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
    label109:
    int i;
    if (paramb != null)
    {
      paramb = paramb.ir;
      if (paramBoolean) {
        paramb = "";
      }
      localSharkfin.sessionId = paramb;
      localSharkfin.buildno = bc.o().getBuildNo();
      localSharkfin.apn = e(paramContext);
      localSharkfin.netType = NetworkUtil.getNetType();
      localSharkfin.authType = aV();
      paramContext = new StringBuilder().append("[ip_list][conn_monitor]checkSharkfin(), apn=").append(localSharkfin.apn).append(" isWifi=");
      if (ei.om != 3) {
        break label238;
      }
      paramBoolean = true;
      eh.f("ConverterUtil", paramBoolean + " authType=" + localSharkfin.authType);
      localSharkfin.guid = paramString;
      localSharkfin.accountId = paramcl.aI();
      localSharkfin.bootType = paramcl.aM();
      localSharkfin.wsGuid = paramcl.bn();
      if (hx == null)
      {
        i = Process.myPid();
        paramb = new StringBuilder();
        if (!paramcl.ax()) {
          break label243;
        }
      }
    }
    label238:
    label243:
    for (paramContext = "b";; paramContext = "f")
    {
      paramb.append(paramContext);
      paramb.append(i);
      hx = paramb.toString();
      localSharkfin.ext1 = hx;
      return localSharkfin;
      paramb = "";
      break;
      paramBoolean = false;
      break label109;
    }
  }
  
  private static void a(Sharkfin paramSharkfin, String paramString)
  {
    if (paramSharkfin == null)
    {
      eh.f("ConverterUtil", "[shark_v4]" + paramString + ": null");
      return;
    }
    eh.f("ConverterUtil", "[shark_v4]" + paramString + ": sharkfin.buildno: " + paramSharkfin.buildno + " sharkfin.apn: " + paramSharkfin.apn + " sharkfin.netType: " + paramSharkfin.netType + " sharkfin.authType: " + paramSharkfin.authType + " sharkfin.guid: " + paramSharkfin.guid + " sharkfin.ext1: " + paramSharkfin.ext1 + " sharkfin.accountId: " + paramSharkfin.accountId + " sharkfin.bootType: " + paramSharkfin.bootType + " sharkfin.wsGuid: " + paramSharkfin.wsGuid);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  private static boolean a(Sharkfin paramSharkfin1, Sharkfin paramSharkfin2)
  {
    if ((paramSharkfin1 == null) && (paramSharkfin2 == null)) {}
    do
    {
      return true;
      if ((paramSharkfin1 == null) || (paramSharkfin2 == null)) {
        return false;
      }
    } while ((paramSharkfin1.apn == paramSharkfin2.apn) && (paramSharkfin1.authType == paramSharkfin2.authType) && (a(paramSharkfin1.guid, paramSharkfin2.guid)) && (a(paramSharkfin1.ext1, paramSharkfin2.ext1)) && (a(paramSharkfin1.sessionId, paramSharkfin2.sessionId)) && (paramSharkfin1.buildno == paramSharkfin2.buildno) && (paramSharkfin1.netType == paramSharkfin2.netType) && (paramSharkfin1.accountId == paramSharkfin2.accountId) && (paramSharkfin1.bootType == paramSharkfin2.bootType) && (a(paramSharkfin1.wsGuid, paramSharkfin2.wsGuid)));
    return false;
  }
  
  public static byte[] a(Context paramContext, JceStruct paramJceStruct, int paramInt, as paramas)
  {
    byte[] arrayOfByte = null;
    if (paramJceStruct != null) {
      arrayOfByte = cp.b(paramJceStruct);
    }
    return a(paramContext, arrayOfByte, paramInt, paramas);
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte, int paramInt, as paramas)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfByte.length <= 50) {
          break label258;
        }
        paramContext = e(paramArrayOfByte);
        if (paramas == null) {
          break label386;
        }
        j = paramas.di;
        if ((paramContext == null) || (paramContext.length >= paramArrayOfByte.length)) {
          break label389;
        }
        paramas.di &= 0xFFFFFFFE;
        eh.f("ConverterUtil", "[shark_compress]compressed, length: " + paramArrayOfByte.length + " -> " + paramContext.length + " cmdId: " + paramInt + " flag: " + Integer.toBinaryString(j) + " -> " + Integer.toBinaryString(paramas.di));
        return b(paramInt, paramContext);
      }
      catch (Exception paramContext)
      {
        int j;
        label131:
        eh.h("ConverterUtil", "jceStruct2DataForSend(), exception: " + paramContext);
        return null;
      }
      paramas.di |= 0x1;
      eh.f("ConverterUtil", "[shark_compress]donnot compress, length: " + paramArrayOfByte.length + " (if compress)|-> " + i + " cmdId: " + paramInt + " flag: " + Integer.toBinaryString(j) + " -> " + Integer.toBinaryString(paramas.di));
      paramContext = paramArrayOfByte;
      continue;
      label258:
      label389:
      do
      {
        i = paramContext.length;
        break label131;
        paramContext = paramArrayOfByte;
        if (paramas == null) {
          break;
        }
        i = paramas.di;
        paramas.di |= 0x1;
        StringBuilder localStringBuilder = new StringBuilder().append("[shark_compress]without compress, length: ");
        if (paramArrayOfByte != null) {}
        for (paramContext = "" + paramArrayOfByte.length;; paramContext = "null")
        {
          eh.f("ConverterUtil", paramContext + " cmdId: " + paramInt + " flag: " + Integer.toBinaryString(i) + " -> " + Integer.toBinaryString(paramas.di));
          paramContext = paramArrayOfByte;
          break;
        }
        break;
      } while (paramContext != null);
      label386:
      int i = -1;
    }
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    boolean bool;
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      paramContext = new StringBuilder().append("[shark_v4]dataForReceive2JceBytes(), null or empty data, null? ");
      if (paramArrayOfByte2 == null)
      {
        bool = true;
        eh.g("ConverterUtil", bool);
        paramArrayOfByte1 = null;
      }
    }
    for (;;)
    {
      return paramArrayOfByte1;
      bool = false;
      break;
      paramContext = paramArrayOfByte2;
      if ((paramInt & 0x2) == 0) {}
      try
      {
        paramContext = b.decrypt(paramArrayOfByte2, paramArrayOfByte1);
        if ((paramContext == null) || (paramContext.length < 4)) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          paramArrayOfByte1 = d(paramContext);
          int i = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte1)).readInt();
          eh.e("ConverterUtil", "[shark_cmd]dataForReceive2JceBytes(), header bytes: " + Arrays.toString(paramArrayOfByte1) + " to int: " + i + " jce bytes count: " + (paramContext.length - 4));
          paramArrayOfByte1 = c(paramContext);
          if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0)) {
            break label296;
          }
          paramContext = paramArrayOfByte1;
          if ((paramInt & 0x1) == 0) {
            paramContext = f(paramArrayOfByte1);
          }
          paramArrayOfByte1 = paramContext;
          if (paramContext != null) {
            continue;
          }
          eh.g("ConverterUtil", "[shark_v4]dataForReceive2JceBytes(), decompress failed!");
          return paramContext;
          paramContext = paramContext;
          eh.g("ConverterUtil", "[shark_v4]dataForReceive2JceBytes(), decrypt exception: " + paramContext);
          paramContext = null;
        }
        catch (Exception paramArrayOfByte1)
        {
          for (;;)
          {
            paramArrayOfByte1.printStackTrace();
            eh.g("ConverterUtil", "[shark_cmd][shark_v4]dataForReceive2JceBytes(), read header exception: " + paramArrayOfByte1);
          }
        }
        paramArrayOfByte1 = new StringBuilder().append("[shark_v4]dataForReceive2JceBytes(), data should be at least 4 bytes: ");
        if (paramContext == null) {}
      }
    }
    for (paramInt = paramContext.length;; paramInt = -1)
    {
      eh.g("ConverterUtil", paramInt);
      label296:
      return null;
    }
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
      paramf = new StringBuilder().append("createSendBytes(), isHello? ").append(paramf.jL).append(" sendData.length: ");
      if (paramString == null) {
        break label100;
      }
    }
    label100:
    for (int i = paramString.length;; i = -1)
    {
      eh.e("ConverterUtil", i);
      return paramString;
      paramString = cp.b(a(bc.n(), paramBoolean, paramf, paramf.jR, paramf.jT, paramString, paramcl));
      break;
    }
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
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      localDataOutputStream.writeInt(paramInt);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localDataOutputStream.write(paramArrayOfByte);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      eh.g("ConverterUtil", "[shark_v4]appendIntHeader(), exception: " + localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        eh.f("ConverterUtil", "[shark_cmd]appendIntHeader(), header bytes: " + Arrays.toString(d(paramArrayOfByte)) + " header value: " + paramInt + " mixData.length: " + paramArrayOfByte.length);
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        break label98;
      }
      localException1 = localException1;
      paramArrayOfByte = null;
    }
    label98:
    return paramArrayOfByte;
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4))
    {
      localObject = new byte[paramArrayOfByte.length - 4];
      System.arraycopy(paramArrayOfByte, 4, localObject, 0, paramArrayOfByte.length - 4);
      return localObject;
    }
    Object localObject = new StringBuilder().append("[shark_v4]deleteIntHeader(), mixData is not valid, len: ");
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      eh.g("ConverterUtil", i);
      return null;
    }
  }
  
  public static byte[] d(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4))
    {
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 4);
      return localObject;
    }
    Object localObject = new StringBuilder().append("[shark_v4]getIntHeader(), mixData is not valid, len: ");
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      eh.g("ConverterUtil", i);
      return null;
    }
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return paramArrayOfByte1;
    }
    try
    {
      paramArrayOfByte1 = b.decrypt(paramArrayOfByte1, paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Throwable paramArrayOfByte1)
    {
      eh.h("ConverterUtil", "decrypt(), exception: " + paramArrayOfByte1.toString());
    }
    return null;
  }
  
  public static int e(Context paramContext)
  {
    int i = 3;
    ei.ol = false;
    ei.n(paramContext);
    if (3 == ei.om)
    {
      i = 1;
      return i;
    }
    switch (ei.oo)
    {
    case 1: 
    default: 
      return 0;
    case 0: 
      return 2;
    case 2: 
      return 4;
    case 3: 
      return 5;
    case 4: 
      return 6;
    case 5: 
      return 7;
    case 6: 
      return 8;
    case 7: 
      return 9;
    }
    return 10;
  }
  
  private static byte[] e(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte);
      localDeflaterOutputStream.finish();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        localDeflaterOutputStream.close();
        return paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return paramArrayOfByte;
      }
      try
      {
        localIOException1.close();
        localDeflaterOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      eh.g("ConverterUtil", "deflater(), exception: " + paramArrayOfByte);
      try
      {
        localIOException1.close();
        localDeflaterOutputStream.close();
        return null;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
    }
    finally {}
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      return paramArrayOfByte1;
    }
    try
    {
      paramArrayOfByte1 = b.encrypt(paramArrayOfByte1, paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Throwable paramArrayOfByte1)
    {
      eh.h("ConverterUtil", "encrypt(), exception: " + paramArrayOfByte1.toString());
    }
    return null;
  }
  
  private static byte[] f(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    localInflaterInputStream = new InflaterInputStream(paramArrayOfByte);
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      for (;;)
      {
        int i = localInflaterInputStream.read();
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(i);
      }
      try
      {
        byte[] arrayOfByte;
        paramArrayOfByte.close();
        localInflaterInputStream.close();
        localByteArrayOutputStream.close();
        throw localObject;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      eh.g("ConverterUtil", "inflater(), exception: " + localException);
      try
      {
        paramArrayOfByte.close();
        localInflaterInputStream.close();
        localByteArrayOutputStream.close();
        return null;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      try
      {
        paramArrayOfByte.close();
        localInflaterInputStream.close();
        localByteArrayOutputStream.close();
        return arrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return arrayOfByte;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cd
 * JD-Core Version:    0.7.0.1
 */