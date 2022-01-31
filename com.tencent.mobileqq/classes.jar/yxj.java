import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class yxj
  implements ysr
{
  yxj(yxi paramyxi) {}
  
  public void onResponse(ysq paramysq)
  {
    if ((paramysq == null) || (paramysq.a() == null) || (yxi.a(this.a) == null) || (yxi.a(this.a).get() == null)) {
      return;
    }
    String str = (String)yxi.a(this.a).get(paramysq);
    yxi.a(this.a).remove(paramysq);
    Object localObject1 = yxr.a(paramysq.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = yxr.a(paramysq.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramysq = new JSONObject();
    try
    {
      paramysq.put("request", localObject1);
      paramysq.put("response", localObject2);
      ((ywn)yxi.a(this.a).get()).callJs(str, new String[] { paramysq.toString() });
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
 * Qualified Name:     yxj
 * JD-Core Version:    0.7.0.1
 */