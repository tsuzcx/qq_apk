import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.AppDownloadInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCGI.10;
import com.tencent.mobileqq.ark.ArkAppCGI.8;
import com.tencent.mobileqq.ark.ArkAppCGI.9;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class adqb
  implements aolm.b
{
  private static final Pattern X;
  static int _tempFileIndex;
  private aolm c;
  private WeakReference<QQAppInterface> gj;
  private final ArrayList<adqb.e> mTaskList = new ArrayList();
  
  static
  {
    if (!adqb.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      X = Pattern.compile("Last-Modified[ ]*=[ ]*\\[([^\\[\\]]+)\\]");
      return;
    }
  }
  
  public adqb(QQAppInterface paramQQAppInterface)
  {
    this.gj = new WeakReference(paramQQAppInterface);
    if (this.c == null) {
      this.c = ((aomf)paramQQAppInterface.getManager(21)).a(paramQQAppInterface, 0);
    }
  }
  
  private adqb.c a(String paramString)
  {
    adqb.c localc = new adqb.c();
    localc.updateInterval = 0;
    if (paramString == null) {
      ArkAppCenter.r("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, data is empty");
    }
    for (;;)
    {
      return localc;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("data");
        if (paramString == null)
        {
          ArkAppCenter.r("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'data' not found");
          return localc;
        }
      }
      catch (JSONException paramString)
      {
        ArkAppCenter.r("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, exception: %s", new Object[] { paramString.getMessage() }));
        return localc;
      }
      localc.updateInterval = paramString.optInt("updateInterval", 300);
      localc.updateInterval = Math.max(60, localc.updateInterval);
      paramString = paramString.optJSONArray("apps");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject1 = paramString.optJSONObject(i);
          if (localObject1 != null)
          {
            String str1 = ((JSONObject)localObject1).optString("app");
            if (TextUtils.isEmpty(str1))
            {
              ArkAppCenter.r("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'app' not found");
            }
            else
            {
              int j = ((JSONObject)localObject1).optInt("ret", -1);
              Object localObject2 = ((JSONObject)localObject1).optString("msg", "");
              adqb.d locald;
              if (j != 0)
              {
                locald = new adqb.d();
                locald.retCode = j;
                locald.msg = ((String)localObject2);
                locald.info = null;
                localc.resultList.put(str1, locald);
              }
              else
              {
                locald = new adqb.d();
                locald.retCode = 0;
                locald.msg = ((String)localObject2);
                locald.info = new ArkAppInfo.AppDownloadInfo();
                locald.info.desc = new ArkAppInfo.AppDesc();
                localObject2 = ((JSONObject)localObject1).optJSONObject("config");
                if (localObject2 != null)
                {
                  locald.info.config = ArkAppConfigMgr.convertJsonToConfig((JSONObject)localObject2);
                  locald.info.desc.isTempApp = ArkAppConfigMgr.isTemplateApp(locald.info.config);
                }
                locald.state = ((JSONObject)localObject1).optInt("state", 0);
                if (locald.state == 0)
                {
                  ArkAppCenter.r("ArkApp.ArkAppCGI", "ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid 'state'");
                  locald.retCode = -1;
                  localc.resultList.put(str1, locald);
                }
                else if (locald.state == 1)
                {
                  localObject2 = ((JSONObject)localObject1).optString("ver", null);
                  String str2 = ((JSONObject)localObject1).optString("url", null);
                  String str3 = ((JSONObject)localObject1).optString("sign", null);
                  j = ((JSONObject)localObject1).optInt("updatePeriod", 0);
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
                  {
                    ArkAppCenter.r("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid app info, app=%s", new Object[] { str1 }));
                  }
                  else
                  {
                    localObject1 = Base64.decode(str3, 0);
                    if ((localObject1 == null) || (localObject1.length == 0))
                    {
                      ArkAppCenter.r("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid sign, app=%s", new Object[] { str1 }));
                    }
                    else
                    {
                      locald.info.downloadUrl = str2;
                      locald.info.sign = ((byte[])localObject1);
                      locald.info.updatePeriodByMinutes = j;
                      locald.info.desc.name = str1;
                      locald.info.desc.version = ((String)localObject2);
                    }
                  }
                }
                else
                {
                  localc.resultList.put(str1, locald);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(adqb.e parame, adqb.b arg2)
  {
    parame.a = ???;
    parame.rspStream = new ByteArrayOutputStream();
    synchronized (this.mTaskList)
    {
      this.mTaskList.add(parame);
      ??? = (QQAppInterface)this.gj.get();
      if (??? == null)
      {
        ArkAppCenter.r("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
    }
    aoll localaoll = new aoll();
    localaoll.bZ = parame.url;
    localaoll.dPo = 1;
    if (parame.postData == null) {
      localaoll.mHttpMethod = 0;
    }
    for (;;)
    {
      localaoll.bw(parame);
      localaoll.u.put("Accept-Encoding", "identity");
      localaoll.jdField_f_of_type_Aolm$b = this;
      localaoll.mExcuteTimeLimit = 30L;
      localaoll.jdField_f_of_type_JavaIoOutputStream = parame.rspStream;
      if (parame.cookie != null) {
        localaoll.u.put("Cookie", parame.cookie);
      }
      if (parame.lastModifiedTime >= 0L)
      {
        Object localObject = new SimpleDateFormat("E, d MMM y HH:mm:ss 'GMT'", Locale.US);
        ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT"));
        localObject = ((SimpleDateFormat)localObject).format(new Date(parame.lastModifiedTime));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localaoll.u.put("If-Modified-Since", localObject);
        }
      }
      ThreadManager.post(new ArkAppCGI.8(this, ???, parame, localaoll), 5, null, true);
      return;
      localaoll.mHttpMethod = 1;
      localaoll.X = parame.postData;
    }
  }
  
  private void a(adqb.e parame, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppCGI.10(this, parame, paramBoolean, paramArrayOfByte));
  }
  
  private void a(adqb.g paramg, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    adqb.a locala;
    if (!paramBoolean)
    {
      ArkAppCenter.r("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: fail, url=%s", new Object[] { paramg.url }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramg.callback.size()) {
        return;
      }
      localObject = paramg.userdata.get(i);
      locala = (adqb.a)paramg.callback.get(i);
      if (locala != null) {
        if (paramArrayOfByte == null) {
          break label136;
        }
      }
    }
    label136:
    for (paramBoolean = true;; paramBoolean = false)
    {
      locala.a(paramBoolean, paramArrayOfByte, paramg.appID, localObject);
      i += 1;
      break label31;
      paramArrayOfByte = s(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        ArkAppCenter.r("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: parseReply fail, url=%s", new Object[] { paramg.url }));
      }
      break;
    }
  }
  
  private boolean a(String paramString, long paramLong, Object paramObject, adqb.a parama)
  {
    synchronized (this.mTaskList)
    {
      Iterator localIterator = this.mTaskList.iterator();
      while (localIterator.hasNext())
      {
        adqb.e locale = (adqb.e)localIterator.next();
        if ((locale.url.equalsIgnoreCase(paramString)) && (locale.lastModifiedTime == paramLong))
        {
          locale.userdata.add(paramObject);
          locale.callback.add(parama);
          return true;
        }
      }
      return false;
    }
  }
  
  private void b(adqb.e parame, adqb.b arg2)
  {
    parame.a = ???;
    synchronized (this.mTaskList)
    {
      this.mTaskList.add(parame);
      ThreadManager.post(new ArkAppCGI.9(this, parame), 5, null, true);
      return;
    }
  }
  
  private int cH(String paramString)
  {
    int j = 5381;
    int i = 0;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  private static String createTempFilePath()
  {
    try
    {
      String str = ArkEnvironmentManager.getInstance().getCacheDirectory() + "/tmp";
      new File(str).mkdirs();
      long l = System.currentTimeMillis();
      int i = _tempFileIndex + 1;
      _tempFileIndex = i;
      str = String.format("%s/%s", new Object[] { str, String.format("cgi_%d_%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) }) });
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String s(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ArkAppCenter.r("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID: replyBuf is empty");
      return null;
    }
    Object localObject;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      str = paramArrayOfByte.getString("retcode");
      if (!str.equalsIgnoreCase("0"))
      {
        ArkAppCenter.r("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, reply fail, ret=" + str);
        return null;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.r("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Json Exception:" + paramArrayOfByte.getMessage());
      return null;
      localObject = paramArrayOfByte.getJSONObject("result");
      paramArrayOfByte = ((JSONObject)localObject).getString("retcode");
      String str = ((JSONObject)localObject).getString("msg");
      localObject = ((JSONObject)localObject).getString("apk_name");
      if ((localObject == null) || (((String)localObject).length() <= 0))
      {
        ArkAppCenter.r("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, packageName is empty, retcode=" + paramArrayOfByte + str);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.r("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Exception:" + paramArrayOfByte.getMessage());
      return null;
    }
    return localObject;
  }
  
  public void GJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ArkAppCenter.r("ArkApp.ArkAppCGI", "doVipReport()=null");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)this.gj.get();
        } while (localObject == null);
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ArkAppCenter.r("ArkApp.ArkAppCGI", "doVipReport()=" + paramString);
    ((adrc)localObject).a("ArkAppReport.VIPReport", paramString, 10000, 0, new adqg(this));
  }
  
  protected void a(adqb.f paramf, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramf.callback.size())
    {
      adqb.a locala = (adqb.a)paramf.callback.get(i);
      if (locala != null) {
        locala.a(paramBoolean, paramf.lastModifiedTime, paramArrayOfByte);
      }
      i += 1;
    }
  }
  
  public void a(String paramString, long paramLong, adqb.a parama)
  {
    if (a(paramString, paramLong, null, parama)) {
      return;
    }
    adqb.f localf = new adqb.f(null);
    localf.url = paramString;
    localf.lastModifiedTime = paramLong;
    localf.callback.add(parama);
    a(localf, new adqh(this));
  }
  
  public void a(String paramString, Object paramObject, adqb.a parama)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      if (parama != null) {
        parama.a(false, null, paramString, paramObject);
      }
    }
    Object localObject2;
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        localObject1 = (QQAppInterface)this.gj.get();
        if (localObject1 == null)
        {
          ArkAppCenter.r("ArkApp.ArkAppCGI", "queryPackageNameByAppID, app is null, return");
          return;
        }
        localObject2 = (TicketManager)((QQAppInterface)localObject1).getManager(2);
        str1 = ((TicketManager)localObject2).getPskey(((QQAppInterface)localObject1).getCurrentAccountUin(), "connect.qq.com");
        if ((str1 != null) && (str1.length() > 0)) {
          break;
        }
        ArkAppCenter.r("ArkApp.ArkAppCGI", "queryPackageNameByAppID, pskey is null, return");
      } while (parama == null);
      parama.a(false, null, paramString, paramObject);
      return;
      localObject2 = ((TicketManager)localObject2).getSkey(((QQAppInterface)localObject1).getCurrentAccountUin());
      str2 = String.format("https://cgi.connect.qq.com/qqconnectwebsite/v2/appinfo/apkname/get?appid=%s&token=%d", new Object[] { paramString, Integer.valueOf(cH(str1)) });
    } while (a(str2, -1L, paramObject, parama));
    adqb.g localg = new adqb.g(null);
    for (Object localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin(); ((String)localObject1).length() < 10; localObject1 = "0" + (String)localObject1) {}
    localObject1 = "o" + (String)localObject1;
    localg.cookie = ("p_uin=" + (String)localObject1 + "; p_skey=" + str1 + "; uin=" + (String)localObject1 + "; skey=" + (String)localObject2);
    localg.url = str2;
    localg.userdata.add(paramObject);
    localg.callback.add(parama);
    localg.appID = paramString;
    localg.referer = "https://connect.qq.com";
    b(localg, new adqd(this));
  }
  
  public void b(String paramString, long paramLong, adqb.a parama)
  {
    if ((TextUtils.isEmpty(paramString)) || (parama == null) || (a(paramString, paramLong, null, parama))) {
      return;
    }
    adqb.f localf = new adqb.f(null);
    localf.url = paramString;
    localf.lastModifiedTime = paramLong;
    localf.callback.add(parama);
    a(localf, new adqe(this));
  }
  
  public void lO(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ArkAppCenter.r("ArkApp.ArkAppCGI", "ArkSafe,doReport=null");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)this.gj.get();
        } while (localObject == null);
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ArkAppCenter.r("ArkApp.ArkAppCGI", "ArkSafe,doReport=" + paramString);
    ((adrc)localObject).a("ArkAppReport.URLCheck", paramString, 10000, 0, new adqf(this));
  }
  
  public void onResp(aomh paramaomh)
  {
    adqb.e locale = (adqb.e)paramaomh.b.U();
    boolean bool;
    if (paramaomh.mResult == 0)
    {
      bool = true;
      if (!bool) {
        break label202;
      }
    }
    for (;;)
    {
      try
      {
        arrayOfByte = locale.rspStream.toByteArray();
        if (paramaomh.dPy == 304)
        {
          bool = true;
          paramaomh = (String)paramaomh.nR.get("param_rspHeader");
          if (!TextUtils.isEmpty(paramaomh))
          {
            paramaomh = X.matcher(paramaomh);
            if (!paramaomh.find()) {}
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          byte[] arrayOfByte;
          paramaomh = paramaomh.group(1);
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
          localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
          locale.lastModifiedTime = localSimpleDateFormat.parse(paramaomh).getTime();
          a(locale, bool, arrayOfByte);
          return;
          bool = false;
          break;
          localOutOfMemoryError = localOutOfMemoryError;
          ArkAppCenter.r("ArkApp.ArkAppCGI", String.format("ArkAppCGI.onResp, out of memory, msg=%s", new Object[] { localOutOfMemoryError.getMessage() }));
          localObject = null;
          bool = false;
        }
        catch (ParseException paramaomh)
        {
          ArkAppCenter.r("ArkApp.ArkAppCGI", String.format("lastModified time parse fail, url=%s", new Object[] { locale.url }));
          continue;
        }
        continue;
      }
      label202:
      Object localObject = null;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  
  public static class a
  {
    public void a(adqb.c paramc, Object paramObject) {}
    
    public void a(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte) {}
    
    public void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject) {}
    
    public void b(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte) {}
  }
  
  public static abstract interface b
  {
    public abstract void b(adqb.e parame, boolean paramBoolean, byte[] paramArrayOfByte);
  }
  
  public static class c
  {
    public final HashMap<String, adqb.d> resultList = new HashMap();
    public int updateInterval;
  }
  
  public static class d
  {
    public ArkAppInfo.AppDownloadInfo info;
    public String msg;
    public int retCode;
    public int state;
  }
  
  public static class e
  {
    public adqb.b a;
    public final ArrayList<adqb.a> callback = new ArrayList();
    public String cookie;
    public long lastModifiedTime = -1L;
    public byte[] postData;
    public String referer;
    public File rspFile;
    public ByteArrayOutputStream rspStream;
    public String url;
    public final ArrayList<Object> userdata = new ArrayList();
  }
  
  static class f
    extends adqb.e
  {
    private f()
    {
      super();
    }
  }
  
  static class g
    extends adqb.e
  {
    public String appID;
    
    private g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqb
 * JD-Core Version:    0.7.0.1
 */