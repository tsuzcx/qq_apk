import android.os.Bundle;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.Statistic;
import com.tencent.open.business.base.OpenConfig;
import org.json.JSONObject;

public class fdk
  implements Runnable
{
  public fdk(OpenConfig paramOpenConfig, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = HttpBaseUtil.a(HttpBaseUtil.a("http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.jdField_a_of_type_AndroidOsBundle).a);
      this.jdField_a_of_type_ComTencentOpenBusinessBaseOpenConfig.a(localJSONObject);
      this.jdField_a_of_type_ComTencentOpenBusinessBaseOpenConfig.a = 0;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fdk
 * JD-Core Version:    0.7.0.1
 */