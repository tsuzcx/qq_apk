import android.content.Context;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

final class ygw
  implements Callback
{
  ygw(Context paramContext, ygx paramygx) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    ygv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ygx, "Jbq0Dm55FudiaTa26UjP071XduhCyIKRYaK6MCcYzZA");
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = new JSONObject(paramResponse.body().string()).optString("key");
      ygv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ygx, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygw
 * JD-Core Version:    0.7.0.1
 */