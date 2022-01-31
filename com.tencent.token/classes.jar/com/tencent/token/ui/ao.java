package com.tencent.token.ui;

import android.os.Message;
import org.json.JSONException;
import org.json.JSONObject;

final class ao
  extends bo
{
  ao(AssistantRecommendFriendQrcode paramAssistantRecommendFriendQrcode)
  {
    super(paramAssistantRecommendFriendQrcode);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      this.a.dismissDialog();
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      if (paramMessage.arg1 == 0) {
        try
        {
          Object localObject = new JSONObject((String)paramMessage.obj);
          paramMessage = ((JSONObject)localObject).getString("wexin_share_more");
          localObject = ((JSONObject)localObject).getString("wexin_share_glock");
          if ((paramMessage != null) && (localObject != null) && (paramMessage.length() > 0) && (((String)localObject).length() > 0)) {
            if (AssistantRecommendFriendQrcode.access$000(this.a) == 9)
            {
              AssistantRecommendFriendQrcode.access$102(this.a, (String)localObject);
              return;
            }
          }
        }
        catch (JSONException paramMessage)
        {
          paramMessage.printStackTrace();
          return;
          AssistantRecommendFriendQrcode.access$102(this.a, paramMessage);
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ao
 * JD-Core Version:    0.7.0.1
 */