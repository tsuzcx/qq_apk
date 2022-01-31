import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class yoj
  implements Runnable
{
  public yoj(CmGameLauncher paramCmGameLauncher, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("gameId", CmGameLauncher.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher));
      ApolloGameBasicEventUtil.a(CmGameLauncher.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher), localJSONObject.toString(), this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yoj
 * JD-Core Version:    0.7.0.1
 */