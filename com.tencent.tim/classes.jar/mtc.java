import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class mtc
{
  private static mtf a;
  private static AtomicBoolean av = new AtomicBoolean(false);
  private static AtomicBoolean aw = new AtomicBoolean(false);
  private static JSONObject ay;
  private static JSONObject az;
  private static ArrayList<mtc.a> lp;
  private static long wF;
  private static long wG;
  private static long wH;
  
  /* Error */
  private static boolean Ej()
  {
    // Byte code:
    //   0: ldc 44
    //   2: ldc 46
    //   4: invokestatic 52	awit:f	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 54	java/lang/String
    //   10: astore 5
    //   12: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +29 -> 44
    //   18: ldc 61
    //   20: iconst_2
    //   21: new 63	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   28: ldc 67
    //   30: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 5
    //   35: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload 5
    //   46: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +5 -> 54
    //   52: iconst_0
    //   53: ireturn
    //   54: new 87	org/json/JSONObject
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 90	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   63: putstatic 92	mtc:ay	Lorg/json/JSONObject;
    //   66: getstatic 92	mtc:ay	Lorg/json/JSONObject;
    //   69: ldc 94
    //   71: invokevirtual 98	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 5
    //   76: getstatic 92	mtc:ay	Lorg/json/JSONObject;
    //   79: ldc 100
    //   81: invokevirtual 104	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   84: istore_0
    //   85: getstatic 92	mtc:ay	Lorg/json/JSONObject;
    //   88: ldc 106
    //   90: invokevirtual 104	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   93: istore_1
    //   94: aload 5
    //   96: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: istore 4
    //   101: iload 4
    //   103: ifne -51 -> 52
    //   106: aconst_null
    //   107: invokestatic 112	aqiw:getSystemNetwork	(Landroid/content/Context;)I
    //   110: iconst_1
    //   111: if_icmpeq +19 -> 130
    //   114: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq -65 -> 52
    //   120: ldc 61
    //   122: iconst_2
    //   123: ldc 114
    //   125: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: iconst_0
    //   129: ireturn
    //   130: ldc 116
    //   132: ldc 46
    //   134: invokestatic 52	awit:f	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast 54	java/lang/String
    //   140: astore 6
    //   142: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +29 -> 174
    //   148: ldc 61
    //   150: iconst_2
    //   151: new 63	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   158: ldc 118
    //   160: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 6
    //   165: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload 6
    //   176: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne +153 -> 332
    //   182: new 87	org/json/JSONObject
    //   185: dup
    //   186: aload 6
    //   188: invokespecial 90	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   191: putstatic 120	mtc:az	Lorg/json/JSONObject;
    //   194: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   197: ldc 122
    //   199: ldc 46
    //   201: invokevirtual 126	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 6
    //   206: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   209: ldc 128
    //   211: iconst_0
    //   212: invokevirtual 132	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   215: istore_2
    //   216: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   219: ldc 134
    //   221: iconst_0
    //   222: invokevirtual 132	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   225: istore_3
    //   226: aload 5
    //   228: aload 6
    //   230: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifeq +29 -> 262
    //   236: iload_2
    //   237: iload_0
    //   238: if_icmpge +8 -> 246
    //   241: iload_3
    //   242: iload_1
    //   243: if_icmplt +19 -> 262
    //   246: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq -197 -> 52
    //   252: ldc 61
    //   254: iconst_2
    //   255: ldc 140
    //   257: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: iconst_0
    //   261: ireturn
    //   262: aload 5
    //   264: aload 6
    //   266: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   269: ifne +45 -> 314
    //   272: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   275: ldc 122
    //   277: aload 5
    //   279: invokevirtual 144	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   282: pop
    //   283: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   286: ldc 128
    //   288: iconst_0
    //   289: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   292: pop
    //   293: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   296: ldc 134
    //   298: iconst_0
    //   299: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   302: pop
    //   303: ldc 116
    //   305: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   308: invokevirtual 148	org/json/JSONObject:toString	()Ljava/lang/String;
    //   311: invokestatic 152	awit:H	(Ljava/lang/String;Ljava/lang/Object;)V
    //   314: invokestatic 156	mtc:bf	()Ljava/util/ArrayList;
    //   317: putstatic 158	mtc:lp	Ljava/util/ArrayList;
    //   320: getstatic 158	mtc:lp	Ljava/util/ArrayList;
    //   323: ifnull +68 -> 391
    //   326: iconst_1
    //   327: istore 4
    //   329: iload 4
    //   331: ireturn
    //   332: new 87	org/json/JSONObject
    //   335: dup
    //   336: invokespecial 159	org/json/JSONObject:<init>	()V
    //   339: putstatic 120	mtc:az	Lorg/json/JSONObject;
    //   342: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   345: ldc 122
    //   347: aload 5
    //   349: invokevirtual 144	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   352: pop
    //   353: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   356: ldc 128
    //   358: iconst_0
    //   359: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   362: pop
    //   363: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   366: ldc 134
    //   368: iconst_0
    //   369: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   372: pop
    //   373: ldc 116
    //   375: getstatic 120	mtc:az	Lorg/json/JSONObject;
    //   378: invokevirtual 148	org/json/JSONObject:toString	()Ljava/lang/String;
    //   381: invokestatic 152	awit:H	(Ljava/lang/String;Ljava/lang/Object;)V
    //   384: goto -70 -> 314
    //   387: astore 5
    //   389: iconst_0
    //   390: ireturn
    //   391: iconst_0
    //   392: istore 4
    //   394: goto -65 -> 329
    //   397: astore 5
    //   399: iconst_0
    //   400: ireturn
    //   401: astore 5
    //   403: iconst_0
    //   404: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   84	155	0	i	int
    //   93	151	1	j	int
    //   215	24	2	k	int
    //   225	19	3	m	int
    //   99	294	4	bool	boolean
    //   10	338	5	str1	String
    //   387	1	5	localException1	Exception
    //   397	1	5	localException2	Exception
    //   401	1	5	localException3	Exception
    //   140	125	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   332	384	387	java/lang/Exception
    //   54	101	397	java/lang/Exception
    //   182	236	401	java/lang/Exception
    //   246	260	401	java/lang/Exception
    //   262	314	401	java/lang/Exception
  }
  
  private static boolean Ek()
  {
    boolean bool2 = false;
    try
    {
      Object localObject = (ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity");
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((ActivityManager)localObject).getDeviceConfigurationInfo();
        bool1 = bool2;
        if (localObject != null)
        {
          int i = ((ConfigurationInfo)localObject).reqGlEsVersion;
          if (i < 131072) {
            break label46;
          }
        }
      }
      label46:
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void a(Context paramContext, mtc.a parama, int paramInt, String paramString, HashMap<Integer, mtf.b> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    Object localObject;
    boolean bool1;
    label172:
    int k;
    int j;
    try
    {
      localJSONObject.put("version", "3.4.4.3058");
      localJSONObject.put("subversion", "3.4.4");
      if (ay == null) {
        break label617;
      }
      localObject = ay.optString("version");
      localJSONObject.put("server_version", localObject);
      localJSONObject.put("video_tag", parama.tag);
      localJSONObject.put("video_vid", parama.vid);
      localJSONObject.put("video_bitrate", parama.bitrate);
      localJSONObject.put("video_width", parama.width);
      localJSONObject.put("video_height", parama.height);
      localJSONObject.put("task_cost_time", wG);
      localJSONObject.put("extract_frame_cost_time", wH);
      localJSONObject.put("return_code", paramInt);
      localJSONObject.put("return_code_detail", paramString);
      if (paramInt != 1) {
        break label624;
      }
      bool1 = true;
      k = 0;
      j = 2147483647;
      int i = 0;
      int m = 0;
      paramInt = 0;
      boolean bool2 = bool1;
      if (bool1)
      {
        paramString = paramHashMap.values().iterator();
        j = 2147483647;
        i = 0;
        paramInt = m;
        label217:
        if (paramString.hasNext())
        {
          localObject = (mtf.b)paramString.next();
          if (((mtf.b)localObject).aUn > parama.aUm) {
            bool1 = false;
          }
          i += ((mtf.b)localObject).aUn;
          k = j;
          if (j > ((mtf.b)localObject).aUn) {
            k = ((mtf.b)localObject).aUn;
          }
          if (paramInt >= ((mtf.b)localObject).aUn) {
            break label630;
          }
          paramInt = ((mtf.b)localObject).aUn;
          break label610;
        }
        k = i / paramHashMap.size();
        m = i;
        bool2 = bool1;
        i = paramInt;
        paramInt = m;
      }
      localJSONObject.put("is_success", String.valueOf(bool2));
      localJSONObject.put("avg_hash_diff", k);
      localJSONObject.put("min_hash_diff", j);
      localJSONObject.put("max_hash_diff", i);
      localJSONObject.put("total_hash_diff", paramInt);
      parama = new JSONArray();
      paramString = paramHashMap.values().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (mtf.b)paramString.next();
        localObject = new JSONObject();
        ((JSONObject)localObject).put("frame_index", paramHashMap.index);
        ((JSONObject)localObject).put("hash_diff", paramHashMap.aUn);
        ((JSONObject)localObject).put("server_hash", paramHashMap.wK);
        ((JSONObject)localObject).put("local_hash", paramHashMap.wL);
        parama.put(localObject);
        continue;
        localHashMap.put("param_content", localJSONObject.toString());
      }
    }
    catch (Exception parama) {}
    for (;;)
    {
      localHashMap.put("param_device", msz.h(false));
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "灯塔数据上报 reportMap = " + localHashMap.toString());
      }
      parama = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (parama != null) {
        anpc.a(paramContext).collectPerformance(parama.getCurrentUin(), "actKandianVideoExtractFrame", true, -1L, 0L, localHashMap, null);
      }
      return;
      localJSONObject.put("detail_list", parama);
    }
    label610:
    label617:
    label624:
    label630:
    for (;;)
    {
      j = k;
      break label217;
      localObject = "";
      break;
      bool1 = false;
      break label172;
    }
  }
  
  private static void a(mtc.a parama, String paramString, HashMap<Integer, mtf.b> paramHashMap, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "innerDoExtractFrame start() videoInfo.tag = " + parama.tag);
    }
    wF = System.currentTimeMillis();
    a = new mtf(BaseApplication.getContext(), paramString, paramHashMap, paramLong);
    a.a(new mte(parama));
    a.start();
  }
  
  private static ArrayList<mtc.a> bf()
  {
    if (ay == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = ay.getJSONArray("videoList");
      int i = 0;
      while (i < localJSONArray.length())
      {
        mtc.a locala = new mtc.a();
        Object localObject = (JSONObject)localJSONArray.get(i);
        locala.vid = ((JSONObject)localObject).getString("vid");
        locala.bitrate = ((JSONObject)localObject).getLong("bitrate");
        locala.wI = ((JSONObject)localObject).getLong("timeout_ms");
        locala.jL = Float.valueOf(((JSONObject)localObject).getString("hevc_level")).floatValue();
        locala.aUm = ((JSONObject)localObject).getInt("max_hashdiff");
        locala.tag = ((JSONObject)localObject).optString("tag");
        localObject = ((JSONObject)localObject).getJSONArray("frameInfo");
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          mtf.b localb = new mtf.b();
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(j);
          localb.index = localJSONObject.getInt("index");
          localb.wK = localJSONObject.getLong("serverHash");
          locala.lq.add(localb);
          j += 1;
        }
        localArrayList.add(locala);
        i += 1;
      }
      return localThrowable;
    }
    catch (Throwable localThrowable)
    {
      return null;
    }
  }
  
  public static void onEnterBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "onEnterBackground() mHasRun = " + av.get() + ", mHasDestory = " + aw.get());
    }
    if (Looper.getMainLooper() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoExtractFrame", 2, "Looper == null, 直接返回");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (av.compareAndSet(false, true)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VideoExtractFrame", 2, "当前进程已执行过一次，直接返回");
        return;
        if (Ej()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoExtractFrame", 2, "条件不满足，不进行检测逻辑");
      return;
      if (Ek()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoExtractFrame", 2, "当前设备OPENGL版本号低于2.0，直接返回");
    return;
    run();
  }
  
  private static void run()
  {
    try
    {
      int i = az.optInt("KEY_LOCAL_RESULT_TRY_COUNT", 0);
      az.put("KEY_LOCAL_RESULT_TRY_COUNT", i + 1);
      awit.H("kandian_video_extract_frame_local_result", az.toString());
      float f = msz.ai();
      Object localObject = lp.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((mtc.a)((Iterator)localObject).next()).jL > f) {
          ((Iterator)localObject).remove();
        }
      }
      if (lp.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoExtractFrame", 2, "当前设备无支持播放的视频，直接返回");
        }
        return;
      }
      i = lp.size();
      i = new Random().nextInt(i);
      localObject = (mtc.a)lp.get(i);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((mtc.a)localObject).lq.iterator();
      while (localIterator.hasNext())
      {
        mtf.b localb = (mtf.b)localIterator.next();
        localHashMap.put(Integer.valueOf(localb.index), localb);
      }
      kxv.a().a(((mtc.a)localObject).vid, "PubAccountArticleCenter.GetUrlByVid", new mtd((mtc.a)localObject, localHashMap));
      return;
    }
    catch (Exception localException) {}
  }
  
  static class a
  {
    public int aUm;
    public long bitrate;
    public int height;
    public float jL;
    public ArrayList<mtf.b> lq = new ArrayList();
    public String tag;
    public String vid;
    public long wI;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtc
 * JD-Core Version:    0.7.0.1
 */