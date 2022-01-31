import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class yod
{
  public static void a(yoe paramyoe)
  {
    if ((paramyoe == null) || (!paramyoe.a()))
    {
      yny.d("GdtActionReporter", "report error");
      return;
    }
    Object localObject1 = paramyoe.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForAction();
    try
    {
      Object localObject2 = ((String)localObject1).replace("__TRACE_ID__", URLEncoder.encode(paramyoe.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(paramyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.get()));
      localObject1 = localObject2;
      if (paramyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.has()) {
        localObject1 = ((String)localObject2).replace("__PAGE_TIME__", String.valueOf(paramyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.get()));
      }
      localObject2 = localObject1;
      if (paramyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.has()) {
        localObject2 = ((String)localObject1).replace("__LANDING_ERROR_CODE__", String.valueOf(paramyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_error_code.get()));
      }
      paramyoe = ((String)localObject2).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(yoc.a(), "utf-8"));
      yny.b("GdtActionReporter", "GdtActionReporter report url = " + paramyoe);
      yol.a(paramyoe);
      return;
    }
    catch (UnsupportedEncodingException paramyoe)
    {
      yny.d("GdtActionReporter", "report error", paramyoe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yod
 * JD-Core Version:    0.7.0.1
 */