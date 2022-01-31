import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class yxb
  implements yxh
{
  private GdtDwellTimeStatisticsAfterClick a;
  
  public boolean a(ywn paramywn, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramywn != null) {}
    GdtHandler.Params localParams;
    for (Activity localActivity = paramywn.a();; localActivity = null)
    {
      localParams = new GdtHandler.Params();
      boolean bool = GdtHandler.a(localParams, paramVarArgs[0]);
      if ((paramywn != null) && (localActivity != null) && (bool)) {
        break;
      }
      yxs.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        yxs.b("GdtHandleAdJsCallHandler", new JSONObject(paramVarArgs[0]).toString());
        localParams.c = 7;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
        localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramywn.a());
        localParams.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
        localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
        paramVarArgs = paramywn.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
          this.a = new GdtDwellTimeStatisticsAfterClick(localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd, new WeakReference(paramywn.mRuntime.a()));
          this.a.a();
          GdtHandler.a(localParams);
          paramywn.callJs(paramString, null);
          paramString = localObject;
          if (paramywn != null) {
            paramString = paramywn.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "handleClick", paramString, localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
          return true;
        }
      }
      catch (Throwable paramywn)
      {
        yxs.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error", paramywn);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxb
 * JD-Core Version:    0.7.0.1
 */