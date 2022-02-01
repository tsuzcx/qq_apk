import NS_USER_ACTION_REPORT.ActionInfo;
import NS_USER_ACTION_REPORT.ItemInfo;
import NS_USER_ACTION_REPORT.PageInfo;
import NS_USER_ACTION_REPORT.TraceInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import NS_USER_ACTION_REPORT.UserCommReport;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager.ReportTask.1;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class avug
{
  private final avug.e a = new avug.e(null);
  
  @NonNull
  public static String P(@Nullable String paramString1, @Nullable String paramString2, @NonNull String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Object localObject = paramString2.split("_");
      if (localObject.length > 2)
      {
        paramString2 = localObject[0];
        String str = localObject[1];
        localObject = localObject[2];
        return paramString3 + "trace_num=1&trace_id=" + paramString1 + "_" + str + "_" + System.currentTimeMillis() + "&trace_detail_adv_pos_id=" + paramString2 + "&trace_detail_adv_id=" + str + "&trace_detail_pattern=" + (String)localObject;
      }
    }
    return "";
  }
  
  public static avug a()
  {
    return avug.f.b();
  }
  
  public static String c(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    String str1 = paramString;
    String str2;
    if (!TextUtils.isEmpty(paramString))
    {
      str2 = "";
      str1 = "";
      if (paramAppInfo != null)
      {
        paramAppInfo = avug.d.a(paramAppInfo);
        str2 = String.format("trace_id=%s&trace_num=%s&trace_detail=%s", new Object[] { paramAppInfo.traceId, String.valueOf(paramAppInfo.eyC), URLEncoder.encode(paramAppInfo.GC()) });
        if (!paramString.contains("?")) {
          break label98;
        }
      }
    }
    label98:
    for (str1 = "&";; str1 = "?")
    {
      str1 = paramString + str1 + str2;
      return str1;
    }
  }
  
  public static String cp(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("page_id", paramString2);
      paramString1 = "&trace_detail=base64-" + ajnj.mh(localJSONObject.toString());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("MobileReport.Manager", 1, "json exception" + paramString1);
    }
    return "&trace_detail=base64-";
  }
  
  public static String cq(String paramString1, String paramString2)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramString1.contains("?")) {}
    for (paramString1 = "&";; paramString1 = "?") {
      return P(str, paramString2, paramString1);
    }
  }
  
  @Nullable
  public static String e(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      paramAppInfo = avug.d.a(paramAppInfo);
      return String.format("&traceId=%s&traceNum=%s&traceDetail=%s", new Object[] { paramAppInfo.traceId, String.valueOf(paramAppInfo.eyC), URLEncoder.encode(paramAppInfo.GC()) });
    }
    return null;
  }
  
  public static String f(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null) {
      return String.format("&trace_detail=base64-%s", new Object[] { ajnj.mh(avug.c.a(paramAppInfo).GC()) });
    }
    return null;
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3)
  {
    avug.d locald;
    JSONObject localJSONObject;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))
    {
      locald = new avug.d("", 0, "", 0, "H5CostReport", paramString1);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("coreType", paramInt2);
      localJSONObject.put("coreVersion", paramString3);
      localJSONObject.put("errorcode", paramString2);
      paramString3 = new avug.b(null).a("").b(localJSONObject.toString()).a(new avug.a(System.currentTimeMillis(), paramInt1, paramLong).a()).a();
      if (QLog.isColorLevel()) {
        QLog.d("MobileReport.Manager", 2, "report " + locald.toString() + " opType = " + paramInt1 + " url = " + paramString1 + " timecost " + paramLong + " errorcode " + paramString2);
      }
      avug.e.a(this.a, locald, paramString3);
      return;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        QLog.e("MobileReport.Manager", 2, " report exception " + paramString3);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong)
  {
    paramString2 = new avug.d("", 1, "", -1, paramString1, paramString2);
    paramString3 = new avug.b(null).a("").c(paramString3).a(new avug.a(paramLong, paramInt1, paramInt2).a()).a();
    if (QLog.isColorLevel())
    {
      if (102 != paramInt1) {
        break label122;
      }
      paramString1 = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + paramString2.toString() + " actionId = " + paramString1);
      avug.e.a(this.a, paramString2, paramString3);
      return;
      label122:
      if (101 == paramInt1) {
        paramString1 = "ITEM_EXPORT";
      } else {
        paramString1 = "UNKONW";
      }
    }
  }
  
  public void b(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if (paramAppInfo == null) {
      return;
    }
    avug.d locald = avug.d.a(paramAppInfo);
    ItemInfo localItemInfo = new avug.b(null).a(locald.hT).b(paramAppInfo.buffer.get()).a(new avug.a(System.currentTimeMillis(), paramInt).a()).a();
    if (QLog.isColorLevel())
    {
      if (102 != paramInt) {
        break label122;
      }
      paramAppInfo = "ITEM_CLICK";
    }
    for (;;)
    {
      QLog.d("MobileReport.Manager", 2, "report " + locald.toString() + " actionId = " + paramAppInfo);
      avug.e.a(this.a, locald, localItemInfo);
      return;
      label122:
      if (101 == paramInt) {
        paramAppInfo = "ITEM_EXPORT";
      } else {
        paramAppInfo = "UNKONW";
      }
    }
  }
  
  public void jr(String paramString1, String paramString2)
  {
    avug.d locald;
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))
    {
      locald = new avug.d("", 0, "", 0, "JumpUrlReport", paramString1);
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("jump_url", paramString2);
      String str = awmw.parseUrlParams(paramString1).getString("adId");
      localObject = new avug.b(null).a(String.valueOf(str)).b(((JSONObject)localObject).toString()).a(new avug.a(System.currentTimeMillis(), 152, 1L).a()).a();
      if (QLog.isColorLevel()) {
        QLog.d("MobileReport.Manager", 2, "report " + locald.toString() + " opType = " + 152 + " url = " + paramString1 + " jumpUrl = " + paramString2);
      }
      avug.e.a(this.a, locald, (ItemInfo)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MobileReport.Manager", 2, " report exception " + localException);
      }
    }
  }
  
  static class a
  {
    private long aAr;
    private int actionId;
    private long operTime;
    
    public a(long paramLong, int paramInt)
    {
      this.operTime = paramLong;
      this.actionId = paramInt;
    }
    
    public a(long paramLong1, int paramInt, long paramLong2)
    {
      this.operTime = paramLong1;
      this.actionId = paramInt;
      this.aAr = paramLong2;
    }
    
    public ActionInfo a()
    {
      ActionInfo localActionInfo = new ActionInfo();
      localActionInfo.oper_time = this.operTime;
      localActionInfo.action_id = this.actionId;
      localActionInfo.action_value = this.aAr;
      return localActionInfo;
    }
  }
  
  static class b
  {
    private ArrayList<ActionInfo> EW = new ArrayList();
    private String cNP;
    private String itemId;
    private String kx = "";
    
    public ItemInfo a()
    {
      ItemInfo localItemInfo = new ItemInfo();
      localItemInfo.item_id = this.itemId;
      localItemInfo.action_infos = this.EW;
      localItemInfo.busi_info = this.cNP;
      localItemInfo.module_id = this.kx;
      return localItemInfo;
    }
    
    public b a(ActionInfo paramActionInfo)
    {
      this.EW.add(paramActionInfo);
      return this;
    }
    
    public b a(String paramString)
    {
      this.itemId = paramString;
      return this;
    }
    
    public b b(String paramString)
    {
      this.cNP = paramString;
      return this;
    }
    
    public b c(String paramString)
    {
      this.kx = paramString;
      return this;
    }
  }
  
  static class c
  {
    final String cNQ;
    final String cNR;
    final String cNS;
    final String mAppId;
    
    private c(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.mAppId = paramString1;
      this.cNQ = paramString2;
      this.cNR = paramString3;
      this.cNS = paramString4;
    }
    
    public static c a(@NonNull BusinessInfoCheckUpdate.AppInfo paramAppInfo)
    {
      String str1 = "0";
      str2 = "";
      String str3 = paramAppInfo.buffer.get();
      localObject = str2;
      paramAppInfo = str1;
      if (!TextUtils.isEmpty(str3)) {
        paramAppInfo = str1;
      }
      try
      {
        localObject = new JSONObject(str3);
        paramAppInfo = str1;
        str1 = ((JSONObject)localObject).getString("ad_id");
        paramAppInfo = str1;
        localObject = ((JSONObject)localObject).getString("pos_id");
        paramAppInfo = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject = str2;
        }
      }
      return new c("vab_red", (String)localObject, paramAppInfo, "5");
    }
    
    public String GC()
    {
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("appid", this.mAppId);
        ((JSONObject)localObject).put("page_id", this.cNQ);
        ((JSONObject)localObject).put("item_id", this.cNR);
        ((JSONObject)localObject).put("item_type", this.cNS);
        localObject = "" + ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("MobileReport.Manager", 1, "parse json exception " + localException);
      }
      return "";
    }
    
    public String toString()
    {
      return "ReportKey{appid=" + this.mAppId + ", pageId=" + this.cNQ + ", mItemId=" + this.cNR + ", mItemType=" + this.cNS + '}';
    }
  }
  
  public static class d
  {
    final int appId;
    final String cNT;
    final int eyC;
    final String hT;
    final String pageId;
    final String traceId;
    
    public d(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
    {
      this.traceId = paramString1;
      this.eyC = paramInt1;
      this.hT = paramString2;
      this.appId = paramInt2;
      this.cNT = paramString3;
      this.pageId = paramString4;
    }
    
    public static d a(@NonNull BusinessInfoCheckUpdate.AppInfo paramAppInfo)
    {
      int j = 0;
      Object localObject1 = "0";
      Object localObject2 = "0";
      Object localObject4 = paramAppInfo.buffer.get();
      Object localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject3 = localObject1;
      }
      for (;;)
      {
        try
        {
          localObject4 = new JSONObject((String)localObject4);
          localObject3 = localObject1;
          localObject1 = ((JSONObject)localObject4).getString("trace_id");
          localObject3 = localObject1;
          i = ((JSONObject)localObject4).getInt("trace_num");
          i += 1;
          int k;
          paramAppInfo.printStackTrace();
        }
        catch (Exception paramAppInfo)
        {
          try
          {
            localObject3 = ((JSONObject)localObject4).getString("ad_id");
            localObject2 = localObject3;
            k = paramAppInfo.uiAppId.get();
            j = k;
            localObject2 = localObject3;
            return new d((String)localObject1, i, (String)localObject2, j, "vab_red", "vab_red");
          }
          catch (Exception paramAppInfo)
          {
            break label123;
          }
          paramAppInfo = paramAppInfo;
          i = 0;
          localObject1 = localObject3;
        }
        label123:
        continue;
        int i = 0;
      }
    }
    
    public String GC()
    {
      return "trace_detail_ad_id=" + this.hT + "&trace_detail_app_id=" + this.appId;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (d)paramObject;
      } while ((this.eyC == paramObject.eyC) && (this.traceId.equals(paramObject.traceId)) && (this.hT.equals(paramObject.hT)) && (this.appId == paramObject.appId) && (this.cNT.equals(paramObject.cNT)) && (this.pageId.equals(paramObject.pageId)));
      return false;
    }
    
    public int hashCode()
    {
      return this.traceId.hashCode();
    }
    
    public String toString()
    {
      return "ReportKey{traceId='" + this.traceId + '\'' + ", traceNum=" + this.eyC + ", adId=" + this.hT + ", appId=" + this.appId + '}';
    }
  }
  
  public static class e
  {
    private final AtomicBoolean eG = new AtomicBoolean(false);
    private final HashMap<avug.d, ArrayList<ItemInfo>> qH = new HashMap();
    
    private void P(HashMap<avug.d, ArrayList<ItemInfo>> paramHashMap)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      ArrayList localArrayList = new ArrayList();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        avug.g localg = new avug.g(null);
        localg.a((avug.d)((Map.Entry)localObject).getKey());
        localObject = ((ArrayList)((Map.Entry)localObject).getValue()).iterator();
        while (((Iterator)localObject).hasNext()) {
          localg.a((ItemInfo)((Iterator)localObject).next());
        }
        localArrayList.add(localg.a());
      }
      anek.a(localAppRuntime, new avug.h(null).a(localAppRuntime.getLongAccountUin()).a(awmw.Hi()).a(), localArrayList);
    }
    
    private void a(avug.d paramd, ItemInfo paramItemInfo)
    {
      do
      {
        synchronized (this.qH)
        {
          ArrayList localArrayList2 = (ArrayList)this.qH.get(paramd);
          ArrayList localArrayList1 = localArrayList2;
          if (localArrayList2 == null) {
            localArrayList1 = new ArrayList();
          }
          localArrayList1.add(paramItemInfo);
          this.qH.put(paramd, localArrayList1);
          if (this.eG.compareAndSet(false, true))
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("MobileReport.Manager", 4, "start report!!!");
            }
            ThreadManager.post(new MobileReportManager.ReportTask.1(this), 2, null, true);
            return;
          }
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("MobileReport.Manager", 4, "wait to report...");
    }
  }
  
  static class f
  {
    private static final avug a = new avug();
  }
  
  static class g
  {
    private ArrayList<ItemInfo> EX = new ArrayList();
    private avug.d a;
    
    public UserActionReport a()
    {
      UserActionReport localUserActionReport = new UserActionReport();
      Object localObject = new PageInfo();
      ((PageInfo)localObject).appid = this.a.cNT;
      ((PageInfo)localObject).page_id = this.a.pageId;
      ((PageInfo)localObject).item_infos = this.EX;
      localUserActionReport.page_info = ((PageInfo)localObject);
      localObject = new TraceInfo();
      ((TraceInfo)localObject).trace_id = this.a.traceId;
      ((TraceInfo)localObject).trace_num = this.a.eyC;
      ((TraceInfo)localObject).trace_detail = this.a.GC();
      localUserActionReport.trace_info = ((TraceInfo)localObject);
      return localUserActionReport;
    }
    
    public g a(ItemInfo paramItemInfo)
    {
      this.EX.add(paramItemInfo);
      return this;
    }
    
    public g a(avug.d paramd)
    {
      this.a = paramd;
      return this;
    }
  }
  
  static class h
  {
    private String network_type;
    private long uin;
    
    public UserCommReport a()
    {
      UserCommReport localUserCommReport = new UserCommReport();
      localUserCommReport.uin = this.uin;
      localUserCommReport.platform = "AND";
      localUserCommReport.client_type = "SQ";
      localUserCommReport.network_type = this.network_type;
      return localUserCommReport;
    }
    
    public h a(long paramLong)
    {
      this.uin = paramLong;
      return this;
    }
    
    public h a(String paramString)
    {
      this.network_type = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avug
 * JD-Core Version:    0.7.0.1
 */