import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.util.HashMap;

public class avfs
{
  private static avfs a;
  private static String[] iK = { "qzone_plugin.apk", "qwallet_plugin.apk", "qqfav.apk", "qqwadl.apk", "dingdong_plugin.apk" };
  private Context mContext;
  private HashMap<String, PluginInfo> qv = new HashMap();
  
  private avfs(Context paramContext)
  {
    this.mContext = paramContext;
    init();
  }
  
  public static final avfs a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avfs(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public static boolean tm(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < iK.length)
      {
        if (paramString.equals(iK[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public PluginInfo a(String paramString)
  {
    return (PluginInfo)this.qv.get(paramString);
  }
  
  /* Error */
  void ezL()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 75	java/io/BufferedReader
    //   5: dup
    //   6: new 77	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: getfield 41	avfs:mContext	Landroid/content/Context;
    //   14: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: ldc 85
    //   19: invokevirtual 91	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: invokespecial 94	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 97	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 101	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +139 -> 174
    //   38: aload_2
    //   39: invokevirtual 104	java/lang/String:trim	()Ljava/lang/String;
    //   42: ldc 106
    //   44: invokevirtual 110	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   47: astore 4
    //   49: aload 4
    //   51: iconst_0
    //   52: aaload
    //   53: astore_3
    //   54: ldc 112
    //   56: astore_2
    //   57: aload 4
    //   59: arraylength
    //   60: iconst_1
    //   61: if_icmple +8 -> 69
    //   64: aload 4
    //   66: iconst_1
    //   67: aaload
    //   68: astore_2
    //   69: new 68	cooperation/plugin/PluginInfo
    //   72: dup
    //   73: invokespecial 113	cooperation/plugin/PluginInfo:<init>	()V
    //   76: astore 4
    //   78: aload 4
    //   80: aload_3
    //   81: putfield 117	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   84: aload 4
    //   86: aload_2
    //   87: putfield 120	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   90: aload 4
    //   92: iconst_1
    //   93: putfield 124	cooperation/plugin/PluginInfo:mUpdateType	I
    //   96: aload 4
    //   98: iconst_0
    //   99: putfield 127	cooperation/plugin/PluginInfo:mInstallType	I
    //   102: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +45 -> 150
    //   108: ldc 135
    //   110: iconst_2
    //   111: new 137	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   118: ldc 140
    //   120: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 4
    //   125: getfield 117	cooperation/plugin/PluginInfo:mID	Ljava/lang/String;
    //   128: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 146
    //   133: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload 4
    //   138: getfield 120	cooperation/plugin/PluginInfo:mMD5	Ljava/lang/String;
    //   141: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 39	avfs:qv	Ljava/util/HashMap;
    //   154: aload_3
    //   155: aload 4
    //   157: invokevirtual 157	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: goto -132 -> 29
    //   164: astore_2
    //   165: aload_1
    //   166: ifnull +7 -> 173
    //   169: aload_1
    //   170: invokevirtual 160	java/io/BufferedReader:close	()V
    //   173: return
    //   174: aload_1
    //   175: ifnull -2 -> 173
    //   178: aload_1
    //   179: invokevirtual 160	java/io/BufferedReader:close	()V
    //   182: return
    //   183: astore_1
    //   184: return
    //   185: astore_1
    //   186: aload_2
    //   187: ifnull +7 -> 194
    //   190: aload_2
    //   191: invokevirtual 160	java/io/BufferedReader:close	()V
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: return
    //   198: astore_2
    //   199: goto -5 -> 194
    //   202: astore_3
    //   203: aload_1
    //   204: astore_2
    //   205: aload_3
    //   206: astore_1
    //   207: goto -21 -> 186
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_1
    //   213: goto -48 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	avfs
    //   28	151	1	localBufferedReader	java.io.BufferedReader
    //   183	1	1	localException1	java.lang.Exception
    //   185	10	1	localObject1	Object
    //   196	8	1	localException2	java.lang.Exception
    //   206	1	1	localObject2	Object
    //   210	1	1	localIOException1	java.io.IOException
    //   212	1	1	localObject3	Object
    //   1	86	2	str	String
    //   164	27	2	localIOException2	java.io.IOException
    //   198	1	2	localException3	java.lang.Exception
    //   204	1	2	localObject4	Object
    //   53	102	3	localObject5	Object
    //   202	4	3	localObject6	Object
    //   47	109	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	164	java/io/IOException
    //   38	49	164	java/io/IOException
    //   57	64	164	java/io/IOException
    //   69	150	164	java/io/IOException
    //   150	161	164	java/io/IOException
    //   178	182	183	java/lang/Exception
    //   2	29	185	finally
    //   169	173	196	java/lang/Exception
    //   190	194	198	java/lang/Exception
    //   29	34	202	finally
    //   38	49	202	finally
    //   57	64	202	finally
    //   69	150	202	finally
    //   150	161	202	finally
    //   2	29	210	java/io/IOException
  }
  
  public void init()
  {
    ezL();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "init. built in plugin size:" + this.qv.size());
    }
  }
  
  public boolean tl(String paramString)
  {
    return this.qv.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfs
 * JD-Core Version:    0.7.0.1
 */