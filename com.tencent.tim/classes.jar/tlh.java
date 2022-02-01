import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public final class tlh
  implements tlb.a
{
  public int EP = -1;
  public long Ew = -2147483648L;
  tlj a = new tli(this);
  private String aJw;
  public qq_ad_get.QQAdGetRsp.AdInfo b;
  public int bBZ = -1;
  private List<String> pR;
  private List<String> pS;
  private List<String> pT;
  
  private void fm(List<String> paramList)
  {
    int i = -1;
    paramList = paramList.iterator();
    int j = 0;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      int k = j + 1;
      int m = y(str, k);
      j = k;
      i = m;
      if (m < 0)
      {
        i = y(str, k);
        j = k;
      }
    }
    anot.c(null, "dc00898", "", "", "0X8009EBF", "0X8009EBF", this.bBZ, i, "", "", this.aJw, "");
  }
  
  private int y(String paramString, int paramInt)
  {
    int k = 0;
    int j = -1;
    i = j;
    try
    {
      tkw.d("GdtC2SReporter", "index: " + paramInt + " mOpeType " + this.bBZ);
      i = j;
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      i = j;
      localHttpURLConnection.setRequestMethod("GET");
      i = j;
      localHttpURLConnection.setConnectTimeout(10000);
      i = j;
      localHttpURLConnection.setReadTimeout(10000);
      i = j;
      localHttpURLConnection.setUseCaches(false);
      i = j;
      localHttpURLConnection.setInstanceFollowRedirects(true);
      i = j;
      localHttpURLConnection.connect();
      i = j;
      j = localHttpURLConnection.getResponseCode();
      i = j;
      tkw.d("GdtC2SReporter", "rspCode:  " + j + " index: " + paramInt + " mOpeType " + this.bBZ + " reportUrl =" + paramString);
      i = j;
      int m = this.bBZ;
      if (j == 200) {}
      for (paramInt = k;; paramInt = 1)
      {
        i = j;
        anot.c(null, "dc00898", "", "", "0X8009B97", "0X8009B97", m, paramInt, "", "", this.aJw, paramString);
        return j;
      }
      return i;
    }
    catch (Throwable paramString)
    {
      tkw.e("GdtC2SReporter", "c2sReport excetpion: " + paramString.getMessage());
    }
  }
  
  public void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    int i = 1;
    this.EP = paramInt2;
    this.b = paramAdInfo;
    if (paramAdInfo == null) {}
    do
    {
      return;
      this.pR = paramAdInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.get();
      this.pS = paramAdInfo.report_info.thirdparty_monitor_urls.api_click_monitor_url.get();
      this.pT = paramAdInfo.report_info.thirdparty_monitor_urls.video_play_monitor_url.get();
      this.aJw = Long.toString(paramAdInfo.report_info.trace_info.aid.get());
    } while (this.aJw == null);
    if ((paramInt1 == 0) && (this.pR != null) && (this.pR.size() > 0)) {
      this.bBZ = paramInt1;
    }
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if ((paramInt1 == 1) && (this.pS != null) && (this.pS.size() > 0)) {
        this.bBZ = paramInt1;
      }
      if ((paramInt1 == 2) && (this.pT != null) && (this.pT.size() > 0)) {
        this.bBZ = paramInt1;
      }
      if (this.bBZ == -1) {
        break;
      }
      tkw.d("GdtC2SReporter", "reportAsync for ADID: " + this.aJw + ", operationType: " + paramInt1);
      this.Ew = System.currentTimeMillis();
      paramAdInfo = BaseApplicationImpl.getApplication().getRuntime();
      String str = paramAdInfo.getAccount();
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), tlk.class);
      localNewIntent.putExtra("key_uin", str);
      localNewIntent.putExtra("key_adID", this.aJw);
      paramInt1 = i;
      if (paramInt2 != 0) {
        paramInt1 = 0;
      }
      localNewIntent.putExtra("key_operation", paramInt1);
      localNewIntent.setObserver(this.a);
      paramAdInfo.startServlet(localNewIntent);
      anot.c(null, "dc00898", "", "", "0X8009EBC", "0X8009EBC", this.bBZ, 0, "", "", this.aJw, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tlh
 * JD-Core Version:    0.7.0.1
 */