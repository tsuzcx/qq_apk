package com.tencent.mm.sdk.openapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.token.pw;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage
{
  public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
  public String description;
  public a mediaObject;
  public int sdkVer;
  public byte[] thumbData;
  public String title;
  
  public WXMediaMessage()
  {
    this(null);
  }
  
  public WXMediaMessage(a parama)
  {
    this.mediaObject = parama;
  }
  
  public final boolean checkArgs()
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
      pw.a("MicroMsg.SDK.WXMediaMessage", (String)localObject);
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
    return ((a)localObject).checkArgs();
  }
  
  public final int getType()
  {
    a locala = this.mediaObject;
    if (locala == null) {
      return 0;
    }
    return locala.type();
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
      pw.a("MicroMsg.SDK.WXMediaMessage", "put thumb failed");
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean checkArgs();
    
    public abstract void serialize(Bundle paramBundle);
    
    public abstract int type();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXMediaMessage
 * JD-Core Version:    0.7.0.1
 */