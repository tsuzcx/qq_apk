package com.tencent.tim.filemanager.util;

import anaz;
import audw;
import audw.a;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class FileManagerReporter$1
  implements Runnable
{
  public FileManagerReporter$1(audw.a parama) {}
  
  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http://qf.qq.com").openConnection();
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setRequestProperty("Content-Type", "text/plain");
      localHttpURLConnection.setRequestProperty("Accept", "*/*");
      localHttpURLConnection.setRequestProperty("charset", "UTF-8");
      localHttpURLConnection.setDoOutput(true);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", this.a.uin);
      ((JSONObject)localObject1).put("sId", this.a.sessionId);
      ((JSONObject)localObject1).put("time", anaz.gQ() * 1000L);
      ((JSONObject)localObject1).put("os", "android");
      ((JSONObject)localObject1).put("app", "tim");
      ((JSONObject)localObject1).put("ver", AppSetting.getRevision());
      ((JSONObject)localObject1).put("biz", this.a.biz);
      ((JSONObject)localObject1).put("name", this.a.filename);
      ((JSONObject)localObject1).put("code", this.a.LE);
      if (this.a.qi.size() > 0)
      {
        localObject2 = new JSONObject();
        Iterator localIterator = this.a.qi.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((JSONObject)localObject2).put(str, this.a.qi.get(str));
        }
        ((JSONObject)localObject1).put("ext", localObject2);
      }
    }
    catch (Exception localException)
    {
      QLog.e("FileManagerReporter<FileAssistant>", 1, "realReport error:" + localException.toString());
      return;
    }
    Object localObject1 = audw.u((JSONObject)localObject1).toString();
    Object localObject2 = new DataOutputStream(localException.getOutputStream());
    ((DataOutputStream)localObject2).write(((String)localObject1).getBytes("UTF-8"));
    ((DataOutputStream)localObject2).flush();
    ((DataOutputStream)localObject2).close();
    QLog.i("FileManagerReporter<FileAssistant>", 1, "realReport status:" + localException.getResponseCode());
    localException.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.FileManagerReporter.1
 * JD-Core Version:    0.7.0.1
 */