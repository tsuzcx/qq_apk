import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.biz.game.SensorAPIJavaScript;
import org.json.JSONException;
import org.json.JSONObject;

public class ng
  implements LoadedCallBack
{
  public ng(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      paramString = new JSONObject(paramString);
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = ("javascript: " + this.jdField_a_of_type_JavaLangString + "(" + paramString.toString() + ")");
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.sendMessage(localMessage);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ng
 * JD-Core Version:    0.7.0.1
 */