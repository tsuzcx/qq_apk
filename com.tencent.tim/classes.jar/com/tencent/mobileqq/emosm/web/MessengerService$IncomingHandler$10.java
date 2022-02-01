package com.tencent.mobileqq.emosm.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import aqlr;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Map;

class MessengerService$IncomingHandler$10
  implements Runnable
{
  MessengerService$IncomingHandler$10(MessengerService.a parama, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, String paramString4, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Bitmap localBitmap = aqlr.a(this.val$iconUrl, this.bDr, null, this.val$qqApp, false);
    Bundle localBundle = new Bundle();
    if (localBitmap != null)
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("starHomeUrl", this.bDs);
      ((Map)localObject).put("nickname", this.val$nickname);
      ((Map)localObject).put("starId", this.bDr);
      localObject = aqlr.a(this.val$qqApp, "sid", (Map)localObject);
      aqlr.a(this.val$qqApp, (Intent)localObject, this.val$nickname, localBitmap);
      localBundle.putInt("ret", 0);
    }
    for (;;)
    {
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.cp(this.val$reqbundle);
      return;
      localBundle.putInt("ret", -4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.10
 * JD-Core Version:    0.7.0.1
 */