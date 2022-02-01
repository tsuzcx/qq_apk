import android.content.Context;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

final class sgr
  implements Callback
{
  sgr(Context paramContext, sgq.a parama) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    sgq.b(this.val$context, this.a, "Jbq0Dm55FudiaTa26UjP071XduhCyIKRYaK6MCcYzZA");
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
    throws IOException
  {
    try
    {
      paramCall = new JSONObject(paramResponse.body().string()).optString("key");
      sgq.b(this.val$context, this.a, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgr
 * JD-Core Version:    0.7.0.1
 */