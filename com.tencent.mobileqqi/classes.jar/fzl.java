import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.activity.AcceptAllHttpsClient;
import com.tencent.mobileqq.international.activity.FeedbackActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class fzl
  extends AsyncTask
{
  private fzl(FeedbackActivity paramFeedbackActivity) {}
  
  protected Void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1)) {
      try
      {
        if (Build.VERSION.SDK_INT >= 11) {}
        for (Object localObject1 = new DefaultHttpClient();; localObject1 = AcceptAllHttpsClient.a())
        {
          HttpPost localHttpPost = new HttpPost(paramVarArgs[0]);
          Object localObject2 = "uin=" + this.a.a(this.a.b.getAccount()) + "; skey=" + this.a.b.d() + "; vkey=" + this.a.b.f();
          localHttpPost.addHeader("Referer", "http://mma.qq.com/feedback/index.html");
          localHttpPost.addHeader("Cookie", (String)localObject2);
          localHttpPost.setHeader("Content-Type", "application/json; charset=utf-8");
          localObject2 = new ArrayList(4);
          ((List)localObject2).add(new BasicNameValuePair("title", "QQ海外版Android用户反馈"));
          ((List)localObject2).add(new BasicNameValuePair("text", paramVarArgs[1]));
          ((List)localObject2).add(new BasicNameValuePair("fid", "1221"));
          ((List)localObject2).add(new BasicNameValuePair("bkn", this.a.a() + ""));
          localHttpPost.setEntity(new UrlEncodedFormEntity((List)localObject2, "UTF-8"));
          paramVarArgs = ((HttpClient)localObject1).execute(localHttpPost);
          QLog.w("FeedBackActivity", 2, "response.getStatusLine().getStatusCode()-->" + paramVarArgs.getStatusLine().getStatusCode());
          if (paramVarArgs.getStatusLine().getStatusCode() != 200) {
            break label471;
          }
          paramVarArgs = EntityUtils.toString(paramVarArgs.getEntity());
          QLog.w("FeedBackActivity", 2, "response-->" + paramVarArgs);
          if (new JSONObject(paramVarArgs).getDouble("ec") != 0.0D) {
            break;
          }
          FeedbackActivity.a(this.a).post(FeedbackActivity.a(this.a));
          break label639;
        }
        FeedbackActivity.a(this.a).post(FeedbackActivity.b(this.a));
      }
      catch (ParseException paramVarArgs)
      {
        FeedbackActivity.a(this.a).post(FeedbackActivity.b(this.a));
        QLog.e("FeedBackActivity", 2, "error " + paramVarArgs.toString());
        break label639;
        FeedbackActivity.a(this.a).post(FeedbackActivity.b(this.a));
      }
      catch (JSONException paramVarArgs)
      {
        FeedbackActivity.a(this.a).post(FeedbackActivity.b(this.a));
        QLog.e("FeedBackActivity", 2, "error " + paramVarArgs.toString());
      }
      catch (ClientProtocolException paramVarArgs)
      {
        FeedbackActivity.a(this.a).post(FeedbackActivity.b(this.a));
        QLog.e("FeedBackActivity", 2, "error " + paramVarArgs.toString());
      }
      catch (IOException paramVarArgs)
      {
        label471:
        FeedbackActivity.a(this.a).post(FeedbackActivity.b(this.a));
        QLog.e("FeedBackActivity", 2, "error " + paramVarArgs.toString());
      }
    }
    label639:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzl
 * JD-Core Version:    0.7.0.1
 */