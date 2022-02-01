import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.net.URLDecoder;

class uxb
  implements vnn
{
  uxb(uxa paramuxa, Context paramContext) {}
  
  public void a(String paramString, int paramInt)
  {
    vmr.a(uxa.a(this.jdField_a_of_type_Uxa), "biz_src_jc_gzh_weishi", paramString, 1, uxa.a(this.jdField_a_of_type_Uxa).link_strategy_type, uxa.a(this.jdField_a_of_type_Uxa));
    vjx.a(114, uxa.b(this.jdField_a_of_type_Uxa), uxa.c(this.jdField_a_of_type_Uxa), this.jdField_a_of_type_Uxa.a.windowsid);
    uxa.a(this.jdField_a_of_type_Uxa, 114, "popup_clk_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.jdField_a_of_type_Uxa.a.windowsid, this.jdField_a_of_type_Uxa.a.trace_id, uxa.a(this.jdField_a_of_type_Uxa));
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      pqx.a(uxa.a(this.jdField_a_of_type_Uxa), paramString);
      vmp.a("weishi-813", "阻断rich弹窗:" + paramString);
      vjx.a(140, uxa.b(this.jdField_a_of_type_Uxa), uxa.c(this.jdField_a_of_type_Uxa), this.jdField_a_of_type_Uxa.a.windowsid);
      vkf.c(140, this.jdField_a_of_type_Uxa.a.type, this.jdField_a_of_type_Uxa.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.jdField_a_of_type_Uxa.a.windowsid, this.jdField_a_of_type_Uxa.a.trace_id, uxa.a(this.jdField_a_of_type_Uxa));
      return;
    }
    vmp.c("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = uxa.a(this.jdField_a_of_type_Uxa).link_strategy_type;
    paramInt = 401;
    if (!uxa.a(this.jdField_a_of_type_Uxa)) {
      paramInt = 402;
    }
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = vkf.b();
    localWSDownloadParams.mScheme = paramString;
    vbq.a((Activity)uxa.a(this.jdField_a_of_type_Uxa), localWSDownloadParams, false);
    uxa.a(this.jdField_a_of_type_Uxa, 115, "popup_dl_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.jdField_a_of_type_Uxa.a.windowsid, this.jdField_a_of_type_Uxa.a.trace_id, uxa.a(this.jdField_a_of_type_Uxa));
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxb
 * JD-Core Version:    0.7.0.1
 */