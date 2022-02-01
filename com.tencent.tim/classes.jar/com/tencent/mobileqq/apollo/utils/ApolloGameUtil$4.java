package com.tencent.mobileqq.apollo.utils;

import abrd;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ApolloGameUtil$4
  implements Runnable
{
  ApolloGameUtil$4(String paramString, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.aWQ);
      long l = ((JSONObject)localObject).optLong("taskId");
      localObject = abrd.a(this.val$app, (JSONObject)localObject);
      if (localObject == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", 0);
      localJSONObject.put("actionInfo", localObject);
      localJSONObject.put("taskId", l);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "ReqAction,", localJSONObject.toString() });
      }
      ApolloCmdChannel.getChannel(this.val$app).callbackFromRequest(this.Od, 0, "sc.script_notify_action_ready.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.4
 * JD-Core Version:    0.7.0.1
 */