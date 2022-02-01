import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

class ozt
  implements Callback
{
  ozt(ozq paramozq, ozn paramozn, boolean paramBoolean, String paramString) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.d(ozq.TAG, 1, "checkResource onFailure");
    this.a.b(false, this.azb, false, this.arN);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
    throws IOException
  {
    try
    {
      paramCall = paramResponse.headers().get("X-COS-META-MD5");
      if ((TextUtils.isEmpty(paramCall)) || (this.arN.equals(paramCall)))
      {
        QLog.d(ozq.TAG, 1, "checkResource is up to date");
        this.a.b(true, this.azb, false, paramCall);
        return;
      }
      QLog.d(ozq.TAG, 1, "checkResource need update");
      this.a.b(true, this.azb, true, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozt
 * JD-Core Version:    0.7.0.1
 */