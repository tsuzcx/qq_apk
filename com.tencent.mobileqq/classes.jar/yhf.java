import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class yhf
  implements Runnable
{
  public yhf(ApolloManager paramApolloManager) {}
  
  public void run()
  {
    Object localObject = null;
    try
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label152;
      }
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, localOutOfMemoryError.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, localException.getMessage());
          }
        }
      } while (localException != null);
    }
    localObject = new File(ApolloConstant.a);
    ((File)localObject).mkdirs();
    localObject = new File((File)localObject, "apollo_res_version_info.json");
    if (((File)localObject).exists())
    {
      localObject = FileUtils.b((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.a.jdField_a_of_type_OrgJsonJSONObject = new JSONObject((String)localObject);
      }
    }
    if (this.a.jdField_a_of_type_OrgJsonJSONObject == null)
    {
      this.a.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      return;
    }
    label152:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhf
 * JD-Core Version:    0.7.0.1
 */