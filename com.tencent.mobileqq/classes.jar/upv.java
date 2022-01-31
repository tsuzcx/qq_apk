import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.IOException;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

public class upv
  extends upy
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public upv(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private ErrorMessage a()
  {
    Object localObject = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { QQStoryContext.a().a(), URLEncoder.encode(this.jdField_a_of_type_JavaLangString) });
    long l = System.currentTimeMillis();
    localObject = ndd.a(QQStoryContext.a().a(), (String)localObject, null, "GET", null, null, 5000, 5000);
    if ((localObject != null) && (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200))
    {
      localObject = ndd.a((HttpResponse)localObject);
      wxe.a("Q.qqstory.publish.upload.LinkRichObject", "http resp %s", localObject);
      localObject = new JSONObject((String)localObject);
      this.jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject).getString("ret"));
      if (this.jdField_a_of_type_Int != 0) {
        return new ErrorMessage(96000002, "server error code:" + this.jdField_a_of_type_Int);
      }
    }
    else
    {
      wxe.d("Q.qqstory.publish.upload.LinkRichObject", "");
      if (localObject != null) {}
      for (localObject = "http code:" + ((HttpResponse)localObject).getStatusLine();; localObject = "response is null") {
        return new ErrorMessage(96000003, (String)localObject);
      }
    }
    String str = ((JSONObject)localObject).getString("title");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.b))) {
      this.b = str;
    }
    str = ((JSONObject)localObject).getString("abstract");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty(this.c))) {
      this.c = str;
    }
    localObject = ((JSONObject)localObject).getString("thumbUrl");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(this.d))) {
      this.d = ((String)localObject);
    }
    wxe.d("Q.qqstory.publish.upload.LinkRichObject", "request take time %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return new ErrorMessage();
  }
  
  protected void a()
  {
    try
    {
      if (a().isSuccess())
      {
        b();
        notifyResult(new ErrorMessage());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      wxe.c("Q.qqstory.publish.upload.LinkRichObject", "parse url ", localJSONException);
      new ErrorMessage(96000001, localJSONException.getMessage());
      b();
      notifyResult(new ErrorMessage());
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        wxe.c("Q.qqstory.publish.upload.LinkRichObject", "parse url ", localIOException);
        new ErrorMessage(96000000, localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upv
 * JD-Core Version:    0.7.0.1
 */