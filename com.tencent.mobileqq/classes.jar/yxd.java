import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import org.json.JSONObject;

class yxd
  implements yxe
{
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 0;
    }
    if (paramInt == 2) {
      return 8;
    }
    return -2147483648;
  }
  
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramywk != null) {}
    GdtHandler.Options localOptions;
    for (Activity localActivity = paramywk.a();; localActivity = null)
    {
      localOptions = new GdtHandler.Options();
      boolean bool = GdtHandler.a(localOptions, paramVarArgs[0]);
      if ((paramywk != null) && (localActivity != null) && (bool)) {
        break;
      }
      yxp.d("GdtInterstitialJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        yxp.b("GdtInterstitialJsCallHandler", paramVarArgs.toString());
        int i = a(paramVarArgs.getJSONObject("options").optInt("orientation"));
        paramVarArgs = paramywk.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localOptions.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localOptions.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
          paramVarArgs = new GdtInterstitialParams();
          paramVarArgs.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options = localOptions;
          paramVarArgs.jdField_a_of_type_Int = i;
          paramVarArgs.jdField_a_of_type_Boolean = true;
          GdtInterstitialFragment.a(localActivity, paramVarArgs);
          paramywk.callJs(paramString, null);
          paramString = localObject;
          if (paramywk != null) {
            paramString = paramywk.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, true, "showInterstitial", paramString, localOptions.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
          return true;
        }
      }
      catch (Throwable paramywk)
      {
        yxp.d("GdtInterstitialJsCallHandler", "handleJsCallRequest error", paramywk);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxd
 * JD-Core Version:    0.7.0.1
 */