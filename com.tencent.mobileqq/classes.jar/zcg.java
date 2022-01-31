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

public class zcg
  implements zcd
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -2147483648L;
  private zcf jdField_a_of_type_Zcf;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -2147483648L;
  
  public zcg(zcf paramzcf)
  {
    this.jdField_a_of_type_Zcf = paramzcf;
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_Long == -2147483648L) {
      return -2147483648L;
    }
    return SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
  }
  
  private String a(String paramString)
  {
    String str2 = "";
    if (this.jdField_a_of_type_Zcf != null) {}
    for (Activity localActivity = this.jdField_a_of_type_Zcf.a();; localActivity = null)
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
  
  private void a(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_REDIRECT_FAIL -- 2 -- \t" + a());
    yxu localyxu = new yxu();
    localyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(2);
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(a());
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a(localyxu);
  }
  
  private void a(GdtAd paramGdtAd, int paramInt, Map<String, Object> paramMap)
  {
    Log.i("GdtWebReportQQ", "ACTION_LOAD_FAILED -- 4 -- " + paramInt + "\t" + a());
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
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
    paramMap = new yxu();
    paramMap.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    paramMap.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(4);
    paramMap.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(a());
    paramMap.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(paramInt);
    a(paramMap);
  }
  
  public static void a(yxu paramyxu)
  {
    if (paramyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.has()) {
      yxt.a(paramyxu);
    }
  }
  
  public static boolean a(String paramString)
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
  
  private long b()
  {
    if (this.jdField_b_of_type_Long == -2147483648L) {
      return -2147483648L;
    }
    return SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
  }
  
  private void b(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_REDIRECT_SUCESS -- 1 -- \t" + a());
    yxu localyxu = new yxu();
    localyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(1);
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(a());
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a(localyxu);
  }
  
  private void c(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_BACK -- 5 -- \t" + a());
    yxu localyxu = new yxu();
    localyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(5);
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(b());
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a(localyxu);
  }
  
  private void d(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_PAUSE -- 6 -- \t" + a());
    yxu localyxu = new yxu();
    localyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(6);
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(b());
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a(localyxu);
  }
  
  private void e(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_EXIT -- 7 -- \t" + a());
    yxu localyxu = new yxu();
    localyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(7);
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(b());
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a(localyxu);
  }
  
  private void f(GdtAd paramGdtAd)
  {
    Log.i("GdtWebReportQQ", "ACTION_LOAD_SUCCESS -- 3 -- \t" + a());
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    yxu localyxu = new yxu();
    localyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(3);
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(a());
    localyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.set(0);
    a(localyxu);
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    Object localObject1 = a("GdtWebReportQQ_ACTION_URL");
    Object localObject2 = a("GdtWebReportQQ_TRACE_ID");
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
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (this.jdField_b_of_type_Int == 1)
      {
        if ((paramLong != 8589934593L) || (this.jdField_a_of_type_Int != 1) || (a(paramString))) {
          break label434;
        }
        b((GdtAd)localObject1);
        this.jdField_b_of_type_Int = 2;
      }
      break;
    }
    for (;;)
    {
      return false;
      if (paramLong != 8589934593L) {
        break;
      }
      if ((a(paramString)) && (this.jdField_b_of_type_Int == 0)) {
        this.jdField_b_of_type_Int = 1;
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Int = 1;
      break;
      if (paramLong == 8589934594L)
      {
        this.jdField_a_of_type_Int = 2;
        f((GdtAd)localObject1);
        break;
      }
      if (paramLong == 8589934595L)
      {
        this.jdField_a_of_type_Int = 3;
        a((GdtAd)localObject1, 1, paramMap);
        break;
      }
      if (paramLong == 8589934601L)
      {
        this.jdField_a_of_type_Int = 4;
        a((GdtAd)localObject1, 94, paramMap);
        c((GdtAd)localObject1);
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.jdField_a_of_type_Int = 4;
      a((GdtAd)localObject1, 95, paramMap);
      d((GdtAd)localObject1);
      break;
      if ((paramLong != 8589934601L) && (paramLong != 8589934597L)) {
        break;
      }
      e((GdtAd)localObject1);
      this.jdField_a_of_type_Int = 4;
      break;
      if (paramLong == 8589934593L)
      {
        this.jdField_a_of_type_Int = 4;
        c((GdtAd)localObject1);
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.jdField_a_of_type_Int = 4;
      d((GdtAd)localObject1);
      break;
      label434:
      if ((a(paramString)) && ((paramLong == 8589934598L) || (paramLong == 8589934595L)))
      {
        this.jdField_b_of_type_Int = 2;
        a((GdtAd)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zcg
 * JD-Core Version:    0.7.0.1
 */