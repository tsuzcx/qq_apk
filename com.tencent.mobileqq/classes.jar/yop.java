import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
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

public final class yop
  implements yog
{
  public int a;
  public long a;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  public qq_ad_get.QQAdGetRsp.AdInfo a;
  yor jdField_a_of_type_Yor = new yoq(this);
  public int b;
  private List<String> b;
  private List<String> c;
  
  public yop()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = -2147483648L;
  }
  
  private int a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis();
    yom.a(BaseApplicationImpl.getApplication(), this, paramString);
    j = -1;
    i = j;
    for (;;)
    {
      try
      {
        yny.a("GdtC2SReporter", "index: " + paramInt + " mOpeType " + this.jdField_a_of_type_Int);
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
        yny.a("GdtC2SReporter", "rspCode:  " + j + " index: " + paramInt + " mOpeType " + this.jdField_a_of_type_Int + " reportUrl =" + paramString);
        i = j;
        int k = this.jdField_a_of_type_Int;
        if (j != 200) {
          continue;
        }
        paramInt = 0;
        i = j;
        awqx.a(null, "dc00898", "", "", "0X8009B97", "0X8009B97", k, paramInt, "", "", this.jdField_a_of_type_JavaLangString, paramString);
      }
      catch (Throwable localThrowable)
      {
        yny.d("GdtC2SReporter", "c2sReport excetpion: " + localThrowable.getMessage());
        j = i;
        continue;
      }
      yom.a(BaseApplicationImpl.getApplication(), this, paramString, j, System.currentTimeMillis() - l);
      return j;
      paramInt = 1;
    }
  }
  
  private void a(List<String> paramList)
  {
    int i = -1;
    paramList = paramList.iterator();
    int j = 0;
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      j += 1;
      int k = a(str, j);
      i = k;
      if (k < 0) {
        i = a(str, j);
      }
      yom.a(BaseApplicationImpl.getApplication(), this, str, i);
    }
    awqx.a(null, "dc00898", "", "", "0X8009EBF", "0X8009EBF", this.jdField_a_of_type_Int, i, "", "", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    int j = 1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo = paramAdInfo;
    if (paramAdInfo == null) {}
    do
    {
      yom.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, false);
      return;
      this.jdField_a_of_type_JavaUtilList = paramAdInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.get();
      this.jdField_b_of_type_JavaUtilList = paramAdInfo.report_info.thirdparty_monitor_urls.api_click_monitor_url.get();
      this.c = paramAdInfo.report_info.thirdparty_monitor_urls.video_play_monitor_url.get();
      this.jdField_a_of_type_JavaLangString = Long.toString(paramAdInfo.report_info.trace_info.aid.get());
    } while (this.jdField_a_of_type_JavaLangString == null);
    if ((paramInt1 == 0) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt1 == 1) && (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Int = paramInt1;
      }
      if ((paramInt1 == 2) && (this.c != null) && (this.c.size() > 0)) {
        this.jdField_a_of_type_Int = paramInt1;
      }
      if (this.jdField_a_of_type_Int == -1) {
        break;
      }
      yny.a("GdtC2SReporter", "reportAsync for ADID: " + this.jdField_a_of_type_JavaLangString + ", operationType: " + paramInt1);
      yom.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, true);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramAdInfo = BaseApplicationImpl.getApplication().getRuntime();
      String str = paramAdInfo.getAccount();
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), yos.class);
      localNewIntent.putExtra("key_uin", str);
      localNewIntent.putExtra("key_adID", this.jdField_a_of_type_JavaLangString);
      paramInt1 = j;
      if (i != 0) {
        paramInt1 = 0;
      }
      localNewIntent.putExtra("key_operation", paramInt1);
      localNewIntent.setObserver(this.jdField_a_of_type_Yor);
      paramAdInfo.startServlet(localNewIntent);
      awqx.a(null, "dc00898", "", "", "0X8009EBC", "0X8009EBC", this.jdField_a_of_type_Int, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yop
 * JD-Core Version:    0.7.0.1
 */