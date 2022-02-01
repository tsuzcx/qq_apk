package com.tencent.mobileqq.emosm.web;

import abhh;
import abxk;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameRoamData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class MessengerService$IncomingHandler$33
  implements Runnable
{
  MessengerService$IncomingHandler$33(MessengerService.a parama, String paramString, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      Object localObject2 = new JSONObject(this.bDz);
      ((JSONObject)localObject2).optLong("timestamp");
      Object localObject1 = new ArrayList();
      localObject2 = ((JSONObject)localObject2).optJSONArray("gameList");
      while (i < ((JSONArray)localObject2).length())
      {
        ApolloGameRoamData localApolloGameRoamData = new ApolloGameRoamData();
        JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
        localApolloGameRoamData.gameId = localJSONObject.optInt("gameId");
        localApolloGameRoamData.type = localJSONObject.optInt("tab");
        ((ArrayList)localObject1).add(localApolloGameRoamData);
        i += 1;
      }
      if (this.val$qqApp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessengerService$IncomingHandler", 2, "IPC_APOLLO_UPDATE_GAME_LIST, update game list");
        }
        localObject2 = (abxk)this.val$qqApp.getManager(155);
        ((abxk)localObject2).cGb();
        ((abxk)localObject2).dw((ArrayList)localObject1);
        ((abhh)this.val$qqApp.getManager(153)).cBL();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("result", 0);
        this.val$reqbundle.putBundle("response", (Bundle)localObject1);
        this.val$service.cp(this.val$reqbundle);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessengerService$IncomingHandler", 1, "IPC_APOLLO_UPDATE_GAME_LIST, exception=", localException);
      Bundle localBundle = new Bundle();
      localBundle.putInt("result", 1);
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.cp(this.val$reqbundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.33
 * JD-Core Version:    0.7.0.1
 */