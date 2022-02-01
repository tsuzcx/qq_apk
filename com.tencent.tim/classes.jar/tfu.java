import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.report.AdRefreshCallback;
import com.tencent.ad.tangram.canvas.report.AdReportAdapter;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.gdtad.aditem.GdtAd;

public class tfu
  implements AdReportAdapter
{
  public void downloadReport(Ad paramAd, String paramString, int paramInt, boolean paramBoolean, AdAppBtnData paramAdAppBtnData)
  {
    if ((!(paramAd instanceof GdtAd)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    tlu.a().a(paramString, (GdtAd)paramAd, paramAdAppBtnData);
    tlu.a().a((GdtAd)paramAd, paramInt, paramBoolean);
  }
  
  public AdRefreshCallback getAdReportAdapter()
  {
    return tlu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfu
 * JD-Core Version:    0.7.0.1
 */