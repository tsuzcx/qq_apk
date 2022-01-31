package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class WXMediaMessage$Builder
{
  public static final String KEY_IDENTIFIER = "_wxobject_identifier_";
  
  public static WXMediaMessage fromBundle(Bundle paramBundle)
  {
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.sdkVer = paramBundle.getInt("_wxobject_sdkVer");
    localWXMediaMessage.title = paramBundle.getString("_wxobject_title");
    localWXMediaMessage.description = paramBundle.getString("_wxobject_description");
    localWXMediaMessage.thumbData = paramBundle.getByteArray("_wxobject_thumbdata");
    String str = paramBundle.getString("_wxobject_identifier_");
    if ((str == null) || (str.length() <= 0)) {
      return localWXMediaMessage;
    }
    try
    {
      localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)Class.forName(str).newInstance());
      localWXMediaMessage.mediaObject.unserialize(paramBundle);
      return localWXMediaMessage;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      Log.e("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + str);
    }
    return localWXMediaMessage;
  }
  
  public static Bundle toBundle(WXMediaMessage paramWXMediaMessage)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_wxobject_sdkVer", paramWXMediaMessage.sdkVer);
    localBundle.putString("_wxobject_title", paramWXMediaMessage.title);
    localBundle.putString("_wxobject_description", paramWXMediaMessage.description);
    localBundle.putByteArray("_wxobject_thumbdata", paramWXMediaMessage.thumbData);
    if (paramWXMediaMessage.mediaObject != null)
    {
      localBundle.putString("_wxobject_identifier_", paramWXMediaMessage.mediaObject.getClass().getName());
      paramWXMediaMessage.mediaObject.serialize(localBundle);
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXMediaMessage.Builder
 * JD-Core Version:    0.7.0.1
 */