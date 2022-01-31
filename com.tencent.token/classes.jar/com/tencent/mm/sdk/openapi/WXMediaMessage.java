package com.tencent.mm.sdk.openapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage
{
  public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
  public String description;
  public WXMediaMessage.IMediaObject mediaObject;
  public int sdkVer;
  public byte[] thumbData;
  public String title;
  
  public WXMediaMessage()
  {
    this(null);
  }
  
  public WXMediaMessage(WXMediaMessage.IMediaObject paramIMediaObject)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXMediaMessage
 * JD-Core Version:    0.7.0.1
 */