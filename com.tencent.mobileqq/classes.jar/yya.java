import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class yya
  implements nbs
{
  yya(yxy paramyxy, QQAppInterface paramQQAppInterface) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("data").optJSONObject(0);
        str = paramString.optString("url");
        paramInt = paramString.optInt("filesize");
        if ((str != null) && (str.endsWith("patch")))
        {
          bdcs.a(ncb.a(this.jdField_a_of_type_Yxy.a) + this.jdField_a_of_type_Yxy.a);
          this.jdField_a_of_type_Yxy.b();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_Yxy.a();
        return;
      }
      if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
      {
        this.jdField_a_of_type_Yxy.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      this.jdField_a_of_type_Yxy.a();
      return;
    }
    this.jdField_a_of_type_Yxy.a();
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yya
 * JD-Core Version:    0.7.0.1
 */