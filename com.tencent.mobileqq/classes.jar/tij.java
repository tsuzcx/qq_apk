import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class tij
  implements TopGestureLayout.OnGestureListener
{
  public tij(BridgeModule paramBridgeModule, ViolaFragment paramViolaFragment) {}
  
  public void flingLToR()
  {
    if ((BridgeModule.access$1700(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule) != null) && (BridgeModule.access$1700(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).b()))
    {
      BridgeModule.access$1700(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule).a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.judgeIfNeedInterruptLToR();
  }
  
  public void flingRToL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tij
 * JD-Core Version:    0.7.0.1
 */