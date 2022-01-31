package com.tencent.mqp.app.dbfs;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;

public class DBSecurity
{
  public static final int a = 8;
  private static final String jdField_a_of_type_JavaLangString = "PBE_PWD";
  public static final int b = 100;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public DBSecurity(Context paramContext)
  {
    a(paramContext);
  }
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 10
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 28	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +60 -> 69
    //   12: aload_0
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 31	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;)[B
    //   18: ldc 10
    //   20: invokevirtual 37	java/lang/String:getBytes	()[B
    //   23: invokestatic 40	com/tencent/mqp/app/dbfs/DBSecurity:b	([B[B)[B
    //   26: putfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   29: aload_0
    //   30: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   33: ifnull +13 -> 46
    //   36: aload_0
    //   37: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   40: arraylength
    //   41: bipush 8
    //   43: if_icmpge +26 -> 69
    //   46: ldc2_w 43
    //   49: invokestatic 50	java/lang/Thread:sleep	(J)V
    //   52: aload_0
    //   53: aload_0
    //   54: aload_1
    //   55: invokespecial 31	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;)[B
    //   58: ldc 10
    //   60: invokevirtual 37	java/lang/String:getBytes	()[B
    //   63: invokestatic 40	com/tencent/mqp/app/dbfs/DBSecurity:b	([B[B)[B
    //   66: putfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   69: aload_0
    //   70: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   73: ifnull +15 -> 88
    //   76: aload_0
    //   77: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   80: arraylength
    //   81: istore_2
    //   82: iload_2
    //   83: bipush 8
    //   85: if_icmpge +90 -> 175
    //   88: aconst_null
    //   89: astore 4
    //   91: aload_1
    //   92: ldc 52
    //   94: invokevirtual 58	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   97: checkcast 60	android/telephony/TelephonyManager
    //   100: invokevirtual 64	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   103: astore 6
    //   105: aload 6
    //   107: ifnull +21 -> 128
    //   110: aload 6
    //   112: astore 4
    //   114: aload 6
    //   116: astore 5
    //   118: aload 6
    //   120: invokevirtual 68	java/lang/String:length	()I
    //   123: bipush 8
    //   125: if_icmpge +120 -> 245
    //   128: aload 6
    //   130: astore 4
    //   132: aload_1
    //   133: ldc 70
    //   135: invokevirtual 58	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   138: checkcast 72	android/net/wifi/WifiManager
    //   141: invokevirtual 76	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   144: invokevirtual 81	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   147: astore 5
    //   149: aload 5
    //   151: astore 4
    //   153: aload 4
    //   155: ifnull +13 -> 168
    //   158: aload 4
    //   160: invokevirtual 68	java/lang/String:length	()I
    //   163: bipush 8
    //   165: if_icmpge +60 -> 225
    //   168: aload_0
    //   169: invokestatic 83	com/tencent/mqp/app/dbfs/DBSecurity:a	()[B
    //   172: putfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   175: aload_1
    //   176: aload_0
    //   177: getfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   180: ldc 10
    //   182: invokevirtual 37	java/lang/String:getBytes	()[B
    //   185: invokestatic 85	com/tencent/mqp/app/dbfs/DBSecurity:a	([B[B)[B
    //   188: invokestatic 88	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;[B)V
    //   191: ldc 10
    //   193: monitorexit
    //   194: return
    //   195: astore 4
    //   197: aload 4
    //   199: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   202: goto -133 -> 69
    //   205: astore_1
    //   206: ldc 10
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    //   211: astore 5
    //   213: aload 5
    //   215: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   218: aload 4
    //   220: astore 5
    //   222: goto +23 -> 245
    //   225: aload_0
    //   226: aload 4
    //   228: invokevirtual 37	java/lang/String:getBytes	()[B
    //   231: putfield 42	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   234: goto -59 -> 175
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   242: goto -51 -> 191
    //   245: aload 5
    //   247: astore 4
    //   249: goto -96 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	DBSecurity
    //   0	252	1	paramContext	Context
    //   81	5	2	i	int
    //   7	2	3	bool	boolean
    //   89	70	4	localObject1	Object
    //   195	32	4	localException1	Exception
    //   247	1	4	localObject2	Object
    //   116	34	5	str1	String
    //   211	3	5	localException2	Exception
    //   220	26	5	localException3	Exception
    //   103	26	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   12	46	195	java/lang/Exception
    //   46	69	195	java/lang/Exception
    //   3	8	205	finally
    //   12	46	205	finally
    //   46	69	205	finally
    //   69	82	205	finally
    //   91	105	205	finally
    //   118	128	205	finally
    //   132	149	205	finally
    //   158	168	205	finally
    //   168	175	205	finally
    //   175	191	205	finally
    //   191	194	205	finally
    //   197	202	205	finally
    //   206	209	205	finally
    //   213	218	205	finally
    //   225	234	205	finally
    //   238	242	205	finally
    //   91	105	211	java/lang/Exception
    //   118	128	211	java/lang/Exception
    //   132	149	211	java/lang/Exception
    //   175	191	237	java/io/IOException
  }
  
  private static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    paramContext = paramContext.openFileOutput("PBE_PWD", 0);
    paramContext.write(paramArrayOfByte);
    paramContext.close();
  }
  
  private static boolean a(Context paramContext)
  {
    return (paramContext.getFileStreamPath("PBE_PWD") != null) && (paramContext.getFileStreamPath("PBE_PWD").exists());
  }
  
  private static byte[] a()
  {
    return new SecureRandom().generateSeed(8);
  }
  
  private byte[] a(Context paramContext)
  {
    paramContext = paramContext.openFileInput("PBE_PWD");
    byte[] arrayOfByte = new byte[paramContext.available()];
    paramContext.read(arrayOfByte);
    paramContext.close();
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 0) {
      return paramArrayOfByte1;
    }
    return a(a(a(paramArrayOfByte1, true), a(paramArrayOfByte2, false)), false);
  }
  
  private static byte[] a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = paramArrayOfInt.length << 2;
    int i;
    if (paramBoolean)
    {
      int k = paramArrayOfInt[(paramArrayOfInt.length - 1)];
      i = k;
      if (k > j) {
        return null;
      }
    }
    else
    {
      i = j;
    }
    byte[] arrayOfByte = new byte[i];
    j = 0;
    while (j < i)
    {
      arrayOfByte[j] = ((byte)(paramArrayOfInt[(j >>> 2)] >>> ((j & 0x3) << 3) & 0xFF));
      j += 1;
    }
    return arrayOfByte;
  }
  
  private static int[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i;
    int[] arrayOfInt;
    if ((paramArrayOfByte.length & 0x3) == 0)
    {
      i = paramArrayOfByte.length >>> 2;
      if (!paramBoolean) {
        break label85;
      }
      arrayOfInt = new int[i + 1];
      arrayOfInt[i] = paramArrayOfByte.length;
    }
    for (;;)
    {
      int j = paramArrayOfByte.length;
      i = 0;
      while (i < j)
      {
        int k = i >>> 2;
        arrayOfInt[k] |= (paramArrayOfByte[i] & 0xFF) << ((i & 0x3) << 3);
        i += 1;
      }
      i = (paramArrayOfByte.length >>> 2) + 1;
      break;
      label85:
      arrayOfInt = new int[i];
    }
    return arrayOfInt;
  }
  
  private static final int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i1 = paramArrayOfInt1.length - 1;
    if (i1 < 1) {}
    for (;;)
    {
      return paramArrayOfInt1;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < 4)
      {
        arrayOfInt = new int[4];
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      }
      int i = paramArrayOfInt1[i1];
      int j = paramArrayOfInt1[0];
      j = 52 / (i1 + 1);
      int k = 0;
      j += 6;
      while (j > 0)
      {
        int m = k - 1640531527;
        int i2 = m >>> 2 & 0x3;
        int n = 0;
        k = i;
        i = n;
        while (i < i1)
        {
          n = paramArrayOfInt1[(i + 1)];
          i3 = paramArrayOfInt1[i];
          k = ((k ^ arrayOfInt[(i & 0x3 ^ i2)]) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
          paramArrayOfInt1[i] = k;
          i += 1;
        }
        n = paramArrayOfInt1[0];
        int i3 = paramArrayOfInt1[i1];
        i = ((arrayOfInt[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
        paramArrayOfInt1[i1] = i;
        j -= 1;
        k = m;
      }
    }
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 0) {
      return paramArrayOfByte1;
    }
    return a(b(a(paramArrayOfByte1, false), a(paramArrayOfByte2, false)), true);
  }
  
  private static final int[] b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = paramArrayOfInt1.length - 1;
    if (m < 1) {}
    for (;;)
    {
      return paramArrayOfInt1;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < 4)
      {
        arrayOfInt = new int[4];
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      }
      int i = paramArrayOfInt1[m];
      i = paramArrayOfInt1[0];
      int j = (52 / (m + 1) + 6) * -1640531527;
      while (j != 0)
      {
        int n = j >>> 2 & 0x3;
        int k = i;
        i = m;
        while (i > 0)
        {
          i1 = paramArrayOfInt1[(i - 1)];
          k = paramArrayOfInt1[i] - ((k ^ j) + (i1 ^ arrayOfInt[(i & 0x3 ^ n)]) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
          paramArrayOfInt1[i] = k;
          i -= 1;
        }
        int i1 = paramArrayOfInt1[m];
        i = paramArrayOfInt1[0] - ((arrayOfInt[(i & 0x3 ^ n)] ^ i1) + (k ^ j) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
        paramArrayOfInt1[0] = i;
        j += 1640531527;
      }
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = a();
    if (this.a != null) {
      try
      {
        byte[] arrayOfByte2 = a(paramArrayOfByte, a(this.a, arrayOfByte1));
        byte[] arrayOfByte4 = new byte[arrayOfByte2.length + 8];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte4, 0, arrayOfByte2.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte4, arrayOfByte2.length, 8);
        return arrayOfByte4;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    byte[] arrayOfByte3 = new byte[paramArrayOfByte.length + 8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte3, 0, paramArrayOfByte.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, paramArrayOfByte.length, 8);
    return arrayOfByte3;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[8];
    System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 8, arrayOfByte1, 0, 8);
    try
    {
      if (this.a != null)
      {
        byte[] arrayOfByte3 = new byte[paramArrayOfByte.length - 8];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte3, 0, paramArrayOfByte.length - 8);
        arrayOfByte1 = b(arrayOfByte3, a(this.a, arrayOfByte1));
        return arrayOfByte1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - 8];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 0, paramArrayOfByte.length - 8);
      return arrayOfByte2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBSecurity
 * JD-Core Version:    0.7.0.1
 */