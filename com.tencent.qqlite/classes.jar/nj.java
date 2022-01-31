import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;

public class nj
  implements TroopMemberApiClient.Callback
{
  public nj(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("state");
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { i + "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     nj
 * JD-Core Version:    0.7.0.1
 */