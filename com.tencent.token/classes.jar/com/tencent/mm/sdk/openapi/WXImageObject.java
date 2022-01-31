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
    if (((this.imageData == null) || (this.imageData.length == 0)) && ((this.imagePath == null) || (this.imagePath.length() == 0)) && ((this.imageUrl == null) || (this.imageUrl.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXImageObject", "checkArgs fail, all arguments are null");
      return false;
    }
    if ((this.imageData != null) && (this.imageData.length > 10485760))
    {
      Log.e("MicroMsg.SDK.WXImageObject", "checkArgs fail, content is too large");
      return false;
    }
    if ((this.imagePath != null) && (this.imagePath.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXImageObject", "checkArgs fail, path is invalid");
      return false;
    }
    if (this.imagePath != null)
    {
      Object localObject = this.imagePath;
      int i;
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        i = 0;
      }
      while (i > 10485760)
      {
        Log.e("MicroMsg.SDK.WXImageObject", "checkArgs fail, image content is too large");
        return false;
        localObject = new File((String)localObject);
        if (!((File)localObject).exists()) {
          i = 0;
        } else {
          i = (int)((File)localObject).length();
        }
      }
    }
    if ((this.imageUrl != null) && (this.imageUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXImageObject", "checkArgs fail, url is invalid");
      return false;
    }
    return true;
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