import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

final class ttu
  implements ucm
{
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "pre load all offline from net is fail");
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray = (JSONArray)paramString.get("preload_bids");
      int i = 0;
      while (i < localJSONArray.length())
      {
        tto.a((String)localJSONArray.get(i), null);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "pre load all offline from net is success");
      }
      tto.jdField_a_of_type_JavaLangString = pkh.a();
      tto.jdField_a_of_type_Long = System.currentTimeMillis();
      if (paramString.has("use_main")) {
        tto.jdField_a_of_type_Boolean = ((Boolean)paramString.get("use_main")).booleanValue();
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ViolaAccessHelper", 2, "pre load all offline from net is exception:" + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ttu
 * JD-Core Version:    0.7.0.1
 */