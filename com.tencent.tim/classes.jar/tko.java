import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class tko
  implements tgc.a
{
  tko(tkn paramtkn) {}
  
  public void onResponse(tgc paramtgc)
  {
    if ((paramtgc == null) || (paramtgc.a() == null) || (tkn.a(this.b) == null) || (tkn.a(this.b).get() == null)) {
      return;
    }
    String str = (String)tkn.a(this.b).get(paramtgc);
    tkn.a(this.b).remove(paramtgc);
    Object localObject1 = tkv.pbToJson(paramtgc.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = tkv.pbToJson(paramtgc.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramtgc = new JSONObject();
    try
    {
      paramtgc.put("request", localObject1);
      paramtgc.put("response", localObject2);
      ((tjs)tkn.a(this.b).get()).callJs(str, new String[] { paramtgc.toString() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tko
 * JD-Core Version:    0.7.0.1
 */