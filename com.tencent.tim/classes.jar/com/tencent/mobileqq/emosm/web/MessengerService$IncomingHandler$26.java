package com.tencent.mobileqq.emosm.web;

import abxk;
import abzy;
import acad;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class MessengerService$IncomingHandler$26
  implements Runnable
{
  MessengerService$IncomingHandler$26(MessengerService.a parama, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject2;
    ApolloFavActionData localApolloFavActionData;
    if (this.val$qqApp != null)
    {
      localObject2 = (abxk)this.val$qqApp.getManager(155);
      localApolloFavActionData = ((abxk)localObject2).a(this.kQ);
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("seq", this.kQ);
          if (localApolloFavActionData != null) {
            continue;
          }
          localJSONObject.put("ret", 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "del fav but local has not the action");
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e("Q.emoji.web.MessengerService", 2, "delFavAction json error + " + localJSONException.toString());
          return;
          ((abxk)localObject2).b(localApolloFavActionData);
          localJSONException.put("ret", 0);
          MqqHandler localMqqHandler = this.val$qqApp.getHandler(ChatActivity.class);
          if (localMqqHandler == null) {
            continue;
          }
          Object localObject1 = new acad(this.val$qqApp.getCurrentUin());
          ((abzy)localObject1).c = ((abxk)localObject2).a(this.val$actionId);
          ((abzy)localObject1).bkj = localApolloFavActionData.text;
          ((abzy)localObject1).cue = localApolloFavActionData.textType;
          localObject2 = localMqqHandler.obtainMessage(66);
          ((Message)localObject2).obj = localObject1;
          ((Message)localObject2).arg1 = 1;
          ((Message)localObject2).sendToTarget();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.emoji.web.MessengerService", 2, "del fav action success +" + localJSONException.toString());
          continue;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("delFavAction", localJSONObject.toString());
        this.val$reqbundle.putBundle("response", (Bundle)localObject1);
        this.val$service.cp(this.val$reqbundle);
        return;
        if (this.val$actionId == localApolloFavActionData.acitonId) {
          continue;
        }
        localJSONObject.put("ret", 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.web.MessengerService", 2, "del fav action fail +" + localJSONObject.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.26
 * JD-Core Version:    0.7.0.1
 */