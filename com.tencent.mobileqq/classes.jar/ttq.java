import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

final class ttq
  implements ttw
{
  public void a()
  {
    Object localObject = tto.a("https://viola/viola_config.json?v_bid=3192");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONObject((String)localObject);
        JSONArray localJSONArray = (JSONArray)((JSONObject)localObject).get("preload_bids");
        int i = 0;
        while (i < localJSONArray.length())
        {
          tto.a((String)localJSONArray.get(i), null);
          i += 1;
        }
        tto.jdField_a_of_type_JavaLangString = pkh.a();
        tto.jdField_a_of_type_Long = System.currentTimeMillis();
        if (((JSONObject)localObject).has("use_main")) {
          tto.jdField_a_of_type_Boolean = ((Boolean)((JSONObject)localObject).get("use_main")).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is success!");
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ViolaAccessHelper", 2, "pre load all offline from offline is exception:" + localException.getMessage());
        }
        tto.b();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is empty!");
    }
    tto.b();
  }
  
  public void a(int paramInt) {}
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ttq
 * JD-Core Version:    0.7.0.1
 */