import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class clk
  extends Thread
{
  public clk(ForwardOperations paramForwardOperations) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || ((this.a.c) && (!TextUtils.isEmpty((CharSequence)localObject))))
      {
        if ((this.a.c) && (!TextUtils.isEmpty(this.a.jdField_v_of_type_JavaLangString))) {
          break label108;
        }
        ForwardOperations.b(this.a);
        this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new cll(this));
      }
      label108:
      HashMap localHashMap1;
      HashMap localHashMap2;
      try
      {
        Thread.sleep(1000L);
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
        i += 1;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()))
    {
      this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new clm(this));
      return;
    }
    if (this.a.jdField_v_of_type_Int == 5)
    {
      this.a.c();
      return;
    }
    localObject = this.a.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localHashMap1 = new HashMap();
      localHashMap1.put("Connection", "keep-alive");
      localHashMap1.put("Referer", "http://www.qq.com");
      localHashMap2 = new HashMap();
      localHashMap2.put("share_image", localObject);
      localObject = HttpUtil.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.jdField_v_of_type_JavaLangString, null, localHashMap2, localHashMap1);
      if (localObject != null) {
        try
        {
          localObject = new JSONObject((String)localObject);
          if ((((JSONObject)localObject).getInt("retcode") == 0) && (((JSONObject)localObject).has("result")))
          {
            localObject = ((JSONObject)localObject).getJSONObject("result");
            this.a.jdField_a_of_type_AndroidOsBundle.remove("image_url");
            this.a.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", ((JSONObject)localObject).getString("url"));
            this.a.c();
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOperations", 2, localJSONException.getMessage());
          }
        }
      }
      this.a.c();
      return;
    }
    this.a.jdField_a_of_type_AndroidOsBundle.remove("image_url");
    this.a.c();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     clk
 * JD-Core Version:    0.7.0.1
 */