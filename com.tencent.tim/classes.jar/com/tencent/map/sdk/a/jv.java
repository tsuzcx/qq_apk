package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

public class jv
{
  public static ConcurrentHashMap<String, fw[]> a = new ConcurrentHashMap();
  private static volatile jv f;
  public String b = null;
  public String c = null;
  public boolean d = false;
  public AtomicInteger e = new AtomicInteger(0);
  private ReentrantReadWriteLock g = new ReentrantReadWriteLock();
  
  public static jv a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new jv();
      }
      return f;
    }
    finally {}
  }
  
  public static boolean a(fw paramfw, fw[] paramArrayOffw)
  {
    boolean bool;
    if ((paramArrayOffw == null) || (paramArrayOffw.length < 3)) {
      bool = false;
    }
    int i;
    int k;
    int j;
    do
    {
      return bool;
      i = paramArrayOffw.length;
      k = 0;
      j = i - 1;
      i = 0;
      bool = k;
    } while (i >= paramArrayOffw.length);
    if (((paramArrayOffw[i].a < paramfw.a) && (paramArrayOffw[j].a >= paramfw.a)) || ((paramArrayOffw[j].a < paramfw.a) && (paramArrayOffw[i].a >= paramfw.a) && ((paramArrayOffw[i].b <= paramfw.b) || (paramArrayOffw[j].b <= paramfw.b)))) {
      if (paramArrayOffw[i].b + (paramfw.a - paramArrayOffw[i].a) / (paramArrayOffw[j].a - paramArrayOffw[i].a) * (paramArrayOffw[j].b - paramArrayOffw[i].b) < paramfw.b)
      {
        j = 1;
        label178:
        k ^= j;
      }
    }
    for (;;)
    {
      j = i;
      i += 1;
      break;
      j = 0;
      break label178;
    }
  }
  
  public static boolean a(fw[] paramArrayOffw1, fw[] paramArrayOffw2)
  {
    boolean bool2 = false;
    int m = paramArrayOffw1.length;
    int i = 0;
    int j = 0;
    if (i < m)
    {
      j |= a(paramArrayOffw1[i], paramArrayOffw2);
      if (j == 0) {}
    }
    for (i = 1;; i = 0)
    {
      int n = paramArrayOffw2.length;
      j = 0;
      m = 0;
      boolean bool1 = false;
      for (;;)
      {
        if (j < n)
        {
          bool1 |= a(paramArrayOffw2[j], paramArrayOffw1);
          if (bool1) {
            m = 1;
          }
          int k;
          j += 1;
          continue;
          i += 1;
          break;
        }
      }
      if ((i != 0) || (m != 0)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public static int b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localIterator = paramString.keys();
      i = 0;
    }
    catch (Throwable paramString)
    {
      try
      {
        Iterator localIterator;
        int i;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ("version".equals(str))
          {
            i = paramString.optInt(str);
          }
          else
          {
            fw[] arrayOffw = c(paramString.optString(str));
            i = j;
            if (arrayOffw != null)
            {
              a.put(str, arrayOffw);
              i = j;
            }
          }
        }
        if (!a.containsKey("china"))
        {
          paramString = c("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.959229,21.677848:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
          if (paramString != null) {
            a.put("china", paramString);
          }
        }
        if (!a.containsKey("inland"))
        {
          paramString = c("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
          if (paramString != null) {
            a.put("inland", paramString);
          }
        }
        if (!a.containsKey("taiwan"))
        {
          paramString = c("121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:121.959229,21.677848");
          if (paramString != null) {
            a.put("taiwan", paramString);
          }
        }
        return j;
      }
      catch (Throwable paramString) {}
      paramString = paramString;
      return 0;
    }
    int j = i;
    return j;
  }
  
  public static fw[] c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return null;
      paramString = paramString.split(":");
    } while (paramString.length == 0);
    fw[] arrayOffw = new fw[paramString.length];
    int i = 0;
    while (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split(",");
      arrayOffw[i] = kd.b(new GeoPoint((int)(Double.parseDouble(arrayOfString[1]) * 1000000.0D), (int)(Double.parseDouble(arrayOfString[0]) * 1000000.0D)));
      i += 1;
    }
    return arrayOffw;
  }
  
  public static fw[] d(String paramString)
  {
    return (fw[])a.get(paramString);
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   13: invokevirtual 167	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   16: new 169	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: getfield 36	com/tencent/map/sdk/a/jv:b	Ljava/lang/String;
    //   24: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 6
    //   29: new 169	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: getfield 38	com/tencent/map/sdk/a/jv:c	Ljava/lang/String;
    //   37: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore 7
    //   42: aload 7
    //   44: invokevirtual 173	java/io/File:exists	()Z
    //   47: ifeq +18 -> 65
    //   50: aload 7
    //   52: invokevirtual 176	java/io/File:delete	()Z
    //   55: ifne +10 -> 65
    //   58: aload 7
    //   60: invokevirtual 179	java/io/File:deleteOnExit	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: aload 6
    //   67: invokevirtual 173	java/io/File:exists	()Z
    //   70: ifeq +39 -> 109
    //   73: aload 6
    //   75: aload 7
    //   77: invokevirtual 183	java/io/File:renameTo	(Ljava/io/File;)Z
    //   80: istore_2
    //   81: iload_2
    //   82: ifne +27 -> 109
    //   85: aconst_null
    //   86: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   89: aload 7
    //   91: aload 6
    //   93: invokevirtual 183	java/io/File:renameTo	(Ljava/io/File;)Z
    //   96: pop
    //   97: aload_0
    //   98: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   101: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   104: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   107: iconst_0
    //   108: ireturn
    //   109: new 193	java/io/FileOutputStream
    //   112: dup
    //   113: aload 6
    //   115: invokespecial 196	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   118: astore_3
    //   119: aload_3
    //   120: aload_1
    //   121: ldc 198
    //   123: invokevirtual 202	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   126: invokevirtual 206	java/io/FileOutputStream:write	([B)V
    //   129: aload_3
    //   130: invokevirtual 209	java/io/FileOutputStream:flush	()V
    //   133: aload_3
    //   134: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   137: aload 7
    //   139: invokevirtual 176	java/io/File:delete	()Z
    //   142: pop
    //   143: aload_0
    //   144: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   147: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   150: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   153: iconst_1
    //   154: ireturn
    //   155: astore_1
    //   156: aload 4
    //   158: astore_1
    //   159: aload_1
    //   160: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   163: aload 7
    //   165: aload 6
    //   167: invokevirtual 183	java/io/File:renameTo	(Ljava/io/File;)Z
    //   170: pop
    //   171: aload_0
    //   172: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   175: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   178: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_1
    //   184: aload 5
    //   186: astore_3
    //   187: aload_3
    //   188: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   191: aload 7
    //   193: aload 6
    //   195: invokevirtual 183	java/io/File:renameTo	(Ljava/io/File;)Z
    //   198: pop
    //   199: aload_0
    //   200: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   203: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   206: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: goto -25 -> 187
    //   215: astore_1
    //   216: aload_3
    //   217: astore_1
    //   218: goto -59 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	jv
    //   0	221	1	paramString	String
    //   80	2	2	bool	boolean
    //   118	99	3	localObject1	Object
    //   4	153	4	localObject2	Object
    //   1	184	5	localObject3	Object
    //   27	167	6	localFile1	java.io.File
    //   40	152	7	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   65	81	155	java/lang/Throwable
    //   109	119	155	java/lang/Throwable
    //   65	81	183	finally
    //   109	119	183	finally
    //   119	133	211	finally
    //   119	133	215	java/lang/Throwable
  }
  
  /* Error */
  public final String b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   6: invokevirtual 214	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   9: invokevirtual 217	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   12: new 219	java/io/FileInputStream
    //   15: dup
    //   16: new 169	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: getfield 36	com/tencent/map/sdk/a/jv:b	Ljava/lang/String;
    //   24: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_1
    //   31: new 67	java/lang/String
    //   34: dup
    //   35: aload_1
    //   36: invokestatic 223	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;)[B
    //   39: ldc 198
    //   41: invokespecial 226	java/lang/String:<init>	([BLjava/lang/String;)V
    //   44: astore_2
    //   45: aload_1
    //   46: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   49: aload_0
    //   50: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   53: invokevirtual 214	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   56: invokevirtual 227	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   59: aload_2
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   68: aload_0
    //   69: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   72: invokevirtual 214	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   75: invokevirtual 227	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_1
    //   81: aload_2
    //   82: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   85: aload_0
    //   86: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   89: invokevirtual 214	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   92: invokevirtual 227	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_3
    //   98: aload_1
    //   99: astore_2
    //   100: aload_3
    //   101: astore_1
    //   102: goto -21 -> 81
    //   105: astore_2
    //   106: goto -42 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	jv
    //   30	16	1	localFileInputStream	java.io.FileInputStream
    //   61	1	1	localThrowable1	Throwable
    //   63	2	1	localCloseable	java.io.Closeable
    //   80	19	1	localObject1	Object
    //   101	1	1	localObject2	Object
    //   1	99	2	localObject3	Object
    //   105	1	2	localThrowable2	Throwable
    //   97	4	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   12	31	61	java/lang/Throwable
    //   12	31	80	finally
    //   31	45	97	finally
    //   31	45	105	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jv
 * JD-Core Version:    0.7.0.1
 */