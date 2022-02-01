package com.tencent.mobileqq.nearby;

import ajrl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import jnl;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONObject;

public final class NearbyUtils$1
  implements Runnable
{
  public NearbyUtils$1(String paramString, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("targetuin", Long.parseLong(this.aGq));
      ((JSONObject)localObject).put("type", this.val$type);
      NewIntent localNewIntent = new NewIntent(this.val$app.getApplication().getApplicationContext(), jnl.class);
      localNewIntent.putExtra("cmd", "NearbySvr.get_chat_signature");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localObject = ((JSONObject)localObject).toString();
      localWebSsoRequestBody.data.set((String)localObject);
      localNewIntent.putExtra("data", localWebSsoRequestBody.toByteArray());
      localNewIntent.setObserver(new ajrl(this));
      this.val$app.startServlet(localNewIntent);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUtils.1
 * JD-Core Version:    0.7.0.1
 */