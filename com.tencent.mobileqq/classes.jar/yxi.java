import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;

class yxi
  implements yxh
{
  private WeakReference<ywn> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<ysq, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ysr jdField_a_of_type_Ysr = new yxj(this);
  
  public boolean a(ywn paramywn, String paramString, String... paramVarArgs)
  {
    if (paramywn != null) {}
    for (Activity localActivity = paramywn.a(); (paramywn == null) || (localActivity == null); localActivity = null)
    {
      yxs.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      yxs.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new yss();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(yxr.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramywn);
      localObject = new ysq(paramVarArgs, new WeakReference(this.jdField_a_of_type_Ysr));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((ysq)localObject).a(new WeakReference(localActivity));
      paramString = new ArrayList();
      if ((paramVarArgs.a != null) && (!paramVarArgs.a.position_info.isEmpty()))
      {
        int i = 0;
        while (i < paramVarArgs.a.position_info.size())
        {
          localObject = ((qq_ad_get.QQAdGet.PositionInfo)paramVarArgs.a.position_info.get(i)).pos_id.get();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString.add(localObject);
          }
          i += 1;
        }
      }
      if (paramywn == null) {}
    }
    catch (JSONException paramywn)
    {
      yxs.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramywn);
      return true;
    }
    for (paramywn = paramywn.a();; paramywn = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramywn);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxi
 * JD-Core Version:    0.7.0.1
 */