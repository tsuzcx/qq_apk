package com.tencent.wework.api.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;

public class WWMediaImage
  extends WWMediaFile
{
  private static final String TAG = "WWAPI.WWMediaImage";
  
  public WWMediaImage() {}
  
  public WWMediaImage(Bitmap paramBitmap)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.fileData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public WWMediaImage(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }
  
  public int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaImage
 * JD-Core Version:    0.7.0.1
 */