import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class yrg
  implements ysj
{
  yrg(yrd paramyrd, String paramString) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("retCode", 0);
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("errMsg", paramString2);
        }
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("file", paramString1);
        }
        this.jdField_a_of_type_Yrd.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e(this.jdField_a_of_type_Yrd.TAG, 1, paramString2, paramString1);
      }
      localJSONObject.put("retCode", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yrg
 * JD-Core Version:    0.7.0.1
 */