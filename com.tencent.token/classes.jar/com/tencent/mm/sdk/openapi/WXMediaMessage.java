package com.tencent.mm.sdk.openapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage
{
  public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
  public String description;
  public IMediaObject mediaObject;
  public int sdkVer;
  public byte[] thumbData;
  public String title;
  
  public WXMediaMessage()
  {
    this(null);
  }
  
  public WXMediaMessage(IMediaObject paramIMediaObject)
  {
    this.mediaObject = paramIMediaObject;
  }
  
  final boolean checkArgs()
  {
    if ((getType() == 8) && ((this.thumbData == null) || (this.thumbData.length == 0)))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData should not be null when send emoji");
      return false;
    }
    if ((this.thumbData != null) && (this.thumbData.length > 32768))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData is invalid");
      return false;
    }
    if ((this.title != null) && (this.title.length() > 512))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, title is invalid");
      return false;
    }
    if ((this.description != null) && (this.description.length() > 1024))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, description is invalid");
      return false;
    }
    if (this.mediaObject == null)
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaObject is null");
      return false;
    }
    return this.mediaObject.checkArgs();
  }
  
  public final int getType()
  {
    if (this.mediaObject == null) {
      return 0;
    }
    return this.mediaObject.type();
  }
  
  public final void setThumbImage(Bitmap paramBitmap)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.thumbData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
      Log.e("MicroMsg.SDK.WXMediaMessage", "put thumb failed");
    }
  }
  
  public static class Builder
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
  
  public static abstract interface IMediaObject
  {
    public static final int TYPE_APPDATA = 7;
    public static final int TYPE_EMOJI = 8;
    public static final int TYPE_FILE = 6;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_MUSIC = 3;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_URL = 5;
    public static final int TYPE_VIDEO = 4;
    
    public abstract boolean checkArgs();
    
    public abstract void serialize(Bundle paramBundle);
    
    public abstract int type();
    
    public abstract void unserialize(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXMediaMessage
 * JD-Core Version:    0.7.0.1
 */