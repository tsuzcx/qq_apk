import android.content.Context;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import org.json.JSONObject;

final class wsh
  implements Callback
{
  wsh(Context paramContext, wsi paramwsi) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    wsg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wsi, "abcdabcdabcdabcd");
  }
  
  public void onResponse(Response paramResponse)
  {
    try
    {
      paramResponse = new JSONObject(paramResponse.body().string()).optString("key");
      wsg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wsi, paramResponse);
      return;
    }
    catch (Throwable paramResponse)
    {
      paramResponse.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsh
 * JD-Core Version:    0.7.0.1
 */