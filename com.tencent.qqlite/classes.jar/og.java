import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.LocListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.concurrent.atomic.AtomicInteger;

public class og
  implements Runnable
{
  public og(PublicAccountJavascriptInterface.LocListener paramLocListener) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "-2", "{type:1, data:null}" });
    String str = Long.toString(System.currentTimeMillis() - this.a.jdField_a_of_type_Long);
    ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 3, this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), str, "", "");
    if (PublicAccountJavascriptInterface.a.decrementAndGet() == 0) {
      SOSOMapLBSApi.getInstance().removeLocationUpdate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     og
 * JD-Core Version:    0.7.0.1
 */