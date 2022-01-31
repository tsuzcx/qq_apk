import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.TranslateClient;

class bfw
  extends TranslateClient
{
  private static final String a = "http://passport.imqq.com/App/MobileQQ/ChangeTrans.html";
  
  public static void a(Context paramContext, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "http://passport.imqq.com/App/MobileQQ/ChangeTrans.html", null, null, new bfx(paramAsyncHttpResponseHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bfw
 * JD-Core Version:    0.7.0.1
 */