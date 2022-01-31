import android.content.Context;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class lh
  extends Thread
{
  public lh(JSONObject paramJSONObject, Context paramContext, String paramString1, String paramString2, LoadedCallBack paramLoadedCallBack) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "Begin checkUpServerThread:");
    }
    String str3 = "0";
    String str1 = str3;
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        str1 = this.jdField_a_of_type_OrgJsonJSONObject.getString("version");
      }
      str1 = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_JavaLangString, this.b);
      if (str1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "getUpdateConfig: null");
        }
        this.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack.a("{\"r\":-2}");
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "end checkUpServerThread:");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str2 = str3;
        continue;
        this.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack.a(str2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lh
 * JD-Core Version:    0.7.0.1
 */