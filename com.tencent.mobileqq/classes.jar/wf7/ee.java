package wf7;

import android.content.Context;
import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

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
      if (paramArrayOfByte2.length == 0) {
        return null;
      }
      paramContext = a(paramContext, paramArrayOfByte1, paramArrayOfByte2, paramInt);
      localObject1 = localObject2;
      if (paramContext != null)
      {
        localObject1 = localObject2;
        if (paramContext.length > 0)
        {
          localObject1 = localObject2;
          if (paramJceStruct != null) {
            localObject1 = df.b(paramContext, paramJceStruct, paramBoolean);
          }
        }
      }
    }
    return localObject1;
  }
  
  private static n a(Context paramContext, boolean paramBoolean, dx paramdx, String paramString, dt paramdt)
  {
    if (paramdt == null) {
      return null;
    }
    n localn = new n();
    if (paramdx != null) {
      paramdx = paramdx.lu;
    } else {
      paramdx = "";
    }
    if (paramBoolean) {
      paramdx = "";
    }
    localn.aZ = paramdx;
    localn.ba = paramdt.bW();
    localn.aS = i(paramContext);
    localn.bb = fi.o(paramContext);
    if (paramdt.ck()) {
      localn.aW = paramdt.cl();
    } else {
      localn.aW = -1;
    }
    localn.aX = paramString;
    localn.bc = paramdt.ci();
    localn.bd = paramdt.cm();
    localn.be = paramdt.cn();
    if (lR == null)
    {
      int i = Process.myPid();
      paramdx = new StringBuilder();
      if (paramdt.bX()) {
        paramContext = "b";
      } else {
        paramContext = "f";
      }
      paramdx.append(paramContext);
      paramdx.append(i);
      lR = paramdx.toString();
    }
    localn.aY = lR;
    return localn;
  }
  
  private static y a(Context paramContext, boolean paramBoolean, em.d paramd, dx paramdx, ArrayList<x> paramArrayList, String paramString, dt paramdt)
  {
    y localy = new y();
    localy.bZ = paramd.nB;
    localy.ci = 4;
    localy.ck = paramArrayList;
    if ((paramBoolean) && (!paramd.nu) && (!paramd.nv) && (!paramd.nx))
    {
      if (paramd.nw) {
        return localy;
      }
      paramContext = a(paramContext, false, paramdx, paramString, paramdt);
      if (!a(paramContext, lQ))
      {
        localy.cj = paramContext;
        lQ = paramContext;
        lS = false;
        return localy;
      }
      if (lS)
      {
        localy.cj = paramContext;
        lQ = paramContext;
        lS = false;
        return localy;
      }
    }
    else
    {
      paramContext = a(paramContext, paramd.nu, paramdx, paramString, paramdt);
      localy.cj = paramContext;
      lQ = paramContext;
      lS = false;
    }
    return localy;
  }
  
  private static boolean a(n paramn1, n paramn2)
  {
    if ((paramn1 == null) && (paramn2 == null)) {
      return true;
    }
    if (paramn1 != null)
    {
      if (paramn2 == null) {
        return false;
      }
      return (paramn1.aS == paramn2.aS) && (paramn1.aW == paramn2.aW) && (e(paramn1.aX, paramn2.aX)) && (e(paramn1.aY, paramn2.aY)) && (e(paramn1.aZ, paramn2.aZ)) && (paramn1.ba == paramn2.ba) && (paramn1.bb == paramn2.bb) && (paramn1.bc == paramn2.bc);
    }
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
    catch (Exception paramArrayOfByte)
    {
      label43:
      break label43;
    }
    return null;
  }
  
  public static byte[] a(Context paramContext, JceStruct paramJceStruct, int paramInt, x paramx)
  {
    if (paramJceStruct != null) {
      paramJceStruct = df.a(paramJceStruct);
    } else {
      paramJceStruct = null;
    }
    return a(paramContext, paramJceStruct, paramInt, paramx);
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte, int paramInt, x paramx)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length <= 50) {
        break label70;
      }
      paramContext = h(paramArrayOfByte);
      if (paramx == null) {
        break label115;
      }
      i = paramx.cf;
      if ((paramContext == null) || (paramContext.length >= paramArrayOfByte.length)) {
        break label108;
      }
      paramx.cf &= 0xFFFFFFFE;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int i;
        continue;
        if (paramContext == null) {}
      }
    }
    i = paramContext.length;
    paramx.cf |= 0x1;
    paramContext = paramArrayOfByte;
    break label94;
    label70:
    paramContext = paramArrayOfByte;
    if (paramx != null)
    {
      i = paramx.cf;
      paramx.cf |= 0x1;
      paramContext = paramArrayOfByte;
    }
    label94:
    paramContext = a(paramInt, paramContext);
    return paramContext;
    return null;
  }
  
  public static byte[] a(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramArrayOfByte2 != null)
    {
      if (paramArrayOfByte2.length == 0) {
        return null;
      }
      paramContext = paramArrayOfByte2;
      if ((paramInt & 0x2) == 0) {
        paramContext = ea.b(paramArrayOfByte2, paramArrayOfByte1);
      }
      if ((paramContext != null) && (paramContext.length >= 4))
      {
        paramArrayOfByte1 = g(paramContext);
        if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
        {
          paramContext = paramArrayOfByte1;
          if ((paramInt & 0x1) == 0) {
            paramContext = i(paramArrayOfByte1);
          }
          return paramContext;
        }
      }
    }
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
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return false;
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
    //   0: new 181	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 182	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 262	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 263	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 264	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 267	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 199	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 270	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 271	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 270	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 271	java/util/zip/DeflaterOutputStream:close	()V
    //   57: goto +8 -> 65
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   65: aload_0
    //   66: athrow
    //   67: aload_1
    //   68: invokevirtual 270	java/io/ByteArrayOutputStream:close	()V
    //   71: aload_2
    //   72: invokevirtual 271	java/util/zip/DeflaterOutputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: goto -18 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   41	9	1	localIOException1	java.io.IOException
    //   60	8	1	localIOException2	java.io.IOException
    //   16	56	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   49	57	60	java/io/IOException
    //   67	75	77	java/io/IOException
    //   17	31	84	java/lang/Exception
  }
  
  public static int i(Context paramContext)
  {
    fh.pT = false;
    fh.m(paramContext);
    if (3 == fh.pU) {
      return 1;
    }
    switch (fh.pW)
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
  private static byte[] i(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 291	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 293	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 295	java/util/zip/InflaterInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 298	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 181	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 182	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 301	java/util/zip/InflaterInputStream:read	()I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +11 -> 44
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 303	java/io/ByteArrayOutputStream:write	(I)V
    //   41: goto -15 -> 26
    //   44: aload_3
    //   45: invokevirtual 199	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 304	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: invokevirtual 305	java/util/zip/InflaterInputStream:close	()V
    //   58: aload_3
    //   59: invokevirtual 270	java/io/ByteArrayOutputStream:close	()V
    //   62: aload 4
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   70: aload 4
    //   72: areturn
    //   73: astore 4
    //   75: aload_0
    //   76: invokevirtual 304	java/io/ByteArrayInputStream:close	()V
    //   79: aload_2
    //   80: invokevirtual 305	java/util/zip/InflaterInputStream:close	()V
    //   83: aload_3
    //   84: invokevirtual 270	java/io/ByteArrayOutputStream:close	()V
    //   87: goto +8 -> 95
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   95: aload 4
    //   97: athrow
    //   98: aload_0
    //   99: invokevirtual 304	java/io/ByteArrayInputStream:close	()V
    //   102: aload_2
    //   103: invokevirtual 305	java/util/zip/InflaterInputStream:close	()V
    //   106: aload_3
    //   107: invokevirtual 270	java/io/ByteArrayOutputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore 4
    //   121: goto -23 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramArrayOfByte	byte[]
    //   30	8	1	i	int
    //   17	86	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   25	82	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   48	23	4	arrayOfByte	byte[]
    //   73	23	4	localObject	Object
    //   119	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   50	62	65	java/io/IOException
    //   26	31	73	finally
    //   36	41	73	finally
    //   44	50	73	finally
    //   75	87	90	java/io/IOException
    //   98	110	112	java/io/IOException
    //   26	31	119	java/lang/Exception
    //   36	41	119	java/lang/Exception
    //   44	50	119	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ee
 * JD-Core Version:    0.7.0.1
 */