import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ynn
  implements yjn
{
  ynn(ynm paramynm) {}
  
  public void onResponse(yjm paramyjm)
  {
    if ((paramyjm == null) || (paramyjm.a() == null) || (ynm.a(this.a) == null) || (ynm.a(this.a).get() == null)) {
      return;
    }
    String str = (String)ynm.a(this.a).get(paramyjm);
    ynm.a(this.a).remove(paramyjm);
    Object localObject1 = ynv.a(paramyjm.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = ynv.a(paramyjm.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramyjm = new JSONObject();
    try
    {
      paramyjm.put("request", localObject1);
      paramyjm.put("response", localObject2);
      ((ymw)ynm.a(this.a).get()).callJs(str, new String[] { paramyjm.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ynn
 * JD-Core Version:    0.7.0.1
 */