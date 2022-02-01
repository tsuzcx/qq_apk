import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.IOException;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

public class pop
  extends pos
{
  public String aue;
  public String auf;
  public int bjH = -1;
  public String url;
  public String zc;
  
  public pop(String paramString)
  {
    this.url = paramString;
  }
  
  private ErrorMessage b()
    throws JSONException, IOException
  {
    Object localObject = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { QQStoryContext.a().mi(), URLEncoder.encode(this.url) });
    long l = System.currentTimeMillis();
    localObject = jqc.a(QQStoryContext.a().getApplication(), (String)localObject, null, "GET", null, null, 5000, 5000);
    if ((localObject != null) && (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200))
    {
      localObject = jqc.a((HttpResponse)localObject);
      ram.b("Q.qqstory.publish.upload.LinkRichObject", "http resp %s", localObject);
      localObject = new JSONObject((String)localObject);
      this.bjH = Integer.parseInt(((JSONObject)localObject).getString("ret"));
      if (this.bjH != 0) {
        return new ErrorMessage(96000002, "server error code:" + this.bjH);
      }
    }
    else
    {
      ram.w("Q.qqstory.publish.upload.LinkRichObject", "");
      if (localObject != null) {}
      for (localObject = "http code:" + ((HttpResponse)localObject).getStatusLine();; localObject = "response is null") {
        return new ErrorMessage(96000003, (String)localObject);
      }
    }
    String str = ((JSONObject)localObject).getString("title");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.zc))) {
      this.zc = str;
    }
    str = ((JSONObject)localObject).getString("abstract");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.aue))) {
      this.aue = str;
    }
    localObject = ((JSONObject)localObject).getString("thumbUrl");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(this.auf))) {
      this.auf = ((String)localObject);
    }
    ram.w("Q.qqstory.publish.upload.LinkRichObject", "request take time %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return new ErrorMessage();
  }
  
  protected void startUpload()
  {
    try
    {
      if (b().isSuccess())
      {
        bmd();
        notifyResult(new ErrorMessage());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      ram.e("Q.qqstory.publish.upload.LinkRichObject", "parse url ", localJSONException);
      new ErrorMessage(96000001, localJSONException.getMessage());
      bmd();
      notifyResult(new ErrorMessage());
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.publish.upload.LinkRichObject", "parse url ", localIOException);
        new ErrorMessage(96000000, localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pop
 * JD-Core Version:    0.7.0.1
 */