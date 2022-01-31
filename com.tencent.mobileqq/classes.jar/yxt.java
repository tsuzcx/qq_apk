import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class yxt
{
  public static void a(yxu paramyxu)
  {
    if ((paramyxu == null) || (!paramyxu.a()))
    {
      yxp.d("GdtActionReporter", "report error");
      return;
    }
    Object localObject1 = paramyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction();
    try
    {
      Object localObject2 = ((String)localObject1).replace("__TRACE_ID__", URLEncoder.encode(paramyxu.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(paramyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.get()));
      localObject1 = localObject2;
      if (paramyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.has()) {
        localObject1 = ((String)localObject2).replace("__PAGE_TIME__", String.valueOf(paramyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.get()));
      }
      localObject2 = localObject1;
      if (paramyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.has()) {
        localObject2 = ((String)localObject1).replace("__LANDING_ERROR_CODE__", String.valueOf(paramyxu.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.get()));
      }
      paramyxu = ((String)localObject2).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(yxs.a(), "utf-8"));
      yxp.b("GdtActionReporter", "GdtActionReporter report url = " + paramyxu);
      yyb.a(paramyxu);
      return;
    }
    catch (UnsupportedEncodingException paramyxu)
    {
      yxp.d("GdtActionReporter", "report error", paramyxu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxt
 * JD-Core Version:    0.7.0.1
 */