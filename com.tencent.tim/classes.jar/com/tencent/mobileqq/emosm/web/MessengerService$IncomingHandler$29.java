package com.tencent.mobileqq.emosm.web;

import abhe;
import afjj;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessengerService$IncomingHandler$29
  implements Runnable
{
  MessengerService$IncomingHandler$29(MessengerService.a parama, String paramString, Bundle paramBundle, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.bDy).getJSONArray("gameList");
      ArrayList localArrayList = new ArrayList();
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(Integer.valueOf(((JSONArray)localObject).getInt(i)));
          i += 1;
        }
        localObject = new afjj(this);
        abhe localabhe = (abhe)this.val$qqApp.getManager(211);
        localabhe.fc = new WeakReference(localObject);
        localabhe.a("android.web", "apollo_aio_game.add_games_to_user_gamepanel", localArrayList);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.29
 * JD-Core Version:    0.7.0.1
 */