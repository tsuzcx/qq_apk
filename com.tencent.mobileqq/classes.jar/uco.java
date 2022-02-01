import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.net.URLDecoder;

class uco
  implements ura
{
  uco(ucn paramucn, Context paramContext) {}
  
  public void a(String paramString, int paramInt)
  {
    uqh.a(ucn.a(this.jdField_a_of_type_Ucn), "biz_src_jc_gzh_weishi", paramString, 1, ucn.a(this.jdField_a_of_type_Ucn).link_strategy_type, ucn.a(this.jdField_a_of_type_Ucn));
    uno.a(114, ucn.b(this.jdField_a_of_type_Ucn), ucn.c(this.jdField_a_of_type_Ucn), this.jdField_a_of_type_Ucn.a.windowsid);
    ucn.a(this.jdField_a_of_type_Ucn, 114, "popup_clk_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.jdField_a_of_type_Ucn.a.windowsid, this.jdField_a_of_type_Ucn.a.trace_id, ucn.a(this.jdField_a_of_type_Ucn));
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      ozs.d(ucn.a(this.jdField_a_of_type_Ucn), paramString);
      uqf.a("weishi-813", "阻断rich弹窗:" + paramString);
      uno.a(140, ucn.b(this.jdField_a_of_type_Ucn), ucn.c(this.jdField_a_of_type_Ucn), this.jdField_a_of_type_Ucn.a.windowsid);
      unx.c(140, this.jdField_a_of_type_Ucn.a.type, this.jdField_a_of_type_Ucn.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.jdField_a_of_type_Ucn.a.windowsid, this.jdField_a_of_type_Ucn.a.trace_id, ucn.a(this.jdField_a_of_type_Ucn));
      return;
    }
    uqf.c("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = ucn.a(this.jdField_a_of_type_Ucn).link_strategy_type;
    paramInt = 401;
    if (!ucn.a(this.jdField_a_of_type_Ucn)) {
      paramInt = 402;
    }
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = unx.b();
    localWSDownloadParams.mScheme = paramString;
    ugz.a((Activity)ucn.a(this.jdField_a_of_type_Ucn), localWSDownloadParams, false);
    ucn.a(this.jdField_a_of_type_Ucn, 115, "popup_dl_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.jdField_a_of_type_Ucn.a.windowsid, this.jdField_a_of_type_Ucn.a.trace_id, ucn.a(this.jdField_a_of_type_Ucn));
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uco
 * JD-Core Version:    0.7.0.1
 */