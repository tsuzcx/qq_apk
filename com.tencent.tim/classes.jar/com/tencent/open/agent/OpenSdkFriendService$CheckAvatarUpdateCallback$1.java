package com.tencent.open.agent;

import arsc;
import arsc.a;
import artp;
import artr;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkFriendService$CheckAvatarUpdateCallback$1
  implements Runnable
{
  public OpenSdkFriendService$CheckAvatarUpdateCallback$1(arsc.a parama, int paramInt, JSONArray paramJSONArray) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.val$num) {
        try
        {
          String str = this.T.getJSONObject(i).getString("openid");
          str = artr.cg(this.a.this$0.mAppid, str);
          artp.a().Xb(str);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback.1
 * JD-Core Version:    0.7.0.1
 */