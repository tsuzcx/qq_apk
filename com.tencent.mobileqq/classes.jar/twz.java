import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

final class twz
  extends LbsManagerService.OnLocationChangeListener
{
  twz(String paramString1, BridgeModule paramBridgeModule, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      twu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, paramSosoLbsInfo, this.jdField_a_of_type_JavaLangString);
      return;
    }
    twu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_JavaLangString, "errorCode: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     twz
 * JD-Core Version:    0.7.0.1
 */