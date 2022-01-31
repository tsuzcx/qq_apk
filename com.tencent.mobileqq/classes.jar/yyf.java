import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class yyf
  implements Runnable
{
  yyf(yye paramyye, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          i = ((JSONObject)localObject).optInt("__apollo_game_id__");
          localObject = CmGameUtil.a();
          if (localObject != null) {
            ((ApolloCmdChannel)localObject).handleWebEvent(this.jdField_a_of_type_JavaLangString, i);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameManager", 1, localException, new Object[0]);
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yyf
 * JD-Core Version:    0.7.0.1
 */