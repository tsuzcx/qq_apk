package com.tencent.open.base.http;

import ahbj;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import arxc;
import arxc.a;
import arxi;
import arxi.a;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class AvatarUpdateService$1
  implements Runnable
{
  public AvatarUpdateService$1(arxc paramarxc, String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext, arxi.a parama) {}
  
  public void run()
  {
    Object localObject1 = new DefaultHttpClient();
    int i;
    int j;
    try
    {
      ??? = new HttpGet(MsfSdkUtils.insertMtype("yingyongbao", this.cCN));
      ((HttpGet)???).addHeader("Cookie", this.lr);
      localObject1 = EntityUtils.toString(((HttpClient)localObject1).execute((HttpUriRequest)???).getEntity(), "utf-8");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("AvatarUpdateService", 1, "-->updateAvatar--jsonp is empty");
        return;
      }
      i = ((String)localObject1).indexOf('{');
      j = ((String)localObject1).lastIndexOf('}');
      if ((i < 0) || (i > j) || (j < 0))
      {
        QLog.e("AvatarUpdateService", 1, "-->updateAvatar--can not find json string");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AvatarUpdateService", 1, new Object[] { "-->updateAvatar---", localException.getMessage() });
      return;
    }
    String str = new JSONObject(localException.substring(i, j + 1)).getString(this.val$uin);
    if (TextUtils.isEmpty(str))
    {
      QLog.e("AvatarUpdateService", 1, "-->updateAvatar--image url is empty");
      return;
    }
    ??? = this.this$0.af.getString(this.val$uin, "");
    if ((!ahbj.isFileExists(this.val$path)) || (!str.equals(???)))
    {
      QLog.d("AvatarUpdateService", 1, "-->updateAvatar--avatar not exist or need update, will download new avatar");
      synchronized (this.this$0.pQ)
      {
        if (!this.this$0.pQ.containsKey(this.val$uin))
        {
          this.this$0.pQ.put(this.val$uin, new arxc.a(this.this$0, this.val$context, this.val$uin, this.val$path, str, this.a));
          new arxi(this.val$uin, str, null, "GET", this.this$0).execute(new Void[0]);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.base.http.AvatarUpdateService.1
 * JD-Core Version:    0.7.0.1
 */