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

class ynm
  implements ynl
{
  private WeakReference<ymw> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<yjm, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private yjn jdField_a_of_type_Yjn = new ynn(this);
  
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    if (paramymw != null) {}
    for (Activity localActivity = paramymw.a(); (paramymw == null) || (localActivity == null); localActivity = null)
    {
      yny.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      yny.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new yjo();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(ynv.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramymw);
      localObject = new yjm(paramVarArgs, new WeakReference(this.jdField_a_of_type_Yjn));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((yjm)localObject).a(new WeakReference(localActivity));
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
      if (paramymw == null) {}
    }
    catch (JSONException paramymw)
    {
      yny.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramymw);
      return true;
    }
    for (paramymw = paramymw.a();; paramymw = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramymw);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ynm
 * JD-Core Version:    0.7.0.1
 */