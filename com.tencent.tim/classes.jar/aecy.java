import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class aecy
  extends aolf
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws IOException
  {
    String str;
    for (Object localObject = paramDownloadParams.url.getHost();; str = "")
    {
      try
      {
        localObject = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { BaseApplicationImpl.getApplication().getRuntime().getAccount(), localObject });
        localObject = jqc.a(BaseApplicationImpl.getApplication(), (String)localObject, null, "GET", null, null, 5000, 5000);
        if ((localObject == null) || (((HttpResponse)localObject).getStatusLine().getStatusCode() != 200)) {
          continue;
        }
        localObject = jqc.a((HttpResponse)localObject);
        localObject = new JSONObject((String)localObject);
        if (Integer.parseInt(((JSONObject)localObject).getString("ret")) == 0)
        {
          localObject = ((JSONObject)localObject).getString("thumbUrl");
          paramDownloadParams.url = new URL((String)localObject);
          paramDownloadParams.urlStr = ((String)localObject);
          localObject = super.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return super.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aecy
 * JD-Core Version:    0.7.0.1
 */