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

class yxf
  implements yxe
{
  private WeakReference<ywk> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<ysn, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private yso jdField_a_of_type_Yso = new yxg(this);
  
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    if (paramywk != null) {}
    for (Activity localActivity = paramywk.a(); (paramywk == null) || (localActivity == null); localActivity = null)
    {
      yxp.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      yxp.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new ysp();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(yxo.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramywk);
      localObject = new ysn(paramVarArgs, new WeakReference(this.jdField_a_of_type_Yso));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((ysn)localObject).a(new WeakReference(localActivity));
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
      if (paramywk == null) {}
    }
    catch (JSONException paramywk)
    {
      yxp.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramywk);
      return true;
    }
    for (paramywk = paramywk.a();; paramywk = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramywk);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxf
 * JD-Core Version:    0.7.0.1
 */