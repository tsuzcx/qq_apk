import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public class tla
{
  public static void a(tla.a parama)
  {
    if ((parama == null) || (!parama.isValid()))
    {
      tkw.e("GdtActionReporter", "report error");
      return;
    }
    Object localObject1 = parama.ad.getUrlForAction();
    try
    {
      Object localObject2 = ((String)localObject1).replace("__TRACE_ID__", URLEncoder.encode(parama.ad.getTraceId(), "utf-8")).replace("__PAGE_ACTION_ID__", String.valueOf(parama.a.landing_page_action_type.get()));
      localObject1 = localObject2;
      if (parama.a.latency_ms.has()) {
        localObject1 = ((String)localObject2).replace("__PAGE_TIME__", String.valueOf(parama.a.latency_ms.get()));
      }
      localObject2 = localObject1;
      if (parama.a.landing_error_code.has()) {
        localObject2 = ((String)localObject1).replace("__LANDING_ERROR_CODE__", String.valueOf(parama.a.landing_error_code.get()));
      }
      parama = ((String)localObject2).replace("__OS_TYPE__", String.valueOf(2)).replace("__VERSION__", URLEncoder.encode(tkz.getQQVersion(), "utf-8"));
      tkw.i("GdtActionReporter", "GdtActionReporter report url = " + parama);
      GdtReporter.doCgiReport(parama);
      return;
    }
    catch (UnsupportedEncodingException parama)
    {
      tkw.e("GdtActionReporter", "report error", parama);
    }
  }
  
  public static class a
  {
    public landing_page_collect_data.LandingPageCollectData a = new landing_page_collect_data.LandingPageCollectData();
    public Ad ad;
    
    public boolean isValid()
    {
      return (this.ad != null) && (!TextUtils.isEmpty(this.ad.getUrlForAction())) && (!TextUtils.isEmpty(this.ad.getTraceId())) && (this.a != null) && (this.a.landing_page_action_type.has());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tla
 * JD-Core Version:    0.7.0.1
 */