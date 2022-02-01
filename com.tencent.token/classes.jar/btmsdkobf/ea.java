package btmsdkobf;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.token.ro;
import java.net.NetworkInterface;

public class ea
{
  private static final String DEFAULT_MAC = "02:00:00:00:00:00";
  private static final String TAG = "ea";
  
  private static String getMacByAPI(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = NetworkInterface.getByName(paramString);
        if (paramString != null)
        {
          paramString = paramString.getHardwareAddress();
          if (paramString != null)
          {
            if (paramString.length == 0) {
              return null;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            int j = paramString.length;
            int i = 0;
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
          return null;
        }
      }
      catch (Throwable paramString)
      {
        return null;
      }
      paramString = null;
    }
  }
  
  private static String getMacFromFile(String paramString)
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = loadFile(String.format("/sys/class/net/%s/address", new Object[] { paramString }));
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
    if (!ro.a().b()) {
      return "02:00:00:00:00:00";
    }
    localObject2 = null;
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null) {
        break label107;
      }
      paramContext = paramContext.getConnectionInfo();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        continue;
        paramContext = null;
      }
    }
    localObject1 = localObject2;
    if (paramContext != null) {
      localObject1 = paramContext.getMacAddress();
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"02:00:00:00:00:00".equals(localObject1))) {
      return localObject1;
    }
    paramContext = getMacByAPI("wlan0");
    if ((!TextUtils.isEmpty(paramContext)) && (!"02:00:00:00:00:00".equals(paramContext))) {
      return paramContext;
    }
    return getMacFromFile("wlan0");
  }
  
  /* Error */
  private static byte[] loadFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 125	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 128	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: new 130	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: aload_0
    //   19: invokevirtual 133	java/io/FileInputStream:available	()I
    //   22: invokespecial 136	java/io/ByteArrayOutputStream:<init>	(I)V
    //   25: astore_2
    //   26: sipush 1024
    //   29: newarray byte
    //   31: astore 4
    //   33: aload_0
    //   34: aload 4
    //   36: invokevirtual 140	java/io/FileInputStream:read	([B)I
    //   39: istore_1
    //   40: iload_1
    //   41: ifle +14 -> 55
    //   44: aload_2
    //   45: aload 4
    //   47: iconst_0
    //   48: iload_1
    //   49: invokevirtual 144	java/io/ByteArrayOutputStream:write	([BII)V
    //   52: goto -19 -> 33
    //   55: aload_2
    //   56: invokevirtual 147	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   59: astore 4
    //   61: aload_2
    //   62: invokevirtual 150	java/io/ByteArrayOutputStream:close	()V
    //   65: aload 4
    //   67: astore_2
    //   68: aload_0
    //   69: invokevirtual 151	java/io/FileInputStream:close	()V
    //   72: aload_2
    //   73: areturn
    //   74: astore 4
    //   76: aload_2
    //   77: astore_3
    //   78: aload_0
    //   79: astore_2
    //   80: aload 4
    //   82: astore_0
    //   83: goto +30 -> 113
    //   86: goto +52 -> 138
    //   89: astore 5
    //   91: aload 4
    //   93: astore_3
    //   94: aload_0
    //   95: astore_2
    //   96: aload 5
    //   98: astore_0
    //   99: goto +14 -> 113
    //   102: aconst_null
    //   103: astore_2
    //   104: goto +34 -> 138
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_2
    //   110: aload 4
    //   112: astore_3
    //   113: aload_3
    //   114: ifnull +10 -> 124
    //   117: aload_3
    //   118: invokevirtual 150	java/io/ByteArrayOutputStream:close	()V
    //   121: goto +3 -> 124
    //   124: aload_2
    //   125: ifnull +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 151	java/io/FileInputStream:close	()V
    //   132: aload_0
    //   133: athrow
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: astore_0
    //   138: aload_2
    //   139: ifnull +10 -> 149
    //   142: aload_2
    //   143: invokevirtual 150	java/io/ByteArrayOutputStream:close	()V
    //   146: goto +3 -> 149
    //   149: aload_0
    //   150: ifnull +8 -> 158
    //   153: aload_3
    //   154: astore_2
    //   155: goto -87 -> 68
    //   158: aconst_null
    //   159: areturn
    //   160: astore_0
    //   161: goto -27 -> 134
    //   164: astore_2
    //   165: goto -63 -> 102
    //   168: astore 4
    //   170: goto -84 -> 86
    //   173: astore_2
    //   174: aload 4
    //   176: astore_2
    //   177: goto -109 -> 68
    //   180: astore_0
    //   181: aload_2
    //   182: areturn
    //   183: astore_3
    //   184: goto -60 -> 124
    //   187: astore_2
    //   188: goto -56 -> 132
    //   191: astore_2
    //   192: goto -43 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramString	String
    //   39	10	1	i	int
    //   25	130	2	localObject1	Object
    //   164	1	2	localThrowable1	Throwable
    //   173	1	2	localThrowable2	Throwable
    //   176	6	2	localThrowable3	Throwable
    //   187	1	2	localThrowable4	Throwable
    //   191	1	2	localThrowable5	Throwable
    //   4	150	3	localObject2	Object
    //   183	1	3	localThrowable6	Throwable
    //   1	65	4	arrayOfByte	byte[]
    //   74	37	4	localObject3	Object
    //   168	7	4	localThrowable7	Throwable
    //   89	8	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   26	33	74	finally
    //   33	40	74	finally
    //   44	52	74	finally
    //   55	61	74	finally
    //   14	26	89	finally
    //   5	14	107	finally
    //   5	14	160	java/lang/Throwable
    //   14	26	164	java/lang/Throwable
    //   26	33	168	java/lang/Throwable
    //   33	40	168	java/lang/Throwable
    //   44	52	168	java/lang/Throwable
    //   55	61	168	java/lang/Throwable
    //   61	65	173	java/lang/Throwable
    //   68	72	180	java/lang/Throwable
    //   117	121	183	java/lang/Throwable
    //   128	132	187	java/lang/Throwable
    //   142	146	191	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ea
 * JD-Core Version:    0.7.0.1
 */