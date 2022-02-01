import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.net.URLDecoder;

class ucm
  implements upz
{
  ucm(ucl paramucl, Context paramContext) {}
  
  public void a(String paramString, int paramInt)
  {
    upg.a(ucl.a(this.jdField_a_of_type_Ucl), "biz_src_jc_gzh_weishi", paramString, 1, ucl.a(this.jdField_a_of_type_Ucl).link_strategy_type, ucl.a(this.jdField_a_of_type_Ucl));
    umq.a(114, ucl.b(this.jdField_a_of_type_Ucl), ucl.c(this.jdField_a_of_type_Ucl), this.jdField_a_of_type_Ucl.a.windowsid);
    ucl.a(this.jdField_a_of_type_Ucl, 114, "popup_clk_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.jdField_a_of_type_Ucl.a.windowsid, this.jdField_a_of_type_Ucl.a.trace_id, ucl.a(this.jdField_a_of_type_Ucl));
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      pha.d(ucl.a(this.jdField_a_of_type_Ucl), paramString);
      upe.a("weishi-813", "阻断rich弹窗:" + paramString);
      umq.a(140, ucl.b(this.jdField_a_of_type_Ucl), ucl.c(this.jdField_a_of_type_Ucl), this.jdField_a_of_type_Ucl.a.windowsid);
      umw.c(140, this.jdField_a_of_type_Ucl.a.type, this.jdField_a_of_type_Ucl.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.jdField_a_of_type_Ucl.a.windowsid, this.jdField_a_of_type_Ucl.a.trace_id, ucl.a(this.jdField_a_of_type_Ucl));
      return;
    }
    upe.c("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = ucl.a(this.jdField_a_of_type_Ucl).link_strategy_type;
    paramInt = 401;
    if (!ucl.a(this.jdField_a_of_type_Ucl)) {
      paramInt = 402;
    }
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = umw.b();
    localWSDownloadParams.mScheme = paramString;
    ugx.a((Activity)ucl.a(this.jdField_a_of_type_Ucl), localWSDownloadParams, false);
    ucl.a(this.jdField_a_of_type_Ucl, 115, "popup_dl_ws");
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.jdField_a_of_type_Ucl.a.windowsid, this.jdField_a_of_type_Ucl.a.trace_id, ucl.a(this.jdField_a_of_type_Ucl));
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucm
 * JD-Core Version:    0.7.0.1
 */