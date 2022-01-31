package tmsdkdual;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tmsdk.dual.TMSDualSDKContext;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class n
{
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    if (paramString1 != null)
    {
      String[] arrayOfString = paramString1.split("&");
      int k = arrayOfString.length;
      int i = 0;
      while (i < k)
      {
        paramString1 = arrayOfString[i].split(",");
        if ((paramString1 != null) && (paramString1.length == 2))
        {
          Object localObject2 = paramString1[0];
          Object localObject3 = paramString1[1];
          Object localObject1 = (List)localHashMap.get(localObject2);
          paramString1 = (String)localObject1;
          if (localObject1 == null) {
            paramString1 = new ArrayList();
          }
          localObject1 = localObject3.split("-");
          if (localObject1 != null)
          {
            int m = localObject1.length;
            int j = 0;
            while (j < m)
            {
              paramString1.add(localObject1[j]);
              j += 1;
            }
          }
          localHashMap.put(localObject2, paramString1);
        }
        i += 1;
      }
    }
    paramString4 = (List)localHashMap.get(paramString3 + "#" + paramString4);
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = (List)localHashMap.get(paramString3 + "#all");
    }
    paramString3 = paramString1;
    if (paramString1 == null) {
      paramString3 = (List)localHashMap.get("all#all");
    }
    if (paramString3 != null)
    {
      paramString1 = paramString3.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.contains((String)paramString1.next())) {
          return false;
        }
      }
    }
    return true;
  }
  
  /* Error */
  public static String b(String paramString, int paramInt)
    throws java.net.UnknownHostException, Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 91	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 94	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 98	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 100	java/net/HttpURLConnection
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 102
    //   21: invokevirtual 105	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: iload_1
    //   26: invokevirtual 109	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   29: aload_0
    //   30: iload_1
    //   31: invokevirtual 112	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   34: aload_0
    //   35: invokevirtual 116	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   38: astore_2
    //   39: new 118	java/io/BufferedReader
    //   42: dup
    //   43: new 120	java/io/InputStreamReader
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 123	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   51: invokespecial 126	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore 5
    //   56: new 47	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   63: astore_3
    //   64: aload 5
    //   66: invokevirtual 129	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore 4
    //   71: aload 4
    //   73: ifnull +54 -> 127
    //   76: aload_3
    //   77: aload 4
    //   79: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: goto -19 -> 64
    //   86: astore 4
    //   88: aload_0
    //   89: astore_3
    //   90: aload 4
    //   92: astore_0
    //   93: aload_2
    //   94: astore 4
    //   96: aload 5
    //   98: astore_2
    //   99: aload_2
    //   100: ifnull +7 -> 107
    //   103: aload_2
    //   104: invokevirtual 132	java/io/BufferedReader:close	()V
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 135	java/io/InputStream:close	()V
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   125: aload_0
    //   126: athrow
    //   127: aload_3
    //   128: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore_3
    //   132: aload 5
    //   134: ifnull +8 -> 142
    //   137: aload 5
    //   139: invokevirtual 132	java/io/BufferedReader:close	()V
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 135	java/io/InputStream:close	()V
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   158: aload_3
    //   159: areturn
    //   160: astore 4
    //   162: aload 4
    //   164: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   167: goto -25 -> 142
    //   170: astore_2
    //   171: aload_2
    //   172: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   175: goto -25 -> 150
    //   178: astore_2
    //   179: aload_2
    //   180: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   183: goto -76 -> 107
    //   186: astore_2
    //   187: aload_2
    //   188: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   191: goto -74 -> 117
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_3
    //   199: goto -100 -> 99
    //   202: astore_2
    //   203: aload_0
    //   204: astore_3
    //   205: aload_2
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_2
    //   209: goto -110 -> 99
    //   212: astore 4
    //   214: aload_0
    //   215: astore_3
    //   216: aload 4
    //   218: astore_0
    //   219: aconst_null
    //   220: astore 5
    //   222: aload_2
    //   223: astore 4
    //   225: aload 5
    //   227: astore_2
    //   228: goto -129 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString	String
    //   0	231	1	paramInt	int
    //   38	109	2	localObject1	Object
    //   170	2	2	localIOException1	java.io.IOException
    //   178	2	2	localIOException2	java.io.IOException
    //   186	2	2	localIOException3	java.io.IOException
    //   196	1	2	localObject2	Object
    //   202	4	2	localObject3	Object
    //   208	20	2	localObject4	Object
    //   63	153	3	localObject5	Object
    //   1	77	4	str	String
    //   86	5	4	localObject6	Object
    //   94	19	4	localObject7	Object
    //   160	3	4	localIOException4	java.io.IOException
    //   212	5	4	localObject8	Object
    //   223	1	4	localObject9	Object
    //   54	172	5	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   56	64	86	finally
    //   64	71	86	finally
    //   76	83	86	finally
    //   127	132	86	finally
    //   137	142	160	java/io/IOException
    //   146	150	170	java/io/IOException
    //   103	107	178	java/io/IOException
    //   112	117	186	java/io/IOException
    //   3	18	194	finally
    //   18	39	202	finally
    //   39	56	212	finally
  }
  
  /* Error */
  private static boolean f(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 47	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   9: ldc 146
    //   11: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 152	tmsdkdual/l:e	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 4
    //   26: ldc 154
    //   28: invokestatic 160	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   31: astore_3
    //   32: aload_3
    //   33: aload 4
    //   35: invokevirtual 164	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   38: astore 5
    //   40: aload 4
    //   42: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +118 -> 163
    //   48: aload 5
    //   50: invokevirtual 174	java/util/regex/Matcher:find	()Z
    //   53: ifne +6 -> 59
    //   56: goto +107 -> 163
    //   59: aload 5
    //   61: invokevirtual 177	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   64: astore 4
    //   66: ldc 179
    //   68: sipush 10000
    //   71: invokestatic 181	tmsdkdual/n:b	(Ljava/lang/String;I)Ljava/lang/String;
    //   74: pop
    //   75: aload_3
    //   76: new 47	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   83: ldc 146
    //   85: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_0
    //   89: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 152	tmsdkdual/l:e	(Ljava/lang/String;)Ljava/lang/String;
    //   98: invokevirtual 164	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   101: astore_0
    //   102: iload_2
    //   103: istore_1
    //   104: aload_0
    //   105: invokevirtual 174	java/util/regex/Matcher:find	()Z
    //   108: ifeq +57 -> 165
    //   111: aload_0
    //   112: invokevirtual 177	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   115: astore_0
    //   116: iload_2
    //   117: istore_1
    //   118: aload 4
    //   120: ifnull +45 -> 165
    //   123: iload_2
    //   124: istore_1
    //   125: aload 4
    //   127: aload_0
    //   128: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifne +34 -> 165
    //   134: iconst_1
    //   135: ireturn
    //   136: astore 5
    //   138: aload 5
    //   140: invokevirtual 185	java/net/UnknownHostException:printStackTrace	()V
    //   143: goto -68 -> 75
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   151: iconst_0
    //   152: ireturn
    //   153: astore 5
    //   155: aload 5
    //   157: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   160: goto -85 -> 75
    //   163: iconst_1
    //   164: istore_1
    //   165: iload_1
    //   166: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramString	String
    //   103	63	1	bool1	boolean
    //   1	123	2	bool2	boolean
    //   31	45	3	localPattern	java.util.regex.Pattern
    //   24	102	4	str	String
    //   38	22	5	localMatcher	java.util.regex.Matcher
    //   136	3	5	localUnknownHostException	java.net.UnknownHostException
    //   153	3	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   66	75	136	java/net/UnknownHostException
    //   2	56	146	java/lang/Exception
    //   59	66	146	java/lang/Exception
    //   75	102	146	java/lang/Exception
    //   104	116	146	java/lang/Exception
    //   125	134	146	java/lang/Exception
    //   138	143	146	java/lang/Exception
    //   155	160	146	java/lang/Exception
    //   66	75	153	java/lang/Exception
  }
  
  public static String getLocalIp()
  {
    Object localObject = u();
    if (((List)localObject).size() == 1) {
      return ((a)((List)localObject).get(0)).ae;
    }
    if (((List)localObject).size() > 1)
    {
      String str1 = l.r();
      String str2 = l.s();
      String str3 = a.b().g.getString("NET_GET_PHONE_FILTER_IPS", null);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        if (f(locala.name)) {
          if (str3 == null)
          {
            if (("Xiaomi".equals(str1)) && (locala.name != null) && (locala.name.contains("usbnet"))) {}
          }
          else {
            while ((str3 == null) || (a(str3, locala.name, str1, str2))) {
              return locala.ae;
            }
          }
        }
      }
    }
    return null;
  }
  
  public static String getNetworkName()
  {
    try
    {
      Object localObject = ((ConnectivityManager)TMSDualSDKContext.getApplicaionContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 0))
      {
        localObject = ((NetworkInfo)localObject).getExtraInfo();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      m.a("NetworkUtil", localThrowable);
    }
    return null;
  }
  
  public static boolean t()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)TMSDualSDKContext.getApplicaionContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int i = localNetworkInfo.getType();
        if (i == 0) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      m.a("NetworkUtil", localThrowable);
    }
    return false;
  }
  
  public static List<a> u()
  {
    localArrayList = new ArrayList();
    try
    {
      Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      while (localEnumeration1.hasMoreElements())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration1.nextElement();
        Enumeration localEnumeration2 = localNetworkInterface.getInetAddresses();
        while (localEnumeration2.hasMoreElements())
        {
          InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
          m.b("NetworkUtil", "find ip:" + localInetAddress.getHostAddress().toString());
          if ((!localInetAddress.isLoopbackAddress()) && ((localInetAddress instanceof Inet4Address)) && (!localInetAddress.isAnyLocalAddress()) && (!localInetAddress.isLinkLocalAddress()) && (!localInetAddress.isMulticastAddress()))
          {
            m.b("NetworkUtil", "-legal ip:" + localInetAddress.getHostAddress().toString());
            localArrayList.add(new a(localInetAddress.getHostAddress().toString(), localNetworkInterface.getName()));
          }
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      m.a("getLocalIpAddress", localException.toString());
    }
  }
  
  public static class a
  {
    public String ae;
    public String name;
    
    public a(String paramString1, String paramString2)
    {
      this.ae = paramString1;
      this.name = paramString2;
    }
    
    public String toString()
    {
      return this.name + "," + this.ae;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.n
 * JD-Core Version:    0.7.0.1
 */