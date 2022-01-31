package btmsdkobf;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.net.NetworkInterface;

public class ea
{
  /* Error */
  private static byte[] G(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 10	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 14	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: new 16	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: aload_3
    //   17: invokevirtual 20	java/io/FileInputStream:available	()I
    //   20: invokespecial 23	java/io/ByteArrayOutputStream:<init>	(I)V
    //   23: astore_2
    //   24: sipush 1024
    //   27: newarray byte
    //   29: astore_0
    //   30: aload_3
    //   31: aload_0
    //   32: invokevirtual 27	java/io/FileInputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle +40 -> 77
    //   40: aload_2
    //   41: aload_0
    //   42: iconst_0
    //   43: iload_1
    //   44: invokevirtual 31	java/io/ByteArrayOutputStream:write	([BII)V
    //   47: goto -17 -> 30
    //   50: astore_0
    //   51: aload_2
    //   52: astore_0
    //   53: aload_0
    //   54: ifnull +7 -> 61
    //   57: aload_0
    //   58: invokevirtual 35	java/io/ByteArrayOutputStream:close	()V
    //   61: aload 4
    //   63: astore_2
    //   64: aload_3
    //   65: ifnull +10 -> 75
    //   68: aload_3
    //   69: invokevirtual 36	java/io/FileInputStream:close	()V
    //   72: aload 4
    //   74: astore_2
    //   75: aload_2
    //   76: areturn
    //   77: aload_2
    //   78: invokevirtual 40	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: astore_0
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 35	java/io/ByteArrayOutputStream:close	()V
    //   90: aload_0
    //   91: astore_2
    //   92: aload_3
    //   93: ifnull -18 -> 75
    //   96: aload_3
    //   97: invokevirtual 36	java/io/FileInputStream:close	()V
    //   100: aload_0
    //   101: areturn
    //   102: astore_2
    //   103: aload_0
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 35	java/io/ByteArrayOutputStream:close	()V
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 36	java/io/FileInputStream:close	()V
    //   126: aload_0
    //   127: athrow
    //   128: astore_2
    //   129: goto -39 -> 90
    //   132: astore_0
    //   133: goto -72 -> 61
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_2
    //   140: goto -22 -> 118
    //   143: astore_2
    //   144: goto -18 -> 126
    //   147: astore_0
    //   148: aconst_null
    //   149: astore_2
    //   150: goto -40 -> 110
    //   153: astore_0
    //   154: goto -44 -> 110
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_3
    //   162: goto -109 -> 53
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_0
    //   168: goto -115 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramString	String
    //   35	9	1	i	int
    //   23	69	2	localObject1	Object
    //   102	1	2	localThrowable1	Throwable
    //   109	6	2	localObject2	Object
    //   128	1	2	localThrowable2	Throwable
    //   139	1	2	localThrowable3	Throwable
    //   143	1	2	localThrowable4	Throwable
    //   149	1	2	localObject3	Object
    //   11	151	3	localFileInputStream	java.io.FileInputStream
    //   1	72	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   24	30	50	java/lang/Throwable
    //   30	36	50	java/lang/Throwable
    //   40	47	50	java/lang/Throwable
    //   77	82	50	java/lang/Throwable
    //   96	100	102	java/lang/Throwable
    //   3	12	105	finally
    //   86	90	128	java/lang/Throwable
    //   57	61	132	java/lang/Throwable
    //   68	72	136	java/lang/Throwable
    //   114	118	139	java/lang/Throwable
    //   122	126	143	java/lang/Throwable
    //   12	24	147	finally
    //   24	30	153	finally
    //   30	36	153	finally
    //   40	47	153	finally
    //   77	82	153	finally
    //   3	12	157	java/lang/Throwable
    //   12	24	165	java/lang/Throwable
  }
  
  private static String I(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramString = NetworkInterface.getByName(paramString);
        if (paramString == null) {
          break label101;
        }
        paramString = paramString.getHardwareAddress();
        if (paramString != null)
        {
          if (paramString.length == 0) {
            return null;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          int j = paramString.length;
          if (i < j)
          {
            localStringBuilder.append(String.format("%02x:", new Object[] { Byte.valueOf(paramString[i]) }));
            i += 1;
            continue;
          }
          if (localStringBuilder.length() > 0) {
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          }
          paramString = localStringBuilder.toString();
          return paramString;
        }
      }
      catch (Throwable paramString) {}
      return null;
      label101:
      paramString = null;
    }
  }
  
  private static String J(String paramString)
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = G(String.format("/sys/class/net/%s/address", new Object[] { paramString }));
      paramString = localObject;
      if (arrayOfByte != null)
      {
        paramString = localObject;
        if (arrayOfByte.length > 0) {
          paramString = new String(arrayOfByte).trim();
        }
      }
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static String j(Context paramContext)
  {
    String str = null;
    if (paramContext == null) {
      paramContext = str;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getConnectionInfo();
          if (paramContext == null) {
            break label61;
          }
        }
        label61:
        for (paramContext = paramContext.getMacAddress();; paramContext = null)
        {
          if ((TextUtils.isEmpty(paramContext)) || ("02:00:00:00:00:00".equals(paramContext))) {
            break label72;
          }
          return paramContext;
          paramContext = null;
          break;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
        label72:
        str = I("wlan0");
        if (!TextUtils.isEmpty(str))
        {
          paramContext = str;
          if (!"02:00:00:00:00:00".equals(str)) {
            continue;
          }
        }
      }
    }
    return J("wlan0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ea
 * JD-Core Version:    0.7.0.1
 */