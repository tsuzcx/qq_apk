package com.tencent.token;

import android.os.Bundle;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXMediaMessage.a;

public final class qh
{
  public static final class a
    extends qf
  {
    public WXMediaMessage b;
    public int c;
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      WXMediaMessage localWXMediaMessage = this.b;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_wxobject_sdkVer", localWXMediaMessage.sdkVer);
      localBundle.putString("_wxobject_title", localWXMediaMessage.title);
      localBundle.putString("_wxobject_description", localWXMediaMessage.description);
      localBundle.putByteArray("_wxobject_thumbdata", localWXMediaMessage.thumbData);
      if (localWXMediaMessage.mediaObject != null)
      {
        localBundle.putString("_wxobject_identifier_", localWXMediaMessage.mediaObject.getClass().getName());
        localWXMediaMessage.mediaObject.serialize(localBundle);
      }
      paramBundle.putAll(localBundle);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.c);
    }
    
    final boolean a()
    {
      WXMediaMessage localWXMediaMessage = this.b;
      if (localWXMediaMessage == null)
      {
        qk.a("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
        return false;
      }
      return localWXMediaMessage.checkArgs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qh
 * JD-Core Version:    0.7.0.1
 */