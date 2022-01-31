import android.content.Context;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import org.json.JSONObject;

final class wse
  implements Callback
{
  wse(Context paramContext, wsf paramwsf) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    wsd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wsf, "abcdabcdabcdabcd");
  }
  
  public void onResponse(Response paramResponse)
  {
    try
    {
      paramResponse = new JSONObject(paramResponse.body().string()).optString("key");
      wsd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wsf, paramResponse);
      return;
    }
    catch (Throwable paramResponse)
    {
      paramResponse.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wse
 * JD-Core Version:    0.7.0.1
 */