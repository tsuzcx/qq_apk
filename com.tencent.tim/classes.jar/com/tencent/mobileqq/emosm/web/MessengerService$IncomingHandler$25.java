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

class MessengerService$IncomingHandler$25
  implements Runnable
{
  MessengerService$IncomingHandler$25(MessengerService.a parama, QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    long l;
    if (this.val$qqApp != null)
    {
      localObject1 = (abxk)this.val$qqApp.getManager(155);
      localObject2 = new ApolloFavActionData();
      ((ApolloFavActionData)localObject2).acitonId = this.val$actionId;
      ((ApolloFavActionData)localObject2).text = this.bDv;
      ((ApolloFavActionData)localObject2).textType = this.cRl;
      ((ApolloFavActionData)localObject2).audioId = this.val$audioId;
      ((ApolloFavActionData)localObject2).playOriginalAudio = this.cRm;
      ((ApolloFavActionData)localObject2).audioStartTime = this.vZ;
      l = System.currentTimeMillis();
      ((ApolloFavActionData)localObject2).favId = l;
      ((abxk)localObject1).a((ApolloFavActionData)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.MessengerService", 2, "add fav action success +" + ((ApolloFavActionData)localObject2).toString());
      }
      MqqHandler localMqqHandler = this.val$qqApp.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        localObject2 = new acad(this.val$qqApp.getCurrentUin());
        ((abzy)localObject2).c = ((abxk)localObject1).a(this.val$actionId);
        ((abzy)localObject2).bkj = this.bDv;
        ((abzy)localObject2).cue = this.cRl;
        ((abzy)localObject2).cre = this.val$audioId;
        ((abzy)localObject2).sC = this.vZ;
        ((abzy)localObject2).cuf = this.cRm;
        localObject1 = localMqqHandler.obtainMessage(66);
        ((Message)localObject1).obj = localObject2;
        ((Message)localObject1).sendToTarget();
      }
      localObject1 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject1).put("seq", l);
      ((JSONObject)localObject1).put("success", true);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("addFavAction", ((JSONObject)localObject1).toString());
      this.val$reqbundle.putBundle("response", (Bundle)localObject2);
      this.val$service.cp(this.val$reqbundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.emoji.web.MessengerService", 2, "addFavAction ipc json error + " + localJSONException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.25
 * JD-Core Version:    0.7.0.1
 */