import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

class ynk
  implements ynl
{
  private GdtDwellTimeStatisticsAfterClick a;
  
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    if (paramymw != null) {}
    for (Activity localActivity = paramymw.a(); (paramymw == null) || (localActivity == null); localActivity = null)
    {
      yny.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject1 = new JSONObject(paramVarArgs[0]);
      yny.b("GdtHandleAdJsCallHandler", ((JSONObject)localObject1).toString());
      JSONObject localJSONObject = ((JSONObject)localObject1).getJSONObject("options");
      boolean bool1 = localJSONObject.getBoolean("reportForClick");
      boolean bool2 = localJSONObject.getBoolean("appAutoDownload");
      boolean bool3 = localJSONObject.optBoolean("videoCeilingSupported", false);
      boolean bool4 = localJSONObject.optBoolean("videoCeilingSupportedIfInstalled", false);
      boolean bool5 = localJSONObject.optBoolean("videoSpliceSupported", false);
      Object localObject2 = localJSONObject.optJSONObject("mediaViewLocationRect");
      paramVarArgs = new Rect();
      if (localObject2 != null)
      {
        int i = ((JSONObject)localObject2).optInt("left", 0);
        int j = ((JSONObject)localObject2).optInt("top", 0);
        int k = ((JSONObject)localObject2).optInt("right", 0);
        int m = ((JSONObject)localObject2).optInt("bottom", 0);
        paramVarArgs.left = i;
        paramVarArgs.top = j;
        paramVarArgs.right = k;
        paramVarArgs.bottom = m;
      }
      localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo(), ((JSONObject)localObject1).getJSONObject("adInfo")));
      localObject1 = new yjs();
      ((yjs)localObject1).jdField_a_of_type_Int = 7;
      ((yjs)localObject1).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
      ((yjs)localObject1).jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
      ((yjs)localObject1).jdField_a_of_type_Boolean = bool1;
      ((yjs)localObject1).jdField_b_of_type_Boolean = bool2;
      ((yjs)localObject1).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramymw.a());
      ((yjs)localObject1).jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
      ((yjs)localObject1).c = bool3;
      ((yjs)localObject1).d = bool4;
      ((yjs)localObject1).e = bool5;
      ((yjs)localObject1).jdField_a_of_type_AndroidGraphicsRect = paramVarArgs;
      ((yjs)localObject1).jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
      paramVarArgs = paramymw.a().getIntent();
      if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
      {
        paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
        ((yjs)localObject1).jdField_a_of_type_AndroidOsBundle = new Bundle();
        ((yjs)localObject1).jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
        ((yjs)localObject1).f = localJSONObject.optBoolean("videoPlayForced");
        this.a = new GdtDwellTimeStatisticsAfterClick(((yjs)localObject1).jdField_a_of_type_ComTencentGdtadAditemGdtAd, new WeakReference(paramymw.mRuntime.a()));
        this.a.a();
        yjr.a((yjs)localObject1);
        paramymw.callJs(paramString, null);
        if (paramymw == null) {
          break label486;
        }
      }
      label486:
      for (paramymw = paramymw.a();; paramymw = null)
      {
        AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "handleClick", paramymw, ((yjs)localObject1).jdField_a_of_type_ComTencentGdtadAditemGdtAd);
        return true;
        paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
        break;
      }
      return true;
    }
    catch (Throwable paramymw)
    {
      yny.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error", paramymw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ynk
 * JD-Core Version:    0.7.0.1
 */