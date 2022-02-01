import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.gdtad.api.GdtAd;
import org.json.JSONObject;

final class tjk
  implements abla
{
  tjk(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onAdClicked(GdtAd paramGdtAd) {}
  
  public void onAdClosed(GdtAd paramGdtAd) {}
  
  public void onAdFailedToLoad(GdtAd paramGdtAd, abkz paramabkz)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, paramabkz.a());
  }
  
  public void onAdImpression(GdtAd paramGdtAd) {}
  
  public void onAdLoaded(GdtAd paramGdtAd)
  {
    Object localObject = twt.a(paramGdtAd);
    paramGdtAd = new JSONObject();
    for (;;)
    {
      try
      {
        paramGdtAd.put("adInfo", localObject);
        if (localObject != null) {
          continue;
        }
        paramGdtAd.put("retCode", -1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramGdtAd);
      return;
      paramGdtAd.put("retCode", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tjk
 * JD-Core Version:    0.7.0.1
 */