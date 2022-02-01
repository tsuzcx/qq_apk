import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.business.base.OpenConfig.1;
import com.tencent.open.business.base.OpenConfig.2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.HashMap;
import org.json.JSONObject;

public class arxs
{
  protected static String cCZ;
  protected static HashMap<String, arxs> gs;
  protected Context appContext;
  protected String appId;
  public JSONObject config;
  private boolean dds;
  public int elh;
  protected long updateTimestamp;
  
  protected arxs(Context paramContext, String paramString)
  {
    this.appContext = paramContext;
    this.appId = paramString;
    init();
    update();
  }
  
  public static arxs a(Context paramContext, String paramString)
  {
    if (gs == null) {
      gs = new HashMap();
    }
    if (paramString != null) {
      cCZ = paramString;
    }
    String str = paramString;
    if (paramString == null) {
      if (cCZ == null) {
        break label78;
      }
    }
    label78:
    for (str = cCZ;; str = "0")
    {
      arxs localarxs = (arxs)gs.get(str);
      paramString = localarxs;
      if (localarxs == null)
      {
        paramString = new arxs(paramContext, str);
        gs.put(str, paramString);
      }
      return paramString;
    }
  }
  
  public void bX(JSONObject paramJSONObject)
  {
    this.config = paramJSONObject;
    writeFile("com.tencent.open.config.json", paramJSONObject.toString());
    this.updateTimestamp = SystemClock.elapsedRealtime();
  }
  
  protected void check()
  {
    int j = this.config.optInt("Common_frequency");
    int i = j;
    if (j == 0) {
      i = 1;
    }
    long l = i * 3600000;
    if (SystemClock.elapsedRealtime() - this.updateTimestamp >= l) {
      update();
    }
  }
  
