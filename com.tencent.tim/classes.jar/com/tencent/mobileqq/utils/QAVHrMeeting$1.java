package com.tencent.mobileqq.utils;

import acdt;
import acdu;
import android.text.TextUtils;
import aqjl;
import aqjl.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.TicketManager;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public final class QAVHrMeeting$1
  implements Runnable
{
  public QAVHrMeeting$1(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface, String paramString4, aqjl.a parama) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.val$tag, 2, "getRedirectInfo.run url[" + this.val$url + "]");
    }
    AudioHelper.rw("获取hr信息_" + this.ctX);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    Object localObject1 = new BasicHttpContext();
    Object localObject6 = new HttpGet(this.val$url);
    Object localObject4 = "";
    for (;;)
    {
      Object localObject8;
      Object localObject9;
      try
      {
        localObject8 = (TicketManager)this.val$app.getManager(2);
        if (localObject8 == null) {
          return;
        }
        localObject8 = ((TicketManager)localObject8).getSkey(this.val$app.getAccount());
        if (localObject8 != null)
        {
          i = ((String)localObject8).length();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localObject9 = this.val$app.getCurrentAccountUin();
        ((HttpGet)localObject6).addHeader("Cookie", "uin=o" + (String)localObject9 + ";skey=" + (String)localObject8);
        localObject6 = localDefaultHttpClient.execute((HttpUriRequest)localObject6, (HttpContext)localObject1);
        localObject1 = "";
        i = ((HttpResponse)localObject6).getStatusLine().getStatusCode();
        if (i != 200) {
          break label815;
        }
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject;
        i = 0;
        localObject1 = "";
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.val$tag, 2, "getRedirectInfo.run e = " + localException2);
        localDefaultHttpClient.getConnectionManager().shutdown();
        continue;
      }
      finally
      {
        localDefaultHttpClient.getConnectionManager().shutdown();
      }
      try
      {
        localObject6 = EntityUtils.toString(((HttpResponse)localObject6).getEntity());
        localObject8 = localObject4;
      }
      catch (Exception localException4)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject6);
          localObject8 = localObject4;
          localObject9 = localObject4;
          if (((JSONObject)localObject1).getInt("retcode") != 0) {
            break label807;
          }
          localObject8 = localObject4;
          localObject9 = localObject4;
          if (!((JSONObject)localObject1).has("result")) {
            break label807;
          }
          localObject8 = localObject4;
          localJSONObject = ((JSONObject)localObject1).getJSONObject("result");
          localObject8 = localObject4;
          if (localJSONObject.has("result_code"))
          {
            localObject8 = localObject4;
            localJSONObject.getInt("result_code");
          }
          localObject1 = localObject4;
          localObject8 = localObject4;
          if (localJSONObject.has("name"))
          {
            localObject8 = localObject4;
            localObject1 = localJSONObject.getString("name");
          }
          localObject8 = localObject1;
          localObject9 = localObject1;
          if (!localJSONObject.has("stask")) {
            break label807;
          }
          localObject8 = localObject1;
          localObject4 = localJSONObject.getString("stask");
          localObject8 = localObject1;
          localObject9 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break label807;
          }
          localObject8 = localObject1;
          localObject9 = localObject1;
          if (((String)localObject4).compareToIgnoreCase("null") == 0) {
            break label807;
          }
          localObject8 = localObject1;
          i = Integer.valueOf((String)localObject4).intValue();
        }
        catch (Exception localException1)
        {
          localObject3 = localObject7;
          Object localObject5 = localObject8;
          continue;
          i = 0;
          localObject3 = localObject9;
          continue;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.val$tag, 2, "getRedirectInfo.run, " + (String)localObject6);
          }
          localDefaultHttpClient.getConnectionManager().shutdown();
          AudioHelper.rw("获取hr信息_rsp_" + this.ctX);
          localObject4 = (acdu)this.val$app.getManager(53);
          if (TextUtils.equals(this.ctX, this.val$app.getCurrentAccountUin()))
          {
            localObject6 = ((acdu)localObject4).a(this.ctY);
            if ((localObject6 != null) && (((DiscussionInfo)localObject6).mSelfRight != i))
            {
              ((DiscussionInfo)localObject6).mSelfRight = i;
              ((acdu)localObject4).d((DiscussionInfo)localObject6);
              aqjl.a("getHrConfMemberName", this.val$app, (DiscussionInfo)localObject6);
              aqjl.bh(this.val$app, ((DiscussionInfo)localObject6).uin);
            }
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject6 = ((acdu)localObject4).a(this.ctY, this.ctX);
            if (localObject6 != null)
            {
              ((DiscussionMemberInfo)localObject6).memberName = ((String)localObject1);
              ((DiscussionMemberInfo)localObject6).inteRemark = ((String)localObject1);
              ((acdu)localObject4).a((DiscussionMemberInfo)localObject6);
              localObject4 = new ArrayList(2);
              ((ArrayList)localObject4).add(this.ctY);
              ((ArrayList)localObject4).add(1, Boolean.valueOf(true));
              ((acdt)this.val$app.getBusinessHandler(6)).notifyUI(1001, true, localObject4);
            }
          }
          if (this.a == null) {
            continue;
          }
          this.a.onComplete((String)localObject1, i);
          return;
        }
        catch (Exception localException3)
        {
          continue;
        }
        localException4 = localException4;
        localObject7 = localObject1;
        i = 0;
        localObject1 = localObject4;
        continue;
      }
      label807:
      label815:
      Object localObject7 = "";
      int i = 0;
      Object localObject3 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVHrMeeting.1
 * JD-Core Version:    0.7.0.1
 */