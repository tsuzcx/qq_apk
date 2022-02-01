import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.net.URL;
import java.util.Map;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class tng
  implements tnd
{
  private long Ey = -2147483648L;
  private long Ez = -2147483648L;
  private tnf a;
  private int bCu;
  private int state = 0;
  
  public tng(tnf paramtnf)
  {
    this.a = paramtnf;
  }
  
  private void a(GdtAd paramGdtAd, int paramInt, Map<String, Object> paramMap)
  {
    Log.i("GdtWebReportQQ", "ACTION_LOAD_FAILED -- 4 -- " + paramInt + "\t" + eh());
    this.Ez = SystemClock.elapsedRealtime();
    int i = 0;
    paramInt = i;
    if (paramMap != null)
    {
      paramInt = i;
      if (paramMap.containsKey("errorCode"))
      {
        paramInt = i;
        if ((paramMap.get("errorCode") instanceof Integer)) {
          paramInt = Math.abs(((Integer)paramMap.get("errorCode")).intValue());
        }
      }
    }
    paramMap = new tla.a();
    paramMap.ad = paramGdtAd;
    paramMap.a.landing_page_action_type.set(4);
    paramMap.a.latency_ms.set(eh());
    paramMap.a.landing_error_code.set(paramInt);
    a(paramMap);
  }
  
  public static void a(tla.a parama)
  {
    if (parama.a.latency_ms.has()) {
      tla.a(parama);
    }
  }
  
  private void e(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_REDIRECT_FAIL -- 2 -- \t" + eh());
    tla.a locala = new tla.a();
    locala.ad = paramGdtAd;
    locala.a.landing_page_action_type.set(2);
    locala.a.latency_ms.set(eh());
    locala.a.landing_error_code.set(0);
    a(locala);
  }
  
  private long eh()
  {
    if (this.Ey == -2147483648L) {
      return -2147483648L;
    }
    return SystemClock.elapsedRealtime() - this.Ey;
  }
  
  private void f(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_REDIRECT_SUCESS -- 1 -- \t" + eh());
    tla.a locala = new tla.a();
    locala.ad = paramGdtAd;
    locala.a.landing_page_action_type.set(1);
    locala.a.latency_ms.set(eh());
    locala.a.landing_error_code.set(0);
    a(locala);
  }
  
  private void g(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_BACK -- 5 -- \t" + eh());
    tla.a locala = new tla.a();
    locala.ad = paramGdtAd;
    locala.a.landing_page_action_type.set(5);
    locala.a.latency_ms.set(getStayTime());
    locala.a.landing_error_code.set(0);
    a(locala);
  }
  
  public static boolean gJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new URL(paramString).getHost();
        String[] arrayOfString = "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com".split("#");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramString.equals(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramString) {}
    }
  }
  
  private long getStayTime()
  {
    if (this.Ez == -2147483648L) {
      return -2147483648L;
    }
    return SystemClock.elapsedRealtime() - this.Ez;
  }
  
  private String getStringExtra(String paramString)
  {
    String str2 = "";
    if (this.a != null) {}
    for (Activity localActivity = this.a.getActivity();; localActivity = null)
    {
      String str1 = str2;
      if (localActivity != null)
      {
        str1 = str2;
        if (localActivity.getIntent() != null) {
          str1 = localActivity.getIntent().getStringExtra(paramString);
        }
      }
      Log.i("GdtWebReportQQ", "name = " + paramString + ", s = " + str1);
      return str1;
    }
  }
  
  private void h(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_PAUSE -- 6 -- \t" + eh());
    tla.a locala = new tla.a();
    locala.ad = paramGdtAd;
    locala.a.landing_page_action_type.set(6);
    locala.a.latency_ms.set(getStayTime());
    locala.a.landing_error_code.set(0);
    a(locala);
  }
  
  private void i(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_EXIT -- 7 -- \t" + eh());
    tla.a locala = new tla.a();
    locala.ad = paramGdtAd;
    locala.a.landing_page_action_type.set(7);
    locala.a.latency_ms.set(getStayTime());
    locala.a.landing_error_code.set(0);
    a(locala);
  }
  
  private void j(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_LOAD_SUCCESS -- 3 -- \t" + eh());
    this.Ez = SystemClock.elapsedRealtime();
    tla.a locala = new tla.a();
    locala.ad = paramGdtAd;
    locala.a.landing_page_action_type.set(3);
    locala.a.latency_ms.set(eh());
    locala.a.landing_error_code.set(0);
    a(locala);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject1 = getStringExtra("GdtWebReportQQ_ACTION_URL");
    Object localObject2 = getStringExtra("GdtWebReportQQ_TRACE_ID");
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      Log.i("GdtWebReportQQ", "ljh, empty traceURL or traceID");
      return false;
    }
    qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo localTraceInfo = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    localTraceInfo.traceid.set((String)localObject2);
    localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).landing_page_report_url.set((String)localObject1);
    ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo)localObject2).trace_info.set(localTraceInfo);
    localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo();
    ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.set((MessageMicro)localObject2);
    localObject1 = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
    switch (this.state)
    {
    default: 
      if (this.bCu == 1)
      {
        if ((paramLong != 8589934593L) || (this.state != 1) || (gJ(paramString))) {
          break label434;
        }
        f((GdtAd)localObject1);
        this.bCu = 2;
      }
      break;
    }
    for (;;)
    {
      return false;
      if (paramLong != 8589934593L) {
        break;
      }
      if ((gJ(paramString)) && (this.bCu == 0)) {
        this.bCu = 1;
      }
      this.Ey = SystemClock.elapsedRealtime();
      this.state = 1;
      break;
      if (paramLong == 8589934594L)
      {
        this.state = 2;
        j((GdtAd)localObject1);
        break;
      }
      if (paramLong == 8589934595L)
      {
        this.state = 3;
        a((GdtAd)localObject1, 1, paramMap);
        break;
      }
      if (paramLong == 8589934601L)
      {
        this.state = 4;
        a((GdtAd)localObject1, 94, paramMap);
        g((GdtAd)localObject1);
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.state = 4;
      a((GdtAd)localObject1, 95, paramMap);
      h((GdtAd)localObject1);
      break;
      if ((paramLong != 8589934601L) && (paramLong != 8589934597L)) {
        break;
      }
      i((GdtAd)localObject1);
      this.state = 4;
      break;
      if (paramLong == 8589934593L)
      {
        this.state = 4;
        g((GdtAd)localObject1);
        this.Ey = SystemClock.elapsedRealtime();
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.state = 4;
      h((GdtAd)localObject1);
      break;
      label434:
      if ((gJ(paramString)) && ((paramLong == 8589934598L) || (paramLong == 8589934595L)))
      {
        this.bCu = 2;
        e((GdtAd)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tng
 * JD-Core Version:    0.7.0.1
 */