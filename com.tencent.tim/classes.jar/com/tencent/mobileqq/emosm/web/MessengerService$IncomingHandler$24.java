package com.tencent.mobileqq.emosm.web;

import abxk;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MessengerService$IncomingHandler$24
  implements Runnable
{
  MessengerService$IncomingHandler$24(MessengerService.a parama, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    int i;
    if (this.val$qqApp != null)
    {
      localObject = ((abxk)this.val$qqApp.getManager(155)).dK();
      localJSONObject1 = new JSONObject();
      localJSONArray = new JSONArray();
      if (localObject != null) {
        i = 0;
      }
    }
    try
    {
      while (i < ((List)localObject).size())
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("seq", ((ApolloFavActionData)((List)localObject).get(i)).favId);
        localJSONObject2.put("actionId", ((ApolloFavActionData)((List)localObject).get(i)).acitonId);
        localJSONObject2.put("actionText", ((ApolloFavActionData)((List)localObject).get(i)).text);
        localJSONObject2.put("textType", ((ApolloFavActionData)((List)localObject).get(i)).textType);
        localJSONObject2.put("audioId", ((ApolloFavActionData)((List)localObject).get(i)).audioId);
        if (!Float.isNaN(((ApolloFavActionData)((List)localObject).get(i)).audioStartTime)) {
          localJSONObject2.put("audioStartTime", ((ApolloFavActionData)((List)localObject).get(i)).audioStartTime);
        }
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("favActionSet", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.emoji.web.MessengerService", 2, "getLocalFavAction json error " + localJSONException.toString());
        }
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("getFavResult", localJSONObject1.toString());
    this.val$reqbundle.putBundle("response", (Bundle)localObject);
    this.val$service.cp(this.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.24
 * JD-Core Version:    0.7.0.1
 */