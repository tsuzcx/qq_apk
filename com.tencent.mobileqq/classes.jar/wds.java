import android.content.Context;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import org.json.JSONObject;

final class wds
  implements Callback
{
  wds(Context paramContext, wdt paramwdt) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    wdr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wdt, "abcdabcdabcdabcd");
  }
  
  public void onResponse(Response paramResponse)
  {
    try
    {
      paramResponse = new JSONObject(paramResponse.body().string()).optString("key");
      wdr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wdt, paramResponse);
      return;
    }
    catch (Throwable paramResponse)
    {
      paramResponse.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wds
 * JD-Core Version:    0.7.0.1
 */