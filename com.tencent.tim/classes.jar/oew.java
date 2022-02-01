import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.net.URLDecoder;

class oew
  implements opn.a
{
  oew(oev paramoev, Context paramContext) {}
  
  public void aU(String paramString, int paramInt)
  {
    opb.a(oev.a(this.a), "biz_src_jc_gzh_weishi", paramString, 1, oev.a(this.a).link_strategy_type, oev.a(this.a));
    ond.reportRichBlockDialog(114, oev.b(this.a), oev.c(this.a), this.a.a.windowsid);
    ong.Y(114, this.a.a.type, this.a.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.a.a.windowsid, this.a.a.trace_id);
  }
  
  public void aV(String paramString, int paramInt)
  {
    if ((this.val$finalContext instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      kxm.C(oev.a(this.a), paramString);
      ooz.i("weishi-813", "阻断rich弹窗:" + paramString);
      ond.reportRichBlockDialog(140, oev.b(this.a), oev.c(this.a), this.a.a.windowsid);
      ong.Y(140, this.a.a.type, this.a.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.a.a.windowsid, this.a.a.trace_id);
      return;
    }
    ooz.w("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void aW(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = oev.a(this.a).link_strategy_type;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = ong.lD();
    localWSDownloadParams.mScheme = paramString;
    oir.a((Activity)oev.a(this.a), localWSDownloadParams, false);
    ong.Y(115, this.a.a.type, this.a.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.a.a.windowsid, this.a.a.trace_id);
  }
  
  public void aX(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oew
 * JD-Core Version:    0.7.0.1
 */