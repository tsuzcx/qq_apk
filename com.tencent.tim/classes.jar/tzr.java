import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.1;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.2;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xb60.ClientInfo;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeReq;
import tencent.im.oidb.oidb_0xb60.ReqBody;

public class tzr
{
  private static tzr a = new tzr();
  public long EZ = 0L;
  public long Fa = 0L;
  public JSONObject aR;
  public final Object bJ = new Object();
  public Map<String, tzl> hc = new HashMap();
  boolean mInited = false;
  
  static
  {
    Bosses.initWithBoss(BaseApplicationImpl.getApplication(), new pmf(BaseApplicationImpl.getApplication()));
  }
  
  public static tzr a()
  {
    return a;
  }
  
  private boolean gZ(String paramString)
  {
    JSONObject localJSONObject = this.aR;
    if (localJSONObject == null) {
      return false;
    }
    if ((tzl)this.hc.get(paramString) != null) {
      return true;
    }
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject = localJSONObject.optJSONObject((String)localIterator.next());
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optJSONArray("apis");
        if (localObject != null)
        {
          int j = ((JSONArray)localObject).length();
          int i = 0;
          while (i < j)
          {
            if (TextUtils.equals(paramString, ((JSONArray)localObject).optString(i))) {
              return true;
            }
            i += 1;
          }
        }
      }
    }
    return false;
  }
  
  private boolean ha(String paramString)
  {
    try
    {
      this.aR = new JSONObject(paramString);
      this.hc.clear();
      return true;
    }
    catch (JSONException paramString)
    {
      QLog.e("DoraemonOpenAPI.permissionHelper", 1, "parseGroupData error");
    }
    return false;
  }
  
  /* Error */
  private static String u(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 152	java/io/InputStreamReader
    //   5: dup
    //   6: aload_0
    //   7: invokevirtual 158	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   10: invokevirtual 164	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 170	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: invokespecial 173	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: new 175	java/io/BufferedReader
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 178	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_1
    //   33: astore_0
    //   34: new 180	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   41: astore 4
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: invokevirtual 185	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +47 -> 100
    //   56: aload_1
    //   57: astore_0
    //   58: aload 4
    //   60: aload 5
    //   62: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: astore_0
    //   68: aload 4
    //   70: bipush 10
    //   72: invokevirtual 192	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -33 -> 43
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 195	java/lang/Exception:printStackTrace	()V
    //   86: aload_3
    //   87: astore_0
    //   88: aload_1
    //   89: ifnull +9 -> 98
    //   92: aload_1
    //   93: invokevirtual 198	java/io/InputStreamReader:close	()V
    //   96: aload_3
    //   97: astore_0
    //   98: aload_0
    //   99: areturn
    //   100: aload_1
    //   101: astore_0
    //   102: aload 4
    //   104: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_0
    //   110: aload_1
    //   111: ifnull -13 -> 98
    //   114: aload_1
    //   115: invokevirtual 198	java/io/InputStreamReader:close	()V
    //   118: aload_2
    //   119: areturn
    //   120: astore_0
    //   121: aload_2
    //   122: areturn
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 198	java/io/InputStreamReader:close	()V
    //   134: aload_1
    //   135: athrow
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: goto -6 -> 134
    //   143: astore_1
    //   144: goto -18 -> 126
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -70 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramContext	android.content.Context
    //   0	153	1	paramString	String
    //   31	15	2	localBufferedReader	java.io.BufferedReader
    //   79	4	2	localException1	java.lang.Exception
    //   107	15	2	str1	String
    //   147	1	2	localException2	java.lang.Exception
    //   1	96	3	localObject	Object
    //   41	62	4	localStringBuilder	java.lang.StringBuilder
    //   49	12	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   23	32	79	java/lang/Exception
    //   34	43	79	java/lang/Exception
    //   45	51	79	java/lang/Exception
    //   58	66	79	java/lang/Exception
    //   68	76	79	java/lang/Exception
    //   102	108	79	java/lang/Exception
    //   114	118	120	java/io/IOException
    //   2	21	123	finally
    //   92	96	136	java/io/IOException
    //   130	134	139	java/io/IOException
    //   23	32	143	finally
    //   34	43	143	finally
    //   45	51	143	finally
    //   58	66	143	finally
    //   68	76	143	finally
    //   82	86	143	finally
    //   102	108	143	finally
    //   2	21	147	java/lang/Exception
  }
  
  public tzl a(String paramString)
  {
    JSONObject localJSONObject1 = this.aR;
    Object localObject;
    if (localJSONObject1 == null) {
      localObject = null;
    }
    tzl localtzl;
    do
    {
      return localObject;
      localtzl = (tzl)this.hc.get(paramString);
      localObject = localtzl;
    } while (localtzl != null);
    Iterator localIterator = localJSONObject1.keys();
    label205:
    for (;;)
    {
      localObject = localtzl;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject((String)localObject);
      if (localJSONObject2 != null)
      {
        JSONArray localJSONArray = localJSONObject2.optJSONArray("apis");
        if (localJSONArray != null)
        {
          int j = localJSONArray.length();
          int i = 0;
          label110:
          if (i < j) {
            if (!TextUtils.equals(paramString, localJSONArray.optString(i))) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label205;
            }
            paramString = new tzl((String)localObject, localJSONObject2.optString("name"));
            j = localJSONArray.length();
            i = 0;
            for (;;)
            {
              localObject = paramString;
              if (i >= j) {
                break;
              }
              localObject = localJSONArray.optString(i);
              this.hc.put(localObject, paramString);
              i += 1;
            }
            i += 1;
            break label110;
          }
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, tzr.c paramc)
  {
    paramString1 = ajcr.a().a(paramString2, paramInt, 1, false, null, 1);
    if (paramString1 != null)
    {
      ThreadManager.getUIHandler().post(new DefaultDoraemonAppInfoHelper.2(this, paramc, paramString1));
      return;
    }
    paramString1 = new ajcn(paramString2, paramInt);
    paramString1.sdkVersion = paramString3;
    paramString1.pkgName = paramString4;
    paramString1.signature = paramString5;
    Stream.of(paramString1).map(new ThreadOffFunction("DoraemonOpenAPI.permissionHelper", 16)).map(new tzr.a(null)).map(new tzr.b(null)).map(new tzt(this, paramString2, paramInt)).map(new UIThreadOffFunction(null)).subscribe(new tzs(this, paramc));
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, tzr.c paramc)
  {
    ajcn localajcn = ajcr.a().a(paramString2, paramInt, 1, false, null, 1);
    paramString1 = localajcn;
    if (localajcn == null) {
      paramString1 = new ajcn(paramString2, paramInt);
    }
    Stream.of(paramString1).map(new ThreadOffFunction("DoraemonOpenAPI.permissionHelper", 16)).map(new tzr.a(null)).map(new VerifyUrlJobSegment(paramString3)).map(new tzr.b(null)).map(new tzw(this, paramString2, paramInt)).map(new UIThreadOffFunction(null)).subscribe(new tzv(this, paramc));
  }
  
  public void b(List<Integer> paramList, Set<String> paramSet)
  {
    paramSet.clear();
    JSONObject localJSONObject = this.aR;
    if (localJSONObject == null) {
      label17:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label17;
      }
      Object localObject = localJSONObject.optJSONObject(String.valueOf((Integer)paramList.next()));
      if (localObject == null) {
        break;
      }
      localObject = ((JSONObject)localObject).optJSONArray("apis");
      if (localObject == null) {
        break;
      }
      int i = 0;
      int j = ((JSONArray)localObject).length();
      while (i < j)
      {
        paramSet.add(((JSONArray)localObject).optString(i));
        i += 1;
      }
    }
  }
  
  public void checkUpdate()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (l > this.EZ) {}
    synchronized (this.bJ)
    {
      if (l > this.EZ)
      {
        this.EZ = (l + 300000L);
        ThreadManager.post(new DefaultDoraemonAppInfoHelper.1(this), 5, null, false);
        return;
      }
      return;
    }
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	tzr:mInited	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 39	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   17: ldc_w 342
    //   20: iconst_4
    //   21: invokevirtual 346	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   24: astore_3
    //   25: aload_3
    //   26: ldc_w 348
    //   29: aconst_null
    //   30: invokeinterface 354 3 0
    //   35: astore 4
    //   37: iconst_0
    //   38: istore_2
    //   39: iload_2
    //   40: istore_1
    //   41: aload 4
    //   43: ldc_w 356
    //   46: invokestatic 125	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   49: ifeq +54 -> 103
    //   52: aload_3
    //   53: ldc_w 358
    //   56: aconst_null
    //   57: invokeinterface 354 3 0
    //   62: astore 4
    //   64: iload_2
    //   65: istore_1
    //   66: aload 4
    //   68: invokestatic 362	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +32 -> 103
    //   74: aload_0
    //   75: aload 4
    //   77: invokespecial 364	tzr:ha	(Ljava/lang/String;)Z
    //   80: istore_2
    //   81: iload_2
    //   82: istore_1
    //   83: iload_2
    //   84: ifeq +19 -> 103
    //   87: aload_0
    //   88: aload_3
    //   89: ldc_w 366
    //   92: lconst_0
    //   93: invokeinterface 370 4 0
    //   98: putfield 65	tzr:Fa	J
    //   101: iload_2
    //   102: istore_1
    //   103: iload_1
    //   104: ifne +48 -> 152
    //   107: ldc 136
    //   109: iconst_1
    //   110: ldc_w 372
    //   113: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: invokestatic 39	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   119: ldc_w 342
    //   122: invokestatic 377	tzr:u	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   125: astore_3
    //   126: aload_3
    //   127: invokestatic 362	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifne +9 -> 139
    //   133: aload_0
    //   134: aload_3
    //   135: invokespecial 364	tzr:ha	(Ljava/lang/String;)Z
    //   138: istore_1
    //   139: iload_1
    //   140: ifne +12 -> 152
    //   143: ldc 136
    //   145: iconst_1
    //   146: ldc_w 379
    //   149: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield 56	tzr:mInited	Z
    //   157: goto -146 -> 11
    //   160: astore_3
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_3
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	tzr
    //   6	134	1	bool1	boolean
    //   38	64	2	bool2	boolean
    //   24	111	3	localObject1	Object
    //   160	4	3	localObject2	Object
    //   35	41	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	7	160	finally
    //   14	37	160	finally
    //   41	64	160	finally
    //   66	81	160	finally
    //   87	101	160	finally
    //   107	126	160	finally
    //   126	139	160	finally
    //   143	152	160	finally
    //   152	157	160	finally
  }
  
  static class a
    extends JobSegment<ajcn, ajcn>
  {
    protected void a(JobContext paramJobContext, ajcn paramajcn)
    {
      paramJobContext = tzr.a();
      if (!paramJobContext.mInited) {
        paramJobContext.init();
      }
      notifyResult(paramajcn);
    }
  }
  
  static class b
    extends JobSegment<ajcn, ajcn>
  {
    protected void a(JobContext paramJobContext, ajcn paramajcn)
    {
      if (paramajcn.aqo())
      {
        notifyResult(paramajcn);
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "cache is valid");
        }
      }
      do
      {
        do
        {
          return;
          paramJobContext = BaseApplicationImpl.getApplication().getRuntime();
          if (paramJobContext != null) {
            break;
          }
          notifyError(new AppInfoError(6, "jobApiPermission app is null"));
        } while (!QLog.isColorLevel());
        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "app is null");
        return;
        try
        {
          int i = Integer.parseInt(paramajcn.appId);
          oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
          localReqBody.get_privilege_req.setHasFlag(true);
          localReqBody.get_privilege_req.appid.set(i);
          localReqBody.get_privilege_req.app_type.set(paramajcn.appType);
          if (paramajcn.appType == 1)
          {
            oidb_0xb60.ClientInfo localClientInfo = new oidb_0xb60.ClientInfo();
            localClientInfo.platform.set(1);
            if (!TextUtils.isEmpty(paramajcn.sdkVersion)) {
              localClientInfo.sdk_version.set(paramajcn.sdkVersion);
            }
            if (!TextUtils.isEmpty(paramajcn.pkgName)) {
              localClientInfo.android_package_name.set(paramajcn.pkgName);
            }
            if (!TextUtils.isEmpty(paramajcn.signature)) {
              localClientInfo.android_signature.set(paramajcn.signature);
            }
            localReqBody.client_info.set(localClientInfo);
          }
          if (QLog.isColorLevel()) {
            QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "send type=" + paramajcn.appType + ", appid=" + paramajcn.appId);
          }
          jnm.a(paramJobContext, new tzy(this, paramajcn), localReqBody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
          return;
        }
        catch (NumberFormatException paramJobContext)
        {
          notifyError(new AppInfoError(6, "jobApiPermission parse appid error"));
        }
      } while (!QLog.isColorLevel());
      QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "parse appid error");
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(ajcn paramajcn, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzr
 * JD-Core Version:    0.7.0.1
 */