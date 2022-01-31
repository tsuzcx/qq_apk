import android.content.Context;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

final class ylj
  implements Callback
{
  ylj(Context paramContext, ylk paramylk) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    yli.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ylk, "Jbq0Dm55FudiaTa26UjP071XduhCyIKRYaK6MCcYzZA");
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = new JSONObject(paramResponse.body().string()).optString("key");
      yli.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ylk, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ylj
 * JD-Core Version:    0.7.0.1
 */