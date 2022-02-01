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
    Object localObject;
    if (getType() == 8)
    {
      localObject = this.thumbData;
      if ((localObject == null) || (localObject.length == 0)) {
        localObject = "checkArgs fail, thumbData should not be null when send emoji";
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", (String)localObject);
      return false;
      localObject = this.thumbData;
      if ((localObject != null) && (localObject.length > 32768))
      {
        localObject = "checkArgs fail, thumbData is invalid";
      }
      else
      {
        localObject = this.title;
        if ((localObject != null) && (((String)localObject).length() > 512))
        {
          localObject = "checkArgs fail, title is invalid";
        }
        else
        {
          localObject = this.description;
          if ((localObject != null) && (((String)localObject).length() > 1024))
          {
            localObject = "checkArgs fail, description is invalid";
          }
          else
          {
            localObject = this.mediaObject;
            if (localObject != null) {
              break;
            }
            localObject = "checkArgs fail, mediaObject is null";
          }
        }
      }
    }
    return ((IMediaObject)localObject).checkArgs();
  }
  
  public final int getType()
  {
    IMediaObject localIMediaObject = this.mediaObject;
    if (localIMediaObject == null) {
      return 0;
    }
    return localIMediaObject.type();
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
      if (str != null)
      {
        if (str.length() <= 0) {
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
          paramBundle = new StringBuilder("get media object from bundle failed: unknown ident ");
          paramBundle.append(str);
          Log.e("MicroMsg.SDK.WXMediaMessage", paramBundle.toString());
        }
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