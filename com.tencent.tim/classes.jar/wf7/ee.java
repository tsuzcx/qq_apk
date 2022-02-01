package wf7;

import android.content.Context;
import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;

public class ee
{
  private static n lQ;
  private static String lR;
  private static boolean lS = false;
  
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
            paramContext = a(paramContext, paramArrayOfByte1, paramArrayOfByte2, paramInt);
            localObject1 = localObject2;
          } while (paramContext == null);
          localObject1 = localObject2;
        } while (paramContext.length <= 0);
        localObject1 = localObject2;
      } while (paramJceStruct == null);
      paramContext = df.b(paramContext, paramJceStruct, paramBoolean);
      localObject1 = paramContext;
    } while (paramContext != null);
    return paramContext;
  }
  
  private static n a(Context paramContext, boolean paramBoolean, dx paramdx, String paramString, dt paramdt)
  {
    if (paramdt == null) {
      return null;
    }
    n localn = new n();
    label84:
    int i;
    if (paramdx != null)
    {
      paramdx = paramdx.lu;
      if (paramBoolean) {
        paramdx = "";
      }
      localn.aZ = paramdx;
      localn.ba = paramdt.bW();
      localn.aS = i(paramContext);
      localn.bb = fi.o(paramContext);
      if (!paramdt.ck()) {
        break label187;
      }
      localn.aW = paramdt.cl();
      localn.aX = paramString;
      localn.bc = paramdt.ci();
      localn.bd = paramdt.cm();
      localn.be = paramdt.cn();
      if (lR == null)
      {
        i = Process.myPid();
        paramdx = new StringBuilder();
        if (!paramdt.bX()) {
          break label196;
        }
      }
    }
    label187:
    label196:
    for (paramContext = "b";; paramContext = "f")
    {
      paramdx.append(paramContext);
      paramdx.append(i);
      lR = paramdx.toString();
      localn.aY = lR;
      return localn;
      paramdx = "";
      break;
      localn.aW = -1;
      break label84;
    }
  }
  
  private static y a(Context paramContext, boolean paramBoolean, em.d paramd, dx paramdx, ArrayList<x> paramArrayList, String paramString, dt paramdt)
  {
    y localy = new y();
    localy.bZ = paramd.nB;
    localy.ci = 4;
    localy.ck = paramArrayList;
    if ((!paramBoolean) || (paramd.nu) || (paramd.nv) || (paramd.nx))
    {
      paramContext = a(paramContext, paramd.nu, paramdx, paramString, paramdt);
      localy.cj = paramContext;
      lQ = paramContext;
      lS = false;
    }
    do
    {
      do
      {
        return localy;
      } while (paramd.nw);
      paramContext = a(paramContext, false, paramdx, paramString, paramdt);
      if (!a(paramContext, lQ))
      {
        localy.cj = paramContext;
        lQ = paramContext;
        lS = false;
        return localy;
      }
    } while (!lS);
    localy.cj = paramContext;
    lQ = paramContext;
    lS = false;
    return localy;
  }
  
  private static boolean a(n paramn1, n paramn2)
  {
    if ((paramn1 == null) && (paramn2 == null)) {}
    do
    {
      return true;
      if ((paramn1 == null) || (paramn2 == null)) {
        return false;
      }
    } while ((paramn1.aS == paramn2.aS) && (paramn1.aW == paramn2.aW) && (e(paramn1.aX, paramn2.aX)) && (e(paramn1.aY, paramn2.aY)) && (e(paramn1.aZ, paramn2.aZ)) && (paramn1.ba == paramn2.ba) && (paramn1.bb == paramn2.bb) && (paramn1.bc == paramn2.bc));
    return false;
  }
  
  private static byte[] a(int paramInt, byte[] paramArrayOfByte)
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
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] a(Context paramContext, JceStruct paramJceStruct, int paramInt, x paramx)
  {
    byte[] arrayOfByte = null;
    if (paramJceStruct != null) {
      arrayOfByte = df.a(paramJceStruct);
    }
    return a(paramContext, arrayOfByte, paramInt, paramx);
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte, int paramInt, x paramx)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      int i;
      if (paramArrayOfByte.length > 50)
      {
        paramContext = h(paramArrayOfByte);
        if (paramx == null) {
          break label103;
        }
        i = paramx.cf;
        if ((paramContext == null) || (paramContext.length >= paramArrayOfByte.length)) {
          break label106;
        }
        paramx.cf &= 0xFFFFFFFE;
        return a(paramInt, paramContext);
      }
      for (;;)
      {
        label54:
        paramx.cf |= 0x1;
        paramContext = paramArrayOfByte;
        break;
        label103:
        label106:
        do
        {
          i = paramContext.length;
          break label54;
          paramContext = paramArrayOfByte;
          if (paramx == null) {
            break;
          }
          i = paramx.cf;
          paramx.cf |= 0x1;
          paramContext = paramArrayOfByte;
          break;
          break;
        } while (paramContext != null);
      }
      return null;
    }
    catch (Exception paramContext) {}
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0)) {
      paramArrayOfByte1 = null;
    }
    do
    {
      return paramArrayOfByte1;
      paramContext = paramArrayOfByte2;
      if ((paramInt & 0x2) == 0) {
        paramContext = ea.b(paramArrayOfByte2, paramArrayOfByte1);
      }
      if ((paramContext == null) || (paramContext.length < 4)) {
        break;
      }
      paramArrayOfByte1 = g(paramContext);
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0)) {
        break;
      }
      paramContext = paramArrayOfByte1;
      if ((paramInt & 0x1) == 0) {
        paramContext = i(paramArrayOfByte1);
      }
      paramArrayOfByte1 = paramContext;
    } while (paramContext != null);
    return paramContext;
    return null;
  }
  
  public static byte[] a(em.d paramd, boolean paramBoolean, String paramString, dt paramdt)
  {
    if (paramd == null) {
      return null;
    }
    if (paramd.nw) {
      return new byte[] { paramd.nI };
    }
    return df.a(a(ea.cr(), paramBoolean, paramd, paramd.nC, paramd.nE, paramString, paramdt));
  }
  
  public static void cz()
  {
    lS = true;
  }
  
  private static boolean e(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  private static byte[] g(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 4];
      System.arraycopy(paramArrayOfByte, 4, arrayOfByte, 0, paramArrayOfByte.length - 4);
      return arrayOfByte;
    }
    return null;
  }
  
  /* Error */
  private static byte[] h(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 180	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 181	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 261	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 262	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 263	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 266	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 198	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 269	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 270	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 273	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 269	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 270	java/util/zip/DeflaterOutputStream:close	()V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 273	java/io/IOException:printStackTrace	()V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_0
    //   67: aload_1
    //   68: invokevirtual 269	java/io/ByteArrayOutputStream:close	()V
    //   71: aload_2
    //   72: invokevirtual 270	java/util/zip/DeflaterOutputStream:close	()V
    //   75: aload_0
    //   76: athrow
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 273	java/io/IOException:printStackTrace	()V
    //   82: goto -7 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   41	27	1	localIOException1	IOException
    //   77	2	1	localIOException2	IOException
    //   16	56	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	java/lang/Exception
    //   49	57	59	java/io/IOException
    //   17	31	66	finally
    //   67	75	77	java/io/IOException
  }
  
  public static int i(Context paramContext)
  {
    int i = 3;
    fh.pT = false;
    fh.m(paramContext);
    if (3 == fh.pU)
    {
      i = 1;
      return i;
    }
    switch (fh.pW)
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
  
  private static byte[] i(byte[] paramArrayOfByte)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ee
 * JD-Core Version:    0.7.0.1
 */