package com.tencent.mm.sdk.openapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WXImageObject
  implements WXMediaMessage.IMediaObject
{
  public byte[] imageData;
  public String imagePath;
  public String imageUrl;
  
  public WXImageObject() {}
  
  public WXImageObject(Bitmap paramBitmap)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.imageData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public WXImageObject(byte[] paramArrayOfByte)
  {
    this.imageData = paramArrayOfByte;
  }
  
  public boolean checkArgs()
  {
    Object localObject = this.imageData;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.imagePath;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        localObject = this.imageUrl;
        if ((localObject == null) || (((String)localObject).length() == 0)) {
          break label193;
        }
      }
    }
    localObject = this.imageData;
    if ((localObject != null) && (localObject.length > 10485760)) {
      localObject = "checkArgs fail, content is too large";
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXImageObject", (String)localObject);
      return false;
      localObject = this.imagePath;
      if ((localObject != null) && (((String)localObject).length() > 10240))
      {
        localObject = "checkArgs fail, path is invalid";
      }
      else
      {
        localObject = this.imagePath;
        if (localObject != null)
        {
          if ((localObject != null) && (((String)localObject).length() != 0))
          {
            localObject = new File((String)localObject);
            if (((File)localObject).exists())
            {
              i = (int)((File)localObject).length();
              break label154;
            }
          }
          int i = 0;
          label154:
          if (i > 10485760)
          {
            localObject = "checkArgs fail, image content is too large";
            continue;
          }
        }
        localObject = this.imageUrl;
        if ((localObject != null) && (((String)localObject).length() > 10240))
        {
          localObject = "checkArgs fail, url is invalid";
        }
        else
        {
          return true;
          label193:
          localObject = "checkArgs fail, all arguments are null";
        }
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wximageobject_imageData", this.imageData);
    paramBundle.putString("_wximageobject_imagePath", this.imagePath);
    paramBundle.putString("_wximageobject_imageUrl", this.imageUrl);
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public int type()
  {
    return 2;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.imageData = paramBundle.getByteArray("_wximageobject_imageData");
    this.imagePath = paramBundle.getString("_wximageobject_imagePath");
    this.imageUrl = paramBundle.getString("_wximageobject_imageUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXImageObject
 * JD-Core Version:    0.7.0.1
 */