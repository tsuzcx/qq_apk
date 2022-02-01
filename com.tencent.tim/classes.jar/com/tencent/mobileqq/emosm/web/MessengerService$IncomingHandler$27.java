package com.tencent.mobileqq.emosm.web;

import abxk;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MessengerService$IncomingHandler$27
  implements Runnable
{
  MessengerService$IncomingHandler$27(MessengerService.a parama, QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    int i = 0;
    Object localObject2;
    Object localObject1;
    ArrayList localArrayList;
    if (this.val$qqApp != null)
    {
      localObject2 = (abxk)this.val$qqApp.getManager(155);
      JSONObject localJSONObject = new JSONObject();
      localObject1 = new JSONArray();
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.bDw);
        if (i >= localJSONArray.length()) {
          break label180;
        }
        Object localObject3 = localJSONArray.getJSONObject(i);
        long l = ((JSONObject)localObject3).optLong("seq");
        int j = ((JSONObject)localObject3).optInt("actionId");
        localObject3 = ((abxk)localObject2).a(l);
        if ((localObject3 == null) || (j != ((ApolloFavActionData)localObject3).acitonId)) {
          ((JSONArray)localObject1).put(l);
        } else {
          localArrayList.add(localObject3);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.emoji.web.MessengerService", 2, "delFavAction json error + " + localJSONException.toString());
        }
      }
      return;
      label180:
      if (localArrayList.size() > 0)
      {
        ((abxk)localObject2).ir(localArrayList);
        localObject2 = this.val$qqApp.getHandler(ChatActivity.class);
        if (localObject2 != null)
        {
          localObject2 = ((MqqHandler)localObject2).obtainMessage(66);
          ((Message)localObject2).arg1 = 1;
          ((Message)localObject2).sendToTarget();
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.web.MessengerService", 2, "del fav action success +" + localJSONException.toString());
          }
        }
      }
      if (((JSONArray)localObject1).length() > 0) {
        localJSONException.put("delHasError", true);
      }
      for (;;)
      {
        localJSONException.put("errorList", ((JSONArray)localObject1).toString());
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("delFavListAction", localJSONException.toString());
        this.val$reqbundle.putBundle("response", (Bundle)localObject1);
        this.val$service.cp(this.val$reqbundle);
        return;
        localJSONException.put("delHasError", false);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.27
 * JD-Core Version:    0.7.0.1
 */