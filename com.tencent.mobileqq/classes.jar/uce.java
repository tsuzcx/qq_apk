import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.18.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

public class uce
  implements ucm
{
  public uce(ViolaBaseView paramViolaBaseView, boolean paramBoolean, long paramLong) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.TIME_BIZ_JS_OFFLINE, Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isColorLevel()) {
      ThreadManager.post(new ViolaBaseView.18.1(this, paramString), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uce
 * JD-Core Version:    0.7.0.1
 */