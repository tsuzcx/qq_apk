import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class xjh
  implements myy
{
  xjh(xjf paramxjf, QQAppInterface paramQQAppInterface) {}
  
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
          bbdx.a(mzh.a(this.jdField_a_of_type_Xjf.a) + this.jdField_a_of_type_Xjf.a);
          this.jdField_a_of_type_Xjf.b();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_Xjf.a();
        return;
      }
      if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
      {
        this.jdField_a_of_type_Xjf.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      this.jdField_a_of_type_Xjf.a();
      return;
    }
    this.jdField_a_of_type_Xjf.a();
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xjh
 * JD-Core Version:    0.7.0.1
 */