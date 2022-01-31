import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class ynx
{
  Object jdField_a_of_type_JavaLangObject;
  String jdField_a_of_type_JavaLangString;
  
  private Object b()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaLangObject == null) {
          return JSONObject.NULL;
        }
        if ((this.jdField_a_of_type_JavaLangObject == JSONObject.NULL) || ((this.jdField_a_of_type_JavaLangObject instanceof String))) {
          return this.jdField_a_of_type_JavaLangObject;
        }
        if (!(this.jdField_a_of_type_JavaLangObject instanceof List)) {
          break label150;
        }
        Object localObject2 = (List)this.jdField_a_of_type_JavaLangObject;
        JSONObject localJSONObject = new JSONObject();
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        ynx localynx = (ynx)((Iterator)localObject2).next();
        if (TextUtils.isEmpty(localynx.jdField_a_of_type_JavaLangString)) {
          yny.d("GdtJsonXmlUtil", "getJSONValue error");
        } else {
          localJSONException.put(localynx.jdField_a_of_type_JavaLangString, localynx.b());
        }
      }
      catch (JSONException localJSONException)
      {
        yny.d("GdtJsonXmlUtil", "toJsonObject", localJSONException);
        return JSONObject.NULL;
      }
    }
    if (localJSONException.length() > 0) {
      return localJSONException;
    }
    return JSONObject.NULL;
    label150:
    yny.d("GdtJsonXmlUtil", "toJsonObject error");
    Object localObject1 = JSONObject.NULL;
    return localObject1;
  }
  
  Object a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      yny.d("GdtJsonXmlUtil", "toJsonObject error");
      return JSONObject.NULL;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(this.jdField_a_of_type_JavaLangString, b());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      yny.d("GdtJsonXmlUtil", "toJSONObject", localJSONException);
    }
    return JSONObject.NULL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ynx
 * JD-Core Version:    0.7.0.1
 */