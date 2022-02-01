import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.qphone.base.util.QLog;

public class tue
  implements HippyQQEngine.HippyQQEngineListener
{
  public tue(ViolaFragment paramViolaFragment, Bundle paramBundle, ViewGroup paramViewGroup) {}
  
  public void onError(int paramInt, String paramString)
  {
    QLog.d("Hippy", 1, "Hippy: initHippy error statusCode=" + paramInt + ", msg=" + paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.mViolaUiDelegate.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.onHippyPageLoad(false, paramString)) {}
    while (paramInt == -11) {
      return;
    }
    ViolaFragment.access$000(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void onSuccess()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.mViolaUiDelegate.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.mViolaUiDelegate.d();
    QLog.d("Hippy", 1, "Hippy: initHippy success!");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.onHippyPageLoad(true, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tue
 * JD-Core Version:    0.7.0.1
 */