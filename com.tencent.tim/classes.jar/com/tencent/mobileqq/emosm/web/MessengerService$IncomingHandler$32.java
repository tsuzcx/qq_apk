package com.tencent.mobileqq.emosm.web;

import abhe;
import afjl;
import android.os.Bundle;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessengerService$IncomingHandler$32
  implements Runnable
{
  MessengerService$IncomingHandler$32(MessengerService.a parama, String paramString, Bundle paramBundle, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new JSONObject(this.bDy).getJSONArray("gameList");
      Object localObject1 = new ArrayList();
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          ((ArrayList)localObject1).add(Integer.valueOf(((JSONArray)localObject2).getInt(i)));
          i += 1;
        }
        localObject2 = new afjl(this);
        abhe localabhe = (abhe)this.val$qqApp.getManager(211);
        localabhe.fc = new WeakReference(localObject2);
        localabhe.a("android.web", "apollo_aio_game.del_games_from_user_gamepanel", (ArrayList)localObject1);
        localObject1 = this.val$qqApp.getHandler(Conversation.class);
        ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(1134054));
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.32
 * JD-Core Version:    0.7.0.1
 */