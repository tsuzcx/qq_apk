package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WXImageObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXImageObject";
  private static final int URL_LENGTH_LIMIT = 10240;
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
  
  private int getFileSize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return 0;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return (int)paramString.length();
  }
  
  public boolean checkArgs()
  {
    if (((this.imageData == null) || (this.imageData.length == 0)) && ((this.imagePath == null) || (this.imagePath.length() == 0)) && ((this.imageUrl == null) || (this.imageUrl.length() == 0)))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, all arguments are null");
      return false;
    }
    if ((this.imageData != null) && (this.imageData.length > 10485760))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, content is too large");
      return false;
    }
    if ((this.imagePath != null) && (this.imagePath.length() > 10240))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, path is invalid");
      return false;
    }
    if ((this.imagePath != null) && (getFileSize(this.imagePath) > 10485760))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, image content is too large");
      return false;
    }
    if ((this.imageUrl != null) && (this.imageUrl.length() > 10240))
    {
      a.a("MicroMsg.SDK.WXImageObject", "checkArgs fail, url is invalid");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.WXImageObject
 * JD-Core Version:    0.7.0.1
 */