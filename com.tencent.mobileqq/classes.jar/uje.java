import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.net.URLDecoder;

class uje
  implements uyv
{
  uje(ujd paramujd, Context paramContext) {}
  
  public void a(String paramString, int paramInt)
  {
    uyc.a(ujd.a(this.jdField_a_of_type_Ujd), "biz_src_jc_gzh_weishi", paramString, 1, ujd.a(this.jdField_a_of_type_Ujd).link_strategy_type, ujd.a(this.jdField_a_of_type_Ujd));
    uvi.a(114, ujd.b(this.jdField_a_of_type_Ujd), ujd.c(this.jdField_a_of_type_Ujd), this.jdField_a_of_type_Ujd.a.windowsid);
    ujd.a(this.jdField_a_of_type_Ujd, 114, "popup_clk_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.jdField_a_of_type_Ujd.a.windowsid, this.jdField_a_of_type_Ujd.a.trace_id, ujd.a(this.jdField_a_of_type_Ujd));
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      pay.d(ujd.a(this.jdField_a_of_type_Ujd), paramString);
      uya.a("weishi-813", "阻断rich弹窗:" + paramString);
      uvi.a(140, ujd.b(this.jdField_a_of_type_Ujd), ujd.c(this.jdField_a_of_type_Ujd), this.jdField_a_of_type_Ujd.a.windowsid);
      uvr.c(140, this.jdField_a_of_type_Ujd.a.type, this.jdField_a_of_type_Ujd.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.jdField_a_of_type_Ujd.a.windowsid, this.jdField_a_of_type_Ujd.a.trace_id, ujd.a(this.jdField_a_of_type_Ujd));
      return;
    }
    uya.c("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = ujd.a(this.jdField_a_of_type_Ujd).link_strategy_type;
    paramInt = 401;
    if (!ujd.a(this.jdField_a_of_type_Ujd)) {
      paramInt = 402;
    }
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = uvr.b();
    localWSDownloadParams.mScheme = paramString;
    unq.a((Activity)ujd.a(this.jdField_a_of_type_Ujd), localWSDownloadParams, false);
    ujd.a(this.jdField_a_of_type_Ujd, 115, "popup_dl_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.jdField_a_of_type_Ujd.a.windowsid, this.jdField_a_of_type_Ujd.a.trace_id, ujd.a(this.jdField_a_of_type_Ujd));
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uje
 * JD-Core Version:    0.7.0.1
 */