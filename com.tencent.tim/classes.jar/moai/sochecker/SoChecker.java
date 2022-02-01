package moai.sochecker;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import moai.log.MLog;
import moai.log.SimpleMLog;

public final class SoChecker
{
  private static final String DEFAULT_INI_FILENAME = "soinfo.ini";
  public static final int ERR_INI_DATA = 3;
  public static final int ERR_OPEN_INI = 1;
  public static final int ERR_READ_INI = 2;
  public static final int ERR_VERSION_CODE = 4;
  public static final int SUCC = 0;
  private static final String TAG = "SoChecker";
  @NonNull
  private final Context context;
  @NonNull
  private final String expectedIniVersion;
  private HashMap<String, ArrayList<Info>> infoMap;
  @NonNull
  private final String iniFileName;
  private String iniVersion;
  @NonNull
  private MLog logger = new SimpleMLog();
  
  public SoChecker(Context paramContext, String paramString)
  {
    this(paramContext, paramString, "soinfo.ini");
  }
  
  SoChecker(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException(String.format("context[%s], iniVersion[%s], iniFileName[%s]", new Object[] { paramContext, paramString1, paramString2 }));
    }
    this.context = paramContext;
    this.expectedIniVersion = paramString1;
    this.iniFileName = paramString2;
  }
  
  /* Error */
  private String crc32(String paramString)
  {
    // Byte code:
    //   0: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 80	java/io/FileInputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore 5
    //   14: sipush 4096
    //   17: newarray byte
    //   19: astore 6
    //   21: new 83	java/util/zip/CRC32
    //   24: dup
    //   25: invokespecial 84	java/util/zip/CRC32:<init>	()V
    //   28: astore 7
    //   30: aload 5
    //   32: aload 6
    //   34: invokevirtual 90	java/io/InputStream:read	([B)I
    //   37: istore_2
    //   38: iload_2
    //   39: ifle +86 -> 125
    //   42: aload 7
    //   44: aload 6
    //   46: iconst_0
    //   47: iload_2
    //   48: invokevirtual 94	java/util/zip/CRC32:update	([BII)V
    //   51: goto -21 -> 30
    //   54: astore 6
    //   56: aload_0
    //   57: getfield 47	moai/sochecker/SoChecker:logger	Lmoai/log/MLog;
    //   60: ldc 22
    //   62: new 96	java/lang/StringBuilder
    //   65: dup
    //   66: ldc 98
    //   68: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: aload_1
    //   72: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: aload 6
    //   80: invokeinterface 113 4 0
    //   85: aload 5
    //   87: invokevirtual 116	java/io/InputStream:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: astore 5
    //   94: aload_0
    //   95: getfield 47	moai/sochecker/SoChecker:logger	Lmoai/log/MLog;
    //   98: ldc 22
    //   100: new 96	java/lang/StringBuilder
    //   103: dup
    //   104: ldc 98
    //   106: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: aload 5
    //   118: invokeinterface 113 4 0
    //   123: aconst_null
    //   124: areturn
    //   125: ldc 118
    //   127: iconst_2
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   136: lload_3
    //   137: lsub
    //   138: invokestatic 124	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: aload_1
    //   145: aastore
    //   146: invokestatic 57	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   149: pop
    //   150: aload 7
    //   152: invokevirtual 127	java/util/zip/CRC32:getValue	()J
    //   155: invokestatic 130	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   158: astore 6
    //   160: aload 5
    //   162: invokevirtual 116	java/io/InputStream:close	()V
    //   165: aload 6
    //   167: areturn
    //   168: astore_1
    //   169: aload 6
    //   171: areturn
    //   172: astore_1
    //   173: aload 5
    //   175: invokevirtual 116	java/io/InputStream:close	()V
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: aconst_null
    //   182: areturn
    //   183: astore 5
    //   185: goto -7 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	SoChecker
    //   0	188	1	paramString	String
    //   37	11	2	i	int
    //   3	134	3	l	long
    //   12	74	5	localFileInputStream	java.io.FileInputStream
    //   92	82	5	localFileNotFoundException	java.io.FileNotFoundException
    //   183	1	5	localIOException1	java.io.IOException
    //   19	26	6	arrayOfByte	byte[]
    //   54	25	6	localIOException2	java.io.IOException
    //   158	12	6	str	String
    //   28	123	7	localCRC32	java.util.zip.CRC32
    // Exception table:
    //   from	to	target	type
    //   14	30	54	java/io/IOException
    //   30	38	54	java/io/IOException
    //   42	51	54	java/io/IOException
    //   125	160	54	java/io/IOException
    //   4	14	92	java/io/FileNotFoundException
    //   160	165	168	java/io/IOException
    //   14	30	172	finally
    //   30	38	172	finally
    //   42	51	172	finally
    //   56	85	172	finally
    //   125	160	172	finally
    //   85	90	180	java/io/IOException
    //   173	178	183	java/io/IOException
  }
  
  private boolean isEnabled()
  {
    int j = readIni();
    int i = j;
    if (j == 0)
    {
      if (this.expectedIniVersion.equals(this.iniVersion)) {
        return true;
      }
      i = 4;
    }
    this.logger.w("SoChecker", "isEnabled: " + i);
    return false;
  }
  
  /* Error */
  private int readIni()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 152	moai/sochecker/SoChecker:infoMap	Ljava/util/HashMap;
    //   4: ifnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: new 154	java/util/HashMap
    //   13: dup
    //   14: invokespecial 155	java/util/HashMap:<init>	()V
    //   17: putfield 152	moai/sochecker/SoChecker:infoMap	Ljava/util/HashMap;
    //   20: new 157	java/io/BufferedReader
    //   23: dup
    //   24: new 159	java/io/InputStreamReader
    //   27: dup
    //   28: aload_0
    //   29: getfield 62	moai/sochecker/SoChecker:context	Landroid/content/Context;
    //   32: invokevirtual 165	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   35: aload_0
    //   36: getfield 66	moai/sochecker/SoChecker:iniFileName	Ljava/lang/String;
    //   39: invokevirtual 171	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   42: invokespecial 174	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   45: invokespecial 177	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_3
    //   49: aload_0
    //   50: aload_3
    //   51: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: putfield 138	moai/sochecker/SoChecker:iniVersion	Ljava/lang/String;
    //   57: aload_0
    //   58: getfield 138	moai/sochecker/SoChecker:iniVersion	Ljava/lang/String;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnonnull +66 -> 129
    //   66: aload_3
    //   67: invokevirtual 181	java/io/BufferedReader:close	()V
    //   70: iconst_3
    //   71: ireturn
    //   72: astore_1
    //   73: iconst_1
    //   74: ireturn
    //   75: aload_0
    //   76: getfield 152	moai/sochecker/SoChecker:infoMap	Ljava/util/HashMap;
    //   79: aload 4
    //   81: invokevirtual 185	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 187	java/util/ArrayList
    //   87: astore_2
    //   88: aload_2
    //   89: astore_1
    //   90: aload_2
    //   91: ifnonnull +22 -> 113
    //   94: new 187	java/util/ArrayList
    //   97: dup
    //   98: invokespecial 188	java/util/ArrayList:<init>	()V
    //   101: astore_1
    //   102: aload_0
    //   103: getfield 152	moai/sochecker/SoChecker:infoMap	Ljava/util/HashMap;
    //   106: aload 4
    //   108: aload_1
    //   109: invokevirtual 192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: aload_1
    //   114: new 194	moai/sochecker/Info
    //   117: dup
    //   118: aload 5
    //   120: aload 6
    //   122: invokespecial 196	moai/sochecker/Info:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: invokevirtual 199	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   128: pop
    //   129: aload_3
    //   130: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   133: astore 4
    //   135: aload 4
    //   137: ifnull +31 -> 168
    //   140: aload_3
    //   141: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   144: astore 5
    //   146: aload_3
    //   147: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   150: astore 6
    //   152: aload 5
    //   154: ifnull +8 -> 162
    //   157: aload 6
    //   159: ifnonnull -84 -> 75
    //   162: aload_3
    //   163: invokevirtual 181	java/io/BufferedReader:close	()V
    //   166: iconst_3
    //   167: ireturn
    //   168: aload_3
    //   169: invokevirtual 181	java/io/BufferedReader:close	()V
    //   172: iconst_0
    //   173: ireturn
    //   174: astore_1
    //   175: aload_3
    //   176: invokevirtual 181	java/io/BufferedReader:close	()V
    //   179: iconst_2
    //   180: ireturn
    //   181: astore_1
    //   182: aload_3
    //   183: invokevirtual 181	java/io/BufferedReader:close	()V
    //   186: aload_1
    //   187: athrow
    //   188: astore_1
    //   189: goto -119 -> 70
    //   192: astore_1
    //   193: goto -27 -> 166
    //   196: astore_1
    //   197: goto -25 -> 172
    //   200: astore_1
    //   201: goto -22 -> 179
    //   204: astore_2
    //   205: goto -19 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	SoChecker
    //   61	2	1	str1	String
    //   72	1	1	localIOException1	java.io.IOException
    //   89	25	1	localObject1	Object
    //   174	1	1	localIOException2	java.io.IOException
    //   181	6	1	localObject2	Object
    //   188	1	1	localIOException3	java.io.IOException
    //   192	1	1	localIOException4	java.io.IOException
    //   196	1	1	localIOException5	java.io.IOException
    //   200	1	1	localIOException6	java.io.IOException
    //   87	4	2	localArrayList	ArrayList
    //   204	1	2	localIOException7	java.io.IOException
    //   48	135	3	localBufferedReader	java.io.BufferedReader
    //   79	57	4	localObject3	Object
    //   118	35	5	str2	String
    //   120	38	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   20	49	72	java/io/IOException
    //   49	62	174	java/io/IOException
    //   75	88	174	java/io/IOException
    //   94	113	174	java/io/IOException
    //   113	129	174	java/io/IOException
    //   129	135	174	java/io/IOException
    //   140	152	174	java/io/IOException
    //   49	62	181	finally
    //   75	88	181	finally
    //   94	113	181	finally
    //   113	129	181	finally
    //   129	135	181	finally
    //   140	152	181	finally
    //   66	70	188	java/io/IOException
    //   162	166	192	java/io/IOException
    //   168	172	196	java/io/IOException
    //   175	179	200	java/io/IOException
    //   182	186	204	java/io/IOException
  }
  
  public static String[] validateLib(Context paramContext, String paramString)
    throws SoCheckerException
  {
    return new SoChecker(paramContext, paramString).validateLib();
  }
  
  public final void setLogger(MLog paramMLog)
  {
    Object localObject = paramMLog;
    if (paramMLog == null) {
      localObject = new SimpleMLog();
    }
    this.logger = ((MLog)localObject);
  }
  
  public final boolean validate(String paramString)
  {
    if (!isEnabled()) {
      return true;
    }
    Object localObject = new File(paramString);
    String str = ((File)localObject).getName();
    if (!((File)localObject).isFile())
    {
      this.logger.w("SoChecker", "validate file is not file");
      return false;
    }
    localObject = (ArrayList)this.infoMap.get(str);
    if (localObject == null) {
      this.logger.w("SoChecker", "validate no expected path:" + paramString);
    }
    for (;;)
    {
      return true;
      str = crc32(paramString);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((Info)localIterator.next()).crc32.equals(str));
      for (int i = 1; i == 0; i = 0)
      {
        this.logger.w("SoChecker", String.format("validate diff ex[%s],act[%s], path[%s]", new Object[] { localObject, str, paramString }));
        return false;
      }
    }
  }
  
  public final String[] validateDir(String paramString)
  {
    if (!isEnabled()) {
      return new String[0];
    }
    Object localObject1 = new File(paramString);
    if (!((File)localObject1).isDirectory()) {
      return new String[0];
    }
    paramString = new ArrayList();
    localObject1 = ((File)localObject1).listFiles();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (!validate(localObject2.getAbsolutePath())) {
        paramString.add(localObject2.getAbsolutePath());
      }
      i += 1;
    }
    return (String[])paramString.toArray(new String[0]);
  }
  
  public final String[] validateLib()
    throws SoCheckerException
  {
    if (!isEnabled()) {
      return null;
    }
    ClassLoader localClassLoader = SoChecker.class.getClassLoader();
    ArrayList localArrayList;
    for (;;)
    {
      String str2;
      try
      {
        localMethod = localClassLoader.getClass().getMethod("findLibrary", new Class[] { String.class });
        localMethod.setAccessible(true);
        localArrayList = new ArrayList();
        localIterator = this.infoMap.keySet().iterator();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          Method localMethod;
          Iterator localIterator;
          str2 = (String)localMethod.invoke(localClassLoader, new Object[] { str1.substring(3, str1.length() - 3) });
          String.format("soName[%s], path[%s]", new Object[] { str1, str2 });
          if ((str2 != null) && (str2.length() != 0)) {
            break label178;
          }
          localArrayList.add(str1);
        }
        catch (Exception localException)
        {
          throw new SoCheckerException(localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        throw new SoCheckerException(localNoSuchMethodException);
      }
      if (!localIterator.hasNext()) {
        break;
      }
      String str1 = (String)localIterator.next();
      label178:
      if (!validate(str2)) {
        localArrayList.add(str1);
      }
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.sochecker.SoChecker
 * JD-Core Version:    0.7.0.1
 */