  public boolean getBoolean(String paramString)
  {
    check();
    paramString = this.config.opt(paramString);
    if (paramString == null) {}
    do
    {
      return false;
      if ((paramString instanceof Integer))
      {
        if (!paramString.equals(Integer.valueOf(0))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    } while (!(paramString instanceof Boolean));
    return ((Boolean)paramString).booleanValue();
  }
  
  public int getInt(String paramString)
  {
    check();
    return this.config.optInt(paramString);
  }
  
  public long getLong(String paramString)
  {
    check();
    return this.config.optLong(paramString);
  }
  
  public String getString(String paramString)
  {
    check();
    return this.config.optString(paramString);
  }
  
  protected void init()
  {
    if (!this.dds)
    {
      this.config = new JSONObject();
      ThreadManager.executeOnSubThread(new OpenConfig.1(this));
    }
  }
  
  /* Error */
  public String readFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	arxs:appId	Ljava/lang/String;
    //   4: ifnull +102 -> 106
    //   7: new 146	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   14: aload_1
    //   15: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 153
    //   20: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 29	arxs:appId	Ljava/lang/String;
    //   27: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 27	arxs:appContext	Landroid/content/Context;
    //   38: aload_2
    //   39: invokevirtual 160	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   42: astore_2
    //   43: aload_2
    //   44: astore_1
    //   45: new 162	java/io/BufferedReader
    //   48: dup
    //   49: new 164	java/io/InputStreamReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 167	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_2
    //   61: new 172	java/lang/StringBuffer
    //   64: dup
    //   65: invokespecial 173	java/lang/StringBuffer:<init>	()V
    //   68: astore_3
    //   69: aload_2
    //   70: invokevirtual 176	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +58 -> 135
    //   80: aload_3
    //   81: aload 4
    //   83: invokevirtual 179	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   86: pop
    //   87: goto -18 -> 69
    //   90: astore_3
    //   91: aload_3
    //   92: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   95: aload_1
    //   96: invokevirtual 187	java/io/InputStream:close	()V
    //   99: aload_2
    //   100: invokevirtual 188	java/io/BufferedReader:close	()V
    //   103: ldc 190
    //   105: areturn
    //   106: aload_1
    //   107: astore_2
    //   108: goto -74 -> 34
    //   111: astore_2
    //   112: aload_0
    //   113: getfield 27	arxs:appContext	Landroid/content/Context;
    //   116: invokevirtual 194	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   119: aload_1
    //   120: invokevirtual 200	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   123: astore_1
    //   124: goto -79 -> 45
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   132: ldc 190
    //   134: areturn
    //   135: aload_3
    //   136: invokevirtual 201	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   139: astore_3
    //   140: aload_1
    //   141: invokevirtual 187	java/io/InputStream:close	()V
    //   144: aload_2
    //   145: invokevirtual 188	java/io/BufferedReader:close	()V
    //   148: aload_3
    //   149: areturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   155: aload_3
    //   156: areturn
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   162: ldc 190
    //   164: areturn
    //   165: astore_3
    //   166: aload_1
    //   167: invokevirtual 187	java/io/InputStream:close	()V
    //   170: aload_2
    //   171: invokevirtual 188	java/io/BufferedReader:close	()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   181: goto -7 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	arxs
    //   0	184	1	paramString	String
    //   33	75	2	localObject1	Object
    //   111	60	2	localFileNotFoundException	java.io.FileNotFoundException
    //   68	13	3	localStringBuffer	java.lang.StringBuffer
    //   90	46	3	localIOException	java.io.IOException
    //   139	17	3	str1	String
    //   165	10	3	localObject2	Object
    //   73	9	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   69	75	90	java/io/IOException
    //   80	87	90	java/io/IOException
    //   135	140	90	java/io/IOException
    //   0	34	111	java/io/FileNotFoundException
    //   34	43	111	java/io/FileNotFoundException
    //   112	124	127	java/io/IOException
    //   140	148	150	java/io/IOException
    //   95	103	157	java/io/IOException
    //   69	75	165	finally
    //   80	87	165	finally
    //   91	95	165	finally
    //   135	140	165	finally
    //   166	174	176	java/io/IOException
  }
  
  public boolean ss(String paramString)
  {
    check();
    paramString = this.config.opt(paramString);
    if (paramString == null) {
      return true;
    }
    if ((paramString instanceof Integer))
    {
      if (!paramString.equals(Integer.valueOf(0))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    if ((paramString instanceof Boolean)) {
      return ((Boolean)paramString).booleanValue();
    }
    return false;
  }
  
  public boolean st(String paramString)
  {
    check();
    paramString = this.config.opt(paramString);
    if (paramString == null) {}
    do
    {
      return false;
      if ((paramString instanceof Integer))
      {
        if (!paramString.equals(Integer.valueOf(0))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    } while (!(paramString instanceof Boolean));
    return ((Boolean)paramString).booleanValue();
  }
  
  protected void update()
  {
    if (this.elh != 0) {
      return;
    }
    this.elh = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.appId);
    localBundle.putString("appid_for_getting_config", this.appId);
    localBundle.putString("status_os", Build.VERSION.RELEASE);
    localBundle.putString("status_machine", Build.MODEL);
    localBundle.putString("status_brand", Build.BRAND);
    localBundle.putString("status_version", Build.VERSION.SDK);
    localBundle.putString("sdkv", "1.5");
    localBundle.putString("sdkp", "a");
    localBundle.putString("blacklist_logic_version", String.valueOf(1));
    localBundle.putString("yyb_version", String.valueOf(arxn.fA("com.tencent.android.qqdownloader")));
    localBundle.putString("qq_version", String.valueOf(GlobalUtil.getAppVersionCode(aroi.a().getContext())));
    ThreadManager.executeOnNetWorkThread(new OpenConfig.2(this, localBundle));
  }
  
  /* Error */
  protected void writeFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 29	arxs:appId	Ljava/lang/String;
    //   9: ifnull +30 -> 39
    //   12: new 146	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   19: aload_1
    //   20: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 153
    //   25: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 29	arxs:appId	Ljava/lang/String;
    //   32: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 27	arxs:appContext	Landroid/content/Context;
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 291	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   48: astore_1
    //   49: new 293	java/io/OutputStreamWriter
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 296	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   57: astore_3
    //   58: aload_3
    //   59: aload_2
    //   60: invokevirtual 300	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   63: aload_3
    //   64: invokevirtual 303	java/io/OutputStreamWriter:flush	()V
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 306	java/io/FileOutputStream:close	()V
    //   75: aload_3
    //   76: ifnull +7 -> 83
    //   79: aload_3
    //   80: invokevirtual 307	java/io/OutputStreamWriter:close	()V
    //   83: return
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_1
    //   87: aload 4
    //   89: astore_3
    //   90: aload_2
    //   91: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   94: goto -27 -> 67
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   102: goto -27 -> 75
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   110: return
    //   111: astore_2
    //   112: aload 4
    //   114: astore_3
    //   115: goto -25 -> 90
    //   118: astore_2
    //   119: goto -29 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	arxs
    //   0	122	1	paramString1	String
    //   0	122	2	paramString2	String
    //   4	111	3	localObject1	Object
    //   1	112	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	39	84	java/io/IOException
    //   39	49	84	java/io/IOException
    //   71	75	97	java/io/IOException
    //   79	83	105	java/io/IOException
    //   49	58	111	java/io/IOException
    //   58	67	118	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxs
 * JD-Core Version:    0.7.0.1
 */