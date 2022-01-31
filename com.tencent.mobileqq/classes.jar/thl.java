import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class thl
  implements Runnable
{
  public thl(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = new HttpGet("http://qqwx.qq.com/s?aid=index&p=5&c=102120&vt=2&pf=0");
      localObject = new DefaultHttpClient().execute((HttpUriRequest)localObject);
      if (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200)
      {
        localObject = EntityUtils.toString(((HttpResponse)localObject).getEntity());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          long l = new JSONObject(((String)localObject).substring(6, ((String)localObject).length() - 2)).getLong("size");
          if (l > 0L)
          {
            this.a.a = l;
            this.a.runOnUiThread(new thp(this.a, 0));
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     thl
 * JD-Core Version:    0.7.0.1
 */