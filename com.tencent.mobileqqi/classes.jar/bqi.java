import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.LocListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.statistics.ReportController;

public class bqi
  implements Runnable
{
  public bqi(PublicAccountJavascriptInterface.LocListener paramLocListener) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "-2", "{type:1, data:null}" });
    String str = Long.toString(System.currentTimeMillis() - this.a.jdField_a_of_type_Long);
    ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 3, this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), str, "", "");
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bqi
 * JD-Core Version:    0.7.0.1
 */