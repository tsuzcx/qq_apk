import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class yxg
  implements yso
{
  yxg(yxf paramyxf) {}
  
  public void onResponse(ysn paramysn)
  {
    if ((paramysn == null) || (paramysn.a() == null) || (yxf.a(this.a) == null) || (yxf.a(this.a).get() == null)) {
      return;
    }
    String str = (String)yxf.a(this.a).get(paramysn);
    yxf.a(this.a).remove(paramysn);
    Object localObject1 = yxo.a(paramysn.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = yxo.a(paramysn.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramysn = new JSONObject();
    try
    {
      paramysn.put("request", localObject1);
      paramysn.put("response", localObject2);
      ((ywk)yxf.a(this.a).get()).callJs(str, new String[] { paramysn.toString() });
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
 * Qualified Name:     yxg
 * JD-Core Version:    0.7.0.1
 */